package com.bijesh.donateblood.utils.webservice;

/**
 * Created by Bijesh on 7/22/2017.
 */

public class WebServiceUtils {

    public  enum Controller{
        INSTALLATION
    }

    public static String getErrorMessage(Controller module){
        switch (module){
            case INSTALLATION:
                return "User Already Exists";
        }
        return null;
    }

}
