package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.Lift;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	private Spark mainLifter;
	
	public Lifter() {
		mainLifter = new Spark (4);
		mainLifter.setInverted(false);
	}
	
	public void setLifterMotor(double speed) {
		mainLifter.set(speed);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new Lift());
		
	}
}