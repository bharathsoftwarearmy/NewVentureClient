package com.bijesh.donateblood.utils.permissions;

import java.util.ArrayList;

/**
 * Created by Bijesh on 1/14/2018.
 */

public interface PermissionResultCallback {
    void PermissionGranted(int request_code);
    void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions);
    void PermissionDenied(int request_code);
    void NeverAskAgain(int request_code);
}
