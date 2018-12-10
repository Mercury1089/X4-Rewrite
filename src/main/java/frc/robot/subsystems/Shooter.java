package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.commands.DriveWithJoysticks;
import frc.util.TalonDrive;
import frc.util.config.DriveTrainSettings;
import frc.util.config.DriveTrainSettings.DriveTrainLayout;
import frc.util.Const;
import frc.util.MercMath;

public class Shooter extends Subsystem{
    
    private Compressor comp;

    public Shooter() {
        comp = new Compressor(0); //to do: make not zero

    }
    public void initDefaultCommand() {
    }
}

