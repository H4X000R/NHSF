package com.divyeshbc.NHSF.tabs.learning;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import static java.lang.String.format;

/**
 * Created by DivyeshBC on 12/11/15.
 */
public class MustKnowMantrasActivity extends BaseActivity implements OnPageChangeListener {

    private PDFView mPDFView;

    public static final String SAMPLE_FILE = "Must Know Mantras.pdf";

    String pdfName = SAMPLE_FILE;

    Integer pageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_is_nhsf);

        activateToolBar();

        mPDFView = (PDFView) findViewById(R.id.introduction_pdf);

        display(SAMPLE_FILE, true);
    }

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(pdfName = assetFileName);

        mPDFView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageChanged(int page, int pageCount) {

        pageNumber = page;
        setTitle(format("%s %s / %s", pdfName, page, pageCount));
    }
}
