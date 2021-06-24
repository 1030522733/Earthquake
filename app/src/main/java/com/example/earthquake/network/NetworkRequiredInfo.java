package com.example.earthquake.network;

import android.app.Application;

import com.example.earthquake.BuildConfig;

/**
 * @author : J-T
 * date   : 2021/6/21
 * desc   :
 */
public class NetworkRequiredInfo implements INetworkRequiredInfo {
    private Application application;

    public NetworkRequiredInfo(Application application) {
        this.application = application;
    }

    @Override
    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getAppVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Application getApplicationContext() {
        return application;
    }
}
