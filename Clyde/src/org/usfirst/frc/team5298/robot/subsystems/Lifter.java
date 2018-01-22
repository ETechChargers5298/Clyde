package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.LiftContinuous;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	private Spark mainLifter;
	
	public DigitalInput upLimitSwitch;
	public DigitalInput downLimitSwitch;
	public int currentLifterPosition;
	
	public Lifter() {
		mainLifter = new Spark(3);
		upLimitSwitch = new DigitalInput(0);
		downLimitSwitch = new DigitalInput(1);
		
		currentLifterPosition = 1;
	}
	
	public void setLifter(double speed) {
		if(currentLifterPosition == 1) {
			mainLifter.set(Math.max(speed, 0));
		}
		
		else if(currentLifterPosition == 4) {
			mainLifter.set(Math.min(speed, 0));
		}
		
		mainLifter.set(speed);
	}
	
	public int getCurrentPosition() {
		if(upLimitSwitch.get()) {
			currentLifterPosition = currentLifterPosition + 1;
		}
		
		else if(downLimitSwitch.get()) {
			currentLifterPosition = currentLifterPosition - 1;
		}
		
		return currentLifterPosition;
	}
	
	public void setNewLifterPosition(int newLifterPosition) {
		currentLifterPosition = newLifterPosition;
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new LiftContinuous());
	}
}