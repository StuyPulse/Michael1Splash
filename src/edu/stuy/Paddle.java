/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy;

import edu.wpi.first.wpilibj.Servo;

/**
 *
 * @author kevin
 */
public class Paddle {
    private Servo paddle;
    
    public Paddle() {
        paddle = new Servo(Michael1.PADDLE_SERVO_CHANNEL);
    }
    
    public void back() {
        paddle.set(0);
    }
    
    public void front() {
        paddle.set(1);
    }
}
