package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.RunCompressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;

public class AirCompressor extends Subsystem {

    private DigitalInput pressure;
    private AnalogInput analogPressureSwitch;
    private Compressor comp;
    private Relay relay;
    public static final int COMP_RELAY_PORT = 0, DIO_PORT = 0, AIO_PORT = 1;

    public AirCompressor() {
        pressure = new DigitalInput(DIO_PORT);
        relay = new Relay(COMP_RELAY_PORT);
        comp = new Compressor(DIO_PORT);
        analogPressureSwitch = new AnalogInput(AIO_PORT);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    //Command not currently in use
    public double getRawPressure() {
        return (analogPressureSwitch.getVoltage() * 250.0) / 4.786 - 25.0;
    }

    public boolean getPressureStatus() {
        return pressure.get();
    }

    //Command not currently in use
    public Relay getRelay() {
        return relay;        
    }
    
    public void setCompressor(Relay.Value val) {
        relay.set(val);
    }
}