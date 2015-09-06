package com.bijesh.donateblood.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bijesh.donateblood.R;

/**
 * Created by Bijesh on 06-09-2015.
 */
public class BloodGroupFragment extends Fragment {



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

    }

}
