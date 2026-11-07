/*
package org.firstinspires.ftc.teamcode.opMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.*;


@TeleOp(name = "TeleOp - THIS ONE 24349")
public class DriverCentricTeleOp25_26 extends OpMode {

    //private Intake intake;
    //private Delivery delivery;
    private Outtake25_26 outtake;
    private Intake2434925_26 intake;
    private MecanumDrive25_26 mecanumDrive;
    private Holder holder;

    @Override
    public void init() {
        //intake = new Intake(this);
        //delivery = new Delivery(this);
        outtake = new Outtake25_26(this);
        mecanumDrive = new MecanumDrive25_26(this);
        //holder = new Holder(this);
        intake = new Intake2434925_26(this);

    }

    @Override
    public void loop() {
        mecanumDrive.mecanumDrive();
        //delivery.teleOp();
        intake.teleOp();
        outtake.teleOp();
        //holder.teleOp();
        mecanumDrive.addTelemetry(this);
    }
}
*/