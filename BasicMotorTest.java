
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 *Motor runs forward then backward as button is pressed.
 * @author Roger
 */
public class BasicMotorTest
{
    TachoPilot pilot;
	
	
	public static void main(String[] args)
    {
		BasicMotorTest robot = new BasicMotorTest();
		robot.pilot = new TachoPilot(1.7f, 12f, Motor.B, Motor.C);
		robot.pilot.setSpeed(1000);
		robot.run();
    }
	
	public void run ()
	{
		pilot.forward();
		Button.waitForPress();
		pilot.stop();
	}
}


