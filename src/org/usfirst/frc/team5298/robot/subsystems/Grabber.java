package org.usfirst.frc.team5298.robot.subsystems;

import org.usfirst.frc.team5298.robot.commands.ActivateGrabberSolenoid;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {

	private Boolean set;
	private Solenoid grabberSolenoid;
	
	private Compressor c;
	
	public Grabber() 
	{
		
	    c = new Compressor(0);
		c.setClosedLoopControl(true);
		grabberSolenoid = new Solenoid(0);
		
	 }
	
	public void setGrabberSolenoid(Boolean direction) 
	{
		grabberSolenoid.set(direction);
	
	}
	
	public void GrabberStop()
	{
		
	}

	protected void initDefaultCommand() {
	}
}