package com.divyeshbc.NHSF.tabs.learning;

import android.content.Context;
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
 * Created by DivyeshBC on 15/11/15.
 */
public class RecyclerViewAdapterImportantDates extends RecyclerView.Adapter<RecyclerViewAdapterImportantDates.MyViewHolder> {

    private LayoutInflater inflater;

    private ImportantDatesActivity activity;

    private List<JSONImportantDateItem> data = Collections.emptyList();

    private Context mContext;


    //Passing in the array list argument
    public RecyclerViewAdapterImportantDates(ImportantDatesActivity activity, Context context, List<JSONImportantDateItem> data){

        this.mContext = context;
        this.activity = activity;

        inflater = LayoutInflater.from(context);

        //Setting the array list data to the argument passed in
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating the row and getting the root of view of the custom row admin (Linear Layout)
        View view = inflater.inflate(R.layout.custom_row_important_dates, parent, false);

        //Passing the root view through as an argument
        MyViewHolder holder = new MyViewHolder(view);

        //Returning the view holder
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //This will get the current position of the JSONAdminItem object from the array
        JSONImportantDateItem importantDateItem = data.get(position);

        //Setting the title to be the Admin Role (converting from JSON)
        holder.title.setText(Html.fromHtml(importantDateItem.getUtsavName()));
        //Setting the subtitle to be the Name (converting from JSON)
        holder.subTitle.setText(Html.fromHtml(importantDateItem.getImportantDate()));
    }

    @Override
    public int getItemCount() {
        //return data.size();

        return (null != data ? data.size() : 0);
    }

    public interface ClickListener {
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subTitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Here setting the id of the textview in the recycler view holder to be the list view from the custom_row xml
            title = (TextView) itemView.
                    findViewById(R.id.listText);
            subTitle = (TextView) itemView.findViewById(R.id.subTitle);
        }
    }
}
