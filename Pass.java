
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 * @author CzlowiekImadlo
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
		robot.run();
    }
	
	public void run () throws Exception
	{
		int delay = 0;
		int action = 0;
		int button = 0;
		
		// ask for delay
		while (button != 1)
		{
			LCD.clear();
			
			if (button == 4) delay++;
			if (button == 2) delay--;
			
			if (delay < 0) delay = 0;
			
			LCD.drawString("Delay", 1, 1);
			LCD.drawInt(delay, 1, 2);
			
			button = Button.waitForPress();
		}

		
		// ask for action
		// yes, we have 6 different paths :P
		button = 0;
		while (button != 1)
		{
			LCD.clear();
			
			if (button == 4) action++;
			if (button == 2) action--;
			
			if (action < 0) action = 0;
			if (action > 5) action = 5;
			
			LCD.drawString("Action", 1, 1);
			LCD.drawString(mapAction(action), 1, 2);
			
			
			button = Button.waitForPress();
		}
		
		
		//delay action
		Thread.sleep(delay * 1000);

		
		if (action == 0) steerTight(false);
		else if (action == 1) steerWide(false);
		else if (action == 2) steerTightLeft(false);
		else if (action == 3) steerWide(true);
		else if (action == 4) edge(false);
		else if (action == 5) edge(true);
		
	}
	
	
	public String mapAction(int action)
	{
		if (action == 0) return "right tight";
		if (action == 1) return "right wide";
		if (action == 2) return "left tight";
		if (action == 3) return "left wide";
		if (action == 4) return "right edge";
		if (action == 5) return "left edge";
		
		return "undefined";
	}
	
	
	// this thing will crash NXC brick 1 out of 4 times
	// dunno why
	public void steerTight(boolean reverse) throws Exception
	{
		int rotate = 70;
		int steer = -46;
		
		if (reverse)
		{
			rotate = -rotate;
			steer = -steer;
		}
		
		pilot.rotate(rotate);
		pilot.steer(steer);
		Thread.sleep(2300);
		pilot.stop();
	}
	
	// this thing exists only because robot steers differently
	// to the left than to the right oO'
	public void steerTightLeft(boolean reverse) throws Exception
	{
		int rotate = -70;
		int steer = 42;
		
		if (reverse)
		{
			rotate = -rotate;
			steer = -steer;
		}
		
		pilot.rotate(rotate);
		pilot.steer(steer);
		Thread.sleep(2300);
		pilot.stop();
	}
	
	// turns out to be optimal path, combining good travel time
	// with low chance for crashing into something
	public void steerWide(boolean reverse) throws Exception
	{
		
		int rotate = 110;
		int arcrad = -30;
		int arctrav = -105;
		
		if (reverse)
		{
			rotate = -rotate;
			arcrad = -arcrad;
			arctrav = -arctrav;
		}
		
		pilot.rotate(rotate);
		pilot.travelArc(arcrad, arctrav);
		pilot.travel(65);
	}
	
	
	// this should bypass all obstacles inside field
	// may cause robot to leave field and lose
	public void edge(boolean reverse) throws Exception
	{
		int rotate = 180;
		int arc1 = -25;
		int trav1 = -50;
		int arc2 = -40;
		int trav2 = -70;
		int arc3 = -35;
		int trav3 = -60;
		
		if (reverse)
		{
			rotate = -rotate;
			arc1 = -arc1;
			trav1 = -trav1;
			arc2 = -arc2;
			trav2 = -trav2;
			arc3 = -arc3;
			trav3 = -trav3;
			
		}
		
		pilot.rotate(rotate);
		pilot.travelArc(arc1, trav1);
		pilot.travelArc(arc2, trav2);
		pilot.travelArc(arc3, trav3);
		pilot.travel(10);
	}
	
}




