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

    public void TankDrive(double SpeedL, double SpeedR) {
        //This is the code that actually makes the robot drive! It tells the
        //proper motor controllers to set the motors to desired speed.
        double PercentSpeed = 0.7;

        Robot.robotmap.MotorL1Control.set(-SpeedL * PercentSpeed);
        Robot.robotmap.MotorL2Control.set(-SpeedL * PercentSpeed);
        Robot.robotmap.MotorR1Control.set(SpeedR * PercentSpeed);
        Robot.robotmap.MotorR2Control.set(SpeedR * PercentSpeed);
        System.out.println("Motor L1 : "+Robot.robotmap.MotorL1Control.getBusVoltage() +"   Motor L2 : "+Robot.robotmap.MotorL2Control.getBusVoltage()+"   Motor L2 : "+Robot.robotmap.MotorL2Control.getBusVoltage()+"   Motor R1 : "+Robot.robotmap.MotorR2Control.getBusVoltage()+"   Motor R2 : "+Robot.robotmap.MotorR1Control.getBusVoltage());

    }

    public void ArcadeDrive(double DrivForward, double DriveTurn) {

        double LeftSide;
        double RightSide;

        if (DrivForward > 0) {
            LeftSide = DrivForward + DriveTurn;
            RightSide = DrivForward - DriveTurn;
        } else {
            LeftSide = DrivForward - DriveTurn;
            RightSide = DrivForward + DriveTurn;
        }

        Robot.robotmap.MotorL1Control.set(-LeftSide * 0.4);
        Robot.robotmap.MotorL2Control.set(-LeftSide * 0.4);
        Robot.robotmap.MotorR1Control.set(RightSide * 0.4);
        Robot.robotmap.MotorR2Control.set(RightSide * 0.4);
        //System.out.println("Arcade drive is activated");

    }


}
