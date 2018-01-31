package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Autonomous extends Command {
	
	public double startTime;
	public double maxTime;
	public double linearMotion;
	public double angularMotion;
	public double strafeMotion;
	private boolean finished;
	
	public Autonomous(double time, 
			double linearSpeed,
			double angularSpeed,
			double strafeSpeed) {
		
		//requires(Robot.drivetrain);
		maxTime = time;
		linearMotion = linearSpeed*0.70;
		angularMotion = angularSpeed*0.70;
		strafeMotion = strafeSpeed*0.70;
	
	}

	public void initialize() {
		// TODO Auto-generated method stub
		startTime = Timer.getFPGATimestamp();
		
	}
	
	public void execute() {
		Robot.drivetrain.drive(linearMotion, angularMotion, strafeMotion);
	}
	
	@Override
	protected boolean isFinished() {
		if(Timer.getFPGATimestamp() - startTime >= maxTime) {
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


