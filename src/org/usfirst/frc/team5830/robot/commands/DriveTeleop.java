package org.usfirst.frc.team5830.robot.commands;

import org.usfirst.frc.team5830.robot.OI;
import org.usfirst.frc.team5830.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTeleop extends Command {

    public DriveTeleop() {}

    protected void execute() {
    	//In this specific setup, Xbox left stick moves and strafes, right stick rotates
    	Robot.swerveDrive.drive(OI.xbox.getRawAxis(0), OI.xbox.getRawAxis(4), OI.xbox.getRawAxis(4));
    }

    protected boolean isFinished() {
        return false;
    }
}
