package com.divyeshbc.NHSF.tabs.sewa;

import android.content.Context;
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
 * Created by DivyeshBC on 17/06/15.
 */
public class RecyclerViewAdapterSewa extends RecyclerView.Adapter<RecyclerViewAdapterSewa.MyViewHolder> {

    private LayoutInflater inflater;

    //Defining an array list of type information. This will be the data set for the recycler view. .emptyList() will
    //take care of the null pointer exception
    List<Information> data = Collections.emptyList();

    //Passing in the array list argument
    public RecyclerViewAdapterSewa(Context context, List<Information> data){

        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row_sewa, parent, false);

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

    @Override
    public int getItemCount() {
        //Returning the size of the data held in the information array
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            title = (TextView) itemView.findViewById(R.id.listText);
            subTitle = (TextView) itemView.findViewById(R.id.subTitle);
        }
    }
}
