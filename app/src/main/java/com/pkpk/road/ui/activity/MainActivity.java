package com.pkpk.road.ui.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.pkpk.road.R;
import com.pkpk.road.databinding.ActivityMainBinding;
import com.pkpk.road.mode.MainChangeMode;
import com.pkpk.road.ui.fragment.IndexFragment;
import com.pkpk.road.ui.fragment.MeFragment;
import com.pkpk.road.ui.fragment.MsgFragment;
import com.pkpk.road.ui.fragment.VideoFragment;
import com.pikachu.utils.adapter.PagerAdapter;
import com.pikachu.utils.base.BaseActivity;
import com.pikachu.utils.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {


    private int colorTouch;
    private MainChangeMode[] mainChangeModes;
    private int positionOld;

    @Override
    protected void initActivity(Bundle savedInstanceState) {
        setNoFullViewToWindow(R.color.white, true);
        initFragment();
    }


    private void initFragment() {
        List<Fragment> fragments = new ArrayList<>();
        IndexFragment indexFragment = IndexFragment.newInstance();
        VideoFragment videoFragment = VideoFragment.newInstance();
        MsgFragment msgFragment = MsgFragment.newInstance();
        MeFragment meFragment = MeFragment.newInstance();
        fragments.add(indexFragment);
        fragments.add(videoFragment);
        fragments.add(msgFragment);
        fragments.add(meFragment);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        binding.viewPager.setAdapter(pagerAdapter);
        bottomBindViewPager(binding.viewPager);
    }


    private void bottomBindViewPager(ViewPager viewPager) {


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MainChangeMode mainChangeMode = mainChangeModes[positionOld];
                mainChangeMode.getTextView().setVisibility(View.GONE);
                mainChangeMode.getImageView().setImageResource(mainChangeMode.getOldImageIdRes());
                mainChangeMode = mainChangeModes[position];
                mainChangeMode.getTextView().setVisibility(View.VISIBLE);
                mainChangeMode.getImageView().setImageResource(mainChangeMode.getNewImageIdRes());
                positionOld = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        colorTouch = getResources().getColor(R.color.touch);
        mainChangeModes = new MainChangeMode[]{
                new MainChangeMode(R.drawable.ic_main_index_1, R.drawable.ic_main_index, binding.bottomRoot.bm1, binding.bottomRoot.bm1Txt,  binding.bottomRoot.bm1Img),
                new MainChangeMode(R.drawable.ic_main_video_1, R.drawable.ic_main_video, binding.bottomRoot.bm2, binding.bottomRoot.bm2Txt,  binding.bottomRoot.bm2Img),
                new MainChangeMode(R.drawable.ic_main_news_1, R.drawable.ic_main_news, binding.bottomRoot.bm4, binding.bottomRoot.bm4Txt,  binding.bottomRoot.bm4Img),
                new MainChangeMode(R.drawable.ic_main_my_1, R.drawable.ic_main_my, binding.bottomRoot.bm5, binding.bottomRoot.bm5Txt ,  binding.bottomRoot.bm5Img)
        };

        for (int i = 0; i < mainChangeModes.length; i++) {
            int finalI = i;
            mainChangeModes[i].getViewLin().setOnClickListener(v -> binding.viewPager.setCurrentItem(finalI));
        }
    }



    public static void setStatusBarHeight(View view, Context context){
        int statusBarHeight = UiUtils.getStatusBarHeight(context);
        if (statusBarHeight <= 0){
            statusBarHeight = UiUtils.dp2px(context, 36);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = statusBarHeight;
        view.setLayoutParams(layoutParams);

    }

}