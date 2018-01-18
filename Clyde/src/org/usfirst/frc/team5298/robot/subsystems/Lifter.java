package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	private Spark mainLifter;
	
	public DigitalInput bottomTrigger, scaleTrigger, switchTrigger, topTrigger;
	
	public Lifter() {
		mainLifter = new Spark(3);
		
		bottomTrigger = new DigitalInput(0);
		scaleTrigger = new DigitalInput(1);
		switchTrigger = new DigitalInput(2);
		topTrigger = new DigitalInput(3);
	}
	
	public void setLifter(double speed) {
		mainLifter.set(speed);
	}
	
	public boolean triggerState(String trigger) {
		if(trigger == "bottomTrigger") {
			return bottomTrigger.get();
		} else if(trigger == "scaleTrigger") {
			return scaleTrigger.get();
		} else if(trigger == "switchTrigger") {
			return switchTrigger.get();
		} else if(trigger == "topTrigger") {
			return topTrigger.get();
		} else {
			return true;
		}
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}