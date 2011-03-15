
import lejos.nxt.*; // this is required for all programs that run on the NXT


/**
 *Motor runs forward then backward as button is pressed.
 * @author Roger
 */
public class BasicMotorTest
{
    public static void main(String[] args)
    {

        Motor.C.forward();
		Motor.B.forward();
        Button.waitForPress();
        Motor.C.stop();
		Motor.B.stop();
    }
}


