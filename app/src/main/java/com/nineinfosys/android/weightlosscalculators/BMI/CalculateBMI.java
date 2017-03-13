package com.nineinfosys.android.weightlosscalculators.BMI;

/**
 * Created by Dev on 23-02-2017.
 */

public class CalculateBMI {
    float height,weight,bmi,ageinyears;
    String gender;
    float FAT_percentage;

    public CalculateBMI(float height, float weight, float ageinyears, String gender) {
        this.height = height;
        this.weight = weight;
        this.ageinyears = ageinyears;
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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

    //Calculate BMI
    public float calculateBMIResult() {

        bmi=(float) (weight / (height * height));
        return bmi;
    }
    // Interpret what BMI means
    public String interpretBMI() {

        if (gender.equals("Male")) {
            if (bmi < 16) {
                return "Severely underweight";
            } else if (bmi < 18.5) {
                return "Underweight";
            } else if (bmi < 25) {
                return "Normal";
            } else if (bmi < 30) {
                return "Overweight";
            } else if (bmi < 35) {
                return "Obese Class I";
            } else if (bmi < 40) {
                return "Obese Class II";
            } else {
                return "Obese Class III";
            }
        } else {
            if (bmi < 17.5) {
                return "Underweight";
            } else if (bmi < 24.9) {
                return "Normal";
            } else if (bmi < 40) {
                return "Overweight";
            } else {
                return "Obese Class ";
            }

        }
    }
    //Calculate Ideal FAT
    public float calculateFATResult() {

        if(gender.equals("Male")) {
            FAT_percentage= (float) ((1.20 * bmi) + (0.23 * ageinyears) - (10.8 * 1) - 5.4);
        }else {
            FAT_percentage = (float) ((1.20 * bmi) + (0.23 * ageinyears) - (10.8 * 0) - 5.4);
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
}
