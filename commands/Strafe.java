package org.usfirst.frc.team5298.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Strafe extends Command{
	
	private double speed;
	private double startTime;
	private double runTime;
	
	public Strafe(double runTime, double speed) {
		this.runTime = runTime;
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
    
    protected void  end() {
    }
    
    protected void interrupted() {
    	end();
    }
}
