package com.divyeshbc.NHSF.tabs.learning;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.divyeshbc.NHSF.BaseActivity;
import com.divyeshbc.NHSF.R;

/**
 * Created by DivyeshBC on 16/11/15.
 */
public class HUMActivity extends BaseActivity {

    private WebView mWebView;

    String url =  "https://drive.google.com/folderview?id=0B6OBRdGlEgKWVmJDUHY3Z014Vkk&usp=sharing&tid=0BzyMQbHGDsGbNWQ4bVZpOE1ZZWs#grid";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hum_magazine);

        //Instantiating the webView as defined in hum_magazines
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setWebViewClient(new MyBrowser());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar enough_food it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
