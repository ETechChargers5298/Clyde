package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LiftOpen extends Command {

	
	public LiftOpen() 
	{		
		requires(Robot.grabber);
	}


	protected void initialize() {
	}

	protected void execute() {
		Robot.Lifter.LifterSet(1);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
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