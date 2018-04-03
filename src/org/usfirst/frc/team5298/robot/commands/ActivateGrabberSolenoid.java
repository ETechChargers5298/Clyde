package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

public class ActivateGrabberSolenoid extends Command {

	private boolean direction;
	
	public ActivateGrabberSolenoid() {
		requires(Robot.grabber);
		direction = false;
	}
	
	public ActivateGrabberSolenoid(boolean direction) {
		requires(Robot.grabber);
		this.direction = direction;
	}

	protected void initialize() {
		Robot.grabber.toggleGrabber();
	}

	protected void execute() { }

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() { }

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
