/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IndexSub extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private boolean IndexTriggered = Robot.indexInitLST;
    private boolean IndexEnded = Robot.indexEndLST;
    private int IndexCase;

    public IndexSub() {

    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void index() {

        //Neither limit switch is triggered
        if (IndexTriggered == false && IndexEnded == false)
            IndexCase = 0;
            //Only the initial limit switch is triggered
        else if (IndexTriggered == true && IndexEnded == false)
            IndexCase = 1;
            //Only the ending limit switch is triggered
        else if (IndexTriggered == false && IndexEnded == true)
            IndexCase = 2;
            //Both limit switches are triggered
        else
            IndexCase = 3;

        switch (IndexCase) {

            case 0:
                Robot.robotmap.indexCtrl.set(0);

                break;

            case 1:
                Robot.robotmap.indexCtrl.set(-.5);
                Timer.delay(0.1);

                break;

            case 2:
                Robot.robotmap.indexCtrl.set(0);

                break;

            case 3:
                Robot.robotmap.indexCtrl.set(0);

                break;

        }

    }

    public void indexRun(double x) {

        Robot.robotmap.indexCtrl.set(x);

    }


}
