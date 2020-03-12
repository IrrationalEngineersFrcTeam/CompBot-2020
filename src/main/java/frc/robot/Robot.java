/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autoCommands.autoDriveForwardCommand;
import frc.robot.commandGroups.AutoMoveForward;
import frc.robot.commandGroups.ShootPowerCells;
import frc.robot.commands.visionTrackinCommand;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot { // does not actually mean TimedRobot!!!
    public static IntakeRollerSubsystem irs;
    public static IndexSub indexs;
    public static DriveSub drive_sub;
    public static ClimberSub climbersub;
    public static ShooterSub shootersub;
    public static ShooterFeederSub shooterfeedersub;
    public static IndexSub indexsub;
    public static IntakeRollerSubsystem intakesub;
    public static DigitalInput indexInitialLimitSwitch;
    public static DigitalInput indexEndingLimitSwitch;
    public static AutoMoveForward automoveforward;//commandgroups
    public static DigitalInput indexLimitSwitch;
    public static RobotMap robotmap;
    public static boolean indexInitLST;
    public static boolean indexEndLST;
    public static NetworkTableInstance inst;
    public static NetworkTable LimelightTable;
    public static NetworkTableEntry ty;
    public static NetworkTableEntry tx;
    public static NetworkTableEntry ta;
    public static NetworkTableEntry tv;
    public static NetworkTableEntry ledMode;
    public static NetworkTableEntry autonomousPos;
    public static NetworkTableEntry teleOpInit;
    public static double VaX;
    public static double VaY;
    public static double VTA;
    public static int ledInt;
    public static boolean StartTracking;
    public static visionTrackinCommand AutoVisTrack;
    public static ShootPowerCells shootPC;
    public static VisionSub visionsub;
    public static PID pid1;
    public static PID pid2;
    public static double PIDTurn;
    public static double PIDSpeed;
    public static boolean seenToBool;
    public static boolean StartShooting;
    public static OI oi; // oi must be at the end!!!
    public static CommandGroup auto;

    /*
     * Command m_autonomousCommand; SendableChooser<Command> m_chooser = new
     * SendableChooser<>();
     */

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        robotmap = new RobotMap();
        drive_sub = new DriveSub();
        intakesub = new IntakeRollerSubsystem();
        indexsub = new IndexSub();
        shootersub = new ShooterSub();
        visionsub = new VisionSub();
        shooterfeedersub = new ShooterFeederSub();
        climbersub = new ClimberSub();
        indexInitialLimitSwitch = new DigitalInput(0);
        indexEndingLimitSwitch = new DigitalInput(1);
        automoveforward = new AutoMoveForward();//CommandGroups
        inst = NetworkTableInstance.getDefault();
        LimelightTable = inst.getTable("limelight");
        tx = LimelightTable.getEntry("tx");
        ty = LimelightTable.getEntry("ty");
        ta = LimelightTable.getEntry("ta");
        tv = LimelightTable.getEntry("tv");
        autonomousPos = SmartDashboard.getEntry("autonomousPos");
        teleOpInit = SmartDashboard.getEntry("teleOpInit");
        ledInt = 0;
        AutoVisTrack = new visionTrackinCommand();
        shootPC = new ShootPowerCells();
        pid1 = new PID(0.01, 0.0, 0.0);
        pid2 = new PID(0.01, 0.0, 0.0);
		seenToBool = (tv.getDouble(0.0) == 1) ? true : false;


        // oi needs to be at the end!!!!
        oi = new OI();

        /*
         * m_chooser.setDefaultOption("Default Auto", new ExampleCommand()); //
         * chooser.addOption("My Auto", new MyAutoCommand());
         * SmartDashboard.putData("Auto mode", m_chooser);
         */
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {

        indexInitLST = indexInitialLimitSwitch.get();
        indexEndLST = indexEndingLimitSwitch.get();
        //System.out.println(indexInitLST);
        
        //Default Red Blue balances of the limelight are 1200 and 1975 respectivly
        VaX = tx.getDouble(0.0);
        VaY = ty.getDouble(0.0);
        VTA = ta.getDouble(0.0);
        StartTracking = oi.visionTracking.get();
        StartShooting = oi.ShootPowerCells.get();


        PIDTurn = Robot.visionsub.VisionTurn(Robot.VaX);
        //the first double is the distance you want to be from the vision target
        PIDSpeed = Robot.visionsub.AdjustRoboDistance(180, Robot.visionsub.CurrentRoboDistance(VaY, 2.0, 23.75));
        //System.out.println(Robot.visionsub.AdjustRoboDistance(180, Robot.visionsub.CurrentRoboDistance(VaY, 2.0, 23.75)) / 12);

        
        SmartDashboard.putNumber("dist", Robot.visionsub.CurrentRoboDistance(Robot.VaY, 30, 30));
        SmartDashboard.putNumber("LimelightX", VaX);
        SmartDashboard.putNumber("LimelightY", VaY);
        SmartDashboard.putNumber("LimelightArea", VTA);


    }

    /**
     * This function is called once each time the robot enters Disabled mode. You
     * can use it to reset any subsystem information you want to clear when the
     * robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable chooser
     * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
     * remove all of the chooser code and uncomment the getString code to get the
     * auto name from the text box below the Gyro
     *
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons to
     * the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {


         char autoPosChar = autonomousPos.getString("F").charAt(0);//This code is currently not working because no NetworkTables entry for the autoChar string have been made
        
        switch(autoPosChar)
         {
           case 'L': ;//calls the auto command for the left position
           AutoVisTrack.start();
           break;

           case 'M': ;//calls the auto command for the middle position
           break;

           case 'R': ;//calls the auto command for the right position
           break;

           case 'F':
           auto = new AutoMoveForward();
           auto.start();
           break;
         } 

       /* if(autoPosChar != 'F') 
            AutoVisTrack.start(); */

        // m_autonomousCommand = m_chooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
         * switch(autoSelected) { case "My Auto": autonomousCommand = new
         * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
         * ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        /*
         * if (m_autonomousCommand != null) { m_autonomousCommand.start(); }
         */
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();


    }


    @Override
    public void teleopInit() {

        AutoVisTrack.cancel();
        teleOpInit.setBoolean(true);

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        // System.out.println(Robot.oi.sticcL.getY());
        // System.out.println(Robot.oi.sticcR.getY());

    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {

    }
}
