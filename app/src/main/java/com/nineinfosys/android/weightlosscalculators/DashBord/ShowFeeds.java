package com.nineinfosys.android.weightlosscalculators.DashBord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.nineinfosys.android.weightlosscalculators.R;

/**
 * Created by Dev on 14-03-2017.
 */

public class ShowFeeds extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_feeds);
        WebView w1=(WebView)findViewById(R.id.webView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebSettings webSettings = w1.getSettings();
        webSettings.setJavaScriptEnabled(false);
        w1.loadUrl(url);
    }
}