package com.nineinfosys.android.weightlosscalculators.Weight;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nineinfosys.android.weightlosscalculators.R;

import java.text.DecimalFormat;
import java.util.List;

import static android.widget.Toast.*;

/**
 * Created by Dev on 18-01-2017.
 */

public class WeightLossConversionAdapter extends RecyclerView.Adapter<WeightLossConversionAdapter.ListViewHolder> {

    Context context;
    LayoutInflater inflater;
    private List<weightlossCalcualtion.ConversionResults> results;
    weightlossCalcualtion.ConversionResults result;
    String conversionType;



    public WeightLossConversionAdapter(Context context2, List<weightlossCalcualtion.ConversionResults> results, String conversionType) {
        this.context = context2;
        this.results = results;
        this.conversionType=conversionType;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_conversion_item, parent, false);

        return new ListViewHolder(convertView);

    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
       /* int i ;

        int length = results.size();
        for( i = 1; i <length; i++) {*/

        result = results.get(position);

        switch (conversionType)
        {


            case "Kilogram":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
                //holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit())+" : ");


                break;
            case "Gram":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));

                break;
            case "Miligram":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));

                break;
            case "Ton":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Pound":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Ounce":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Carat":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
              //  holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Atomic Mass Unit":
                //setting value to textview
                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
                //holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Grain":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));


                break;
            case "Quarter US":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
              //  holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Quarter UK":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
              //  holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Stone US":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
              //  holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));
                break;
            case "Stone UK":
                //setting value to textview

                holder.textViewkg.setText(new DecimalFormat("##.############").format(result.getKilogram())+" : ");
                holder.textViewgram.setText(new DecimalFormat("##.############").format(result.getGram())+" : ");
                holder.textViewmiligram.setText(new DecimalFormat("##.############").format(result.getMiligram())+" : ");
                holder.textViewton.setText(new DecimalFormat("##.############").format(result.getTon())+" : ");
                holder.textViewpond.setText(new DecimalFormat("##.############").format(result.getPond())+" : ");
                holder.textViewounce.setText(new DecimalFormat("##.############").format(result.getOunce())+" : ");
                holder.textViewcarat.setText(new DecimalFormat("##.############").format(result.getCarat())+" : ");
                holder.textViewgrain.setText(new DecimalFormat("##.############").format(result.getGrain())+" : ");
                holder.textViewquarterUS.setText(new DecimalFormat("##.############").format(result.getQuarterUS())+" : ");
                holder.textViewquarterUK.setText(new DecimalFormat("##.############").format(result.getQuarterUK())+" : ");
                holder.textViewstoneUS.setText(new DecimalFormat("##.############").format(result.getStoneUS())+" : ");
                holder.textViewstoneUK.setText(new DecimalFormat("##.############").format(result.getStoneUK())+" : ");
               // holder.textViewAtomicMassUnit.setText(new DecimalFormat("##.############").format(result.getAtomicMassUnit()));

                break;

        }




    }


    @Override
    public int getItemCount() {
        return results.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView textViewkg,textViewgram,textViewmiligram,textViewton,textViewpond,textViewounce,textViewcarat,textViewAtomicMassUnit,textViewgrain,textViewquarterUS,textViewquarterUK,textViewstoneUS,textViewstoneUK;
        ImageView iv_delete;

        public ListViewHolder(View itemView) {
            super(itemView);
            textViewkg = (TextView) itemView.findViewById(R.id.conversionunitvaluekg);
            textViewgram = (TextView) itemView.findViewById(R.id.conversionunitvaluegram);
            textViewmiligram = (TextView) itemView.findViewById(R.id.conversionunitmiligram);
            textViewton = (TextView) itemView.findViewById(R.id.conversionunitton);
            textViewpond = (TextView) itemView.findViewById(R.id.conversionunitpond);
            textViewounce = (TextView) itemView.findViewById(R.id.conversionunitounce);
            textViewcarat = (TextView) itemView.findViewById(R.id.conversionunitcarat);
           // textViewAtomicMassUnit = (TextView) itemView.findViewById(R.id.conversionunitAtomicMassUnit);
            textViewgrain = (TextView) itemView.findViewById(R.id.conversionunitgrain);
            textViewquarterUS = (TextView) itemView.findViewById(R.id.conversionunitquarterUS);
            textViewquarterUK = (TextView) itemView.findViewById(R.id.conversionunitquarterUk);
            textViewstoneUS = (TextView) itemView.findViewById(R.id.conversionunitstoneUS);
            textViewstoneUK = (TextView) itemView.findViewById(R.id.conversionunitstoneUK);


        }
    }


}
