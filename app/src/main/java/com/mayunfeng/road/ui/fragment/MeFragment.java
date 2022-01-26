package com.mayunfeng.road.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayunfeng.road.R;
import com.mayunfeng.road.databinding.FragmentIndexBinding;
import com.mayunfeng.road.databinding.FragmentMeBinding;
import com.pikachu.utils.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeFragment extends BaseFragment<FragmentMeBinding> {

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance() {
        return new MeFragment();
    }



    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentMeBinding binding, FragmentActivity activity) {

    }

    @Override
    protected void lazyLoad() {

    }
}