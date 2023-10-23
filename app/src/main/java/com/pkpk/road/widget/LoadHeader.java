package com.pkpk.road.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pkpk.road.R;
import com.pkpk.road.databinding.UiLoadHeaderBinding;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.widget
 * @Author: pkpk.run
 * @Description: null
 */
public class LoadHeader extends RelativeLayout implements RefreshHeader {


    private final UiLoadHeaderBinding uiLoadHeaderBinding;

    public LoadHeader(Context context) {
        this(context,null);
    }

    public LoadHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        uiLoadHeaderBinding = UiLoadHeaderBinding.inflate(LayoutInflater.from(context), this, false);
        addView(uiLoadHeaderBinding.getRoot());
    }




    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        //uiLoadHeaderBinding.h0.playAnimation();
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        uiLoadHeaderBinding.h0.setVisibility(GONE);
        uiLoadHeaderBinding.h1.setVisibility(VISIBLE);
        //new Handler().postDelayed(() -> UiUtils.runUi(() -> uiLoadHeaderBinding.h1.setVisibility(GONE)), 500);
        return 1000;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None:
                uiLoadHeaderBinding.h0.cancelAnimation();
                uiLoadHeaderBinding.h1.setVisibility(GONE);
                uiLoadHeaderBinding.h0.setVisibility(VISIBLE);

                break;
            case PullDownToRefresh:
                // 下拉开始刷新
                uiLoadHeaderBinding.h0.playAnimation();
                break;
            case Refreshing:
                // 正在刷新
                break;
            case ReleaseToRefresh:
                // 释放立即刷新
                break;
        }
    }
}
