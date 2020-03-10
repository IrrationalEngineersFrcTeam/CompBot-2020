/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commandGroups.ShootPowerCells;
import frc.robot.commands.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //This is the place where you create joysticks
    public Joystick sticcL;
    public Joystick sticcR;

    //This is the place where you create buttons
    public Button intakeButton;
    public Button triggerShoot;
    public Button indexRunIn;
    public Button indexRunOut;
    public Button climbButton;
    public Button climbDownButton;
    public Button visionTracking;
    public Button ShootPowerCells;


    public OI() {

        //This is where you initialize the joysticks
        sticcL = new Joystick(0);
        sticcR = new Joystick(1);

        //This is where you initialize the buttons
        intakeButton = new JoystickButton(sticcL, 2);
        triggerShoot = new JoystickButton(sticcL, 1);
        indexRunIn = new JoystickButton(sticcR, 2);
        indexRunOut = new JoystickButton(sticcR, 8);
        visionTracking = new JoystickButton(sticcR, 1);
        climbButton = new JoystickButton(sticcL, 5);//Change to an appropriate button later
        climbDownButton = new JoystickButton(sticcL, 10);

        ShootPowerCells = new JoystickButton(sticcR, 5);//Change to appropriate button later

        //This is where you give the button it's functionality
        intakeButton.whileHeld(new intakeRollerCommand());
        triggerShoot.whileHeld(new shootCommand());
        indexRunIn.whileHeld(new indexInCommand());
        indexRunOut.whileHeld(new indexOutCommand());
        climbButton.whileHeld(new climbUpCommand());
        climbDownButton.whileHeld(new climbDownCommand());

        //Command Groups
        ShootPowerCells.whileHeld(new ShootPowerCells());//We may change the type of trigger this is later, for now this button is for testing


    }

  
  /*CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggerShoots and bind those to
  // commands the same as any other Button.

  //// triggerShootING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand()); 
  */

}
