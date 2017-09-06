package com.philong.lazada.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Long on 9/6/2017.
 */

public class CheckInternet {

    public static boolean isInternet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
            return true;
        }else{
            return false;
        }
    }
}
