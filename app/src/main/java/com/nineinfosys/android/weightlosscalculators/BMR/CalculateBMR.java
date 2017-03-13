package com.nineinfosys.android.weightlosscalculators.BMR;

/**
 * Created by Dev on 23-02-2017.
 */

public class CalculateBMR {
    float height;
    float weight;
    float ageinyears;
    static final int MALEOFFSET = 5;  // Miffin St-Jeor equation is: (10 * weight (kg)) + (6.25 * height (cm)) + (5 * age) + OFFSET, where offset is 5 for males, -161 for females.
    static final int FEMALEOFFSET = -161;

    public CalculateBMR(float height, float weight, float ageinyears, String gender) {
        this.height = height;
        this.weight = weight;
        this.ageinyears = ageinyears;
        this.gender = gender;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    String gender;




    //Calculate Ideal BMR
    public float calculateBMRResult() {

        int offset = gender.equals("Male") ? MALEOFFSET : FEMALEOFFSET;
        return (float) ((10 * weight) + (6.25 * height) - (5 * ageinyears) + offset);
    }

}
