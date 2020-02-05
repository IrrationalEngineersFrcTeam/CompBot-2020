/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //This is where you create the motor controller, or anything else that needs to be made for robotmap
  public CANSparkMax intakeMotorControl;
  public CANSparkMax indexCtrl0;
  public CANSparkMax indexCtrl1;
  public CANSparkMax shootCtrl;

  //This is where you create the motor ID, for CAN or PWM
  public static int intakeMotor;
  public static int indexM0;
  public static int indexM1;
  public static int shootMotor; //<--- fun to say

  public static int MotorL1;
  public static int MotorL2;
  public static int MotorR1;
  public static int MotorR2;

  public CANSparkMax MotorL1Control;
  public CANSparkMax MotorL2Control;
  public CANSparkMax MotorR1Control;
  public CANSparkMax MotorR2Control;


  public RobotMap() {


    //This is where you give the motor ID it's value
    intakeMotor = 1 ;
    indexM0 = 2;
    indexM1 = 3;
    shootMotor = 4;

    MotorL1 = 5;
    MotorL2 = 6;
    MotorR1 = 7;
    MotorR2 = 8;

    //This is where you give the motor controller it's CAN ID and type
    intakeMotorControl = new CANSparkMax(intakeMotor, MotorType.kBrushless);
    indexCtrl0 = new CANSparkMax(indexM0,  MotorType.kBrushless);
    indexCtrl1 = new CANSparkMax(indexM1,  MotorType.kBrushless);
    shootCtrl = new CANSparkMax(shootMotor, MotorType.kBrushless);
                              
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
