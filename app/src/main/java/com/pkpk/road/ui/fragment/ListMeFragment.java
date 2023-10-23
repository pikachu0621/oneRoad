package com.pkpk.road.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import com.google.gson.Gson;
import com.pkpk.road.R;
import com.pkpk.road.adapter.MainMixAdapter;
import com.pkpk.road.adapter.OnMainMixItemClickListener;
import com.pkpk.road.databinding.FragmentIndexBinding;
import com.pkpk.road.databinding.FragmentListBinding;
import com.pkpk.road.mode.JsonIndexMode;
import com.pkpk.road.mode.JsonTabMode;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListMeFragment extends BaseFragment<FragmentListBinding> implements OnMainMixItemClickListener<JsonIndexMode.ContentDTO> {

    private JsonTabMode.TitleDTO bundle;

    public ListMeFragment() {
        // Required empty public constructor
    }

    public static ListMeFragment newInstance(JsonTabMode.TitleDTO titleDTO) {
        ListMeFragment listFragment = new ListMeFragment();
        setBundle(listFragment, titleDTO);
        return listFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getBundle(JsonTabMode.TitleDTO.class);
    }


    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentListBinding binding, FragmentActivity activity) {

    }

    @Override
    protected void lazyLoad() {
        binding.list1.setText(bundle.getTitle());
        // test 假数据
        showLog(bundle.getTitle(), bundle.getUrl());
        String jsonStr = AssetsUtils.readAssetsString(context, bundle.getUrl());

        binding.listWeb.setVisibility(View.GONE);
        binding.list2.setVisibility(View.VISIBLE);
        JsonIndexMode jsonIndexMode = new Gson().fromJson(jsonStr, JsonIndexMode.class);
        MainMixAdapter mainMixAdapter = new MainMixAdapter(jsonIndexMode.getContent(), this);
        mainMixAdapter.setHideMe(bundle.getType() == 0);
        binding.list2.setAdapter(mainMixAdapter);
        binding.list2.setLayoutManager(new LinearLayoutManager(context));

    }



    @Override
    public boolean onClickItem(JsonIndexMode.ContentDTO itemData) {
        return false;
    }
}