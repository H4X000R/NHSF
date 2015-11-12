package com.divyeshbc.NHSF.tabs.learning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divyeshbc.NHSF.Information;
import com.divyeshbc.NHSF.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by DivyeshBC on 12/11/15.
 */
public class RecyclerViewAdapterMustRead extends RecyclerView.Adapter<RecyclerViewAdapterMustRead.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;

    //Variable for the on click Listener
    private ClickListener clickListener;

    List<Information> data = Collections.emptyList();

    //Passing in the array list argument
    public RecyclerViewAdapterMustRead(Context context, List<Information> data) {

        this.context = context;
        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row natcom (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row_learning, parent, false);

        //Passing the root view through as an argument
        MyViewHolder holder = new MyViewHolder(view);

        //Returning the view holder
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        //This will get the current position of the Information object from the Information array
        Information current = data.get(position);

        holder.title.setText(current.getTitle());
        holder.subtitle.setText(current.getSubtitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;

                switch (position) {
                    case 0:
                        //Intent to Bhagavad Gita PDF
                        intent = new Intent(context, BhagavadGitaActivity.class);
                        break;

                    case 1:
                        //Intent to What is Hinduism RecyclerView
                        intent = new Intent(context, WhatIsHinduismActivity.class);
                        break;
                    default:
                        break;
                }

                //In order for an activity to begin, a context needs to be passed in
                context.startActivity(intent);
                //If the method is not called (Error handling to avoid NULL POINTER EXCEPTION ERROR)
                //Trigger the appropriate call. getPosition will get the latest position of the item clicked by the user
                if (clickListener != null) {
                    clickListener.itemClicked(v, position);
                }
            }
        });
    }
    //Setting up a click listener which lets me set up an object that implements the interface
    public void setClickListener(ClickListener clickListener) {

        //Initialising the clickListener
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subtitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            title = (TextView) itemView.
                    findViewById(R.id.listText);
            subtitle = (TextView) itemView.
                        findViewById(R.id.subTitle);
        }
    }

    //Here, inside the adapter have made an interface. This interface is implemented in the Tab1 class Fragment.
    public interface ClickListener {
        void itemClicked(View view, int position);
    }
}
