
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 * 
 * @author Quak
 */
public class Balls
{
	TachoPilot pilot;
	UltrasonicSensor sonic;
	LightSensor light;
	
	int infinite = 100;
	int near = 10;
	int realign = 40;
	int errorRate = 10;

    public static void main(String[] args)
    {   
		Balls robot = new Balls();
		robot.sonic = new UltrasonicSensor(SensorPort.S1);
		robot.pilot = new TachoPilot(1.7f, 12f, Motor.B, Motor.C);
		robot.light = new LightSensor(SensorPort.S2);
		robot.run();
    }
	
	public void run()
	{
		//pilot.travel(20);
		
		//kick();
		find();
		kick();
		turnAround();
		find();
		kick();
	}
	
	public void align ()
	{
		int reading = 0;
		int angle = 0;
		
		reading = sonic.getDistance();
		
		do
		{	
			reading = sonic.getDistance();
			while (reading < infinite)
			{
				pilot.rotate(-5);
				reading = sonic.getDistance();
			}
			
			while (reading > infinite)
			{
				pilot.rotate(5);
				reading = sonic.getDistance();
			}
			
			angle = 0;
			while (reading < infinite)
			{
				pilot.rotate(5);
				reading = sonic.getDistance();
				angle += 5;
			}
		
			pilot.rotate(-angle/2);
			reading = sonic.getDistance();
		}
		while (reading > infinite);
	}

	public void find ()
	{
		int reading;
		int errorCount = 0;
		int lastRead;
		
		reading = sonic.getDistance();
		
		while (reading > near)
		{
			lastRead = reading;
			
			if (reading > infinite || reading == realign)
			{
				pilot.stop();
				align();
				pilot.forward();
				
			}
			reading = sonic.getDistance();
			LCD.drawInt(reading, 4, 0, 4);
			
			if (reading == lastRead) errorCount++;
			else errorCount = 0;
		}
		
		pilot.stop();
		//pilot.travel(10);
		//align();
	}
	
	public void turnAround ()
	{
		pilot.travel(-30);
		pilot.rotate(250);
	}
	
	public void kick ()
	{
		Motor.A.rotate(-180);
		Motor.A.rotate(180);
	}
}


