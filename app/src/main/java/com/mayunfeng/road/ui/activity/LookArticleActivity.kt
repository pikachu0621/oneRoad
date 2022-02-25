package com.mayunfeng.road.ui.activity

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import com.mayunfeng.road.adapter.LookImageDataAdapter
import com.mayunfeng.road.base.BaseBActivity
import com.mayunfeng.road.databinding.ActivityLookArticleBinding
import com.mayunfeng.road.databinding.UiLookItemImgBinding
import com.mayunfeng.road.mode.JsonIndexMode
import com.mayunfeng.road.widget.ObservableScrollView
import com.pikachu.utils.adapter.QuickAdapter
import com.pikachu.utils.utils.GlideUtils
import com.pikachu.utils.utils.TimeUtils
import com.pikachu.utils.utils.UiUtils

class LookArticleActivity : BaseBActivity<ActivityLookArticleBinding>() {


    private lateinit var content : JsonIndexMode.ContentDTO

    override fun initBActivity(savedInstanceState: Bundle?) {
        content = getSerializableExtra(JsonIndexMode.ContentDTO::class.java)
        scrollChangeTop()
        click()
        initData()
    }

    private fun initData() {
        // 头像
        GlideUtils.with(context).load(content.userImage).into(binding.tty)
        GlideUtils.with(context).load(content.userImage).into(binding.QMUIRadiusImageView2)
        // 昵称
        binding.tty1.text = content.userName
        binding.appCompatTextView5.text = content.userName
        // 时间
        binding.appCompatTextView6.text = TimeUtils.dataToStr(TimeUtils.longToDate(content.articleOutTime), "yyyy/MM/dd")
        // 标题
        binding.appCompatTextView7.text = content.articleTitle
        // 内容
        binding.appCompatTextView8.text = Html.fromHtml(content.articleContent)
        // 图片
        LookImageDataAdapter.setAdapter(content.dataSource, context, binding.recyclerImg)
        // 
    }

    private fun click() {
        binding.appCompatImageView4.setOnClickListener {
            finish()
        }
    }


    private fun scrollChangeTop() {
        var actionBarHeight = UiUtils.dp2px(context, 60F)
        val tv = TypedValue()
        if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight =
                TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
        }
        val screenWidth = UiUtils.getScreenWidth(context) / 2 + actionBarHeight

        val layoutParams = binding.tty.layoutParams as ConstraintLayout.LayoutParams
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.lookRt.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                onScroll(scrollY, screenWidth, layoutParams)
            }
        } else {
            binding.lookRt.setScrollViewListener(object :
                ObservableScrollView.OnScrollChangeListener {
                override fun onScrollChange(v: Int, scrollX: Int, scrollY: Int, oldScrollX: Int) {
                    onScroll(scrollY, screenWidth, layoutParams)
                }
            })
        }
    }


    private fun onScroll(
        scrollY: Int,
        maxScrollY: Int,
        layoutParams: ConstraintLayout.LayoutParams
    ) {
        val fl = scrollY * 1.7F
        val d: Float = 1F / maxScrollY
        val moveI: Int
        val moveAlpha: Float
        if (fl > maxScrollY) {
            moveI = maxScrollY
            moveAlpha = 1F
        } else {
            moveI = fl.toInt()
            moveAlpha = fl * d
        }
        layoutParams.marginEnd = moveI;
        binding.tty.layoutParams = layoutParams
        binding.tty1.alpha = moveAlpha
        binding.tty2.alpha = moveAlpha
    }

}