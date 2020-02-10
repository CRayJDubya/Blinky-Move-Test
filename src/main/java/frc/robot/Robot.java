/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs
 * the motors with arcade steering.
 */
public class Robot extends TimedRobot {

  // Creates a stick variable
  private Joystick stick;   
  // These create motor groups
  private SpeedControllerGroup leftMotorGroup;
  private SpeedControllerGroup rightMotorGroup;
  // Required to use tankDrive/arcadeDrive
  private DifferentialDrive robotDrive;


  @Override
  public void robotInit() {
    // Creates motors. Numbers in parantheses are where they are on the PWM.
    final Spark frontLeftMotor = new Spark(0);
    final Spark backLeftMotor = new Spark(1);
    final Spark frontRightMotor = new Spark(2);
    final Spark backRightMotor = new Spark(3);
    // Groups motors
    leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    rightMotorGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);
    // DifferentialDrive groups the motor groups so they work with differential drive
    robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
    // The port that the joystick is plugged into on the computer
    stick = new Joystick(1);
  } 

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    // m_robotDrive.tankDrive(stick.getY(), stick.getX());

    //This creates the drive, putting * -1.0 means that forwards is forwards on our joystick.
    robotDrive.arcadeDrive(stick.getY() * -1.0, stick.getX());
    SmartDashboard.putNumber("Joy stick Y", stick.getY());
  }
}
