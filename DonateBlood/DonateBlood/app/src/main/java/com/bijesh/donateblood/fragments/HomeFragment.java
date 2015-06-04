package com.bijesh.donateblood.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bijesh.donateblood.DonateBloodApplication;
import com.bijesh.donateblood.R;
import com.bijesh.donateblood.activities.HomeActivity;
import com.bijesh.donateblood.controllers.InstallationController;
import com.bijesh.donateblood.controllers.UIInterface;
import com.bijesh.donateblood.models.ui.Installation;
import com.bijesh.donateblood.models.ui.Operation;
import com.bijesh.donateblood.storage.singleton.PreviousRequest;
import com.bijesh.donateblood.utils.calendar.CalendarUtil;
import com.bijesh.donateblood.utils.calendar.TimeFormatUtil;
import com.bijesh.donateblood.utils.phone.PhoneUtils;

/**
 * Created by Bijesh on 23-05-2015.
 */
public class HomeFragment extends Fragment implements UIInterface {

    private static final String TAG = HomeFragment.class.getCanonicalName();
    private TextView mTxtViewStatus;
    private TextView mTxtViewMessages;
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_home, container, false);
        init(retView);
        return retView;
    }

    private void init(View view){
        mTxtViewStatus = (TextView)view.findViewById(R.id.txtViewQuote);
        mTxtViewMessages = (TextView) view.findViewById(R.id.txtViewPushRequests);
        mTxtViewMessages.setMovementMethod(new ScrollingMovementMethod());



        mTxtViewMessages.setText(getMessage());
        requestWebService();
    }

    private void requestWebService(){
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Installation installation = new Installation();
                installation.setUniqueId(PhoneUtils.getUniqueId(DonateBloodApplication.getInstance()));
                installation.setTime(TimeFormatUtil.timeFormat(System.currentTimeMillis()));
                installation.setTimezone(CalendarUtil.getDeviceTimeZone());
                InstallationController.instance().intallationProcess(getActivity(), installation);
            }
        },700);
    }

    private String getMessage(){
        HomeActivity homeActivity = (HomeActivity)getActivity();
        StringBuilder builder = new StringBuilder();
        if(homeActivity.getPushMessage() != null) {
            builder.append(homeActivity.getPushMessage());
        }
        if(PreviousRequest.INS.getPreviousMessages() != null){
            for(String previousMessage:PreviousRequest.INS.getPreviousMessages()) {
                if(previousMessage != null)
                  builder.append("\n\n" + previousMessage);
            }
        }
        PreviousRequest.INS.setPreviousMessage(homeActivity.getPushMessage());
        return builder.toString();
    }

    @Override
    public void onProgress(Operation opr) {

    }

    @Override
    public void onError(Operation opr) {

    }

    @Override
    public void onSuccess(Operation opr) {

    }
}
