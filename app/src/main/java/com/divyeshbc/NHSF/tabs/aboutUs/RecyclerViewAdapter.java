package com.divyeshbc.NHSF.tabs.aboutUs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.divyeshbc.NHSF.Information;
import com.divyeshbc.NHSF.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by DivyeshBC on 26/05/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;

    //Variable for the on click Listener
    private ClickListener clickListener;

    //Defining an array list of type information. This will be the data set for the recycler view. .emptyList() will
    //take care of the null pointer exception
    List<Information> data = Collections.emptyList();

    //Passing in the array list argument
    public RecyclerViewAdapter(Context context, List<Information> data){

        this.context = context;

        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row, parent, false);

        //Passing the root view through as an argument
        MyViewHolder holder = new MyViewHolder(view);

        //Returning the view holder
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //This will get the current position of the Information object from the Information array
        Information current = data.get(position);
        //Information subCurrent = data.get(position);

        //Setting the text in the row to be the custom_row text
        holder.title.setText(current.getTitle());
        holder.subTitle.setText(current.getSubtitle());

    }

    //Setting up a click listener which lets me set up an object that implements the interface
    public void setClickListener(ClickListener clickListener){

        //Initialising the clickListener
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        //Returning the size of the data held in the information array
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //implements View.OnClickListener {

        TextView title;
        TextView subTitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Setting an on Click Listener inside the ViewHolder
            itemView.setOnClickListener(this);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            title = (TextView) itemView.findViewById(R.id.listText);
            subTitle = (TextView) itemView.findViewById(R.id.subTitle);
        }

        @Override
        public void onClick(View v) {

            Intent intent = null;

            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(context, IntroductionActivity.class);
                    break;

                case 1:
                    intent = new Intent(context, NationalCommitteeActivity.class);
                    break;
                default:
                    Toast.makeText(v.getContext(), "Default Case", Toast.LENGTH_SHORT).show();
                    break;
            }

            //In order for an activity to begin, a context needs to be passed in
            //context.startActivity(new Intent(context, IntroductionActivity.class));
            context.startActivity(intent);
            //If the method is not called (Error handling to avoid NULL POINTER EXCEPTION ERROR)
            if(clickListener != null)
            {
                //Trigger the appropriate call. getPosition will get the latest position of the item clicked by the user
                clickListener.itemClicked(v, getAdapterPosition());
            }

        }

    }

        //Here, inside the adapter have made an interface. This interface is implemented in the Tab1 class Fragment.
        public interface ClickListener {
            void itemClicked(View view, int position);
        }

}
