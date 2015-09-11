package com.bijesh.donateblood.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bijesh.donateblood.R;

import at.markushi.ui.CircleButton;

/**
 * Created by Bijesh on 06-09-2015.
 */
public class BloodGroupFragment extends Fragment {


    private CircleButton mCBAPositive,mCBANegative,mCBBPositive,mCBBNegative;
    private CircleButton mCBOPositive,mCBONegative,mCBABPositive,mCBABNegative;
    private CircleButton mCBA1Positive,mCBA1Negative,mCBA1BPositive,mCBA1BNegative;

    public BloodGroupFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bloodgroup, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        mCBAPositive = (CircleButton) view.findViewById(R.id.circleButtonAPositive);
        mCBAPositive.setImageResource(R.drawable.apositive);

        mCBANegative = (CircleButton) view.findViewById(R.id.circleButtonANegative);
        mCBANegative.setImageResource(R.drawable.anegative);

        mCBBPositive = (CircleButton) view.findViewById(R.id.circleButtonBPositive);
        mCBBPositive.setImageResource(R.drawable.bpositive);

        mCBBNegative = (CircleButton) view.findViewById(R.id.circleButtonBNegative);
        mCBBNegative.setImageResource(R.drawable.bnegative);

        mCBOPositive = (CircleButton) view.findViewById(R.id.circleButtonOPositive);
        mCBOPositive.setImageResource(R.drawable.opositive);

        mCBONegative = (CircleButton) view.findViewById(R.id.circleButtonONegative);
        mCBONegative.setImageResource(R.drawable.onegative);

        mCBABPositive = (CircleButton) view.findViewById(R.id.circleButtonABPositive);
        mCBABPositive.setImageResource(R.drawable.abpositive);

        mCBABNegative = (CircleButton) view.findViewById(R.id.circleButtonABNegative);
        mCBABNegative.setImageResource(R.drawable.abnegative);

        mCBA1Positive = (CircleButton) view.findViewById(R.id.circleButtonA1Positive);
        mCBA1Positive.setImageResource(R.drawable.a1positive);

        mCBA1Negative = (CircleButton) view.findViewById(R.id.circleButtonA1Negative);
        mCBA1Negative.setImageResource(R.drawable.a1negative);

        mCBA1BPositive = (CircleButton) view.findViewById(R.id.circleButtonA1BPositive);
        mCBA1BPositive.setImageResource(R.drawable.a1bpositive);

        mCBA1BNegative = (CircleButton) view.findViewById(R.id.circleButtonA1BNegative);
        mCBA1BNegative.setImageResource(R.drawable.a1bnegative);

        

    }

}
