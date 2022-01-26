package com.mayunfeng.road.mode;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.mode
 * @Author: pkpk.run
 * @Description: 首页推荐数据内容
 *
 *首页数据，
 *  type->1(图文类  跳转图文类)  2->(视频类 跳转纯视频)  3->(图片 跳转纯图片)
 *
 */
public class JsonIndexMode implements Serializable {



    private List<TitleDTO> title; // 首页标题
    private List<ContentDTO> content; // 首页内容推荐

    public List<TitleDTO> getTitle() {
        return title;
    }

    public void setTitle(List<TitleDTO> title) {
        this.title = title;
    }

    public List<ContentDTO> getContent() {
        return content;
    }

    public void setContent(List<ContentDTO> content) {
        this.content = content;
    }

    public static class TitleDTO implements Serializable {
        private int type; // 类型 此类型非上面的类型 （以此类型进行数据加载）
        private String title; // 标题Str

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class ContentDTO implements Serializable {  // 内容Json  适配于首页，视频 全部数据
        private int type; // 类型 同上面的类型
        private int userId; // 用户id
        private String userName; // 用户昵称
        private int userGrade; // 用户等级
        private int articleId; // 文章id
        private String articleTitle; // 文章标题
        private String articleContent; // 文章内容 文字
        private int articleCommentNum; //  评论数
        private int articleLaudNum; // 点赞数
        private List<DataSourceDTO> dataSource; // 数据源

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserGrade() {
            return userGrade;
        }

        public void setUserGrade(int userGrade) {
            this.userGrade = userGrade;
        }

        public int getArticleId() {
            return articleId;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public String getArticleTitle() {
            return articleTitle;
        }

        public void setArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
        }

        public String getArticleContent() {
            return articleContent;
        }

        public void setArticleContent(String articleContent) {
            this.articleContent = articleContent;
        }

        public int getArticleCommentNum() {
            return articleCommentNum;
        }

        public void setArticleCommentNum(int articleCommentNum) {
            this.articleCommentNum = articleCommentNum;
        }

        public int getArticleLaudNum() {
            return articleLaudNum;
        }

        public void setArticleLaudNum(int articleLaudNum) {
            this.articleLaudNum = articleLaudNum;
        }

        public List<DataSourceDTO> getDataSource() {
            return dataSource;
        }

        public void setDataSource(List<DataSourceDTO> dataSource) {
            this.dataSource = dataSource;
        }

        public static class DataSourceDTO implements Serializable {
            private int id; // 数据id
            private String url; // 数据url

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
