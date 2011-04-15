
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
		robot.pilot = new TachoPilot(12.8f, 15.5f, Motor.B, Motor.C);
		robot.pilot.setSpeed(800);
		
		Motor.B.smoothAcceleration(true);
		Motor.B.regulateSpeed(false);
		Motor.C.smoothAcceleration(true);
		Motor.C.regulateSpeed(false);
		
		robot.run();
		
    }
	
	public void run() throws Exception
	{
		
		int but = Button.waitForPress();
		if (but == 2) run1();
		else if (but == 4) run1();
		
	}
	
	public void run1 () throws Exception
	{
		int arc = 17;
		int art = 40;
		int rot1 = 150;
		int rot2 = 100;
		int rot3 = -100;
		
		
		//pilot.travelArc(arc, art);
		pilot.rotate(40);
		pilot.travel(40);
		pilot.rotate(90);
		pilot.travel(40);
		pilot.rotate(rot1);
		pilot.travel(20);
		pilot.rotate(rot2);
		pilot.travel(50);
		pilot.rotate(rot3);
		pilot.travel(5);
		
	}
	
	public void run2 () throws Exception
	{
		
		
		pilot.rotate(-45);
		pilot.travel(35);
		pilot.rotate(-85);	
		pilot.travel(50);
		pilot.rotate(-170);
		pilot.travel(20);
		pilot.rotate(-90);
		pilot.travel(50);
		pilot.rotate(110);
		pilot.travel(10);
		
	}

}