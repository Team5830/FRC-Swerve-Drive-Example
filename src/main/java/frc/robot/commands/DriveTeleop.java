package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
/**
 *
 */
public class DriveTeleop extends CommandBase {

    public DriveTeleop() {}
    @Override
    public void execute() {
    	//In this specific setup, Xbox left stick moves and strafes, right stick rotates
    	Robot.swerveDrive.drive(OI.xbox.getRawAxis(0), OI.xbox.getRawAxis(4), OI.xbox.getRawAxis(4));
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
