package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoAlignment extends Command {
	
	private int data;
	private double angle;
	
	public AutoAlignment() {
		requires(Robot.Navigator);
		requires(Robot.Drivetrain);
		requires(Robot.transciever);
	}
	

	protected void initialize() {
		Robot.transciever.enableTargeting("Tape");
		Robot.Navigator.enableLidar();
	}

	protected void execute() { 
		data = Robot.transciever.getData("Tape");
		angle = Robot.Navigator.getAngle();
		Robot.Drivetrain.drive(0.5, data, angle);
		
		SmartDashboard.putNumber("Lidar value", Robot.Navigator.getDisplacement());
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.Navigator.getDisplacement() >= 140;
		
	}

	// Called once after isFinished returns true
	protected void end() { 
		Robot.Navigator.disableLidar();
		Robot.transciever.disableTargeting("Tape");
		Robot.Navigator.resetGyro();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}