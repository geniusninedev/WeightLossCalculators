package com.nineinfosys.android.weightlosscalculators.DashBord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.weightlosscalculators.FatIntake.FatIntakeCalculator;
import com.nineinfosys.android.weightlosscalculators.R;

/**
 * Created by Dev on 14-03-2017.
 */

public class ShowFeeds extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_feeds);

        MobileAds.initialize(ShowFeeds.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewnews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        WebView w1 = (WebView) findViewById(R.id.webView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebSettings webSettings = w1.getSettings();
        webSettings.setJavaScriptEnabled(false);
        w1.loadUrl(url);
        ShowFeeds.this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }
}