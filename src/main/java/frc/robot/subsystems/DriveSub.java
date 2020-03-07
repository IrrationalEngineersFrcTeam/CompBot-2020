/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;
import frc.robot.Robot;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DriveSub() {
    
  }

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new DriveCommand());

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void TankDrive(double SpeedL, double SpeedR){
    //This is the code that actually makes the robot drive! It tells the 
    //proper motor controllers to set the motors to desired speed.
    double PercentSpeed = 0.7;

    Robot.robotmap.MotorL1Control.set(-SpeedL * 0.7);
		Robot.robotmap.MotorL2Control.set(-SpeedL * 0.7);
		Robot.robotmap.MotorR1Control.set(SpeedR * 0.7);
    Robot.robotmap.MotorR2Control.set(SpeedR * 0.7); 
    
  }

  public void ArcadeDrive(double DrivForward, double DriveTurn)
  {

    double LeftSide;
    double RightSide;

    if(DrivForward > 0)
    {
      LeftSide = DrivForward + DriveTurn;
      RightSide = DrivForward - DriveTurn;
    }
    else
    {
      LeftSide = DrivForward - DriveTurn;
      RightSide = DrivForward + DriveTurn;
    }

    Robot.robotmap.MotorL1Control.set(-LeftSide * 0.4);
		Robot.robotmap.MotorL2Control.set(-LeftSide * 0.4);
		Robot.robotmap.MotorR1Control.set(RightSide * 0.4);
    Robot.robotmap.MotorR2Control.set(RightSide * 0.4);

  }

  



}
