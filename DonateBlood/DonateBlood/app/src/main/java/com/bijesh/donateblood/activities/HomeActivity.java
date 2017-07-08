package com.bijesh.donateblood.activities;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.bijesh.donateblood.R;
import com.bijesh.donateblood.cloudmessaging.QuickstartPreferences;
import com.bijesh.donateblood.cloudmessaging.RegistrationIntentService;
import com.bijesh.donateblood.fragments.HomeFragment;
import com.bijesh.donateblood.fragments.NavigationDrawerFragment;
import com.bijesh.donateblood.utils.cloud.PushServiceUtils;


import org.json.JSONObject;

import java.util.List;

/**
 * Created by bijesh on 5/13/2015.
 */
public class HomeActivity extends AppCompatActivity {


    private static final String TAG = HomeActivity.class.getCanonicalName();
    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mMainFrameLayout;
    private String pushMessage;
    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);


//        set tool bar here
        mToolBar = (Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolBar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        set navigation drawer here
        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().
                findFragmentById(R.id.fragment_nav_drawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationDrawerFragment.setUp(R.id.fragment_nav_drawer,mDrawerLayout, mToolBar);



        mMainFrameLayout = (FrameLayout) findViewById(R.id.home_container);
        init();

//        showPushMessage();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                ParsePush.subscribeInBackground("Donate");
//                Log.d(TAG,"$$$ before subscribing to Donate channel");
//
//                ParsePush.subscribeInBackground("Donate", new SaveCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if (e == null) {
//                            Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
//                        } else {
//                            Log.e("com.parse.push", "failed to subscribe for push", e);
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        }).start();


//        sendPush();

//        initGCM();

    }


    private void showPushMessage(){
        try{
            Bundle b = getIntent().getExtras();
            JSONObject jsonObject = new JSONObject(b.getString("com.parse.Data"));
            Toast.makeText(getApplicationContext(), "" + jsonObject.getString("alert"), Toast.LENGTH_LONG).show();
            pushMessage = jsonObject.getString("alert");
            Log.d(TAG,"pushMessage "+pushMessage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void init(){
        HomeFragment fragment = new HomeFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.home_container,fragment);
        fragmentTransaction.commit();

    }

    public String getPushMessage(){
        return pushMessage;
    }

    private void initGCM(){
//        ParseInstallation.getCurrentInstallation().put("")

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {
//                    mInformationTextView.setText(getString(R.string.gcm_send_message));
                    Log.d(TAG,"$$$ Token sent successfully");
                } else {
//                    mInformationTextView.setText(getString(R.string.token_error_message));
                    Log.e(TAG,"$$$ error in sending token");
                }
            }
        };

        if(PushServiceUtils.checkPlayServices(this)){
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        if(mDrawerLayout != null){
            mDrawerLayout.closeDrawers();
        }
    }
}
