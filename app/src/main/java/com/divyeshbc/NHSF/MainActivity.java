package com.divyeshbc.NHSF;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.divyeshbc.NHSF.tabs.SlidingTabLayout;
import com.divyeshbc.NHSF.tabs.aboutUs.Tab1;
import com.divyeshbc.NHSF.tabs.campus.Tab2;
import com.divyeshbc.NHSF.tabs.events.Tab3;
import com.divyeshbc.NHSF.tabs.learning.Tab4;
import com.divyeshbc.NHSF.tabs.sewa.Tab5;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;


public class MainActivity extends BaseActivity {

    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // To track statistics around application
        ParseAnalytics.trackAppOpened(getIntent());

        // inform the Parse Cloud that it is ready for notifications
        ParseInstallation.getCurrentInstallation().saveInBackground();

        //Creating a new object of notification builder
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        notificationBuilder.setSmallIcon(getNotificationIcon(notificationBuilder));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //Set Status bar colour to Orange
            getWindow().setStatusBarColor(getResources().getColor(R.color.baseSecondaryBackgroundColour));

        }
        /*
        else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.md_black_1000));
        }
        */

        //Calling Activate Toolbar method
        activateToolBar();

        mPager = (ViewPager) findViewById(R.id.pager);
        //Setting the Adapter on the view pager first. Passing the fragment manager through as an argument
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);

        //Setting the custom Tab View as the Sliding Tabs Layout
        mTabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);

        mTabs.setDistributeEvenly(true);

        //mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.tabIndicatorColour));

        mTabs.setBackgroundColor(getResources().getColor(R.color.basePrimaryBackgroundColour));

        //Setting the ViewPager as the tabs
        mTabs.setViewPager(mPager);

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

        //noinspection SimplifiableIfStatement
        //enough_food (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {


        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

            //Initialising the strings array of the tabs
            tabs = getResources().getStringArray(R.array.tabs);

        }

        /*
        //Setting up integer array of icons
        int icons[] = {R.drawable.about_us, R.drawable.campus, R.drawable.events, R.drawable.learning, R.drawable.sewa_campaigns};

        //Defined from strings.xml
        String[] tabText = getResources().getStringArray(R.array.tabs);

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            //Initialising the strings array of tabs
            tabText = getResources().getStringArray(R.array.tabs);

        }
        */

        @Override
        public Fragment getItem(int position) {

            if (position == 0) // Based on the position is we are returning the relevant tab
            {
                return new Tab1();

            } else if (position == 1) {
                return new Tab2();

            } else if (position == 2) {
                return new Tab3();

            } else if (position == 3) {
                return new Tab4();

            } else {
                return new Tab5();
            }
        }


        @Override
        public CharSequence getPageTitle(int position) {

            //Return the text of the position clicked and display this as the title for the tab
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 5;
        }
    }


    //This method will determine the user's operating system and based on this will set the app notification icon accordingly
    private int getNotificationIcon(NotificationCompat.Builder notificationBuilder) {

        //If the OS version is greater than or equal to lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            int color = 0xFFD66F;
            //Set the background colour of the app icon to orange
            notificationBuilder.setColor(color);
            //Use the transparent icon (As per Google Design Guidelines for Icons for Lollipop and above)
            return R.mipmap.nhsf_twentyfifth_app_icon_transparent;

        } else {
            //Else use the standard colour icon
            return R.mipmap.nhsf_25th_app_logo_androidx144;
        }

    }
}


