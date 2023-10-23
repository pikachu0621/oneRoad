package com.pkpk.road.mode;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.mode
 * @Author: pkpk.run
 * @Description: null
 */
public class JsonMeData {


    private String message;
    private ContentDTO content;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContentDTO getContent() {
        return content;
    }

    public void setContent(ContentDTO content) {
        this.content = content;
    }

    public static class ContentDTO {
        private int userId;                       // 用户id
        private String userIdStr;                 // 用户id编号
        private String userName;                  // 用户名字
        private int userGrade;                    // 用户等级
        private String userImage;                 // 用户头像
        private int userSex;                      // 用户性别
        private String userConstellation;         // 用户星座
        private String userArea;                  // 用户地区
        private int userBirthday;                 // 用户生日
        private String userProfession;            // 用户职业
        private String userSchool;                // 用户学校
        private String userExpound;               // 用户个性签名
        private String userBackgroundImage;       // 用户背景图片
        private String userFollow;                // 用户关注 （我关注的）
        private String userFan;                   // 用户粉丝 （关注我的）
        private String userPraiseAndCollect;      // 用户收到的点赞和收藏

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserIdStr() {
            return userIdStr;
        }

        public void setUserIdStr(String userIdStr) {
            this.userIdStr = userIdStr;
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

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public String getUserConstellation() {
            return userConstellation;
        }

        public void setUserConstellation(String userConstellation) {
            this.userConstellation = userConstellation;
        }

        public String getUserArea() {
            return userArea;
        }

        public void setUserArea(String userArea) {
            this.userArea = userArea;
        }

        public int getUserBirthday() {
            return userBirthday;
        }

        public void setUserBirthday(int userBirthday) {
            this.userBirthday = userBirthday;
        }

        public String getUserProfession() {
            return userProfession;
        }

        public void setUserProfession(String userProfession) {
            this.userProfession = userProfession;
        }

        public String getUserSchool() {
            return userSchool;
        }

        public void setUserSchool(String userSchool) {
            this.userSchool = userSchool;
        }

        public String getUserExpound() {
            return userExpound;
        }

        public void setUserExpound(String userExpound) {
            this.userExpound = userExpound;
        }

        public String getUserBackgroundImage() {
            return userBackgroundImage;
        }

        public void setUserBackgroundImage(String userBackgroundImage) {
            this.userBackgroundImage = userBackgroundImage;
        }

        public String getUserFollow() {
            return userFollow;
        }

        public void setUserFollow(String userFollow) {
            this.userFollow = userFollow;
        }

        public String getUserFan() {
            return userFan;
        }

        public void setUserFan(String userFan) {
            this.userFan = userFan;
        }

        public String getUserPraiseAndCollect() {
            return userPraiseAndCollect;
        }

        public void setUserPraiseAndCollect(String userPraiseAndCollect) {
            this.userPraiseAndCollect = userPraiseAndCollect;
        }
    }
}
