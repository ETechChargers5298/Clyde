package org.usfirst.frc.team5298.robot;

import org.usfirst.frc.team5298.robot.subsystems.Grabber;
import org.usfirst.frc.team5298.robot.subsystems.Lifter;
import org.usfirst.frc.team5298.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Grabber grabber;
	public static Lifter lifter;
	
	String autonomousPosition;
	String gameData;
	char scaleSide;

    public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain();
		grabber = new Grabber();
		lifter = new Lifter();
    }
	
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousPosition = "Left";
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	scaleSide = gameData.charAt(1);
    	
    	switch(autonomousPosition) {
    		case "Left":
    			if(scaleSide == 'L') {
    				
    			}
    	}
    	
    	if(gameData.charAt(1) == 'L') {
    		
		}
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
    }
}