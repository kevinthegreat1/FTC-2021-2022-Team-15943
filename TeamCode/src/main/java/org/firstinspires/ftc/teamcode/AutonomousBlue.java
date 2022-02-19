/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 * <p>
 * The code assumes that you do NOT have encoders on the wheels,
 * otherwise you would use: PushbotAutoDriveByEncoder;
 * <p>
 * The desired path in this example is:
 * - Drive forward for 3 seconds
 * - Spin right for 1.3 seconds
 * - Drive Backwards for 1 Second
 * - Stop and close the claw.
 * <p>
 * The code is written in a simple form with no optimizations.
 * However, there are several ways that this type of sequence could be streamlined,
 * <p>
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name = "AutonomousBlue", group = "Pushbot")
public class AutonomousBlue extends LinearOpMode {

    @Override
    public void runOpMode() {
        /* Declare OpMode members. */
        DcMotor leftFront = hardwareMap.dcMotor.get("leftFront");
        DcMotor rightFront = hardwareMap.dcMotor.get("rightFront");
        DcMotor leftBack = hardwareMap.dcMotor.get("leftBack");
        DcMotor rightBack = hardwareMap.dcMotor.get("rightBack");
        DcMotor intake = hardwareMap.dcMotor.get("intake");
        DcMotor output = hardwareMap.dcMotor.get("output");
        DcMotor duck = hardwareMap.dcMotor.get("duck");

        rightFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.REVERSE);
        output.setDirection(DcMotor.Direction.FORWARD);
        duck.setDirection(DcMotor.Direction.FORWARD);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        leftFront.setPower(1);
        rightFront.setPower(1);
        leftBack.setPower(1);
        rightBack.setPower(1);
        sleep(1000);
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        output.setPower(-1);
        sleep(1000);
        output.setPower(1);
        sleep(980);
        output.setPower(0);
        leftFront.setPower(1);
        rightFront.setPower(-1);
        leftBack.setPower(1);
        rightBack.setPower(-1);
        sleep(1200);
        leftFront.setPower(1);
        rightFront.setPower(1);
        leftBack.setPower(1);
        rightBack.setPower(1);
        sleep(10000);
    }
}
