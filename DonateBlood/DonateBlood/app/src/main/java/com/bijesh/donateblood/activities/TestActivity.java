package com.bijesh.donateblood.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.bijesh.donateblood.R;
import com.bijesh.donateblood.utils.calendar.CalendarUtil;
import com.bijesh.donateblood.utils.calendar.TimeFormatUtil;

/**
 * Created by bijesh on 6/4/2015.
 */
public class TestActivity extends ActionBarActivity {

    private static final String TAG = TestActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        Log.d(TAG, "time zone "+ CalendarUtil.getDeviceTimeZone());
    }
}
