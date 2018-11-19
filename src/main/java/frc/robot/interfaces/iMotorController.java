package frc.robot.interfaces;

public interface iMotorController {
    
    public double getPosition();
    public double getVelocity();
    public double getAcceleration();
    public void setPosition();
    public void setVelocity();
    public void setPercentOutput();
}