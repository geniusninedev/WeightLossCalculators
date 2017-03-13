package com.nineinfosys.android.weightlosscalculators.LeanBodyMass;

/**
 * Created by Dev on 25-02-2017.
 */

public class CalulateLeanBodyMass {
    float height,weight;
    String gender;

    public CalulateLeanBodyMass(float height, float weight, String gender) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }




  public float calculateleanbodymasscalculaterBoer(){
      float eLBM;
      if(gender.equals("Male")){
          eLBM = (float) (0.407*weight + 0.267*height - 19.2);
      }else{
          eLBM = (float) (0.252*weight + 0.473*height - 48.3);
      }

     return  eLBM;

  }
    public float calculateleanbodymasscalculaterJames(){
        float eLBM;
        if(gender.equals("Male")){
           eLBM = (float) (1.1*weight - 128*Math.pow((weight/height),2));


        }else{
           eLBM = (float) (1.07*weight - 148*Math.pow((weight/height),2));
        }

        return  eLBM;

    }
    public float calculateleanbodymasscalculaterHume(){
        float eLBM;
        if(gender.equals("Male")){
          eLBM = (float) (0.32810*weight + 0.33929*height - 29.5336);


        }else{
            eLBM = (float) (0.29569*weight + 0.41813*weight - 43.2933);
        }

        return  eLBM;

    }
}
