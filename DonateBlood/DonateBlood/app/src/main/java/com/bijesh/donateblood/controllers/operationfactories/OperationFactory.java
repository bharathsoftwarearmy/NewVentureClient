package com.bijesh.donateblood.controllers.operationfactories;


import com.bijesh.donateblood.models.ui.Operation;

/**
 * Created by Bijesh
 */

public interface OperationFactory {
    Operation createOperation(int oprId, int oprState);
}
