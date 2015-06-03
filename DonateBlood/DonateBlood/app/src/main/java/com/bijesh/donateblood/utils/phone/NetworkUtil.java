
package com.bijesh.donateblood.utils.phone;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Util class for getting Network details.
 * 
 */
public class NetworkUtil {

	/**
	 * Checks if network is available
	 * 
	 * @param context
	 * @return true if available, false otherwise
	 */
	public static boolean isNetworkAvailable(Context context) {
		Context mContext = context;
		try {
			ConnectivityManager connectivity = (ConnectivityManager) mContext
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null) {
                    for (NetworkInfo anInfo : info) {
                        if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
