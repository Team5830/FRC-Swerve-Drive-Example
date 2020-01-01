/**
 * @author Jacob Misirian
 * https://jacobmisirian.gitbooks.io/frc-swerve-drive-programming/content/
 *
 * Max P. implemented
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.Spark;

public class WheelDrive {
	private Spark angleMotor;
	private Spark speedMotor;
    private PIDController pidController;
    private AnalogInput encoderInput;

    public WheelDrive (int angleMotor, int speedMotor, int encoder) {
        this.angleMotor = new Spark(angleMotor);
        this.speedMotor = new Spark(speedMotor);
        this.encoderInput = new AnalogInput(encoder);

        pidController = new PIDController (2, 0, 0.5);
        pidController.enableContinuousInput(0, 4.95);
    }

    private final double MAX_VOLTS = 4.95;

    public void drive (double speed, double angle) {
        speedMotor.set (speed);

    double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
        if (setpoint < 0) {
            setpoint = MAX_VOLTS + setpoint;
        }
        if (setpoint > MAX_VOLTS) {
            setpoint = setpoint - MAX_VOLTS;
        }

        angleMotor.set(pidController.calculate(encoderInput.getVoltage(), setpoint));
    }

}