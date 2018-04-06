package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabberSolenoid;
import org.usfirst.frc.team5298.robot.commands.AutoDrive;
import org.usfirst.frc.team5298.robot.commands.DriveTrainMotions;
import org.usfirst.frc.team5298.robot.commands.LifterAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleCommand extends CommandGroup {
	
	public MiddleCommand(double strafeVelocity)
	{
		addParallel(new LifterAuto(2.5, 1));
		addSequential(new DriveTrainMotions(1.5, 0.5, strafeVelocity, 0));
		addSequential(new AutoDrive(2, 0.6));
		addSequential(new ActivateGrabberSolenoid(false));
	}						
}
