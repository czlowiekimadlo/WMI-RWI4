
import lejos.nxt.*; // this is required for all programs that run on the NXT
import lejos.robotics.navigation.TachoPilot;


/**
 * 
 * @author Quak
 */
public class Sensors
{
	TachoPilot pilot;
	UltrasonicSensor sonic;
	LightSensor light;	

    public static void main(String[] args) throws Exception
    {   
		Sensors robot = new Sensors();
		robot.sonic = new UltrasonicSensor(SensorPort.S1);
		robot.pilot = new TachoPilot(1.7f, 12f, Motor.B, Motor.C);
		robot.light = new LightSensor(SensorPort.S2);
		robot.run();
		
    }
	
	public void run() throws Exception
	{
		//pilot.travel(20);
		
		boolean more = true;
		while (more) 
		{
			LCD.clear();
			LCD.drawInt(sonic.getDistance(), 0, 0);
			LCD.drawInt(light.readValue(), 4, 0, 1);
			LCD.drawInt(light.readNormalizedValue(), 4, 0, 2);
			LCD.drawInt(SensorPort.S4.readRawValue(), 4, 0, 3);
			LCD.drawInt(SensorPort.S4.readValue(), 4, 0, 4);
			more = Button.waitForPress()<8;
		}
		
		
	}
	
	public void kick ()
	{
		Motor.A.rotate(-90);
		Motor.A.rotate(90);
	}
	   

}


