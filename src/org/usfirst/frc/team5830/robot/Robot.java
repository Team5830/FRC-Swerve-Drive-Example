/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5830.robot;

import org.usfirst.frc.team5830.robot.subsystems.SwerveDrive;
import org.usfirst.frc.team5830.robot.subsystems.WheelDrive;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI m_oi;
	
	/*
	 * Swerve Drive
	 */
	//Enter motor port numbers in RobotMap
	public static WheelDrive backRight = new WheelDrive (RobotMap.brAngle, RobotMap.brDrive, RobotMap.brEncoder);
	public static WheelDrive backLeft = new WheelDrive (RobotMap.blAngle, RobotMap.blDrive, RobotMap.blEncoder);
	public static WheelDrive frontRight = new WheelDrive (RobotMap.frAngle, RobotMap.frDrive, RobotMap.frEncoder);
	public static WheelDrive frontLeft = new WheelDrive (RobotMap.flAngle, RobotMap.flDrive, RobotMap.flEncoder);
	public static SwerveDrive swerveDrive = new SwerveDrive (backRight, backLeft, frontRight, frontLeft);

	@Override
	public void robotInit() {m_oi = new OI();}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {Scheduler.getInstance().run();}
	
	@Override
	public void autonomousInit() {}

	@Override
	public void autonomousPeriodic() {Scheduler.getInstance().run();}

	@Override
	public void teleopInit() {}

	@Override
	public void teleopPeriodic() {Scheduler.getInstance().run();}

	@Override
	public void testPeriodic() {}
}
