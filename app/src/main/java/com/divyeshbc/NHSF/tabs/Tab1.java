package com.divyeshbc.NHSF.tabs;

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
import com.divyeshbc.NHSF.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyeshBC on 25/05/15.
 */
public class Tab1 extends Fragment {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapter adapter;

    private static final int ITEM_COUNT = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout =inflater.inflate(R.layout.tab_1,container,false);

        //Instantiating the recycler view as defined in tab_1
        mRecyclerView = (RecyclerView) layout.findViewById(R.id.about_us_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter = new RecyclerViewAdapter(getActivity(), getData());

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
        String[] text = {"Introduction", "National Committee (Natcom)"};
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
}