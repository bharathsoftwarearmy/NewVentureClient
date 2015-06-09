package com.bijesh.donateblood.controllers;

import android.content.Context;
import android.util.Log;

import com.bijesh.donateblood.AppConstants;
import com.bijesh.donateblood.controllers.operationdata.InstallationControllerOperationData;
import com.bijesh.donateblood.controllers.operationfactories.InstallationControllerOperationFactory;
import com.bijesh.donateblood.controllers.operationfactories.OperationFactory;
import com.bijesh.donateblood.httpwrapper.RestClient;
import com.bijesh.donateblood.httpwrapper.impl.DonateBloodHttpRequest;
import com.bijesh.donateblood.httpwrapper.impl.Response;
import com.bijesh.donateblood.models.ui.BaseModel;
import com.bijesh.donateblood.models.ui.Installation;
import com.bijesh.donateblood.models.ui.InstallationModel;
import com.bijesh.donateblood.models.ui.Operation;
import com.bijesh.donateblood.utils.calendar.TimeFormatUtil;
import com.bijesh.donateblood.utils.phone.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by bijesh on 6/2/2015.
 */
public class InstallationController extends BaseController {

    private static final String TAG = InstallationController.class.getSimpleName();
    private static final int INSTALLATION_DATA_MODEL = 0;

    private static InstallationController mInstance = null;
    // INSTALLTION controller Operation Codes.
    private int SET_INSTALLATION_DATA = Operation.OperationCode.SET_INSTALLATION.ordinal();

    private OperationFactory mOperationFactory = InstallationControllerOperationFactory.instance();

    private static final int INSTALLATION_MODEL = 0;

    public static InstallationController instance() {
        if (mInstance == null)
            mInstance = new InstallationController();
        return mInstance;
    }

    private InstallationController(){
        super();
        mModels.add(new InstallationModel());
    }

    public BaseModel getInstallationModel(){
        return mModels.get(INSTALLATION_MODEL);
    }




    public void intallationProcess(Context context,Installation installation){
        if(mOperationsModel.addOperation(mOperationFactory.createOperation(SET_INSTALLATION_DATA,Operation.CREATED))){
            if (NetworkUtil.isNetworkAvailable(context)) {
                DonateBloodHttpRequest aHttpRequest = (DonateBloodHttpRequest)createRequest();
                String url = "http://192.168.56.1:8080/DonateBloodWeb/Installation";//"http://10.5.50.4:8080/DonateBloodWeb/Installation";
                aHttpRequest.setUrl(url);
                Log.d(TAG, "$$$ url "+url);
                HashMap<String, String> map = (HashMap<String, String>)aHttpRequest.getHeaders();
                if (map == null)
                    map = new HashMap<String, String>();
                map.put("operation", Integer.toString(SET_INSTALLATION_DATA));
                aHttpRequest.setMethod(RestClient.POST);
                aHttpRequest.setHeaders(map);
                aHttpRequest.setData(prepareBody(installation.getUniqueId(),installation.getTime(),installation.getTimezone()));
                aHttpRequest.setTag(TAG);
                submit(aHttpRequest);
                Operation opr = mOperationsModel.getOperation(SET_INSTALLATION_DATA);
                opr.setState(Operation.PENDING);
                onProgress(opr);
            }else{
                Operation opr = mOperationsModel.getOperation(SET_INSTALLATION_DATA);
                opr.setState(Operation.ERROR);
                ((InstallationControllerOperationData)opr.getData()).setMessage(AppConstants.NETWORK_ERROR);
                onError(opr);
            }
        }
    }


    private String prepareBody(String uniqueId,String time, String timezone) {
        // Stubbed parameter
        String str = "{"
                +    "\"Data\"" + ":"+ "{"
                +        "\"uniqueID\"" + ":" + "\""+ uniqueId +"\""+","
                +        "\"time\"" + ":" + "\""+time+"\""+","
                +        "\"timezone\""   + ":" + "\""+timezone+"\""
                +    "}"
                +"}";
        // Stub ended.
        return str;
    }

    @Override
    public void handleResponseForOperation(Response aResponse, Operation aOperation) {

        Log.d(TAG,"Operation "+aOperation.getId());
        JSONObject lData = aResponse.getData();
        try {
            if (aOperation.getId() == Operation.OperationCode.SET_INSTALLATION.ordinal()) {
                Log.d(TAG, "data here " + lData.getString("response"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    public void handleErrorForOperation(Response aResponse, Operation aOperation) {
        Log.d(TAG,"$$$$$$$$$ handleErrorForOperation");
        aOperation.setState(Operation.ERROR);
        aOperation.setInformation(aResponse.getResponseDescription());
        onError(aOperation);
        getInstallationModel().clear();
    }
}
