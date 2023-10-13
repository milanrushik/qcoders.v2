package com.qcoders.adscodenew;

import android.app.Application;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;


public class MyApplication extends Application {

    public static MyApplication mInstance;




    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        AudienceNetworkAds.initialize(this);
        MobileAds.initialize(this);

    }

    public static MyApplication getInstance() {
        return mInstance;
    }
}
