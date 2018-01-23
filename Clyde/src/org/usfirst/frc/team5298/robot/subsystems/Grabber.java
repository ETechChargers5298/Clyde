package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabber;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
	private Spark leftGrabberMotor;
	private Spark rightGrabberMotor;
	private Spark grabberActuator;
	
	public Grabber() {
		leftGrabberMotor = new Spark(1);
		leftGrabberMotor.setInverted(false);
		
		rightGrabberMotor = new Spark(2);
		rightGrabberMotor.setInverted(true);
		
		grabberActuator = new Spark(3);
		grabberActuator.setInverted(false);
	 }
	
	public void setGrabberMotors(double speed) {
		leftGrabberMotor.set(speed);
		rightGrabberMotor.set(speed);
	}
	
	public void setGrabberWidth(double speed) {
		grabberActuator.set(speed);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new ActivateGrabber());
	}
}