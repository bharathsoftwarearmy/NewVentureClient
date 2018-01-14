package com.bijesh.donateblood.fragments;


import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bijesh.donateblood.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_register, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        getActivity().getSupportFragmentManager().beginTransaction().
                add(R.id.fragmentContainer,new FirstNameFragment(),"FirstName").commit();
    }

    private void getLocation(){

    }



}
