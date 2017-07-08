package com.bijesh.donateblood.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bijesh.donateblood.R;
import com.bijesh.donateblood.storage.DonateSharedPrefs;

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

        TextView txtNext = (TextView) view.findViewById(R.id.txtNext);

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, new BloodGroupFragment(), "BloodGroupFrag");
                transaction.addToBackStack("BloodGroupFrag");
                transaction.commit();

                String gender = isMale ? "Male": "Female";
                DonateSharedPrefs.getInstance(getActivity()).setStringData(DonateSharedPrefs.GENDER, gender);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        String gender = DonateSharedPrefs.getInstance(getActivity()).getStringData(DonateSharedPrefs.GENDER,"Male");
        if(gender != null){
            if(gender.equals("Male")){
                circleButtonMale.setImageResource(R.drawable.ic_action_tick);
                circleButtonFemale.setImageResource(0);
            }else{
                circleButtonMale.setImageResource(0);
                circleButtonFemale.setImageResource(R.drawable.ic_action_tick);
            }
        }
    }

}
