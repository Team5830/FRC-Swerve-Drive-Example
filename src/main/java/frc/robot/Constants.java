/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * 
 * @author Hunter P.
 *
 */

public class Constants {
	/*
	Swerve Drive Motors/Encoders
	
	Swerve module location (left and right) is from a view of the robot from behind.
	
    Front of Robot
	  ---------
	 /FL	 FR\
	 |		   |
	 |		   |
	 |         |
	 \BL     BR/
	  ---------
	 */
	
	//Angle and Drive motors are standard PWM-controlled motor controller outputs. 
	//Put the number of the PWM port of your motor controller.
	
	//Encoders are analog, basically potentiometers without end stops.
	//We use the Andymark AM-2899 encoder for this. http://www.andymark.com/MA3-A10-250-N-absolute-encoder-p/am-2899.htm
	//Enter the Analog port your encoder is connected to.
	public static final class DrivePorts {
		//Back Right:
		public static int brAngle = 7;//PWM Port
		public static int brDrive = 8;//PWM Port
		public static int brEncoder = 0;//Analog Port
		
		//Back Left:
		public static int blAngle = 0;//PWM Port
		public static int blDrive = 1;//PWM Port
		public static int blEncoder = 3;//Analog Port

		//Front Right:
		public static int frAngle = 3;//PWM Port
		public static int frDrive = 2;//PWM Port
		public static int frEncoder = 1;//Analog Port
		
		//Front Left:
		public static int flAngle = 4;//PWM Port
		public static int flDrive = 5;//PWM Port
		public static int flEncoder = 2;//Analog Port
	}
}
