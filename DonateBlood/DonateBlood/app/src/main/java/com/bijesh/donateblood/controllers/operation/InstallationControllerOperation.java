package com.bijesh.donateblood.controllers.operation;


import com.bijesh.donateblood.controllers.operationdata.InstallationControllerOperationData;
import com.bijesh.donateblood.models.ui.Operation;

/**
 * Created by Bijesh
 */
public class InstallationControllerOperation extends Operation {

    public InstallationControllerOperation(int id, int state) {
        super(id, state);
        mData = new InstallationControllerOperationData();
    }

    @Override
    public String getInformation() {
        if (mData == null)
            return "";
        return ((InstallationControllerOperationData)mData).getMessage();
    }

    @Override
    public void setInformation(String message) {
        ((InstallationControllerOperationData)mData).setMessage(message);
        setChanged();
        notifyObservers(this);
    }
}
