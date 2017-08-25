package com.bijesh.donateblood.activities;


import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;


import com.bijesh.donateblood.R;
import com.bijesh.donateblood.fragments.HomeFragment;
import com.bijesh.donateblood.fragments.NavigationDrawerFragment;

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



    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        if(mDrawerLayout != null){
            mDrawerLayout.closeDrawers();
        }
    }
}
