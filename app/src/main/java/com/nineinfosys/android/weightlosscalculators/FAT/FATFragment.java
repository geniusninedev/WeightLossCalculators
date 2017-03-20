package com.nineinfosys.android.weightlosscalculators.FAT;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;

public class FATFragment  extends Fragment {
    //View Declarations
     EditText editTextAge,editTextBMI;
     Button buttonCalculate;
     ImageView imageViewGender;
     TextView textViewFAT,textViewFATInterpret;
     private RadioGroup radioGroupSex;
    private RadioButton radioButtonSex;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_fat, null);
        ((MainActivityDrawer) getActivity()).toolbar.setTitle("FAT");
        //Initialising Views
        editTextAge=(EditText)v.findViewById(R.id.editTextAge);
        editTextBMI=(EditText)v.findViewById(R.id.editTextBMI);
        imageViewGender = (ImageView) v.findViewById(R.id.imageViewGender);
        buttonCalculate = (Button) v.findViewById(R.id.buttonCalculate);
        textViewFAT = (TextView) v.findViewById(R.id.textViewFAT);
        textViewFATInterpret = (TextView) v.findViewById(R.id.textViewFATInterpret);

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

        //Calculating BMI and FAT
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_LONG).show();
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
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        return v;
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
}