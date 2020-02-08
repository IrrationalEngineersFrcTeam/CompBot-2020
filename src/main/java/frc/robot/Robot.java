/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.DriveSub; 
import frc.robot.subsystems.ShooterSub;
import frc.robot.subsystems.IntakeRollerSubsystem;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot { //does not actually mean TimedRobot!!!
  public static IntakeRollerSubsystem irs;
  public static IndexSub indexs;
  public static DriveSub drive_sub;
  public static ShooterSub shootersub;
  public static IndexSub indexsub;
  public static IntakeRollerSubsystem intakesub;
  public static DigitalInput indexLimitSwitch;
  public static RobotMap robotmap;
  public static boolean indexLST;
  public static NetworkTableInstance inst;
  public static NetworkTable LimelightTable;
  public static NetworkTableEntry ty;
  public static NetworkTableEntry tx;
  public static NetworkTableEntry ta;
  public static NetworkTableEntry tv;
  public static double VaX;
  public static double VaY;
  public static double VTA;
  public static double IsSeen;
  public static boolean seenToBool;
  public static OI oi;  //oi must be at the end!!!


 /* Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
*/

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    robotmap = new RobotMap();
    drive_sub = new DriveSub();
    intakesub  = new IntakeRollerSubsystem();
    indexsub = new IndexSub();
    shootersub = new ShooterSub();
    indexLimitSwitch = new DigitalInput(0);
    inst = NetworkTableInstance.getDefault();
    LimelightTable = inst.getTable("limelight");
    tx = LimelightTable.getEntry("tx");
    ty = LimelightTable.getEntry("ty");
    ta = LimelightTable.getEntry("ta");
    tv = LimelightTable.getEntry("tv");
    //oi needs to be at the end!!!!
    oi = new OI(); 
  
    /*m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    */
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    indexLST = indexLimitSwitch.get();

    VaX = tx.getDouble(0.0);
    VaY = ty.getDouble(0.0);
    VTA = ta.getDouble(0.0);
    IsSeen = tv.getDouble(0.0);

    seenToBool = (IsSeen == 1) ? true : false;

    SmartDashboard.putNumber("LimelightX", VaX);
    SmartDashboard.putNumber("LimelightY", VaY);
    SmartDashboard.putNumber("LimelightArea", VTA);
    SmartDashboard.putBoolean("targetFound", seenToBool);

    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
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
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
  //  m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
  /*  if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
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
   
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
