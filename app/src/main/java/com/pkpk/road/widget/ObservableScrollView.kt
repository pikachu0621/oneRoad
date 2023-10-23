package com.pkpk.road.widget

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView

/**
 * @author pkpk.run
 * @project 一带一路
 * @package com.mayunfeng.road.widget
 * @date 2022/2/25
 * @description 略
 */


class ObservableScrollView : NestedScrollView {

    private var onScrollChangeListener: OnScrollChangeListener? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    interface OnScrollChangeListener {
        fun onScrollChange(v: Int, scrollX: Int, scrollY: Int, oldScrollX: Int)
    }

    fun setScrollViewListener(onScrollChangeListener : OnScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        if(onScrollChangeListener != null){
            onScrollChangeListener!!.onScrollChange(l, t, oldl, oldt)
        }
    }

}