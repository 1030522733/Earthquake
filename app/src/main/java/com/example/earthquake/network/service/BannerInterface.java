package com.example.earthquake.network.service;

import com.example.earthquake.model.BannerBean;
import com.example.earthquake.model.ResponModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author : J-T
 * date   : 2021/6/24
 * desc   :
 */
public interface BannerInterface {
    @GET("banner/json")
    Observable<ResponModel<List<BannerBean>>> getBanner();
}
