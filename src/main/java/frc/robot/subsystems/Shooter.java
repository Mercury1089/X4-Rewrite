package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.commands.RaiseShooter;
import frc.robot.Robot;

public class Shooter extends Subsystem {
    private DoubleSolenoid highElevator, lowElevator;
    private Solenoid shooter;

    public enum ElevatorPosition {
        DOWN,
        LOW,
        MEDIUM,
        HIGH;
    }
    
    //PCM ID's
    private final int PCM_ID = 6, 
        SHOOTER_FORWARD = 7,
        HIGH_ELEVATOR_FORWARD = 1,
        HIGH_ELEVATOR_REVERSE = 2,
        LOW_ELEVATOR_FORWARD = 4,
        LOW_ELEVATOR_REVERSE = 3;
    //variable currently not in use
    private ElevatorPosition currPos = ElevatorPosition.LOW;

    public Shooter() {
        shooter = new Solenoid(PCM_ID, SHOOTER_FORWARD);
        highElevator = new DoubleSolenoid(PCM_ID, HIGH_ELEVATOR_FORWARD, HIGH_ELEVATOR_REVERSE);
        lowElevator = new DoubleSolenoid(PCM_ID, LOW_ELEVATOR_FORWARD, LOW_ELEVATOR_REVERSE);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RaiseShooter(ElevatorPosition.DOWN));
    }    

    public void setShooterHeight(ElevatorPosition pos) {
		this.currPos = pos;       
        switch(pos) {
            case DOWN:			
                lowElevator.set(DoubleSolenoid.Value.kReverse);
                highElevator.set(DoubleSolenoid.Value.kReverse);
                break;
            case LOW:
                lowElevator.set(DoubleSolenoid.Value.kForward);
                highElevator.set(DoubleSolenoid.Value.kReverse);
                break;
            case MEDIUM:
                lowElevator.set(DoubleSolenoid.Value.kReverse);
                highElevator.set(DoubleSolenoid.Value.kForward);
                break;
            case HIGH:
                highElevator.set(DoubleSolenoid.Value.kForward);
                lowElevator.set(DoubleSolenoid.Value.kForward);
                break;   
        }
    }

    /**
     * @param shoot whether or not to shoot
     */
    public void shootBall() {
        shooter.set(true);
    }
}
