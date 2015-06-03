package com.bijesh.donateblood.controllers.operationdata;


import com.bijesh.donateblood.httpwrapper.impl.Response;

/**
 * Created by Bijesh
 */
public class InstallationControllerOperationData {
    private String mMessage = "";
    private Response mResponseData;

    public void setMessage(String aMessage) {
        mMessage = aMessage;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setData(Response obj) {
        mResponseData =  obj;
    }

    public Response getData() { return mResponseData; }
}
