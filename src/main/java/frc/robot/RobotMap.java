/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.Spark;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //This is where you create the motor controller, or anything else that needs to be made for robotmap
  public CANSparkMax intakeMotorControl;
  public CANSparkMax shootCtrl;
  public CANSparkMax shooterFeederControl; //subject to change
  public Spark indexCtrl;
  public PWMSparkMax climberCtrl;

  //The drive motors
  public CANSparkMax MotorL1Control;
  public CANSparkMax MotorL2Control;
  public CANSparkMax MotorR1Control;
  public CANSparkMax MotorR2Control;

  //This is where you create the motor ID, for CAN or PWM
  public static int intakeMotor;
  public static int indexMotor;
  public static int shootMotor; //<--- fun to say
  public static int shooterFeederMotor;
  public static int climberMotor;

  public static int MotorL1;
  public static int MotorL2;
  public static int MotorR1;
  public static int MotorR2;


  public RobotMap() {


    //This is where you give the motor ID it's value
    indexMotor = 0;
    climberMotor = 1;

    intakeMotor = 3;
    shootMotor = 1;
    shooterFeederMotor = 4;

    MotorR1 = 5;
    MotorR2 = 6;
    MotorL1 = 7;
    MotorL2 = 2;

    //This is where you give the Spark motor controller it's PWM ID and type
    indexCtrl = new Spark(indexMotor);

    //2.003ms = full "forward"
    // 1.550ms = the "high end" of the deadband range
    // 1.500ms = center of the deadband range (off)
    // 1.460ms = the "low end" of the deadband range
    // 0.999ms = full "reverse"
    climberCtrl = new PWMSparkMax(climberMotor);
    
    //This is where you give the SparkMax motor controller it's CAN ID and type
    intakeMotorControl = new CANSparkMax(intakeMotor, MotorType.kBrushless);
    shootCtrl = new CANSparkMax(shootMotor, MotorType.kBrushless);
    shooterFeederControl = new CANSparkMax(shooterFeederMotor, MotorType.kBrushless);
                              
    MotorL1Control = new CANSparkMax(MotorL1 , MotorType.kBrushless);
    MotorL2Control = new CANSparkMax(MotorL2 , MotorType.kBrushless);
    MotorR1Control = new CANSparkMax(MotorR1 , MotorType.kBrushless);
    MotorR2Control = new CANSparkMax(MotorR2 , MotorType.kBrushless);
  
    


  }
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
