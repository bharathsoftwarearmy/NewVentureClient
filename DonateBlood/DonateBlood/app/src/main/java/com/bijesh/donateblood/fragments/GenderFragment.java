package com.bijesh.donateblood.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bijesh.donateblood.R;

import at.markushi.ui.CircleButton;

/**
 * Created by Bijesh on 25-08-2015.
 */
public class GenderFragment extends Fragment {

    private static final String TAG = GenderFragment.class.getCanonicalName();

    private CircleButton circleButtonMale,circleButtonFemale;

    private boolean isMale;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gender, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){

        circleButtonMale = (CircleButton)view.findViewById(R.id.circleButtonMale);
        circleButtonFemale = (CircleButton) view.findViewById(R.id.circleButtonFeMale);

        // setting the background image for circle button
        circleButtonMale.setImageResource(R.drawable.ic_action_tick);
        isMale = true;
        circleButtonMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               isMale = true;
                circleButtonMale.setImageResource(R.drawable.ic_action_tick);
                circleButtonFemale.setImageResource(0);
            }
        });

        circleButtonFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMale = false;
                circleButtonMale.setImageResource(0);
                circleButtonFemale.setImageResource(R.drawable.ic_action_tick);
            }
        });

    }

}
