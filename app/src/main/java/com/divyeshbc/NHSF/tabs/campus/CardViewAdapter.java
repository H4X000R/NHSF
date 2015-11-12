package com.divyeshbc.NHSF.tabs.campus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.divyeshbc.NHSF.Chapter;
import com.divyeshbc.NHSF.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by DivyeshBC on 23/08/15.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private static ArrayList<Chapter> dataSet;

    PhotoViewAttacher mPhotoViewAttacher;

    //Variable for the on click Listener
    //private ClickListener clickListener;

    public CardViewAdapter(Context context, ArrayList<Chapter> chapters) {

        this.context = context;

        //inflater = LayoutInflater.from(context);

        dataSet = chapters;
    }


    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.card_view, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CardViewAdapter.ViewHolder viewHolder, final int i) {

        final Chapter chapter = dataSet.get(i);

        Picasso.with(context)
                .load(chapter.getThumbnail())
                .resize(1300, 1300)
                .into(viewHolder.iconView);
        mPhotoViewAttacher = new PhotoViewAttacher(viewHolder.iconView);

        viewHolder.chapterName.setText(chapter.getTitle());
        //viewHolder.iconView.setImageResource(fp.getThumbnail());
        viewHolder.chapterZone.setText(chapter.getZone());
        viewHolder.chapterDetails.setText(chapter.getSubTitle());
        viewHolder.details = chapter;


        viewHolder.iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            //Setting an onClick on the imageView
            public void onClick(View v) {

                Intent intent = null;

                /*
                switch (i) {
                    case 0:
                        //Intent to NHSF Aston Image
                        intent = new Intent(context, ChapterImageZoomActivity.class);
                        break;

                    default:
                        break;
                }
                */

                intent = new Intent(context, ChapterImageZoomActivity.class);

                //intent.putExtra("CHAPTER_IMAGE" , dataSet.get(i));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface Clicklistener {
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView chapterName;
        public TextView chapterDetails;
        public TextView chapterZone;
        public ImageView iconView;
        //public ImageView mImageView;

        public Chapter details;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            chapterName = (TextView) itemLayoutView
                    .findViewById(R.id.chapterName);
            iconView = (ImageView) itemLayoutView
                    .findViewById(R.id.iconId);
            chapterZone = (TextView) itemLayoutView
                    .findViewById(R.id.chapterZone);
            chapterDetails = (TextView) itemLayoutView
                    .findViewById(R.id.chapterDetails);
        }
    }

    //Getting the image position
    public Chapter getImage(int position) {

        //If dataset is null then return null, otherwise return the position of the image in the list
        return (null != dataSet ? dataSet.get(position) : null);
    }
}
