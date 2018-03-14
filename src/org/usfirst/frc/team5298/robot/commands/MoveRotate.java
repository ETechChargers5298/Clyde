package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class MoveRotate extends PIDCommand {
	private double angle;
	
	public MoveRotate(double kP, double kI, double kD, double angle) {
		super(kP,kI,kD);
		requires(Robot.Drivetrain);
		requires(Robot.Navigator);
		this.angle = angle;
	}

	protected void initialize() {
		setInputRange(1, 300);
		getPIDController().setAbsoluteTolerance(5);
		getPIDController().setOutputRange(-1, 1);
		setSetpoint(this.angle);
	}

	protected void execute() {
		
	}

	protected double returnPIDInput() {
		return Robot.Navigator.getAngle();
	}

	protected void usePIDOutput(double output) {
		Robot.Drivetrain.drive(0.0, 0.0, output);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		getPIDController().disable();
		Robot.Drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}