package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftBottom extends Command {
	
	protected void initialize(){
	}

	protected  void execute() {  
		Robot.lifter.setLifter(-0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Robot.lifter.triggerState("bottomTrigger"));
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lifter.setLifter(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	  	end();
	}
}