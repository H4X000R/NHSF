package com.divyeshbc.NHSF.tabs.sewa;

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
 * Created by DivyeshBC on 04/06/15.
 */
public class Tab5 extends Fragment {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterSewa adapter;

    private static final int ITEM_COUNT = 6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.tab_5, container, false);

        //Instantiating the recycler view as defined in tab_1
        mRecyclerView = (android.support.v7.widget.RecyclerView) layout.findViewById(R.id.sewa_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter = new RecyclerViewAdapterSewa(getActivity(), getData());

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
        String[] text = {"Sewa Campaigns", "Idea Bank", "Sewa Inspiration", "Events On A Plate", "National Charity", "Sewa University Guide"};
        String[] subText = {"Sewa Day, National Donation Day, Help The Homeless & Sewa Week", "Sewa Ideas Document", "Sewa Videos & Sewa Quotes", "Google Drive", "Divya Seva Foundation", "Who To Contact & Where To Go"};

        //For loop to go through entire length of the menu string
        //for(int i=0; i<menu.length; i++) {

        for(int i=0; i<ITEM_COUNT; i++){

            data.add(new Information(text[i], subText[i]));

        }

        return data;
    }
}

