package com.nineinfosys.android.weightlosscalculators.HealthyWeight;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.weightlosscalculators.LeanBodyMass.LeanBodyMassCalculator;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

public class HealthyWeightCalculator extends AppCompatActivity {
    EditText editTextHeight,edittextfeet,edittextInch;
    Button buttonCalculate,buttonMoreInfo;
    ImageView imageViewHeight;
    private RadioGroup radioGroupHeight;
    private RadioButton radioButtonHeight;
    TextView textViewHealthyWeight;
    WebView Introwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_healthyweight);

        MobileAds.initialize(HealthyWeightCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewMainPagehealthy);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
       // ((MainActivityDrawer) HealthyWeightCalculator).toolbar.setTitle("Healthy Weight");
        editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        edittextfeet = (EditText) findViewById(R.id.edittextFeet);
        edittextInch = (EditText) findViewById(R.id.edittextInch);
        imageViewHeight = (ImageView) findViewById(R.id.imageViewHeight);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);
        textViewHealthyWeight = (TextView) findViewById(R.id.textViewHealthyWeight);

        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert Dialog Declaration For More Infomation
                final LayoutInflater inflaterMoreInfo = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayoutMoreInfo = inflaterMoreInfo.inflate(R.layout.info_webview, null);
                final AlertDialog.Builder alertDialogBuilderMoreInfo = new AlertDialog.Builder(HealthyWeightCalculator.this);
                alertDialogBuilderMoreInfo.setTitle("More Info:");
                Introwebview = (WebView) alertLayoutMoreInfo.findViewById(R.id.webViewinfo);
                WebSettings IntroWebSettings = Introwebview.getSettings();
                IntroWebSettings.setBuiltInZoomControls(true);
                IntroWebSettings.setJavaScriptEnabled(true);
                IntroWebSettings.setUseWideViewPort(true);
                IntroWebSettings.setLoadWithOverviewMode(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/healthyweight.html");
                alertDialogBuilderMoreInfo.setView(alertLayoutMoreInfo);
                final AlertDialog alertDialogMoreInfo = alertDialogBuilderMoreInfo.create();
                alertDialogMoreInfo.show();
            }
        });



        //alert Dialog Declaration for Height
        final LayoutInflater inflaterHeight = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutHeight  = inflaterHeight.inflate(R.layout.dialogheight, null);
        final AlertDialog.Builder alertDialogBuilderHeight = new AlertDialog.Builder(HealthyWeightCalculator.this);
        alertDialogBuilderHeight.setTitle("Height In :");
        radioGroupHeight = (RadioGroup) alertLayoutHeight.findViewById(R.id.radioHeight);
        alertDialogBuilderHeight.setView(alertLayoutHeight);
        final AlertDialog alertDialogHeight = alertDialogBuilderHeight.create();

        //on Alert Radio Button height On click listener
        imageViewHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vgender) {
                alertDialogHeight.show();
                radioGroupHeight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        alertDialogHeight.cancel();
                        radioButtonHeight = (RadioButton) alertLayoutHeight.findViewById(radioGroup.getCheckedRadioButtonId());
                        // Toast.makeText(getApplication(), heightValue, Toast.LENGTH_SHORT).show();
                        if (radioButtonHeight.getText().toString().trim().equals("CM")) {
                            editTextHeight.setVisibility(View.VISIBLE);
                            edittextfeet.setVisibility(View.GONE);
                            edittextInch.setVisibility(View.GONE);
                            imageViewHeight.setImageResource(R.drawable.btn_cm);


                        } else {
                            editTextHeight.setVisibility(View.GONE);
                            edittextfeet.setVisibility(View.VISIBLE);
                            edittextInch.setVisibility(View.VISIBLE);
                            imageViewHeight.setImageResource(R.drawable.btn_ft_in);
                        }

                    }

                });

            }
        });
        //Calculating BMR
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for hiding keyboard
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                HealthyWeight healthyWeightCalculator=new HealthyWeight();
                if(radioGroupHeight.getCheckedRadioButtonId() == -1){
                    if(editTextHeight.getText().toString().trim().equals("")){
                        editTextHeight.setError("Enter Height In CM");
                    }else{
                        String healthyweightInKG=healthyWeightCalculator.HeightInCM(Float.parseFloat(editTextHeight.getText().toString().trim()));
                        textViewHealthyWeight.setText(healthyweightInKG);
                    }
                }else{
                    if(radioButtonHeight.getText().toString().trim().equals("CM")){
                        if(editTextHeight.getText().toString().trim().equals("")){
                            editTextHeight.setError("Enter Height In CM");
                        }else{
                            String healthyweightInKG=healthyWeightCalculator.HeightInCM(Float.parseFloat(editTextHeight.getText().toString().trim()));
                            textViewHealthyWeight.setText(healthyweightInKG);
                        }

                    }
                    else{
                        if(edittextfeet.getText().toString().trim().equals("")){
                            edittextfeet.setError("Enter Height In Feet");
                        }else if(edittextInch.getText().toString().trim().equals("")){
                            edittextInch.setError("Enter Height In Inch or Enter 0");
                        }else{
                            String healthyweightInLBS=healthyWeightCalculator.HeightInFTAndIn(Float.parseFloat(edittextfeet.getText().toString().trim()),Float.parseFloat(edittextInch.getText().toString().trim()));
                            textViewHealthyWeight.setText(healthyweightInLBS);
                        }
                    }

                }
            }
        });
       getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

    }
    public class WebViewClient extends android.webkit.WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
