package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
	
	public Drive() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		Robot.drivetrain.drive(
					 -Robot.oi.driverPad.getLeftY(),
					 Robot.oi.driverPad.getLeftX(),
					 Robot.oi.driverPad.getRightX()
					 );
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}

}
