package org.usfirst.frc.team5298.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeft extends CommandGroup{
	
	public StartLeft(char scaleSide) {
		if(scaleSide == 'L') {
			addSequential(new MoveLinear(5.0, 0.7));
			addSequential(new Rotate(90, 0.5));
			addSequential(new MoveLinear(7.0, 0.5));
		
		}
		
		else if(scaleSide == 'R') {
			addSequential(new MoveLinear(3.0, 0.6));
			addSequential(new Rotate(-90, 0.8));
			addSequential(new MoveLinear(6.0, 0.5));
			}
	}

}
