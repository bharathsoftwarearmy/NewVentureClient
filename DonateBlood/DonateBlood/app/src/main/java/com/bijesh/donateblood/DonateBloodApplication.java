
package com.bijesh.donateblood;

import android.app.Application;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

import com.bijesh.donateblood.activities.HomeActivity;
import com.bijesh.donateblood.controllers.RestResponseHandlerThread;
import com.bijesh.donateblood.httpwrapper.RestClientFactory;
import com.bijesh.donateblood.httpwrapper.impl.DonateBloodRestClient;

/**
 * Created by bijesh on 5/21/2015.
 */
public class DonateBloodApplication extends Application {

    private static DonateBloodApplication mInstance;
    private static final String TAG = DonateBloodApplication.class.getCanonicalName();
    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

//        Volley init
        DonateBloodRestClient lClient = (DonateBloodRestClient) RestClientFactory.getDefaultRestClient();
        lClient.init(this);
        RestResponseHandlerThread.init();




//        // Enable Local Datastore.
//        Parse.enableLocalDatastore(this);
//
//        Parse.initialize(this, "KJfdKjZnGbTBX1OzEcvIWIehgxsr2G46f0DLAGar", "o2zXEa0uO27sdSIwu9TXczWe2rEAfJ23wtuSBvVD");
//
//
//
////        ParseACL defaultAcl = new ParseACL();
////        defaultAcl.setPublicReadAccess(true);
////        ParseACL.setDefaultACL(defaultAcl, true);
//
//        PushService.setDefaultPushCallback(this, HomeActivity.class);
//        ParseInstallation.getCurrentInstallation().getInstallationId();
//
//
//        handler = new Handler();
//        ParseInstallation.getCurrentInstallation().saveEventually();
//
//
//
//       registerPushService();


    }

    private void registerPushService() {

        final String androidId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);


        // Post the uniqueId delayed

        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                }
                            }, 10000
        );


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 20000);
    }

    public synchronized static DonateBloodApplication getInstance() {
        return mInstance;
    }


}
