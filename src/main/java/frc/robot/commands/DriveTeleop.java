package frc.robot.commands;

import frc.robot.subsystems.*;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**
 *
 */
public class DriveTeleop extends CommandBase {
    private SwerveDrive swervedrive;
    private DoubleSupplier x;
    private DoubleSupplier y;
    public DriveTeleop(DoubleSupplier X, DoubleSupplier Y, SwerveDrive swerveDrive) {
        addRequirements(swerveDrive);
        x = X;
        y = Y;
        swervedrive = swerveDrive;
    }
    @Override
    public void execute() {
    	//In this specific setup, Xbox left stick moves and strafes, right stick rotates
    	swervedrive.drive(x.getAsDouble(), y.getAsDouble(), y.getAsDouble());
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
