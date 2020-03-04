/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.commandGroups.ShootPowerCells;

public class visionTrackinCommand extends Command {
  public double TurnSpeed;
  public visionTrackinCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive_sub);
    requires(Robot.visionsub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Robot.LimelightTable.getEntry("ledMode").setNumber(0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {

    double DriveSpeed = Robot.visionsub.AdjustRoboDistance(96, Robot.visionsub.CurrentRoboDistance(Robot.VaY, 30, 30));
    double TurnSpeed = Robot.visionsub.VisionTurn(Robot.VaX);

    if(Robot.IsSeen != 1 )
      Robot.drive_sub.TankDrive(.25, -.25);
  
    else {

      Robot.drive_sub.TankDrive(0, 0);
      Robot.drive_sub.ArcadeDrive(DriveSpeed, TurnSpeed);
      
      if(TurnSpeed == 0)
      {
        Robot.shootersub.shoot();
      }

    }

     //This creates two variables that are equal to the angle of joysticks
    //These will be usefull to the drive subsystem 
    
    // double SpeedL = Robot.oi.sticcL.getY();AZ
    // double SpeedR = Robot.oi.sticcR.getY();
    // //  double SpeedXL = Robot.oi.sticcL.getX();
    // // double SpeedXR = Robot.oi.sticcR.getX();

    //double TurnVoltageVision = Robot.visionsub.VisionTurn(Robot.VaX);
      
    // if(Robot.StartTracking == true)
    // {
    // Robot.drive_sub.ArcadeDrive(SpeedR, TurnVoltageVision);
    // }


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
