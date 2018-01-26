package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.Drive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private static Talon frontLeftMotor, rearLeftMotor, rearRightMotor, frontRightMotor;
	
	private double frontLeftSpeed, rearLeftSpeed, rearRightSpeed, frontRightSpeed;
	private double maxSpeed;
	
	public Drivetrain() {
		frontLeftMotor = new Talon(1);
		frontLeftMotor.setInverted(false);
		frontLeftMotor.set(0.0);
		
		rearLeftMotor = new Talon(4);
		rearLeftMotor.setInverted(false);
		rearLeftMotor.set(0.0);
		
		rearRightMotor = new Talon(3);
		rearRightMotor.setInverted(true);
		rearRightMotor.set(0.0);
		
		frontRightMotor = new Talon(2);
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