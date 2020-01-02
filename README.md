# FRC-Swerve-Drive-Example
Plug-and-play example code for FRC Swerve Drive robots using [Andymark Swerve and Steer Modules](https://www.andymark.com/products/swerve-and-steer?Encoder=MA3&Motor=CIM) with [MA3 Encoders](https://www.andymark.com/products/absolute-encoder-with-cable) (and [gears](https://www.andymark.com/products/40-tooth-absolute-encoder-gear-for-swerve-steer)). Based on [jacobmisirian's tutorial](https://www.gitbook.com/book/jacobmisirian/frc-swerve-drive-programming).

## Features
- Robot-oriented or Field-oriented driving modes
- Quick and easy deployment
- Gyroscope optional

## Instructions
#### 1. Wire to RoboRIO
Wire according to this list, following the positioning diagram in `RobotContainer.java`:
- Analog Encoders:
  - Back Right: Analog 0
  - Back Left: Analog 1
  - Front Right: Analog 2
  - Front Left: Analog 3
- Angle Motors:
  - Back Right: PWM 0
  - Back Left: PWM 2
  - Front Right: PWM 4
  - Front Left: PWM 6
- Drive Motors:
  - Back Right: PWM 1
  - Back Left: PWM 2
  - Front Right: PWM 5
  - Front Left: PWM 7
#### 2. Configure
Gyros: Gyros are optional. This code is built to use the ADXSR450 gyroscope. If you have another gyro, manually change it in `RobotContainer.java`. If you do not have a gyro installed, set `hasGyro` to `false` and comment out the specified line.

In `Constants.java`, change the length and width values to match your robot. This is vital. Improper adjustment may result in reduced performance, worn wheels, and damaged parts.

In `RobotContainer.java`, add/change to the desired joystick(s). Change joystick axes in `DriveTeleop.java` to match.

#### 3. Test
If you run into issues, follow commented instructions throughout code to fix common issues. If you are still having issues, submit an issue and Team 5830 will help as best as we can.