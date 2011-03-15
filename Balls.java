
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 * 
 * @author Quak
 */
public class Balls
{
	TachoPilot pilot;

    public static void main(String[] args)
    {   
		Balls robot = new Balls();
		robot.pilot = new TachoPilot(1.75f, 12f, Motor.B, Motor.C);
		robot.run();
    }
	
	public void run()
	{
		pilot.travel(20);
		
		kick();
		
	}
	
	public void kick ()
	{
		Motor.A.rotate(-90);
		Motor.A.rotate(90);
	}
}


