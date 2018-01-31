package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ActivateGrabberSolenoid extends Command {
	
	private String direction;
	
	public ActivateGrabberSolenoid(string direction) {
		this.direction = direction;
		
	}
	
	public void initialize() {
	}
	
	public void execute() {
		Robot.grabber.setGrabberSolenoid(direction);
		
	}
	
	protected boolean isFinished() {
		return (!(Robot.oi.operatorPad.getRawLeftButton() || Robot.oi.operatorPad.getRawRightButton()));
		
	}
}
