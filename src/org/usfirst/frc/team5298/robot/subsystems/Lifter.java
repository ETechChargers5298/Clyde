package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Lifter extends Subsystem {
	
	private Spark Lift;
	
	public Lifter() {
		Lift = new Spark(5);
	}
	
	public void LifterSet(double speed) {
		//Set Grabber speeds
		Lift.set(speed);
	}
	
	public void LifterStop()
	{
		Lift.set(0);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}