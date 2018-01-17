package org.usfirst.frc.team5298.robot.subsystems;



public class Velocity {
    private double linear, angular, strafe, theta;

    public Velocity() {
        update(0.0, 0.0, 0.0);
        this.theta = 0.0;
    }

    public Velocity(double linear, double angular, double strafe) {
        update(linear, angular, strafe);
        this.theta = 0.0;
    }

    public Velocity(double linear, double angular, double strafe, double theta) {
        update(linear, angular, strafe, theta);
    }

    public void update(double linear, double angular, double strafe) {
        this.linear = linear;
        this.angular = angular;
        this.strafe = strafe;
    }

    public void update(double linear, double angular, double strafe, double theta) {
        convertRelativeToAbsolute(linear, strafe, theta);
        this.angular = angular;
        this.theta = theta;
    }

    private void convertRelativeToAbsolute(double linear, double strafe, double theta) {
        this.linear = linear*Math.sin(theta) + strafe*Math.sin(theta);
        this.strafe = linear*Math.cos(theta) + strafe*Math.cos(theta);
    }

    public double linear() {
        return this.linear;
    }

    public double angular() {
        return this.angular;
    }

    public double strafe() {
        return this.strafe;
    }

    public double currentAngle() {
        return this.theta;
    }
}