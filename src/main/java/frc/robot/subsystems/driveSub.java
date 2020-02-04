/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.DriveCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class driveSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public driveSub() {
    
  }

  @Override
  public void initDefaultCommand() {


    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void TankDrive(double SpeedL, double SpeedR){
    //This is the code that actually makes the robot drive! It tells the 
    //proper motor controllers to set the motors to desired speed.
      
    Robot.robotmap.MotorL1Control.set(-SpeedL * 0.65);
		Robot.robotmap.MotorL2Control.set(-SpeedL * 0.65);
		Robot.robotmap.MotorR1Control.set(SpeedR * 0.65);
    Robot.robotmap.MotorR2Control.set(SpeedR * 0.65); 
  }

  public void shoot() {

    Robot.robotmap.shootCtrl.set(.5);

  }
}
