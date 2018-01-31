package org.usfirst.frc.team5298.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabberSolenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
 

	private Spark leftGrabberMotor;
	private Spark rightGrabberMotor;
	private DoubleSolenoid grabberSolenoid;

	public Grabber() {
	
	leftGrabberMotor = new Spark(7);
	leftGrabberMotor.setInverted(false);
	leftGrabberMotor.set(0.0);
	
	rightGrabberMotor = new Spark(8);
	rightGrabberMotor.setInverted(true);
	rightGrabberMotor.set(0.0);
	
	grabberSolenoid = new DoubleSolenoid(7,8);
	grabberSolenoid.set(DoubleSolenoid.Value.kOff);
	
	}

	public void setGrabberMotors(double speed) {
		leftGrabberMotor.set(speed);
		rightGrabberMotor.set(speed);
	}
	
		public void setGrabberSolenoid(String direction) {
			if(direction == "open") {
			grabberSolenoid.set(DoubleSolenoid.Value.kForward);
			}
			
			else if(direction == "close") {
				grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
			}
			else if(direction == "off") {
				grabberSolenoid.set(DoubleSolenoid.Value.kOff);
			}
		}
		
	protected void initDefaultCommand() {
		setDefaultCommand(new ActivateGrabberSolenoid());

	}
}