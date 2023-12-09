// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DutyCycleEncoder;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final CANSparkMax m_driveMotor;
  private final CANSparkMax m_turningMotor;
  private final DutyCycleEncoder encoder;
  public ExampleSubsystem() {
    m_driveMotor = new CANSparkMax(Constants.OperatorConstants.sparkmax1, MotorType.kBrushless);
    m_turningMotor = new CANSparkMax(Constants.OperatorConstants.sparkmax2, MotorType.kBrushless);
    encoder = new DutyCycleEncoder(0);
    encoder.setDistancePerRotation(360.0);
    encoder.reset();


   
    
  }

  public void run(){ 
    m_driveMotor.set(0.2);
    m_turningMotor.set(0.2);   
  }
  public void runback(){ 
    m_driveMotor.set(-0.2);
    m_turningMotor.set(-0.2);   
  }

  
  
  public void stop(){ 
    m_driveMotor.set(0);
    m_turningMotor.set(0);   
  }


  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
