package com.mayunfeng.road.adapter;

import com.mayunfeng.road.databinding.UiMainItemImg3Binding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.pikachu.utils.adapter.QuickAdapter;

import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.adapter
 * @Author: pkpk.run
 * @Description: null 首页混合适配器
 */
public class MainMixAdapter extends QuickAdapter<UiMainItemImg3Binding, JsonIndexMode.ContentDTO> {

    public MainMixAdapter(List<JsonIndexMode.ContentDTO> data) {
        super(data);
    }

    @Override
    public void onQuickBindView(UiMainItemImg3Binding binding, JsonIndexMode.ContentDTO itemData, int position, List<JsonIndexMode.ContentDTO> data) {

        binding.img35.setText(itemData.getUserName());
        binding.img31.setText(itemData.getArticleTitle());
        binding.img32.setText(itemData.getArticleContent());
        // binding.img37.setText(itemData.getArticleCommentNum());


    }


}
