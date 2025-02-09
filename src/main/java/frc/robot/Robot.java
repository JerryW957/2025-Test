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
  SparkMax driveFrontRight;
  SparkMax steerFrontRight;
  SparkMax driveFrontLeft;
  SparkMax steerFrontLeft;
  SparkMax driveBackRight;
  SparkMax steerBackRight;
  SparkMax driveBackLeft;
  SparkMax steerBackLeft;
  TalonFX pivot;
  SparkMax claw;
  SparkMax climber;
  TalonFX elevator;

  XboxController xbox;
  
  int count;

  public Robot() {
    driveFrontLeft = new SparkMax(1, MotorType.kBrushless);
    steerFrontLeft = new SparkMax(2, MotorType.kBrushless);

    driveFrontRight = new SparkMax(3, MotorType.kBrushless);
    steerFrontRight = new SparkMax(4, MotorType.kBrushless);

    driveBackLeft = new SparkMax(5, MotorType.kBrushless);
    steerBackLeft = new SparkMax(6, MotorType.kBrushless);

    driveBackRight = new SparkMax(7, MotorType.kBrushless);
    steerBackRight = new SparkMax(8, MotorType.kBrushless);

    pivot = new TalonFX(9);
    claw = new SparkMax(10, MotorType.kBrushless);
    climber = new SparkMax(11, MotorType.kBrushless);
    elevator = new TalonFX(13);

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

    if (count > 11) {
      count = 0;
    } 

    if (count < 0) {
      count = 11;
    }
    
    switch (count) {
      case 0:
      driveFrontRight.setVoltage(4);
      break;

      case 1:
      steerFrontRight.setVoltage(4);
      break;

      case 2:
      driveFrontLeft.setVoltage(4);
      break;

      case 3:
      steerFrontLeft.setVoltage(4);
      break;

      case 4:
      driveBackRight.setVoltage(4);
      break;

      case 5:
      steerBackRight.setVoltage(4);
      break;

      case 6:
      driveBackLeft.setVoltage(4);
      break;

      case 7:
      steerBackLeft.setVoltage(4);
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
    driveFrontRight.setVoltage(0);
    steerFrontRight.setVoltage(0);
    driveFrontLeft.setVoltage(0);
    steerFrontLeft.setVoltage(0);
    driveBackRight.setVoltage(0);
    steerBackRight.setVoltage(0);
    driveBackLeft.setVoltage(0);
    steerBackLeft.setVoltage(0);
    pivot.setVoltage(0);
    claw.setVoltage(0);
    climber.setVoltage(0);
    elevator.setVoltage(0);
  }
}
