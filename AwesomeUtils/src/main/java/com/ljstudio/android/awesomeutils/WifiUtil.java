package com.ljstudio.android.awesomeutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by tianguorui on 2016/6/23.
 */
public class WifiUtil {

    /**
     * get WifiInfo
     */
    public static WifiInfo getWifiInfo(Context context) {

        WifiInfo wifiInfo = null;
        String wifiR3g;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        //是否连接网络
        if (networkInfo != null && networkInfo.isConnected()) {
            //联网方式
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                wifiR3g = "3G";
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                wifiR3g = "wifi";
            }

            wifiInfo = wm.getConnectionInfo();
        } else {
            wifiR3g = "未连接wifi网络";
        }

        return wifiInfo;
    }


    /**
     * get MAC
     */
    public static String getMac(Context context) {

        String wifiR3g;
        String mac;
        String ipAddress;

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        //是否连接网络
        if (networkInfo != null && networkInfo.isConnected()) {
            //联网方式
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                wifiR3g = "3G";
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                wifiR3g = "wifi";
            }

            WifiInfo wifiInfo = wm.getConnectionInfo();
            int ipInt = wifiInfo.getIpAddress();
            ipAddress = intToIp(ipInt);
            mac = wifiInfo.getMacAddress();

            String ssid = wifiInfo.getSSID();
            int networkID = wifiInfo.getNetworkId();
            int speed = wifiInfo.getLinkSpeed();
            System.out.print("mac-->" + mac + "ssid-->" + ssid + "networkID-->" + networkID + "speed-->" + speed);
        } else {
            wifiR3g = "未连接wifi网络";
            mac = "未连接wifi网络";
            ipAddress = "未连接wifi网络";
        }

        return mac;
    }


    /**
     * get Mac_sys
     */
    public static String getMac_sys() {

        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return macSerial;
    }


    /**
     * get Mac_proc
     */
    public static String getMac_proc() {

        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /proc/net/arp");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return macSerial;
    }


    /**
     * ip
     */
    private static String intToIp(int i) {
        return (i & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + ((i >> 16) & 0xFF) +
                "." + (i >> 24 & 0xFF);
    }
}
