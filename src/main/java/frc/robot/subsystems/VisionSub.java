/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class VisionSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }



    //this takes the X angle from the limelight and turns it into a motor output
    public double VisionTurn(double AngleX)
    {
      
      if(Math.abs(AngleX)<=0.2)
      {
      return 0;
      }
      else
      {
      return -Robot.pid1.CalculateSpeed(AngleX);
      }
  
    }
  
    //This takes the Y angle from the limelight(in degrees), the angle of the mounting of the limelight(in degrees), and the hight of the limeligh(in inches)
    //and then returns the current distance of the robot to the vision target(in inches)
    public double CurrentRoboDistance(double VisionDegreesY, double MountingDegreesY, double MountingHight)
    {
  
      //These convert the angles we get from degrees to radians, because the tangent function only takes radians
      double VisRadiansY = Math.toRadians(VisionDegreesY);
      double MountRadiansY = Math.toRadians(MountingDegreesY);
  
      //The 98.25 is the hieght of the visiontarget in inches is 98.25
      double Hight = 98 - MountingHight;
      double TangentAngle = Math.tan(VisRadiansY + MountRadiansY);
  
      double CurrentDistance = Hight/TangentAngle;
  
      return CurrentDistance;
  
    }
  
    public double AdjustRoboDistance(double TargetDist, double CurrentDist)
    {
  
      double DeltaX = TargetDist - CurrentDist;
  
      if(Math.abs(DeltaX) <= 6)
      {
      return 0;
      }
      else
      {
      return -Robot.pid2.CalculateSpeed(DeltaX);
      }

    }
  

}