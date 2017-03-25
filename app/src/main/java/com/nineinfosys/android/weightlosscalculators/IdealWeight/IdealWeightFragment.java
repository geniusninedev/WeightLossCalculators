package com.nineinfosys.android.weightlosscalculators.IdealWeight;

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

public class IdealWeightFragment extends Fragment {
    //View Declarations
    EditText  editTextHeight,edittextfeet,edittextInch;
    Button buttonCalculate;
    ImageView imageViewGender,imageViewHeight;
    TextView textViewIdealWeight;
    private RadioGroup radioGroupSex,radioGroupHeight;
    private RadioButton radioButtonSex,radioButtonHeight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_ideal_weight, null);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView) v.findViewById(R.id.adViewMainPageidealWeight);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Ideal Weight");

        //Initialising Views
        editTextHeight=(EditText)v.findViewById(R.id.editTextHeight);
        edittextfeet = (EditText)v. findViewById(R.id.edittextFeet);
        edittextInch = (EditText) v.findViewById(R.id.edittextInch);
        imageViewGender = (ImageView) v.findViewById(R.id.imageViewGender);
        imageViewHeight = (ImageView) v.findViewById(R.id.imageViewHeight);
        buttonCalculate = (Button) v.findViewById(R.id.buttonCalculate);
        textViewIdealWeight = (TextView) v.findViewById(R.id.textViewIdealWeight);

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
        //Calculating BMI and FAT
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for hiding keyboard
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                //Default case Calculation
                if (radioGroupSex.getCheckedRadioButtonId() == -1 && radioGroupHeight.getCheckedRadioButtonId() == -1) {
                    //Validation for Edittext  if is blank
                    int hightincm= Integer.parseInt(editTextHeight.getText().toString().trim());
                     if (editTextHeight.getText().toString().equals("")) {
                        editTextHeight.setError("Enter Height");
                    }  else if (hightincm<100) {
                         textViewIdealWeight.setText("Standards Not Available For Your Height");
                     } else {
                         calculateIdealWeigh(Integer.parseInt(editTextHeight.getText().toString().trim()), "Male");
                    }
                } else {
                    if (radioGroupSex.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_LONG).show();
                    }else if(radioGroupHeight.getCheckedRadioButtonId() == -1 ) {
                        Toast.makeText(getActivity(), "Please Select Height Unit", Toast.LENGTH_LONG).show();
                    } else {
                        if(radioButtonHeight.getText().toString().trim().equals("CM")) {
                            //Validation for Edittext  if is blank
                            int hightincm= Integer.parseInt(editTextHeight.getText().toString().trim());
                            if (editTextHeight.getText().toString().equals("")) {
                                editTextHeight.setError("Enter Height");
                            } else if (hightincm<100) {
                                textViewIdealWeight.setText("Standards Not Available For Your Height");
                            }
                            else
                             {
                                calculateIdealWeigh(Integer.parseInt(editTextHeight.getText().toString().trim()), radioButtonSex.getText().toString().trim());
                            }
                        }else{
                            int hightinfeet= (int) (((Float.parseFloat(edittextfeet.getText().toString().trim()))*(30.48))+((Float.parseFloat(edittextInch.getText().toString().trim()))*(2.54)));

                            //Validation for Edittext  if is blank
                             if(edittextfeet.getText().toString().equals("")){
                                edittextfeet.setError("Enter Feet");
                            }else if(edittextInch.getText().toString().equals("")){
                                edittextInch.setError("Enter Inch");
                            } else if (hightinfeet<100) {
                                 textViewIdealWeight.setText("Standards Not Available For Your Height");
                             }else {
                                calculateIdealWeigh((int) (((Float.parseFloat(edittextfeet.getText().toString().trim()))*(30.48))+((Float.parseFloat(edittextInch.getText().toString().trim()))*(2.54))), radioButtonSex.getText().toString().trim());
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

    public  void calculateIdealWeigh(int height,String gender){
        CalculateIdealWeight calculateIdealWeight = new CalculateIdealWeight(height,gender);
        float resultIdealWeight= calculateIdealWeight.calculateIdealWeightResult() ;
        DecimalFormat f = new DecimalFormat("##.00");
        textViewIdealWeight.setText(f.format(resultIdealWeight)+" KG");

    }

}