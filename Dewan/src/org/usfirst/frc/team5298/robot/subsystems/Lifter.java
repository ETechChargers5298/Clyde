package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem{

	private Spark lifterMotor;
	
	public DigitalInput UpperSwitch, BottomSwitch;
	public int currentLift;
	
	public Lifter() {
		lifterMotor = new Spark(8);
		currentLift = 1;
	}
	
	public void SpeedMotor(double speed) {
		lifterMotor.set(speed);
	}
	
	public void LifterPosition() {
		if(UpperSwitch.get()) {
			currentLift = currentLift + 1;
		}
			
		else if(BottomSwitch.get()) { 
			currentLift = currentLift - 1;
			
			
		}
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
			

		}
	}


