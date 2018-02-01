package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class MoveLinear extends Command {

	private double originalAngle;
	private double startTime;
	private double runTime;
	private double speed;;
	
	public static ADXRS450_Gyro gyro;
	
	public MoveLinear(double runTime, double speed) {
		this.runTime = runTime;
		this.speed = speed;
	}

	protected void initialize(){
		originalAngle = gyro.getAngle();
		startTime = Timer.getFPGATimestamp();
	}

	protected void execute() {
	    Robot.drivetrain.drive(speed, 0.0, 0.0);
	    Timer.delay(0.5);
	    while(gyro.getAngle() > originalAngle + 1.0 || gyro.getAngle() < originalAngle - 1.0){
	    	Robot.drivetrain.drive(0.0, 0.0, 0.2);
	    }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Timer.getFPGATimestamp() >= startTime + runTime);
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