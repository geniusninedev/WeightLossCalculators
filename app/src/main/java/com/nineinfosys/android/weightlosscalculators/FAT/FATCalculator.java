package com.nineinfosys.android.weightlosscalculators.FAT;

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
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.weightlosscalculators.IdealWeight.IdealWeightCalculator;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;

public class FATCalculator extends AppCompatActivity {
    //View Declarations
     EditText editTextAge,editTextBMI;
     Button buttonCalculate,buttonMoreInfo;
     ImageView imageViewGender;
     TextView textViewFAT,textViewFATInterpret;
     private RadioGroup radioGroupSex;
    private RadioButton radioButtonSex;
    WebView Introwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fat);

        MobileAds.initialize(FATCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewMainPagefat);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
       // ((MainActivityDrawer) FATCalculator).toolbar.setTitle("FAT");
        //Initialising Views
        editTextAge=(EditText)findViewById(R.id.editTextAge);
        editTextBMI=(EditText)findViewById(R.id.editTextBMI);
        imageViewGender = (ImageView) findViewById(R.id.imageViewGender);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);
        textViewFAT = (TextView) findViewById(R.id.textViewFAT);
        textViewFATInterpret = (TextView) findViewById(R.id.textViewFATInterpret);
        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert Dialog Declaration For More Infomation
                final LayoutInflater inflaterMoreInfo = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayoutMoreInfo = inflaterMoreInfo.inflate(R.layout.info_webview, null);
                final AlertDialog.Builder alertDialogBuilderMoreInfo = new AlertDialog.Builder(FATCalculator.this);
                alertDialogBuilderMoreInfo.setTitle("More Info:");
                Introwebview = (WebView) alertLayoutMoreInfo.findViewById(R.id.webViewinfo);
                WebSettings IntroWebSettings = Introwebview.getSettings();
                IntroWebSettings.setBuiltInZoomControls(true);
                IntroWebSettings.setJavaScriptEnabled(true);
                IntroWebSettings.setUseWideViewPort(true);
                IntroWebSettings.setLoadWithOverviewMode(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/fat.html");
                alertDialogBuilderMoreInfo.setView(alertLayoutMoreInfo);
                final AlertDialog alertDialogMoreInfo = alertDialogBuilderMoreInfo.create();
                alertDialogMoreInfo.show();
            }
        });
        //alert Dialog Declaration For Gender
        final LayoutInflater inflaterGender = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutGender = inflaterGender.inflate(R.layout.dialog, null);
        final AlertDialog.Builder alertDialogBuilderGender = new AlertDialog.Builder(FATCalculator.this);
        alertDialogBuilderGender.setTitle("Gender :");
        radioGroupSex = (RadioGroup) alertLayoutGender.findViewById(R.id.radioSex);
        alertDialogBuilderGender.setView(alertLayoutGender);
        final AlertDialog alertDialogGender = alertDialogBuilderGender.create();

        //on Alert Radio Button Gender On click listener
        imageViewGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogGender.show();
                radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        alertDialogGender.cancel();
                        radioButtonSex = (RadioButton) alertLayoutGender.findViewById(radioGroup.getCheckedRadioButtonId());
                        //For Changing Button Image
                        if (radioButtonSex.getText().toString().trim().equals("Male") || radioButtonSex.getText().toString().trim().equals("")) {
                            imageViewGender.setImageResource(R.drawable.gender_m);
                        } else {
                            imageViewGender.setImageResource(R.drawable.gender_f);
                        }
                    }

                });


            }
        });

        //Calculating BMI and FAT
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for hiding keyboard
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                    if (editTextAge.getText().toString().equals("")) {
                        editTextAge.setError("Enter Age");
                    } else if (editTextBMI.getText().toString().equals("")) {
                        editTextBMI.setError("Enter BMI");
                    } else {
                        calculateFAT(Float.parseFloat(editTextAge.getText().toString().trim()),Float.parseFloat(editTextBMI.getText().toString().trim()),"Male");

                    }
                } else {
                    if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(FATCalculator.this, "Please Select Gender", Toast.LENGTH_LONG).show();
                    } else {
                        //Validation for Edittext  if is blank
                        if (editTextAge.getText().toString().equals("")) {
                            editTextAge.setError("Enter Age");
                        } else if (editTextBMI.getText().toString().equals("")) {
                            editTextBMI.setError("Enter BMI");
                        } else {
                            calculateFAT(Float.parseFloat(editTextAge.getText().toString().trim()),Float.parseFloat(editTextBMI.getText().toString().trim()),radioButtonSex.getText().toString().trim());
                        }
                    }
                }
            }
        });
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

    }
public void calculateFAT(float age,float bmi,String gender){
    CalculateFAT calculateFAT = new CalculateFAT( age,bmi,gender);
    float resultFAT = calculateFAT.calculateFATResult();
    DecimalFormat f = new DecimalFormat("##.00");
    textViewFAT.setText(f.format(resultFAT));
    String interpretFATResult = calculateFAT.interpretFAT();
    textViewFATInterpret.setText(interpretFATResult);
    int resultFATColor=calculateFAT.interpretFATCOLOR();
    textViewFATInterpret.setTextColor(resultFATColor);
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