package com.nineinfosys.android.weightlosscalculators.DashBord;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;


/**
 * Created by Dev on 12-01-2017.
 */

public class DashBord extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dashbord, null);
        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Home");




        return v;
    }

}
