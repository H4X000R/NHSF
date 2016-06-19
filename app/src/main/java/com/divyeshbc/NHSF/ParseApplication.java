package com.divyeshbc.NHSF;

import android.app.Application;

import com.batch.android.Batch;
import com.batch.android.Config;

/**
 * Created by DivyeshBC on 09/09/15.
 *
 * v3.0 - 19-Jun-2016 - Integrating BAtch SDK for Push Notifications as Parse is being discontinued from Jan 2017
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        //v3.0 --
        Batch.Push.setGCMSenderId("1051429278258");

        //Configuring Batch SDK
        Batch.setConfig(new Config("5724CD31B3AAC595B55F9ABBA4761F")); //LIVE API Key - Tested with DEV API Key
        //v3.0 --

        /*
        //Configuring Parse
        Parse.initialize(this, "BHjlrcmscfRYwgbLTAfTWcZc2y3VnhnyQ2mcH57w", "oi3GxqMQWa0caB6f9lYG8gpYXLAhCmTTEXuyguAJ");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        ParseACL.setDefaultACL(defaultACL, true);

        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.d("com.parse.push", "Successfully subscribed to Push");
                } else {
                    Log.d("com.parse.push", "Unsuccessful subscribe to push", e);
                }
            }
        });
        */

    }
}
