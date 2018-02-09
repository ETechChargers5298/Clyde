package org.usfirst.frc.team5298.robot.commands;

import org.usfirst.frc.team5298.robot.commands.MoveLinear;
import org.usfirst.frc.team5298.robot.commands.Rotate;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartMiddle extends CommandGroup {
	
	public StartMiddle(char scaleSide) {
		if(scaleSide == 'L') {
			addSequential(new MoveLinear(6.0, 0.8));
			addSequential(new Rotate(-90, 0.5));
			addSequential(new MoveLinear(5.0, 0.8));
			addSequential(new Rotate(0, 0.5));
		}
		
		else if(scaleSide == 'R') {
			addSequential(new MoveLinear(7.0, 0.7));
			addSequential(new Rotate(-90, 0.5));
			addSequential(new MoveLinear(5.0, 0.5));
			addSequential(new Rotate(90, 0.5));
		}
			
}
}
	


