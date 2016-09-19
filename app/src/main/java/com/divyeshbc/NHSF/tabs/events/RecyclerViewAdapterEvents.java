package com.divyeshbc.NHSF.tabs.events;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divyeshbc.NHSF.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by DivyeshBC on 09/11/15.
 */
public class RecyclerViewAdapterEvents extends RecyclerView.Adapter<RecyclerViewAdapterEvents.MyViewHolder> {

    private LayoutInflater inflater;

    //String returning all EVENT Object properties
    public static final String EVENT_TRANSFER = "EVENT_TRANSFER";

    private List<JSONEventsItem> data = Collections.emptyList();

    private Context mContext;

    //Variable for the on click Listener
    private ClickListener clickListener;

    //Passing in the array list argument
    public RecyclerViewAdapterEvents(Context context, List<JSONEventsItem> data) {

        this.mContext = context;
        //this.activity = activity;

        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.data = data;

    }

    @Override
    public RecyclerViewAdapterEvents.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row_natcom, parent, false);

        //Passing the root view through as an argument
        MyViewHolder holder = new MyViewHolder(view);

        //Returning the view holder
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterEvents.MyViewHolder holder, final int position) {

        //This will get the current position of the JSONEventItem object from the array
        JSONEventsItem eventsItem = data.get(position);

        //Setting the event name to the name of the event retrieved from the Database (converting from JSON)
        holder.eventName.setText(Html.fromHtml(eventsItem.getEventName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent to EventsActivity
                Intent intent = new Intent(mContext, EventsActivity.class);

                //Along with the Event Title also transfer the additional event details that will display based on the
                //position of the event in the cell
                intent.putExtra(EVENT_TRANSFER, getEvent(position));

                //Navigate to the intent
                mContext.startActivity(intent);
            }

            });
    }

    public void setClickListener(ClickListener clicklistener) {
        this.clickListener = clicklistener;
    }

    @Override
    public int getItemCount() {

        return (null != data ? data.size() : 0);
    }

    public interface ClickListener {
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView eventName;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            eventName = (TextView) itemView.
                    findViewById(R.id.listText);
        }
    }

    //Getting the Event Item position
    public JSONEventsItem getEvent(int position) {
        //If the data list is null then return null, otherwise return the position of the event in the list
        return (null != data ? data.get(position) : null);
    }
}
