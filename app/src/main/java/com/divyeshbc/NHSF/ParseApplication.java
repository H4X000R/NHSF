package com.divyeshbc.NHSF;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * Created by DivyeshBC on 09/09/15.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        //Configuring Parse
        Parse.initialize(this, "Ba3KK8bC10GCznAsNI8HML52qmYcZqEso1uKNfPM", "LFf9YwRIxB04tRdSFrYjZQTooQQWV1XIFVPIFHGh");

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

    }
}
