package com.nineinfosys.android.weightlosscalculators.DashBord;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.nineinfosys.android.weightlosscalculators.MainActivityDrawer;
import com.nineinfosys.android.weightlosscalculators.R;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


/**
 * Created by Dev on 12-01-2017.
 */

public class RateUs extends Fragment {
    private OrderApp orderApp;
    private EditText editTextdevice;
    private EditText editTextOS;
    private EditText editTextApplication;
    private EditText editTextIndustry;
    private EditText editTextAppDescription;
    private EditText editTextPhoneNumber;
    private EditText editTextContactEmail;
    private Button buttonGetQuote;

    //Azure Database connection for contact uploading
    private MobileServiceClient mobileServiceClientOrderApp;
    private MobileServiceTable<OrderApp> mobileServiceTableOrderApp;
    private FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_rate_us, null);
        ((MainActivityDrawer) getActivity()).toolbar.setTitle("Rate Us and Leave Feedback");




        return v;
    }
    private void initializeAzureTable() {
        try {
            mobileServiceClientOrderApp = new MobileServiceClient(
                    getString(R.string.web_address),
                   getActivity());
            mobileServiceClientOrderApp.setAndroidHttpClientFactory(new OkHttpClientFactory() {
                @Override
                public OkHttpClient createOkHttpClient() {
                    OkHttpClient client = new OkHttpClient();
                    client.setReadTimeout(20, TimeUnit.SECONDS);
                    client.setWriteTimeout(20, TimeUnit.SECONDS);
                    return client;
                }
            });
            mobileServiceTableOrderApp = mobileServiceClientOrderApp.getTable(OrderApp.class);


        } catch (MalformedURLException e) {

        } catch (Exception e) {

        }
    }
    private void uploadOrder() {
        firebaseAuth = FirebaseAuth.getInstance();
        orderApp = new OrderApp();
        orderApp.setFirebaseid(firebaseAuth.getCurrentUser().getUid());
        orderApp.setAppid(getString(R.string.app_id));
        orderApp.setDevice(editTextdevice.getText().toString());
        orderApp.setOs(editTextOS.getText().toString());
        orderApp.setApptype(editTextApplication.getText().toString());
        orderApp.setIndustry(editTextIndustry.getText().toString());
        orderApp.setDescription(editTextAppDescription.getText().toString());
        orderApp.setPhone(editTextPhoneNumber.getText().toString());
        orderApp.setEmail(editTextContactEmail.getText().toString());

        try {
            mobileServiceTableOrderApp.insert(orderApp);
            editTextdevice.setText("");
            editTextOS.setText("");
            editTextApplication.setText("");
            editTextIndustry.setText("");
            editTextAppDescription.setText("");
            editTextPhoneNumber.setText("");
            editTextContactEmail.setText("");

            Toast.makeText(getActivity(), "Submitted", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Log.e("feedback ", e.toString());
        }

    }
}
