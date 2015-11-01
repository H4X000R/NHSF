package com.divyeshbc.NHSF.tabs.aboutUs;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class NationalCommittee extends BaseActivity implements RecyclerViewAdapterNationalCommiitee.ClickListener {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterNationalCommiitee adapter;

    private static final int ITEM_COUNT = 2;

    @Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.national_committee);

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


    //Creating an array list of information objects that can be passed into the recycler view
    public static List<SubInformation> getData() {

        List<SubInformation> data = new ArrayList<>();

        //String array of text for the recycler view
        String[] text = {"Admin Team", "Team Coordinators"};
        //String[] subText = {"What is NHSF?", "Admin Team and Team Coordinators"};

        //For loop to go through entire length of the menu string
        //for(int i=0; i<menu.length; i++) {

        for(int i=0; i<ITEM_COUNT; i++){


            //Information current = new Information();
            //Information subCurrent = new Information();

            //current.title = text[i];
            //subCurrent.subtitle = subText[i];

            data.add(new SubInformation(text[i]));

        }

        return data;
    }

    @Override
    public void itemClicked(View view, int position) {

    }
}

