package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class AutoDrive extends Command {
	
	public double startTime;
	public double maxTime;
	public double speed;
	
	public AutoDrive() {
		requires(Robot.Drivetrain);
	}
	
	public void initialize() {
		startTime = Timer.getFPGATimestamp();
	}
	
	public void execute() {
    	Robot.Drivetrain.autonDrive();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Timer.getFPGATimestamp() - startTime >= maxTime;
	}

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Drivetrain.drive(0.0, 0.0, 0.0);
    }
}
