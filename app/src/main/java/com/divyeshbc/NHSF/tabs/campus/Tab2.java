package com.divyeshbc.NHSF.tabs.campus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divyeshbc.NHSF.Chapter;
import com.divyeshbc.NHSF.R;

import java.util.ArrayList;

/**
 * Created by DivyeshBC on 25/05/15.
 */
public class Tab2 extends Fragment {

    private RecyclerView mRecyclerView;
    private CardView cardView;

    private ArrayList<Chapter> chapters;

    private RecyclerView.Adapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_2,container,false);

        //Fetching setChapters to retrieve data
        setChapters();

        //Instantiating the recycler view as defined in tab_2
        mRecyclerView = (RecyclerView) v.findViewById(R.id.campus_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // ListView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // create an Object for Adapter
        mAdapter = new CardViewAdapter(getActivity(), chapters);

        // set the adapter object to the Recyclerview
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    public void setChapters(){

        final String[] affiliatedChapters = {"NHSF Aston", "NHSF BCU", "NHSF Birmingham", "NHSF BPP",
                "NHSF Bradford", "NHSF Brighton", "NHSF Bristol", "NHSF Brunel",
                "NHSF Bucks New Uni"};
        final int[] logos = {R.drawable.nhsf_aston, R.drawable.nhsf_bcu, R.drawable.nhsf_birmingham, R.drawable.nhsf_bpp, R.drawable.nhsf_bradford, R.drawable.nhsf_brighton, R.drawable.nhsf_bristol, R.drawable.nhsf_brunel, R.drawable.nhsf_bucks_new_uni};

        final String[] zones = {"Central Zone - Coordinator: Shivanee Ardeshana", "Central Zone - Coordinator: Shivanee Ardeshana",
                "Central Zone - Coordinator: Shivanee Ardeshana", "Central Zone - Coordinator: Shivanee Ardeshana", "Central Zone - Coordinator: Shivanee Ardeshana",
                "Central Zone - Coordinator: Shivanee Ardeshana", "Central Zone - Coordinator: Shivanee Ardeshana", "Central Zone - Coordinator: Shivanee Ardeshana",
                "Central Zone - Coordinator: Shivanee Ardeshana"};

        final String[] chapterCommittees = {"PRESIDENT: Shailee Patel \nVP: Dhimant Mehta \nSECRETARIES: Raj Sivlal & Karishma Patel \nTREASURERS: Ajay Mistry & Akshay Nagda " +
                "\nEVENTS: Ashni Mehta, Avni Vaghela & Natasha Sandle \nPR: Hetal Patel, Trisha Kandlur & Priyesh Patel \nSEWA: Krishna Jethwa & Chandni Gadhia " +
                "\nLEARNING: Akshay Bhardwa & Trusha Parikh \nSPORTS: Neelam Mistry & Colette Rodrigues \nRELIGIOUS: Trusha Parikh & Akshay Bhardwa, " +
                "\nADVISORY: Nikhil Parekh, Dev Patel, Anjali Bharania, Rupal Chavda & Radhika Madlani",

                "President: AAAA, VP: sadsff, Secretrary: dfsfs",
                "President: AAAA, VP: sadsff, Secretrary: dfsfs", "President: AAAA, VP: sadsff, Secretrary: dfsfs", "President: AAAA, VP: sadsff, Secretrary: dfsfs",
                "President: AAAA, VP: sadsff, Secretrary: dfsfs", "President: AAAA, VP: sadsff, Secretrary: dfsfs",
                "President: AAAA, VP: sadsff, Secretrary: dfsfs", "President: AAAA, VP: sadsff, Secretrary: dfsfs"};

        chapters = new ArrayList<Chapter>();

        for (int i = 0; i < affiliatedChapters.length; i++) {
            Chapter feed = new Chapter();

            feed.setTitle(affiliatedChapters[i]);
            feed.setThumbnail(logos[i]);
            feed.setZone(zones[i]);
            feed.setSubTitle(chapterCommittees[i]);
            chapters.add(feed);
        }
    }
}