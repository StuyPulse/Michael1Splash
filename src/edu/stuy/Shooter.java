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
public class Shooter {
    private Victor shooter;
    
    public Shooter() {
        shooter = new Victor(Michael1.SHOOTER_MOTOR_CHANNEL);
    }
    
    public void shoot() {
        shooter.set(.5);
    }
    
    public void stop() {
        shooter.set(0);
    }
}
