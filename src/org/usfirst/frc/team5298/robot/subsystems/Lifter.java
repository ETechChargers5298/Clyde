package org.usfirst.frc.team5298.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Lifter extends Subsystem {
	
	private WPI_TalonSRX Lift;
	private int TIMEOUT_MS;
	
	public Lifter() {
		Lift = new WPI_TalonSRX(1);
		//Lift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, TIMEOUT_MS);
		//Lift.setSensorPhase(true);
		
		//Lift.configNominalOutputForward(0, TIMEOUT_MS);
		//Lift.configNominalOutputReverse(0, TIMEOUT_MS);
		//Lift.configPeakOutputForward(1, TIMEOUT_MS);
		//Lift.configPeakOutputReverse(-1, TIMEOUT_MS);
	}
	
	public void LifterSet(double speed) {
		//Set Grabber speeds
		Lift.set(speed);
		//Lift.set(ControlMode.Position, speed);
		//SmartDashboard.putNumber("Count Value", speed);
	}
	
	public void LifterStop()
	{
		Lift.set(0);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}