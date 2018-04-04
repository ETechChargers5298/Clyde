package org.usfirst.frc.team5298.robot.commands;
import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class DriveTrainMotions extends Command {

	private double originalAngle;
	private double startTime;
	private double runTime;
	private double linearVelocity;
	private double strafeVelocity;
	private double angularVelocity;
	
	
	public DriveTrainMotions(double runTime, double linear, double strafe, double angular) {
		this.runTime = runTime;
		this.linearVelocity = linear;
		this.strafeVelocity = strafe;
		this.angularVelocity = angular;
	}

	protected void initialize(){
		originalAngle = Robot.Navigator.getAngle();
		startTime = Timer.getFPGATimestamp();
	}

	protected void execute() {
	    Robot.Drivetrain.drive(linearVelocity, strafeVelocity, angularVelocity);
	    
	    Robot.Navigator.resetGyro();
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