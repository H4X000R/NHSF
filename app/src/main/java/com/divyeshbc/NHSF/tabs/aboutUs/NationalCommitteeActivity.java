package com.divyeshbc.NHSF.tabs.aboutUs;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;
import com.divyeshbc.NHSF.tabs.DividerItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DivyeshBC on 27/10/15.
 *
 * v3.0 - 14-MAY-2016 - Removing Team Coordinator row from Table View as incorporating both Admin and TC into one Table View
 *                    - Adding in onClickListener for Floating Action Button
 */
public class NationalCommitteeActivity extends BaseActivity implements RecyclerViewAdapterAdminTeam.ClickListener {

    //v3.0 -- This is the AdminTeamActivity code, no longer need two separate activities for TC and Admin as all in one Table.

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterAdminTeam adapter;

    private List<JSONAdminItem> AdminTeamList;

    private AdminTeamActivity activity;

    private String jsonString = "";

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_team);

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //This line will forcefully hide the bottom navigation bar on devices that have them
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Instantiating the recycler view as defined in admin_team
        mRecyclerView = (RecyclerView) findViewById(R.id.adminteam_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the parsed Admin Team List
        adapter = new RecyclerViewAdapterAdminTeam(activity, this, AdminTeamList);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Downloading data from below url (Universal Resource Locator) to obtain data from the Admin database
        final String url = "http://dbchudasama.webfactional.com/jsonscriptAdmin.php";
        new AsyncHTTPTask().execute(url);

        //3.0 -- Here setting the onClickListener for the FAB
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(NationalCommitteeActivity.this, "Failed to fetch Admin Team. No Internet!", Toast.LENGTH_SHORT).show();

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
        });
        //v3.0 --
    }

    public class AsyncHTTPTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 0;
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    jsonString = response.toString();
                    parseResult();
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }
            } catch (Exception e) {
                Log.d("Exception Caught", e.getLocalizedMessage());
            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {

            super.onPostExecute(result);

            if (result == 1) {
                //Initialising the adapter - Passing in the activity and the parsed Admin Team List
                adapter = new RecyclerViewAdapterAdminTeam(activity, NationalCommitteeActivity.this, AdminTeamList);
                //Setting the adapter
                mRecyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(NationalCommitteeActivity.this, "Failed to fetch Admin Team. No Internet!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //This method will parse the RAW data downloaded from the server
    private void parseResult() {

        try {

            JSONArray AdminArrays = new JSONArray(jsonString);
            AdminTeamList = new ArrayList<>();

            for (int i = 0; i < AdminArrays.length(); i++) {
                JSONObject AdminArrayObject = AdminArrays.getJSONObject(i);
                JSONAdminItem item = new JSONAdminItem();
                item.setAdminRole(AdminArrayObject.getString("AdminRole"));
                item.setName(AdminArrayObject.getString("Name"));

                this.AdminTeamList.add(item);

                Log.e("Admin Role", AdminArrayObject.getString("AdminRole"));
                Log.e("Name", AdminArrayObject.getString("Name"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}   //v3.0 --

    //Below is the old code when TC and Admin Table Views were separate.
    /*
    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterNationalCommiitee adapter;

    private static final int ITEM_COUNT = 2;

    @Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.national_committee);

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //final View layout = inflater.inflate(R.layout.national_committee, container, false);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Instantiating the recycler view as defined in national_committee
        mRecyclerView=(RecyclerView) findViewById(R.id.natcom_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the getData method
        adapter=new RecyclerViewAdapterNationalCommiitee(this,getData());

        //Here passing in the click listener into the Adapter. 'this' signifies that it is the fragment that handles the click listener.
        //This is possible as the on Click Listener interface is being implemented.
        adapter.setClickListener(this);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    //return layout;

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar enough_food it is present.
        getMenuInflater().inflate(R.menu.menu_email, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_email) {

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

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Creating an array list of information objects that can be passed into the recycler view
    public static List<SubInformation> getData() {

        List<SubInformation> data = new ArrayList<>();

        //String array of text for the recycler view
        String[] text = {"Admin Team"}; //"Team Coordinators"}; //v3.0

        //For loop to go through entire length of the menu string
        for(int i=0; i<ITEM_COUNT; i++){

            data.add(new SubInformation(text[i]));

        }

        return data;
    }

    @Override
    public void itemClicked(View view, int position) {

    }
}
*/
