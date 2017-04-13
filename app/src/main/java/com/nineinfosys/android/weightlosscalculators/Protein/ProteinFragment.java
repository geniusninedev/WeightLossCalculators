package com.nineinfosys.android.weightlosscalculators.Protein;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.weightlosscalculators.Calorie.CalculateBMR;
import com.nineinfosys.android.weightlosscalculators.LeanBodyMass.LeanBodyMassFragment;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProteinFragment extends Fragment {


    //View Declarations
    EditText editTextAge, editTextHeight, editTextWeight,edittextfeet,edittextInch,edittextWeightInLb,edittextWeightInST,edittextWeightInSTLb;
    Button buttonCalculate,buttonMoreInfo;
    ImageView imageViewGender,imageViewHeight,imageViewWeight;
    private RadioGroup radioGroupSex,radioGroupHeight,radioGroupWeight;
    private RadioButton radioButtonSex,radioButtonHeight,radioButtonWeight;
    TextView textViewADA,textViewCDC;
    Spinner spinneractivity;
    WebView Introwebview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_protein, null);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView) v.findViewById(R.id.adViewMainPageCalorie);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Protein");
        //Initialising Views
        editTextAge = (EditText) v.findViewById(R.id.editTextAge);
        editTextHeight = (EditText) v.findViewById(R.id.editTextHeight);
        edittextfeet = (EditText) v.findViewById(R.id.edittextFeet);
        edittextInch = (EditText) v.findViewById(R.id.edittextInch);
        editTextWeight = (EditText)v.findViewById(R.id.editTextWeight);
        edittextWeightInLb = (EditText) v.findViewById(R.id.edittextWeightInLb);
        edittextWeightInST = (EditText)v.findViewById(R.id.edittextWeightInST);
        edittextWeightInSTLb = (EditText) v.findViewById(R.id.edittextWeightInSTLb);
        imageViewGender = (ImageView) v.findViewById(R.id.imageViewGender);
        imageViewHeight = (ImageView) v.findViewById(R.id.imageViewHeight);
        imageViewWeight = (ImageView) v.findViewById(R.id.imageViewWeight);
        buttonCalculate = (Button) v.findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) v.findViewById(R.id.buttonMoreInfo);
        spinneractivity=(Spinner)v.findViewById(R.id.spinneractivity);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Sedentary-little or no exercise");
        categories.add("Lightly Active-exercise/sports 1-3 times/week");
        categories.add("Moderatetely Active-exercise/sports 3-5 times/week");
        categories.add("Very Active-hard exercise/sports 6-7 times/week");
        categories.add("Extra Active- very hard exercise/sports or physical  job");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinneractivity.setAdapter(dataAdapter);
        textViewADA = (TextView) v.findViewById(R.id.textViewADA);
        textViewCDC = (TextView) v.findViewById(R.id.textViewCDC);



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
                IntroWebSettings.setUseWideViewPort(true);
                IntroWebSettings.setLoadWithOverviewMode(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/protein.html");
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
                        if (radioButtonSex.getText().toString().trim().equals("Male")) {
                            imageViewGender.setImageResource(R.drawable.gender_m);
                        } else {
                            imageViewGender.setImageResource(R.drawable.gender_f);
                        }
                    }

                });


            }
        });

        //alert Dialog Declaration for Height
        final LayoutInflater inflaterHeight = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutHeight  = inflaterHeight.inflate(R.layout.dialogheight, null);
        final AlertDialog.Builder alertDialogBuilderHeight = new AlertDialog.Builder(getActivity());
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

        //alert Dialog Declaration for Weight
        final LayoutInflater inflaterWeight = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutWeight  = inflaterWeight.inflate(R.layout.dialogweight, null);
        final AlertDialog.Builder alertDialogBuilderWeight = new AlertDialog.Builder(getActivity());
        alertDialogBuilderWeight.setTitle("Weight In :");
        radioGroupWeight = (RadioGroup) alertLayoutWeight.findViewById(R.id.radioWeight);
        alertDialogBuilderWeight.setView(alertLayoutWeight);
        final AlertDialog alertDialogWeight = alertDialogBuilderWeight.create();

        //on Alert Radio Button weight On click listener
        imageViewWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogWeight.show();
                radioGroupWeight.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        alertDialogWeight.cancel();
                        radioButtonWeight = (RadioButton) alertLayoutWeight.findViewById(radioGroup.getCheckedRadioButtonId());
                        // Toast.makeText(getApplication(), WeightValue, Toast.LENGTH_SHORT).show();
                        if (radioButtonWeight.getText().toString().trim() .equals("KG")) {
                            editTextWeight.setVisibility(View.VISIBLE);
                            edittextWeightInLb.setVisibility(View.GONE);
                            edittextWeightInST.setVisibility(View.GONE);
                            edittextWeightInSTLb.setVisibility(View.GONE);
                            imageViewWeight.setImageResource(R.drawable.btn_kg);


                        } else if(radioButtonWeight.getText().toString().trim() .equals("LB")){
                            editTextWeight.setVisibility(View.GONE);
                            edittextWeightInLb.setVisibility(View.VISIBLE);
                            edittextWeightInST.setVisibility(View.GONE);
                            edittextWeightInSTLb.setVisibility(View.GONE);
                            imageViewWeight.setImageResource(R.drawable.btn_lb);
                        }else{
                            editTextWeight.setVisibility(View.GONE);
                            edittextWeightInLb.setVisibility(View.GONE);
                            edittextWeightInST.setVisibility(View.VISIBLE);
                            edittextWeightInSTLb.setVisibility(View.VISIBLE);
                            imageViewWeight.setImageResource(R.drawable.btn_st_lb);
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
                //Default case Calculation
                if (radioGroupSex.getCheckedRadioButtonId() == -1&& radioGroupHeight.getCheckedRadioButtonId() == -1 && radioGroupWeight.getCheckedRadioButtonId() == -1) {
                    //Validation for Edittext  if is blank
                    if (editTextAge.getText().toString().equals("")) {
                        editTextAge.setError("Enter Age");
                    } else if (editTextHeight.getText().toString().equals("")) {
                        editTextHeight.setError("Enter Height");
                    } else if (editTextWeight.getText().toString().equals("")) {
                        editTextWeight.setError("Enter Weight");
                    } else {
                        calculateCalorie(Float.parseFloat(editTextHeight.getText().toString().trim()), Float.parseFloat(editTextWeight.getText().toString().trim()), Float.parseFloat(editTextAge.getText().toString().trim()),"Male",spinneractivity.getSelectedItem().toString().trim());
                    }
                } else {
                    //Validation for radiobutton if not checked
                    if (radioGroupSex.getCheckedRadioButtonId() == -1 ){
                        Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_LONG).show();
                    } else if(radioGroupHeight.getCheckedRadioButtonId() == -1 ) {
                        Toast.makeText(getActivity(), "Please Select Height Unit", Toast.LENGTH_LONG).show();
                    }else if(radioGroupWeight.getCheckedRadioButtonId() == -1 ){
                        Toast.makeText(getActivity(), "Please Select Weight Unit", Toast.LENGTH_LONG).show();
                    }
                    else {
                        if(radioButtonHeight.getText().toString().trim().equals("CM")) {
                            if(radioButtonWeight.getText().toString().trim().equals("KG")) {
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextAge.setError("Enter Age");
                                } else if (editTextHeight.getText().toString().equals("")) {
                                    editTextHeight.setError("Enter Height");
                                } else if (editTextWeight.getText().toString().equals("")) {
                                    editTextWeight.setError("Enter Weight");
                                } else {
                                    calculateCalorie(Float.parseFloat(editTextHeight.getText().toString().trim()), Float.parseFloat(editTextWeight.getText().toString().trim()), Float.parseFloat(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim(),spinneractivity.getSelectedItem().toString().trim());
                                }
                            } else if(radioButtonWeight.getText().toString().trim().equals("LB")) {
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextAge.setError("Enter Age");
                                } else if (editTextHeight.getText().toString().equals("")) {
                                    editTextHeight.setError("Enter Height");
                                } else if (edittextWeightInLb.getText().toString().equals("")) {
                                    edittextWeightInLb.setError("Enter Weight In Lb (Pounds)");
                                } else {
                                    calculateCalorie(Float.parseFloat(editTextHeight.getText().toString().trim()),(float) (Float.parseFloat(edittextWeightInLb.getText().toString().trim())* (0.454)), Float.parseFloat(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim(),spinneractivity.getSelectedItem().toString().trim());
                                }
                            }
                            else {
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextAge.setError("Enter Age");
                                } else if (editTextHeight.getText().toString().equals("")) {
                                    editTextHeight.setError("Enter Height");
                                } else if (edittextWeightInST.getText().toString().equals("")) {
                                    edittextWeightInST.setError("Enter Weight in ST (Stone)");
                                }  else if (edittextWeightInSTLb.getText().toString().equals("")) {
                                    edittextWeightInSTLb.setError("Enter Weight In Lb (Pounds)");
                                }
                                else {
                                    calculateCalorie(Float.parseFloat(editTextHeight.getText().toString().trim()), (float) (((Float.parseFloat(edittextWeightInST.getText().toString().trim()))*(6.350))+((Float.parseFloat(edittextWeightInSTLb.getText().toString().trim()))*(0.454))), Float.parseFloat(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim(),spinneractivity.getSelectedItem().toString().trim());
                                }
                            }
                        }else {
                            if (radioButtonWeight.getText().toString().trim().equals("KG")) {
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextAge.setError("Enter Age");
                                } else if(edittextfeet.getText().toString().equals("")){
                                    edittextfeet.setError("Enter Feet");
                                }else if(edittextInch.getText().toString().equals("")){
                                    edittextInch.setError("Enter Inch");
                                }else if (editTextWeight.getText().toString().equals("")) {
                                    editTextWeight.setError("Enter Weight");
                                } else {
                                    calculateCalorie( (float) (((Float.parseFloat(edittextfeet.getText().toString().trim()))*(30.48))+((Float.parseFloat(edittextInch.getText().toString().trim()))*(2.54))), Float.parseFloat(editTextWeight.getText().toString().trim()), Float.parseFloat(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim(),spinneractivity.getSelectedItem().toString().trim());
                                }
                            } else if (radioButtonWeight.getText().toString().trim().equals("LB")) {
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextAge.setError("Enter Age");
                                }else if(edittextfeet.getText().toString().equals("")){
                                    edittextfeet.setError("Enter Feet");
                                }else if(edittextInch.getText().toString().equals("")){
                                    edittextInch.setError("Enter Inch");
                                } else if (edittextWeightInLb.getText().toString().equals("")) {
                                    edittextWeightInLb.setError("Enter Weight In Lb (Pounds)");
                                } else {
                                    calculateCalorie((float) (((Float.parseFloat(edittextfeet.getText().toString().trim()))*(30.48))+((Float.parseFloat(edittextInch.getText().toString().trim()))*(2.54))), (float) (Float.parseFloat(edittextWeightInLb.getText().toString().trim()) * (0.454)), Float.parseFloat(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim(),spinneractivity.getSelectedItem().toString().trim());
                                }
                            } else {
                                //Validation for Edittext  if is blank
                                if (editTextAge.getText().toString().equals("")) {
                                    editTextAge.setError("Enter Age");
                                } else if(edittextfeet.getText().toString().equals("")){
                                    edittextfeet.setError("Enter Feet");
                                }else if(edittextInch.getText().toString().equals("")){
                                    edittextInch.setError("Enter Inch");
                                } else if (edittextWeightInST.getText().toString().equals("")) {
                                    edittextWeightInST.setError("Enter Weight in ST (Stone)");
                                } else if (edittextWeightInSTLb.getText().toString().equals("")) {
                                    edittextWeightInSTLb.setError("Enter Weight In Lb (Pounds)");
                                } else {
                                    calculateCalorie((float) (((Float.parseFloat(edittextfeet.getText().toString().trim()))*(30.48))+((Float.parseFloat(edittextInch.getText().toString().trim()))*(2.54))), (float) (((Float.parseFloat(edittextWeightInST.getText().toString().trim())) * (6.350)) + ((Float.parseFloat(edittextWeightInSTLb.getText().toString().trim())) * (0.454))), Float.parseFloat(editTextAge.getText().toString().trim()), radioButtonSex.getText().toString().trim(),spinneractivity.getSelectedItem().toString().trim());
                                }
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


    public void calculateCalorie(float height,float weight,float age,String gender,String activity){
        CalculateBMR calculateBMR = new CalculateBMR(height,weight, age, gender,activity);
        float resultADA,resultCDC;
        DecimalFormat f = new DecimalFormat("##.00");

        resultADA=calculateBMR.getWeight();
        textViewADA.setText("Based on the weight, American Dietetic Association (ADA) recommend taking at least "+resultADA*0.8+" - "+resultADA*1+" grams of protein per day.");
        resultCDC = calculateBMR.Sedentary() ;
        textViewCDC.setText("Based on the conditions, Centers for Disease Control and Prevention (CDC) recommend taking "+f.format(((resultCDC/4.09)*10)/100)+" - "+f.format(((resultCDC/4.09)*35)/100)+" grams of protein per day, which is 10% - 35% of your daily Calorie intake.");

    }
    public class WebViewClient extends android.webkit.WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}