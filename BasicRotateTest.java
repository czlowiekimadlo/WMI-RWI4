
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;

/**
 * Program for basic turning test.
 * @author CzlowiekImadlo
 */
public class BasicRotateTest
{
    TachoPilot pilot;
	
	
	public static void main(String[] args)
    {
		BasicRotateTest robot = new BasicRotateTest();
		robot.pilot = new TachoPilot(1.7f, 12f, Motor.B, Motor.C);
		robot.pilot.setSpeed(100);
		robot.run();
    }
	
	public void run ()
	{
		pilot.rotate(360);
	}

}


