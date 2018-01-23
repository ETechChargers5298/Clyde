package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ChangeGrabberWidth extends Command {

	private double direction;
	
	public ChangeGrabberWidth(String operation) {
		if(operation == "open") {
			direction = 1.0;
		}
		
		else if(operation == "close") {
			direction = -1.0;
		}
	}
	
	protected void initialize(){
	}

	protected  void execute() {
		Robot.grabber.setGrabberWidth(direction);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	  	end();
	}
}