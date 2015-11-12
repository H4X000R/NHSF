package com.divyeshbc.NHSF.tabs.campus;

import android.view.View;
import android.widget.ImageView;

import com.divyeshbc.NHSF.Chapter;
import com.divyeshbc.NHSF.R;

/**
 * Created by DivyeshBC on 10/11/15.
 */
public class ChapterImageHolder extends CardViewAdapter.ViewHolder {

    //SubsamplingScaleImageView where the image will be stored
    protected ImageView chapterImage;

    protected Chapter chapObject;

    //private Context context;

    //Constructor for the Image View Holder
    public ChapterImageHolder(View view, Chapter chap){
        super(view);
        //Initialising the ImageView as defined in the browse.xml file
        this.chapterImage = (ImageView) view.findViewById(R.id.chapterImageView);

        this.chapObject = chap;

        //chapterImage.setImage(ImageSource.resource(chap.getThumbnail()));
        //this.context = context;
    }
}
