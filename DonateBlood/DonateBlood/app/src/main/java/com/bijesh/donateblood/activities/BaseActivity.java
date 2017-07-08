package com.bijesh.donateblood.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bijesh.donateblood.storage.DonateSharedPrefs;

/**
 * Created by Bijesh on 7/8/2017.
 */

public class BaseActivity extends AppCompatActivity{

    String[] preferences = {DonateSharedPrefs.FIRST_NAME,DonateSharedPrefs.EMAIL,DonateSharedPrefs.PHONE,DonateSharedPrefs.GENDER};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void clearPreferences(){
        /**
         * Use builder pattern to clear which type of preference to clear. As of now clear all the preferences
         */
       for(String pref:preferences){
           DonateSharedPrefs.getInstance(this).getSharedPreferences().edit().remove(pref).commit();
       }

    }

}
