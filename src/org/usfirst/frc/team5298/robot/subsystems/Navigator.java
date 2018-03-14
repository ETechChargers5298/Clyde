package org.usfirst.frc.team5298.robot.subsystems;
import org.usfirst.frc.team5298.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.Integer;

import java.util.ArrayList;

public class Navigator extends Subsystem {
    private static ADXRS450_Gyro gyro;
    private static Counter lidar;
    private static DigitalOutput lidarTrigger;
    private static SerialPort rangeFinder;
    private static ByteArrayOutputStream rangeFinderBuffer;

    public Navigator() {
        gyro = new ADXRS450_Gyro();
        lidar = new Counter(/*pin*/);
        lidarTrigger = new DigitalOutput(0/*pin*/);
        rangeFinder = new SerialPort(115200, Port.kMXP);
        rangeFinderBuffer = new ByteArrayOutputStream();

		resetGyro();
        disableLidar();
        lidar.setSemiPeriodMode(true);
    }

    public void resetGyro() {
        gyro.reset();
    }

    public double getAngle() {
        return gyro.getAngle();
    }

    public void enableLidar() {
        lidarTrigger.set(false);
    }

    public void disableLidar() {
        lidarTrigger.set(true);
        lidar.reset();
    }

    public double getDisplacement() {
        return lidar.getPeriod() / 25.4;   // TODO: Convert from m to ft.
    }
    
 

    // Poll this method in Command.execute() or Command.getPIDInput().
    public Boolean rangeFinderReady() throws IOException {
        if(rangeFinderBuffer.size() < 16) {
            rangeFinderBuffer.write(rangeFinder.read(8));
            return false;
        }

        return true;
    }

    public Integer getHeight() {
        // Java is retarded.
        ArrayList<Integer> input = new ArrayList<Integer>();
        int height;

        // Convert byte array to int arrayList.
        for(byte b: rangeFinderBuffer.toByteArray())
            input.add(b & 0xFF);

        for(int i = 1; i < input.size(); i++) {
            // Look for header bytes and check for data bytes beyond.
            if((input.get(i - 1) == 0x59) && (input.get(i) == 0x59) && (input.size() - i > 2)) {
                rangeFinderBuffer.reset();
                return (input.get(i + 1) << 8) + input.get(i + 2);
            }
        }

        // Should not return null if you called rangeFinderReady() before.
        return null;
    }

	protected void initDefaultCommand() {
		
	}
}
