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
public class BloodGroupFragment extends Fragment implements View.OnClickListener{


    private CircleButton mCBAPositive,mCBANegative,mCBBPositive,mCBBNegative;
    private CircleButton mCBOPositive,mCBONegative,mCBABPositive,mCBABNegative;
    private CircleButton mCBA1Positive,mCBA1Negative,mCBA1BPositive,mCBA1BNegative;

    private CircleButton[] mCircleButtonViews;

    private int[] mResourceIds = {
            R.drawable.s_apositive,R.drawable.s_anegative,R.drawable.s_bpositive,R.drawable.s_bnegative,R.drawable.s_opositive,
            R.drawable.s_onegative,R.drawable.s_abpositive,R.drawable.s_abnegative,R.drawable.s_a1positive,R.drawable.s_a1negative,
            R.drawable.s_a1bpositive,R.drawable.s_a1bnegative
    };


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


        mCircleButtonViews = new CircleButton[]{
                mCBAPositive,mCBANegative,mCBBPositive,mCBBNegative,
                mCBOPositive,mCBONegative,mCBABPositive,mCBABNegative,
                mCBA1Positive,mCBA1Negative,mCBA1BPositive,mCBA1BNegative
        };


        setUpClickListeners();



    }

    private void setUpClickListeners(){

        mCBAPositive.setOnClickListener(this);
        mCBANegative.setOnClickListener(this);
        mCBBPositive.setOnClickListener(this);
        mCBBNegative.setOnClickListener(this);
        mCBOPositive.setOnClickListener(this);
        mCBONegative.setOnClickListener(this);
        mCBABPositive.setOnClickListener(this);
        mCBABNegative.setOnClickListener(this);
        mCBA1Positive.setOnClickListener(this);
        mCBA1Negative.setOnClickListener(this);
        mCBA1BPositive.setOnClickListener(this);
        mCBA1BNegative.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.circleButtonAPositive:
//               mCBAPositive.setImageResource(R.drawable.s_apositive);
               setBackgroundResources(mCircleButtonViews,0);
               break;
           case R.id.circleButtonANegative:
//               mCBANegative.setImageResource(R.drawable.s_anegative);
               setBackgroundResources(mCircleButtonViews,1);
               break;
           case R.id.circleButtonBPositive:
               setBackgroundResources(mCircleButtonViews,2);
               break;
           case R.id.circleButtonBNegative:
               setBackgroundResources(mCircleButtonViews,3);
               break;
           case R.id.circleButtonOPositive:
               setBackgroundResources(mCircleButtonViews,4);
               break;
           case R.id.circleButtonONegative:
               setBackgroundResources(mCircleButtonViews,5);
               break;
           case R.id.circleButtonABPositive:
               setBackgroundResources(mCircleButtonViews,6);
               break;
           case R.id.circleButtonABNegative:
               setBackgroundResources(mCircleButtonViews,7);
               break;
           case R.id.circleButtonA1Positive:
               setBackgroundResources(mCircleButtonViews,8);
               break;
           case R.id.circleButtonA1Negative:
               setBackgroundResources(mCircleButtonViews,9);
               break;
           case R.id.circleButtonA1BPositive:
               setBackgroundResources(mCircleButtonViews,10);
               break;
           case R.id.circleButtonA1BNegative:
               setBackgroundResources(mCircleButtonViews,11);
               break;
       }
    }

    /**
     * Follow the same ordinal to set the background resources, dont change the order of the views, if any new
     * views come up in future add to the end.
     * @param cusCircleButtons
     * @param whichCircleSelected
     */
    private void setBackgroundResources(CircleButton[] cusCircleButtons,int whichCircleSelected){
         for(int i=0;i<cusCircleButtons.length;i++){
             if(i == 0){
                 cusCircleButtons[i].setImageResource(R.drawable.apositive);
             }else if(i == 1){
                 cusCircleButtons[i].setImageResource(R.drawable.anegative);
             }else if (i == 2){
                 cusCircleButtons[i].setImageResource(R.drawable.bpositive);
             }else if(i == 3){
                 cusCircleButtons[i].setImageResource(R.drawable.bnegative);
             }else if(i == 4){
                 cusCircleButtons[i].setImageResource(R.drawable.opositive);
             }else if(i == 5){
                 cusCircleButtons[i].setImageResource(R.drawable.onegative);
             }else if(i == 6){
                 cusCircleButtons[i].setImageResource(R.drawable.abpositive);
             }else if(i == 7){
                 cusCircleButtons[i].setImageResource(R.drawable.abnegative);
             }else if (i == 8){
                  cusCircleButtons[i].setImageResource(R.drawable.a1positive);
             }else if(i == 9){
                 cusCircleButtons[i].setImageResource(R.drawable.a1negative);
             }else if(i == 10){
                 cusCircleButtons[i].setImageResource(R.drawable.a1bpositive);
             }else if(i == 11){
                 cusCircleButtons[i].setImageResource(R.drawable.a1bnegative);
             }
         }

//        setting the selected button
          cusCircleButtons[whichCircleSelected].setImageResource(mResourceIds[whichCircleSelected]);

    }

}
