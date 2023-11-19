package frc.robot.commands;

import frc.robot.subsystems.*;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveTeleop extends CommandBase {
  private SwerveDrive swerveDrive;
  private DoubleSupplier x1;
  private DoubleSupplier y1;
  private DoubleSupplier x2;

  public DriveTeleop(DoubleSupplier x1, DoubleSupplier y1, DoubleSupplier x2, SwerveDrive swerveDrive) {
    addRequirements(swerveDrive);
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.swerveDrive = swerveDrive;
  }

  @Override
  public void execute() {
    // In this specific setup, Xbox left stick moves and strafes, right stick
    // rotates
    swerveDrive.drive(x1.getAsDouble(), y1.getAsDouble(), x2.getAsDouble());
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
