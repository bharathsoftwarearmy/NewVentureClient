package com.bijesh.donateblood.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bijesh.donateblood.R;
import com.bijesh.donateblood.fragments.FirstNameFragment;
import com.bijesh.donateblood.models.ui.RequestDonor;
import com.bijesh.donateblood.models.ui.Validator;
import com.bijesh.donateblood.utils.ValidationUtils;


/**
 * Created by Bijesh on 23-05-2015.
 */
public class NeedActivity extends AppCompatActivity {

    private static final String TAG = NeedActivity.class.getCanonicalName();

    private Toolbar mToolBar;
    private Button mBtnRequest;
    private EditText mEdtEmail;
    private EditText mEdtPhone;
    private EditText mEdtName;
    private EditText mEdtDesc, mEdtCity, mEdtCountry;
    private Spinner mSpinBGroup;
    private String mBloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_new);

        init();

    }

    private void init(){
        initToolBar();
//        initComponents();
        initComps();
    }

    private void initToolBar(){
        mToolBar = (Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "toolbar clicked ");
                finish();
            }
        });
    }

    private void initComps(){
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,new FirstNameFragment(),"FirstName").commit();
    }

    @Deprecated
    private void initComponents(){
        mBtnRequest = (Button) findViewById(R.id.btnRegister);

        mBtnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestDonor requestDonor = populateRequestDonor();
                Validator validator = ValidationUtils.validateRequestDonorScreen(requestDonor);
                if(validator.isFlag()) {

                }else{
                    Toast.makeText(NeedActivity.this,validator.getMessage(),Toast.LENGTH_LONG).show();
                    return;
                }
//                Toast.makeText(NeedActivity.this, "Request is sent", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        mEdtEmail = (EditText) findViewById(R.id.edtTxtEmail);
        mEdtPhone = (EditText) findViewById(R.id.edtTxtMobile);
        mEdtName = (EditText) findViewById(R.id.edtTxtName);
        mEdtDesc = (EditText) findViewById(R.id.edtTxtDesc);
        mEdtCity = (EditText) findViewById(R.id.edtTxtCity);
        mEdtCountry = (EditText) findViewById(R.id.edtTxtCountry);




        mSpinBGroup = (Spinner)findViewById(R.id.spinnerBloodGroup);
        mSpinBGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mBloodGroup = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    private RequestDonor populateRequestDonor(){
        RequestDonor requestDonor = null;
        String email = mEdtEmail.getText().toString();
        String phone = mEdtPhone.getText().toString();
        String name = mEdtName.getText().toString();
        String city = mEdtCity.getText().toString();
        String country = mEdtCountry.getText().toString();
        String desc = mEdtDesc.getText().toString();

        Log.d(TAG,"Request Donor email "+email+" phone "+phone+" bg "+mBloodGroup+" city "+city+" country "+country);
        requestDonor = new RequestDonor(email,phone,name,mBloodGroup,desc,city,country);

        return requestDonor;
    }

}
