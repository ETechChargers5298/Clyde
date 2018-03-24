package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.GrabberAuto;
import org.usfirst.frc.team5298.robot.commands.LifterAuto;
import org.usfirst.frc.team5298.robot.commands.MoveLinear;
import org.usfirst.frc.team5298.robot.commands.MoveRotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScaleCommandRight extends CommandGroup {

	public ScaleCommandRight(char scaleSide) {

		if (scaleSide == 'R') {
			addSequential(new MoveLinear(324));
			//addParallel(new LifterAuto(2, 0.5));
			//addSequential(new MoveRotate(90));
			//addSequential(new GrabberAuto(1, false));

		} else if (scaleSide == 'L') {
			addSequential(new MoveLinear(324));
		}
	}
}
