// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  SparkMax driveTopRight;
  SparkMax steerTopRight;
  SparkMax driveTopLeft;
  SparkMax steerTopLeft;
  SparkMax driveBottomRight;
  SparkMax steerBottomRight;
  SparkMax driveBottomLeft;
  SparkMax steerBottomLeft;
  SparkMax pivot;
  SparkMax claw;
  SparkMax climber;
  SparkMax spare;
  TalonFX elevator;

  XboxController xbox;
  
  int count;

  public Robot() {
    driveTopRight = new SparkMax(0, MotorType.kBrushless);
    steerTopRight = new SparkMax(1, MotorType.kBrushless);
    driveTopLeft = new SparkMax(2, MotorType.kBrushless);
    steerTopLeft = new SparkMax(3, MotorType.kBrushless);
    driveBottomRight = new SparkMax(4, MotorType.kBrushless);
    steerBottomRight = new SparkMax(5, MotorType.kBrushless);
    driveBottomLeft = new SparkMax(6, MotorType.kBrushless);
    steerBottomLeft = new SparkMax(7, MotorType.kBrushless);
    pivot = new SparkMax(8, MotorType.kBrushless);
    claw = new SparkMax(9, MotorType.kBrushless);
    climber = new SparkMax(10, MotorType.kBrushless);
    spare = new SparkMax(11, MotorType.kBrushless);
    elevator = new TalonFX(12);

    xbox = new XboxController(0);

    count = 0;

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    if (xbox.getRightBumperButtonPressed()){
      stopAllMotors();
      count++;
    }

    if (xbox.getLeftBumperButtonPressed()){
      stopAllMotors();
      count--;
    }

    if (count > 12) {
      count = 0;
    } 

    if (count < 0) {
      count = 12;
    }
    
    switch (count) {
      case 0:
      driveTopRight.setVoltage(4);
      break;

      case 1:
      steerTopRight.setVoltage(4);
      break;

      case 2:
      driveTopLeft.setVoltage(4);
      break;

      case 3:
      steerTopLeft.setVoltage(4);
      break;

      case 4:
      driveBottomRight.setVoltage(4);
      break;

      case 5:
      steerBottomRight.setVoltage(4);
      break;

      case 6:
      driveBottomLeft.setVoltage(4);
      break;

      case 7:
      steerBottomLeft.setVoltage(4);
      break;

      case 8:
      pivot.setVoltage(4);
      break;

      case 9:
      claw.setVoltage(4);
      break;

      case 10:
      climber.setVoltage(4);
      break;

      case 11:
      spare.setVoltage(4);
      break;

      case 12:
      elevator.setVoltage(4);
      break;
    } 
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}

  public void stopAllMotors(){
    driveTopRight.setVoltage(0);
    steerTopRight.setVoltage(0);
    driveTopLeft.setVoltage(0);
    steerTopLeft.setVoltage(0);
    driveBottomRight.setVoltage(0);
    steerBottomRight.setVoltage(0);
    driveBottomLeft.setVoltage(0);
    steerBottomLeft.setVoltage(0);
    pivot.setVoltage(0);
    claw.setVoltage(0);
    climber.setVoltage(0);
    spare.setVoltage(0);
    elevator.setVoltage(0);
  }
}
