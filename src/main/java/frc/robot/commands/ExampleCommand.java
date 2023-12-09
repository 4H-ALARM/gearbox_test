package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DutyCycleEncoder;


public class ExampleCommand extends CommandBase {
  private ExampleSubsystem m_Open;
  private final DutyCycleEncoder encoder;
  double m_Angle = 0.0;

  /** Creates a new GrabberOpen. */
  public ExampleCommand(ExampleSubsystem o, double angle) {
    this.m_Open = o;
    this.m_Angle = angle;
    this.encoder = new DutyCycleEncoder(0);
    

    // Use addRequirements(g) here to declare subsystem dependencies.
    addRequirements(o);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    encoder.setDistancePerRotation(360.0);
    encoder.reset();
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_Angle-encoder.getDistance() > encoder.getDistance()-m_Angle) {
      m_Open.run();
    } else {
      m_Open.runback();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Open.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_Angle-encoder.getDistance() > encoder.getDistance()-m_Angle) {
      if (encoder.getDistance() >= m_Angle ) {
        return true;
      }
    
    } else if (encoder.getDistance() <= m_Angle ) {
    return true;
    }
    return false;
  }
}

