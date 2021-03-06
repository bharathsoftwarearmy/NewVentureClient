package com.bijesh.donateblood.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Bijesh on 23-05-2015.
 */
public class DonateSharedPrefs implements SharedPrefsConstants{


    private static final String TAG = DonateSharedPrefs.class.getCanonicalName();
    private static final String DONATE_BLOOD_PREFS = "DonateBloodPrefs";



    private static DonateSharedPrefs mInstance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private DonateSharedPrefs(Context context){
        mSharedPreferences = context.getSharedPreferences(DONATE_BLOOD_PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public static DonateSharedPrefs getInstance(Context context){
        if(mInstance == null){
            mInstance = new DonateSharedPrefs(context);
        }
        return mInstance;
    }

    public SharedPreferences getSharedPreferences(){
        return mSharedPreferences;
    }

    public void setStringData(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public String getStringData(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public void setLongData(String key,long value){
        mEditor.putLong(HAS_ALREADY_NOTIFIED_DONORS_RECENTLY,value);
        mEditor.commit();
    }

    public long getLongData(String key,long defValue){
        return mSharedPreferences.getLong(key,defValue);
    }

}
