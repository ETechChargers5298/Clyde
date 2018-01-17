package org.usfirst.frc.team5298.robot;

import org.usfirst.frc.team5298.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5298.robot.subsystems.Navigator;
import org.usfirst.frc.team5298.robot.subsystems.Velocity;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	
	UsbCamera gearCamera;
	
	public static final int	WIDTH = 320;
	public static final int	HEIGHT = 240;
	public static final int	FPS = 30;
	
	private Command autonomous;
    private SendableChooser<Command> autoChooser;
	
    
	public static OI oi;
	public static Gamepad driverPad;
	public static Gamepad operatorPad;
	
	public static DriveTrain drivetrain;
	public static Navigator navigator;
	public static Velocity velocity;

	
	private double autonStartTime;
	
	
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	

    public void robotInit() {
		
    	//Gamepad Initialized Here
    	oi = new OI();
		driverPad = new Gamepad(0);
		
		//Vision Code Here
		 gearCamera = CameraServer.getInstance().startAutomaticCapture();
		 gearCamera.setResolution(WIDTH, HEIGHT);
		 gearCamera.setFPS(FPS);
		 
		//Subsystems Initialized Here
		drivetrain = new DriveTrain();
		navigator = new Navigator();
		velocity = new Velocity();
		
        autoChooser = new SendableChooser<Command>();
	    SmartDashboard.putData("Autonomous Command", autoChooser);
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
    	//if(autonomous != null) 
        //autonomous = (Command) autoChooser.getSelected();
    	autonomous.start();
    	autonStartTime = Timer.getFPGATimestamp();
    	
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
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();//keep this one if you dont want a spammed error message on driver station.
    	if (Timer.getFPGATimestamp() - autonStartTime >= 15) {
    		autonomous.cancel();
    	}
    }

    public void teleopInit() {
    	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	if(autonomous != null) {
    		autonomous.cancel();
    	}
    } 
    
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
	}
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}