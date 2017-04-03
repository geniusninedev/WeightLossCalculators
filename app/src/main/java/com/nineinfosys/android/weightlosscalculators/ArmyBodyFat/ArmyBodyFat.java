package com.nineinfosys.android.weightlosscalculators.ArmyBodyFat;

/**
 * Created by Dev on 25-02-2017.
 */

public class ArmyBodyFat {
    float AmryBodyFat;
    float waist;
    float neck;
    float height;
    float hip;
    int age;
    String gender;

    public ArmyBodyFat(float waist, float neck, float height, float hip, int age, String gender) {
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
            AmryBodyFat = (float) ((86.010 * Math.log10 (waist - neck)) - (70.041 * Math.log10(height)) + 36.76);
        }else{
            AmryBodyFat = (float) ((163.205 * Math.log10(waist + hip - neck)) - (97.684 * Math.log10(height)) - 78.387);

        }
        return  AmryBodyFat;
    }
    // Interpret what FAT means
    public String interpretArmyBodyFat() {

        if (gender.equals("Male")) {
            if((int) Math.ceil(AmryBodyFat) < 15){
                return "You Need To Increase Weight";
            }
           else if ((int) Math.ceil(AmryBodyFat) >= 18 &&(int) Math.ceil(AmryBodyFat) <= 25) {
                return "You meet the Department of Defense goal";
            }else if ((int) Math.ceil(AmryBodyFat) > 25) {
                return "You Need To Lose Weight";
            } else {
                return "Please Enter Correct Values";
            }
        } else {
            if((int) Math.ceil(AmryBodyFat) < 26){
                return "You Need To Increase Weight";
            } else if ((int) Math.ceil(AmryBodyFat) >= 26 &&(int) Math.ceil(AmryBodyFat) <= 32) {
                return "You meet the Department of Defense goal";
            }else if ((int) Math.ceil(AmryBodyFat) > 32) {
                return "You Need To Lose Weight";
            } else {
                return "Please Enter Correct Values";
            }
        }

    }
}
