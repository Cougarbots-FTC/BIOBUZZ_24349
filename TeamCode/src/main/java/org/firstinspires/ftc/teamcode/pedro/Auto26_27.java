package org.firstinspires.ftc.teamcode.pedro;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive26_27;

@Autonomous(name="Leave and Park auto from corner")
public class Auto26_27 extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private MecanumDrive26_27 mecanumDrive;


    @Override
    public void runOpMode() throws InterruptedException {
        mecanumDrive = new MecanumDrive26_27(this);

        waitForStart();
        runtime.reset();

        //TODO: test if time and power are good
        mecanumDrive.auto(350, 0.7);

        while (opModeIsActive()){// && (runtime.seconds() < 10.0)) {
            //telemetry.addData("Status", "Auto move complete");
            telemetry.addData("Time", runtime.time());
            telemetry.update();
        }
    }
}