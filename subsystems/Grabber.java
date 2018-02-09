package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabber;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
	private Spark leftGrabberMotor;
	private Spark rightGrabberMotor;
	private DoubleSolenoid ActivateSolenoid;
	
	public Grabber() {
		leftGrabberMotor = new Spark(1);
		leftGrabberMotor.setInverted(false);
		leftGrabberMotor.set(0.0);
		
		rightGrabberMotor = new Spark(2);
		rightGrabberMotor.setInverted(true);
		rightGrabberMotor.set(0.0);
		
		ActivateSolenoid = new DoubleSolenoid(1, 2);
		ActivateSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public void setGrabberMotors(double speed) {
		leftGrabberMotor.set(speed);
		rightGrabberMotor.set(speed);
	}
	
	public void ActivateSolenoidl(String direction) {
		if(direction == "open") {
			ActivateSolenoid.set(DoubleSolenoid.Value.kForward);
	   }
		else if(direction == "close") {
			ActivateSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
		
		else if(direction == "off") {
			ActivateSolenoid.set(DoubleSolenoid.Value.kOff);
		}
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ActivateGrabber());
	}

	public void setActivateSolenoid(String direction) {
		// TODO Auto-generated method stub
		
	}
}