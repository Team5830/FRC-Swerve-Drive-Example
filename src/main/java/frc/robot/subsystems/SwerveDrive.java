/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveTeleop;

/**
 * Add your docs here.
 */
public class SwerveDrive extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private SwerveDrive m_SwerveDrive;

  double gyroRad;
	
	public void drive (double x1, double y1, double x2) {
      
    double r = Math.sqrt ((Constants.L * Constants.L) + (Constants.W * Constants.W));
    y1 *= -1;
    x1 *= -1;
    
    //The following is for Field oriented swerve drive. If you do not have a gyroscope, delete from here until specified.
    gyroRad = RobotContainer.gyro.getAngle()*Math.PI/180;
    
    //Set to true to enable Field-oriented drive. Set to false for Robot-oriented drive.
    //Making this a boolean toggle in SmartDashboard or something is recommended, as this can be switched at any time during the game.
    //Sometimes robot will drive the opposite direction in some orientations. Add or remove Math.PI in this function to correct.
    if(true) {
      double temp = y1*Math.cos(gyroRad) + x1*Math.sin(gyroRad-Math.PI);
      x1 = -y1*Math.sin(gyroRad-Math.PI) + x1*Math.cos(gyroRad);
      y1 = temp;
    }
    //Stop deleting here if you don't have a gyroscope.

    double a = x1 - x2 * (Constants.L / r);
    double b = x1 + x2 * (Constants.L / r);
    double c = y1 - x2 * (Constants.W / r);
    double d = y1 + x2 * (Constants.W / r);

    double backRightSpeed = Math.sqrt ((a * a) + (d * d));
    double backLeftSpeed = Math.sqrt ((a * a) + (c * c));
    double frontRightSpeed = Math.sqrt ((b * b) + (d * d));
    double frontLeftSpeed = Math.sqrt ((b * b) + (c * c));

    double backRightAngle = Math.atan2 (a, d) / Math.PI;
    double backLeftAngle = Math.atan2 (a, c) / Math.PI;
    double frontRightAngle = Math.atan2 (b, d) / Math.PI;
    double frontLeftAngle = Math.atan2 (b, c) / Math.PI;
    backRight.drive (backRightSpeed, backRightAngle);
    backLeft.drive (backLeftSpeed, backLeftAngle);
    frontRight.drive (frontRightSpeed, frontRightAngle);
    frontLeft.drive (frontLeftSpeed, frontLeftAngle);
	}
	
	private WheelDrive backRight;
	private WheelDrive backLeft;
	private WheelDrive frontRight;
	private WheelDrive frontLeft;

	public SwerveDrive (WheelDrive backRight, WheelDrive backLeft, WheelDrive frontRight, WheelDrive frontLeft) {
    this.backRight = backRight;
    this.backLeft = backLeft;
    this.frontRight = frontRight;
    this.frontLeft = frontLeft;
	}

  @Override
  public void setDefaultCommand(Command defaultCommand) {
    super.setDefaultCommand(new DriveTeleop(m_SwerveDrive));
  }
}
