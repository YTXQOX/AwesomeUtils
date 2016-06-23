package com.ljstudio.android.awesomeutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/**
 * Created by tianguorui on 2016/6/23.
 */
public class WiFiUtil {

    public static String getMac(Context context) {

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        String wifiR3g = null;
        String mac = null;
        String ipAddress = null;
        float floatSize = 0;

        //是否连接网络
        if (networkInfo != null && networkInfo.isConnected()) {
            //联网方式
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                wifiR3g = "3G";
            }
            else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                wifiR3g = "wifi";
            }

            WifiInfo wifiInfo = wm.getConnectionInfo();
            int ipInt = wifiInfo.getIpAddress();
            ipAddress = intToIp(ipInt);
            mac = wifiInfo.getMacAddress();
        } else {
            wifiR3g = "未连接wifi网络";
            mac = "未连接wifi网络";
            ipAddress = "未连接wifi网络";
        }

        return mac;
    }

    public static String intToIp(int i) {
        return (i & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + ((i >> 16) & 0xFF) +
                "." + (i >> 24 & 0xFF);
    }
}
