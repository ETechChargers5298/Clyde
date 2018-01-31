package org.usfirst.frc.team5298.robot.commands;
import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Grab extends Command {
	
	public Grab() {  
	}
	
	protected void initialize() {
		Robot.grabber.grab(Robot.oi.operatorPad.getLeftY());
  	}
	
	protected void execute() {  
 	}
  
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	protected void end() {
 	}

	protected void interrupted() {	
		end();
	}
}