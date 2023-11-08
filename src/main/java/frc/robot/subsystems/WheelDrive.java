package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
/**
 * @author Jacob Misirian
 * https://jacobmisirian.gitbooks.io/frc-swerve-drive-programming/content/
 *
 * Max P. implemented
 */

public class WheelDrive {
	private Talon angleMotor;
	private Talon speedMotor;
	private PIDController pidController;
    private AnalogInput encoder;
public WheelDrive (int angleMotor, int speedMotor, int encoder_port) {
    this.angleMotor = new Talon (angleMotor);
    this.speedMotor = new Talon (speedMotor);
    this.encoder = new AnalogInput(encoder_port);
	pidController = new PIDController (2.0, 0.0, 0.5);//, new AnalogInput (encoder), this.angleMotor);
    pidController.enableContinuousInput(0, 4.95);
    pidController.setTolerance(2,0.5);
    //.calculate(new AnalogInput (encoder));
    //pidController.setOutputRange (-1, 1);
    //pidController.setInputRange(0, 4.95);
    //pidController.setContinuous ();
    //pidController.enable ();
}

private final double MAX_VOLTS = 4.95;

public void drive (double speed, double angle) {
    speedMotor.set (speed);

 double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
    //Remove ? 
    if (setpoint < 0) {
        setpoint = MAX_VOLTS + setpoint;
    }
    if (setpoint > MAX_VOLTS) {
        setpoint = setpoint - MAX_VOLTS;
    }
    //Remove ?
    //Apply input limits that were set with setInputRange before
    if (setpoint < 0) {
        setpoint = 0;
    } 
    if (setpoint > MAX_VOLTS) {
        setpoint = MAX_VOLTS;
    }
    angleMotor.set(MathUtil.clamp(pidController.calculate(encoder.getVoltage(), setpoint), -1.0, 1.0) );
    //pidController.setSetpoint (setpoint);
}

public double getVoltage() {
    return encoder.getVoltage();
}

}
