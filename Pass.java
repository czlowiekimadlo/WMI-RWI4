
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 *Motor runs forward then backward as button is pressed.
 * @author Roger
 */
public class Pass
{
    TachoPilot pilot;
	
	
	public static void main(String[] args) throws Exception
    {
		Pass robot = new Pass();
		robot.pilot = new TachoPilot(12.8f, 15.5f, Motor.B, Motor.C);
		
		Motor.B.smoothAcceleration(true);
		Motor.B.regulateSpeed(false);
		Motor.C.smoothAcceleration(true);
		Motor.C.regulateSpeed(false);
		
		robot.pilot.setSpeed(800);
		//robot.pilot.setRotateSpeed(1000);
		robot.run();
    }
	
	public void run () throws Exception
	{
		pilot.rotate(70);
		pilot.steer(-47);
		Thread.sleep(2500);
		pilot.stop();
		
		/*
		pilot.travel(90, true);
		while (pilot.isMoving()) ;
		pilot.stop();
		pilot.travel(-10);
		*/
		
	}
}


