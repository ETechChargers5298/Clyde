package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Grabber extends Subsystem {
	
	private Spark leftGrabber;
	private Spark rightGrabber;
	
	public Grabber() {
		leftGrabber = new Spark(1);
		rightGrabber = new Spark(2);
	 }
	
	public void setGrabber(double speed) {
		//Set Grabber speeds
		leftGrabber.set(speed);
		rightGrabber.set(-speed);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}