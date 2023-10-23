package com.pkpk.road.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.pkpk.road.R;
import com.pkpk.road.databinding.FragmentIndexBinding;
import com.pkpk.road.databinding.FragmentMeBinding;
import com.pkpk.road.mode.JsonMeData;
import com.pkpk.road.mode.JsonTabMode;
import com.pkpk.road.ui.activity.MainActivity;
import com.pkpk.road.utils.BaseAppBarStateChangeListener;
import com.pikachu.utils.adapter.PagerAdapter;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;
import com.pikachu.utils.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeFragment extends BaseFragment<FragmentMeBinding> {

    private boolean isState;

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance() {
        return new MeFragment();
    }



    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentMeBinding binding, FragmentActivity activity) {
        //状态栏
        MainActivity.setStatusBarHeight(binding.tRootView, context);


        //当布局折叠 结束轮播  反正继续
        binding.fMeAppbar.addOnOffsetChangedListener(new BaseAppBarStateChangeListener(){
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int i) {
                if( state == State.EXPANDED ) {
                    //展开状态
                    isState = true;
                    setWindowTextWhiteNowOntNar();
                    showViewAnimation(false);
                    binding.mTopT1.setColorFilter(0xFFFFFFFF);
                    binding.mTopT2.setColorFilter(0xFFFFFFFF);
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    isState = false;
                    setWindowTextBlackNow();
                    showViewAnimation(true);
                    binding.mTopT1.setColorFilter(0xFF000000);
                    binding.mTopT2.setColorFilter(0xFF000000);
                }
            }
        });



    }


    @Override
    protected void lazyLoad() {
        // 加载Tab标题
        String s = AssetsUtils.readAssetsString(context, "me/loadMeTab.json");
        //showLog(s);
        JsonTabMode jsonTabMode = new Gson().fromJson(s, JsonTabMode.class);
        // ViewPager
        loadPager(jsonTabMode);
        loadMeData();
    }


    /**
     * 加载用户数据
     */
    @SuppressLint({"SetTextI18n","UseCompatLoadingForDrawables"})
    private void loadMeData() {
        String s = AssetsUtils.readAssetsString(context, "me/loadMeData.json");
        //showLog(s);
        JsonMeData jsonMeData = new Gson().fromJson(s, JsonMeData.class);
        JsonMeData.ContentDTO content = jsonMeData.getContent();
        // 背景图
        GlideUtils.with(context)
                .load(content.getUserBackgroundImage())
                .transition(150)
                .into(binding.appCompatImageView2);
        // 用户头像
        GlideUtils.with(context)
                .load(content.getUserImage())
                .into(binding.mTopImg);
        GlideUtils.with(context)
                .load(content.getUserImage())
                .into(binding.QMUIRadiusImageView);
        // 用户名
        binding.appCompatTextView.setText(content.getUserName());
        // 用户id Str
        binding.appCompatTextView2.setText("用户ID: " + content.getUserIdStr());
        // 用户个签
        String userExpound = content.getUserExpound();
        if (userExpound == null || userExpound.isEmpty())
            userExpound = "这个"+ (content.getUserSex() == 0 ? "仙女" : "帅哥") +"很懒，什么都没留下";
        binding.appCompatTextView3.setText(userExpound);
        // 性别   0女    1男
        binding.mF1Sex.setCompoundDrawablesRelativeWithIntrinsicBounds(
                content.getUserSex() == 0 ? R.drawable.ic_me_girl : R.drawable.ic_me_boy,
                0,0,0);
        // 星座
        String userConstellation = content.getUserConstellation();
        if (userConstellation == null || userConstellation.isEmpty())
            userConstellation = "";
        binding.mF1Sex.setText(userConstellation);
        // 地区
        setUserLabel(content.getUserArea(), binding.mF1Area);
        // 学校
        setUserLabel(content.getUserSchool(), binding.mF1School);
        // 职业
        setUserLabel(content.getUserProfession(), binding.mF1Profession);
        // 关注
        binding.uT1.setText(content.getUserFollow());
        // 粉丝
        binding.uT2.setText(content.getUserFan());
        // 获赞和被收藏量
        binding.uT3.setText(content.getUserPraiseAndCollect());
    }


    private void setUserLabel(String str, TextView textView){
        if (str == null || str.isEmpty())
            textView.setVisibility(View.GONE);
        else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(str);
        }
    }



    private void loadPager(JsonTabMode jsonIndexMode) {
        List<JsonTabMode.TitleDTO> title = jsonIndexMode.getTitle();
        if (title == null || title.size() <= 0){
            return;
        }
        List<String> tabs = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();

        for (JsonTabMode.TitleDTO titleDTO: title) {
            tabs.add(titleDTO.getTitle());
            fragments.add(ListMeFragment.newInstance(titleDTO));
        }
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), fragments, tabs);
        binding.mF1Pager1.setAdapter(pagerAdapter);
        binding.mF1Tab1.setupWithViewPager(binding.mF1Pager1);
    }


    private void showViewAnimation(boolean isShow){
        Animation animation = isShow ?
                AnimationUtils.loadAnimation(context, R.anim.anim_me_show_img) :
                AnimationUtils.loadAnimation(context, R.anim.anim_me_hide_img) ;
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (isShow){
                    binding.mTopImg.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isShow){
                    binding.mTopImg.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        binding.mTopImg.startAnimation(animation);
       //  animation.start();
    }




    @Override
    protected void onShow() {
        if (isState){
            setWindowTextWhiteNowOntNar();
            binding.mTopImg.setVisibility(View.GONE);
            binding.mTopT1.setColorFilter(0xFFFFFFFF);
            binding.mTopT2.setColorFilter(0xFFFFFFFF);
        }else {
            setWindowTextBlackNow();
            binding.mTopImg.setVisibility(View.VISIBLE);
            binding.mTopT1.setColorFilter(0xFF000000);
            binding.mTopT2.setColorFilter(0xFF000000);
        }
    }

}