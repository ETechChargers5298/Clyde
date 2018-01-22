package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.MoveLinear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRight extends CommandGroup {
	
	public StartRight(char scaleSide) {
		if(scaleSide == 'L') {
			addSequential(new MoveLinear(5.0, 0.8)); 
		}
		
		else if(scaleSide == 'R') {
			addSequential(new MoveLinear(5.0, 0.8)); 
		}
	}
}