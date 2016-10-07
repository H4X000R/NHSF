package com.divyeshbc.NHSF.tabs.campus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
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
    private CardViewAdapter adapter;
    private ArrayList<Chapter> chapters;

    private RecyclerView.Adapter mAdapter;

    private FloatingActionButton fab1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_2, container, false);

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


        //Floating Action Button For Email Copied from AdminTeam
       /* fab1 = (FloatingActionButton) fab1.findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {

            //3.0 -- Here setting the onClickListener for the FAB
        @Override
        public void onClick(View v) {

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
        }
        });*/
        return v;

    }


    public void setChapters() {

        final String[] affiliatedChapters = {"NHSF Aston", "NHSF BCU", "NHSF Birmingham", "NHSF BPP",
                "NHSF Brighton", "NHSF Bristol", "NHSF Brunel", "NHSF Bucks New Uni", "NHSF City", "NHSF Coventry",
                "NHSF DMU", "NHSF Exeter", "NHSF Greenwich", "NHSF Hertfordshire", "NHSF Huddersfield", "NHSF Hull", "NHSF Imperial",
                "NHSF KCL", "NHSF Keele", "NHSF Kent", "NHSF Kingston", "NHSF Leeds", "NHSF Leicester", "NHSF Lincoln", "NHSF Liverpool", "NHSF Loughborough",
                "NHSF LSBU", "NHSF LSE", "NHSF Manchester", "NHSF Medway", "NHSF Northampton", "NHSF Northumbria", "NHSF Nottingham",
                "NHSF NTU", "NHSF Plymouth", "NHSF Portsmouth", "NHSF QMUL", "NHSF Reading", "NHSF RHUL", "NHSF Roehampton", "NHSF SGUL",
                "NHSF Sheffield", "NHSF Southampton", "NHSF Swansea", "NHSF UEA", "NHSF UWE", "NHSF Warwick", "NHSF Westminster"};

        final int[] logos = {R.drawable.nhsf_aston, R.drawable.nhsf_bcu, R.drawable.nhsf_birmingham, R.drawable.nhsf_bpp, R.drawable.nhsf_brighton,
                R.drawable.nhsf_bristol, R.drawable.nhsf_brunel, R.drawable.nhsf_bucks_new_uni, R.drawable.nhsf_city, R.drawable.nhsf_coventry,
                R.drawable.nhsf_dmu, R.drawable.nhsf_exeter, R.drawable.nhsf_greenwich, R.drawable.nhsf_hertfordshire, R.drawable.nhsf_huddersfield,
                R.drawable.nhsf_hull, R.drawable.nhsf_imperial, R.drawable.nhsf_kcl, R.drawable.nhsf_keele, R.drawable.nhsf_kent, R.drawable.nhsf_kingston,
                R.drawable.nhsf_leeds, R.drawable.nhsf_leicester, R.drawable.nhsf_lincoln, R.drawable.nhsf_liverpool, R.drawable.nhsf_loughborough, R.drawable.nhsf_lsbu, R.drawable.nhsf_lse,
                R.drawable.nhsf_manchester, R.drawable.nhsf_medway, R.drawable.nhsf_northampton, R.drawable.nhsf_northumbria, R.drawable.nhsf_nottingham,
                R.drawable.nhsf_ntu, R.drawable.nhsf_plymouth, R.drawable.nhsf_portsmouth, R.drawable.nhsf_qmul, R.drawable.nhsf_reading, R.drawable.nhsf_rhul,
                R.drawable.nhsf_roehampton, R.drawable.nhsf_sgul, R.drawable.nhsf_sheffield, R.drawable.nhsf_southampton, R.drawable.nhsf_swansea,
                R.drawable.nhsf_uea, R.drawable.nhsf_uwe, R.drawable.nhsf_warwick, R.drawable.nhsf_westminster};

        final String[] zones = {
                //NHSF Aston
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF BCU
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF Birmingham
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF BPP
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Brighton
                "South Zone - Coordinator: Devisha Karadia",
                //nhsf_Bristol
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF Brunel
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Bucks New Uni
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF City
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Coventry
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF DMU
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF Exeter
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF Greenwich
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Hertfordshire
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Huddersfield
                "North Zone - Coordinator: Jay Badiani",
                //NHSF Hull
                "North Zone - Coordinator: Jay Badiani",
                //NHSF Imperial
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF KCL
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Keele
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF Kent
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF Kingston
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF Leeds
                "North Zone - Coordinator: Jay Badiani",
                //NHSF Leicester
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF Lincoln
                "North Zone - Coordinator: Jay Badiani",
                //NHSF Liverpool
                "North Zone - Coordinator: Jay Badiani",
                //NHSF Loughborough
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF LSBU
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF LSE
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF MANCHESTER
                "North Zone - Coordinator: Jay Badiani",
                //NHSF MEDWAY
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF NORTHAMPTON
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF NORTHUMBRIA
                "North Zone - Coordinator: Jay Badiani",
                //NHSF NOTTINGHAM
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF NTU
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF PLYMOUTH
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF PORTSMOUTH
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF QMUL
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF READING
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF RHUL
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF ROEHAMPTON
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF SGUL
                "London Zone - Coordinator: Shivani Chudasama",
                //NHSF SHEFFIELD
                "North Zone - Coordinator: Jay Badiani",
                //NHSF SOUTHAMPTON
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF SWANSEA
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF UEA
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF UWE
                "South Zone - Coordinator: Devisha Karadia",
                //NHSF WARWICK
                "Central Zone - Coordinator: Harshil Shah",
                //NHSF WESTMINSTER
                "London Zone - Coordinator: Shivani Chudasama"
        };


        final String[] chapterCommittees = {
                //--NHSF ASTON --
                "aston@nhsf.org.uk",

                //-- NHSF BCU --
                "birminghamcity@nhsf.org.uk",

                //-- NHSF BIRMINGHAM --
                "birmingham@nhsf.org.uk",

                //-- NHSF BPP --
                "bpp@nhsf.org.uk",

                //-- NHSF BRIGHTON --
                "brighton@nhsf.org.uk",

                //-- NHSF BRISTOL --
                "bristol@nhsf.org.uk",

                //-- NHSF BRUNEL--
                "brunel@nhsf.org.uk",

                //-- NHSF BUCKS NEW UNI --
                "bucksnewuni@nhsf.org.uk",

                //-- NHSF CITY --
                "city@nhsf.org.uk",

                //-- NHSF COVENTRY --
                "coventry@nhsf.org.uk",

                //-- NHSF DMU --
                "dmu@nhsf.org.uk",

                // -- NHSF EXETER --
                "exeter@nhsf.org.uk",

                // -- NHSF GREENWICH --
                "greenwich@nhsf.org.uk",

                // -- NHSF HERTFORDSHIRE --
                "hertfordshire@nhsf.org.uk",

                // -- NHSF HUDDERSFIELD --
                "huddersfield@nhsf.org.uk",

                // -- NHSF HULL --
                "hull@nhsf.org.uk",

                // -- NHSF IMPERIAL --
                "imperial@nhsf.org.uk",

                // -- NHSF KCL --
                "kcl@nhsf.org.uk",

                // -- NHSF KEELE --
                "keele@nhsf.org.uk",

                // -- NHSF KENT --
                "kent@nhsf.org.uk",

                // -- NHSF KINGSTON --
                "kingston@nhsf.org.uk",

                // -- NHSF LEEDS --
                "leeds@nhsf.org.uk",

                // -- NHSF LEICESTER --
                "leicester@nhsf.org.uk",

                // -- NHSF LINCOLN --
                "lincoln@nhsf.org.uk",

                // -- NHSF LIVERPOOL --
                "liverpool@nhsf.org.uk",

                // -- NHSF LOUGHBOROUGH --
                "loughborough@nhsf.org.uk",

                // -- NHSF LSBU --
                "lsbu@nhsf.org.uk",

                // -- NHSF LSE --
                "lse@nhsf.org.uk",

                // -- NHSF MANCHESTER --
                "manchester@nhsf.org.uk",

                // -- NHSF MEDWAY --
                "medway@nhsf.org.uk",

                // -- NHSF NORTHAMPTON --
                "nothampton@nhsf.org.uk",

                // -- NHSF NORTHUMBRIA --
                "northumbria@nhsf.org.uk",

                // -- NHSF NOTTINGHAM --
                "nottingham@nhsf.org.uk",

                // -- NHSF NTU --
                "nottinghamtrent@nhsf.org.uk",

                // -- NHSF PLYMOUTH --
                "plymouth@nhsf.org.uk",

                // -- NSHF PORTSMOUTH --
                "portmouths@nhsf.org.uk",

                // -- NHSF QMUL --
                "qmul@nhsf.org.uk",

                // -- NHSF READING
                "reading@nhsf.org.uk",

                // -- NHSF RHUL --
                "rhul@nhsf.org.uk",

                // -- NHSF ROEHAMPTON --
                "roehampton@nhsf.org.uk",

                // -- NHSF SGUL --
                "sgul@nhsf.org.uk",

                // -- NHSF SHEFFIELD --
                "sheffield@nhsf.org.uk",

                // -- NHSF SOUTHAMPTON --
                "southampton@nhsf.org.uk",

                // -- NHSF SWANSEA --
                "swansea@nhsf.org.uk",

                // -- NHSF UEA --
                "east-anglia@nhsf.org.uk",

                // -- NHSF UWE --
                "uwe@nhsf.org.uk",

                // -- NHSF WARWICK --
                "warwick@nhsf.org.uk",

                // -- NHSF WESTMINSTER --
                "westminister@nhsf.org.uk",

        };


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
