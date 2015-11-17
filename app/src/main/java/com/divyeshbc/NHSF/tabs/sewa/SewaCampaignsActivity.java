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
import com.divyeshbc.NHSF.Information;
import com.divyeshbc.NHSF.R;
import com.divyeshbc.NHSF.tabs.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyeshBC on 16/11/15.
 */
public class SewaCampaignsActivity extends BaseActivity implements RecyclerViewAdapterSewaCampaigns.ClickListener {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterSewaCampaigns adapter;

    private static final int ITEM_COUNT = 4;

    @Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sewa_campaigns);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolBar();

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Instantiating the recycler view as defined in national_committee
        mRecyclerView=(RecyclerView) findViewById(R.id.sewaCampaigns_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter=new RecyclerViewAdapterSewaCampaigns(this, getData());

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
    public static List<Information> getData() {

        List<Information> data = new ArrayList<>();

        //String array of text for the recycler view
        String[] text = {"Sewa Day", "National Donation Day", "Help The Homeless", "Sewa Week"};
        String[] subtext = {"What is Sewa Day?", "What is National Donation Day?", "What is Help The Homeless Campaign?", "What is Sewa Week?"};

        //For loop to go through entire length of the menu string
        for(int i=0; i<ITEM_COUNT; i++){

            data.add(new Information(text[i], subtext[i]));
        }

        return data;
    }

    @Override
    public void itemClicked(View view, int position) {

    }
}
