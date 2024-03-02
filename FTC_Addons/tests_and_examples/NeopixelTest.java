package org.firstinspires.ftc.teamcode.hardwareClasses.FTC_Addons.tests_and_examples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardwareClasses.FTC_Addons.AdafruitNeodriver;

@TeleOp
//@Disabled
public class NeopixelTest extends LinearOpMode {

    AdafruitNeodriver neo;



    @Override
    public void runOpMode() throws InterruptedException {

        initialize_opmode();

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive() && !isStopRequested()) {



                int WRGB = 0x333333;
                for (int i = 0; i < 12; i++){
                    neo.setColor(WRGB, (short) i);
                }

                sleep(1000);
                neo.clearAllPixels();
                sleep(1000);

                int red = ((WRGB >> (8*2)) & 0xfe);
                int green = ((WRGB >> (8*1)) & 0xfe);
                int blue = ((WRGB >> (8*0)) & 0xfe);
                int white = ((WRGB >> (8*3)) & 0xfe);

                telemetry.addData("red = ", red);
                telemetry.addData("green = ", green);
                telemetry.addData("blue = ", blue);
                telemetry.addData("white = ", white);


                telemetry.update();

            }


        }

    }

    public void initialize_opmode(){
        neo = hardwareMap.get(AdafruitNeodriver.class, "neopixels");
        neo.setPixelType(AdafruitNeodriver.ColorOrder.NEO_GRB);
        neo.init_neopixels();

    }
}
