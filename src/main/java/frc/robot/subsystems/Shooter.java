package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Shooter extends Subsystem{
    private DoubleSolenoid shooter, highElevator, lowElevator;
    
    //PCM ID's
    private final int PCM_ID = 6, 
                      SHOOTER_FORWARD = 7,
                      SHOOTER_REVERSE = 0,
                      HIGH_ELEVATOR_FORWARD = 1,
                      HIGH_ELEVATOR_REVERSE = 2,
                      LOW_ELEVATOR_FORWARD = 4,
                      LOW_ELEVATOR_REVERSE = 3;
                    
    public Shooter() {
        shooter = new DoubleSolenoid(PCM_ID, SHOOTER_FORWARD, SHOOTER_REVERSE);
        highElevator = new DoubleSolenoid(PCM_ID, HIGH_ELEVATOR_FORWARD, HIGH_ELEVATOR_REVERSE);
        lowElevator = new DoubleSolenoid(PCM_ID, LOW_ELEVATOR_FORWARD, LOW_ELEVATOR_REVERSE);
    }

    public void initDefaultCommand() {
        
    }
}

