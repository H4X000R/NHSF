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
        //mPhotoViewAttacher = new PhotoViewAttacher(viewHolder.iconView);

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

                switch (i) {
                    case 0:
                        //Intent to NHSF Aston Image
                        intent = new Intent(context, NHSFAstonImageActivity.class);
                        break;

                    case 1:
                        //Intent to NHSF BCU Image
                        intent = new Intent(context, NHSFBCUImageActivity.class);
                        break;

                    case 2:
                        //Intent to NHSF Birmingham Image
                        intent = new Intent(context, NHSFBirminghamImageActivity.class);
                        break;

                    case 3:
                        //Intent to NHSF BPP Image
                        intent = new Intent(context, NHSFBPPImageActivity.class);
                        break;

                    case 4:
                        //Intent to NHSF Bradford Image
                        intent = new Intent(context, NHSFBradfordImageActivity.class);
                        break;

                    case 5:
                        //Intent to NHSF Brighton Image
                        intent = new Intent(context, NHSFBrightonImageActivity.class);
                        break;

                    case 6:
                        //Intent to NHSF Bristol Image
                        intent = new Intent(context, NHSFBristolImageActivity.class);
                        break;

                    case 7:
                        //Intent to NHSF Brunel Image
                        intent = new Intent(context, NHSFBrunelImageActivity.class);
                        break;

                    case 8:
                        //Intent to NHSF Bucks New Uni Image
                        intent = new Intent(context, NHSFBucksImageActivity.class);
                        break;

                    case 9:
                        //Intent to NHSF City Image
                        intent = new Intent(context, NHSFCityImageActivity.class);
                        break;

                    case 10:
                        //Intent to NHSF Coventry Image
                        intent = new Intent(context, NHSFCoventryImageActivity.class);
                        break;

                    case 11:
                        //Intent to NHSF DMU Image
                        intent = new Intent(context, NHSFDMUImageActivity.class);
                        break;

                    case 12:
                        //Intent to NHSF Exeter Image
                        intent = new Intent(context, NHSFExeterImageActivity.class);
                        break;

                    case 13:
                        //Intent to NHSF Greenwich Image
                        intent = new Intent(context, NHSFGreenwichImageActivity.class);
                        break;

                    case 14:
                        //Intent to NHSF Hertfordshire Image
                        intent = new Intent(context, NHSFHertfordshireImageActivity.class);
                        break;

                    case 15:
                        //Intent to NHSF Huddersfield Image
                        intent = new Intent(context, NHSFHuddersfieldImageActivity.class);
                        break;

                    case 16:
                        //Intent to NHSF Hull Image
                        intent = new Intent(context, NHSFHullImageActivity.class);
                        break;

                    case 17:
                        //Intent to NHSF Imperial Image
                        intent = new Intent(context, NHSFImperialImageActivity.class);
                        break;

                    case 18:
                        //Intent to NHSF KCL Image
                        intent = new Intent(context, NHSFKCLImageActivity.class);
                        break;

                    case 19:
                        //Intent to NHSF Keele Image
                        intent = new Intent(context, NHSFKeeleImageActivity.class);
                        break;

                    case 20:
                        //Intent to NHSF Kent Image
                        intent = new Intent(context, NHSFKentImageActivity.class);
                        break;

                    case 21:
                        //Intent to NHSF Kingston Image
                        intent = new Intent(context, NHSFKingstonImageActivity.class);
                        break;

                    case 22:
                        //Intent to NHSF Leeds Image
                        intent = new Intent(context, NHSFLeedsImageActivity.class);
                        break;

                    case 23:
                        //Intent to NHSF Leicester Image
                        intent = new Intent(context, NHSFLeicesterImageActivity.class);
                        break;

                    case 24:
                        //Intent to NHSF Liverpool Image
                        intent = new Intent(context, NHSFLiverpoolImageActivity.class);
                        break;

                    case 25:
                        //Intent to NHSF Loughborough Image
                        intent = new Intent(context, NHSFLoughboroughImageActivity.class);
                        break;

                    case 26:
                        //Intent to NHSF LSBU Image
                        intent = new Intent(context, NHSFLSBUImageActivity.class);
                        break;

                    case 27:
                        //Intent to NHSF LSE Image
                        intent = new Intent(context, NHSFLSEImageActivity.class);
                        break;

                    case 28:
                        //Intent to NHSF Manchester Image
                        intent = new Intent(context, NHSFManchesterImageActivity.class);
                        break;

                    case 29:
                        //Intent to NHSF Medway Image
                        intent = new Intent(context, NHSFMedwayImageActivity.class);
                        break;

                    case 30:
                        //Intent to NHSF Northampton Image
                        intent = new Intent(context, NHSFNorthamptonImageActivity.class);
                        break;

                    case 31:
                        //Intent to NHSF Northumbria Image
                        intent = new Intent(context, NHSFNorthumbriaImageActivity.class);
                        break;

                    case 32:
                        //Intent to NHSF Nottingham Image
                        intent = new Intent(context, NHSFNottinghamImageActivity.class);
                        break;

                    case 33:
                        //Intent to NHSF NTU Image
                        intent = new Intent(context, NHSFNTUImageActivity.class);
                        break;

                    case 34:
                        //Intent to NHSF Plymouth Image
                        intent = new Intent(context, NHSFPlymouthImageActivity.class);
                        break;

                    case 35:
                        //Intent to Portsmouth Image
                        intent = new Intent(context, NHSFPortsmouthImageActivity.class);
                        break;

                    case 36:
                        //Intent to NHSF QMUL Image
                        intent = new Intent(context, NHSFQMULImageActivity.class);
                        break;

                    case 37:
                        //Intent to NHSF Reading Image
                        intent = new Intent(context, NHSFReadingImageActivity.class);
                        break;

                    case 38:
                        //Intent to NHSF RHUL Image
                        intent = new Intent(context, NHSFRHULImageActivity.class);
                        break;

                    case 39:
                        //Intent to NHSF Roehampton Image
                        intent = new Intent(context, NHSFRoehamptonImageActivity.class);
                        break;

                    case 40:
                        //Intent to NHSF SGUL Image
                        intent = new Intent(context, NHSFSGULImageActivity.class);
                        break;

                    case 41:
                        //Intent to NHSF Sheffield Image
                        intent = new Intent(context, NHSFSheffieldImageActivity.class);
                        break;

                    case 42:
                        //Intent to NHSF SOAS Image
                        intent = new Intent(context, NHSFSOASImageActivity.class);
                        break;

                    case 43:
                        //Intent to NHSF Southampton Image
                        intent = new Intent(context, NHSFSouthamptonImageActivity.class);
                        break;

                    case 44:
                        //Intent to NHSF Swansea Image
                        intent = new Intent(context, NHSFSwanseaImageActivity.class);
                        break;

                    case 45:
                        //Intent to NHSF UEA Image

                        break;

                    case 46:
                        //Intent to NHSF UWE Image

                        break;

                    case 47:
                        //Intent to NHSF Warwick Image

                        break;

                    case 48:
                        //Intent to NHSF Westminster Image

                        break;

                    case 49:
                        //Intent to NHSF York Image

                        break;

                    default:
                        break;
                }

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
}
