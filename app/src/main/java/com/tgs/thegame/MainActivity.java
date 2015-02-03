package com.tgs.thegame;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.jme3.app.AndroidHarness;
import com.jme3.renderer.android.TextureUtil;
import com.jme3.system.android.AndroidConfigChooser;

import java.util.logging.Level;
import java.util.logging.LogManager;


public class MainActivity extends AndroidHarness {

    public MainActivity() {
        // Set the application class to run
        appClass = Game.class.getCanonicalName();

        // Try ConfigType.FASTEST; or ConfigType.LEGACY if you have problems
        eglConfigType = AndroidConfigChooser.ConfigType.BEST;

        // Exit Dialog title & message
        exitDialogTitle = "Exit?";
        exitDialogMessage = "Are you sure you want to quit?";

        // Choose screen orientation
        screenOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        // Enable MouseEvents being generated from TouchEvents (default = true)
        mouseEventsEnabled = true;

        TextureUtil.ENABLE_COMPRESSION = false;

        // Set the default logging level (default=Level.INFO, Level.ALL=All Debug Info)
        LogManager.getLogManager().getLogger("").setLevel(Level.INFO);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideNavigationBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void hideNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            View decorView = getWindow().getDecorView();
            // View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
            int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

}