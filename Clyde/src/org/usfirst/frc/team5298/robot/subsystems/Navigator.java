package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.Robot;
import org.usfirst.frc.team5298.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Navigator extends Subsystem {
    private static ADXRS450_Gyro gyro;
    
    private Velocity velocity;
    
    private boolean isAbsolute;

    public Navigator() {
        gyro = initializeGyro();
        velocity = new Velocity();
        isAbsolute = false;
    }

    public Navigator(boolean isAbsolute) {
        gyro = initializeGyro();
        velocity = new Velocity(0.0, 0.0, 0.0);
        this.isAbsolute = isAbsolute;
    }

    private ADXRS450_Gyro initializeGyro() {
    	gyro = new ADXRS450_Gyro();
    	gyro.reset();
    	gyro.calibrate();
		return gyro;
    }

    public void updateInputs() {
        if(isAbsolute) {
            velocity.update(
                Robot.oi.driverPad.getLeftY(),
                Robot.oi.driverPad.getLeftX(),
                Robot.oi.driverPad.getRightX(),
                gyro.getAngle()
            );
        }
        else {
            velocity.update(
                Robot.oi.driverPad.getLeftY(),
                Robot.oi.driverPad.getLeftX(),
                Robot.oi.driverPad.getRightX()
            );
        }
    }

    public boolean isRotationFinished(double targetAngle) {
        return ((gyro.getAngle() < targetAngle + 0.2) || (gyro.getAngle() > targetAngle - 0.2));
    }

    public Velocity getCalculatedVelocities() { return velocity; }

    public void useAbsoluteMovement() { isAbsolute = true; }

    public void useRelativeMovement() { isAbsolute = false; }

    public void toggleMovementType() { isAbsolute = !isAbsolute; }

    public double getCurrentAngle() { return gyro.getAngle(); }

    public void resetAngle() { gyro.reset(); }
    
    public double getCurrentRotation() { return gyro.getRate(); }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}