package com.divyeshbc.NHSF.tabs.aboutUs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.JSONAdminItem;
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
 * Created by DivyeshBC on 31/10/15.
 */
public class AdminTeam extends BaseActivity implements RecyclerViewAdapterAdminTeam.ClickListener{

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterAdminTeam adapter;

    private List<JSONAdminItem> AdminTeamList;

    //private static final int ITEM_COUNT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_team);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Instantiating the recycler view as defined in admin_team
        mRecyclerView = (RecyclerView) findViewById(R.id.adminteam_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Downloading data from below url (Universal Resource Locator) to obtain data from the Admin database
        final String url = "http://dbchudasama.webfactional.com/jsonscriptAdmin.php";
        new AsyncHTTPTask().execute(url);
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
                    parseResult(response.toString());
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

            if (result == 1) {
                //Initialising the adapter - Passing in the activity and the parsed Admin Team List
                adapter = new RecyclerViewAdapterAdminTeam(AdminTeam.this, AdminTeamList);
                //Setting the adapter
                mRecyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(AdminTeam.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //This method will parse the RAW data downloaded from the server
    private void parseResult(String result) {
        try {
            //Converting into a JSON Object
            JSONObject response = new JSONObject(result);
            //Now converting this JSON Object into and a JSON Array
            JSONArray AdminArrays = response.optJSONArray("Admin Arrays");
            AdminTeamList = new ArrayList<>();

            //String[] AdminRole = {};

            for (int i = 0; i < AdminArrays.length(); i++) {
                JSONObject AdminArray = AdminArrays.optJSONObject(i);
                JSONAdminItem item = new JSONAdminItem();
                item.setAdminRole(AdminArray.optString("Admin Role"));
                item.setName(AdminArray.optString("Name"));

                AdminTeamList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}