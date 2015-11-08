package com.divyeshbc.NHSF.tabs.aboutUs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.JSONTCItem;
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
 * Created by DivyeshBC on 07/11/15.
 */
public class TeamCoordinatorsActivity extends BaseActivity implements RecyclerViewAdapterTC.ClickListener{

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterTC adapter;

    private List<JSONTCItem> TCTeamList;

    private TeamCoordinatorsActivity activity;

    private String jsonString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.natcom_tc);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Instantiating the recycler view as defined in admin_team
        mRecyclerView = (RecyclerView) findViewById(R.id.natcomtc_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the parsed Admin Team List
        adapter = new RecyclerViewAdapterTC(activity, this, TCTeamList);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Downloading data from below url (Universal Resource Locator) to obtain data from the Admin database
        final String url = "http://dbchudasama.webfactional.com/jsonscriptTeamCoordinators.php";
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
                adapter = new RecyclerViewAdapterTC(activity, TeamCoordinatorsActivity.this, TCTeamList);
                //Setting the adapter
                mRecyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(TeamCoordinatorsActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //This method will parse the RAW data downloaded from the server
    private void parseResult() {

        try {

            JSONArray TCArrays = new JSONArray(jsonString);
            TCTeamList = new ArrayList<>();

            for (int i = 0; i < TCArrays.length(); i++) {
                JSONObject TCArrayObject = TCArrays.getJSONObject(i);
                JSONTCItem item = new JSONTCItem();
                item.setTCRole(TCArrayObject.getString("Team"));
                item.setName(TCArrayObject.getString("TCName"));

                this.TCTeamList.add(item);

                Log.e("Team", TCArrayObject.getString("Team"));
                Log.e("TC Name", TCArrayObject.getString("TCName"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

