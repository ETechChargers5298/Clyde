package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.LiftContinuous;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDLifter extends PIDSubsystem {
	
	private Spark mainLifter;
	
	public AnalogInput lifterPotentiometer;
	public double currentLifterHeight;
	
	public PIDLifter() {
		super("PIDLifter", 2.0, 0.0, 0.0);
		
		lifterPotentiometer = new AnalogInput(1);
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
		
		mainLifter = new Spark(3);
		
		currentLifterHeight = 0.0;
	}
	
	protected double returnPIDInput() {
		return lifterPotentiometer.getAverageVoltage();
	}

	protected void usePIDOutput(double output) {
		mainLifter.pidWrite(output);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new LiftContinuous());
	}
}