package frc.util;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/**
 * Helper class to interface with the Shuffleboard Dashboard.
 */
public class ShuffleDash {
    private NetworkTableInstance ntInstance;

    public ShuffleDash() {
        new Notifier(this::updateDash).startPeriodic(0.050);

        ntInstance = NetworkTableInstance.getDefault();
    }

    private void updateDash() {
        //SmartDashboard.putString("Alliance Color", DriverStation.getInstance().getAlliance().toString());

        SmartDashboard.putNumber("Left Enc in ticks", Robot.driveTrain.getLeft().getSelectedSensorPosition(DriveTrain.PRIMARY_PID_LOOP));
        SmartDashboard.putNumber("Right Enc in ticks", Robot.driveTrain.getRight().getSelectedSensorPosition(DriveTrain.PRIMARY_PID_LOOP));
        /*SmartDashboard.putNumber("Left Enc in feet", Robot.driveTrain.getLeftEncPositionInFeet());
        SmartDashboard.putNumber("Right Enc in feet", Robot.driveTrain.getRightEncPositionInFeet());*/
        SmartDashboard.putNumber("Left Wheel RPM", MercMath.ticksPerTenthToRevsPerMinute(Robot.driveTrain.getLeft().getSelectedSensorVelocity(DriveTrain.PRIMARY_PID_LOOP))); //ticks per tenth of a second
        SmartDashboard.putNumber("Right Wheel RPM", MercMath.ticksPerTenthToRevsPerMinute(Robot.driveTrain.getRight().getSelectedSensorVelocity(DriveTrain.PRIMARY_PID_LOOP)));
        //SmartDashboard.putNumber("LIDAR Raw Distance (in.)", MercMath.roundFloat(Robot.claw.getLidar().getRawDistance(), 10));
        //SmartDashboard.putNumber("LIDAR Period", MercMath.roundFloat(Robot.claw.getLidar().getDistance(), 10));
        SmartDashboard.putNumber("Gyro Angle", Robot.driveTrain.getGyro().getAngle());
        SmartDashboard.putBoolean("Auton Initialized", ntInstance.getTable("AutonConfiguration").containsKey("startingPosition"));
        //SmartDashboard.putString("LED Output",Robot.claw.getCurrentLEDOutput()[0]+","+Robot.claw.getCurrentLEDOutput()[1]+","+Robot.claw.getCurrentLEDOutput()[2]);
    }
}
