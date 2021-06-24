package com.example.earthquake.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : J-T
 * date   : 2021/6/24
 * desc   :
 */
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding>
        extends AppCompatActivity {

    /**
     * 获取TAG的activity名称
     **/
    protected final String TAG = this.getClass().getSimpleName();
    /**
     * 获取上下文
     **/
    public Context mContext;

    protected VM mViewModel;
    protected VDB binding;

    /**
     * 获取当前activity布局文件,并初始化我们的binding
     *
     * @return int
     */
    protected abstract int getContentViewId();

    /**
     * 处理逻辑业务
     **/
    protected abstract void processLogic();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getContentViewId());
        //初始化我们的binging
        binding = DataBindingUtil.setContentView(this, getContentViewId());
        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner
        binding.setLifecycleOwner(this);
        //创建我们的ViewModel。
        createViewModel();
        processLogic();
    }

    public void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            //返回直接继承的父类（包含泛型参数）
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }

}
