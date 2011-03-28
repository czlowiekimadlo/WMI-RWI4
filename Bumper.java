
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 *Motor runs forward then backward as button is pressed.
 * @author Roger
 */
public class Bumper
{
    TachoPilot pilot;
	int armRealign = 160;
	int armKick = 50;
	
	public static void main(String[] args) throws Exception
    {
		Bumper robot = new Bumper();
		robot.pilot = new TachoPilot(1.7f, 19f, Motor.B, Motor.C);
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
		pilot.travel(95);
		
		pilot.setSpeed(100);
		
		int i = 0;
		do
		{
			Motor.A.rotate(-armKick, true);
			Thread.sleep(300);
			Motor.A.rotate(armKick, true);
			Thread.sleep(800);
			pilot.travel(3);
			i++;
		} while (i < 10);
		
		Motor.A.rotate(armRealign);
	}
}