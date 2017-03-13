package com.nineinfosys.android.weightlosscalculators.FatIntake;

/**
 * Created by Dev on 23-02-2017.
 */

public class CalculateBMR {
    float height;
    float weight;
    float ageinyears;
    String gender;
    String activity;

    static final int MALEOFFSET = 5;  // Miffin St-Jeor equation is: (10 * weight (kg)) + (6.25 * height (cm)) + (5 * age) + OFFSET, where offset is 5 for males, -161 for females.
    static final int FEMALEOFFSET = -161;
    float bmr;
    float activityfactor;
    public CalculateBMR(float height, float weight, float ageinyears, String gender,String activity) {
        this.height = height;
        this.weight = weight;
        this.ageinyears = ageinyears;
        this.gender = gender;
        this.activity=activity;
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
    public String getGender() {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }








    //Calculate Ideal BMR
    public float calculateBMRResult() {

        int offset = gender.equals("Male") ? MALEOFFSET : FEMALEOFFSET;
        bmr=(float) ((10 * weight) + (6.25 * height) - (5 * ageinyears) + offset);
        return bmr;
    }
   public float ActivityFactor(){

       if (activity.equals("Sedentary-little or no exercise")){
           activityfactor= (float) 1.2;
       }else if (activity.equals("Lightly Active-exercise/sports 1-3 times/week")){
           activityfactor= (float) 1.375;
       }else if (activity.equals("Moderatetely Active-exercise/sports 3-5 times/week")){
           activityfactor= (float) 1.55;
       }else if (activity.equals("Very Active-hard exercise/sports 6-7 times/week")){
           activityfactor= (float) 1.725;
       }else{
           activityfactor= (float)1.9 ;
       }
       return activityfactor;
   }
    // Interpret  Sedentary-little or no exercise
    public  float Sedentary()
    {
        float sedentaryCalorieresult;
        sedentaryCalorieresult=  calculateBMRResult()*ActivityFactor();
        return  sedentaryCalorieresult;
    }
    public  float LoseHaifKg()
    {
        float losehaifkgCalorieresult;
        losehaifkgCalorieresult= calculateBMRResult()*ActivityFactor();
        return  losehaifkgCalorieresult -500;
    }
    public  float LoseOnekg()
    {
        float loseonekgCalorieresult;
        loseonekgCalorieresult=  calculateBMRResult()*ActivityFactor();
        return  loseonekgCalorieresult -1000;
    }
    public  float GainHaifKg()
    {
        float GainhaifkgCalorieresult;
        GainhaifkgCalorieresult= calculateBMRResult()*ActivityFactor();
        return  GainhaifkgCalorieresult +500;
    }
    public  float GainOnekg()
    {
        float GainonekgCalorieresult;
        GainonekgCalorieresult= calculateBMRResult()*ActivityFactor();
        return  GainonekgCalorieresult + 1000;
    }
}
