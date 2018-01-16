package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.Robot;
import org.usfirst.frc.team5298.robot.commands.DriveTrainCommands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


@SuppressWarnings("deprecation")
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static WPI_TalonSRX frontRightmotor;
	private static WPI_TalonSRX frontLeftmotor;
	private static WPI_TalonSRX rearRightmotor;
	private static WPI_TalonSRX  rearLeftmotor;
	
	private static ADXRS450_Gyro gyro;
	
  
	double angle;
	double field;
	
	
	public static MecanumDrive robotDrive;

		public DriveTrain() {
		frontLeftmotor = new WPI_TalonSRX(1);
		rearLeftmotor = new WPI_TalonSRX(2);
		frontRightmotor = new WPI_TalonSRX(3);
		rearRightmotor = new WPI_TalonSRX(4);
		
		frontLeftmotor.setInverted(true);
		rearLeftmotor.setInverted(true);
		
		robotDrive = new MecanumDrive(frontLeftmotor, rearLeftmotor, frontRightmotor, rearRightmotor);
		
		gyro = new ADXRS450_Gyro();
		gyro.reset();
		gyro.calibrate();
		}
		
		public boolean rotate(double angle){
			
			boolean complete = false;
			
			if(gyroAngle() > angle + 0.5){
				robotDrive.driveCartesian(0, 0, -0.21, Robot.drivetrain.gyroAngle());
				complete = false;
			}
			
			else if(gyroAngle() < angle - 0.5){
				robotDrive.driveCartesian(0, 0, 0.2, Robot.drivetrain.gyroAngle());
				complete = false;
			}
			
			else if(gyroAngle() < angle + 0.2 && gyroAngle() > angle - 0.2){
				complete = true;
			}
			
			return complete;
		}
	
		public double gyroAngle() {
			return gyro.getAngle();
		}
	
		public void gyroReset() {
			gyro.reset();
		}

			
		public double getRotation() {
			return gyro.getRate();
		}
	
		public void stop() {
			robotDrive.driveCartesian(0, 0, 0, Robot.drivetrain.gyroAngle());
		}
	
		public void initDefaultCommand() {
			// Set the default command for a subsystem here.
			setDefaultCommand(new DriveTrainCommands());
		}
}