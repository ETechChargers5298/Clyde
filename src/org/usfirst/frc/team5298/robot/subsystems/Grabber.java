package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Grabber extends Subsystem {
	
	private Spark LeftGrabber;
	private Spark RightGrabber;
	
	public Grabber() {
		LeftGrabber = new Spark(6);
		RightGrabber = new Spark(7);
	 }
	
	public void GrabberSet(double speed) {
		//Set Grabber speeds
		LeftGrabber.set(speed);
		RightGrabber.set(-speed);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}