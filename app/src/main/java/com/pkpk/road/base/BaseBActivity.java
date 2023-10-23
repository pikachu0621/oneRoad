package com.pkpk.road.base;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.gyf.immersionbar.ImmersionBar;
import com.pkpk.road.R;
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
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .navigationBarDarkIcon(getResources().getBoolean(R.bool.isStatusBar))
                .navigationBarColor(R.color.white)
                .statusBarColor(R.color.white)
                .init();
        initBActivity(savedInstanceState);
    }

    protected abstract void initBActivity(Bundle savedInstanceState);
}
