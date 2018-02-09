package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ActivateSolenoid extends Command {
	
	String direction;
	
	public ActivateSolenoid(String direction) {
		this.direction = direction;
	}
	
	protected void intilize() {
	}
	
	protected void execute() {
		Robot.grabber.setActivateSolenoid(direction);
	}
	
	protected boolean isFinished() {
		return (!(Robot.oi.operatorPad.getRawLeftButton() || Robot.oi.operatorPad.getRawRightButton()));
	}
	
	protected void end() {
		Robot.grabber.setActivateSolenoid("off");
	}
	
	protected void intterrupted() {
		end();
		
	}
}
