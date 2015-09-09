package com.divyeshbc.NHSF;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by DivyeshBC on 09/09/15.
 */
public class ParseApplication extends Application {

    public void onCreate(){

        super.onCreate();

        //Configuring Parse
        Parse.initialize(this, "Ba3KK8bC10GCznAsNI8HML52qmYcZqEso1uKNfPM", "LFf9YwRIxB04tRdSFrYjZQTooQQWV1XIFVPIFHGh");
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
