package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Drivetrain extends Subsystem {
	
	private static Talon frontRightMotor;
	private static Talon frontLeftMotor;
	private static Talon rearRightMotor;
	private static Talon rearLeftMotor;
	
	private double frontLeftSpeed;
	private double frontRightSpeed;
	private double rearLeftSpeed;
	private double rearRightSpeed;
	private double norm;
	
	private boolean isAbsolute;
	
	private double linear;
	private double strafe;
	private double rotate;
	private double angular;
	
	public static ADXRS450_Gyro gyro;

	public Drivetrain() {
		frontLeftMotor = new Talon(1);
		rearLeftMotor = new Talon(2);
		frontRightMotor = new Talon(3);
		rearRightMotor = new Talon(4);
		
		frontRightMotor.setInverted(true);
		rearRightMotor.setInverted(true);
		
		gyro = new ADXRS450_Gyro();
		
		gyro.reset();
	}
	
	public void calculateVelocities(double linear, double strafe, double rotate) {
		norm = linear + rotate + strafe;

		if(norm < 1.0) {
			norm = 1.0;
		}
		
		frontLeftSpeed = (linear + rotate + strafe)/norm;
		frontRightSpeed = (linear - rotate - strafe)/norm;
		rearLeftSpeed = (linear - rotate + strafe)/norm;
		rearRightSpeed = (linear + rotate - strafe)/norm;
		
		
	}
	
	public void moveRobot() {
		frontLeftMotor.set(Math.pow(frontLeftSpeed, 3));
		rearLeftMotor.set(Math.pow(rearLeftSpeed, 3));
		frontRightMotor.set(Math.pow(frontRightSpeed, 3));
		rearRightMotor.set(Math.pow(rearRightSpeed, 3));	
	}
	
	public void drive(double linearJoystick, double strafeJoystick, double rotateJoystick) {
		calculateVelocities(linearJoystick, strafeJoystick, rotateJoystick);
		moveRobot();
	}
	
	public void moveLinear()
	{
		
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}
}