package com.saxon.myapplication;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.orhanobut.logger.Logger;


public class WIFIUtil {
    public static void getIpAddress(Context context){
        WifiManager wifiManager= (WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        boolean isOpen=wifiManager.isWifiEnabled();
        if (isOpen){
            WifiInfo wifiInfo= wifiManager.getConnectionInfo();
            int ip=wifiInfo.getIpAddress();
            String ipp=(ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) &     0xFF) + "." + (ip >> 24 & 0xFF);
            Logger.d("ip:"+ip+"\t"+ipp);
        }else {
            Logger.e("wifi不可用");
        }
    }
}
