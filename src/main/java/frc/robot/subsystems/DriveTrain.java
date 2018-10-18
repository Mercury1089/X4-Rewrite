/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap.*;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private TalonSRX rightFront, leftFront;
  private VictorSPX rightBack, leftBack;
  private DifferentialDrive drive;

  public DriveTrain() {
    leftFront = new TalonSRX(CAN.DRIVETRAIN_ML);
    rightFront = new TalonSRX(CAN.DRIVETRAIN_MR);
    leftFront.setInverted(true);
    rightFront.setInverted(false);
    leftBack = new VictorSPX(CAN.DRIVETRAIN_SL);
    rightBack = new VictorSPX(CAN.DRIVETRAIN_SR);
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

  //COMPLETE: set the default command. (If you need help ask me)
  @Override
  public void initDefaultCommand() {
    // e.g.: setDefaultCommand(new MySpecialCommand());
    
  }

  /**
   * Should arcadeDrive the robot using the throttle (y-axis of the left joystick) and yaw (x-axis of right joystick)
   */
  public void arcadeDrive(double throttle, double yaw) {
    double leftPercent, rightPercent;

		// Square inputs, but maintain their signs.
		// This allows for more precise control at lower speeds,
		// but permits full power.
		throttle = Math.copySign(throttle * throttle, throttle);
		yaw = Math.copySign(yaw * yaw, yaw);
		
		// Set left and right motor speeds.
		if (throttle > 0) {
			if (yaw > 0) {
				rightPercent = throttle - yaw;
				leftPercent = Math.max(throttle, yaw);
			} else {
				rightPercent = Math.max(throttle, -yaw);
				leftPercent = throttle + yaw;
			}
		} else {
			if (yaw > 0) {
				rightPercent = -Math.max(-throttle, yaw);
				leftPercent = throttle + yaw;
			} else {
				rightPercent = throttle - yaw;
				leftPercent = -Math.max(-throttle, -yaw);
			}
		}
		
		// Apply speeds to motors.
		// This assumes that the Talons have been setClawState properly.
		leftFront.set(ControlMode.PercentOutput, leftPercent);
		rightFront.set(ControlMode.PercentOutput, rightPercent);
  }

  public void stopDriveTrain() {
    Robot.driveTrain.setNeutralMode(NeutralMode.Brake);
    leftFront.set(ControlMode.Velocity, 0);
    rightFront.set(ControlMode.Velocity, 0);
  }

  public void setNeutralMode(NeutralMode nm) {
    rightFront.setNeutralMode(nm);
    leftFront.setNeutralMode(nm);
    rightBack.setNeutralMode(nm);
    leftBack.setNeutralMode(nm);
  }
}
