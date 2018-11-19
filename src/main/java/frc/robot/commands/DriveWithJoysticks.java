package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap.DS_USB;
import frc.util.TalonDrive;

/**
 * Command that puts the drive train into a manual control mode.
 * This puts the robot in arcade drive.
 */
public class DriveWithJoysticks extends Command {
	private TalonDrive tDrive;
	//private static Logger log = LogManager.getLogger(DriveWithJoysticks.class);
	//private DelayableLogger everySecond = new DelayableLogger(log, 10, TimeUnit.SECONDS);
	private DriveType driveType;

	public enum DriveType {
		TANK,
		ARCADE
	}


	public DriveWithJoysticks(DriveType type) {
		requires(Robot.driveTrain);
		setName("DriveWithJoysticks Command");
		driveType = type;
		//log.debug(getName() + " command created");
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		tDrive = Robot.driveTrain.getTalonDrive();
		//log.info("Set max output to: " + tDrive.getMaxOutput());
		Robot.driveTrain.setNeutralMode(NeutralMode.Brake);
		//log.info(getName() + " command initialized");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
			switch (driveType) {
				case TANK:
					tDrive.tankDrive(Robot.oi.getY(DS_USB.LEFT_STICK), Robot.oi.getY(DS_USB.RIGHT_STICK));
					break;
				case ARCADE:
					tDrive.arcadeDrive(Robot.oi.getY(DS_USB.LEFT_STICK), -Robot.oi.getX(DS_USB.RIGHT_STICK), true);
					break;
			}
		}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
        Robot.driveTrain.setNeutralMode(NeutralMode.Brake);
		Robot.driveTrain.stop();
		//log.info(getName() + "ended");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		//log.info(getName() + "interrupted");
		end();
	}
}
