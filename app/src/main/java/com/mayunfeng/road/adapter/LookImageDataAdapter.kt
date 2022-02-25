package com.mayunfeng.road.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mayunfeng.road.databinding.UiLookItemImgBinding
import com.mayunfeng.road.mode.JsonIndexMode
import com.pikachu.utils.adapter.QuickAdapter
import com.pikachu.utils.utils.GlideUtils
import com.pikachu.utils.utils.UiUtils

/**
 *
 * @ProjectName:    一带一路
 * @Package:        com.mayunfeng.road.adapter
 * @Author:         pkpk.run
 * @Description:    null
 */
class LookImageDataAdapter : QuickAdapter<UiLookItemImgBinding, JsonIndexMode.ContentDTO.DataSourceDTO> {

    private var screenWidth: Int = 0
    private var context: Context? = null

    constructor(data: List<JsonIndexMode.ContentDTO.DataSourceDTO>, context: Context, wNum: Int = 3, distanceDp: Int = 16, mDisDp: Int = 2) : super(data) {
        this.context = context
        screenWidth = (UiUtils.getScreenWidth(context) - UiUtils.dp2px(context, distanceDp.toFloat()) * 2 - UiUtils.dp2px(context, mDisDp.toFloat()) * (wNum * 2)) / wNum
    }

    override fun onQuickBindView(binding: UiLookItemImgBinding, itemData: JsonIndexMode.ContentDTO.DataSourceDTO, position: Int, data: List<JsonIndexMode.ContentDTO.DataSourceDTO>) {
        binding.root.layoutParams.height = screenWidth
        GlideUtils.with(context).load(itemData.imgUrl).into(binding.img3Root1)
    }


    companion object {
        fun setAdapter(data:  List<JsonIndexMode.ContentDTO.DataSourceDTO>, context: Context, recyclerView: RecyclerView) {
            recyclerView.adapter = LookImageDataAdapter(data, context)
            recyclerView.layoutManager = GridLayoutManager(context, 3)
        }
    }


}