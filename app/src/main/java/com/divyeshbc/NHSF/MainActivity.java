package com.divyeshbc.NHSF;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;

import com.divyeshbc.NHSF.tabs.SlidingTabLayout;
import com.divyeshbc.NHSF.tabs.Tab1;
import com.divyeshbc.NHSF.tabs.Tab2;
import com.divyeshbc.NHSF.tabs.Tab3;
import com.divyeshbc.NHSF.tabs.Tab4;
import com.divyeshbc.NHSF.tabs.Tab5;


public class MainActivity extends BaseActivity {

    private ViewPager mPager;
    private SlidingTabLayout mTabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        // Inflate the menu; this adds items to the action bar if it is present.
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
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        /*
        String[] tabs;

        public  MyPagerAdapter(FragmentManager fm) {
            super(fm);

            //Initialising the strings array of the tabs
            tabs = getResources().getStringArray(R.array.tabs);
        */


        //Setting up integer array of icons
        int icons[] = {R.drawable.about_us, R.drawable.campus, R.drawable.events, R.drawable.learning, R.drawable.sewa};

        //Defined from strings.xml
        String[] tabText = getResources().getStringArray(R.array.tabs);

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            //Initialising the strings array of tabs
            tabText = getResources().getStringArray(R.array.tabs);

        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) // if the position is 0 we are returning the First tab
            {
                Tab1 tab1 = new Tab1();
                return tab1;

            } else if (position == 1)           // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
            {
                Tab2 tab2 = new Tab2();
                return tab2;

            } else if (position == 2)
            {
                Tab3 tab3 = new Tab3();
                return tab3;

            } else if (position == 3)
            {
                Tab4 tab4 = new Tab4();
                return tab4;

            } else
            {
                Tab5 tab5 = new Tab5();
                return tab5;
            }



            /*
            //Initialising Fragment
            //Passing in the position so that position of the fragment is returned
            MyFragment myFragment = MyFragment.getInstance(position);

            return myFragment;
            */
        }


        @Override
        public CharSequence getPageTitle(int position) {

            //Constructing drawable object from the icon position
            Drawable drawable = getResources().getDrawable(icons[position]);

            //Defining the bounds for each icon as this is not automatically calculated
            drawable.setBounds(0, 0, 90, 90);

            //Passing icons as drawable objects into the imageSpan. This means it can be placed amongst the text
            ImageSpan imageSpan = new ImageSpan(drawable);

            //Spannable strings allows us to embed images with text (attach/detach images)
            SpannableString spannableString = new SpannableString(" ");

            //Here setting the span of the icons amongst the scroll bar. Using the array of icons, starting at position 0,
            //till the end, SPAN_EXCLUSIVE_EXCLUSIVE will ensure only the images in the range are included, nothing more,
            //nothing less
            spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            //Return the spannable string with icons embedded
            return spannableString;



            //Return the text of the position clicked and display this as the title for the tab
            //return tabs[position];
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}

