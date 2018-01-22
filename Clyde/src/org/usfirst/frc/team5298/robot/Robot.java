package org.usfirst.frc.team5298.robot;

import org.usfirst.frc.team5298.robot.subsystems.Grabber;
import org.usfirst.frc.team5298.robot.subsystems.Lifter;
import org.usfirst.frc.team5298.robot.autonomous.StartLeft;
import org.usfirst.frc.team5298.robot.autonomous.StartMiddle;
import org.usfirst.frc.team5298.robot.autonomous.StartRight;
import org.usfirst.frc.team5298.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain drivetrain;
	public static Grabber grabber;
	public static Lifter lifter;

	private String autoSelected;
	private SendableChooser<String> autoChooser;
	private Command autoCommand;
	
	String autonomousPosition;
	String gameData;
	char scaleSide;
	
	private double autoStartTime;

    public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain();
		grabber = new Grabber();
		lifter = new Lifter();
		
		autoChooser = new SendableChooser<String>();
		autoChooser.addDefault("Default Auto", "Default");
		autoChooser.addObject("Left Auto", "Start Left");
		autoChooser.addObject("Middle Auto", "Start Middle");
		autoChooser.addObject("Right Auto", "Start Right");
		SmartDashboard.putData("Auto Choices", autoChooser);
    }
	
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		autoSelected = autoChooser.getSelected();
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	scaleSide = gameData.charAt(1);
    	
    	switch(autoSelected) {
    		case "Start Right":
    			if(scaleSide == 'L') {
    				autoCommand = new StartRight("Left");
    				break;
    			}
    			
    			else if(scaleSide == 'R') {
    				autoCommand = new StartRight("Right");
    				break;
    			}
    			
    		case "Start Middle":
    			if(scaleSide == 'L') {
    				autoCommand = new StartMiddle("Left");
    				break;
    			}
    			
    			else if(scaleSide == 'R') {
    				autoCommand = new StartMiddle("Right");
    				break;
    			}
    			
    		case "Start Left":
    			if(scaleSide =='L') {
    				autoCommand = new StartLeft("Left");
    				break;
    			}
    			
    			else if(scaleSide == 'R') {
    				autoCommand = new StartLeft("Right");
    				break;
    			}
    			
    		case "Default":
    			if(scaleSide =='L') {
    				autoCommand = new StartLeft("Left");
    				break;
    			}
    			
    			else if(scaleSide == 'R') {
    				autoCommand = new StartLeft("Right");
    				break;
    			}
    	}
    	
    	autoCommand.start();
    	autoStartTime = Timer.getFPGATimestamp();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        if(Timer.getFPGATimestamp() - autoStartTime >= 15) {
        	autoCommand.cancel();
        }
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
    }
}