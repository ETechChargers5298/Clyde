package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends Subsystem {
	
	private static WPI_TalonSRX frontLeftMotor, rearLeftMotor, rearRightMotor, frontRightMotor;
	Encoder frontLeftEncoder, rearLeftEncoder, rearRightEncoder, frontRightEncoder;
	
	private double frontLeftSpeed, rearLeftSpeed, rearRightSpeed, frontRightSpeed;
	private double maxSpeed;
	
	public static ADXRS450_Gyro gyro;

	public Drivetrain() {
		frontLeftMotor = new WPI_TalonSRX(2);
		frontLeftMotor.setInverted(false);
		frontLeftMotor.set(0.0);
		frontLeftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		
		rearLeftMotor = new WPI_TalonSRX(3);
		rearLeftMotor.setInverted(false);
		rearLeftMotor.set(0.0);
		rearLeftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		
		rearRightMotor = new WPI_TalonSRX(1);
		rearRightMotor.setInverted(true);
		rearRightMotor.set(0.0);
		rearRightEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
		
		frontRightMotor = new WPI_TalonSRX(0);
		frontRightMotor.setInverted(true);
		frontRightMotor.set(0.0);
		frontRightEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
		
		gyro = new ADXRS450_Gyro();
		gyro.reset();
	}
	
	public void calculateVelocities(double linear, double strafe, double rotate) {
		maxSpeed = linear + Math.abs(strafe) + Math.abs(rotate);
		
		if(maxSpeed < 1.0){
			maxSpeed = 1.0;
		}

		frontLeftSpeed = (linear + strafe + rotate)/maxSpeed;
		rearLeftSpeed = (linear - strafe + rotate)/maxSpeed;
		rearRightSpeed = (linear + strafe - rotate)/maxSpeed;
		frontRightSpeed = (linear - strafe - rotate)/maxSpeed;
	}
	
	public void moveRobot() {
		frontLeftMotor.set(frontLeftSpeed);
		rearLeftMotor.set(rearLeftSpeed);
		rearRightMotor.set(rearRightSpeed);
		frontRightMotor.set(frontRightSpeed);	
	}
	
	public void drive(double linearJoystick, double strafeJoystick, double rotateJoystick) {
		calculateVelocities(linearJoystick, strafeJoystick, rotateJoystick);
		moveRobot();
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());
	}
}