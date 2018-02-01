package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class MoveRotate extends Command {

	private double targetAngle;
	private double speed;
	
	public static ADXRS450_Gyro gyro;
	
	public MoveRotate(double targetAngle, double speed) {
		this.targetAngle = targetAngle;
		this.speed = speed;
	}

	protected void initialize(){
	}

	protected  void execute() {
		if(gyro.getAngle() < targetAngle) {
		    Robot.drivetrain.drive(0.0, 0.0, speed);
		}
		
		else if(gyro.getAngle() > targetAngle) {
		    Robot.drivetrain.drive(0.0, 0.0, -speed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (gyro.getAngle() > targetAngle - 1.0 && gyro.getAngle() < targetAngle + 1.0);
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