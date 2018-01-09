package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;


public class DriveTrainCommands extends Command {

	public DriveTrainCommands() {
        requires(Robot.navigator);
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
	}
	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.navigator.updateInputs();
        Robot.drivetrain.drive(Robot.navigator.getCalculatedVelocities());
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}