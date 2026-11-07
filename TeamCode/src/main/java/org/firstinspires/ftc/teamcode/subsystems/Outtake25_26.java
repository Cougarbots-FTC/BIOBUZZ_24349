package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake25_26 {
    private DcMotorEx outtake, outtake2;
    private Gamepad driver1, driver2;
    private int targetVelocity;

    public Outtake25_26(OpMode mode) {
        driver1 = mode.gamepad1;
        driver2 = mode.gamepad2;
        targetVelocity = 1200;

        HardwareMap hardwareMap = mode.hardwareMap;
        outtake = hardwareMap.get(DcMotorEx.class, "Outtake");   //e 3
        //outtake2 = hardwareMap.get(DcMotor.class, "Outtake2"); //e 1
    }
    public void teleOp() {

        if (driver2.xWasPressed()) {
            outtake.setVelocity(-targetVelocity);
        } else if(driver2.yWasPressed()) {
            outtake.setVelocity(0);
        }
        if (driver2.aWasPressed()) {
            targetVelocity -= 10;
        }
        else if(driver2.bWasPressed()) {
            targetVelocity += 10;
        }
        //outtake.setPower(driver2.left_stick_y);
    }

    public void addTelemetry(OpMode opMode) {
        opMode.telemetry.addData("Target Velocity: ", targetVelocity);
        opMode.telemetry.addData("Outtake Velocity: ", outtake.getVelocity());
        opMode.telemetry.update();
    }
}
