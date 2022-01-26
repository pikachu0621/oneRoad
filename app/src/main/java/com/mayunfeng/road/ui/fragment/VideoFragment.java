package com.mayunfeng.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayunfeng.road.R;
import com.mayunfeng.road.databinding.FragmentMeBinding;
import com.mayunfeng.road.databinding.FragmentVideoBinding;
import com.pikachu.utils.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends BaseFragment<FragmentVideoBinding> {


    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }



    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentVideoBinding binding, FragmentActivity activity) {

    }

    @Override
    protected void lazyLoad() {

    }
}