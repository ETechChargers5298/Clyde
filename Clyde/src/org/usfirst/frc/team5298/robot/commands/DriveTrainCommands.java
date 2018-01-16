package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import org.usfirst.frc.team5298.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrainCommands extends Command {

	public DriveTrainCommands() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
	}
	
    // Called repeatedly when this Command is scheduled to run
    protected  void execute() {	
    	DriveTrain.robotDrive.driveCartesian(
    		Robot.oi.driverPad.getRightX(),
    		Robot.oi.driverPad.getLeftX(),
    		Robot.oi.driverPad.getLeftY(),
    		Robot.drivetrain.gyroAngle()
    	);
    	
    	System.out.println(Robot.oi.driverPad.getLeftY()*0.95);
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