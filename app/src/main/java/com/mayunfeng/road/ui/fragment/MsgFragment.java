package com.mayunfeng.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayunfeng.road.R;
import com.mayunfeng.road.databinding.FragmentMeBinding;
import com.mayunfeng.road.databinding.FragmentMsgBinding;
import com.pikachu.utils.base.BaseFragment;

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

    }

    @Override
    protected void lazyLoad() {

    }
}