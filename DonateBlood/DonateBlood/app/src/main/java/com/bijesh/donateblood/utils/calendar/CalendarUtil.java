package com.bijesh.donateblood.utils.calendar;

import android.util.Log;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by bijesh on 6/4/2015.
 */
public class CalendarUtil {

    private static final String TAG = CalendarUtil.class.getCanonicalName();

    public static String getDeviceTimeZone(){
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        String retString = timeZone.getTimeZone(timeZone.getID()).getID();
        return retString;
    }

}
