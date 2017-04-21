package com.nineinfosys.android.weightlosscalculators.ArmyBodyFat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.nineinfosys.android.weightlosscalculators.AnorexicBMI.AnorexicBMICalculator;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;

public class ArmyBodyFatCalculator extends AppCompatActivity {
    //View Declarations
    EditText editTextAge,edittextHeightFeet,edittextHeightInch,edittextWaistFeet,edittextWaistInch,edittextNeckFeet,edittextNeckInch,edittextHipFeet,edittextHipInch;
    Button buttonCalculate,buttonMoreInfo;
    ImageView imageViewGender,imageViewHip;
    TextView textViewArmyBodyFat,textViewArmyBodyFatInterpret,textHip;
    private RadioGroup radioGroupSex;
    private RadioButton radioButtonSex;
    WebView Introwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_army_body_fat);

        MobileAds.initialize(ArmyBodyFatCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewMainPagebodyfat);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);

      //  ((MainActivityDrawer) ArmyBodyFatCalculator.this).toolbar.setTitle("Army Body Fat");
        //Initialising Views
        editTextAge=(EditText)findViewById(R.id.editTextAge);
        edittextHeightFeet=(EditText)findViewById(R.id.edittextHeightFeet);
        edittextHeightInch=(EditText)findViewById(R.id.edittextHeightInch);
        edittextWaistFeet=(EditText)findViewById(R.id.edittextWaistFeet);
        edittextWaistInch=(EditText)findViewById(R.id.edittextWaistInch);
        edittextNeckFeet=(EditText)findViewById(R.id.edittextNeckFeet);
        edittextNeckInch=(EditText)findViewById(R.id.edittextNeckInch);
        textHip = (TextView) findViewById(R.id.textHip);
        edittextHipFeet=(EditText)findViewById(R.id.edittextHipFeet);
        edittextHipInch=(EditText)findViewById(R.id.edittextHipInch);
        imageViewHip = (ImageView) findViewById(R.id.imageViewHip);
        imageViewGender = (ImageView) findViewById(R.id.imageViewGender);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);
        textViewArmyBodyFat = (TextView) findViewById(R.id.textViewArmyBodyFat);
        textViewArmyBodyFatInterpret = (TextView) findViewById(R.id.textViewArmyBodyFatInterpret);

        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert Dialog Declaration For More Infomation
                final LayoutInflater inflaterMoreInfo = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayoutMoreInfo = inflaterMoreInfo.inflate(R.layout.info_webview, null);
                final AlertDialog.Builder alertDialogBuilderMoreInfo = new AlertDialog.Builder(ArmyBodyFatCalculator.this);
                alertDialogBuilderMoreInfo.setTitle("More Info:");
                Introwebview = (WebView) alertLayoutMoreInfo.findViewById(R.id.webViewinfo);
                WebSettings IntroWebSettings = Introwebview.getSettings();
                IntroWebSettings.setBuiltInZoomControls(true);
                IntroWebSettings.setJavaScriptEnabled(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/armybodyfat.html");
                alertDialogBuilderMoreInfo.setView(alertLayoutMoreInfo);
                final AlertDialog alertDialogMoreInfo = alertDialogBuilderMoreInfo.create();
                alertDialogMoreInfo.show();
            }
        });

        //alert Dialog Declaration For Gender
        final LayoutInflater inflaterGender = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutGender = inflaterGender.inflate(R.layout.dialog, null);
        final AlertDialog.Builder alertDialogBuilderGender = new AlertDialog.Builder(ArmyBodyFatCalculator.this);
        alertDialogBuilderGender.setTitle("Gender :");
        radioGroupSex = (RadioGroup) alertLayoutGender.findViewById(R.id.radioSex);
        alertDialogBuilderGender.setView(alertLayoutGender);
        final AlertDialog alertDialogGender = alertDialogBuilderGender.create();

        //on Alert Radio Button Gender On click listener
        imageViewGender.setOnClickListener(

                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogGender.show();
                radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        alertDialogGender.cancel();
                        radioButtonSex = (RadioButton) alertLayoutGender.findViewById(radioGroup.getCheckedRadioButtonId());
                        //For Changing Button Image
                        if (radioButtonSex.getText().toString().trim().equals("Male")) {
                            imageViewGender.setImageResource(R.drawable.gender_m);
                            textHip.setVisibility(View.GONE);
                            edittextHipFeet.setVisibility(View.GONE);
                            edittextHipInch.setVisibility(View.GONE);
                            imageViewHip.setVisibility(View.GONE);
                        }
                        else {
                            imageViewGender.setImageResource(R.drawable.gender_f);
                            textHip.setVisibility(View.VISIBLE);
                            edittextHipFeet.setVisibility(View.VISIBLE);
                            edittextHipInch.setVisibility(View.VISIBLE);
                            imageViewHip.setVisibility(View.VISIBLE);
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
                InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(radioGroupSex.getCheckedRadioButtonId() == -1){
                    //Validation for Edittext  if is blank
                    if (editTextAge.getText().toString().equals("")) {
                        editTextAge.setError("Enter Age");
                    } else if (edittextHeightFeet.getText().toString().equals("")) {
                        edittextHeightFeet.setError("Enter Height in Feet");
                    }  else if (edittextHeightInch.getText().toString().equals("")) {
                        edittextHeightInch.setError("Enter Height in Inch");
                    } else if (edittextWaistFeet.getText().toString().equals("")) {
                        edittextWaistFeet.setError("Enter Waist in Feet");
                    } else if (edittextWaistInch.getText().toString().equals("")) {
                        edittextWaistInch.setError("Enter Waist in Inch");
                    } else if (edittextNeckFeet.getText().toString().equals("")) {
                        edittextNeckFeet.setError("Enter Neck in Feet");
                    }else if (edittextNeckInch.getText().toString().equals("")) {
                        edittextNeckInch.setError("Enter Neck in Inch");
                    } else {
                        calculateArmyBodyFat((Float.parseFloat(edittextWaistFeet.getText().toString().trim())*12)+(Float.parseFloat(edittextWaistInch.getText().toString().trim())), (Float.parseFloat(edittextNeckFeet.getText().toString().trim())*12)+(Float.parseFloat(edittextNeckInch.getText().toString().trim())), (Float.parseFloat(edittextHeightFeet.getText().toString().trim())*12)+(Float.parseFloat(edittextHeightInch.getText().toString().trim())),0, Integer.parseInt(editTextAge.getText().toString().trim()),"Male");
                    }
                }else {
                    if(radioGroupSex.getCheckedRadioButtonId() == -1){
                        Toast.makeText(ArmyBodyFatCalculator.this, "Please Select Gender", Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (radioButtonSex.getText().toString().trim().equals("Male")) {
                            //Validation for Edittext  if is blank
                            if (editTextAge.getText().toString().equals("")) {
                                editTextAge.setError("Enter Age");
                            } else if (edittextHeightFeet.getText().toString().equals("")) {
                                edittextHeightFeet.setError("Enter Height in Feet");
                            } else if (edittextHeightInch.getText().toString().equals("")) {
                                edittextHeightInch.setError("Enter Height in Inch");
                            } else if (edittextWaistFeet.getText().toString().equals("")) {
                                edittextWaistFeet.setError("Enter Waist in Feet");
                            } else if (edittextWaistInch.getText().toString().equals("")) {
                                edittextWaistInch.setError("Enter Waist in Inch");
                            } else if (edittextNeckFeet.getText().toString().equals("")) {
                                edittextNeckFeet.setError("Enter Neck in Feet");
                            } else if (edittextNeckInch.getText().toString().equals("")) {
                                edittextNeckInch.setError("Enter Neck in Inch");
                            } else {
                                calculateArmyBodyFat((Float.parseFloat(edittextWaistFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextWaistInch.getText().toString().trim())), (Float.parseFloat(edittextNeckFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextNeckInch.getText().toString().trim())), (Float.parseFloat(edittextHeightFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextHeightInch.getText().toString().trim())), 0, Integer.parseInt(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                            }

                        }else {
                            //Validation for Edittext  if is blank
                            if (editTextAge.getText().toString().equals("")) {
                                editTextAge.setError("Enter Age");
                            } else if (edittextHeightFeet.getText().toString().equals("")) {
                                edittextHeightFeet.setError("Enter Height in Feet");
                            } else if (edittextHeightInch.getText().toString().equals("")) {
                                edittextHeightInch.setError("Enter Height in Inch");
                            } else if (edittextWaistFeet.getText().toString().equals("")) {
                                edittextWaistFeet.setError("Enter Waist in Feet");
                            } else if (edittextWaistInch.getText().toString().equals("")) {
                                edittextWaistInch.setError("Enter Waist in Inch");
                            } else if (edittextNeckFeet.getText().toString().equals("")) {
                                edittextNeckFeet.setError("Enter Neck in Feet");
                            } else if (edittextNeckInch.getText().toString().equals("")) {
                                edittextNeckInch.setError("Enter Neck in Inch");
                            } else if (edittextHipFeet.getText().toString().equals("")) {
                                edittextHipFeet.setError("Enter Hip Feet");
                            } else if (edittextHipInch.getText().toString().equals("")) {
                                edittextHipInch.setError("Enter Hip Inch");
                            } else {
                                calculateArmyBodyFat((Float.parseFloat(edittextWaistFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextWaistInch.getText().toString().trim())), (Float.parseFloat(edittextNeckFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextNeckInch.getText().toString().trim())), (Float.parseFloat(edittextHeightFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextHeightInch.getText().toString().trim())), (Float.parseFloat(edittextHipFeet.getText().toString().trim()) * 12) + (Float.parseFloat(edittextHipInch.getText().toString().trim())), Integer.parseInt(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                            }
                        }
                    }

                }
            }
        });
       getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

    }


    public  void calculateArmyBodyFat(float waist, float neck, float height, float hip, int age, String gender){
        ArmyBodyFat armyBodyFat = new ArmyBodyFat(waist, neck, height, hip, age, gender);
        DecimalFormat f = new DecimalFormat("##.00");
        float resultArmyBodyFat = armyBodyFat.calculateAmryBodyFatResult();
        if(resultArmyBodyFat < 0){
            textViewArmyBodyFat.setText("Please Enter Correct Values");
            textViewArmyBodyFatInterpret.setText("-");
        }else if(resultArmyBodyFat > 100){
            textViewArmyBodyFat.setText("Please Enter Correct Values");
            textViewArmyBodyFatInterpret.setText("-");
        }else {
            textViewArmyBodyFat.setText(f.format(resultArmyBodyFat) + " %");
            String resultinterpretArmyBodyFat = armyBodyFat.interpretArmyBodyFat();
            textViewArmyBodyFatInterpret.setText(resultinterpretArmyBodyFat);
        }

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
            Intent intent=new Intent(ArmyBodyFatCalculator.this,MainActivityDrawer.class);
            finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}