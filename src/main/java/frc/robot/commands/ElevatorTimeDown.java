/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

/**
 * Responding to motor control. Runs infinitely
 */
public class ElevatorTimeDown extends Command {

  private int count = 0;
  private double time;

  private Elevator elevator = Robot.elevator;

  public ElevatorTimeDown(double time) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevator);
    this.time = time;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drivymcDriveDriverson.drive.arcadeDrive(Robot.m_oi., target);
    count = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      count ++;
      elevator.elevatorMotor.set(-0.2);
    }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return count >= time*30;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    elevator.elevatorMotor.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    elevator.elevatorMotor.set(0.0);
  }

}
