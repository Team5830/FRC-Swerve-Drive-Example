
package frc.robot;

import frc.robot.Constants.DrivePorts;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.WheelDrive;
import frc.robot.subsystems.SwerveDrive;

public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  public static WheelDrive backRight;
  public static WheelDrive backLeft;
  public static WheelDrive frontRight;
  public static WheelDrive frontLeft;
  public static SwerveDrive swerveDrive;

  // Joysticks
  private final XboxController controller = new XboxController(0);
  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    backRight = new WheelDrive(DrivePorts.brAngle, DrivePorts.brDrive, DrivePorts.brEncoder);
    backLeft = new WheelDrive(DrivePorts.blAngle, DrivePorts.blDrive, DrivePorts.blEncoder);
    frontRight = new WheelDrive(DrivePorts.frAngle, DrivePorts.frDrive, DrivePorts.frEncoder);
    frontLeft = new WheelDrive(DrivePorts.flAngle, DrivePorts.flDrive, DrivePorts.flEncoder);
    swerveDrive = new SwerveDrive(backRight, backLeft, frontRight, frontLeft);

    // Configure the button bindings
    configureButtonBindings();
    swerveDrive.setDefaultCommand(new DriveTeleop(controller::getLeftX, controller::getRightY, controller::getRightX, swerveDrive));
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link xroller}), and then passing
   * it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
      
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
    /*
    return new SequentialCommandGroup(
      new Positioning(m_arm,m_wrist,m_extension, m_driveTrain, Position4.armAngle, Position4.wristAngle, Position4.extensionDistance,false),
      new OpenManipulator( m_pneumatics ),
      new WaitCommand(0.75),
      new CloseManipulator( m_pneumatics ),
      new Positioning(m_arm,m_wrist,m_extension,m_driveTrain, Position1.armAngle, Position1.wristAngle, Position1.extensionDistance,true),
      new Move(-4.0, m_driveTrain),
      new InstantCommand(m_driveTrain::OverrideMax)
    );
     */
  }

}
