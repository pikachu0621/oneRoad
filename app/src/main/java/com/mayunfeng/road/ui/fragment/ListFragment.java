package com.mayunfeng.road.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayunfeng.road.R;
import com.mayunfeng.road.databinding.FragmentIndexBinding;
import com.mayunfeng.road.databinding.FragmentListBinding;
import com.mayunfeng.road.mode.JsonIndexMode;
import com.pikachu.utils.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends BaseFragment<FragmentListBinding> {

    private JsonIndexMode.TitleDTO bundle;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(JsonIndexMode.TitleDTO titleDTO) {
        ListFragment listFragment = new ListFragment();
        setBundle(listFragment, titleDTO);
        return listFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getBundle(JsonIndexMode.TitleDTO.class);
    }

    @Override
    protected void onInitView(Bundle savedInstanceState, FragmentListBinding binding, FragmentActivity activity) {


        binding.list1.setText(bundle.getTitle());

    }

    @Override
    protected void lazyLoad() {



    }
}