package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;

public class AirCompressor extends Subsystem {

    private Compressor comp;
    private Relay relay;
    public static final int COMP_RELAY_PORT = 1;
    
    DigitalInput pressure;

    public AirCompressor() {
        pressure = new DigitalInput(COMP_RELAY_PORT);
        relay = new Relay(Ports.Relay.COMPRESSOR_RELAY);
    }

    public void initDefaultCommand() {
        
    }
    public void periodic() {

    }
}