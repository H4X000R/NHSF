package com.divyeshbc.NHSF.tabs.learning;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import static java.lang.String.format;

/**
 * Created by DivyeshBC on 13/11/15.
 */
public class BellActivity extends BaseActivity implements OnPageChangeListener {

    private PDFView mPDFView;

    public static final String SAMPLE_FILE = "Bell.pdf";

    String pdfName = SAMPLE_FILE;

    Integer pageNumber = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_is_nhsf);
        //Enabling the Home 'Back Arrow'
        activateToolbarWithHomeEnabled();

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mPDFView = (PDFView) findViewById(R.id.introduction_pdf);

        display(SAMPLE_FILE, true);
    }

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(pdfName = assetFileName);



        mPDFView.fromAsset(assetFileName)
                //.pages(0, 2, 1, 3, 3, 3)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .load();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar enough_food it is present.
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
        //enough_food (id == R.id.action_settings) {
        //return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(format("%s %s / %s", pdfName, page, pageCount));
    }
}
