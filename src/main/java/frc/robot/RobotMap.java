/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 * 
 * @author Hunter P.
 *
 */

public class RobotMap {
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
	
	//Back Right:
	public static int brAngle = 0;//PWM Port
	public static int brDrive = 1;//PWM Port
	public static int brEncoder = 0;//Analog Port
	
	//Back Left:
	public static int blAngle = 2;//PWM Port
	public static int blDrive = 3;//PWM Port
	public static int blEncoder = 1;//Analog Port

	//Front Right:
	public static int frAngle = 4;//PWM Port
	public static int frDrive = 5;//PWM Port
	public static int frEncoder = 2;//Analog Port
	
	//Front Left:
	public static int flAngle = 6;//PWM Port
	public static int flDrive = 7;//PWM Port
	public static int flEncoder = 3;//Analog Port
	
	//Gyro
	//We happen to use the ADXRS540 SPI gyro. As long as your gyro can give SwerveDrive its angle in degrees, that's great.
	//Gyroscope is optional. If you do not have one, delete this line, and specified code block in SwerveDrive subsystem.
	//If you do not have a gyroscope and leave this here, the code WILL crash on startup.
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
}
