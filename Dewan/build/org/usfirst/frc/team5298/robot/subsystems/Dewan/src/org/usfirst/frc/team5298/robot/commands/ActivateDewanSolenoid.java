package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ActivateDewanSolenoid extends Command {
	
	String direction;
	
	public ActivateDewanSolenoid(String direction) {
		this.direction = direction;
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.grabber.setDewanSolenoid(direction);
	}

	protected boolean isFinished() {
		return (!(Robot.oi.operatorPad.getRawLeftButton() || Robot.oi.operatorPad.getRawRightButton()));
	}
	
	protected void end() {	
		Robot.grabber.setDewanSolenoid("off");
	}
	
	protected void interrupted() {
		end();	
	}
} 
	

