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
import com.mayunfeng.road.ui.activity.LookArticleActivity;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;
import com.pikachu.utils.utils.UiUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends BaseFragment<FragmentListBinding> implements OnMainMixItemClickListener<JsonIndexMode.ContentDTO> {

    private JsonTabMode.TitleDTO bundle;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(JsonTabMode.TitleDTO titleDTO) {
        ListFragment listFragment = new ListFragment();
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

        // test ?????????
        showLog(bundle.getTitle(), bundle.getUrl());
        String jsonStr = AssetsUtils.readAssetsString(context, bundle.getUrl());
        // ??????load
        hideLoadView();

        switch (bundle.getType()) {
            case 0:
            case 1:
            case 2:
            case 3:
                binding.list3.setEnableLoadMore(true);
                binding.list3.setEnableRefresh(true);

                binding.listWeb.setVisibility(View.GONE);
                binding.list2.setVisibility(View.VISIBLE);
                JsonIndexMode jsonIndexMode = new Gson().fromJson(jsonStr, JsonIndexMode.class);
                binding.list2.setAdapter(new MainMixAdapter(jsonIndexMode.getContent(), this));
                binding.list2.setLayoutManager(new LinearLayoutManager(context));
                break;
            case 4:
                binding.list3.setEnableLoadMore(false);
                binding.list3.setEnableRefresh(false);

                binding.list2.setVisibility(View.GONE);
                binding.listWeb.setVisibility(View.VISIBLE);
                webStyleDisplay();
                break;
            case 5:
                binding.list3.setEnableLoadMore(true);
                binding.list3.setEnableRefresh(true);
                JsonIndexMode jsonIndexMode1 = new Gson().fromJson(jsonStr, JsonIndexMode.class);
                binding.list2.setAdapter(new MainMixAdapter(jsonIndexMode1.getContent(), this));
                binding.list2.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        }*/

    }

    @Override
    protected void lazyLoad() {
        binding.list1.setText(bundle.getTitle());

        // test ?????????
        showLog(bundle.getTitle(), bundle.getUrl());
        String jsonStr = AssetsUtils.readAssetsString(context, bundle.getUrl());
        // ??????load
        hideLoadView();

        switch (bundle.getType()) {
            case 0:
            case 1:
            case 2:
            case 3:
                binding.list3.setEnableLoadMore(true);
                binding.list3.setEnableRefresh(true);

                binding.listWeb.setVisibility(View.GONE);
                binding.list2.setVisibility(View.VISIBLE);
                JsonIndexMode jsonIndexMode = new Gson().fromJson(jsonStr, JsonIndexMode.class);
                binding.list2.setAdapter(new MainMixAdapter(jsonIndexMode.getContent(), this));
                binding.list2.setLayoutManager(new LinearLayoutManager(context));
                break;
            case 4:
                binding.list3.setEnableLoadMore(false);
                binding.list3.setEnableRefresh(false);

                binding.list2.setVisibility(View.GONE);
                binding.listWeb.setVisibility(View.VISIBLE);
                webStyleDisplay();
                break;
            case 5:
                binding.list3.setEnableLoadMore(true);
                binding.list3.setEnableRefresh(true);
                JsonIndexMode jsonIndexMode1 = new Gson().fromJson(jsonStr, JsonIndexMode.class);
                binding.list2.setAdapter(new MainMixAdapter(jsonIndexMode1.getContent(), this));
                binding.list2.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        }
    }



    private void showLoadView(){
        binding.listLottie.setVisibility(View.VISIBLE);
        binding.listLottie1.playAnimation();
    }


    private void hideLoadView(){
        binding.listLottie.setVisibility(View.GONE);
        binding.listLottie1.cancelAnimation();
    }






    @SuppressLint("SetJavaScriptEnabled")
    private void webStyleDisplay() {
        showLoadView();
        binding.listWeb.loadUrl(bundle.getUrl());
        binding.listWeb.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageFinished(WebView view, String url) {
                if (url != null) {
                    new Handler().postDelayed(() -> {
                        String js = AssetsUtils.readAssetsString(context, "hideTt.js");
                        showLog(js);
                        view.loadUrl(js);
                        view.loadUrl("javascript:hide();");
                        hideLoadView();
                    }, 2000);
                }
                super.onPageFinished(view, url);
            }


        });
        WebSettings webSettings = binding.listWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");


    }





    @Override
    public boolean onClickItem(JsonIndexMode.ContentDTO itemData) {
        startActivity(LookArticleActivity.class, itemData);
        return false;
    }
}