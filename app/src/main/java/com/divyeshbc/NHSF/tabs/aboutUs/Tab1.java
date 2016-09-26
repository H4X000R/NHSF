package com.divyeshbc.NHSF.tabs.aboutUs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divyeshbc.NHSF.Information;
import com.divyeshbc.NHSF.R;
import com.divyeshbc.NHSF.tabs.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyeshBC on 25/05/15.
 */
public class Tab1 extends Fragment implements RecyclerViewAdapter.ClickListener{

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapter adapter;

    private static final int ITEM_COUNT = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View layout =inflater.inflate(R.layout.tab_1,container,false);

        //Instantiating the recycler view as defined in tab_1
        mRecyclerView = (RecyclerView) layout.findViewById(R.id.about_us_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter = new RecyclerViewAdapter(getActivity(), getData());

        //Here passing in the click listener into the Adapter. 'this' signifies that it is the fragment that handles the click listener.
        //This is possible as the on Click Listener interface is being implemented.
        adapter.setClickListener(this);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return layout;
    }


            //Creating an array list of information objects that can be passed into the recycler view
    public static List<Information> getData() {

        List<Information> data = new ArrayList<>();

        //String array of text for the recycler view
        String[] text = {"Introduction", "National Committee (NatCom)"};
        String[] subText = {"What is NHSF?", "Admin Team and Team Coordinators"};

        //For loop to go through entire length of the menu string
        //for(int i=0; i<menu.length; i++) {

        for(int i=0; i<ITEM_COUNT; i++){


                //Information current = new Information();
                //Information subCurrent = new Information();

                //current.title = text[i];
                //subCurrent.subtitle = subText[i];

                data.add(new Information(text[i], subText[i]));

            }

        return data;
    }

    //Because the click listener is being implemented, here it needs to be overridden
    @Override
    public void itemClicked(View view, int position) {

    }
}