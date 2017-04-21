package com.nineinfosys.android.weightlosscalculators.Calculators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import com.nineinfosys.android.weightlosscalculators.AnorexicBMI.AnorexicBMICalculator;
import com.nineinfosys.android.weightlosscalculators.ArmyBodyFat.ArmyBodyFatCalculator;
import com.nineinfosys.android.weightlosscalculators.BMI.BMICalculator;
import com.nineinfosys.android.weightlosscalculators.BMR.BMRCalculator;
import com.nineinfosys.android.weightlosscalculators.BodyFat.BodyFatCalculator;
import com.nineinfosys.android.weightlosscalculators.Calorie.CalorieCalculator;
import com.nineinfosys.android.weightlosscalculators.Carbohydrate.CarbohydrateCalculator;
import com.nineinfosys.android.weightlosscalculators.FAT.FATCalculator;
import com.nineinfosys.android.weightlosscalculators.FatIntake.FatIntakeCalculator;
import com.nineinfosys.android.weightlosscalculators.HealthyWeight.HealthyWeightCalculator;
import com.nineinfosys.android.weightlosscalculators.IdealWeight.IdealWeightCalculator;
import com.nineinfosys.android.weightlosscalculators.LeanBodyMass.LeanBodyMassCalculator;
import com.nineinfosys.android.weightlosscalculators.Protein.ProteinCalculator;
import com.nineinfosys.android.weightlosscalculators.R;
import com.nineinfosys.android.weightlosscalculators.Weight.WeightLossConversionList;

import java.util.ArrayList;

/**
 * Created by Supriya on 19-04-2017.
 */

public class CalculatorFragment extends Fragment {
    private CustomAdapter mAdapter;
    private ArrayList<String> listCalculator;
    private ArrayList<Integer> listCount;
    private GridView gridView;
    FragmentManager mFragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_calculator_fragment, null);
        // prepared arraylist and passed it to the Adapter class

        prepareList();
        mAdapter = new CustomAdapter(getActivity(),listCalculator, listCount);

        // Set custom adapter to gridview
        gridView = (GridView)v.findViewById(R.id.grid);
        gridView.setAdapter(mAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0){
                 //BMI Calcultor
                    startActivity(new Intent(getActivity(), BMICalculator.class));
                }
                if (position == 1) {
                    startActivity(new Intent(getActivity(), BMRCalculator.class));
                }
                if (position == 2) {
                    startActivity(new Intent(getActivity(), IdealWeightCalculator.class));
                }
                if (position == 3) {
                    startActivity(new Intent(getActivity(), FATCalculator.class));
                }
                if (position == 4) {
                   startActivity(new Intent(getActivity(), AnorexicBMICalculator.class));
                }
                if (position == 5){
                   //Fat Intake
                    startActivity(new Intent(getActivity(), FatIntakeCalculator.class));
                }
                if (position == 6) {
                    startActivity(new Intent(getActivity(), BodyFatCalculator.class));
                }
                if (position == 7) {
                    startActivity(new Intent(getActivity(), CalorieCalculator.class));
                }
                if (position == 8) {
                //Lean Body Mass
                    startActivity(new Intent(getActivity(), LeanBodyMassCalculator.class));
                }

                if (position == 9) {
                //Army Body Fat
                    startActivity(new Intent(getActivity(), ArmyBodyFatCalculator.class));
                }
                if (position == 10) {
                    startActivity(new Intent(getActivity(), HealthyWeightCalculator.class));

                }
                if (position == 11) {
                    //Carbohydrate
                    startActivity(new Intent(getActivity(), CarbohydrateCalculator.class));
                }

                if (position == 12) {
                    startActivity(new Intent(getActivity(), WeightLossConversionList.class));
                }
                if (position == 13) {
                    startActivity(new Intent(getActivity(), ProteinCalculator.class));
                }

            }
        });
        return v;
    }


    public void prepareList()
    {
        listCalculator = new ArrayList<String>();

        listCalculator.add("BMI ");
        listCalculator.add("BMR");
        listCalculator.add("Ideal Weight");
        listCalculator.add("Fat");
        listCalculator.add("Anorexic BMI");
        listCalculator.add("Fat InTake");
        listCalculator.add("Body Fat  ");
        listCalculator.add("Calorie");
        listCalculator.add("Lean Body Mass");
        listCalculator.add("Army Body Fat");
        listCalculator.add("Healthy Weight");
        listCalculator.add("Carbohydrate");
        listCalculator.add("Weight");
        listCalculator.add("Protien");



        listCount = new ArrayList<Integer>();
        listCount.add(R.drawable.btn_bmi_icon);
        listCount.add(R.drawable.btn_bmr);
        listCount.add(R.drawable.btn_ideal_weight);
        listCount.add(R.drawable.btn_fat);
        listCount.add(R.drawable.btn_anorexic_bmi);
        listCount.add(R.drawable.btn_fat_intek);
        listCount.add(R.drawable.btn_body_fat);

        listCount.add(R.drawable.btn_calorie);
        listCount.add(R.drawable.btn_lbm);
        listCount.add(R.drawable.btn_army_body_fat);
        listCount.add(R.drawable.btn_healthy_weight);
        listCount.add(R.drawable.btn_carbohydrates);
        listCount.add(R.drawable.btn_weight);
        listCount.add(R.drawable.btn_protein);
    }

}
