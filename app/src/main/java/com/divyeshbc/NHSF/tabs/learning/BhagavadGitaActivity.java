package com.divyeshbc.NHSF.tabs.learning;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import static java.lang.String.format;

/**
 * Created by DivyeshBC on 12/11/15.
 */
public class BhagavadGitaActivity extends BaseActivity implements OnPageChangeListener {

    private PDFView mPDFView;

    private WebView mWebView;

    public static final String SAMPLE_FILE = "Bhagavad Gita.pdf";

    String pdfName = SAMPLE_FILE;

    Integer pageNumber = 1;

    //String pdfURL = "https://drive.google.com/open?id=0B9N_W4Tvxh5pUTFELUFKSjRpYTg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_is_nhsf);
        //setContentView(R.layout.hum_magazine);

        //Enabling the Home 'Back Arrow'
        activateToolbarWithHomeEnabled();

        //Instantiating the webView as defined in hum_magazines
        //mWebView = (WebView) findViewById(R.id.webView);

        //mWebView.setWebViewClient(new MyBrowser());
        //mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        //mWebView.loadUrl(url);

        //Setting the orientation to Portrait Only
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mPDFView = (PDFView) findViewById(R.id.introduction_pdf);

        display(SAMPLE_FILE, true);

        //---you need this to prevent the webview from
        // launching another browser when a url
        // redirection occurs---
        //mWebView.setWebViewClient(new Callback());

        //String pdfURL = "https://www.dropbox.com/home/NHSF%20App%20Android%20Learning?preview=Bhagavad+Gita.pdf";
        //mWebView.loadUrl(
                //"http://docs.google.com/gview?embedded=true&url=" + pdfURL);
    }

    /*
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }
    */

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(pdfName = assetFileName);

        mPDFView.fromAsset(assetFileName)
                //.pages(0, 2, 1, 3, 3, 3)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .load();

    }

    /*
    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(
                WebView view, String url) {
            view.loadUrl(url);
            return(true);
        }
    }
    */

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
