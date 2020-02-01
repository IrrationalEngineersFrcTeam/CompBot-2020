/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public CANSparkMax intakeMotorControl;
  public static int intakeMotor;

  public CANSparkMax indexCtrl0;
  public static int indexM0;

  public CANSparkMax indexCtrl1;
  public static int indexM1;

 


  public RobotMap() {

    intakeMotor = 1 ;
    indexM0 = 2;
    indexM1 = 3;

    intakeMotorControl = new CANSparkMax(intakeMotor, MotorType.kBrushless);
    indexCtrl0 = new CANSparkMax(indexM0,  MotorType.kBrushless);
    indexCtrl1 = new CANSparkMax(indexM1,  MotorType.kBrushless);
    
  
  
    


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
