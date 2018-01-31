package org.usfirst.frc.team5298.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

	public class AutonomousLeft extends CommandGroup {
		
		public AutonomousLeft() {
			addSequential(new Autonomous(4, 1, 0, 0));
			addSequential(new Autonomous(1, 0, 0, 1));
			addSequential(new Autonomous(4, -1, 0, 0));
			addSequential(new Autonomous(1, 0, 0, -1));
				
		}
	}