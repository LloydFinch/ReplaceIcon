package com.lloydfinch.mmkvdemo;

import android.app.Application;
import android.util.Log;

import com.tencent.mmkv.MMKV;

/**
 * Name: MainApplication
 * Author: lloydfinch
 * Function: MainApplication
 * Date: 2020-10-16 10:52
 * Modify: lloydfinch 2020-10-16 10:52
 */
public class MainApplication extends Application {

    public static final String APP_TAG = "MMKV";
    private static MainApplication application;
    private MMKV mmkv;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        String rootDir = MMKV.initialize(this);
        Log.e(APP_TAG, "mmkv dir: [" + rootDir + "]");

        mmkv = MMKV.defaultMMKV();
    }

    public static MainApplication get() {
        return application;
    }

    public MMKV getMMKV() {
        return mmkv;
    }
}