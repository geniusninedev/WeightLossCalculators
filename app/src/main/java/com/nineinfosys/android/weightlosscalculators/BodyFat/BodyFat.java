package com.nineinfosys.android.weightlosscalculators.BodyFat;

/**
 * Created by Dev on 25-02-2017.
 */

public class BodyFat {
    float BodyFat;
    float waist;
    float neck;
    float height;
    float hip;
    int age;
    String gender;

    public BodyFat(float waist, float neck, float height, float hip, int age, String gender) {
        this.waist = waist;
        this.neck = neck;
        this.height = height;
        this.hip = hip;
        this.age = age;
        this.gender = gender;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getNeck() {
        return neck;
    }

    public void setNeck(float neck) {
        this.neck = neck;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getHip() {
        return hip;
    }

    public void setHip(float hip) {
        this.hip = hip;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    public float calculateAmryBodyFatResult(){

        if(gender.equals("Male")) {
            BodyFat = (float) (495/(1.0324- 0.19077*(Math.log10(waist - neck)) + 0.15456*( Math.log10(height)))- 450);
        }else{
            BodyFat = (float) (495/(1.29579-0.35004*(Math.log10(waist+hip-neck))+0.22100*(Math.log10(height)))-450);

        }
        return  BodyFat;
    }
    // Interpret what FAT means
    public String interpretFAT() {

        if (gender.equals("Male")) {
            if (BodyFat < 14) {
                return "Athletes";
            } else if (BodyFat < 24) {

                return "Fitness";
            } else if (BodyFat < 31) {

                return "Acceptable";
            } else {

                return "Obese";
            }
        } else {
            if (BodyFat < 6) {
                return "Athletes";
            } else if (BodyFat < 17) {

                return "Fitness";
            } else if (BodyFat < 25) {

                return "Acceptable";
            } else {

                return "Obese";
            }
        }

    }
}
