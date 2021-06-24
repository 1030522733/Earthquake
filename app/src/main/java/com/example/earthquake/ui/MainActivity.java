package com.example.earthquake.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;

import com.example.earthquake.R;
import com.example.earthquake.base.BaseActivity;
import com.example.earthquake.databinding.ActivityMainBinding;
import com.example.earthquake.model.BannerBean;
import com.example.earthquake.utils.GlideImageLoader;
import com.example.earthquake.viewmodel.MainViewModel;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void processLogic() {
        binding.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //这是给banner添加图片加载器
        binding.banner.setImageLoader(new GlideImageLoader());
        binding.btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("托马斯小火车", "onClick: ");
                getBanner();
            }
        });
    }

    private void getBanner() {
        mViewModel.getBanners().observe(this, new Observer<List<BannerBean>>() {
            @Override
            public void onChanged(List<BannerBean> bannerBeans) {
                updateBanner(bannerBeans);
            }
        });
    }

    private void updateBanner(List<BannerBean> data) {
        if (data == null || data.size() <= 0) {
            return;
        }
        List<String> urls = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            urls.add(data.get(i).getImagePath());
            titles.add(data.get(i).getTitle());
        }
        binding.banner.setBannerTitles(titles);
        binding.banner.setImages(urls);
        binding.banner.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}