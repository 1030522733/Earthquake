package com.example.earthquake.network.service;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author : J-T
 * date   : 2021/6/21
 * desc   :
 */
public interface NewsApiInterface {
    //被观察者
    @GET("release/channel")
    Observable<String> getNewsChannels();
}
