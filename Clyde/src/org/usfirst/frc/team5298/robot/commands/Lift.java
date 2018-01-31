package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {
	public Lift( ) {
		
	}
	
	protected void initialize() {
		Robot.lift.lift(Robot.oi.operatorPad.getRightY());
	}
	
	protected void execute() {
		
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	end();
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
} 
