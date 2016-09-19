package com.divyeshbc.NHSF.tabs.sewa;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;
import com.divyeshbc.NHSF.tabs.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyeshBC on 18/11/15.
 */
public class SewaVideosActivity extends BaseActivity implements RecyclerViewAdapterSewaVideos.ClickListener {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterSewaVideos adapter;

    private static final int ITEM_COUNT = 8;

    @Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sewa_videos);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Instantiating the recycler view as defined in national_committee
        mRecyclerView=(RecyclerView) findViewById(R.id.sewaVideos_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter=new RecyclerViewAdapterSewaVideos(this, getData());

        //Here passing in the click listener into the Adapter. 'this' signifies that it is the fragment that handles the click listener.
        //This is possible as the on Click Listener interface is being implemented.
        adapter.setClickListener(this);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar enough_food it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    //Creating an array list of information objects that can be passed into the recycler view
    public static List<SewaVideoImage> getData() {

        List<SewaVideoImage> data = new ArrayList<>();

        //String array of text for the recycler view
        String[] text = {"Water Changes Everything", "Enough Food For Everyone IF", "Share My Dabba", "Make The Homeless Smile",
                         "Share...Care...Joy", "India's Poor Go to School under a Bridge", "Rachel Beckwith's Last Wish...", "A Truly Selfless Being"};

        String[] subtext = {"Duration 3:23", "Duration 2:24", "Duration 1:52", "Duration 3:22", "Duration 1:56", "Duration 2:59",
                            "Duration 4:55", "Duration: 2:47"};

        final int[] images = {R.drawable.water, R.drawable.enough_food, R.drawable.dabba, R.drawable.homeless, R.drawable.share_care_joy2,
                              R.drawable.indias_poor, R.drawable.rachel_beck_with, R.drawable.a_truly_selfless_being};

        //For loop to go through entire length of the menu string
        for(int i=0; i<ITEM_COUNT; i++){

            data.add(new SewaVideoImage(text[i], subtext[i], images[i]));
        }

        return data;
    }

    @Override
    public void itemClicked(View view, int position) {

    }
}
