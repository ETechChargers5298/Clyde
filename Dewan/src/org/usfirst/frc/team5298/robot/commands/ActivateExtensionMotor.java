package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ActivateExtensionMotor extends Command {
	
	String direction;
	
	public ActivateExtensionMotor(String direction) {
		this.direction = direction;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		if(direction == "open") {
			Robot.grabber.setExtensionMotor(1.0);
		}
		
		else if(direction == "close") {
			Robot.grabber.setExtensionMotor(-1.0);
		}
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {	
	}
	
	protected void interrupted() {
		end();	
	}
}