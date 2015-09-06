package com.bijesh.donateblood.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bijesh.donateblood.R;
import com.bijesh.donateblood.storage.DonateSharedPrefs;

/**
 * Created by Bijesh on 24-08-2015.
 */
public class EmailFragment extends Fragment {

    private EditText mEdtTxtEmail;

    public EmailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        TextView txtNext = (TextView) view.findViewById(R.id.txtNext);
        mEdtTxtEmail = (EditText) view.findViewById(R.id.edtFirstName);
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, new PhoneFragment(), "PhoneFrag");
                transaction.addToBackStack("PhoneFrag");
                transaction.commit();

                DonateSharedPrefs.getInstance(getActivity()).setStringData(DonateSharedPrefs.EMAIL, mEdtTxtEmail.getText().toString());
            }
        });
    }

}

