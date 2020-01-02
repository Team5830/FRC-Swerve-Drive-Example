/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveDrive;

public class DriveTeleop extends CommandBase {

  private final SwerveDrive m_swerveDrive;

  public DriveTeleop(SwerveDrive subsystem) {
    m_swerveDrive = subsystem;
    addRequirements(m_swerveDrive);
  }

  @Override
  public void execute() {
    //Change to match joystick configuration
    RobotContainer.swerveDrive.drive(RobotContainer.xbox.getRawAxis(0), RobotContainer.xbox.getRawAxis(4), RobotContainer.xbox.getRawAxis(4));
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
