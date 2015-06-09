package com.bijesh.donateblood.storage;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by Bijesh on 07-06-2015.
 */
public class DonateBloodFileStorage {

    private static final String TAG = DonateBloodFileStorage.class.getCanonicalName();
    static String fileKeyValueType = "KeyValue.dat";

    public static void setStringData(Context context, String key, String value){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        HashMap<String, String> keyVal = null;
        try{
            File file = new File(context.getFilesDir()+ File.separator+fileKeyValueType);
            if(file.exists()) {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                keyVal = (HashMap<String, String>) ois.readObject();
                ois.close();
                Log.d(TAG, "keyVal is " + keyVal);
                if (keyVal != null) {
//                    Log.d(TAG, "its not null now");
                    keyVal.put(key,value);
//                    Log.d(TAG,"hash map now "+keyVal);
                }
            }else{
                file.createNewFile();
                Log.d(TAG,"Created new file "+file.getAbsolutePath());
                keyVal = new HashMap<>();
                keyVal.put(key,value);
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(keyVal);
//                Log.d(TAG,"stored values");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getStringData(Context context,String key){
        String retVal = null;
        File file = new File(context.getFilesDir()+ File.separator+fileKeyValueType);
        FileInputStream fis = null;
        HashMap<String, String> keyVal = null;
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                keyVal = (HashMap<String, String>) ois.readObject();
                ois.close();
                if(keyVal != null){
                    retVal = keyVal.get(key);
                }
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return retVal;
    }


}
