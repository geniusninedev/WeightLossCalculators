package com.nineinfosys.android.weightlosscalculators.Weight;

/**
 * Created by Divya on 28-02-2017.
 */

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;

import java.util.ArrayList;
import java.util.List;

public class WeightLossConversionList extends Fragment {
    RecyclerView recyclerViewAmortization;
    WeightLossConversionAdapter weightLossConversionAdapter;
    int i=1;
    double edtextvalue;
    List<weightlossCalcualtion.ConversionResults> results = new ArrayList<>();
    EditText editTextvalue;
    Spinner spinnerConversionType;
    Button buttonCalcualte,buttonMoreInfo;
    String strConversiontype;
    WebView Introwebview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_weight_conversion, null);

        MobileAds.initialize(getActivity(), getString(R.string.ads_app_id));
        AdView mAdView = (AdView) v.findViewById(R.id.adViewMainPageWeight);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Weight Conversion");
        editTextvalue=(EditText)v.findViewById(R.id.edtvalue);
        spinnerConversionType=(Spinner)v.findViewById(R.id.spinnerconversiontype);
        buttonCalcualte=(Button)v.findViewById(R.id.buttonCalculate);
        buttonMoreInfo = (Button) v.findViewById(R.id.buttonMoreInfo);
        recyclerViewAmortization=(RecyclerView)v.findViewById(R.id.recyclerViewAmortization);
        recyclerViewAmortization.setHasFixedSize(true);
        recyclerViewAmortization.setLayoutManager(new GridLayoutManager(getActivity(),1));



        //adding value to sppiner paid type
        List<String> listConversiontype = new ArrayList<String>();
        listConversiontype.add("Kilogram");
        listConversiontype.add("Gram");
        listConversiontype.add("Miligram");
        listConversiontype.add("Ton");
        listConversiontype.add("Pound");
        listConversiontype.add("Ounce");
        listConversiontype.add("Carat");
        listConversiontype.add("Grain");
        listConversiontype.add("Quarter US");
        listConversiontype.add("Quarter UK");
        listConversiontype.add("Stone US");
        listConversiontype.add("Stone UK");
     //   listConversiontype.add("Atomic Mass Unit");
        // Creating adapter for spinner
        ArrayAdapter<String> Adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listConversiontype);

        // Drop down layout style - list view with radio button
        Adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnerConversionType.setAdapter(Adapter1);

        buttonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert Dialog Declaration For More Infomation
                final LayoutInflater inflaterMoreInfo = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View alertLayoutMoreInfo = inflaterMoreInfo.inflate(R.layout.info_webview, null);
                final AlertDialog.Builder alertDialogBuilderMoreInfo = new AlertDialog.Builder(getActivity());
                alertDialogBuilderMoreInfo.setTitle("More Info:");
                Introwebview = (WebView) alertLayoutMoreInfo.findViewById(R.id.webViewinfo);
                WebSettings IntroWebSettings = Introwebview.getSettings();
                IntroWebSettings.setBuiltInZoomControls(true);
                IntroWebSettings.setJavaScriptEnabled(true);
                Introwebview.setWebViewClient(new WebViewClient());
                Introwebview.loadUrl("file:///android_res/raw/weight.html");
                alertDialogBuilderMoreInfo.setView(alertLayoutMoreInfo);
                final AlertDialog alertDialogMoreInfo = alertDialogBuilderMoreInfo.create();
                alertDialogMoreInfo.show();
            }
        });
        buttonCalcualte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for hiding keyboard
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                if(editTextvalue.getText().toString().trim().equals("")){
                    editTextvalue.setError("Enter Value");

                }else{
                    converterCalcualtion();
                }

            }
        });




        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        //calculation method call for amortization
       return  v;
    }




    private void converterCalcualtion() {
        String stredittextvalue=editTextvalue.getText().toString();
        strConversiontype = spinnerConversionType.getSelectedItem().toString().trim();
        edtextvalue= Double.parseDouble(stredittextvalue);
        weightlossCalcualtion iA = new weightlossCalcualtion(edtextvalue,strConversiontype);
        results = iA.calculateWeightConversion();
      //  Log.d("Result", String.valueOf(results));
        weightLossConversionAdapter = new WeightLossConversionAdapter(getActivity(),results,strConversiontype);
        recyclerViewAmortization.setAdapter(weightLossConversionAdapter);




    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

        }
    }
    public class WebViewClient extends android.webkit.WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
