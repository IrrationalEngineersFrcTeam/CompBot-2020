/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.autoCommands.autoDriveForwardCommand;

public class AutoMoveForward extends CommandGroup {
    /**
     * Add your docs here.
     */
    public AutoMoveForward() {

        requires(Robot.drive_sub);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        // addSequential(new Command2());
        // these will run in order.
        addSequential(new autoDriveForwardCommand(), 1);

    /* To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.
    */

    }
}
