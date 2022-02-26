package com.mayunfeng.road.mode

import java.io.Serializable

data class JsonCommentMode(
        val content: List<Content>,
        val message: String
        ) : Serializable {


    data class Content(
            val commentComment: List<CommentComment>,
            val commentContent: String,
            val commentId: Int,
            val commentImage: List<CommentImage>,
            val commentLaudNum: Int,
            val commentTime: String,
            val type: Int,
            val userGrade: Int,
            val userId: Int,
            val userImage: String,
            val userName: String
    )

    data class CommentComment(
            val commentLaudNum: Int,
            val commentTime: String,
            val tCommentContent: String,
            val tCommentImage: List<TCommentImage>,
            val tUerGrade: Int,
            val tUserId: Int,
            val tUserImage: String,
            val tUserName: String
    )

    data class CommentImage(
            val imgId: Int,
            val imgPxh: Int,
            val imgUrl: String,
            val videoId: Int,
            val videoUrl: String
    )

    data class TCommentImage(
            val imgId: Int,
            val imgPxh: Int,
            val imgUrl: String,
            val videoId: Int,
            val videoUrl: String
    )


}