package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command {
	
	public double startTime;
	public double maxTime;
	private boolean finished;
	
	public Wait(double time) {
		requires(Robot.drivetrain);
		maxTime = time;
	}
	
	public void initialize() {
		startTime = Timer.getFPGATimestamp();
	}
	
	public void execute() {
    	//Robot.drivetrain.mecanumDrive_Cartesian(0, 0, 0, Robot.drivetrain());
    	//x, rotation, y, gyro. This is the order. Don't ask...
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (Timer.getFPGATimestamp() - startTime >= maxTime) {
			finished = true;
		}
		return finished;
	}

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }	
}