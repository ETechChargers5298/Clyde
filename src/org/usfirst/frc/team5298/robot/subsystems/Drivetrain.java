package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5298.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Drivetrain extends Subsystem {
	
	private static WPI_TalonSRX frontRightMotor;
	private static WPI_TalonSRX frontLeftMotor;
	private static WPI_TalonSRX rearRightMotor;
	private static WPI_TalonSRX rearLeftMotor;
	
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
		frontLeftMotor = new WPI_TalonSRX(1);
		frontLeftMotor.setInverted(false);
		frontLeftMotor.set(0.0);
		
		rearLeftMotor = new WPI_TalonSRX(2);
		rearLeftMotor.setInverted(false);
		rearLeftMotor.set(0.0);
		
		rearRightMotor = new WPI_TalonSRX(0);
		rearRightMotor.setInverted(true);
		rearRightMotor.set(0.0);
		
		frontRightMotor = new WPI_TalonSRX(3);
		frontRightMotor.setInverted(true);
		frontRightMotor.set(0.0);
		
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

	
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}

	public void stop() {
		
	}

	public void resetEncoders() {
		// TODO Auto-generated method stub
		
	}
}