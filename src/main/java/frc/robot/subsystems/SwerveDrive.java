package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Jacob Misirian
 * https://jacobmisirian.gitbooks.io/frc-swerve-drive-programming/content/
 *
 * Max P. implemented
 */

public class SwerveDrive extends SubsystemBase {
	
	double gyroRad;
	
	//CHANGE THESE VALUES! Failing to do so could result in 
	//L refers to the physical distance between the front and back wheels
	//W refers to the physical distance between the left and right wheels
	public final double L = 21;
	public final double W = 26;
	public AHRS ahrs = new AHRS(SerialPort.Port.kUSB1);

	public void drive (double x1, double y1, double x2) {
		SmartDashboard.putNumber("drive x1", x1);
		SmartDashboard.putNumber("drive y1", y1);
		SmartDashboard.putNumber("drive x2", x2);

	    double r = Math.sqrt ((L * L) + (W * W));
	    y1 *= -1;
	    x1 *= -1;
	    
	    //The following is for Field oriented swerve drive. If you do not have a gyroscope, delete from here until specified.
	    gyroRad = ahrs.getAngle()*Math.PI/180;
	
	    //Set to true to enable Field-oriented drive. Set to false for Robot-oriented drive.
	    //Making this a boolean toggle in SmartDashboard or something is recommended, as this can be switched at any time during the game.
	    if(false) {
	    	  double temp = y1*Math.cos(gyroRad) + x1*Math.sin(gyroRad-Math.PI); //Sometimes robot will drive the opposite direction in some orientations, read wiki for more info
	 	   	 x1 = -y1*Math.sin(gyroRad-Math.PI) + x1*Math.cos(gyroRad);
	 	   	 y1 = temp;
	    }
	    //Stop deleting here if you don't have a gyroscope.

	    double a = x1 - x2 * (L / r);
	    double b = x1 + x2 * (L / r);
	    double c = y1 - x2 * (W / r);
	    double d = y1 + x2 * (W / r);

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
	public void periodic() {
		SmartDashboard.putNumber("backright volt", backRight.getVoltage());
		SmartDashboard.putNumber("backleft volt", backLeft.getVoltage());
		SmartDashboard.putNumber("frontright volt", frontRight.getVoltage());
		SmartDashboard.putNumber("frontleft volt", frontLeft.getVoltage());

		SmartDashboard.putNumber("backright set", backRight.getSetpoint());
		SmartDashboard.putNumber("backleft set", backLeft.getSetpoint());
		SmartDashboard.putNumber("frontright set", frontRight.getSetpoint());
		SmartDashboard.putNumber("frontleft set", frontLeft.getSetpoint());
		
		SmartDashboard.putNumber("ahrs angle", ahrs.getAngle());
		SmartDashboard.putNumber("ahrs roll", ahrs.getRoll());
		SmartDashboard.putNumber("ahrs pitch", ahrs.getPitch());
		SmartDashboard.putNumber("ahrs yaw", ahrs.getYaw());
	}

}
