package com.pikachu.utils.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;

import com.pikachu.utils.utils.LogsUtils;
import com.pikachu.utils.utils.ToastUtils;
import com.pikachu.utils.utils.ViewBindingUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pkpk.run
 * @project 通用工程
 * @package com.pikachu.utils.base
 * @date 2021/9/8
 * @description 用于懒加载 数据等
 */
public abstract class BaseFragment<T extends ViewBinding> extends Fragment {
    private final static String START_STR = "PIKACHU";
    protected View mRootView;
    protected boolean isVisible = false;   //是否可见
    private boolean isPrepared = false;    //是否初始化完成
    private boolean isFirst = true;        //是否第一次加载
    protected T binding;
    protected FragmentActivity context;


    public BaseFragment() {
        // Required empty public constructor
    }





    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mRootView == null) {
            return;
        }
        if (getUserVisibleHint()) {
            isVisible = true;
            initLoad();
        } else {
            isVisible = false;
            onHidden();
        }
    }






    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ViewBindingUtils.create(getClass(), inflater, container);
        if (mRootView == null) {
            mRootView = binding.getRoot();
            //mRootView = initView(inflater, container, savedInstanceState);
            context = getActivity();
            onInitView(savedInstanceState, binding, context);
        }
        context = getActivity();
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        initLoad();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint())
            setUserVisibleHint(true);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null)
            parent.removeView(mRootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isVisible = false;
        isPrepared = false;
        isFirst = true;
        mRootView = null;
    }

    private void initLoad() {
        if (isPrepared && isVisible && !isFirst)
            onShow();
        if (!isPrepared || !isVisible || !isFirst)
            return;
        lazyLoad();
        isFirst = false;
    }


    /**
     * 初始化布局
     */
    protected abstract void onInitView(Bundle savedInstanceState, T binding, FragmentActivity activity);

    /**
     * 懒加载
     */
    protected abstract void lazyLoad();


    /**
     * 不可见时调用
     */
    protected void onHidden() { }


    /**
     * 可见时调用
     *
     * (初始时不调用)
     */
    protected void onShow() { }



    // 发送包
    public static void setBundle(Fragment fragment, Serializable clz) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(START_STR, clz);
        fragment.setArguments(bundle);
    }
    protected <t extends Serializable> t getBundle(Class<t> cls) {
        if (this.getArguments() == null)
            return null;
        return cls.cast(this.getArguments().getSerializable(START_STR));
    }

    protected <t extends Serializable> t getBundle(Bundle savedInstanceState, Class<t> cls) {
        if (this.getArguments() == null)
            return null;
        return cls.cast(savedInstanceState.getSerializable(START_STR));
    }




    /**
     * 页面跳转
     */
    protected void startActivity(Class<?> clz) {
        startActivity(new Intent(getActivity(), clz));
    }


    /**
     * 带数据页面跳转 序列化
     */
    protected void startActivity(Class<?> clz, Serializable cls) {
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtra(START_STR, cls);
        startActivity(intent);
    }

    /**
     * 带数据页面跳转  int
     */
    protected void startActivity(Class<?> clz, int cls) {
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtra(START_STR, cls);
        startActivity(intent);
    }

    /**
     * 带数据页面跳转 string
     */
    protected void startActivity(Class<?> clz, String cls) {
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtra(START_STR, cls);
        startActivity(intent);
    }

    /**
     * 带数据页面跳转 float
     */
    protected void startActivity(Class<?> clz, float cls) {
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtra(START_STR, cls);
        startActivity(intent);
    }
    
    
    
    public void showToast(String... msg) {
        ToastUtils.showToast(context, LogsUtils.forStr(msg));
    }
    public void showToast(Object... msg) {
        ToastUtils.showToast(context, LogsUtils.forStr(Arrays.toString(msg)));
    }

    public void showLog(String... msg) {
        LogsUtils.showLog(context, LogsUtils.forStr(msg));
    }
    public void showLog(Object... msg) {
        List<String> strings = new ArrayList<>();
        for (Object f : msg)
            strings.add(f + "");
        LogsUtils.showLog(context, LogsUtils.forStr(strings.toArray(new String[]{})));
    }




    public int getColor(@ColorRes int id){
        return getResources().getColor(id);
    }



}