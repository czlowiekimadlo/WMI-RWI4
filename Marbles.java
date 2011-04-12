
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 *
 * @author CzlowiekImadlo
 */
public class Marbles
{
    TachoPilot pilot;
	
	public static void main(String[] args) throws Exception
    {
		Marbles robot = new Marbles();
		robot.pilot = new TachoPilot(6.8f, 15.5f, Motor.B, Motor.C);
		robot.pilot.setSpeed(1000);
		robot.run();
		
    }
	
	public void run() throws Exception
	{
		int but = Button.waitForPress();
		if (but == 2) run1();
		else if (but == 4) run2();
	}
	
	public void run1 () throws Exception
	{
	
		pilot.rotate(60);
		pilot.travel(20);
		pilot.rotate(-75);
		pilot.travel(23);
		pilot.rotate(-93);
		pilot.travel(14);
		pilot.rotate(-75);
		pilot.travel(20);		
		pilot.rotate(30);
		pilot.travel(10);
			
		
	}
	
	
	public void run2 () throws Exception
	{
	
		pilot.rotate(-60);
		pilot.travel(20);
		pilot.rotate(75);
		pilot.travel(23);
		pilot.rotate(93);
		pilot.travel(14);
		pilot.rotate(75);
		pilot.travel(20);		
		pilot.rotate(-45);
		pilot.travel(10);
			
		
	}
}