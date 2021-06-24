package com.example.earthquake.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.earthquake.R;
import com.youth.banner.loader.ImageLoader;

/**
 * @author : J-T
 * date   : 2021/6/24
 * desc   :
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop().into(imageView);

    }
}
