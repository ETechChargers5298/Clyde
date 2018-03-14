package org.usfirst.frc.team5298.robot.commands;
import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class MoveLinear extends PIDCommand {
	private double angle, mecanumConversionFactor;
	private long displacement;
	
	public MoveLinear(double kP, double kI, double kD, long displacement) {
		super(kP, kI, kD);
		requires(Robot.Drivetrain);
		requires(Robot.Navigator);
		this.displacement = displacement;

		this.mecanumConversionFactor = 1/Math.sqrt(2.0);
	}

	protected void initialize() {
		this.angle = Robot.Navigator.getAngle();
		Robot.Navigator.enableLidar();
		
		// Account for the initial sensor distance.
		this.displacement += Robot.Navigator.getDisplacement();

		setInputRange(1,300);
		getPIDController().setAbsoluteTolerance(5);
		getPIDController().setOutputRange(-1,1);
		setSetpoint(this.displacement);
	}

	protected void execute() {
	} 

	// Override this in the CommandGroup
	protected double returnPIDInput() {
		return angle;
		// return (double) Robot.Drivetrain.getDisplacement("motorName");
		// return (double) Robot.Navigator.getDisplacement();
	}

	protected void usePIDOutput(double output) {
		Robot.Drivetrain.drive(output, 0.0, 0.25 * (this.angle - Robot.Navigator.getAngle()));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		getPIDController().disable();
		Robot.Drivetrain.stop();
		Robot.Navigator.disableLidar();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}