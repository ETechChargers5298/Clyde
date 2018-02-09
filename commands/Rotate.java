package org.usfirst.frc.team5298.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command {
	
	private double speed;
	private double angle;
	
	public Rotate(double angle, double speed) {
		this.angle = angle;
		this.speed = speed;
	}

	protected void initialize() {
	}
	
	protected void execute() {
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
		end();
	}
}
