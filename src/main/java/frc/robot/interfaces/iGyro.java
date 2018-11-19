package frc.robot.interfaces;

public interface iGyro {

    public double getAngle();
    public void reset();
    public void calibrate();
}