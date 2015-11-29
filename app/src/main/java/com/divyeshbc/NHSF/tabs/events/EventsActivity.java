package com.divyeshbc.NHSF.tabs.events;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;

/**
 * Created by DivyeshBC on 09/11/15.
 */
public class EventsActivity extends BaseActivity implements RecyclerViewAdapterEvents.ClickListener {

    //String returning all EVENT Object properties
    public static final String EVENT_TRANSFER = "EVENT_TRANSFER";

    EditText postcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        //Enabling the toolbar
        activateToolBar();

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Retrieving current intent NOT CREATING a new one
        Intent intent = getIntent();

        //Returning the event object that is passed from the Tab3 activity
        JSONEventsItem event = (JSONEventsItem) intent.getSerializableExtra(EVENT_TRANSFER);

        //Linking the event title text view from the event_details view
        TextView eventTitle = (TextView) findViewById(R.id.eventName);

        //Getting the event title
        eventTitle.setText(event.getEventName());

        //Linking the event date text view from the event_details view
        TextView eventDate = (TextView) findViewById(R.id.eventDate);

        //Getting the event date
        eventDate.setText(event.getEventDate());

        //Linking the event time text view from the event_details view
        TextView eventTime = (TextView) findViewById(R.id.eventTime);

        //Getting the event time
        eventTime.setText(event.getEventTime());

        //Linking the event location text view from the event_details view
        TextView eventLocation = (TextView) findViewById(R.id.eventLocation);

        //Getting the event location
        eventLocation.setText(event.getEventLocation());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar enough_food it is present.
        getMenuInflater().inflate(R.menu.menu_events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_map) {

            //Setting the postcode variable to the editText view in eventDetails
            postcode = (EditText) findViewById(R.id.editText);

            //Getting the entered postcode
            String location = postcode.getText().toString();

            Uri gmmIntentUri = Uri.parse("google.navigation:q="+location);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
