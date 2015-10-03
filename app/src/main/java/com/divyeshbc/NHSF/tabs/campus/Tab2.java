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
                "NHSF Bradford", "NHSF Brighton", "NHSF Bristol", "NHSF Brunel", "NHSF Bucks New Uni", "NHSF City", "NHSF Coventry",
                "NHSF DMU", "NHSF Exeter", "NHSF Greenwich", "NHSF Hertfordshire", "NHSF Huddersfield"};

        final int[] logos = {R.drawable.nhsf_aston, R.drawable.nhsf_bcu, R.drawable.nhsf_birmingham, R.drawable.nhsf_bpp, R.drawable.nhsf_bradford, R.drawable.nhsf_brighton,
                             R.drawable.nhsf_bristol, R.drawable.nhsf_brunel, R.drawable.nhsf_bucks_new_uni, R.drawable.nhsf_city, R.drawable.nhsf_coventry,
                             R.drawable.nhsf_dmu, R.drawable.nhsf_exeter, R.drawable.nhsf_greenwich, R.drawable.nhsf_hertfordshire, R.drawable.nhsf_huddersfield};

        final String[] zones = {"Central Zone - Coordinator: Shivanee Ardeshana", "Central Zone - Coordinator: Shivanee Ardeshana",
                "Central Zone - Coordinator: Shivanee Ardeshana", "London Zone - Coordinator: Ritesh Thakrar", "North Zone - Coordinator: Nakul Rajani",
                "South Zone - Coordinator: Reva Shah", "South Zone - Coordinator: Reva Shah", "London Zone - Coordinator: Ritesh Thakrar",
                "South Zone - Coordinator: Reva Shah", "London Zone - Coordinator: Ritesh Thakrar", "Central Zone - Coordinator: Shivanee Ardeshana",
                "Central Zone - Coordinator: Shivanee Ardeshana", "South Zone - Coordinator: Reva Shah", "London Zone - Coordinator: Ritesh Thakrar",
                "London Zone - Coordinator: Ritesh Thakrar", "North Zone - Coordinator - Nakul Rajani"};

        //--NHSF ASTON --
        final String[] chapterCommittees = {"PRESIDENT: Shailee Patel \nVP: Dhimant Mehta \nSECRETARIES: Raj Sivlal & Karishma Patel \nTREASURERS: Ajay Mistry & Akshay Nagda " +
                "\nEVENTS: Ashni Mehta, Avni Vaghela & Natasha Sandle \nPR: Hetal Patel, Trisha Kandlur & Priyesh Patel \nSEWA: Krishna Jethwa & Chandni Gadhia " +
                "\nLEARNING: Akshay Bhardwa & Trusha Parikh \nSPORTS: Neelam Mistry & Colette Rodrigues \nRELIGIOUS: Trusha Parikh & Akshay Bhardwa " +
                "\nADVISORY: Nikhil Parekh, Dev Patel, Anjali Bharania, Rupal Chavda & Radhika Madlani",

                //-- NHSF BCU --
                "PRESIDENT: Akshay Depala \nVP: Kalindi Parikh \nSECRETARY: Sittal Patel \nTREASURER: Kushagra Rastogi" +
                "\nEVENTS: Rahul Depala, Avni Shah, Jessica Chumber & Aman Sadhwani \nSEWA: Kiran Nayee & Kushal Thakkar, " +
                        "\nLEARNING: Kiran Nayee & Kushal Thakkar \nSPORTS: Sachin Dadhania",

                //-- NHSF BIRMINGHAM --
                "PRESIDENT: Anuj Popat \nVP: Dylan Patel-Vathvali \nSECRETARY: Noureen Lakhani \nTREASURER: Roshni Rupalaria" +
                        "\nEVENTS: Sachin Malkan, Roshni Dodhia & Himani Amin \nPR: Janu Shah & Sham Patel \nSEWA: Thineswari Pandiyan, Sushma Roy & Vanisha Solanki " +
                        "\nLEARNING: Henna Patel \nSPORTS: Reeya Patel & Rikesh Mistry \nDESIGNER: Janeena Sahota",

                //-- NHSF BPP --
                "PRESIDENT: Monica Mohan \nADVISORY: Ritesh Thakrar",

                //-- NHSF BRADFORD --
                "PRESIDENT: Mitesh Gunpath \nSECRETARY: Bindiya Kotecha \nEVENTS: Kieran Mistry \nPR: Fahim Mulla \nSEWA: Pavithra Natatrajan " +
                        "\nLEARNING: Radhika Chaudhury \nSPORTS: Kirujan Ravichandran & Sagiram Surendirarasa",

                //-- NHSF BRIGHTON --
                "PRESIDENT: Chintan Patel \nVP: Shreena Patel \nSECRETARIES: Roshni Patel & Suhani Ghiya \nTREASURER: Nity Kapoor" +
                        "\nEVENTS: Amisha Patel & Duckshini Sivalingam \nPR: Bhavisha Patel \nSEWA: Ramya Shanthikumar " +
                        "\nSPORTS: Yogesh Karunavannam & Krishan Patel \nMEDIA: Divya Lakhani",

                //-- NHSF BRISTOL --
                "PRESIDENT: Nihir Shah \nVP: Jagrati Chopra \nSECRETARY: Siddhant Shah \nTREASURER: Shria Radia" +
                        "\nEVENTS: Rishi Nanavati & Bhawick Jain \nSEWA: Krishna Ravichandar " +
                        "\nLEARNING: Krishna Ravichandar \nSPORTS: Vishal Davda & Aarti Gogna" +
                        "\nSIKH REP: Gulpuvan Sidhu",

                //-- NHSF BRUNEL--
                "PRESIDENT: Anisha Devani \nVP: Priya Leela Nair \nSECRETARY: Neha Chauhan \nTREASURER: Reeya Chetri" +
                        "\nEVENTS: Rajiv Chadha \nSEWA: Matthew Bavisi Bird \nLEARNING: Shivaley Tank " +
                        "\nSPORTS: Tejas Depala \nWEB: Minisha Kiran Mahay \nMEETINGS OFFICER: Shivaley Tank " +
                        "\nUNIVERSTIY OFFICER: Neha Joshi \nSPONSORSHIP: Priyen Patel",

                //-- NHSF BUCKS NEW UNI --
                "PRESIDENT: Anand Joshi \nVP: Rushi Patel \nSECRETARY: Karishma Sureja \nTREASURER: Rushi Patel",

                //-- NHSF CITY --
                "PRESIDENT: Anjlee Bathia \nVP: Karan Patel \nTREASURER: Palak Duggal \nEVENTS: Nyasha Sardana \nSEWA: Bhavik Khatri" +
                "\nLEARNING: Bhavik Khatri \nSPORTS: Ayesha Sharma \nMARKETING: Nikul Shah \nCOMMUNICATION: Prabhdeep Matharu",

                //-- NHSF COVENTRY --
                "PRESIDENT: Akash Shah \nVP: Pragyan Tulsian \nSECRETARY: Nirali Patel \nTREASURER: Kishan Mistry ",

                //-- NHSF DMU --
                "PRESIDENT: Dipali Jivram \nVP: Ravi Jagatia & Rishal Rathod \nSECRETARIES: Rozy Shukla & Sharad Pala " +
                        "\nTREASURER: Radhika Shikotra & Ajay Main \nEVENTS: Nikita Ladwa & Kanika Sharma \nSEWA: Jai Makwana & Rishan Gudka " +
                        "\nSPORTS: Anirrudh Ganatra, Nikita Patel & Himansh",

                // -- NHSF EXETER --
                "PRESIDENT: Shivam Joshi & Neha Toteja \nSECRETARY: Navin Nagesh  \nTREASURER: Sai Suhruta Jasthi \nEVENTS: Nikita Sethu Menon & Praveena Nanthakumaran" +
                        "\nSEWA: Visha Rach \nLEARNING: Yajur Kapoor \nSPORTS: Amaritpal Singh Siani \nPR: Ridhi Jogia",

                // -- NHSF GREENWICH --
                "PRESIDENT: Deepa Dabaisa \nVP: Roshan Patel \nSECRETARY: Chetan Sablawat \nTREASURER: Mishali Paragjee " +
                        "\nSPORTS: Sapna Chudasama & Bhumit Patel \nPR: Nikhil Parbat \nGREENWICH REP: Nidhi Naik",

                // -- NHSF HERTFORDSHIRE --
                "PRESIDENT: Gayatri Bhudia \nVP: Sonali Pabali \nSECRETARY: Kishan Patel \nEVENTS: Rupa Carpenter & Mohit Vyas" +
                        "\nLEARNING: Sapna Sodha & Priyali Patel \nSPORTS: Hanna Patel & Hari Patel \nMEDIA: Kishan Patel",

                // -- NHSF HUDDERSFIELD --
               "PRESIDENT: Seetal Mistry \nTREASURER: Rahul Hirani \nEVENTS: Natasha Patel \nLEARNING: Nilam Patel" +
                       "\nSPORTS: Priyesh Patel \nADVISORY: Roshni Mistry"};


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