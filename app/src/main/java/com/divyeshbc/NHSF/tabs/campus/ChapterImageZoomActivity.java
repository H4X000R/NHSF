package com.divyeshbc.NHSF.tabs.campus;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.Chapter;
import com.divyeshbc.NHSF.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by DivyeshBC on 10/11/15.
 */
public class ChapterImageZoomActivity extends BaseActivity implements CardViewAdapter.Clicklistener{

    private ImageView mImageView;

    private PhotoViewAttacher mPhotoViewAttacher;

    private Context mContext;

    private Chapter cImage;

    private ChapterImageHolder CIH;

    private CardView mCardView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_image_zoom);

        activateToolBar();

        Intent intent = getIntent();

        //mImageView = (ImageView) intent.getSerializableExtra(CHAPTER_IMAGE);

        mImageView = (ImageView) findViewById(R.id.chapterImageView);

        Drawable bitmap = getResources().getDrawable(R.drawable.nhsf_aston);
        mImageView.setImageDrawable(bitmap);

        //Attach a PhotoViewAttacher, which takes care of all of the zooming functionality
        mPhotoViewAttacher = new PhotoViewAttacher(mImageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.intro_pdf_details, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //return true;
        //}

        return super.onOptionsItemSelected(item);
    }



}

