package com.bijesh.donateblood.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bijesh.donateblood.R;
import com.bijesh.donateblood.storage.DonateBloodFileStorage;

/**
 * Created by bijesh on 6/4/2015.
 */
public class TestActivity extends AppCompatActivity {

    private static final String TAG = TestActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        DonateBloodFileStorage.setStringData(this, "test1", "this is for test");
        Log.d(TAG,"$$$ onAct value is "+DonateBloodFileStorage.getStringData(this, "test1"));
//        Log.d(TAG, "time zone "+ CalendarUtil.getDeviceTimeZone());
    }
}
