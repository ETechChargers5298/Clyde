package org.usfirst.frc.team5298.robot.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5298.robot.commands.*;;

public class ScaleCommandLeft extends CommandGroup {

	public ScaleCommandLeft(char scaleSide) {

		if (scaleSide == 'L') {
			addSequential(new MoveLinear(324));
			//addParallel(new LifterAuto(2, 0.5));
			//addSequential(new MoveRotate(90));
			//addSequential(new GrabberAuto(1, false));

		} else if (scaleSide == 'R') {

			addSequential(new MoveLinear(324));
		}

	}
}