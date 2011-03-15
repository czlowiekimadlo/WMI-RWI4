
import lejos.nxt.*; // this is required for all programs that run on the NXT


/**
 * 
 * @author Quak
 */
public class BasicSearchTest
{
    public static void main(String[] args)
    {   
		BasicSearchTest robot = new BasicSearchTest();
		
		robot.run();
    }
	
	public void run()
	{
		//Motor.C.forward();
		//Motor.B.forward();
        
		//Button.waitForPress();
        //Motor.C.stop();
		//Motor.B.stop();
		
		kick();
		
	}
	
	public void kick ()
	{
		Motor.A.rotate(-90);
		Motor.A.rotate(90);
	}
}


