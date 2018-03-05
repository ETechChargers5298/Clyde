package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Drivetrain extends Subsystem {
	private static HashMap<String, WPI_TalonSRX> motors;

	private double frontLeftSpeed, rearLeftSpeed, rearRightSpeed, frontRightSpeed;

	// Public Methods
	public Drivetrain() {
		motors = new HashMap<String, WPI_TalonSRX>();

		// We can give each motor object a name.
		motors.put("front_left",	new WPI_TalonSRX(2));
		motors.put("rear_left",		new WPI_TalonSRX(3));
		motors.put("rear_right",	new WPI_TalonSRX(1));
		motors.put("front_right",	new WPI_TalonSRX(0))

		// And we can get each motor object by it's name.
		motors.get("rear_right").setInverted(true);
		motors.get("front_right").setInverted(true);
		
		// Create an iterator to get each motor in the hash map.
		Iterator iterator = motors.entrySet().iterator();

		// Set each motor to neutral/brake.
		while(iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			entry.getValue().set(0.0);
		}
	}

	public void drive(double linearJoystick, double strafeJoystick, double rotateJoystick) {
		calculateVelocities(linearJoystick, strafeJoystick, rotateJoystick);
		moveRobot();
	}
	
	public double getDisplacement(String motorName) {
		return (double) motors.get(motorName).getSelectedSensorPosition();
	}

	public void resetEncoders() {
		Iterator iterator = motors.entrySet().iterator();

		// Reset each encoder.
		while(iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			entry.getValue().setSelectedSensorPosition(0, 0, 0);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new Drive());
	}

	// Private Methods
	private void calculateVelocities(double linear, double strafe, double rotate) {
		double maxSpeed = Math.min(1.0, linear + Math.abs(strafe) + Math.abs(rotate));
		
		frontLeftSpeed = (linear + strafe + rotate)/maxSpeed;
		rearLeftSpeed = (linear - strafe + rotate)/maxSpeed;
		rearRightSpeed = (linear + strafe - rotate)/maxSpeed;
		frontRightSpeed = (linear - strafe - rotate)/maxSpeed;
	}
	
	private void moveRobot() {
		motors.get("front_left").set(frontLeftSpeed);
		motors.get("rear_left").set(rearLeftSpeed);
		motors.get("rear_right").set(rearRightSpeed);
		motors.get("front_right").set(frontRightSpeed);	
	}
}