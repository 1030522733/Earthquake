package com.example.earthquake.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.earthquake.base.BaseViewModel;
import com.example.earthquake.model.BannerBean;
import com.example.earthquake.model.ResponModel;
import com.example.earthquake.network.BaseObserver;
import com.example.earthquake.network.EarthquakeNetworkApi;
import com.example.earthquake.network.service.BannerInterface;

import java.util.List;

/**
 * @author : J-T
 * date   : 2021/6/24
 * desc   :
 */
public class MainViewModel extends BaseViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<BannerBean>> getBanners() {
        final MutableLiveData<List<BannerBean>> liveData = new MutableLiveData<>();
        EarthquakeNetworkApi.getService(BannerInterface.class)
                .getBanner()
                .compose(EarthquakeNetworkApi.getInstance()
                        .applySchedulers(new BaseObserver<ResponModel<List<BannerBean>>>() {
                            @SuppressLint("CheckResult")
                            @Override
                            public void onSuccess(ResponModel<List<BannerBean>> listResponModel) {
                                Log.d("托马斯小火车", "onSuccess: ");
                                liveData.postValue(listResponModel.getData());
                            }

                            @SuppressLint("CheckResult")
                            @Override
                            public void onFailure(Throwable e) {
                                Log.d("托马斯小火车", "失败了");
                            }
                        }));
        return liveData;
    }
}
