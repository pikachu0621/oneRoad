package com.mayunfeng.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.mayunfeng.road.R;
import com.mayunfeng.road.adapter.MainMsgAdapter;
import com.mayunfeng.road.databinding.FragmentMeBinding;
import com.mayunfeng.road.databinding.FragmentMsgBinding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.mayunfeng.road.mode.JsonMsgMode;
import com.mayunfeng.road.ui.activity.MainActivity;
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



    }

    @Override
    protected void lazyLoad() {


        // test 假数据
        String jsonStr = AssetsUtils.readAssetsString(context, "msg/testMsg.json");

        JsonMsgMode jsonMsgMode = new Gson().fromJson(jsonStr, JsonMsgMode.class);

        binding.msgRecycle.setLayoutManager(new LinearLayoutManager(context));
        binding.msgRecycle.setAdapter(new MainMsgAdapter(jsonMsgMode.getContent(), context));
    }
}