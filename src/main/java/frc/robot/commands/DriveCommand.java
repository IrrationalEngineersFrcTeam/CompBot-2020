/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive_sub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //This creates two variables that are equal to the angle of joysticks
    //These will be usefull to the drive subsystem 
    double SpeedL = Robot.oi.sticcL.getY();
    double SpeedR = Robot.oi.sticcR.getY();
    // double SpeedXL = Robot.oi.sticcL.getX();
    //double SpeedXR = Robot.oi.sticcR.getX();
    double TurnSpeed = Robot.drive_sub.VisionTurn(Robot.VaX);

      
    if(Robot.StartTracking == false)
    {
   // Robot.ledMode.setNumber(1);
    Robot.drive_sub.TankDrive(SpeedL, SpeedR);
    }
    else
    {
   // Robot.ledMode.setNumber(3);
    Robot.drive_sub.ArcadeDrive(SpeedR, TurnSpeed);
    }

  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
