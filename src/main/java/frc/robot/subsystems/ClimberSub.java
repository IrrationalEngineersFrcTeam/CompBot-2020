/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ClimberSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void climb(){

    // 2.003ms = full "forward"
    // 1.550ms = the "high end" of the deadband range
    // 1.500ms = center of the deadband range (off)
    // 1.460ms = the "low end" of the deadband range
    // 0.999ms = full "reverse"
    // 1.752 is half speed
    Robot.robotmap.climberCtrl.set(1.752);

  }

  public void climbDown(){

    Robot.robotmap.climberCtrl.set(1.248);
    
  }
}
