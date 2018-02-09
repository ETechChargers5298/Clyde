package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ActivateGrabber extends Command {
	
	public ActivateGrabber() {
		requires(Robot.grabber);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		Robot.grabber.setGrabberMotors(Robot.oi.operatorPad.getRightY());
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
