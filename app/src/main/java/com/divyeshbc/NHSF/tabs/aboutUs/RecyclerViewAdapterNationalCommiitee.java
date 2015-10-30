package com.divyeshbc.NHSF.tabs.aboutUs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.divyeshbc.NHSF.R;
import com.divyeshbc.NHSF.SubInformation;

import java.util.Collections;
import java.util.List;

/**
 * Created by DivyeshBC on 27/10/15.
 */
public class RecyclerViewAdapterNationalCommiitee extends RecyclerView.Adapter<RecyclerViewAdapterNationalCommiitee.MyViewHolder> {

    private LayoutInflater inflater;

    //Variable for the on click Listener
    private ClickListener clickListener;

    List<SubInformation> data = Collections.emptyList();

    //Passing in the array list argument
    public RecyclerViewAdapterNationalCommiitee(Context context, List<SubInformation> data){

        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row natcom (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row_natcom, parent, false);

        //Passing the root view through as an argument
        MyViewHolder holder = new MyViewHolder(view);

        //Returning the view holder
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //This will get the current position of the Information object from the Information array
        SubInformation current = data.get(position);

        holder.title.setText(current.getTitle());
    }

    //Setting up a click listener which lets me set up an object that implements the interface
    public void setClickListener(ClickListener clickListener){

        //Initialising the clickListener
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            title = (TextView) itemView.
                    findViewById(R.id.listText);
        }

        @Override
        public void onClick(View v) {

        }
    }

    //Here, inside the adapter have made an interface. This interface is implemented in the Tab1 class Fragment.
    public interface ClickListener {
        void itemClicked(View view, int position);
    }
}
