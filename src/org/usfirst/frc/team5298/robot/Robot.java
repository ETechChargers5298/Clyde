package org.usfirst.frc.team5298.robot;

import org.usfirst.frc.team5298.robot.subsystems.Grabber;
import org.usfirst.frc.team5298.robot.subsystems.Lifter;
import org.usfirst.frc.team5298.robot.subsystems.Navigator;
import org.usfirst.frc.team5298.robot.subsystems.Transciever;
import org.usfirst.frc.team5298.robot.autonomous.ScaleCommand;
import org.usfirst.frc.team5298.robot.subsystems.Drivetrain;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drivetrain Drivetrain;
	public static Grabber grabber;
	public static Lifter Lifter;
	public static Transciever transciever;
	public static Navigator Navigator;
	
	UsbCamera camera;

	private String autoPositionSelected;
    private Command autoCommand;
	private double autoStartTime;
	
	String gameData;
	char scaleSide;
	
	SendableChooser<String> chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		Drivetrain = new Drivetrain();
		Navigator = new Navigator();
		grabber = new Grabber();
		//transciever = new Transciever();
        
		oi = new OI();
   
        chooser = new SendableChooser<String>();
        chooser.addDefault("Default Auto", "Start Left");
        chooser.addObject("Start Left", "Start Left");
        chooser.addObject("Start Right", "Start Right");
		chooser.addObject("Middle Position", "Start Middle");

        SmartDashboard.putData("Auto mode", chooser);
     
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	autoPositionSelected = chooser.getSelected();
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	switch(autoPositionSelected)
    	{
    		
    	}
    	
    	

		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autoCommand != null) autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
       
        
        if(Timer.getFPGATimestamp() - autoStartTime >= 15) {
        	autoCommand.cancel();
        }
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autoCommand != null) autoCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    	  try {
              for(int i = 0; i < 10; i++) {
                  transciever.enableTargeting("Cube");
              }

              Integer p = transciever.getData("Cube");
              if(p != null)
                  System.out.println("Main Thread Data:"+ p);

          } catch(Exception ex) {
              ex.printStackTrace();
          }

          
      }
    	
    }