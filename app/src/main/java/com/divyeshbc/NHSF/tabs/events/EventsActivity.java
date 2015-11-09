package com.divyeshbc.NHSF.tabs.events;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * Created by DivyeshBC on 09/11/15.
 */
public class EventsActivity extends BaseActivity implements RecyclerViewAdapterEvents.ClickListener {

    private RecyclerView mRecyclerView;

    //Creating an instance of the adapter object
    private RecyclerViewAdapterEvents adapter;

    private List<JSONEventsItem> EventsList;

    private EventsActivity activity;

    private String jsonString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_3);

        //Calling Activate Toolbar method (with the Back button enabled)
        activateToolbarWithHomeEnabled();

        //Instantiating the recycler view as defined in admin_team
        //mRecyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);

        //Adding item decoration. Recycler view divider
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //Initialising the adapter - Passing in the activity and the parsed Events List
        adapter = new RecyclerViewAdapterEvents(this, EventsList);

        //Setting the adapter
        mRecyclerView.setAdapter(adapter);

        //Setting the Layout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Downloading data from below url (Universal Resource Locator) to obtain data from the Admin database
        final String url = "http://dbchudasama.webfactional.com/jsonscript.php";
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

            //adapter.getItemCount();

            if (result == 1) {
                //Intent intent = getIntent();
                //intent.getSerializableExtra("JSON Admin");
                //Initialising the adapter - Passing in the activity and the parsed Admin Team List
                adapter = new RecyclerViewAdapterEvents(EventsActivity.this, EventsList);
                //Setting the adapter
                mRecyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(EventsActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //This method will parse the RAW data downloaded from the server
    private void parseResult() {

        try {

            JSONArray AdminArrays = new JSONArray(jsonString);
            EventsList = new ArrayList<>();

            for (int i = 0; i < AdminArrays.length(); i++) {
                JSONObject AdminArrayObject = AdminArrays.getJSONObject(i);
                JSONEventsItem item = new JSONEventsItem();
                item.setEventName(AdminArrayObject.getString("eventName"));

                this.EventsList.add(item);

                Log.e("Event Name", AdminArrayObject.getString("eventName"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
