package com.mayunfeng.road.adapter;

import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.mayunfeng.road.databinding.UiMainItemBigImgBinding;
import com.mayunfeng.road.databinding.UiMainItemBigVideoBinding;
import com.mayunfeng.road.databinding.UiMainItemImg1Binding;
import com.mayunfeng.road.databinding.UiMainItemImg3Binding;
import com.mayunfeng.road.databinding.UiMainItemTodayBinding;
import com.mayunfeng.road.databinding.UiMainItemVideoBinding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.pikachu.utils.adapter.BaseAdapter;
import com.pikachu.utils.adapter.QuickAdapter;
import com.pikachu.utils.utils.GlideUtils;

import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.adapter
 * @Author: pkpk.run
 * @Description: null 首页混合适配器
 */
public class MainMixAdapter extends BaseAdapter<JsonIndexMode.ContentDTO> {

    public static final int IMG_1 = -1, IMG_3 = -2, VIDEO = -3, BIG_IMG = -4, BIG_VIDEO = -5, TODAY = -6;


    public MainMixAdapter(List<JsonIndexMode.ContentDTO> data) {
        super(data);
    }

    @Override
    public Class<? extends ViewBinding> onCreateView(ViewGroup parent, int viewType) {
        if (viewType == IMG_1)
            return UiMainItemImg1Binding.class; // 1到2张图片的item
        if (viewType == IMG_3)
            return UiMainItemImg3Binding.class; // 3张图片以上item
        if (viewType == VIDEO)
            return UiMainItemVideoBinding.class; // 视频样式
        if (viewType == BIG_IMG)
            return UiMainItemBigImgBinding.class; // 全部图片样式
        if (viewType == BIG_VIDEO)
            return UiMainItemBigVideoBinding.class; // 全部视频样式
        if (viewType == TODAY)
            return UiMainItemTodayBinding.class; // 每日必看样式
        return UiMainItemImg1Binding.class;
    }

    @Override
    public void onBindView(ViewBinding binding, JsonIndexMode.ContentDTO itemData, int position, int itemViewType, List<JsonIndexMode.ContentDTO> data) {

      /*  binding.img35.setText(itemData.getUserName());
        binding.img31.setText(itemData.getArticleTitle());
        binding.img32.setText(itemData.getArticleContent());*/

        if (itemViewType == IMG_1){
            UiMainItemImg1Binding bind = (UiMainItemImg1Binding) binding;
            bind.img15.setText(itemData.getUserName());
            bind.img11.setText(itemData.getArticleTitle());
            bind.img12.setText(itemData.getArticleContent());

            JsonIndexMode.ContentDTO.DataSourceDTO dataSourceDTO = itemData.getDataSource().get(0);
            GlideUtils.with(context).load(dataSourceDTO.getUrl()).transition(200).rounded(20).into(bind.img13);
            return;
        }

        if (itemViewType == IMG_3){
            UiMainItemImg3Binding bind = (UiMainItemImg3Binding) binding;
            bind.img35.setText(itemData.getUserName());
            bind.img31.setText(itemData.getArticleTitle());
            bind.img32.setText(itemData.getArticleContent());

            List<JsonIndexMode.ContentDTO.DataSourceDTO> dataSource = itemData.getDataSource();
            GlideUtils.with(context).load(dataSource.get(0).getUrl()).transition(200).rounded(20).into(bind.img3Root1);
            GlideUtils.with(context).load(dataSource.get(1).getUrl()).transition(200).rounded(20).into(bind.img3Root2);
            GlideUtils.with(context).load(dataSource.get(2).getUrl()).transition(200).rounded(20).into(bind.img3Root3);


            return;
        }

        if (itemViewType == VIDEO){
            UiMainItemVideoBinding bind = (UiMainItemVideoBinding) binding;

            bind.img35.setText(itemData.getUserName());
            bind.img31.setText(itemData.getArticleTitle());

            JsonIndexMode.ContentDTO.DataSourceDTO dataSourceDTO = itemData.getDataSource().get(0);
            GlideUtils.with(context).load(dataSourceDTO.getUrl()).transition(200).rounded(20).into(bind.uImg3Root);


            return;
        }



        if (itemViewType == BIG_IMG){
            UiMainItemBigImgBinding bind = (UiMainItemBigImgBinding) binding;



            return;
        }

        if (itemViewType == BIG_VIDEO){
            UiMainItemBigVideoBinding bind = (UiMainItemBigVideoBinding) binding;


            return;
        }

        if (itemViewType == TODAY){
            UiMainItemTodayBinding bind = (UiMainItemTodayBinding) binding;


            return;
        }


    }


    @Override
    public int getItemViewType(int position, JsonIndexMode.ContentDTO itemData) {
        return itemData.getType();
    }
}
