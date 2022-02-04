package com.mayunfeng.road.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mayunfeng.road.R;
import com.mayunfeng.road.databinding.UiLoadHeaderBinding;
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
public class LoadHeader extends LinearLayout implements RefreshHeader {


    private UiLoadHeaderBinding uiLoadHeaderBinding;

    public LoadHeader(Context context) {
        this(context,null);
    }

    public LoadHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        uiLoadHeaderBinding = UiLoadHeaderBinding.inflate(LayoutInflater.from(context));
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
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
        //uiLoadHeaderBinding.h0.cancelAnimation();

        return 500;
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
                break;
            case PullDownToRefresh:
              /*  mHeaderText.setText("下拉开始刷新");
                mArrowView.setVisibility(VISIBLE);//显示下拉箭头
                mProgressView.setVisibility(GONE);//隐藏动画
                mArrowView.animate().rotation(0);//还原箭头方向*/
                //uiLoadHeaderBinding.h0.playAnimation();
                break;
            case Refreshing:
               /* mHeaderText.setText("正在刷新");
                mProgressView.setVisibility(VISIBLE);//显示加载动画
                mArrowView.setVisibility(GONE);//隐藏箭头*/
                //uiLoadHeaderBinding.h0.playAnimation();
                uiLoadHeaderBinding.h0.playAnimation();
                break;
            case ReleaseToRefresh:
/*                mHeaderText.setText("释放立即刷新");
                mArrowView.animate().rotation(180);//显示箭头改为朝上*/
                //uiLoadHeaderBinding.h0.cancelAnimation();
                // uiLoadHeaderBinding.h0.playAnimation();
                break;
        }
    }
}
