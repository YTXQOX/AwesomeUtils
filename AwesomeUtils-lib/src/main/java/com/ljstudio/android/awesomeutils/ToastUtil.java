package com.ljstudio.android.awesomeutils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by tianguorui on 2016/6/23.
 */
public class ToastUtil {

    private static Toast mToast;
    private static Handler mHandler = new Handler();

    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        }
    };

    public static void toastShort(Context mContext, String text, int duration) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        }
        mHandler.postDelayed(r, duration);
        mToast.show();
    }


    public static void toastShort(Context mContext, int resId, int duration) {
        toastShort(mContext, mContext.getResources().getString(resId), duration);
    }


    public static void toastShortCenter(Context mContext, String text, int duration) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        }
        mHandler.postDelayed(r, duration);
        mToast.show();
    }


    public static void toastShortCenter(Context mContext, int resId, int duration) {
        toastShort(mContext, mContext.getResources().getString(resId), duration);
    }


    public static void toastLong(Context mContext, String text, int duration) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_LONG);
        }
        mHandler.postDelayed(r, duration);
        mToast.show();
    }


    public static void toastLong(Context mContext, int resId, int duration) {
        toastLong(mContext, mContext.getResources().getString(resId), duration);
    }


    public static void toastLongCenter(Context mContext, String text, int duration) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_LONG);
        }
        mHandler.postDelayed(r, duration);
        mToast.show();
    }


    public static void toastLongCenter(Context mContext, int resId, int duration) {
        toastLongCenter(mContext, mContext.getResources().getString(resId), duration);
    }

}