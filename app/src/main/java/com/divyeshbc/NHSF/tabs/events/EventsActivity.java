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
    String location;
    JSONEventsItem event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Retrieving current intent NOT CREATING a new one
        Intent intent = getIntent();

        //Returning the event object that is passed from the Tab3 activity
        event = (JSONEventsItem) intent.getSerializableExtra(EVENT_TRANSFER);

        //Here checking to see if the postcode field for the location is empty
        if (event.getEventPostcode().isEmpty()) {

            //Log.e("Fetching Postcode", "Postocode is");

            //If it is empty then set the view to event_details2 (with option to enter postcode)
            setContentView(R.layout.event_details2);
            activateToolBar();

            //Linking the event postcode text view from the event_details view
            postcode = (EditText) findViewById(R.id.editText);

            //Getting the above typed postcode as the event postcode
            postcode.getText().toString();

            //Log.e("Postcode Blank", "Event Details 2");
        }

        else {

            //Else if postcode is not blank then set to the event_details (no option for post code entry direct 'get directions)
            setContentView(R.layout.event_details);
            activateToolBar();

            //Linking the event location text view from the event_details view
            //TextView eventPostcode = (TextView) findViewById(R.id.eventPostcode);

            //Getting the event location
            //eventPostcode.setText("Postcode: " + event.getEventPostcode());

            //Log.e("Fetching Postcode", "Postcode is");
            //Log.e("Post code not Blank", "Event Detail selected");
        }

        //setContentView(R.layout.event_details);

        //Enabling the toolbar
        //activateToolBar();

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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

            if (event.getEventPostcode().isEmpty()) {
                //Setting the postcode variable to the editText view in eventDetails
                postcode = (EditText) findViewById(R.id.editText);

                //Getting the entered postcode
                location = postcode.getText().toString();

            }
            else {

                //Setting the location to the address postcode
                 location = event.getEventPostcode();
            }

            Uri gmmIntentUri = Uri.parse("google.navigation:q="+location);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
