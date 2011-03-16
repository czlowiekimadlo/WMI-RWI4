
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
	int near = 20;

    public static void main(String[] args)
    {   
		Balls robot = new Balls();
		robot.sonic = new UltrasonicSensor(SensorPort.S3);
		robot.pilot = new TachoPilot(1.7f, 12f, Motor.B, Motor.C);
		robot.light = new LightSensor(SensorPort.S4);
		robot.run();
    }
	
	public void run()
	{
		//pilot.travel(20);
		
		//kick();
		align();
	}
	
	public void align ()
	{
		int reading = 0;
		int angle = 0;
		int travelDistance = 0;
		
		reading = sonic.getDistance();
		
		while (reading > near)
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
			
			if (near + 10 > reading) travelDistance = reading - near;
			else travelDistance = 10;
			
			pilot.travel(travelDistance);
			
			reading = sonic.getDistance();
		}
	}
	
	public void kick ()
	{
		Motor.A.rotate(-90);
		Motor.A.rotate(90);
	}
}


