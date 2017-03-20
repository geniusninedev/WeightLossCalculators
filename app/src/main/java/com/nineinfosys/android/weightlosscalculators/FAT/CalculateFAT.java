package com.nineinfosys.android.weightlosscalculators.FAT;

import android.graphics.Color;

/**
 * Created by Dev on 23-02-2017.
 */

public class CalculateFAT {
    float ageinyears;
    float bmivalue;
    String gender;
    float FAT_percentage;

    public CalculateFAT(float ageinyears, float bmivalue, String gender) {
        this.ageinyears = ageinyears;
        this.bmivalue = bmivalue;
        this.gender = gender;
    }

    public float getBmivalue() {
        return bmivalue;
    }

    public void setBmivalue(float bmivalue) {
        this.bmivalue = bmivalue;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getAgeinyears() {
        return ageinyears;
    }

    public void setAgeinyears(float ageinyears) {
        this.ageinyears = ageinyears;
    }





    //Calculate Ideal FAT
    public float calculateFATResult() {

        if(gender.equals("Male")) {
            FAT_percentage= (float) ((1.20 * bmivalue) + (0.23 * ageinyears) - (10.8 * 1) - 5.4);
        }else {
            FAT_percentage = (float) ((1.20 * bmivalue) + (0.23 * ageinyears) - (10.8 * 0) - 5.4);
        }
        return (int) (FAT_percentage);
    }
    // Interpret what FAT means
    public String interpretFAT() {

        if (gender.equals("Male")) {
            if (FAT_percentage < 14) {
                return "Athletes";
            } else if (FAT_percentage < 24) {

                return "Fitness";
            } else if (FAT_percentage < 31) {

                return "Acceptable";
            } else {

                return "Obese";
            }
        } else {
            if (FAT_percentage < 6) {
                return "Athletes";
            } else if (FAT_percentage < 17) {

                return "Fitness";
            } else if (FAT_percentage < 25) {

                return "Acceptable";
            } else {

                return "Obese";
            }
        }

    }
    // Interpret what FAT COLOR
    public int interpretFATCOLOR() {

        if (gender == "Female") {
            if (FAT_percentage < 20) {
                return Color.parseColor("#dc9b22");
            } else if (FAT_percentage < 24) {
                return Color.parseColor("#059733");
            } else if (FAT_percentage < 31) {
                return Color.parseColor("#059733");
            } else {
                return Color.parseColor("#c41919");
            }
        } else {
            if (FAT_percentage < 6) {
                return Color.parseColor("#dc9b22");
            } else if (FAT_percentage < 17) {
                return Color.parseColor("#059733");
            } else if (FAT_percentage < 25) {
                return Color.parseColor("#059733");
            } else {
                return Color.parseColor("#c41919");
            }
        }
    }
}
