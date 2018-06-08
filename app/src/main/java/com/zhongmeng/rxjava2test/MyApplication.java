package com.zhongmeng.rxjava2test;

import android.app.Application;


/**
 * Created by RCW on 2017/7/19.
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static MyApplication getInstance() {
        return instance;
    }

}
