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
                "NHSF DMU", "NHSF Exeter", "NHSF Greenwich", "NHSF Hertfordshire", "NHSF Huddersfield", "NHSF Hull", "NHSF Imperial",
                "NHSF KCL", "NHSF Keele", "NHSF Kent", "NHSF Kingston", "NHSF Leeds", "NHSF Leicester", "NHSF Liverpool", "NHSF Loughborough",
                "NHSF LSBU", "NHSF LSE", "NHSF Manchester", "NHSF Medway", "NHSF Northampton", "NHSF Northumbria", "NHSF Nottingham",
                "NHSF NTU", "NHSF Plymouth", "NHSF Portsmouth", "NHSF QMUL", "NHSF Reading", "NHSF RHUL", "NHSF Roehampton", "NHSF SGUL",
                "NHSF Sheffield", "NHSF SOAS", "NHSF Southampton", "NHSF Swansea", "NHSF UEA", "NHSF UWE", "NHSF Warwick", "NHSF Westminster", "NHSF York"};

        final int[] logos = {R.drawable.nhsf_aston, R.drawable.nhsf_bcu, R.drawable.nhsf_birmingham, R.drawable.nhsf_bpp, R.drawable.nhsf_bradford, R.drawable.nhsf_brighton,
                             R.drawable.nhsf_bristol, R.drawable.nhsf_brunel, R.drawable.nhsf_bucks_new_uni, R.drawable.nhsf_city, R.drawable.nhsf_coventry,
                             R.drawable.nhsf_dmu, R.drawable.nhsf_exeter, R.drawable.nhsf_greenwich, R.drawable.nhsf_hertfordshire, R.drawable.nhsf_huddersfield,
                             R.drawable.nhsf_hull, R.drawable.nhsf_imperial, R.drawable.nhsf_kcl, R.drawable.nhsf_keele, R.drawable.nhsf_kent, R.drawable.nhsf_kingston,
                             R.drawable.nhsf_leeds, R.drawable.nhsf_leicester, R.drawable.nhsf_liverpool, R.drawable.nhsf_loughborough, R.drawable.nhsf_lsbu, R.drawable.nhsf_lse,
                             R.drawable.nhsf_manchester, R.drawable.nhsf_medway, R.drawable.nhsf_northampton, R.drawable.nhsf_northumbria, R.drawable.nhsf_nottingham,
                             R.drawable.nhsf_ntu, R.drawable.nhsf_plymouth, R.drawable.nhsf_portsmouth, R.drawable.nhsf_qmul, R.drawable.nhsf_reading, R.drawable.nhsf_rhul,
                             R.drawable.nhsf_roehampton, R.drawable.nhsf_sgul, R.drawable.nhsf_sheffield, R.drawable.nhsf_soas, R.drawable.nhsf_southampton, R.drawable.nhsf_swansea,
                             R.drawable.nhsf_uea, R.drawable.nhsf_uwe, R.drawable.nhsf_warwick, R.drawable.nhsf_westminster, R.drawable.nhsf_york};

        final String[] zones = {
                //NHSF Aston
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF BCU
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF Birmingham
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF BPP
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Bradford
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF Brighton
                "South Zone - Coordinator: Reva Shah",
                //NHSF Bristol
                "South Zone - Coordinator: Reva Shah",
                //NHSF Brunel
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Bucks New Uni
                "South Zone - Coordinator: Reva Shah",
                //NHSF City
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Coventry
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF DMU
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF Exeter
                "South Zone - Coordinator: Reva Shah",
                //NHSF Greenwich
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Hertfordshire
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Huddersfield
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF Hull
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF Imperial
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF KCL
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Keele
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF Kent
                "South Zone - Coordinator: Reva Shah",
                //NHSF Kingston
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF Leeds
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF Leicester
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF Liverpool
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF Loughborough
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF LSBU
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF LSE
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF MANCHESTER
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF MEDWAY
                "South Zone - Coordinator: Reva Shah",
                //NHSF NORTHAMPTON
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF NORTHUMBRIA
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF NOTTINGHAM
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF NTU
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF PLYMOUTH
                "South Zone - Coordinator: Reva Shah",
                //NHSF PORTSMOUTH
                "South Zone - Coordinator: Reva Shah",
                //NHSF QMUL
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF READING
                "South Zone - Coordinator: Reva Shah",
                //NHSF RHUL
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF ROEHAMPTON
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF SGUL
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF SHEFFIELD
                "North Zone - Coordinator: Nakul Rajani",
                //NHSF SOAS
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF SOUTHAMPTON
                "South Zone - Coordinator: Reva Shah",
                //NHSF SWANSEA
                "South Zone - Coordinator: Reva Shah",
                //NHSF UEA
                "South Zone - Coordinator: Reva Shah",
                //NHSF UWE
                "South Zone - Coordinator: Reva Shah",
                //NHSF WARWICK
                "Central Zone - Coordinator: Shivanee Ardeshana",
                //NHSF WESTMINSTER
                "London Zone - Coordinator: Ritesh Thakrar",
                //NHSF YORK
                "North Zone - Coordinator: Nakul Rajani"
                };


        final String[] chapterCommittees = {
                //--NHSF ASTON --
                "PRESIDENT: Shailee Patel \nVP: Dhimant Mehta \nSECRETARIES: Raj Sivlal & Karishma Patel \nTREASURERS: Ajay Mistry & Akshay Nagda " +
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
                "PRESIDENT: Yogesh Karunavannan \nVP: Shreena Patel \nSECRETARIES: Roshni Patel & Suhani Ghiya \nTREASURER: Nity Kapoor" +
                        "\nEVENTS: Amisha Patel & Duckshini Sivalingam \nPR: Bhavisha Patel \nSEWA: Ramya Shanthikumar \nLEARNING: Chintan Patel" +
                        "\nSPORTS: Krishan Patel \nMEDIA: Divya Lakhani",

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
                       "\nSPORTS: Priyesh Patel \nADVISORY: Roshni Mistry",

                // -- NHSF HULL --
                "PRESIDENT: Shiv Soni \nVP: Sonal Gohil \nTREASURER: Vivek Mistry \nSPORTS: Krishnaa Mistry & Jayesh Patel \nPR: Sharon George" +
                        "\nADVISORY: Yogesh Namballa",

                // -- NHSF IMPERIAL --
                "PRESIDENT: Shaneil Tanna \nVP: Payal Kotecha & Aparna Joshi \nSECRETARY: Kapil Agarwal \nTREASURER: Vijay Ramadoss & Anjlee Patel" +
                        "\nSEWA: Riddhi Shenoy & Roshni Vinda \nSPORTS: Sanjay Patel & Milan Nayee \nEDUCATION: Surya Kocherlakota \nBHAKTI: Sneha Varshani" +
                        "\nCULTURE: Aaran Patel & Srideep Mallick",

                // -- NHSF KCL --
                "PRESIDENT: Hiten Mistry \nVP: Darshana Nair, Jaymin Patel & Seema Vaswani \nSECRETARY: Manisha Ghosh, \nTREASURER: Prince Naruka" +
                        "\nEVENTS: Afiyah Falak, Aparjita Venkat & Mayank Varyani \nSEWA: Ishita Jhunjhunwala \nLEARNING: Arjun Varma " +
                        "\nBHAKTI: Akshaya Rajangam \nMARKETING: Kaneesha Banker \nCAMPUS REPS: Anushka Bhargava, Maliekah Harjani, Urvi Parekh," +
                        "Jaskiran Rana & Chandni Vasandani",

                // -- NHSF KEELE --
                "PRESIDENT: Rishi Batra \nVP: Manish Gohil \nSECRETARY: Krupesh Patel \nTREASURER: Alex Patel \nEVENTS: Bhavisha Gondalia, Danisha Patel" +
                        "& Shivani Patel \nPR: Amit Rajani \nSEWA: Bhavisha Gondalia, Danisha Patel & Shivani Patel \nLEARNING: Meena Chandarana & Urega Balakrishnan" +
                        "\nSPORTS: Aman Grover & Revyath Varanthan \nADVISORY: Kusum Nathawat",

                // -- NHSF KENT --
                "PRESIDENT: Kunal Patel \nSECRETARY: Meera Daya \nTREASURUER: Trina Mistry \nSEWA: Anokhi Desai \nLEARNING: Abi Nadarajah \nSPORTS: Rahul Dayalani" +
                        "\nMARKETING: Viknesh Prabhakar \nSOCIAL: Lakchitha Kananathapillai & Pari Shah \nLOGISTICS: Karnan Narendrakumar",

                // -- NHSF KINGSTON --
                "PRESIDENT: Janak Dattani \nVP: Dhanik Parmar \nSECRETARY: Disha Patel \nTREASURER: Vichruti Hkumar \nEVENTS: Anisha Ruparelia & Abhishek Gautami" +
                        "\nSEWA: Anisha Ruparelia \nLEARNING: Dipak Pindoria \nSPORTS: Abhishek Gautami, Mayur Depala & Nithusan Sivarasa \nSOCIAL: Sachin Patel" +
                        "\nADVISORY: Bhavik Vara",

                // -- NHSF LEEDS --
                "PRESIDENT: Priya Shah \nVP: Kanaka Kulkarni \nSECRETARY: Aviral Sethi \nTREASURER: Sejal Mistry \nEVENTS: Jaskaran Dutta, Jainam Tolia & Rishi Thakerar" +
                        "\nPUBLICITY: Rhea Bhandari \nSEWA: Mayur Parmar & Purvi Makwana \nLEARNING: Jeet Parmar \nSPORTS: Akshay Mistry \nSPONSORSHIP: Anurika Nehra" +
                        "\nINTERSOCIETY REP: Jeet Parmar",

                // -- NHSF LEICESTER --
                "PRESIDENT: Hitesh Mankani \nVP: Sahil Kotecha & Sinthu Harini Uthayashankar \nSECRETARY: Henal Patel \nTREASURER: Savi Chaplot" +
                        "\nPR: Shoban P Kannu \nEVENTS: Bhumika Hirani, Radhika Rana, Sanjana Masilamani & Gowshiee Ravindran \nSEWA: Sneha Nootigattu \nLEARNING: Deepa Lad" +
                        "\nSPORTS: Tarun Sharma & Zaeem Rahim \nRELIGIOUS: Aditya Nidamarthi",

                // -- NHSF LIVERPOOL --
                "PRESIDENT: Sandip Patel \nVP: Ananda Mohan & Vaishnavi Menon",

                // -- NHSF LOUGHBOROUGH --
                "PRESIDENT: Harshil Shah \nVP: Niraj Dhodia \nSECRETARY: Tulsi Shah \nTREASURER: Suraj Shah \nEVENTS: Shreyasi Mukherjee \nSEWA: Erandika Mohanathasan" +
                        "\nLEARNING: Shriya Ramaiya \nSPORTS: Nikhil Borkhatria \nSPONSORSHIP: Rhea Visavadia",

                // -- NHSF LSBU --
                "PRESIDENT: Kishan Patel \nSECRETARY: Amalia Premgi \nTREASURER: Arun Aravinth \nMEDIA: Akshay Parmar \nGENERAL COMMITTEE MEMBER: Haran Pillai",

                // -- NHSF LSE --
                "PRESIDENT: Sagar Ghelani \nVP: Dillon Halai \nSECRETARY: Tejan Shah \nTREASURER: Himansu Odedra \nEVENTS: Jay Depala \nSEWA: Ayush Oza" +
                        "\nSPORTS: Sona Shah & Ajay Shah \nSPONSORSHIP: Khush Chudasama \nMEDIA: Yaxsaana Sivanathan",

                // -- NHSF MANCHESTER --
                "PRESIDENT: Shree Thakker \nVP: Pavan Mamtora \nSECRETARY: Shyam Pattni & Bhavesh Soneji \nTREASURER: Riyan Shah \nPR: Nikita Patel & Rupen Taylor" +
                        "\nEVENTS: Rishi Sharma, Gita Shaparia, Priya Mahallingam, Sachin Tandon & Divya Mardania \nSEWA: Rishi Patel & Neharika Dembla" +
                        "\nLEARNING: Krupa Thakkar & Hirendra Patel \nSPORTS: Talisha Patel \nPERFORMING ARTS: Sonam Kotecha & Priyanka Patel",

                // -- NHSF MEDWAY --
                "PRESIDENT: Mayur Patel \nVP: Kash Mehta \nTREASURER: Preksha \nPR: Shavinder & Pradeepan \nLEARNING: Nidhi & Deesha Bhudia" +
                "\nEVENTS: Kash Mehta",

                // -- NHSF NORTHAMPTON --
                "PRESIDENT: Anna Chandrasehar \nSECRETARY: Saejal Odedra \nTREASURER: Neelam Chhabhadiya \nEVENTS: Feroz Shanmughanthan \nLEARNING: Bhakti Joshi" +
                        "\nSPORTS: Sritharan Theiventhran",

                // -- NHSF NORTHUMBRIA --
                "PRESIDENT: Karan Haveliwala \nSECRETARY: Emily Beaumont \nTREASURER: Shalin Mistry \nEVENTS: Shivani Patel \nMARKETING: Kotwarthanan Ganesha",

                // -- NHSF NOTTINGHAM --
                "PRESIDENT: Vasant Limbachia \nVP: Dillon Shah & Khyati Thakkar \nSECTRETARY: Avnee Vaghjiani \nTREASURER: Rikesh Patel " +
                        "\nPR: Nikita Sailesh Shah \nEVENTS: Sweta Patel & Nikita Patel \nSEWA: Radhika Chond \nLEARNING: Prit Thakar & Shivam Patel" +
                        "\nSPORTS: Tanvi Shah & Dilan Chudasama \nMARKETING: Nikita Sailesh Shah \nARTISITIC DIRECTOR: Nikita Shah" +
                        "\nSOCIAL: Prasann & Kinner Shah \nSPONSORSHIP: Shivani Bhayani \nHEAD OF KANGNA: Akshay Ladwa",

                // -- NHSF NTU --
                "PRESIDENT: Palvi Sharma \nTREASURER: Amber Ali \nEVENTS: Keval Karia \nSEWA: Shruti Ahuja \nLEARNING: Shivani Kapoor" +
                        "\nSPORTS: Alisaha Pugal \nSOCIAL: Krupa Dave",

                // -- NHSF PLYMOUTH --
                "PRESIDENT: Pooja",

                // -- NSHF PORTSMOUTH --
                "PRESIDENTS: Ashna Sejpal & Jay Amin \nVP: Chiraag Sanghani \nSECRETARY: Bina Choudury \nTREASURER: Ankit Nayee & Jay Sharma \nPR: Nisha KApur" +
                        "\nEVENTS: Sarina Kholsa, Namita Shenolikar Shil Patel, Vimal Patel & Devika Sharma \nSEWA: Harshiv Nayee, Natasha Gukhool, Hitesh Patel, Manish Seth & Priyia Ravi" +
                        "\nSPORTS: Ajay Upadyaya & Kamal Patel \nDHARMA: Khushal Shah, Tejal Mandalia, Alysha Gupta & Bhavisha Kataria \nSUPPORT: Monil Patel",

                // -- NHSF QMUL --
                "PRESIDENT: Chandan Varsani \nVP: Archana Sasitharan \nTREASURER: Shubhra Jain \nPR: Pareen Chhaganlal & Serena Patel \nEVENTS: Serena Desai," +
                        "Abhishiktar Talukder, Jay Patel & Purvi Kirticumar \nSEWA: Roshni Mehta \nLEARNING: Shivam Malhotra & Harshil Kanji" +
                        "\nSPORTS: Harshita Vig, Rishi Bhayani & Nishma Bechar \nMEDIA: Manthan Patel \nSPONSORSHIP: Pritish Patel \nBARTS REP: Shreeya Patel",

                // -- NHSF READING
                "PRESIDENT: Sanja Bhagawan \nVP: Shreya Mashru \nSECRETARY: Daksh Jain \nTREASURER: Tamish Khullar \nEVENTS: Mohini Mistry & Natasha Menghani" +
                        "\nSEWA: Dimpy Pandya \nLEARNING: Stuti Chauhan & Archana Chauhan \nSOCIAL: Shagun Wasan \nCREATIVE COORDINATOR: Stuti Chauhan" +
                        "\nSPONSORSHIP: Hari Singh Sokhal",

                // -- NHSF RHUL --
                "PRESIDENT: Shreya Shrikhande \nVP: Jashma Karia \nSECRETARY: Aahuti Bharai \nTREASURER: Prishaa Ellagovan",

                // -- NHSF ROEHAMPTON --
                "PRESIEDENT: Ashwini Mandalia \nVP: Anuj Radia & Cynthia Manoharadas \nTREASURER: Nakul Shah \nEVENTS: Neeta Patel & Chetna Sookdawar" +
                        "\nSEWA: Arishma Amin \nLEARNING: Arishma Amin \nSPORTS: Cynthia Manoharadas",

                // -- NHSF SGUL --
                "PRESIDENT: Hershil Lakhani \nVP: Chandrika Chopra \nEVENTS: Abhi Chennupati & Tharshana Mahendrarajah \nSEWA: Sabeena Pushparajah" +
                        "\nLEARNING: Talisha Modasia & Adam Gadhvi \nSPORTS: Zaib Hilal & Anish Patel \nCULTURE: Radhika Tanna & Alia Sahni " +
                        "\nMEDIA: Poorani Kuganesan \nDIVIA COORDINATOR: Eesha Tripathi & Siddharth Praveen \nADVISROY: Bejaya Chowdury",

                // -- NHSF SHEFFIELD --
                "PRESIDENT: Hina Sharma \nVP: Krishna Tejura & Vaidehi Tembhekar \nSECRETARY: Reesha Siniara \nTREASURER: Anuj Savani \nPR: Nicole Chahal & " +
                        "Nikita Pankhania \nEVENTS: Aneesa Bhardwa & Anamil Kochar \nSEWA: Saakshi Barman & Tejal Mistry \nLEARNING: Dania Lakshmi" +
                        "\nSPORTS: Akash Madhu & Ayesha Girach \nPERFORMING ARTS: Tanya Datta & Nikita Bharat",

                // -- NHSF SOAS --
                "PRESIDENT: \nVP: \nSECRETARY \nTREASURER",

                // -- NHSF SOUTHAMPTON --
                "PRESIDENT: Jay Dave \nVP: Vikram Palli \nSECRETARY: Sajeenth Thevabalasingam & Yue Huang \nTREASURER: Animesh Sahay \nEVETNS: Tara Ludra, Sonam Thanki" +
                        "& Sahil Thakrar \nSEWA: Roshni Desai, Hemna Santilale & Jesal Patel \nLEARNING: Roshni Desai, Hemna Santilale & Jesal Patel" +
                        "\nSPORTS: Suraj Vadukul, Alisha Sharma & Nikesh Patel \nSPONSORSHIP: Ravi Jayanti & Aravinthan Andy Vijaykumar" +
                        "\nIT: Sivaruby Kangarathinam, Asmie Vanajaraj & Methusha Sakthipakan \nDANCE: Karishma Patel \nHEALTH: Darshan Patel",

                // -- NHSF SWANSEA --
                "PRESIDENT: Karan Dossa \nLEARNING: Krishan Karadia",

                // -- NHSF UEA --
                "PRESIDENT: Punit Naran \nSECRETARY: Jaymini Chohan \nTREASURER: Urvashi Ragobur \nSEWA: Punit Naran \nLEARNING: Kishan Jethwa" +
                        "\nSPORTS: Rahul Mehta & Hinal Shah \nDIVERSITY: Abinayah Jayanthan & Prina Kakad \nAARTI COORDINATOR: Trisha Dhaliah" +
                        "\nSOCIAL: Prabin Mohanty \nGENERAL COMMITTEE MEMBERS: Nischay Kakkar, Riti Sharma & Sandhya Rai \nHEALTH: Prabin Mohanty",

                // -- NHSF UWE --
                "PRESIDENTS: Janki Seth & Roshnie Mahani \nSECRETARY: Prachi Patel \nTREASURER: Kasturi Sothiraj \nEVENTS: Prashant Shukla & Pirruntha Siva " +
                        "\nSEWA: Pratik Joshi \nLEARNING: Pratik Joshi \nSPORTS: Mevin Daniel \nDANCE: Astha Suri",

                // -- NHSF WARWICK --
                "PRESIDENTS:Hiran Adhia & Nishil Bathia \nSECRETARY: Minesh Patel \nTREASURER: Chandni Patel \nEVENTS: Monic Chotai & Priya Agarwal \nSEWA: Liana Malhan" +
                        "\nLEARNING: Prianka Chotai \nSPORTS: Mirresh Pankahnia & Rajvir Kaur Padda \nMEDIA: Amar Suralia",

                // -- NHSF WESTMINSTER --
                "PRESIDENTS: Radhika Kotak & Kush Mahesh \nTREASURER: Reena Vadhia \nPR: Bhrindhan Manoharan \nEVENTS: Nikita Retnasingam \nSEWA: Preethy Jose " +
                        "\nLEARNING: Nimesh Patel \nSPORTS: Harshil Kerai \nMEDIA: Fazil Muhammed",

                // -- NHSF YORK --
                "PRESIDENT: \nSECRETARY: \nTREASURER:"
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