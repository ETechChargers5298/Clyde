package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
    private Spark leftGrabber;
    private Spark rightGrabber;
    private DoubleSolenoid dewanSolenoid;
   
   
      public Grabber() {
	    leftGrabber = new Spark(5);
	    leftGrabber.setInverted(false);
	    leftGrabber.set(0.0);
	    
	    rightGrabber = new Spark(6);
	    rightGrabber.setInverted(true);
	    rightGrabber.set(0.0);
	    
	    dewanSolenoid = new DoubleSolenoid(1, 2);
	    dewanSolenoid.set(DoubleSolenoid.Value.kOff);
	    
	 }
    
	public void setGrabberMotors(double speed) {
		leftGrabber.set(speed);
		rightGrabber.set(speed);
	}
	
	public void setDewanSolenoid(String direction) {
    	if(direction == "open") {
    		dewanSolenoid.set(DoubleSolenoid.Value.kForward);	    		
    	}
    	else if(direction == "close") {
    		dewanSolenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if(direction == "off") {
    		dewanSolenoid.set(DoubleSolenoid.Value.kOff);
    	}
		
	}
		protected void initDefaultCommand() {
		setDefaultCommand(new ActivateGrabber());
	}
}