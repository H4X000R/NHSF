package com.divyeshbc.NHSF.tabs.learning;

import android.content.Context;
import android.content.Intent;
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
 * Created by DivyeshBC on 14/11/15.
 */
public class RecyclerViewAdapterFestivals extends RecyclerView.Adapter<RecyclerViewAdapterFestivals.MyViewHolder> {

    private Context context;
    //private LayoutInflater inflater;

    //Variable for the on click Listener
    private ClickListener clickListener;

    private LayoutInflater inflater;

    //Defining an array list of type information. This will be the data set for the recycler view. .emptyList() will
    //take care of the null pointer exception
    List<SubInformation> dataSet = Collections.emptyList();

    //Context context;

    //Passing in the array list argument
    public RecyclerViewAdapterFestivals(Context context, List<SubInformation> data) {

        this.context = context;
        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.dataSet = data;
        //dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row_natcom, parent, false);

        //View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
        //R.layout.custom_row_learning, null);

        //Passing the root view through as an argument
        MyViewHolder holder = new MyViewHolder(view);

        //Returning the view holder
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        //This will get the current position of the SubInformation object from the SubInformation array
        SubInformation current = dataSet.get(position);

        //Setting the text in the row to be the custom_row text
        holder.title.setText(current.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;

                switch (position) {
                    case 0:
                        //Intent to Jan - June Festivals Activity (RecyclerView)
                        intent = new Intent(context, JanToJuneActivity.class);
                        break;

                    case 1:
                        //Intent to the July - December Activity (RecyclerView)
                        intent = new Intent(context, JulyToDecActivity.class);
                        break;

                    default:
                        break;
                }

                //In order for an activity to begin, a context needs to be passed in
                context.startActivity(intent);
                //If the method is not called (Error handling to avoid NULL POINTER EXCEPTION ERROR)
                if(clickListener != null)
                {
                    //Trigger the appropriate call. getPosition will get the latest position of the item clicked by the user
                    clickListener.itemClicked(v, position);
                }
            }
        });
    }

    //Setting up a click listener which lets me set up an object that implements the interface
    public void setClickListener(ClickListener clickListener){

        //Initialising the clickListener
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        //Returning the size of the data held in the information array
        return dataSet.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            title = (TextView) itemView.
                    findViewById(R.id.listText);
        }
    }

    //Here, inside the adapter have made an interface. This interface is implemented in the Tab1 class Fragment.
    public interface ClickListener {
        void itemClicked(View view, int position);
    }
}