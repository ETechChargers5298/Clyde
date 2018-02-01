package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftContinuous extends Command {
	
	protected void initialize() {
		
	}
	protected void execute() {
		Robot.lifter.SpeedMotor(Robot.oi.operatorPad.getRightX());
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
