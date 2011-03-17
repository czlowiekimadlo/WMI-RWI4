//package org.lejos.knr;

import lejos.nxt.*;
import lejos.robotics.navigation.TachoPilot;

public class LineFollower {
	
	int treshold = 35;
	int seekAngle = 30;
	int seekAngleStep = 3;
	boolean left = true;

	TachoPilot pilot;
	LightSensor light;


	public static void main(String[] args) throws Exception 
	{
	
		LineFollower robot = new LineFollower();
		robot.pilot = new TachoPilot(1.7f, 24f, Motor.B, Motor.C);
		robot.light = new LightSensor(SensorPort.S2);
		robot.run();

	}
	
	public void run ()
	{
		int reading;
		int angleCount;
		
		pilot.forward();
		
		while (Button.ESCAPE.isPressed())
		{
			reading = light.readValue();
			LCD.drawInt(reading, 4, 0, 4);
			
			if (reading > treshold)
			{
				pilot.stop();
				
				if (left)
				{
					angleCount = 0;
					while (reading > treshold && angleCount < seekAngle)
					{
						pilot.rotate(-seekAngleStep);
						angleCount += seekAngleStep;
						reading = light.readValue();
						LCD.drawInt(reading, 4, 0, 4);
					}
					
					if (reading > treshold)
					{
						pilot.rotate(seekAngle);
						while (reading > treshold)
						{
							pilot.rotate(seekAngleStep);
							reading = light.readValue();
							LCD.drawInt(reading, 4, 0, 4);
						}
						left = false;
					}
				}
				else
				{
					angleCount = 0;
					while (reading > treshold && angleCount < seekAngle)
					{
						pilot.rotate(seekAngleStep);
						angleCount += seekAngleStep;
						reading = light.readValue();
						LCD.drawInt(reading, 4, 0, 4);
					}
					
					if (reading > treshold)
					{
						pilot.rotate(-seekAngle);
						while (reading > treshold)
						{
							pilot.rotate(-seekAngleStep);
							reading = light.readValue();
							LCD.drawInt(reading, 4, 0, 4);
						}
						left = true;
					}
				}
				pilot.forward();
			}
		}
	}
	
}