package com.nineinfosys.android.weightlosscalculators.ArmyBodyFat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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

public class ArmyBodyFatFragment extends Fragment {
    //View Declarations
    EditText editTextAge,edittextHeightFeet,edittextHeightInch,edittextWaistFeet,edittextWaistInch,edittextNeckFeet,edittextNeckInch,edittextHipFeet,edittextHipInch;
    Button buttonCalculate;
    ImageView imageViewGender,imageViewHip;
    TextView textViewArmyBodyFat,textViewArmyBodyFatInterpret,textHip;
    private RadioGroup radioGroupSex;
    private RadioButton radioButtonSex;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_army_body_fat, null);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView) v.findViewById(R.id.adViewMainPagebodyfat);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Army Body Fat");
        //Initialising Views
        editTextAge=(EditText)v.findViewById(R.id.editTextAge);
        edittextHeightFeet=(EditText)v.findViewById(R.id.edittextHeightFeet);
        edittextHeightInch=(EditText)v.findViewById(R.id.edittextHeightInch);
        edittextWaistFeet=(EditText)v.findViewById(R.id.edittextWaistFeet);
        edittextWaistInch=(EditText)v.findViewById(R.id.edittextWaistInch);
        edittextNeckFeet=(EditText)v.findViewById(R.id.edittextNeckFeet);
        edittextNeckInch=(EditText)v.findViewById(R.id.edittextNeckInch);
        textHip = (TextView) v.findViewById(R.id.textHip);
        edittextHipFeet=(EditText)v.findViewById(R.id.edittextHipFeet);
        edittextHipInch=(EditText)v.findViewById(R.id.edittextHipInch);
        imageViewHip = (ImageView)v. findViewById(R.id.imageViewHip);
        imageViewGender = (ImageView) v.findViewById(R.id.imageViewGender);

        buttonCalculate = (Button) v.findViewById(R.id.buttonCalculate);
        textViewArmyBodyFat = (TextView) v.findViewById(R.id.textViewArmyBodyFat);
        textViewArmyBodyFatInterpret = (TextView) v.findViewById(R.id.textViewArmyBodyFatInterpret);


        //alert Dialog Declaration For Gender
        final LayoutInflater inflaterGender = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertLayoutGender = inflaterGender.inflate(R.layout.dialog, null);
        final AlertDialog.Builder alertDialogBuilderGender = new AlertDialog.Builder(getActivity());
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
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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
                        Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_LONG).show();
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
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        return v;
    }


    public  void calculateArmyBodyFat(float waist, float neck, float height, float hip, int age, String gender){
        ArmyBodyFat armyBodyFat = new ArmyBodyFat(waist, neck, height, hip, age, gender);
        DecimalFormat f = new DecimalFormat("##.00");
        float resultArmyBodyFat = armyBodyFat.calculateAmryBodyFatResult();
        textViewArmyBodyFat.setText(f.format(resultArmyBodyFat) + " %");
        String resultinterpretArmyBodyFat=armyBodyFat.interpretArmyBodyFat();
        textViewArmyBodyFatInterpret.setText(resultinterpretArmyBodyFat);

    }
}