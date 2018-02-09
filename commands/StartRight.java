package org.usfirst.frc.team5298.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRight extends CommandGroup{
	
	public StartRight(char scaleSide) {
		if(scaleSide == 'R') {
			addSequential(new MoveLinear(5.0, 0.7));
			addSequential(new Rotate(90, 0.7));
			addSequential(new MoveLinear(3.0, 0.6));
		}
		
		else if(scaleSide == 'L') {
			addSequential(new MoveLinear(5.0, 0.7));
			addSequential(new Rotate(-90, 0.7));
			addSequential(new MoveLinear(8.0, 0.5));
		}
	}
}
