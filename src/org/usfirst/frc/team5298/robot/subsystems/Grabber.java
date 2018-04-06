package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabberSolenoid;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {

	private Boolean isClosed;
	private Solenoid grabberSolenoid;
	private Solenoid tosserSolenoid;

	private Compressor c;
	
	//There will be two solenoids for the robot this year
	
	public Grabber() 
	{
	    c = new Compressor(0);
		c.setClosedLoopControl(true);
		grabberSolenoid = new Solenoid(0);
		tosserSolenoid = new Solenoid(1);
		isClosed = true;
	 }
	
	public void setGrabber(boolean direction) 
	{
		grabberSolenoid.set(direction);
	}
	
	public void setTosser(boolean direction)
	{
		tosserSolenoid.set(direction);
	}
	
	public void toggleTosser()
	{
		isClosed = !isClosed;
		tosserSolenoid.set(isClosed);
		
	}
	
	
	public void toggleGrabber() 
	{
		isClosed = !isClosed;
		grabberSolenoid.set(isClosed);
	}
	
	protected void initDefaultCommand() { 
		
	}
}