/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stuy;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author kevin
 */
public class Acquirer {
    private Victor acquirerMotor;
    
    public Acquirer() {
        acquirerMotor = new Victor(Michael1.ACQUIRER_MOTOR_CHANNEL);
    }
    
    public void acquire() {
        acquirerMotor.set(.5);
    }
    
    public void stop() {
        acquirerMotor.set(0);
    }
}
