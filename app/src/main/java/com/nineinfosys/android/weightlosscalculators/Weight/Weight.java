package com.nineinfosys.android.weightlosscalculators.Weight;

/**
 * Created by Dev on 28-02-2017.
 */

public class Weight {
    String weightin,weightto;
    String weight;
    float resultConvertedWeight;
    public Weight(String weightin, String weightto, String weight) {
        this.weightin = weightin;
        this.weightto = weightto;
        this.weight = weight;
    }

    public String getWeightin() {
        return weightin;
    }

    public void setWeightin(String weightin) {
        this.weightin = weightin;
    }

    public String getWeightto() {
        return weightto;
    }

    public void setWeightto(String weightto) {
        this.weightto = weightto;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
public  float getWeightConverted() {
    switch (weightin) {
        case "KG":
            switch (weightto) {
                case "KG":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                  
                    break;

                case "Gram":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1000);
                    
                    break;

                case "MiliGram":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1000000);
                
                    break;

                case "Ton":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.001);
                   
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.2046226218488);
                    
                    break;

                case "Ounces":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 35.27396194958);
                  
                    break;

                case "Carat":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 5000);
                   
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 6.0221366516752E+26);
                    
                    break;

                case "Grain":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 15432.358352941);
                 
                    break;

                case "QuarterUS":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.088184904873951);
                    
                    break;

                case "QuarterUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.078736522208885);
                   
                    break;

                case "StoneUS":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.1763698097479);
                    
                    break;

                case "StoneUK":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.15747304441777);
                   
                    break;
            }
            break;

        case "Gram":
            switch (weightto) {
                case "KG":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.001);
                   
                    break;

                case "Gram":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                   
                    break;

                case "MiliGram":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1000);
                   
                    break;

                case "Ton":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.0E-6);
                   
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0022046226218488);
                  
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.03527396194958);
                   
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 5);
                    
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 6.0221366516752E+23);
                   
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 15.432358352941);
                    
                    break;

                case "QuarterUS":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 8.8184904873951E-5);
                    
                    break;

                case "QuarterUK":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 7.8736522208885E-5);
                   
                    break;

                case "StoneUS":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.0001763698097479);
                  
                    break;

                case "StoneUK":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.00015747304441777);
                    
                    break;
            }
            break;


        case "MiliGram":
            switch (weightto) {

                case "KG":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 1.0E-6);
                   
                    break;

                case "Gram":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.001);
                    
                    break;

                case "MiliGram":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    
                    break;

                case "Ton":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 1.0E-9);
                   
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.2046226218488E-6);
                   
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.527396194958E-5);
                   
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.005);
                    
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 6.0221366516752E+20);
                    
                    break;

                case "Grain":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.015432358352941);
                   
                    break;

                case "QuarterUS":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 8.8184904873951E-8);
                  
                    break;

                case "QuarterUK":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 7.8736522208885E-8);
                   
                    break;

                case "StoneUS":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.763698097479E-7);
                    
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.5747304441777E-7);
                   
                    break;
                
            }
            break;

        case "Ton":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 1000);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 1000000);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 1000000000);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2204.6226218488);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 35273.96194958);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 5000000);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 6.0221366516752E+29);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 15432358.352941);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 88.184904873951);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 78.736522208885);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 176.3698097479);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 157.47304441777);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;

            }
            break;

        case "Pounds":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.45359237);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 453.59237);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 453592.37);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.00045359237);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 16);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2267.96185);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.7315952362972E+26);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 7000);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.04);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.035714285714286);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.08);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.071428571428571);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;
            }
            break;

        case "Ounces":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.028349523125);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 28.349523125);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 28349.523125);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.8349523125E-5);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0625);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 141.747615625);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.7072470226858E+25);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 437.5);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0025);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0022321428571429);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.005);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0044642857142857);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;

            }
            break;

        case "Carat":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 0.0002);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.2);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 200);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.0E-7);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.00044092452436976);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0070547923899161);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.204427330335E+23);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.0864716705883);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.763698097479E-5);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.5747304441777E-5);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.527396194958E-5);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.1494608883554E-5);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;

            }
            break;

        case "Atomic Mass Unit":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 1.6605402E-27);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.6605402E-24);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 1.6605402E-21);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.6605402E-30);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.6608644894093E-27);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 5.8573831830549E-26);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 8.302701E-24);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.5626051425865E-23);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.4643457957637E-28);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.3074516033605E-28);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.9286915915274E-28);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.6149032067209E-28);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;

            }
            break;

        case "Grain":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 6.479891E-5);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.06479891);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 64.79891);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 6.479891E-8);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.00014285714285714);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.0022857142857143);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.32399455);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.902278908996E+22);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 5.7142857142857E-6);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 5.1020408163265E-6);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.1428571428571E-5);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.0204081632653E-5);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;


            }
            break;

        case "QuarterUS":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 11.33980925);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 11339.80925);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 11339809.25);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.01133980925);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 25);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 400);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 56699.04625);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 6.828988090743E+27);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 175000);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.89285714285714);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 2);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.7857142857143);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;
            }
            break;

        case "QuarterUK":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 12.70058636);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 12700.58636);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 12700586.36);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.01270058636);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 28);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 448);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 63502.9318);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 7.6484666616322E+27);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 196000);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.12);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 2.24);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 2);
                    System.out.println("Your " + weightto + " in tone [Uk]: " + resultConvertedWeight);
                    break;

            }
            break;

        case "StoneUS":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 5.669904625);
                    System.out.println("Your" + weightto + " in KG: " + resultConvertedWeight);
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 5669.904625);
                    System.out.println("Your " + weightto + " in Gram: " + resultConvertedWeight);
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 5669904.625);
                    System.out.println("Your " + weightto + " in Mili Gram: " + resultConvertedWeight);
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.005669904625);
                    System.out.println("Your " + weightto + " in Ton: " + resultConvertedWeight);
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 12.5);
                    System.out.println("Your " + weightto + " in Pounds(lb): " + resultConvertedWeight);
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 200);
                    System.out.println("Your" + weightto + " in Ounces: " + resultConvertedWeight);
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 28349.523125);
                    System.out.println("Your " + weightto + " in Carat: " + resultConvertedWeight);
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.4144940453715E+27);
                    System.out.println("Your" + weightto + " in Atomic Mass Unit: " + resultConvertedWeight);
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 87500);
                    System.out.println("Your " + weightto + " in Grain: " + resultConvertedWeight);
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.5);
                    System.out.println("Your" + weightto + " in Quarter [US]: " +resultConvertedWeight);
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.44642857142857);
                    System.out.println("Your" + weightto + " in Quarter [UK]: " + resultConvertedWeight);
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    System.out.println("Your " + weightto + " in Stone [US]: " + resultConvertedWeight);
                    break;

            }
            break;

        case "StoneUK":
            switch (weightto) {

                case "KG":
                   resultConvertedWeight= (float) (Float.parseFloat(weight) * 6.35029318);
                    
                    break;

                case "Gram":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 6350.29318);
                    
                    break;

                case "MiliGram":
                    resultConvertedWeight= (float) (Float.parseFloat(weight) * 6350293.18);
                    
                    break;

                case "Ton":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.00635029318);
                    
                    break;

                case "Pounds":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 14);
                    
                    break;

                case "Ounces":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 224);
                    
                    break;

                case "Carat":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 31751.4659);
                    
                    break;

                case "Atomic Mass Unit":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 3.8242333308161E+27);
                    
                    break;

                case "Grain":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 98000);
                    
                    break;

                case "QuarterUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.56);
                    
                    break;

                case "QuarterUK":
                   resultConvertedWeight = (float) (Float.parseFloat(weight) * 0.5);
                    
                    break;

                case "StoneUS":
                  resultConvertedWeight = (float) (Float.parseFloat(weight) * 1.12);
                    
                    break;

                case "StoneUK":
                    resultConvertedWeight = (float) (Float.parseFloat(weight) * 1);
                    
                    break;
            }
            break;
    }
    return resultConvertedWeight;
}
}
