
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;

/**
 *Motor runs forward then backward as button is pressed.
 * @author Roger
 */
public class BasicRotateTest
{
    TachoPilot pilot;
	
	
	public static void main(String[] args)
    {
		BasicRotateTest robot = new BasicRotateTest();
		robot.pilot = new TachoPilot(1.7f, 12f, Motor.B, Motor.C);
		robot.pilot.setSpeed(50);
		robot.run();
    }
	
	public void run ()
	{
		pilot.rotate(360);
	}

}


