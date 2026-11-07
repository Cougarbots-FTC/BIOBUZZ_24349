package org.firstinspires.ftc.teamcode.opMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Holder;
import org.firstinspires.ftc.teamcode.subsystems.Intake26_27;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive26_27;
import org.firstinspires.ftc.teamcode.subsystems.Outtake25_26;
import org.firstinspires.ftc.teamcode.subsystems.Outtake26_27;

@TeleOp(name = "TeleOp - BIOBLIZZARD")
public class DriverCentricTeleOp26_27 extends OpMode {

        //private Intake intake;
        //private Delivery delivery;
        private Outtake25_26 outtake;
        private Intake26_27 intake;
        private MecanumDrive26_27 mecanumDrive;
        private Holder holder;

        @Override
        public void init() {
            //intake = new Intake(this);
            //delivery = new Delivery(this);
            outtake = new Outtake25_26(this);
            mecanumDrive = new MecanumDrive26_27(this);
            holder = new Holder(this);
            intake = new Intake26_27(this);

        }

        @Override
        public void loop() {
            mecanumDrive.mecanumDrive();
            //delivery.teleOp();
            intake.teleOp();
            outtake.teleOp();
            holder.teleOp();
            outtake.addTelemetry(this);
            holder.addTelemetry(this);
        }
    }
