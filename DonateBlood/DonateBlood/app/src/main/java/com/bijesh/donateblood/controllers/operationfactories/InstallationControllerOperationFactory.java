package com.bijesh.donateblood.controllers.operationfactories;

import com.bijesh.donateblood.controllers.operation.InstallationControllerOperation;
import com.bijesh.donateblood.models.ui.Operation;

/**
 * Created by bijesh on 6/3/2015.
 */
public class InstallationControllerOperationFactory implements OperationFactory {
    private static InstallationControllerOperationFactory mInstance = null;

    private InstallationControllerOperationFactory() {

    }

    public static InstallationControllerOperationFactory instance() {
        if (mInstance == null) {
            mInstance = new InstallationControllerOperationFactory();
        }
        return mInstance;
    }

    @Override
    public Operation createOperation(int id, int state) {
        return new InstallationControllerOperation(id, state);
    }
}
