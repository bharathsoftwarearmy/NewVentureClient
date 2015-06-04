package com.bijesh.donateblood.utils.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * Created by bijesh on 6/4/2015.
 */
public class TimeFormatUtil {

    static Format mDBFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String timeFormat(long timeInMillis){
        String dateAsString = mDBFormatter.format(timeInMillis);
        return dateAsString;
    }

}
