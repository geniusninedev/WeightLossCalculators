package com.nineinfosys.android.weightlosscalculators.Weight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WeightFragment extends Fragment {


    EditText editTextWeight;
    Button buttonCalculate;
    TextView textViewResult;
    Spinner spinnerWeight1,spinnerWeight2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_weight, null);
        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Weight Conversion");
        editTextWeight=(EditText)v.findViewById(R.id.editTextWeight);
        spinnerWeight1=(Spinner)v.findViewById(R.id.spinnerWeight1);
        spinnerWeight2=(Spinner)v.findViewById(R.id.spinnerWeight2);
        buttonCalculate=(Button)v.findViewById(R.id.buttonCalculate);
        textViewResult=(TextView)v.findViewById(R.id.textViewResult);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("KG");
        categories.add("Gram");
        categories.add("MiliGram");
        categories.add("Ton");
        categories.add("Pounds");
        categories.add("Ounces");

        categories.add("Carat");
        categories.add("Atomic Mass Unit");
        categories.add("Grain");
        categories.add("QuarterUS");
        categories.add("QuarterUK");
        categories.add("StoneUS");
        categories.add("StoneUK");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerWeight1.setAdapter(dataAdapter);
        spinnerWeight2.setAdapter(dataAdapter);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextWeight.getText().toString().trim().equals("")){
                    editTextWeight.setError("Enter Weight");
                }else {
                    Weight weightcalucaltion=new Weight(spinnerWeight1.getSelectedItem().toString().trim(),spinnerWeight2.getSelectedItem().toString().trim(),editTextWeight.getText().toString().trim());
                    DecimalFormat f = new DecimalFormat("##.00");
                    float weightconvertedresult=weightcalucaltion.getWeightConverted();
                    textViewResult.setText(" Your "+editTextWeight.getText().toString().trim()+" "+spinnerWeight1.getSelectedItem().toString().trim()+" To "+spinnerWeight2.getSelectedItem().toString().trim()+" is: "+f.format(weightconvertedresult)+" "+spinnerWeight2.getSelectedItem().toString().trim());

                }

            }
        });
     return v;
    }

}
