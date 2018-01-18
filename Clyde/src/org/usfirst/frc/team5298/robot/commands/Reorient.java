package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;


public class Reorient extends Command {

	public static ADXRS450_Gyro gyro;
	
	protected void initialize(){
	}

	protected  void execute() {
	    Robot.drivetrain.drive(0.0, 0.0, 0.2);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (gyro.getAngle() < 0.5 && gyro.getAngle() > -0.5);
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}