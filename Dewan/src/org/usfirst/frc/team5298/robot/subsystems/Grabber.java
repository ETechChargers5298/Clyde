package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabber;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
    private Spark leftGrabber;
    private Spark rightGrabber;
    private Spark extensionMotor;
   
    public Grabber() {
	    leftGrabber = new Spark(5);
	    leftGrabber.setInverted(false);
	    leftGrabber.set(0.0);
	    
	    rightGrabber = new Spark(6);
	    rightGrabber.setInverted(true);
	    rightGrabber.set(0.0);
	    
	    extensionMotor = new Spark(7);
	    extensionMotor.setInverted(false);
	    extensionMotor.set(0.0);
	 }
    
	public void setGrabberMotors(double speed) {
		leftGrabber.set(speed);
		rightGrabber.set(speed);
	}
	
	public void setExtensionMotor(double speed) {
		extensionMotor.set(speed);		
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ActivateGrabber());
	}
}