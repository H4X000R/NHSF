package com.divyeshbc.NHSF;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

/**
 * Created by DivyeshBC on 25/05/15.
 */
//Creating a Base Activity class that can be used throughout the app consisting of shared activities
public class BaseActivity extends ActionBarActivity {

    //Variable to store the Toolbar
    private Toolbar mToolbar;

    //Method to create Custom ToolBar
    protected Toolbar activateToolBar() {
        //If no toolbar has been created then create a new toolbar using Toolbar View app_bar
        if(mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);

            //mToolbar.setSubtitle("National Hindu Students' Forum (UK)");


            //If toolbar already created then no need to create a new one.
            if(mToolbar != null) {
                //Use current toolbar
                setSupportActionBar(mToolbar);
            }
        }

        mToolbar.getMenu().clear();

        //Logic for setting the colour of the status bar
        //If the Android OS on the phone is Android Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //Set Status bar colour to Orange
            getWindow().setStatusBarColor(getResources().getColor(R.color.baseSecondaryBackgroundColour));

        }
        /*
        else {
            //Set Status bar colour to Black
            getWindow().setStatusBarColor(getResources().getColor(R.color.md_black_1000));
        }
        */

        //Return the created Toolbar
        return mToolbar;
    }


    //Method to add the 'Back Arrow' to allow user to navigate back to Home View
    protected Toolbar activateToolbarWithHomeEnabled() {
        //Create standard Toolbar
        activateToolBar();
        if(mToolbar != null) {
            //If Toolbar is created then automatically add the 'Back Arrow (Left Arrow)' symbol to home view
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return mToolbar;
    }


}