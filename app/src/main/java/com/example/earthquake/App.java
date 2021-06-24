package com.example.earthquake;

import android.app.Application;
import android.content.Context;

import com.example.earthquake.network.NetworkApi;
import com.example.earthquake.network.NetworkRequiredInfo;

/**
 * @author : J-T
 * date   : 2021/6/21
 * desc   :
 */
public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        NetworkApi.init(new NetworkRequiredInfo(this));
    }

    public static Context getContext() {
        return instance;
    }
}
