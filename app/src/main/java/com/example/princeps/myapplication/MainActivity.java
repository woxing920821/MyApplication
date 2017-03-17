package com.example.princeps.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Camera;
//import android.graphics.Camera;

public class MainActivity extends AppCompatActivity {
    private static int defaultCameraId = 0;
    private static Camera mcamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //camera = getCameraInstance()
        mcamera = Camera.open();
        if (mcamera == null)
            System.out.println("camera is null");
        else
            System.out.println("camera is work");
        mcamera.stopPreview();
        mcamera.release();
        mcamera = null;

    }
    public static Camera getCameraInstance() {
        int numberOfCameras = Camera.getNumberOfCameras();

        // Find the ID of the default camera
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                defaultCameraId = i;
            }
        }

        Camera c = null;
        try {
            c = Camera.open(defaultCameraId); // attempt to get a Camera instance
        }
        catch (Exception e) { } // Camera is not available (in use or does not exist)
        return c; // returns null if camera is unavailable
    }
}
