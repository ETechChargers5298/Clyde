package org.usfirst.frc.team5298.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

	public class Lifter extends Subsystem {
 	
		private Spark leftLifter;
		private Spark rightLifter;

		public Lifter() {
		leftLifter = new Spark(5);
		rightLifter = new Spark(6); }

		public void grab(double speed) {
			leftLifter.set(speed);
			rightLifter.set(-speed);	
		}
		
		public void release(double speed) {
			leftLifter.set(-speed);
			rightLifter.set(speed);
		}
		


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void lift(double rightY) {
		// TODO Auto-generated method stub
		
	}

}
