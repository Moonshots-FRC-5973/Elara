/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
/**
 * Responding to motor control. Runs infinitely
 */
public class DriveCommand extends Command {

  private DifferentialDrive drive = Robot.drivymcDriveDriverson.drive;

  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivymcDriveDriverson);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.drivymcDriveDriverson.drive.arcadeDrive(Robot.m_oi., target);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //MANUAL DEAD ZONE
    double dead = 0.15;

    double valueleftx = OI.gamePad3.getRawAxis(0);
    double valuelefty = OI.gamePad3.getRawAxis(1);

    if(Math.abs(valueleftx) < dead){
      valueleftx = 0;
    }
    if(Math.abs(valuelefty) < dead){
      valuelefty = 0;
    }    

    drive.arcadeDrive(valuelefty, valueleftx); 
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    drive.arcadeDrive(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    drive.arcadeDrive(0,0);
  }

}
