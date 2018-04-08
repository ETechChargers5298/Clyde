package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.AutoDrive;
import org.usfirst.frc.team5298.robot.commands.DriveTrainMotions;
import org.usfirst.frc.team5298.robot.commands.GrabberAuto;
import org.usfirst.frc.team5298.robot.commands.LifterAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScaleCommandRight extends CommandGroup {

	public ScaleCommandRight(char scaleSide) {

		if (scaleSide == 'R') {
			addSequential(new AutoDrive(3.5, 0.8));
			addParallel(new LifterAuto(3, 1));
			addSequential(new DriveTrainMotions(2, 0, 0.5, 0));
			addSequential(new GrabberAuto(1, false));
		} else if (scaleSide == 'L') {
			addSequential(new AutoDrive(2.5, 1));
		}
	}
}
