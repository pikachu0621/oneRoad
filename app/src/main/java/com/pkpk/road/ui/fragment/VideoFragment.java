package com.pkpk.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.gson.Gson;
import com.pkpk.road.R;
import com.pkpk.road.databinding.FragmentMeBinding;
import com.pkpk.road.databinding.FragmentVideoBinding;
import com.pkpk.road.mode.JsonTabMode;
import com.pkpk.road.ui.activity.MainActivity;
import com.pikachu.utils.adapter.PagerAdapter;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends BaseFragment<FragmentVideoBinding> {


    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }



    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentVideoBinding binding, FragmentActivity activity) {
        //状态栏
        MainActivity.setStatusBarHeight(binding.topRoot.tRootView, context);
        setWindowTextBlackNow();

        // 加载Tab标题
        String s = AssetsUtils.readAssetsString(context, "video/loadVideoTab.json");
        //showLog(s);
        JsonTabMode jsonTabMode = new Gson().fromJson(s, JsonTabMode.class);
        loadTabAndFragment(jsonTabMode);
    }

    @Override
    protected void lazyLoad() {
/*        // 加载Tab标题
        String s = AssetsUtils.readAssetsString(context, "video/loadVideoTab.json");
        //showLog(s);
        JsonTabMode jsonTabMode = new Gson().fromJson(s, JsonTabMode.class);
        loadTabAndFragment(jsonTabMode);*/
    }



    private void loadTabAndFragment(JsonTabMode jsonIndexMode){
        List<JsonTabMode.TitleDTO> title = jsonIndexMode.getTitle();
        if (title == null || title.size() <= 0){
            return;
        }

        List<String> tabs = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        for (JsonTabMode.TitleDTO titleDTO : title) {
            tabs.add(titleDTO.getTitle());
            fragments.add(ListVideoFragment.newInstance(titleDTO));
        }
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), fragments, tabs);
        binding.fIndex1.setAdapter(pagerAdapter);
        binding.topRoot.topTabLayout.setupWithViewPager(binding.fIndex1);
    }



    @Override
    protected void onShow() {
        setWindowTextBlackNow();
    }
}