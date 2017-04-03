package com.nineinfosys.android.weightlosscalculators.Weight;

import java.util.ArrayList;



public class weightlossCalcualtion {
	
	double kilogram,gram,miligram,ton,pond,ounce,carat,AtomicMassUnit,grain,quarterUS,quarterUK,stoneUS,stoneUK;
	double edtValue;
	private String conversionFrom,conversionTo;
	public weightlossCalcualtion(double edtValue, String conversionFrom) {
		super();
		this.edtValue = edtValue;
		this.conversionFrom = conversionFrom;

	}

		
		public ArrayList<ConversionResults> calculateWeightConversion()
	    {
	    	
			ArrayList<ConversionResults> angleArray = new ArrayList<ConversionResults>();
				
			ConversionResults results= new ConversionResults();



			switch(conversionFrom)
			{
			case "Kilogram":

					kilogram=(edtValue)*1;
	    		    gram=(edtValue)*1000;
	    		    miligram=(edtValue)*1000000;
	    		    ton=(edtValue)* 0.001;
	    		    pond=(edtValue)*2.2046226218488;
	    		    ounce=(edtValue)*35.27396194958;
	    		    carat=(edtValue)*5000;
	    		    AtomicMassUnit=(edtValue)*6.0221366516752E+26;
	    		    grain=(edtValue)*15432.358352941;
	    		    quarterUS=(edtValue)* 0.088184904873951;
	    		    quarterUK=(edtValue)* 0.078736522208885;
	    		    stoneUS=(edtValue)*0.1763698097479;
	    		    stoneUK=(edtValue)*0.15747304441777;

	    	        break;

				case "Gram":
					kilogram=(edtValue)*0.001;
					gram=(edtValue)*1;
					miligram=(edtValue)*1000;
					ton=(edtValue)*  1.0E-6;
					pond=(edtValue)*0.0022046226218488;
					ounce=(edtValue)*0.03527396194958;
					carat=(edtValue)*5;
					AtomicMassUnit=(edtValue)*6.0221366516752E+23;
					grain=(edtValue)*15.432358352941;
					quarterUS=(edtValue)* 8.8184904873951E-5;
					quarterUK=(edtValue)* 7.8736522208885E-5;
					stoneUS=(edtValue)*0.0001763698097479;
					stoneUK=(edtValue)*0.00015747304441777;

				 break;

				case "Miligram":
						kilogram=(edtValue)*1.0E-6;
						gram=(edtValue)*0.001;
						miligram=(edtValue)*1;
						ton=(edtValue)*  1.0E-9;
						pond=(edtValue)*2.2046226218488E-6;
						ounce=(edtValue)*3.527396194958E-5;
						carat=(edtValue)*0.005;
						AtomicMassUnit=(edtValue)*6.0221366516752E+20;
						grain=(edtValue)*0.015432358352941;
						quarterUS=(edtValue)* 8.8184904873951E-8;
						quarterUK=(edtValue)* 7.8736522208885E-8;
						stoneUS=(edtValue)*1.763698097479E-7;
						stoneUK=(edtValue)*1.5747304441777E-7;
				 break;

				case "Ton":
						kilogram=(edtValue)*1000;
						gram=(edtValue)*1000000;
						miligram=(edtValue)*1000000000;
						ton=(edtValue)*  1;
						pond=(edtValue)*2204.6226218488;
						ounce=(edtValue)*35273.96194958;
						carat=(edtValue)*5000000;
						AtomicMassUnit=(edtValue)*6.0221366516752E+29;
						grain=(edtValue)*15432358.352941;
						quarterUS=(edtValue)* 88.184904873951;
						quarterUK=(edtValue)* 78.736522208885;
						stoneUS=(edtValue)*176.3698097479;
						stoneUK=(edtValue)*157.47304441777;
						break;


				case "Pound":
						kilogram=(edtValue)*1000;
						gram=(edtValue)*1000000;
						miligram=(edtValue)*1000000000;
						ton=(edtValue)*  1;
						pond=(edtValue)*2204.6226218488;
						ounce=(edtValue)*35273.96194958;
						carat=(edtValue)*5000000;
						AtomicMassUnit=(edtValue)*6.0221366516752E+29;
						grain=(edtValue)*15432358.352941;
						quarterUS=(edtValue)* 88.184904873951;
						quarterUK=(edtValue)* 78.736522208885;
						stoneUS=(edtValue)*176.3698097479;
						stoneUK=(edtValue)*157.47304441777;
						break;

				case "Ounce":
					kilogram=(edtValue)*0.028349523125;
					gram=(edtValue)*28.349523125;
					miligram=(edtValue)*28349.523125;
					ton=(edtValue)* 2.8349523125E-5;
					pond=(edtValue)*0.0625;
					ounce=(edtValue)*1;
					carat=(edtValue)*141.747615625;
					AtomicMassUnit=(edtValue)*1.7072470226858E+25;
					grain=(edtValue)*437.5;
					quarterUS=(edtValue)* 0.0025;
					quarterUK=(edtValue)* 0.0022321428571429;
					stoneUS=(edtValue)*0.005;
					stoneUK=(edtValue)*0.0044642857142857;
					break;

				case "Carat":
					kilogram=(edtValue)*0.0002;
					gram=(edtValue)*0.2;
					miligram=(edtValue)*200;
					ton=(edtValue)* 2.0E-7;
					pond=(edtValue)*0.00044092452436976;
					ounce=(edtValue)*0.0070547923899161;
					carat=(edtValue)*1;
					AtomicMassUnit=(edtValue)*1.204427330335E+23;
					grain=(edtValue)*3.0864716705883;
					quarterUS=(edtValue)* 1.763698097479E-5;
					quarterUK=(edtValue)* 1.5747304441777E-5;
					stoneUS=(edtValue)*3.527396194958E-5;
					stoneUK=(edtValue)*3.1494608883554E-5;
					break;

				case "Atomic Mass Unit":
					kilogram=(edtValue)*1.6605402E-27;
					gram=(edtValue)*1.6605402E-24;
					miligram=(edtValue)*1.6605402E-21;
					ton=(edtValue)* 1.6605402E-30;
					pond=(edtValue)*3.6608644894093E-27;
					ounce=(edtValue)*5.8573831830549E-26;
					carat=(edtValue)*8.302701E-24;
					AtomicMassUnit=(edtValue)*1;
					grain=(edtValue)*2.5626051425865E-23;
					quarterUS=(edtValue)* 1.4643457957637E-28;
					quarterUK=(edtValue)* 1.3074516033605E-28;
					stoneUS=(edtValue)*2.9286915915274E-28;
					stoneUK=(edtValue)*2.6149032067209E-28;
					break;

				case "Grain":
					kilogram=(edtValue)*6.479891E-5;
					gram=(edtValue)*0.06479891;
					miligram=(edtValue)*64.79891;
					ton=(edtValue)* 6.479891E-8;
					pond=(edtValue)*0.00014285714285714;
					ounce=(edtValue)*0.0022857142857143;
					carat=(edtValue)*0.32399455;
					AtomicMassUnit=(edtValue)*3.902278908996E+22;
					grain=(edtValue)*1;
					quarterUS=(edtValue)* 5.7142857142857E-6;
					quarterUK=(edtValue)* 5.1020408163265E-6;
					stoneUS=(edtValue)*1.1428571428571E-5;
					stoneUK=(edtValue)*1.0204081632653E-5;
				break;

				case "Quarter US":
					kilogram=(edtValue)*11.33980925;
					gram=(edtValue)*11339.80925;
					miligram=(edtValue)*11339809.25;
					ton=(edtValue)* 0.01133980925;
					pond=(edtValue)*25;
					ounce=(edtValue)*400;
					carat=(edtValue)*56699.04625;
					AtomicMassUnit=(edtValue)*6.828988090743E+27;
					grain=(edtValue)*175000;
					quarterUS=(edtValue)* 1;
					quarterUK=(edtValue)* 0.89285714285714;
					stoneUS=(edtValue)*2;
					stoneUK=(edtValue)*1.7857142857143;
					break;


				case "Quarter UK":
					kilogram=(edtValue)*12.70058636;
					gram=(edtValue)*12700.58636;
					miligram=(edtValue)*12700586.36;
					ton=(edtValue)* 0.01270058636;
					pond=(edtValue)*28;
					ounce=(edtValue)*448;
					carat=(edtValue)*63502.9318;
					AtomicMassUnit=(edtValue)*7.6484666616322E+27;
					grain=(edtValue)*196000;
					quarterUS=(edtValue)* 1.12;
					quarterUK=(edtValue)* 1;
					stoneUS=(edtValue)*2.24;
					stoneUK=(edtValue)*2;
					break;

				case "Stone US":
					kilogram=(edtValue)*5.669904625;
					gram=(edtValue)*5669.904625;
					miligram=(edtValue)*5669904.625;
					ton=(edtValue)* 0.005669904625;
					pond=(edtValue)*12.5;
					ounce=(edtValue)*200;
					carat=(edtValue)*28349.523125;
					AtomicMassUnit=(edtValue)*3.4144940453715E+27;
					grain=(edtValue)*87500;
					quarterUS=(edtValue)* 0.5;
					quarterUK=(edtValue)* 0.44642857142857;
					stoneUS=(edtValue)*1;
					stoneUK=(edtValue)*0.89285714285714;
					break;

				case "Stone UK":
					kilogram=(edtValue)*6.35029318;
					gram=(edtValue)*6350.29318;
					miligram=(edtValue)*6350293.18;
					ton=(edtValue)* 0.00635029318;
					pond=(edtValue)*14;
					ounce=(edtValue)*224;
					carat=(edtValue)*31751.4659;
					AtomicMassUnit=(edtValue)*3.8242333308161E+27;
					grain=(edtValue)*98000;
					quarterUS=(edtValue)* 0.56;
					quarterUK=(edtValue)* 0.5;
					stoneUS=(edtValue)*1.12;
					stoneUK=(edtValue)*1;
					break;

			}
			results.setKilogram(kilogram);
			results.setGram(gram);
			results.setMiligram(miligram);
			results.setTon(ton);
			results.setPond(pond);
			results.setOunce(ounce);
			results.setCarat(carat);
			results.setAtomicMassUnit(AtomicMassUnit);
			results.setGrain(grain);
			results.setQuarterUS(quarterUS);
			results.setQuarterUK(quarterUK);
			results.setStoneUS(stoneUS);
			results.setStoneUK(stoneUK);
			angleArray.add(results);
	    	return angleArray;
			}

	
	
	 public class ConversionResults{
		 private double kilogram,gram,miligram,ton,pond,ounce,carat,AtomicMassUnit,grain,quarterUS,quarterUK,stoneUS,stoneUK;

		public double getKilogram() {
			return kilogram;
		}

		public void setKilogram(double kilogram) {
			this.kilogram = kilogram;
		}

		public double getGram() {
			return gram;
		}

		public void setGram(double gram) {
			this.gram = gram;
		}

		public double getMiligram() {
			return miligram;
		}

		public void setMiligram(double miligram) {
			this.miligram = miligram;
		}

		public double getTon() {
			return ton;
		}

		public void setTon(double ton) {
			this.ton = ton;
		}

		public double getPond() {
			return pond;
		}

		public void setPond(double pond) {
			this.pond = pond;
		}

		public double getOunce() {
			return ounce;
		}

		public void setOunce(double ounce) {
			this.ounce = ounce;
		}

		public double getCarat() {
			return carat;
		}

		public void setCarat(double carat) {
			this.carat = carat;
		}

		public double getAtomicMassUnit() {
			return AtomicMassUnit;
		}

		public void setAtomicMassUnit(double atomicMassUnit) {
			AtomicMassUnit = atomicMassUnit;
		}

		public double getGrain() {
			return grain;
		}

		public void setGrain(double grain) {
			this.grain = grain;
		}

		public double getQuarterUS() {
			return quarterUS;
		}

		public void setQuarterUS(double quarterUS) {
			this.quarterUS = quarterUS;
		}

		public double getQuarterUK() {
			return quarterUK;
		}

		public void setQuarterUK(double quarterUK) {
			this.quarterUK = quarterUK;
		}

		public double getStoneUS() {
			return stoneUS;
		}

		public void setStoneUS(double stoneUS) {
			this.stoneUS = stoneUS;
		}

		public double getStoneUK() {
			return stoneUK;
		}

		public void setStoneUK(double stoneUK) {
			this.stoneUK = stoneUK;
		}
		 
		
		 
	 }
		   

}
