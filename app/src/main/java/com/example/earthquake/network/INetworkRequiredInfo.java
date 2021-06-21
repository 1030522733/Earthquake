package com.example.earthquake.network;

import android.app.Application;

/**
 * @author : J-T
 * date   : 2021/6/21
 * desc   :
 */
public interface INetworkRequiredInfo {
    String getAppVersionName();
    String getAppVersionCode();
    boolean isDebug();
    Application getApplicationContext();
}
