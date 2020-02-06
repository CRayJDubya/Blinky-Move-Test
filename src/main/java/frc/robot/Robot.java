/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import javax.swing.plaf.basic.BasicButtonUI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs
 * the motors with arcade steering.
 */
public class Robot extends TimedRobot {

  // Motors
 /* private final Talon frontLeftMotor = new Talon(0);
  private final Talon backLeftMotor = new Talon(1);
  private final Talon frontRightMotor = new Talon(2);
  private final Talon backRightMotor = new Talon(3);
  private SpeedController m_motor; */
  
  // Motor Grouping
  //private final SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
  //private final SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);

  // Differential Drive
  // private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
  private Joystick stick;    // = new Joystick(1);
  private SpeedController m_motor;
  //Button motorRun = new JoystickButton(stick, 1);
  //stick = new Joystick(1);

  @Override
  public void robotInit() {
    m_motor = new Spark(0);
    stick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    // m_robotDrive.tankDrive(stick.getY(), stick.getX());
    //motorRun.whenPressed(command);
    //frontLeftMotor.setSpeed(stick.getY());
    m_motor.set(stick.getY());
    SmartDashboard.putNumber("Joy stick Y", stick.getY());
  }
}
