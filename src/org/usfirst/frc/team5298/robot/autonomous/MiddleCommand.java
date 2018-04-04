package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.DriveTrainMotions;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleCommand extends CommandGroup {
	
	public MiddleCommand(double strafeVelocity)
	{
		addSequential(new DriveTrainMotions(2, 0.5, strafeVelocity, 0));
	}						
}
