/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ShooterSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public ShooterSub() {

    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public double velocity(double dist, double angle, double height) {

      double  v0 = Math.sqrt((9.8*(Math.pow(dist,2))/(2*dist*(Math.sin(angle))*(Math.cos(angle)))-(2*height*(Math.pow(Math.cos(angle),2)))));

      return v0;
    }

    //set to %50 for testing purposes only, remember to put it up again
    public void shoot(double v0) {
        

        Robot.robotmap.shootCtrl0.set(v0);
        Robot.robotmap.shootCtrl1.set(v0);

    }

}
