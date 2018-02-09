package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	public static WPI_TalonSRX frontLeftMotor, rearLeftMotor, rearRightMotor, frontRightMotor;
	
	private double frontLeftSpeed, rearLeftSpeed, rearRightSpeed, frontRightSpeed;
	private double maxSpeed;
	
	public Drivetrain() {
		frontLeftMotor = new WPI_TalonSRX(2);
		frontLeftMotor.setInverted(false);
		frontLeftMotor.set(0.0);
		
		rearLeftMotor = new WPI_TalonSRX(3);
		rearLeftMotor.setInverted(false);
		rearLeftMotor.set(0.0);
		
		rearRightMotor = new WPI_TalonSRX(1);
		rearRightMotor.setInverted(true);
		rearRightMotor.set(0.0);
		
		frontRightMotor = new WPI_TalonSRX(4);
		frontRightMotor.setInverted(true);
		frontRightMotor.set(0.0);
	}
	
	public void calculateVelocities(double linear, double strafe, double rotate) {
		maxSpeed = linear + Math.abs(strafe) + Math.abs(rotate);
		
		if(maxSpeed < 1.0) {
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
	
	 protected void initDefaultCommand() {
		 setDefaultCommand(new Drive());
	}
}
