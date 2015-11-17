package com.divyeshbc.NHSF.tabs.aboutUs;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;
import com.divyeshbc.NHSF.SubInformation;
import com.divyeshbc.NHSF.tabs.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyeshBC on 27/10/15.
 */
public class NationalCommitteeActivity extends BaseActivity implements RecyclerViewAdapterNationalCommiitee.ClickListener {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterNationalCommiitee adapter;

    private static final int ITEM_COUNT = 2;

    @Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.national_committee);

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //final View layout = inflater.inflate(R.layout.national_committee, container, false);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Instantiating the recycler view as defined in national_committee
        mRecyclerView=(RecyclerView) findViewById(R.id.natcom_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter=new RecyclerViewAdapterNationalCommiitee(this,getData());

        //Here passing in the click listener into the Adapter. 'this' signifies that it is the fragment that handles the click listener.
        //This is possible as the on Click Listener interface is being implemented.
        adapter.setClickListener(this);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    //return layout;

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_email) {

            //Invoking new intent to allow user to send email
            Intent emailIntent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));

            //Setting an array up for the recipient
            String emailRecipient[] = {"info@nhsf.org.uk"};

            //Allowing the user to select with what application they would like to send the email
            //startActivity(Intent.createChooser(emailIntent, "Send your email via:"));

            //Here providing the email address to which the email is being sent
            emailIntent.putExtra(Intent.EXTRA_EMAIL, emailRecipient);

            //Prompt email clients only
            emailIntent.setType("message/rfc822");

            //Navigate to the above intent
            startActivity(Intent.createChooser(emailIntent, "Choose an email client:"));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Creating an array list of information objects that can be passed into the recycler view
    public static List<SubInformation> getData() {

        List<SubInformation> data = new ArrayList<>();

        //String array of text for the recycler view
        String[] text = {"Admin Team", "Team Coordinators"};

        //For loop to go through entire length of the menu string
        for(int i=0; i<ITEM_COUNT; i++){

            data.add(new SubInformation(text[i]));

        }

        return data;
    }

    @Override
    public void itemClicked(View view, int position) {

    }
}

