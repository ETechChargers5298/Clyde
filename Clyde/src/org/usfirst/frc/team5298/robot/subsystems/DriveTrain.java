package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

@SuppressWarnings("deprecation")
public class DriveTrain extends Subsystem {
	
	private static Talon frontLeftMotor, frontRightMotor, rearLeftMotor, rearRightMotor;

	private static ADXRS450_Gyro gyro;
	
	private double frontLeftSpeed, frontRightSpeed, rearLeftSpeed, rearRightSpeed;
	private double linearWeight, angularWeight, strafeWeight;
	private double theta;
	
	private double norm;
	
	private boolean absoluteMovement;
	
	public DriveTrain(byte[] pins) {
		initialize(pins);
	}

	public DriveTrain(byte[] pins, double[] weights) {
		initialize(pins);

		linearWeight = weights[0];
		angularWeight = weights[1];
		strafeWeight = weights[2];
	}

	private void initialize(byte[] pins) {
		frontLeftMotor = new Talon(pins[0]);
		frontLeftSpeed = 0.0;

		frontRightMotor = new Talon(pins[2]);
		frontRightSpeed = 0.0;

		rearLeftMotor = new Talon(pins[1]);
		rearLeftSpeed = 0.0;  

		rearRightMotor = new Talon(pins[3]);
		rearRightSpeed = 0.0;

		frontRightMotor.setInverted(true);
		rearRightMotor.setInverted(true);
	}

	/*	Definition breakdown:
		linear 	velocity: Robot forward/backward speed.
		angular velocity: Robot rotation speed.
		strafe 	velocity: Robot side-to-side movement.
		Combining all 3 velocities leads to very interesting movements. For example:
		
		Example 1:
			angularVelocity makes the robot turn in-place.
			linearVelocity + angularVelocity makes the robot turn while moving (in an arc).
		
		Example 2:
			strafeVelocity makes the robot move left or right.
			linearVelocity + strafeVelocity makes the robot move diagonally.
	*/
	private void calculateMotorVelocities(double linear, double angular, double strafe) {
		norm = linear + Math.abs(angular) + Math.abs(strafe);

		frontLeftSpeed = (linear + angular + strafe)/norm;
		frontRightSpeed = (linear - angular - strafe)/norm;
		rearLeftSpeed = (linear + angular - strafe)/norm;
		rearRightSpeed = (linear - angular + strafe)/norm;
	}

	private void moveRobot() {
		frontLeftMotor.set(frontLeftSpeed);
		frontRightMotor.set(frontRightSpeed);
		rearLeftMotor.set(rearLeftSpeed);
		rearRightMotor.set(rearRightSpeed);
	}

	// Use drive() when directly controlling the robot using the controller.
	// Supports absolute & relative movement.
	// Absolute movement mode should only be used when trying to line the robot up with an object.
	public void drive(Velocity velocity) {
		calculateMotorVelocities(
			velocity.linear(),
			velocity.angular(),
			velocity.strafe()
		);

		moveRobot();
	}

	public void drive(double linearMotion, double angularMotion, double strafeMotion) {
		calculateMotorVelocities(
			linearMotion,
			angularMotion,
			strafeMotion
		);
		moveRobot();
	}

	// Use move(), rotate(), strafe(), and stop() for simple autonomous subroutines.
	public void move(double speed) {
		calculateMotorVelocities(speed, 0.0, 0.0);
		moveRobot();
	}

	public void rotate(double speed) {
		calculateMotorVelocities(0.0, speed, 0.0);
		moveRobot();
	}

	public void strafe(double speed) {
		calculateMotorVelocities(0.0, 0.0, speed);
		moveRobot();
	}

	public void stop() {
		frontLeftSpeed = 0.0;
		frontRightSpeed = 0.0;
		rearLeftSpeed = 0.0;
		rearRightSpeed = 0.0;

		moveRobot();
	}
	
	// Use setAbsolute
	

	// Assign a button on the controller to toggle between Absolute and Relative movement types.
	// Relative movement means the Robot will go forward/strafe in the direction it is currently facing.
	// Absolute movement means the Robot will strafe in the direction it was facing when first powered on.
	public void toggleMovementType() {
		absoluteMovement = !absoluteMovement;
	}

	public boolean isRotationFinished(double targetAngle) {
		return ((getCurrentAngle() < targetAngle + 0.2) || (getCurrentAngle() > targetAngle - 0.2));
	}

	public double getCurrentAngle() {
		return gyro.getAngle();
	}

	public void resetAngle() {
		gyro.reset();
	}
	
	public double getCurrentRotation() {
		return gyro.getRate();
	}


	protected void initDefaultCommand() {
		
	}

}
