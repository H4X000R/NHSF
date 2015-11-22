package com.divyeshbc.NHSF.tabs.events;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;

/**
 * Created by DivyeshBC on 09/11/15.
 */
public class EventsActivity extends BaseActivity implements RecyclerViewAdapterEvents.ClickListener {

    //String returning all EVENT Object properties
    public static final String EVENT_TRANSFER = "EVENT_TRANSFER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        //Enabling the toolbar
        activateToolBar();

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
        //getMenuInflater().inflate(R.menu.intro_pdf_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //enough_food (id == R.id.action_settings) {
        //return true;
        //}

        return super.onOptionsItemSelected(item);
    }

}
