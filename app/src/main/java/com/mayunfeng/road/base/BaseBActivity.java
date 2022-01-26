package com.mayunfeng.road.base;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.pikachu.utils.base.BaseActivity;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.base
 * @Author: pkpk.run
 * @Description: null
 */
public abstract class BaseBActivity<T extends ViewBinding> extends BaseActivity<T> {
    @Override
    protected void initActivity(Bundle savedInstanceState) {
        setWindowBlack();
        initBActivity(savedInstanceState);
    }

    protected abstract void initBActivity(Bundle savedInstanceState);
}
