/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ShootBall extends Command {
  
  private boolean shoot;
  private final double SHOOTER_DELAY_MILLIS = 500;
  private double startTime;

  public ShootBall(boolean shoot) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.shooter);
    this.shoot = shoot;
    startTime = System.currentTimeMillis();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.shooter.shootBall();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() - startTime >= SHOOTER_DELAY_MILLIS;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }
}
