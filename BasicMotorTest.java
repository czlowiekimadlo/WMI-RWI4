
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 * Program for basic forward motor testing
 * @author CzlowiekImadlo
 */
public class BasicMotorTest
{
    TachoPilot pilot;
	
	
	public static void main(String[] args)
    {
		BasicMotorTest robot = new BasicMotorTest();
		robot.pilot = new TachoPilot(3.8f, 12f, Motor.B, Motor.C);
		
		Motor.B.smoothAcceleration(true);
		Motor.B.regulateSpeed(false);
		Motor.C.smoothAcceleration(true);
		Motor.C.regulateSpeed(false);
		
		robot.pilot.setSpeed(900);
		robot.run();
    }
	
	public void run ()
	{
		
		//pilot.arc(35.5f);
		//pilot.forward();
		//Button.waitForPress();
		//pilot.stop();
		
		
		pilot.travel(60);
		
		//Motor.A.rotate(-180);
		/*
		Motor.A.rotate(-130, true);
		pilot.travel(100);
		Motor.A.rotate(-60);
		Motor.A.rotate(60);
		*/
	}
}


