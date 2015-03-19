/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.stuy;

import edu.stuy.Gamepad;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Michael1 extends SimpleRobot {
    Gamepad gamepad;
    RobotDrive drivetrain;
    
    Acquirer acquirer;
    Shooter shooter;
    Paddle paddle;
    
    // USB PORTS
    static final int GAMEPAD_PORT = 1;
    
    // PWM OUTPUTS
    static final int DRIVE_LEFT_CHANNEL = 1;
    static final int DRIVE_RIGHT_CHANNEL = 2;
    static final int ACQUIRER_MOTOR_CHANNEL = 3;
    static final int SHOOTER_MOTOR_CHANNEL = 4;
    static final int PADDLE_SERVO_CHANNEL = 5;
    
    public Michael1() {
        gamepad = new Gamepad(GAMEPAD_PORT);
        drivetrain = new RobotDrive(DRIVE_LEFT_CHANNEL, DRIVE_RIGHT_CHANNEL);
        acquirer = new Acquirer();
        shooter = new Shooter();
        paddle = new Paddle();
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        acquirer.acquire();
        drivetrain.setLeftRightMotorOutputs(.5, .5);
        Timer.delay(5);
        drivetrain.setLeftRightMotorOutputs(0, 0);
        acquirer.stop();
        Timer.delay(1);
        drivetrain.setLeftRightMotorOutputs(-.5, -.5);
        Timer.delay(2);
        drivetrain.setLeftRightMotorOutputs(0, 0);
        shooter.shoot();
        Timer.delay(3);
        shooter.stop();
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            double left = gamepad.getLeftY();
            double right = gamepad.getRightY();
            drivetrain.tankDrive(-left, -right);
            
            if (gamepad.getLeftTrigger() || gamepad.getRightTrigger()) {
                acquirer.acquire();
            } else {
                acquirer.stop();
            }

            if (gamepad.getLeftBumper() || gamepad.getRightBumper()) {
                shooter.shoot();
            } else {
                shooter.stop();
            }

            if (gamepad.getDPadDown() || gamepad.getDPadUp() || gamepad.getDPadLeft() || gamepad.getDPadRight()) {
                paddle.front();
            } else {
                paddle.back();
            }
        }
    }
}