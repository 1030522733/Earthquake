package com.example.earthquake.network;

/**
 * @author : J-T
 * date   : 2021/6/21
 * desc   :
 */
public class EarthquakeNetworkApi extends NetworkApi {

    /**
     * 可见性单例
     **/
    private static volatile EarthquakeNetworkApi sInstance;

    /**
     * 双重检查锁创建单例
     **/
    public static EarthquakeNetworkApi getInstance() {
        if (sInstance == null) {
            synchronized (EarthquakeNetworkApi.class) {
                if (sInstance == null) {
                    sInstance = new EarthquakeNetworkApi();
                }
            }
        }
        return sInstance;
    }

    /**
     * 使用方式示例：EarthquakeNetworkApi.getService(NewsApiInterface.class  //接口类)
     * .getNewsChannels()   //接口中的方法
     * .compose(EarthquakeNetworkApi.getInstance()
     * .applySchedulers(new BaseObserver<Bean>()));
     **/
    public static <T> T getService(Class<T> service) {
        return getInstance().getRetrofit(service).create(service);
    }

    @Override
    public String getFormal() {
        return "https://www.wanandroid.com";
    }

    @Override
    public String getTest() {
        return "https://www.wanandroid.com";
    }
}
