package frc.robot.subsystems;

import javax.swing.RowFilter.ComparisonType;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.Items.SparkMax.SparkController;
import frc.lib.configs.Sparkmax.SparkControllerInfo;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    private SparkController topRoller;
    private SparkController bottomRoller;

    private CANSparkMax topMotor;
    private CANSparkMax bottomMotor;

    private RelativeEncoder topEncoder;
    private RelativeEncoder bottomEncoder; 

    private SparkPIDController topController;
    private SparkPIDController bottomController;

    

    public Intake(){

        this.topRoller = new SparkController(Constants.Setup.topRoller, new SparkControllerInfo().shooterWheel(Constants.Setup.shooterInverts.left));
        this.bottomRoller = new SparkController(Constants.Setup.bottomRoller, new SparkControllerInfo().shooterWheel(Constants.Setup.shooterInverts.right));

        this.topMotor = topRoller.spark;
        this.bottomMotor = bottomRoller.spark;
        
        this.topEncoder = topRoller.sparkEncode;
        this.bottomEncoder = bottomRoller.sparkEncode;

        this.topController = topRoller.sparkControl;
    }

    public void setDutyCylce(double percent){
        percent = percent/100;
        topController.setReference(percent, CANSparkBase.ControlType.kDutyCycle);
        bottomController.setReference(percent, CANSparkBase.ControlType.kDutyCycle);
    }

    
}