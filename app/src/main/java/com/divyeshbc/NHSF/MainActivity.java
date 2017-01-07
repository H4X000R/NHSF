package com.divyeshbc.NHSF;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.divyeshbc.NHSF.tabs.AR17;
import com.divyeshbc.NHSF.tabs.WellWisher;
import com.divyeshbc.NHSF.tabs.aboutUs.Tab1;
import com.divyeshbc.NHSF.tabs.campus.Tab2;
import com.divyeshbc.NHSF.tabs.events.Tab3;
import com.divyeshbc.NHSF.tabs.learning.Tab4;
import com.divyeshbc.NHSF.tabs.sewa.Tab5;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Logic for setting the colour of the status bar
        //If the Android OS on the phone is Android Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //Set Status bar colour to Orange
            getWindow().setStatusBarColor(getResources().getColor(R.color.baseSecondaryBackgroundColour));

        }

        //----------------------------HOME TAB-------------------------------
        // Here setting up Home Tab icon colour states for Navigation Menu --
        int[][] statesHome = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked } // false
        };

        int[] coloursHome = new int[] {

                //Colour codes taken from icons made by Karan in Photoshop
                Color.rgb(239,102,65), //Medium Pinky Orange
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList homeTab = new ColorStateList(statesHome, coloursHome);
        //----------------------------HOME TAB-------------------------------

        //--------------------------ABOUT US TAB------------------------------
        // Here setting up About Us icon colour states for Navigation Menu --
        int[][] statesAboutUs = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursAboutUs = new int[] {

                //Colour codes taken from icons made by Karan in Photoshop
                Color.rgb(111,193,225), //Light Blue
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList aboutUsTab = new ColorStateList(statesAboutUs, coloursAboutUs);
        //--------------------------ABOUT US TAB------------------------------

        //---------------------------CAMPUS TAB-------------------------------
        // Here setting up Campus Tab icon colour states for Navigation Menu --
        int[][] statesCampus = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursCampus = new int[] {

                //Colour codes taken from icons made by Karan in Photoshop
                Color.rgb(253,216,53), //Medium Yellow
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList campusTab = new ColorStateList(statesCampus, coloursCampus);
        //---------------------------CAMPUS TAB-------------------------------

        //---------------------------EVENTS TAB-------------------------------
        // Here setting up Events Tab icon colour states for Navigation Menu --
        int[][] statesEvents = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursEvents = new int[] {

                //Colour codes taken from icons made by Karan in Photoshop
                Color.rgb(254,126,139), //Pink
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList eventsTab = new ColorStateList(statesEvents, coloursEvents);
        //---------------------------EVENTS TAB-------------------------------

        //---------------------------LEARNING TAB-----------------------------
        // Here setting up Learning Tab icon colour states for Navigation Menu --
        int[][] statesLearning = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursLearning = new int[] {

                //Colour codes taken from icons made by Karan in Photoshop
                Color.rgb(52,221,202), //Teal
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList learningTab = new ColorStateList(statesLearning, coloursLearning);
        //---------------------------LEARNING TAB-----------------------------

        //----------------------------SEWA TAB--------------------------------
        // Here setting up Sewa Tab icon colour states for Navigation Menu --
        int[][] statesSewa = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursSewa = new int[] {

                //Colour codes taken from icons made by Karan in Photoshop
                Color.rgb(186,104,200), //Purple
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList sewaTab = new ColorStateList(statesSewa, coloursSewa);
        //----------------------------SEWA TAB--------------------------------

        //------------------------AMBITION RUN TAB----------------------------
        // Here setting up Ambition Run Tab icon colour states for Navigation Menu --
        int[][] statesAR = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursAR = new int[] {

                Color.rgb(40,50,113), //Dark Deep Blue
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList arTab = new ColorStateList(statesAR, coloursAR);
        //------------------------AMBITION RUN TAB-----------------------------

        //--------------------------WELL WISHER TAB----------------------------
        // Here setting up Well Wisher Tab icon colour states for Navigation Menu --
        int[][] statesWW = new int[][] {

                new int[] { android.R.attr.state_checked }, //  true
                new int[] { -android.R.attr.state_checked} // false
        };

        int[] coloursWW = new int[] {

                Color.rgb(42,93,7), //Dark Green
                Color.rgb(73,68,67) //Dark Grey

        };

        final ColorStateList wwTab = new ColorStateList(statesWW, coloursWW);
        //--------------------------WELL WISHER TAB-----------------------------


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new NHSF_UK());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("NHSF (UK)");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //--
        //navigationView.setItemIconTintList(null);
        // --
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new NHSF_UK());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("NHSF UK");
                        navigationView.setItemIconTintList(homeTab); //Setting the Home Icon colour state
                        navigationView.setItemTextColor(homeTab); //Setting the Home Text colour state
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_tab1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Tab1());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About Us");
                        navigationView.setItemIconTintList(aboutUsTab); //Setting the About Us Icon colour state
                        navigationView.setItemTextColor(aboutUsTab); //Setting the About Us Text colour state
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_tab2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Tab2());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Campus");
                        navigationView.setItemIconTintList(campusTab); //Setting the Campus Icon colour state
                        navigationView.setItemTextColor(campusTab); //Setting the Campus Text colour state
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_tab3:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Tab3());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Events");
                        navigationView.setItemIconTintList(eventsTab); //Setting the Events Icon colour state
                        navigationView.setItemTextColor(eventsTab); //Setting the Events Text colour state
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_tab4:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Tab4());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Learning");
                        navigationView.setItemIconTintList(learningTab); //Setting the Learning Icon colour state
                        navigationView.setItemTextColor(learningTab); //Setting the Learning Text colour state
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_tab5:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new Tab5());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        getSupportActionBar().setTitle("Sewa");
                        navigationView.setItemIconTintList(sewaTab); //Setting the Sewa Icon colour state
                        navigationView.setItemTextColor(sewaTab); //Setting the Sewa Text colour state
                        item.setChecked(true);
                        break;
                    case R.id.nav_tab6:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AR17());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        getSupportActionBar().setTitle("Ambition Run 2017");
                        navigationView.setItemIconTintList(arTab); //Setting the Ambition Run Icon colour state
                        navigationView.setItemTextColor(arTab); //Setting the Ambition Run Text colour state
                        item.setChecked(true);
                        break;
                    case R.id.nav_tab7:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new WellWisher());
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        getSupportActionBar().setTitle("Well Wisher");
                        navigationView.setItemIconTintList(wwTab); //Setting the Well Wisher Icon colour state
                        navigationView.setItemTextColor(wwTab); //Setting the Well Wisher Text colour state
                        item.setChecked(true);
                        break;
                }
                return false;
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
      /*  navigationView = (NavigationView) findViewById(R.id.drawer_layout);
        View headerView = getLayoutInflater().inflate(R.layout.navigation_drawer_header, navigationView, false);
        navigationView.addHeaderView(headerView);

        ImageView headerImage = (ImageView) headerView.findViewById(R.id.ib);

        headerImage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Logout",
                        Toast.LENGTH_LONG).show();
            }});

     /*   ImageButton imagebutton = (ImageButton) findViewById(R.id.ib);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "NHSF_UK",
                        Toast.LENGTH_LONG).show();
            }});
            */

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.divyeshbc.NHSF/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a 0title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.divyeshbc.NHSF/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}




