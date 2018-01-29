package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ActivateGrabberSolenoid extends Command {

	private String direction;
	
	public ActivateGrabberSolenoid(String direction) {
		this.direction = direction;
	}
	
	protected void initialize(){
	}

	protected  void execute() {
		Robot.grabber.setGrabberSolenoid(direction);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (!(Robot.oi.operatorPad.getRawLeftButton() || Robot.oi.operatorPad.getRawRightButton()));
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.grabber.setGrabberSolenoid("off");
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	  	end();
	}
}