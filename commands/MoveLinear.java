package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class MoveLinear extends Command {
	
	private double speed;
	private double startTime;
	private double runTime;
	
	public MoveLinear(double speed, double runTime) {
		this.runTime = runTime;
		this.speed = speed;
	}
		
	protected void  initialize() {
	}
		
	protected void execute() {
		Robot.drivetrain.drive(speed, 0.0,  0.0);
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
