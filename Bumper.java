
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;
import lejos.robotics.navigation.Pilot;


/**
 *
 * @author CzlowiekImadlo
 */
public class Bumper
{
    TachoPilot pilot;
	TouchSensor touch; 

	int armRealign = 100;
	int armKick = 70;
	
	public static void main(String[] args) throws Exception
    {
		Bumper robot = new Bumper();
		robot.pilot = new TachoPilot(12.8f, 15.5f, Motor.B, Motor.C);
		robot.pilot.setSpeed(1000);
		robot.touch = new TouchSensor(SensorPort.S1);
		
		Motor.B.smoothAcceleration(true);
		Motor.B.regulateSpeed(false);
		Motor.C.smoothAcceleration(true);
		Motor.C.regulateSpeed(false);
		
		
		robot.run();
		
		
    }
	
	public void run () throws Exception
	{
		
		Motor.A.rotate(armRealign, true);
		
		pilot.travelArc(45f,110f);
		pilot.travel(43);
		pilot.rotate(110);
		pilot.forward();
		Thread.sleep(4000);
		pilot.stop();
		
		
		Motor.B.lock(1000);
		Motor.C.lock(1000);
		attack();

		Motor.A.rotate(-armRealign, true);
		Thread.sleep(500);
		Motor.A.stop();
	}
	
	public void attack() throws Exception
	{
		Motor.A.rotate(2 * armKick, true);
		while (!touch.isPressed());
		Motor.A.rotate(-armKick);
		Motor.A.lock(1000);
		
		int i = 0;
		do
		{
			Thread.sleep(6500);
			
			Motor.A.rotate(2 * armKick, true);
			while (!touch.isPressed());
			Motor.A.rotate(-armKick);
			Motor.A.lock(1000);
			
			i++;
		} while (i < 6);
	}
}