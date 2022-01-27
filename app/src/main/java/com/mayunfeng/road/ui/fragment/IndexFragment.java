package com.mayunfeng.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.mayunfeng.road.R;
import com.mayunfeng.road.databinding.FragmentIndexBinding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.pikachu.utils.adapter.PagerAdapter;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;
import com.pikachu.utils.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndexFragment extends BaseFragment<FragmentIndexBinding> {



    public IndexFragment() {
        // Required empty public constructor
    }

    public static IndexFragment newInstance() {
        return new IndexFragment();
    }



    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentIndexBinding binding, FragmentActivity activity) {


    }

    @Override
    protected void lazyLoad() {
        String s = AssetsUtils.readAssetsString(context, "index/loadIndex.json");
        //showLog(s);

        JsonIndexMode jsonIndexMode = new Gson().fromJson(s, JsonIndexMode.class);
        loadTabAndFragment(jsonIndexMode);
    }



    private void loadTabAndFragment(JsonIndexMode jsonIndexMode){
        List<JsonIndexMode.TitleDTO> title = jsonIndexMode.getTitle();
        if (title == null || title.size() <= 0){
            return;
        }

        List<String> tabs = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        for (JsonIndexMode.TitleDTO titleDTO : title) {
            tabs.add(titleDTO.getTitle());
            fragments.add(ListFragment.newInstance(titleDTO));
        }
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), fragments, tabs);
        binding.fIndex1.setAdapter(pagerAdapter);
        binding.topRoot.topTabLayout.setupWithViewPager(binding.fIndex1);
        binding.fIndex1.setCurrentItem(1);
    }




}