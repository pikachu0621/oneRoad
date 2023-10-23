package com.pkpk.road.adapter

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.pkpk.road.databinding.UiLookItemCommentBinding
import com.pkpk.road.mode.JsonCommentMode
import com.pikachu.utils.adapter.QuickAdapter
import com.pikachu.utils.utils.GlideUtils
import com.pikachu.utils.utils.AssetsUtils

class LookCommentAdapter(data: List<JsonCommentMode.Content>?) : QuickAdapter<UiLookItemCommentBinding, JsonCommentMode.Content>(data) {
    @SuppressLint("SetTextI18n")
    override fun onQuickBindView(binding: UiLookItemCommentBinding, itemData: JsonCommentMode.Content, position: Int, data: List<JsonCommentMode.Content>) {
        // 头像
        GlideUtils.with(context).load(itemData.userImage).into(binding.QMUIRadiusImageView3)
        // 昵称
        binding.img35.text = itemData.userName
        // 内容
        binding.appCompatTextView9.text = itemData.commentContent
        // 回复
        binding.appCompatTextView10.text = "${itemData.commentComment.size} 回复"
        // 时间
        binding.appCompatTextView11.text = itemData.commentTime
        // 点赞
        binding.img19.text = itemData.commentLaudNum.toString()
    }


    companion object{
        fun setAdapter(context: Context, id: Int, recycler:RecyclerView){
            val jsonStr = AssetsUtils.readAssetsString(context, "comment/${id}.json")
            val fromJson = Gson().fromJson(jsonStr, JsonCommentMode::class.java)
            recycler.adapter = LookCommentAdapter(fromJson.content)
            recycler.layoutManager = LinearLayoutManager(context)
        }
    }

}