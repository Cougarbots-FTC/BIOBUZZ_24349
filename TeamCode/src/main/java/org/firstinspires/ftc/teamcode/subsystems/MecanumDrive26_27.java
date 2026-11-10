package org.firstinspires.ftc.teamcode.subsystems;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

    public class MecanumDrive26_27 {
        private final DcMotorEx front_left, front_right, back_left, back_right;

        private final Gamepad driver1, driver2;
        //private final double AUTO_SPEED = -0.75;

        private double speed = 1;

        public MecanumDrive26_27(OpMode mode) {

            driver1 = mode.gamepad1;
            driver2 = mode.gamepad2;

            HardwareMap hardwareMap = mode.hardwareMap;
            front_left = hardwareMap.get(DcMotorEx.class, "FrontLeft"); //2
            front_right = hardwareMap.get(DcMotorEx.class, "FrontRight"); //0
            back_left = hardwareMap.get(DcMotorEx.class, "BackLeft"); //1
            back_right = hardwareMap.get(DcMotorEx.class, "BackRight"); //3

            //this will make drivetrain used correctly
            back_left.setDirection(DcMotorEx.Direction.REVERSE);
            //front_right.setDirection(DcMotorEx.Direction.REVERSE);
            back_right.setDirection(DcMotorEx.Direction.REVERSE);
            front_left.setDirection(DcMotorEx.Direction.REVERSE);


            back_left.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            back_right.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            front_left.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
            front_right.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        }

        public void mecanumDrive() {

            if (driver1.right_bumper) {
                speed = 0.5;
            } else {
                speed = 1;
            }
            // You may need to multiply some of these by -1 to invert direction of
            // the motor.  This is not an issue with the calculations themselves.
            double vertical = driver1.left_stick_y;
            double horizontal = driver1.left_stick_x * 1.1; //  Multiply by 1.1 to negate imperfect strafing
            double pivot = driver1.right_stick_x;

            //Obtains values for each motor through the positions through values
            //from  left joystick which has up/down(vertical) and left/right values(horizontal), and right joystick which has left/right values(pivot)
            double denominator = Math.max(Math.abs(vertical) + Math.abs(horizontal) + Math.abs(pivot), 1);
            double rightFrontPower = (vertical + horizontal + pivot) / denominator * speed;
            double rightBackPower = (vertical - horizontal + pivot) / denominator * speed;
            double LeftFrontPower = (vertical - horizontal - pivot) / denominator * speed;
            double LeftBackPower = (vertical + horizontal - pivot) / denominator * speed;

            front_left.setPower(LeftFrontPower);
            front_right.setPower(rightFrontPower);
            back_left.setPower(LeftBackPower);
            back_right.setPower(rightBackPower);
        }


        public void auto(int time, double autoSpeed) {

            front_left.setPower(autoSpeed);
            front_right.setPower(autoSpeed);
            back_left.setPower(autoSpeed);
            back_right.setPower(autoSpeed);

            try {
                sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            front_left.setPower(0);
            front_right.setPower(0);
            back_left.setPower(0);
            back_right.setPower(0);


        }

        public void addTelemetry(OpMode opMode) {
            opMode.telemetry.addData("Left Back: ", back_left.getCurrent(CurrentUnit.AMPS));
            opMode.telemetry.addData("Right Back: ", back_right.getCurrent(CurrentUnit.AMPS));
            opMode.telemetry.addData("Left Front: ", front_left.getCurrent(CurrentUnit.AMPS));
            opMode.telemetry.addData("Right Front: ", front_left.getCurrent(CurrentUnit.AMPS));

            opMode.telemetry.update();
        }
}
