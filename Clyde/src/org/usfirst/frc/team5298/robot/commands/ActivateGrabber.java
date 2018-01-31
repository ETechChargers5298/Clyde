package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class ActivateGrabber extends Command {
	
	public ActivateGrabber() {
		requires(Robot.grabber.setGrabberSolenoid(-Robot.oi.operatorPad.getLeftY));
	}

	protected void initalize() {
	}
	
	protected void execute() {
		
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
