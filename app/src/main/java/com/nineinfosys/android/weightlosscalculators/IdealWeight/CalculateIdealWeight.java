package com.nineinfosys.android.weightlosscalculators.IdealWeight;

/**
 * Created by Dev on 23-02-2017.
 */

public class CalculateIdealWeight {

    int height;
    String Gender;

    public CalculateIdealWeight(int height, String gender) {
        this.height = height;
        Gender = gender;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }





    //Calculate Ideal Weight
    public int calculateIdealWeightResult() {
        int idealweight=0;
        if (Gender.equals("Male")) {
            idealweight = (height - 100 - ((height - 150) / 4));
        } else{
            idealweight = (height - 100 - ((height - 150) / 2));
        }
        return (int) (idealweight+1);
    }
}
