
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

    public static void main(String[] args)
    {   
		Sensors robot = new Sensors();
		robot.sonic = new UltrasonicSensor(SensorPort.S4);
		robot.pilot = new TachoPilot(1.75f, 12f, Motor.B, Motor.C);
		robot.run();
    }
	
	public void run()
	{
		//pilot.travel(20);
		
		
    while (!Button.ESCAPE.isPressed()) {

      //LCD.clear();
      //LCD.drawString(sonic.getVersion(), 0, 0);
      //LCD.drawString(sonic.getProductID(), 0, 1);
      //LCD.drawString(sonic.getSensorType(), 0, 2);
      LCD.drawInt(sonic.getDistance(), 0, 3);
	  }
		
		//kick();
		
	}
	
	public void kick ()
	{
		Motor.A.rotate(-90);
		Motor.A.rotate(90);
	}
	   

}


