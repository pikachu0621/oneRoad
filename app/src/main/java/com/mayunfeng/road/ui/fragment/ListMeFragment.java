package com.mayunfeng.road.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.mayunfeng.road.R;
import com.mayunfeng.road.adapter.MainMixAdapter;
import com.mayunfeng.road.adapter.OnMainMixItemClickListener;
import com.mayunfeng.road.databinding.FragmentIndexBinding;
import com.mayunfeng.road.databinding.FragmentListBinding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.mayunfeng.road.mode.JsonTabMode;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;
import com.pikachu.utils.utils.LogsUtils;
import com.pikachu.utils.utils.UiUtils;

import java.util.List;

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