
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 *
 * @author CzlowiekImadlo
 */
public class Bumper
{
    TachoPilot pilot;
	int armRealign = 120;
	int armKick = 50;
	
	public static void main(String[] args) throws Exception
    {
		Bumper robot = new Bumper();
		robot.pilot = new TachoPilot(6.8f, 22f, Motor.B, Motor.C);
		robot.pilot.setSpeed(1000);
		robot.run();
		
		Motor.A.regulateSpeed(false);
		Motor.A.setPower(100);
    }
	
	public void run () throws Exception
	{
		Motor.A.rotate(-armRealign, true);
		
		pilot.travel(100);
		pilot.rotate(90);
		pilot.travel(62);
		pilot.rotate(90);
		pilot.travel(105);
		
		pilot.setSpeed(50);
		
		int i = 0;
		do
		{
			Motor.A.rotate(-armKick, true);
			Thread.sleep(500);
			Motor.A.stop();
			Motor.A.rotate(armKick, true);
			Thread.sleep(800);
			pilot.travel(1, true);
			Thread.sleep(6000);
			i++;
		} while (i < 6);
		
		Motor.A.rotate(armRealign);
	}
}