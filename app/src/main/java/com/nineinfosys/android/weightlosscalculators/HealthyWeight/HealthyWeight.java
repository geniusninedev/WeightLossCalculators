package com.nineinfosys.android.weightlosscalculators.HealthyWeight;

/**
 * Created by Dev on 08-03-2017.
 */

public class HealthyWeight {
    String healthyweight;

    public  String HeightInCM(float heightinCM){

        if(heightinCM <73){
            healthyweight="Standards Not Available For Your Height";
        }else if(heightinCM >=73 && heightinCM <= 75.6){
            healthyweight="7 to 19.3 kg.";
        }else if(heightinCM >=75.6 && heightinCM <= 78.2){
            healthyweight="8.3 to 20.6 kg.";
        }else if(heightinCM >=78.2 && heightinCM <= 80.8){
            healthyweight="9.6 to 21.9 kg.";
        }else if(heightinCM >=80.8 && heightinCM <= 83.4){
            healthyweight="10.9 to 23.2 kg.";
        }else if(heightinCM >=83.4 && heightinCM <= 86){
            healthyweight="12.2 to 24.5 kg.";
        }else if(heightinCM >=86 && heightinCM <= 88.6){
            healthyweight="13.5 to 25.8 kg.";
        }else if(heightinCM >=88.6 && heightinCM <=91.2 ){
            healthyweight="14.8 to 27.1 kg.";
        }else if(heightinCM >=91.2 && heightinCM <= 93.8){
            healthyweight="16.1 to 28.4 kg.";
        }else if(heightinCM >=93.8 && heightinCM <= 96.4){
            healthyweight="17.4 to 29.7 kg.";
        }else if(heightinCM >=96.4 && heightinCM <= 99){
            healthyweight="18.7 to 31 kg.";
        }else if(heightinCM >=99 && heightinCM <= 101.6){
            healthyweight="20 to 32.3 kg.";
        }else if(heightinCM >=101.6 && heightinCM <= 104.2){
            healthyweight="21.3 to 33.6 kg.";
        }else if(heightinCM >=104.2 && heightinCM <= 109.4){
            healthyweight="22.6 to 34.9 kg.";
        }else if(heightinCM >=109.4 && heightinCM <= 112){
            healthyweight="23.9 to 36.2 kg.";
        }else if(heightinCM >=112 && heightinCM <= 117.2){
            healthyweight="25.2 to 37.5 kg.";
        }else if(heightinCM >=117.2 && heightinCM <= 119.8){
            healthyweight="26.5 to 38.8 kg.";
        }else if(heightinCM >=119.8 && heightinCM <= 122.4){
            healthyweight="27.8 to 40.1 kg.";
        }else if(heightinCM >=122.4 && heightinCM <= 125){
            healthyweight="29.1 to 41.4 kg.";
        } else if(heightinCM >=125 && heightinCM <= 127.6){
            healthyweight="30.4 to 42.7 kg.";
        } else if(heightinCM >=127.6 && heightinCM <= 130.2){
            healthyweight="31.7 to 44 kg.";
        } else if(heightinCM >=130.2 && heightinCM <= 132.8){
            healthyweight="33 to 45.3 kg.";
        } else if(heightinCM >=132.8 && heightinCM <= 135.4){
            healthyweight="34.3 to 46.6 kg.";
        } else if(heightinCM >=135.4 && heightinCM <= 138){
            healthyweight="35.6 to 47.9 kg.";
        } else if(heightinCM >=138 && heightinCM <= 140.6){
            healthyweight="36.9 to 49.2 kg.";
        } else if(heightinCM >=140.6 && heightinCM <= 143.2){
            healthyweight="38.2 to 50.5 kg.";
        }else if(heightinCM >=143.2 && heightinCM <= 146){
            healthyweight="39.5 to 51.8 kg.";
        }else if(heightinCM >=146 && heightinCM <= 147.3){
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
        }else if(heightinCM>193 && heightinCM <=195.6){
            healthyweight="72 to 93.8 kg.";
        }else if(heightinCM>195.6 && heightinCM <=198.2){
            healthyweight="73.3 to 95.1 kg.";
        }else if(heightinCM>198.2 && heightinCM <=200.8){
            healthyweight="74.6 to 96.4 kg.";
        } else if(heightinCM>200.8 && heightinCM <=203.4){
            healthyweight="75.9 to 97.7 kg.";
        }else if(heightinCM>203.4 && heightinCM <=206){
            healthyweight="77.2 to 99 kg.";
        }else if(heightinCM>206 && heightinCM <=208.6){
            healthyweight="78.5 to 100.3 kg.";
        }else if(heightinCM>208.6 && heightinCM <=211.2){
            healthyweight="79.8 to 101.6 kg.";
        }else if(heightinCM>211.2 && heightinCM <=213.8){
            healthyweight="81.1 to 102.9 kg.";
        } else{
            healthyweight="Standards Not Available For Your Height";
        }

        return healthyweight;
    }
    public  String HeightInFTAndIn(float heightinft,float heightinin){
        if(heightinft<2 && heightinin <4){
            healthyweight="Standards Not Available For Your Height";
        } else if(heightinft==2 && heightinin ==4){
            healthyweight="1 to 28 lbs.";
        }else if(heightinft==2&& heightinin ==5){
            healthyweight="4 to 31 lbs.";
        }else if(heightinft== 2 && heightinin ==6){
            healthyweight="7 to 34 lbs.";
        }else if(heightinft==2 && heightinin ==7){
            healthyweight="10 to 37 lbs.";
        }else if(heightinft==2 && heightinin ==8){
            healthyweight="13 to 40 lbs.";
        }else if(heightinft==2 && heightinin ==9){
            healthyweight="16 to 43 lbs.";
        }else if(heightinft==2 && heightinin ==10){
            healthyweight="19 to 46 lbs.";
        }else if(heightinft==2 && heightinin ==11){
            healthyweight="22 to 49 lbs.";
        } else if(heightinft==3 && heightinin ==0){
            healthyweight="25 to 52 lbs.";
        } else if(heightinft==3&& heightinin ==1){
            healthyweight="28 to 55 lbs.";
        }else if(heightinft==3 && heightinin ==2){
            healthyweight="31 to 58 lbs.";
        }else if(heightinft==3 && heightinin ==3){
            healthyweight="34 to 61 lbs.";
        }else if(heightinft==3 && heightinin ==4){
            healthyweight="37 to 64 lbs.";
        }else if(heightinft==3 && heightinin ==5){
            healthyweight="40 to 67 lbs.";
        }else if(heightinft==3 && heightinin ==6){
            healthyweight="43 to 70 lbs.";
        }else if(heightinft==3 && heightinin ==7){
            healthyweight="46 to 73 lbs.";
        }else if(heightinft==3 && heightinin ==8){
            healthyweight="49 to 76 lbs.";
        }else if(heightinft==3 && heightinin ==9){
            healthyweight="52 to 79 lbs.";
        }else if(heightinft==3 && heightinin ==10){
            healthyweight="55 to 82 lbs.";
        }else if(heightinft==3 && heightinin ==11){
            healthyweight="58 to 85 lbs.";
        }else if(heightinft==4 && heightinin ==0){
            healthyweight="61 to 88 lbs.";
        }else if(heightinft==4 && heightinin ==1){
            healthyweight="65 to 91 lbs.";
        }else if(heightinft==4 && heightinin ==2){
            healthyweight="67 to 94 lbs.";
        }else if(heightinft==4 && heightinin ==3){
            healthyweight="70 to 97 lbs.";
        }else if(heightinft==4 && heightinin ==4){
            healthyweight="73 to 100 lbs.";
        }else if(heightinft==4 && heightinin ==5){
            healthyweight="76 to 103 lbs.";
        }else if(heightinft==4 && heightinin ==6){
            healthyweight="79 to 106 lbs.";
        }else if(heightinft==4 && heightinin ==7){
            healthyweight="82 to 109 lbs.";
        }else if(heightinft==4 && heightinin ==8){
            healthyweight="85 to 112 lbs.";
        }else if(heightinft==4 && heightinin ==9){
            healthyweight="88 to 115 lbs.";
        } else if(heightinft==4 && heightinin ==10){
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
        } else if(heightinft==6 && heightinin ==5){
            healthyweight="159 to 208 lbs.";
        }else if(heightinft==6 && heightinin ==6){
            healthyweight="162 to 212 lbs.";
        }else if(heightinft==6 && heightinin ==7){
            healthyweight="165 to 216 lbs.";
        }else if(heightinft==6 && heightinin ==8){
            healthyweight="168 to 220 lbs.";
        }else if(heightinft==6 && heightinin ==9){
            healthyweight="171 to 224 lbs.";
        }else if(heightinft==6 && heightinin ==10){
            healthyweight="174 to 228 lbs.";
        }else if(heightinft==7 && heightinin ==0){
            healthyweight="177 to 232 lbs.";
        } else{
            healthyweight="Standards Not Available For Your Height";
        }

        return healthyweight;
    }

}
