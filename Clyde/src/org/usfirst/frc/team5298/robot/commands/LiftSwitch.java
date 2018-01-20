package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftSwitch extends Command {

	private int currentLifterPosition;
	private int newLifterPosition;
	private int switchPosition;
	
	public LiftSwitch(){
		switchPosition = 2;
	}
	
	protected void initialize(){
	}

	protected  void execute() {
		currentLifterPosition = Robot.lifter.getCurrentPosition();
		
		if(currentLifterPosition < switchPosition) {
			Robot.lifter.setLifter(0.5);
		}
		
		else if(currentLifterPosition > switchPosition) {
			Robot.lifter.setLifter(-0.5);
		}
		
		newLifterPosition = Robot.lifter.getCurrentPosition();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (newLifterPosition == switchPosition);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lifter.setLifter(0.0);
		Robot.lifter.setNewLifterPosition(newLifterPosition);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	  	end();
	}
}