// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.numbers.N2;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the constants are needed, to
 * reduce verbosity.
 */
public final class Constants {

  /**
   * Stores constants related to the robot.
   */
  public static final class RobotConstants {
    public static final int COUNTS_PER_REV = 2048;
    public static final double SENSOR_GEAR_RATIO = 10.71;
    public static final double WHEEL_RADIUS_INCHES = 6;
    public static final double TRACK_WIDTH = 18.75;
  }

  /**
   * Stores constants related to path following.
   */
  public static final class PathConstants {
    public static final double MAX_DRIVE_SPEED = 1;
    public static final double MAX_ACCELERATION = 0.5;
    public static final double RAMSETE_B = 2.0;
    public static final double RAMSETE_ZETA = 0.7;
    public static final double kS = 0.86841;
    public static final double kV = 4.009;
    public static final double kA = 2.6045;
    public static final double kP = 0.25889;
    public static final double kI = 0;
    public static final double KD = 0.13772;
    public static final double MAX_OFFSET_START = 1;
  }

  /**
   * Stores constants related to this year's playing field.
   */
  public static final class FieldConstants {
    public static final Pose2d[] SCORING_WAYPOINTS = new Pose2d[] {
        new Pose2d(1.57, 0.43, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 1, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 1.6, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 2.2, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 2.7, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 3.3, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 3.85, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 4.4, new Rotation2d(Math.toRadians(180))),
        new Pose2d(1.57, 5, new Rotation2d(Math.toRadians(180)))
    };
    public static final Pose2d[] TRAVELING_WAYPOINTS = new Pose2d[] {
        new Pose2d(2.75, 0.43, new Rotation2d(0)), new Pose2d(2.75, 1, new Rotation2d(0)),
        new Pose2d(2.75, 1.6, new Rotation2d(0)), new Pose2d(2.75, 2.2, new Rotation2d(0)),
        new Pose2d(2.75, 2.7, new Rotation2d(0)), new Pose2d(2.75, 3.3, new Rotation2d(0)),
        new Pose2d(2.75, 3.85, new Rotation2d(0)), new Pose2d(2.75, 4.4, new Rotation2d(0)),
        new Pose2d(2.75, 5, new Rotation2d(0))
    };
    public static final double MAX_AUTO_DISTANCE_METERS = 10;
    public static final double SCORING_ZONE_DEADBAND = 0.5;
  }

  /**
   * Stores constants related to autonomous routines.
   */
  public static final class AutonConstants {
    public static final double SIMPLE_AUTON_SPEED = 0.3;
    public static final double SIMPLE_AUTON_RUNTIME = 3.25;
  }

  public static final class VisionConstants {
    public static final Transform3d ROBOT_TO_FRONT_LEFT_CAMERA =
        new Transform3d(
            new Translation3d(-Units.inchesToMeters(9.766), Units.inchesToMeters(7.852), Units.inchesToMeters(28.242)),
            new Rotation3d());
    public static final Transform3d ROBOT_TO_FRONT_RIGHT_CAMERA =
        new Transform3d(
            new Translation3d(-Units.inchesToMeters(9.766), -Units.inchesToMeters(7.852), Units.inchesToMeters(28.242)),
            new Rotation3d());
    public static final Transform3d ROBOT_TO_REAR_CAMERA =
        new Transform3d(new Translation3d(-Units.inchesToMeters(12.1585), 0.07, Units.inchesToMeters(20.749)),
            new Rotation3d(0, 0, Math.PI));
    public static final double MAINTAIN_CAMERA_CONFIDENCE_THRESHOLD = 0.7;
  }

  /**
   * Stores constants related to driver controls, SmartDashboard and other user interface elements.
   */
  public static final class UIConstants {
    public static final class DriverConstants {
      public static final int DRIVER_JOYSTICK_INDEX = 0;
      public static final boolean SQUARED_INPUTS = true;
      public static final int LEFT_AXIS = 1;
      public static final int RIGHT_AXIS = 5;
      public static final int SLOWDOWN_BUTTON_INDEX = 2;
      public static final double SLOWDOWN_PERCENT = 0.5;
    }

    public static final class OperatorConstants {
      public static final int OPERATOR_JOYSTICK_INDEX = 1;
      public static final double JOYSTICK_DEADBAND = 0.05;
      public static final int ELEVATOR_AXIS = 1;
      public static final int ARM_AXIS = 5;

      public static final int MANUAL_CONTROL_BUTTON_INDEX = 7;
      public static final int INTAKE_BUTTON_INDEX = 5;
      public static final int OUTTAKE_BUTTON_INDEX = 6;

      public static final int LOW_GOAL_BTN_INDEX = 2;
      public static final int MID_GOAL_BTN_INDEX = 1;
      public static final int HIGH_GOAL_BTN_INDEX = 4;
      // public static final int PLACE_CONE_BTN_INDEX = 3;
      public static final int STATION_PICKUP_BTN_INDEX = 3;
      // public static final int CONE_PICKUP_BTN_INDEX = 0;
    }
  }

  /**
   * Stores constants related to the arm.
   */
  public static final class ArmConstants {
    public static final int ENCODER_CHANNEL = 3;
    public static final int LEFT_MOTOR_ID = 21; // TODO: figure out which is left and which is right
    public static final int RIGHT_MOTOR_ID = 22;
    public static final int CURRENT_LIMIT = 40;

    public static final double PIVOT_HEIGHT_FROM_GROUND = 51.428;
    public static final double PIVOT_SETBACK = -27.521;
    public static final double ARM_OFFSET_DEG = 285;
    public static final Rotation2d ZERO_ARM_OFFSET = new Rotation2d(Units.degreesToRadians(60));
    public static final Rotation2d ANGLE_AT_ARM_ZERO = new Rotation2d(Units.degreesToRadians(22));
    public static final double ARM_DEGREES_PER_ROTATION = 360;

    public static final double MAX_VELOCITY_DEG_PER_SEC = 300;
    public static final double MAX_ACCELERATION_DEG_PER_SEC_SQUARED = 1000;
    public static final double MAX_ROTATION_DEG = 75;
    public static final double MIN_ROTATION_DEG = 0;

    public static final double ROTATION_ERROR_DEADBAND = 1;
    public static final double SEQUENTIAL_ROTATION_ERROR_DEADBAND = 5;
    public static final double RETRACT_BEFORE_MOVING_DEADBAND = 5;

    public static final double kP = 0.03;
    public static final double kSVolts = 0;
    public static final double kGVolts = 0;
    public static final double kAVoltSecondSquaredPerRad = 0;
    public static final double kVVoltSecondPerRad = 0;
  }

  /**
   * Stores positions for the arm.
   */
  public static final class ArmPositionConstants {
    public static final Translation2d GROUND_PICKUP = new Translation2d(10, 5);
    public static final Translation2d GROUND_SCORING = new Translation2d(15, 5);
    public static final Translation2d MID_GOAL_SCORING = new Translation2d(22.75, 38);
    public static final Translation2d HIGH_GOAL_SCORING = new Translation2d(39.75, 50);
    public static final Translation2d CONE_SCORING_OFFSET = new Translation2d(0, -4);
    public static final Translation2d PLAYER_STATION_PICKUP = new Translation2d(10, 44.375);
    public static final Translation2d OUTSIDE_BUMPERS = new Translation2d(0, 0);
  }

  /**
   * Stores constants related to the elevator.
   */
  public static final class ElevatorConstants {
    public static final int ENCODER_CHANNEL_A = 0;
    public static final int ENCODER_CHANNEL_B = 1;
    public static final int LIMIT_SWITCH_CHANNEL = 2;
    public static final int ELEVATOR_MOTOR_ID = 31;
    public static final int CURRENT_LIMIT = 20;

    public static final double LENGTH_FULLY_RETRACTED = 42.25;
    public static final double LENGTH_RETRACTED_BEFORE_ROTATING = 0.5;
    public static final double MAX_EXTENSION_INCHES = 29;
    public static final double MIN_EXTENSION_INCHES = -0.1;
    public static final double HOME_SPEED = 0.18;
    public static final double MAX_VELOCITY_INCHES_PER_SEC = 10;
    public static final double MAX_ACCELERATION_INCHES_PER_SEC_SQUARED = 5;
    public static final double DISTANCE_PER_PULSE = 5.5 / 2048; // 5.5 inches for a 22 tooth-sprocket with 1/4" chain
                                                                // links
    public static final double kS = 0.32321;
    public static final double kV = 0.123766;
    public static final double kA = 0.0853;
    public static final double kG = -0.11681;
    public static final double kP = 0.16023;
  }

  /**
   * Stores constants related to the intake.
   */
  public static final class IntakeConstants {
    public static final int LEFT_MOTOR_ID = 0;
    public static final int RIGHT_MOTOR_ID = 1;

    public static final double INTAKE_HEIGHT = 6.37;

    public static final double OUTTAKE_VOLTAGE = 2.4;
    public static final double INTAKE_VOLTAGE = -5;
    public static final double PASSIVE_INTAKE_VOLTAGE = -1.6;
  }

  /**
   * Stores constants related to the DriveBase.
   */
  public static final class DriveConstants {
    public static final double ACCELERATION_RATE_LIMIT = 1.5;
    public static final DifferentialDriveKinematics KINEMATICS =
        new DifferentialDriveKinematics(Units.inchesToMeters(RobotConstants.TRACK_WIDTH));

    public static final class DriveMotorCANIDs {
      public static final int RIGHT_FRONT = 14;
      public static final int RIGHT_BACK = 13;
      public static final int LEFT_FRONT = 12;
      public static final int LEFT_BACK = 11;
    }

    public static final int STATOR_CURRENT_LIMIT = 80;
    public static final int SUPPLY_CURRENT_LIMIT = 80;
    public static final int STATOR_TRIGGER_THRESHOLD = 100;
    public static final double STATOR_TRIGGER_THRESHOLD_TIME = 0.5;
    public static final int SUPPLY_TRIGGER_THRESHOLD = 100;
    public static final double SUPPLY_TRIGGER_THRESHOLD_TIME = 0.5;
    public static final double SLEW_RATE_LIMIT = 1.8;

    public static final LinearSystem<N2, N2, N2> kDrivetrainPlant =
    LinearSystemId.identifyDrivetrainSystem(
        PathConstants.kV,
        PathConstants.kA,
        20,
        10);

// Example values only -- use what's on your physical robot!
public static final DCMotor kDriveGearbox = DCMotor.getFalcon500(2);
public static final double kDriveGearing = 10.71;
  }
}
