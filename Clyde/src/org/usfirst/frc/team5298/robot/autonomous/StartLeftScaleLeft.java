package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.MoveLinear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeftScaleLeft extends CommandGroup {
	
	public StartLeftScaleLeft() {
		addSequential(new MoveLinear(5.0, 0.8));
	}
}