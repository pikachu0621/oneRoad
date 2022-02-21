package com.mayunfeng.road.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.view.marginLeft
import androidx.core.view.marginStart
import com.mayunfeng.road.base.BaseBActivity
import com.mayunfeng.road.databinding.ActivityLookArticleBinding

class LookArticleActivity : BaseBActivity<ActivityLookArticleBinding>() {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun initBActivity(savedInstanceState: Bundle?) {



        binding.lookRt.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

            val layoutParams = binding.tty.layoutParams
            layoutParams.height = scrollY
            binding.tty.layoutParams = layoutParams

        }

    }

}