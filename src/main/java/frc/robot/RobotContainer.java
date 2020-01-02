/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.SwerveDrive;
import frc.robot.subsystems.WheelDrive;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  /*
	Swerve Drive Motors/Encoders

	Swerve module location (left and right) is from a view of the robot from behind.

	Front of Robot
		 ---------
		/FL     FR\
		|         |
		|         |
		|         |
		\BL     BR/
		 ---------
		*/
	
	//Angle and Drive motors are standard PWM-controlled motor controller outputs. 
	//Put the number of the PWM port of your motor controller.
	//Enter the Analog port your encoder is connected to.
	
	//Gyro
	//Replace with your gyroscope. SwerveDrive.java polls the gyro using .getAngle().
	//Gyroscope is optional. If you do not have one, comment this line AND set the boolean to false.
	//If you do not have a gyroscope and leave this here and/or leave the boolean true, the code may crash on startup.
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static boolean hasGyro = true;

	//Add or change as necessary
	public static XboxController xbox = new XboxController(0);

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

	public static WheelDrive backRight = new WheelDrive (brAngle, brDrive, brEncoder);
	public static WheelDrive backLeft = new WheelDrive (blAngle, blDrive, blEncoder);
	public static WheelDrive frontRight = new WheelDrive (frAngle, frDrive, frEncoder);
	public static WheelDrive frontLeft = new WheelDrive (flAngle, flDrive, flEncoder);
	public static SwerveDrive swerveDrive = new SwerveDrive (backRight, backLeft, frontRight, frontLeft);
 
	public RobotContainer() {
		configureButtonBindings();
  }

  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
