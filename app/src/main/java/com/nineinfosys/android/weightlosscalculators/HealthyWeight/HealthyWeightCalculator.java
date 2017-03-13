package com.nineinfosys.android.weightlosscalculators.HealthyWeight;

/**
 * Created by Dev on 08-03-2017.
 */

public class HealthyWeightCalculator {
    String healthyweight;

    public  String HeightInCM(float heightinCM){

        if(heightinCM >=146 && heightinCM <= 147.3){
            healthyweight="41.2 to 53.5 kg.";
        }else if(heightinCM>147.3 && heightinCM <=149.9){
            healthyweight="42.6 to 55.7 kg.";
        }else if(heightinCM>149.9 && heightinCM <=152.4){
            healthyweight="43.9 to 57.6 kg.";
        }else if(heightinCM>152.4&& heightinCM <=154.9){
            healthyweight="45.3 to 59.4 kg.";
        }else if(heightinCM>154.9 && heightinCM <=157.5){
            healthyweight="47.1 to 61.2 kg.";
        }else if(heightinCM>157.5 && heightinCM <= 160 ){
            healthyweight="48.5 to 63.5 kg.";
        }else if(heightinCM>160 && heightinCM <=162.6){
            healthyweight="49.8 to 65.3 kg.";
        }else if(heightinCM>162.6 && heightinCM <=165.1){
            healthyweight="51.7 to 67.5 kg.";
        }else if(heightinCM>165.1 && heightinCM <=167.6){
            healthyweight="53.5 to 69.8 kg.";
        }else if(heightinCM>167.6 && heightinCM <=170.2){
            healthyweight="54.8 to 71.6 kg.";
        }else if(heightinCM>170.2 && heightinCM <=172.7){
            healthyweight="56.6 to 73.9 kg.";
        }else if(heightinCM>172.7 && heightinCM <=175.3){
            healthyweight="58.0 to 76.2 kg.";
        }else if(heightinCM>175.3 && heightinCM <=177.8){
            healthyweight="59.8 to 78.4 kg.";
        }else if(heightinCM>177.8 &&heightinCM <=180.3){
            healthyweight="61.6 to 80.7 kg.";
        }else if(heightinCM>180.3 && heightinCM<=182.9){
            healthyweight="63.5 to 83.0 kg.";
        }else if(heightinCM>182.9 && heightinCM<=185.4 ){
            healthyweight="65.3 to 85.2 kg.";
        } else if(heightinCM>185.4 && heightinCM <=188){
            healthyweight="67.1 to 87.5 kg.";
        }else if(heightinCM>188 && heightinCM <=190.5){
            healthyweight="68.9 to 90.2 kg.";
        }else if(heightinCM>190.5 && heightinCM <=193){
            healthyweight="70.7 to 92.5 kg.";
        }else{
            healthyweight="Your Height Not In Standards";
        }

        return healthyweight;
    }
    public  String HeightInFTAndIn(float heightinft,float heightinin){

        if(heightinft==4 && heightinin ==10){
            healthyweight="91 to 118 lbs.";
        }else if(heightinft==4 && heightinin ==11){
            healthyweight="94 to 123 lbs.";
        }else if(heightinft==5 && heightinin ==0){
            healthyweight="97 to 127 lbs.";
        }else if(heightinft==5 && heightinin ==1){
            healthyweight="100 to 131 lbs.";
        }else if(heightinft==5 && heightinin ==2){
            healthyweight="104 to 135 lbs.";
        }else if(heightinft==5 && heightinin ==3){
            healthyweight="107 to 140 lbs.";
        }else if(heightinft==5 && heightinin ==4){
            healthyweight="110 to 144 lbs.";
        }else if(heightinft==5 && heightinin ==5){
            healthyweight="114 to 149 lbs.";
        }else if(heightinft==5 && heightinin ==6){
            healthyweight="118 to 154 lbs.";
        }else if(heightinft==5 && heightinin ==7){
            healthyweight="121 to 158 lbs.";
        }else if(heightinft==5 && heightinin ==8){
            healthyweight="125 to 163 lbs.";
        }else if(heightinft==5 && heightinin ==9){
            healthyweight="128 to 168 lbs.";
        }else if(heightinft==5 && heightinin ==10){
            healthyweight="132 to 173 lbs.";
        }else if(heightinft==5 && heightinin ==11){
            healthyweight="136 to 178 lbs.";
        }else if(heightinft==6 && heightinin ==0){
            healthyweight="140 to 183 lbs.";
        }else if(heightinft==6 && heightinin ==1){
            healthyweight="144 to 188 lbs.";
        } else if(heightinft==6 && heightinin ==2){
            healthyweight="148 to 193 lbs.";
        }else if(heightinft==6 && heightinin ==3){
            healthyweight="152 to 199 lbs.";
        }else if(heightinft==6 && heightinin ==4){
            healthyweight="156 to 204 lbs.";
        }else{
            healthyweight="Your Height Not In Standards";
        }

        return healthyweight;
    }

}
