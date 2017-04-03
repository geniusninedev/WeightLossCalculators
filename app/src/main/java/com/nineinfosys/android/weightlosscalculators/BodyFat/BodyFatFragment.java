package com.nineinfosys.android.weightlosscalculators.BodyFat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
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
import com.nineinfosys.android.weightlosscalculators.AnorexicBMI.AnorexicBMIFragment;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;

public class BodyFatFragment extends Fragment {
    //View Declarations
    EditText editTextAge,editTextHeight,editTextWaist,editTextNeck,editTextHip,edittextHeightFeet,edittextHeightInch,edittextWaistFeet,edittextWaistInch,edittextNeckFeet,edittextNeckInch,edittextHipFeet,edittextHipInch;
    Button buttonCalculate,buttonMoreInfo;
    ImageView imageViewUnit,imageViewGender,imageViewHeight,imageViewWaist,imageViewNeck,imageViewHip;
    TextView textViewBodyFAT,textHip;
    private RadioGroup radioGroupSex,radioGroupUnit;
    private RadioButton radioButtonSex,radioButtonUnit;
    WebView Introwebview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_body_fat, null);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView) v.findViewById(R.id.adViewMainPagebody);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Body Fat");

        //Initialising Views
        editTextAge=(EditText)v.findViewById(R.id.editTextAge);
        editTextHeight=(EditText)v.findViewById(R.id.editTextHeight);
        editTextWaist=(EditText)v.findViewById(R.id.editTextWaist);
        editTextNeck=(EditText)v.findViewById(R.id.editTextNeck);
        editTextHip=(EditText)v.findViewById(R.id.editTextHip);
        edittextHeightFeet=(EditText)v.findViewById(R.id.edittextHeightFeet);
        edittextHeightInch=(EditText)v.findViewById(R.id.edittextHeightInch);
        edittextWaistFeet=(EditText)v.findViewById(R.id.edittextWaistFeet);
        edittextWaistInch=(EditText)v.findViewById(R.id.edittextWaistInch);
        edittextNeckFeet=(EditText)v.findViewById(R.id.edittextNeckFeet);
        edittextNeckInch=(EditText)v.findViewById(R.id.edittextNeckInch);
        textHip = (TextView) v.findViewById(R.id.textHip);
        edittextHipFeet=(EditText)v.findViewById(R.id.edittextHipFeet);
        edittextHipInch=(EditText)v.findViewById(R.id.edittextHipInch);
        
        
        imageViewUnit = (ImageView) v.findViewById(R.id.imageViewUnit);
        imageViewGender = (ImageView) v.findViewById(R.id.imageViewGender);
        imageViewHeight = (ImageView) v.findViewById(R.id.imageViewHeight);
        imageViewWaist = (ImageView) v.findViewById(R.id.imageViewWaist);
        imageViewNeck = (ImageView) v.findViewById(R.id.imageViewNeck);
        imageViewHip = (ImageView) v.findViewById(R.id.imageViewHip);
       
        buttonCalculate = (Button) v.findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) v.findViewById(R.id.buttonMoreInfo);
        textViewBodyFAT = (TextView) v.findViewById(R.id.textViewBodyFAT);

        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert Dialog Declaration For More Infomation
                final LayoutInflater inflaterMoreInfo = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayoutMoreInfo = inflaterMoreInfo.inflate(R.layout.info_webview, null);
                final AlertDialog.Builder alertDialogBuilderMoreInfo = new AlertDialog.Builder(getActivity());
                alertDialogBuilderMoreInfo.setTitle("More Info:");
                Introwebview = (WebView) alertLayoutMoreInfo.findViewById(R.id.webViewinfo);
                WebSettings IntroWebSettings = Introwebview.getSettings();
                IntroWebSettings.setBuiltInZoomControls(true);
                IntroWebSettings.setJavaScriptEnabled(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/bodyfat_three.html");
                alertDialogBuilderMoreInfo.setView(alertLayoutMoreInfo);
                final AlertDialog alertDialogMoreInfo = alertDialogBuilderMoreInfo.create();
                alertDialogMoreInfo.show();
            }
        });

        //alert Dialog Declaration For Gender
        final LayoutInflater inflaterGender = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutGender = inflaterGender.inflate(R.layout.dialog, null);
        final AlertDialog.Builder alertDialogBuilderGender = new AlertDialog.Builder(getActivity());
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
                        if (radioGroupUnit.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getActivity(), "Please Select Unit", Toast.LENGTH_LONG).show();
                        } else {
                            switch (radioButtonUnit.getText().toString().trim()){
                                case "CM":
                                    if (radioButtonSex.getText().toString().trim().equals("Male")) {
                                        visibilityforCMmale();
                                    } else {
                                        visibilityforCMfemale();
                                    }
                                    break;
                                case "FT+IN":
                                    if (radioButtonSex.getText().toString().trim().equals("Male")) {
                                       visibilityforFTandINmale();
                                    } else {
                                       visibilityforFTandInfemale();
                                    }
                                    break;
                                case "":
                                    if (radioButtonSex.getText().toString().trim().equals("Male")) {
                                       visibilityforCMmale();
                                    } else {
                                       visibilityforCMmale();
                                    }
                                    break;
                            }

                        }
                    }

                });


            }
        });

        //alert Dialog Declaration for Height
        final LayoutInflater inflaterUnit = (LayoutInflater)getActivity(). getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutUnit  = inflaterUnit.inflate(R.layout.dialogheight, null);
        final AlertDialog.Builder alertDialogBuilderUnit = new AlertDialog.Builder(getActivity());
        alertDialogBuilderUnit.setTitle("Unit In :");
        radioGroupUnit = (RadioGroup) alertLayoutUnit.findViewById(R.id.radioHeight);
        alertDialogBuilderUnit.setView(alertLayoutUnit);
        final AlertDialog alertDialogUnit = alertDialogBuilderUnit.create();


        //on Alert Radio Button height On click listener
        imageViewUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vgender) {
                alertDialogUnit.show();
                radioGroupUnit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        alertDialogUnit.cancel();
                        radioButtonUnit = (RadioButton) alertLayoutUnit.findViewById(radioGroup.getCheckedRadioButtonId());
                        // Toast.makeText(getApplication(), heightValue, Toast.LENGTH_SHORT).show();
                        if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_LONG).show();
                        } else {
                            switch (radioButtonSex.getText().toString().trim()) {
                                case "Male":
                                    if (radioButtonUnit.getText().toString().trim().equals("CM")) {
                                       visibilityforCMmale();
                                    } else {
                                        visibilityforFTandINmale();
                                    }
                                    break;
                                case "Female":
                                    if (radioButtonUnit.getText().toString().trim().equals("CM")) {
                                        visibilityforCMfemale();
                                    } else {
                                       visibilityforFTandInfemale();
                                    }
                                    break;
                                case "":
                                    if (radioButtonUnit.getText().toString().trim().equals("CM")) {
                                       visibilityforCMmale();
                                    } else {
                                        visibilityforFTandINmale();
                                    }
                                    break;

                            }
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
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                    //Validation for Edittext  if is blank
                    if (editTextAge.getText().toString().equals("")) {
                        editTextHeight.setError("Enter Age");
                    } else if (editTextHeight.getText().toString().equals("")) {
                        editTextHeight.setError("Enter Height");
                    } else if (editTextWaist.getText().toString().equals("")) {
                        editTextWaist.setError("Enter Waist");
                    } else if (editTextNeck.getText().toString().equals("")) {
                        editTextNeck.setError("Enter Neck");
                    } else {
                        calculateBodyFat(Float.parseFloat(editTextWaist.getText().toString().trim()), Float.parseFloat(editTextNeck.getText().toString().trim()), Float.parseFloat(editTextHeight.getText().toString().trim()), 0, Integer.parseInt(editTextAge.getText().toString().trim()), "Male");
                    }

                } else {
                    if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_LONG).show();
                    }else if (radioGroupUnit.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getActivity(), "Please Select Unit", Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (radioButtonSex.getText().toString().trim().equals("Male")) {
                            switch (radioButtonUnit.getText().toString().trim()){
                                case "CM":
                                    if (editTextAge.getText().toString().equals("")) {
                                        editTextHeight.setError("Enter Age");
                                    } else if (editTextHeight.getText().toString().equals("")) {
                                        editTextHeight.setError("Enter Height");
                                    } else if (editTextWaist.getText().toString().equals("")) {
                                        editTextWaist.setError("Enter Waist");
                                    } else if (editTextNeck.getText().toString().equals("")) {
                                        editTextNeck.setError("Enter Neck");
                                    } else {
                                        calculateBodyFat(Float.parseFloat(editTextWaist.getText().toString().trim()), Float.parseFloat(editTextNeck.getText().toString().trim()), Float.parseFloat(editTextHeight.getText().toString().trim()),0, Integer.parseInt(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                                    }
                                    break;
                                case "FT+IN":
                                    if (editTextAge.getText().toString().equals("")) {
                                        editTextHeight.setError("Enter Age");
                                    } else if (edittextHeightFeet.getText().toString().equals("")) {
                                        edittextHeightFeet.setError("Enter Height in Feet");
                                    } else if (edittextHeightInch.getText().toString().equals("")) {
                                        edittextHeightInch.setError("Enter Height in Inch");
                                    } else if (edittextWaistFeet.getText().toString().equals("")) {
                                        edittextWaistFeet.setError("Enter Waist in Feet");
                                    }else if (edittextWaistInch.getText().toString().equals("")) {
                                        edittextWaistInch.setError("Enter Waist in Inch");
                                    } else if (edittextNeckFeet.getText().toString().equals("")) {
                                        edittextNeckFeet.setError("Enter Neck in Feet");
                                    } else if (edittextNeckInch.getText().toString().equals("")) {
                                        edittextNeckInch.setError("Enter Neck in Inch");
                                    }else {
                                        calculateBodyFat((float)(((Float.parseFloat(edittextWaistFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextWaistInch.getText().toString().trim()))*(2.54)), (float)(((Float.parseFloat(edittextNeckFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextNeckInch.getText().toString().trim()))*(2.54)), (float)(((Float.parseFloat(edittextHeightFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextHeightInch.getText().toString().trim()))*(2.54)), 0, Integer.parseInt(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                                    }
                                    break;


                            }

                        } else {
                            switch (radioButtonUnit.getText().toString().trim()) {
                                case "CM":
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextHeight.setError("Enter Age");
                                } else if (editTextHeight.getText().toString().equals("")) {
                                    editTextHeight.setError("Enter Height");
                                } else if (editTextWaist.getText().toString().equals("")) {
                                    editTextWaist.setError("Enter Waist");
                                } else if (editTextNeck.getText().toString().equals("")) {
                                    editTextNeck.setError("Enter Neck");
                                } else if (editTextHip.getText().toString().equals("")) {
                                    editTextHip.setError("Enter Hip");
                                } else {
                                    calculateBodyFat(Float.parseFloat(editTextWaist.getText().toString().trim()), Float.parseFloat(editTextNeck.getText().toString().trim()), Float.parseFloat(editTextHeight.getText().toString().trim()), Float.parseFloat(editTextHip.getText().toString().trim()), Integer.parseInt(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                                }
                                    break;
                                case "FT+IN":
                                    if (editTextAge.getText().toString().equals("")) {
                                        editTextHeight.setError("Enter Age");
                                    } else if (edittextHeightFeet.getText().toString().equals("")) {
                                        edittextHeightFeet.setError("Enter Height in Feet");
                                    } else if (edittextHeightInch.getText().toString().equals("")) {
                                        edittextHeightInch.setError("Enter Height in Inch");
                                    } else if (edittextWaistFeet.getText().toString().equals("")) {
                                        edittextWaistFeet.setError("Enter Waist in Feet");
                                    }else if (edittextWaistInch.getText().toString().equals("")) {
                                        edittextWaistInch.setError("Enter Waist in Inch");
                                    } else if (edittextNeckFeet.getText().toString().equals("")) {
                                        edittextNeckFeet.setError("Enter Neck in Feet");
                                    } else if (edittextNeckInch.getText().toString().equals("")) {
                                        edittextNeckInch.setError("Enter Neck in Inch");
                                    }else if (edittextHipFeet.getText().toString().equals("")) {
                                        edittextHipFeet.setError("Enter Hip in Feet");
                                    } else if (edittextHipInch.getText().toString().equals("")) {
                                        edittextHipInch.setError("Enter Hip in Inch");
                                    }
                                    else {
                                        calculateBodyFat((float)(((Float.parseFloat(edittextWaistFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextWaistInch.getText().toString().trim()))*(2.54)), (float)(((Float.parseFloat(edittextNeckFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextNeckInch.getText().toString().trim()))*(2.54)), (float)(((Float.parseFloat(edittextHeightFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextHeightInch.getText().toString().trim()))*(2.54)), (float)(((Float.parseFloat(edittextHipFeet.getText().toString().trim()))*(30.48)) + (Float.parseFloat(edittextHipInch.getText().toString().trim()))*(2.54)), Integer.parseInt(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        });
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        return v;
    }

    public  void calculateBodyFat(float waist, float neck, float height, float hip, int age, String gender){
        BodyFat bodyFat = new BodyFat(waist, neck, height, hip, age, gender);
        DecimalFormat f = new DecimalFormat("##.00");
        float resultArmyBodyFat = bodyFat.calculateAmryBodyFatResult();
        if(resultArmyBodyFat < 0){
            textViewBodyFAT.setText("Please Enter Correct Values");
        }else if(resultArmyBodyFat > 100){
            textViewBodyFAT.setText("Please Enter Correct Values");
        }else {
            textViewBodyFAT.setText(f.format(resultArmyBodyFat) + " %");
        }
    }
    public void visibilityforCMmale(){
        imageViewGender.setImageResource(R.drawable.gender_m);
        imageViewUnit.setImageResource(R.drawable.btn_cm);
        imageViewHeight.setImageResource(R.drawable.btn_cm);
        imageViewWaist.setImageResource(R.drawable.btn_cm);
        imageViewNeck.setImageResource(R.drawable.btn_cm);
        editTextHeight.setVisibility(View.VISIBLE);
        edittextHeightFeet.setVisibility(View.GONE);
        edittextHeightInch.setVisibility(View.GONE);
        editTextWaist.setVisibility(View.VISIBLE);
        edittextWaistFeet.setVisibility(View.GONE);
        edittextWaistInch.setVisibility(View.GONE);
        editTextNeck.setVisibility(View.VISIBLE);
        edittextNeckFeet.setVisibility(View.GONE);
        edittextNeckInch.setVisibility(View.GONE);
        textHip.setVisibility(View.GONE);
        editTextHip.setVisibility(View.GONE);
        edittextHipFeet.setVisibility(View.GONE);
        edittextHipInch.setVisibility(View.GONE);
        imageViewHip.setVisibility(View.GONE);
    }
    public void visibilityforFTandINmale(){
        imageViewGender.setImageResource(R.drawable.gender_m);
        imageViewUnit.setImageResource(R.drawable.btn_ft_in);
        imageViewHeight.setImageResource(R.drawable.btn_ft_in);
        imageViewWaist.setImageResource(R.drawable.btn_ft_in);
        imageViewNeck.setImageResource(R.drawable.btn_ft_in);
        editTextHeight.setVisibility(View.GONE);
        edittextHeightFeet.setVisibility(View.VISIBLE);
        edittextHeightInch.setVisibility(View.VISIBLE);
        editTextWaist.setVisibility(View.GONE);
        edittextWaistFeet.setVisibility(View.VISIBLE);
        edittextWaistInch.setVisibility(View.VISIBLE);
        editTextNeck.setVisibility(View.GONE);
        edittextNeckFeet.setVisibility(View.VISIBLE);
        edittextNeckInch.setVisibility(View.VISIBLE);
        textHip.setVisibility(View.GONE);
        editTextHip.setVisibility(View.GONE);
        edittextHipFeet.setVisibility(View.GONE);
        edittextHipInch.setVisibility(View.GONE);
        imageViewHip.setVisibility(View.GONE);
    }
    public void visibilityforCMfemale(){
        imageViewGender.setImageResource(R.drawable.gender_f);
        imageViewUnit.setImageResource(R.drawable.btn_cm);
        imageViewHeight.setImageResource(R.drawable.btn_cm);
        imageViewWaist.setImageResource(R.drawable.btn_cm);
        imageViewNeck.setImageResource(R.drawable.btn_cm);
        imageViewHip.setVisibility(View.VISIBLE);
        imageViewHip.setImageResource(R.drawable.btn_cm);
        editTextHeight.setVisibility(View.VISIBLE);
        edittextHeightFeet.setVisibility(View.GONE);
        edittextHeightInch.setVisibility(View.GONE);
        editTextWaist.setVisibility(View.VISIBLE);
        edittextWaistFeet.setVisibility(View.GONE);
        edittextWaistInch.setVisibility(View.GONE);
        editTextNeck.setVisibility(View.VISIBLE);
        edittextNeckFeet.setVisibility(View.GONE);
        edittextNeckInch.setVisibility(View.GONE);
        textHip.setVisibility(View.VISIBLE);
        editTextHip.setVisibility(View.VISIBLE);
        edittextHipFeet.setVisibility(View.GONE);
        edittextHipInch.setVisibility(View.GONE);
    }
    public void visibilityforFTandInfemale(){
        imageViewGender.setImageResource(R.drawable.gender_f);
        imageViewUnit.setImageResource(R.drawable.btn_ft_in);
        imageViewHeight.setImageResource(R.drawable.btn_ft_in);
        imageViewWaist.setImageResource(R.drawable.btn_ft_in);
        imageViewNeck.setImageResource(R.drawable.btn_ft_in);
        imageViewHip.setVisibility(View.VISIBLE);
        imageViewHip.setImageResource(R.drawable.btn_ft_in);
        editTextHeight.setVisibility(View.GONE);
        edittextHeightFeet.setVisibility(View.VISIBLE);
        edittextHeightInch.setVisibility(View.VISIBLE);
        editTextWaist.setVisibility(View.GONE);
        edittextWaistFeet.setVisibility(View.VISIBLE);
        edittextWaistInch.setVisibility(View.VISIBLE);
        editTextNeck.setVisibility(View.GONE);
        edittextNeckFeet.setVisibility(View.VISIBLE);
        edittextNeckInch.setVisibility(View.VISIBLE);
        textHip.setVisibility(View.VISIBLE);
        editTextHip.setVisibility(View.GONE);
        edittextHipFeet.setVisibility(View.VISIBLE);
        edittextHipInch.setVisibility(View.VISIBLE);
    }
    public class WebViewClient extends android.webkit.WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}