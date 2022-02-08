package com.mayunfeng.road.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;
import com.mayunfeng.road.R;
import com.mayunfeng.road.adapter.MainMixAdapter;
import com.mayunfeng.road.adapter.OnMainMixItemClickListener;
import com.mayunfeng.road.databinding.FragmentListBinding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.mayunfeng.road.mode.JsonTabMode;
import com.mayunfeng.road.utils.AutoPlayUtils;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;

import cn.jzvd.Jzvd;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 * 视频页
 */
public class ListVideoFragment extends BaseFragment<FragmentListBinding> implements OnMainMixItemClickListener<JsonIndexMode.ContentDTO> {

    private JsonTabMode.TitleDTO bundle;
    private LinearLayoutManager linearLayoutManager;

    public ListVideoFragment() {
        // Required empty public constructor
    }

    public static ListVideoFragment newInstance(JsonTabMode.TitleDTO titleDTO) {
        ListVideoFragment listFragment = new ListVideoFragment();
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
       /* binding.list1.setText(bundle.getTitle());

        // test 假数据
        showLog(bundle.getTitle(), bundle.getUrl());
        String jsonStr = AssetsUtils.readAssetsString(context, bundle.getUrl());
        // 隐藏load
        binding.listWeb.setVisibility(View.GONE);
        binding.list2.setVisibility(View.VISIBLE);


        JsonIndexMode jsonIndexMode = new Gson().fromJson(jsonStr, JsonIndexMode.class);
        binding.list2.setAdapter(new MainMixAdapter(jsonIndexMode.getContent(), this));
        linearLayoutManager = new LinearLayoutManager(context);
        binding.list2.setLayoutManager(linearLayoutManager);
        setAutoPlay();*/
    }

    @Override
    protected void lazyLoad() {
        binding.list1.setText(bundle.getTitle());

        // test 假数据
        showLog(bundle.getTitle(), bundle.getUrl());
        String jsonStr = AssetsUtils.readAssetsString(context, bundle.getUrl());
        // 隐藏load
        binding.listWeb.setVisibility(View.GONE);
        binding.list2.setVisibility(View.VISIBLE);


        JsonIndexMode jsonIndexMode = new Gson().fromJson(jsonStr, JsonIndexMode.class);
        binding.list2.setAdapter(new MainMixAdapter(jsonIndexMode.getContent(), this));
        linearLayoutManager = new LinearLayoutManager(context);
        binding.list2.setLayoutManager(linearLayoutManager);
        setAutoPlay();
    }




    private void setAutoPlay(){
        binding.list2.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {
                Jzvd jzvd = view.findViewById(R.id.video_player);
                if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });
        binding.list2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    AutoPlayUtils.onScrollPlayVideo(recyclerView, R.id.video_player, linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition());
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy != 0) {
                    AutoPlayUtils.onScrollReleaseAllVideos(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition(), 0.2f);
                }
            }
        });

    }








    @Override
    protected void onShow() {
        super.onShow();
    }


    @Override
    protected void onHidden() {
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onStop() {
        super.onStop();
        Jzvd.releaseAllVideos();
    }

    @Override
    public boolean onClickItem(JsonIndexMode.ContentDTO itemData) {
        return false;
    }
}