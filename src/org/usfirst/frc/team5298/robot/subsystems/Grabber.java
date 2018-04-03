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
	
	private Compressor c;
	
	public Grabber() 
	{
	    c = new Compressor(0);
		c.setClosedLoopControl(true);
		grabberSolenoid = new Solenoid(0);
		isClosed = false;
	 }
	
	public void setGrabber(boolean direction) 
	{
		grabberSolenoid.set(direction);
	}
	
	public void toggleGrabber() {
		isClosed = !isClosed;
		grabberSolenoid.set(isClosed);
	}
	
	protected void initDefaultCommand() { 
		
	}
}