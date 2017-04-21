package com.nineinfosys.android.weightlosscalculators.IdealWeight;

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
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;

public class IdealWeightCalculator extends AppCompatActivity {
    //View Declarations
    EditText  editTextHeight,edittextfeet,edittextInch;
    Button buttonCalculate,buttonMoreInfo;
    ImageView imageViewGender,imageViewHeight;
    TextView textViewIdealWeight;
    private RadioGroup radioGroupSex,radioGroupHeight;
    private RadioButton radioButtonSex,radioButtonHeight;
    WebView Introwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ideal_weight);

        MobileAds.initialize(IdealWeightCalculator.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewMainPageidealWeight);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

      //  ((MainActivityDrawer) IdealWeightCalculator.this).toolbar.setTitle("Ideal Weight");

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        //Initialising Views
        editTextHeight=(EditText)findViewById(R.id.editTextHeight);
        edittextfeet = (EditText) findViewById(R.id.edittextFeet);
        edittextInch = (EditText) findViewById(R.id.edittextInch);
        imageViewGender = (ImageView) findViewById(R.id.imageViewGender);
        imageViewHeight = (ImageView) findViewById(R.id.imageViewHeight);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) findViewById(R.id.buttonMoreInfo);
        textViewIdealWeight = (TextView) findViewById(R.id.textViewIdealWeight);


        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert Dialog Declaration For More Infomation
                final LayoutInflater inflaterMoreInfo = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayoutMoreInfo = inflaterMoreInfo.inflate(R.layout.info_webview, null);
                final AlertDialog.Builder alertDialogBuilderMoreInfo = new AlertDialog.Builder(IdealWeightCalculator.this);
                alertDialogBuilderMoreInfo.setTitle("More Info:");
                Introwebview = (WebView) alertLayoutMoreInfo.findViewById(R.id.webViewinfo);
                WebSettings IntroWebSettings = Introwebview.getSettings();
                IntroWebSettings.setBuiltInZoomControls(true);
                IntroWebSettings.setJavaScriptEnabled(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/idealweight.html");
                alertDialogBuilderMoreInfo.setView(alertLayoutMoreInfo);
                final AlertDialog alertDialogMoreInfo = alertDialogBuilderMoreInfo.create();
                alertDialogMoreInfo.show();
            }
        });


        //alert Dialog Declaration For Gender
        final LayoutInflater inflaterGender = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutGender = inflaterGender.inflate(R.layout.dialog, null);
        final AlertDialog.Builder alertDialogBuilderGender = new AlertDialog.Builder(IdealWeightCalculator.this);
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
//alert Dialog Declaration for Height
        final LayoutInflater inflaterHeight = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutHeight  = inflaterHeight.inflate(R.layout.dialogheight, null);
        final AlertDialog.Builder alertDialogBuilderHeight = new AlertDialog.Builder(IdealWeightCalculator.this);
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
        //Calculating BMI and FAT
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for hiding keyboard
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                //Default case Calculation
                if (radioGroupSex.getCheckedRadioButtonId() == -1 && radioGroupHeight.getCheckedRadioButtonId() == -1) {
                    //Validation for Edittext  if is blank
                    if(editTextHeight.getText().toString().equals("")) {
                        editTextHeight.setError("Enter Height");
                    }else{
                        int hightincm = Integer.parseInt(editTextHeight.getText().toString().trim());
                         if (hightincm < 100) {
                            textViewIdealWeight.setText("Standards Not Available For Your Height");
                        } else {
                            calculateIdealWeigh(Integer.parseInt(editTextHeight.getText().toString().trim()), "Male");
                        }
                    }
                } else {
                    if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(IdealWeightCalculator.this, "Please Select Gender", Toast.LENGTH_LONG).show();
                    }else if(radioGroupHeight.getCheckedRadioButtonId() == -1 ) {
                        Toast.makeText(IdealWeightCalculator.this, "Please Select Height Unit", Toast.LENGTH_LONG).show();
                    } else {
                        if(radioButtonHeight.getText().toString().trim().equals("CM")) {
                            //Validation for Edittext  if is blank
                            if(editTextHeight.getText().toString().equals("")) {
                                editTextHeight.setError("Enter Height");
                            }else {
                                int hightincm = Integer.parseInt(editTextHeight.getText().toString().trim());
                                if (hightincm < 100) {
                                    textViewIdealWeight.setText("Standards Not Available For Your Height");
                                } else {
                                    calculateIdealWeigh(Integer.parseInt(editTextHeight.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                                }
                            }
                        }else{


                            //Validation for Edittext  if is blank
                             if(edittextfeet.getText().toString().equals("")){
                                edittextfeet.setError("Enter Feet");
                            }else if(edittextInch.getText().toString().equals("")){
                                edittextInch.setError("Enter Inch");
                            } else {
                                 int hightinfeet= (int) (((Float.parseFloat(edittextfeet.getText().toString().trim()))*(30.48))+((Float.parseFloat(edittextInch.getText().toString().trim()))*(2.54)));
                                 if (hightinfeet < 100) {
                                     textViewIdealWeight.setText("Standards Not Available For Your Height");
                                 } else {
                                     calculateIdealWeigh((int) (((Float.parseFloat(edittextfeet.getText().toString().trim())) * (30.48)) + ((Float.parseFloat(edittextInch.getText().toString().trim())) * (2.54))), radioButtonSex.getText().toString().trim());
                                 }
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

    public  void calculateIdealWeigh(int height,String gender){
        CalculateIdealWeight calculateIdealWeight = new CalculateIdealWeight(height,gender);
        float resultIdealWeight= calculateIdealWeight.calculateIdealWeightResult() ;
        DecimalFormat f = new DecimalFormat("##.00");
        textViewIdealWeight.setText(f.format(resultIdealWeight)+" KG");

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
            Intent intent=new Intent(IdealWeightCalculator.this,MainActivityDrawer.class);
            finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}