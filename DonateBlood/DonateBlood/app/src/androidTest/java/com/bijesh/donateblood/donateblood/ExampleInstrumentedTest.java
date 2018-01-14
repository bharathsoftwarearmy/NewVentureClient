package com.bijesh.donateblood.donateblood;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.bijesh.donateblood.utils.phone.PhoneUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.bijesh.donateblood.donateblood", appContext.getPackageName());
    }


    @Test
    public void testPhoneUtils() throws Exception{
        Context appContext = InstrumentationRegistry.getTargetContext();
        String email = PhoneUtils.getPrimaryEmailAddress(appContext);
        assertNotNull(email);
    }

}