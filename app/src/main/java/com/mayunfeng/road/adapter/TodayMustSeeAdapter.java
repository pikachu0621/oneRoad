package com.mayunfeng.road.adapter;

import com.mayunfeng.road.databinding.UiMainItemTodayBinding;
import com.mayunfeng.road.mode.JsonIndexTodayMode;
import com.pikachu.utils.adapter.QuickAdapter;

import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.adapter
 * @Author: pkpk.run
 * @Description: null 混合
 */
public class TodayMustSeeAdapter extends QuickAdapter<UiMainItemTodayBinding, JsonIndexTodayMode> {


    public TodayMustSeeAdapter(List<JsonIndexTodayMode> data) {
        super(data);
    }

    @Override
    public void onQuickBindView(UiMainItemTodayBinding binding, JsonIndexTodayMode itemData, int position, List<JsonIndexTodayMode> data) {

    }



}
