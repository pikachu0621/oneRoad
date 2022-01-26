package com.mayunfeng.road.mode;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.mode
 * @Author: pkpk.run
 * @Description: null
 */
public class MainChangeMode{
    int oldImageIdRes, newImageIdRes;
    LinearLayoutCompat viewLin;
    AppCompatTextView textView;
    AppCompatImageView imageView;

    public MainChangeMode(@DrawableRes int oldImageIdRes, @DrawableRes int newImageRes,
                          LinearLayoutCompat linView, AppCompatTextView textView, AppCompatImageView imageView) {
        this.oldImageIdRes = oldImageIdRes;
        this.newImageIdRes = newImageRes;
        this.viewLin = linView;
        this.textView = textView;
        this.imageView = imageView;
    }

    public int getOldImageIdRes() {
        return oldImageIdRes;
    }

    public void setOldImageIdRes(int oldImageIdRes) {
        this.oldImageIdRes = oldImageIdRes;
    }

    public int getNewImageIdRes() {
        return newImageIdRes;
    }

    public void setNewImageIdRes(int newImageIdRes) {
        this.newImageIdRes = newImageIdRes;
    }

    public LinearLayoutCompat getViewLin() {
        return viewLin;
    }

    public void setViewLin(LinearLayoutCompat viewLin) {
        this.viewLin = viewLin;
    }

    public AppCompatTextView getTextView() {
        return textView;
    }

    public void setTextView(AppCompatTextView textView) {
        this.textView = textView;
    }

    public AppCompatImageView getImageView() {
        return imageView;
    }

    public void setImageView(AppCompatImageView imageView) {
        this.imageView = imageView;
    }
}