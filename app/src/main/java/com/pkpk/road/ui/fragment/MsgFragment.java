package com.pkpk.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.pkpk.road.R;
import com.pkpk.road.adapter.MainMsgAdapter;
import com.pkpk.road.databinding.FragmentMeBinding;
import com.pkpk.road.databinding.FragmentMsgBinding;
import com.pkpk.road.mode.JsonMsgMode;
import com.pkpk.road.ui.activity.MainActivity;
import com.pikachu.utils.base.BaseFragment;
import com.pikachu.utils.utils.AssetsUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MsgFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MsgFragment extends BaseFragment<FragmentMsgBinding> {


    public MsgFragment() {
        // Required empty public constructor
    }

    public static MsgFragment newInstance() {
        return new MsgFragment();
    }



    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentMsgBinding binding, FragmentActivity activity) {
        //状态栏
        MainActivity.setStatusBarHeight(binding.topRoot.tRootView, context);
       setWindowTextBlackNow();


    }

    @Override
    protected void lazyLoad() {


        // test 假数据
        String jsonStr = AssetsUtils.readAssetsString(context, "msg/loadMsg.json");

        JsonMsgMode jsonMsgMode = new Gson().fromJson(jsonStr, JsonMsgMode.class);

        binding.msgRecycle.setLayoutManager(new LinearLayoutManager(context));
        binding.msgRecycle.setAdapter(new MainMsgAdapter(jsonMsgMode.getContent(), context));
    }



    @Override
    protected void onShow() {
        setWindowTextBlackNow();
    }
}