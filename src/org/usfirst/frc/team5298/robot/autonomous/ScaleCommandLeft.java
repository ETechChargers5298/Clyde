package org.usfirst.frc.team5298.robot.autonomous;

import org.usfirst.frc.team5298.robot.commands.AutoDrive;
import org.usfirst.frc.team5298.robot.commands.DriveTrainMotions;
import org.usfirst.frc.team5298.robot.commands.GrabberAuto;
import org.usfirst.frc.team5298.robot.commands.LifterAuto;

import edu.wpi.first.wpilibj.command.CommandGroup;;

public class ScaleCommandLeft extends CommandGroup {

	public ScaleCommandLeft(char scaleSide) {

		if (scaleSide == 'L') {
			addSequential(new AutoDrive(2, 0.25));
			addParallel(new LifterAuto(3, 1));
			addSequential(new DriveTrainMotions(1,0,0,0.25));
			addSequential(new GrabberAuto(1, false));

		} else if (scaleSide == 'R') {

			addSequential(new AutoDrive(1 ,0.5));
		}
	}
}