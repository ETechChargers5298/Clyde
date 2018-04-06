   package org.usfirst.frc.team5298.robot;

import org.usfirst.frc.team5298.robot.autonomous.MiddleCommand;
import org.usfirst.frc.team5298.robot.autonomous.ScaleCommandLeft;
import org.usfirst.frc.team5298.robot.autonomous.ScaleCommandRight;
import org.usfirst.frc.team5298.robot.commands.AutoDrive;
import org.usfirst.frc.team5298.robot.commands.LifterCommand;
import org.usfirst.frc.team5298.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5298.robot.subsystems.Grabber;
import org.usfirst.frc.team5298.robot.subsystems.Lifter;
import org.usfirst.frc.team5298.robot.subsystems.Navigator;
import org.usfirst.frc.team5298.robot.subsystems.Transciever;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
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
	public static final int	WIDTH = 640;
	public static final int	HEIGHT = 480;
	public static final int	FPS = 30;
	

    private Command autoCommand;
	private double autoStartTime;
	
	String gameData;
	char scaleSide;
	
	SendableChooser<Integer> chooser; 

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		Drivetrain = new Drivetrain();
		Navigator = new Navigator();
		grabber = new Grabber();
		Lifter = new Lifter();
		//transciever = new Transciever();
        
		oi = new OI();
		
		camera = new UsbCamera("Box Camera", 1);
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(WIDTH, HEIGHT);
		camera.setFPS(FPS);
		
		
        chooser = new SendableChooser<Integer>();
        chooser.addDefault("Default Auto", 0);
        chooser.addObject("Start Middle", 1);
        chooser.addObject("Start Left", 2);
        chooser.addObject("Start Right", 3);

        SmartDashboard.putData("Auto mode", chooser);   
        
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit() {
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
    	autoStartTime = Timer.getFPGATimestamp();
	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	scaleSide = gameData.charAt(1);
    	
		switch(chooser.getSelected()) {
		case 0:
			autoCommand = new AutoDrive(3, 0.8);
			break;
		case 1:
			if(gameData.charAt(1) == 'L') 
			{
				autoCommand = new MiddleCommand(-0.5);
			} else {
				autoCommand = new MiddleCommand(0.5);
			}
			break;
		case 2:
			autoCommand = new ScaleCommandLeft('L');
			break;
		case 3:
			autoCommand = new ScaleCommandRight('R');
			break;
		default:
			System.out.println("No autonomous command selected!");
			break;
		} 
		
    	autoCommand.start();
    	
    	// schedule the autonomous command (example)
        //if (autoCommand != null) autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        updateSmartDashboard();
        
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
        
        Navigator.enableLidar();
        
        Scheduler.getInstance().add(new LifterCommand());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        updateSmartDashboard();
    }
    
    /**
     * This function is called periodically during test mode
     */
    
    public void updateSmartDashboard()
    {
    	SmartDashboard.putNumber("Lidar Value", Navigator.getDisplacement());
    	SmartDashboard.putNumber("Gyro Angle", Navigator.getAngle());
    	
    	if(Navigator.getAngle() > 100)
    	{
    		Navigator.resetGyro();
    	}
    	
    }

    
    public void testPeriodic() 
    {
    	
    	//Scheduler.getInstance().add(new MiddleCommand(0.5));
    	
    	updateSmartDashboard();
    	
    	
    	/*
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
          
          */

          
      }
    	
    }

