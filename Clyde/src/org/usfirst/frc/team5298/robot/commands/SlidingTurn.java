package org.usfirst.frc.team5298.robot.commands;
import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SlidingTurn extends PIDCommand {
	private double angle, mecanumConversionFactor;
	private long displacement;
	
	public SlidingTurn(double kP, double kI, double kD, double angle, long displacement) {
		super(kP, kI, kD);
		requires(Robot.Drivetrain);
		requires(Robot.Navigator);

        this.angle = angle;
		this.displacement = displacement;
	}

	protected void initialize() {
		this.angle = Robot.Navigator.getAngle();
        Robot.Drivetrain.resetEncoders();

		setInputRange(/**/);
		getPIDController.setAbsoluteTolerance(/**/);
		getPIDController.setOutputRange(/**/);
		setSetpoint(this.displacement);
	}

	protected void execute() {
	} 

	protected double returnPIDInput() {
		// return (double) Robot.Drivetrain.getDisplacement("motorName");
		// return (double) Robot.Navigator.getDisplacement();
	}

	protected void usePIDOutput(double output) {
        double currentAngle = Robot.Navigator.getAngle();
        
		Robot.drivetrain.drive(
            Math.cos(Math.toRadians(currentAngle)),
            Math.sin(Math.toRadians(currentAngle)),
            0.25 * (this.angle - currentAngle)
        );
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