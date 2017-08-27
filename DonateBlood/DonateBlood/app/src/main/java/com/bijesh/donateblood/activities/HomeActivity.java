package com.bijesh.donateblood.activities;


import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;


import com.bijesh.donateblood.R;
import com.bijesh.donateblood.adapters.DrawerItemCustomAdapter;
import com.bijesh.donateblood.fragments.HomeFragment;
import com.bijesh.donateblood.fragments.NavigationDrawerFragment;
import com.bijesh.donateblood.fragments.RegisterFragment;
import com.bijesh.donateblood.models.ui.NavigationModel;

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
    private ListView mDrawerList;
    private String[] mNavigationDrawerItemTitles;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);


//        set tool bar here
        mToolBar = (Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);

//        set navigation drawer here
//        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().
//                findFragmentById(R.id.fragment_nav_drawer);
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        navigationDrawerFragment.setUp(R.id.fragment_nav_drawer,mDrawerLayout, mToolBar);

         setupNavigationDrawer();


        mMainFrameLayout = (FrameLayout) findViewById(R.id.home_container);
        init();

    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,mToolBar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    private void setupNavigationDrawer(){

        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        NavigationModel[] drawerItem = new NavigationModel[3];

        drawerItem[0] = new NavigationModel( "Register");
        drawerItem[1] = new NavigationModel( "Request Donors");
        drawerItem[2] = new NavigationModel( "About");

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.navigation_row_item, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }


    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new RegisterFragment();
                break;
            case 1:
//                fragment = new FixturesFragment();
                break;
            case 2:
//                fragment = new TableFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.home_container, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("NavigationHomeActivity", "Error in creating fragment");
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
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
