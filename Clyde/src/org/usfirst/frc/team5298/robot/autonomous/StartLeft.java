package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.MoveLinear;
import org.usfirst.frc.team5298.robot.commands.MoveRotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeft extends CommandGroup {
	
	public StartLeft(char scaleSide) {
		if(scaleSide == 'L') {
			addSequential(new MoveLinear(7.0, 0.8)); 
			addSequential(new MoveRotate(90, 0.5));
			addSequential(new MoveLinear(2.0, 0.8));
		}
		
		else if(scaleSide == 'R') {
			addSequential(new MoveLinear(5.0, 0.8));
			addSequential(new MoveRotate(90, 0.5));
			addSequential(new MoveLinear(5.0, 0.8));
			addSequential(new MoveRotate(0, 0.5));
			addSequential(new MoveLinear(2.0, 0.8));
			addSequential(new MoveRotate(-90, 0.5));
			addSequential(new MoveLinear(2.0, 0.8));
		}
	}
}