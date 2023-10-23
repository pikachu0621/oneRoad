package com.pkpk.road.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.pkpk.road.R;
import com.pkpk.road.databinding.UiMsgItemTalkBinding;
import com.pkpk.road.mode.JsonMsgMode;
import com.pikachu.utils.adapter.QuickAdapter;
import com.pikachu.utils.utils.GlideUtils;

import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.adapter
 * @Author: pkpk.run
 * @Description: null
 */
public class MainMsgAdapter extends QuickAdapter<UiMsgItemTalkBinding, JsonMsgMode.ContentDTO> {

    private final Drawable drawable1, drawable2, drawable3, drawable4;

    @SuppressLint("UseCompatLoadingForDrawables")
    public MainMsgAdapter(List<JsonMsgMode.ContentDTO> data, Context context) {
        super(data);

        drawable1 = context.getResources().getDrawable(R.drawable.dw_main_msg_type1_bg);
        drawable2 = context.getResources().getDrawable(R.drawable.dw_main_msg_type2_bg);
        drawable3 = context.getResources().getDrawable(R.drawable.dw_main_msg_type3_bg);
        drawable4 = context.getResources().getDrawable(R.drawable.dw_main_msg_type4_bg);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onQuickBindView(UiMsgItemTalkBinding binding, JsonMsgMode.ContentDTO itemData, int position, List<JsonMsgMode.ContentDTO> data) {
        Drawable drawable = drawable1;
        String str = "官方";
        int color = 0xFFE44545;
        if (itemData.getType() == -2){
            drawable = drawable2;
            str = "认证";
            color = 0xFF45B2E4;
        }else if (itemData.getType() == -3){
            drawable = drawable3;
            str = "好友";
            color = 0xFF45E4A4;
        }else if (itemData.getType() == -4){
            drawable = drawable4;
            str = "不详";
            color = 0xFFE4CA45;
        }
        binding.mL6.setText(str);
        binding.mL6.setBackgroundDrawable(drawable);
        binding.mL1.setBorderColor(color);

        GlideUtils.with(context).load(itemData.getUserImage()).into(binding.mL1);
        binding.mL2.setText(itemData.getUserName());

        JsonMsgMode.ContentDTO.MsgListDTO msgDTO = itemData.getMsgList().get(0);
        binding.mL3.setText(msgDTO.getMsgTime());
        binding.mL4.setText(msgDTO.getMsgStr());
        binding.mL5.setText(itemData.getMsgNewNum() > 99 ? "99+" : itemData.getMsgNewNum() + "");

    }
}
