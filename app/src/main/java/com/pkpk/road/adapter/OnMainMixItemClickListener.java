package com.pkpk.road.adapter;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.adapter
 * @Author: pkpk.run
 * @Description: null
 */
public interface OnMainMixItemClickListener<T> {

    /**
     * 点击用户头像
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    default boolean onClickUserImg(T itemData) {
        return false;
    }


    /**
     * 点击关注
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    default boolean onClickFollow(T itemData) {
        return false;
    }


    /**
     * 点击大视频
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    default boolean onClickVideo(T itemData) {
        return false;
    }


    /**
     * 点击图片
     *
     * @param itemData 数据
     * @param position 位置
     * @return 是否刷新列表
     */
    default boolean onClickImg(T itemData, int position) {
        return false;
    }


    /**
     * 点击分享
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    default boolean onClickShare(T itemData) {
        return false;
    }

    /**
     * 点击评论
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    default boolean onClickComment(T itemData) {
        return false;
    }


    /**
     * 点击点赞
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    default boolean onClickLaud(T itemData) {
        return false;
    }


    /**
     * 点击整个项目
     *
     * @param itemData 数据
     * @return 是否刷新列表
     */
    boolean onClickItem(T itemData);

}
