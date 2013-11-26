/** Thomas Buchanan CISS241
 * The goal of this program is to keep the robot moving at all times
 */

package lejos;

import lejos.nxt.*;

public class KeepMoving
{
	public static void main(String[] args)
	{
	TouchSensor ts1 = new TouchSensor(SensorPort.S1);
	TouchSensor ts2 = new TouchSensor(SensorPort.S2);
	
	Motor.A.setSpeed(360);
	Motor.C.setSpeed(360);

		while (!ts1.isPressed() && !ts2.isPressed()) //We are not hitting anything; go forward.
		{
			Motor.A.forward(); //Set motors to go forward
			Motor.C.forward(); //Set motors to go forward
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{}
		}
		
		while (ts1.isPressed()) { //Oh no, we hit something with sensor 1.
			Motor.A.backward(); //Set motors to go backward
			Motor.C.backward(); //Set motors to go backward
			try
			{
				Thread.sleep(2000); //Go backward for 2 seconds
			}
			catch(InterruptedException e)
			{}
			Motor.A.forward(); //Set motors to go right
			Motor.C.backward();//Set motors to go right
			try
			{
				Thread.sleep(3000); //Go right for 3 seconds
			}
			catch(InterruptedException e)
			{}
		}
		
		while (ts2.isPressed()) { //Oh no, we hit something with sensor 2.
			Motor.A.backward(); //Set motors to go backward
			Motor.C.backward(); //Set motors to go backward
			try
			{
				Thread.sleep(2000); //Go backward for 2 seconds
			}
			catch(InterruptedException e)
			{}
			Motor.A.backward();//Set motors to go left
			Motor.C.forward(); //Set motors to go left
			try
			{
				Thread.sleep(3000); //Go left for 3 seconds
			}
			catch(InterruptedException e)
			{}
		}
		
		while (ts1.isPressed() && ts2.isPressed()) { //Both sensors are hit; we are trapped.
			Motor.A.flt(); //Float to a stop.
			Motor.C.flt(); //Float to a stop.
		}
	}
}
