package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class GrabberAuto extends Command {
	
	private double startTime;
	private double runTime;
	private Boolean position;
	
	public GrabberAuto(double runTime, Boolean position) {
		this.runTime = runTime;
		this.position = position;
	}

	protected void initialize(){
		startTime = Timer.getFPGATimestamp();
		position = true;
		
	}

	protected void execute() {
	    Robot.grabber.setGrabber(position);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Timer.getFPGATimestamp() >= startTime + runTime);
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
