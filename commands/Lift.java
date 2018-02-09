package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {
	
	public Lift() {
		requires(Robot.lifter);
	}
	
	protected void initalize() {
	}
	
	protected void execute() {
		if(Robot.oi.operatorPad.getLeftY() < 0.1 && Robot.oi.operatorPad.getLeftY() > -0.1) {
			Robot.lifter.setLifterMotor(0.1);
		}
		else {
			Robot.lifter.setLifterMotor(Robot.oi.operatorPad.getLeftY());
		}
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
		end();
	}
}
