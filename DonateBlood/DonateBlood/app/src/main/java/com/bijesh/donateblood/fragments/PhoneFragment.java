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
 * Created by Bijesh on 25-08-2015.
 */
public class PhoneFragment extends Fragment {

    private EditText mEdtTxtPhone;

    public PhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view){
        TextView txtNext = (TextView) view.findViewById(R.id.txtNext);
        mEdtTxtPhone = (EditText) view.findViewById(R.id.edtPhone);
        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, new GenderFragment(), "GenderFrag");
                transaction.addToBackStack("GenderFrag");
                transaction.commit();
                DonateSharedPrefs.getInstance(getActivity()).setStringData(DonateSharedPrefs.PHONE, mEdtTxtPhone.getText().toString());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        String phone = DonateSharedPrefs.getInstance(getActivity()).getStringData(DonateSharedPrefs.PHONE,null);
        if(phone != null){
            mEdtTxtPhone.setText(phone);
        }
    }

}
