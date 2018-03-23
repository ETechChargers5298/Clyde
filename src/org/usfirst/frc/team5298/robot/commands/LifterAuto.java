package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LifterAuto extends Command {
	
	
	private double startTime;
	private double runTime;
	private double speed;
	
	public LifterAuto(double runTime, double speed) {
		this.runTime = runTime;
		this.speed = speed;
	}

	protected void initialize(){
		startTime = Timer.getFPGATimestamp();		
	}

	protected void execute() {
	    Robot.Lifter.LifterSet(speed);
	    
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Timer.getFPGATimestamp() >= startTime + runTime);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.Lifter.LifterStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
