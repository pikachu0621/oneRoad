package com.mayunfeng.road.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
import com.pikachu.utils.utils.LogsUtils;
import com.pikachu.utils.utils.OtherUtils;
import com.pikachu.utils.utils.TimeUtils;
import com.pikachu.utils.utils.UiUtils;

import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.adapter
 * @Author: pkpk.run
 * @Description: null 首页混合适配器
 */
public class MainMixAdapter extends BaseAdapter<JsonIndexMode.ContentDTO> {

    public static final int IMG_1 = -1, // 一张图片样式
            IMG_3 = -2, // 3张图片样式
            VIDEO = -3, // 频样式
            BIG_IMG = -4,  // 全图片样式
            BIG_VIDEO = -5, // 全视频样式
            TODAY = -6; // 每日必看
    private final OnMainMixItemClickListener<JsonIndexMode.ContentDTO> onMainMixItemClickListener;


    public MainMixAdapter(List<JsonIndexMode.ContentDTO> data, OnMainMixItemClickListener<JsonIndexMode.ContentDTO> onMainMixItemClickListener ) {
        super(data);
        this.onMainMixItemClickListener = onMainMixItemClickListener;
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindView(ViewBinding binding, JsonIndexMode.ContentDTO itemData, int position, int itemViewType, List<JsonIndexMode.ContentDTO> data) {

      /*  binding.img35.setText(itemData.getUserName());
        binding.img31.setText(itemData.getArticleTitle());
        binding.img32.setText(itemData.getArticleContent());*/

        if (itemViewType == IMG_1){
            UiMainItemImg1Binding bind = (UiMainItemImg1Binding) binding;

            GlideUtils.with(context).load(itemData.getUserImage()).transition(200).into(bind.img14); // 用户头像
            bind.img15.setText(itemData.getUserName()); // 用户昵称
            bind.img11.setText(itemData.getArticleTitle()); // 文章标题
            bind.img12.setText(itemData.getArticleContent()); // 文章内容

            bind.img17.setText(itemData.getArticleShareNum() + ""); // 分享数
            bind.img18.setText(itemData.getArticleCommentNum() + ""); //  评论数
            bind.img19.setText(itemData.getArticleLaudNum() + ""); // 点赞数

            JsonIndexMode.ContentDTO.DataSourceDTO dataSourceDTO = itemData.getDataSource().get(0); // 获取图片组
            GlideUtils.with(context).load(dataSourceDTO.getUrl()).transition(200).into(bind.img13); // 加载图片
            return;
        }

        if (itemViewType == IMG_3){
            UiMainItemImg3Binding bind = (UiMainItemImg3Binding) binding;

            GlideUtils.with(context).load(itemData.getUserImage()).transition(200).into(bind.img34); // 用户头像
            bind.img35.setText(itemData.getUserName());
            bind.img31.setText(itemData.getArticleTitle());
            bind.img32.setText(itemData.getArticleContent());

            bind.img37.setText(itemData.getArticleShareNum() + ""); // 分享数
            bind.img38.setText(itemData.getArticleCommentNum() + ""); //  评论数
            bind.img39.setText(itemData.getArticleLaudNum() + ""); // 点赞数

            List<JsonIndexMode.ContentDTO.DataSourceDTO> dataSource = itemData.getDataSource();
            GlideUtils.with(context).load(dataSource.get(0).getUrl()).transition(200).into(bind.img3Root1);
            GlideUtils.with(context).load(dataSource.get(1).getUrl()).transition(200).into(bind.img3Root2);
            GlideUtils.with(context).load(dataSource.get(2).getUrl()).transition(200).into(bind.img3Root3);

            return;
        }

        if (itemViewType == VIDEO){
            UiMainItemVideoBinding bind = (UiMainItemVideoBinding) binding;

            GlideUtils.with(context).load(itemData.getUserImage()).transition(200).into(bind.img34); // 用户头像
            bind.img35.setText(itemData.getUserName());
            bind.img31.setText(itemData.getArticleTitle());

            bind.img37.setText(itemData.getArticleShareNum() + ""); // 分享数
            bind.img38.setText(itemData.getArticleCommentNum() + ""); //  评论数
            bind.img39.setText(itemData.getArticleLaudNum() + ""); // 点赞数

            JsonIndexMode.ContentDTO.DataSourceDTO dataSourceDTO = itemData.getDataSource().get(0);
            GlideUtils.with(context).load(dataSourceDTO.getUrl()).transition(200).into(bind.uImg3Root);

            return;
        }



        if (itemViewType == BIG_IMG){
            UiMainItemBigImgBinding bind = (UiMainItemBigImgBinding) binding;


            GlideUtils.with(context).load(itemData.getUserImage()).into(bind.bImg4); // 用户头像
            bind.bImg1.setText(itemData.getArticleTitle());
            bind.bImg2.setText(itemData.getArticleLaudNum() + "");
            bind.bImg3.setText(itemData.getArticleCommentNum() + "");



            JsonIndexMode.ContentDTO.DataSourceDTO dataSourceDTO = itemData.getDataSource().get(0);

            LogsUtils.showLog("TEST_TT", dataSourceDTO.getPxh());
            ViewGroup.LayoutParams params =  bind.bImg0.getLayoutParams();
            params.height = UiUtils.dp2px(context, dataSourceDTO.getPxh());
            bind.bImg0.setLayoutParams(params);

            GlideUtils.with(context).load(dataSourceDTO.getUrl()).into(bind.bImg0);

            return;
        }

        if (itemViewType == BIG_VIDEO){
            UiMainItemBigVideoBinding bind = (UiMainItemBigVideoBinding) binding;



            return;
        }

        if (itemViewType == TODAY){
            UiMainItemTodayBinding bind = (UiMainItemTodayBinding) binding;

            bind.today2.setText(itemData.getArticleTitle()); // 文章标题
            bind.today3.setText(itemData.getArticleLaudNum() + ""); // 点赞数
            bind.today4.setText(TimeUtils.dataToStr(itemData.getArticleOutTime(), "yyyy年MM月dd日")); // 日期

            JsonIndexMode.ContentDTO.DataSourceDTO dataSourceDTO = itemData.getDataSource().get(0);
            GlideUtils.with(context).load(dataSourceDTO.getUrl()).transition(200).into(bind.today1);

            return;
        }


        // 列表点击
        binding.getRoot().setOnClickListener(v -> {

            if (onMainMixItemClickListener.onClickItem(itemData)) {
                refresh();
            }

        });
    }


    @Override
    public int getItemViewType(int position, JsonIndexMode.ContentDTO itemData) {
        return itemData.getType();
    }
}