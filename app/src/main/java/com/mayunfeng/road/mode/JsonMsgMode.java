package com.mayunfeng.road.mode;

import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.mode
 * @Author: pkpk.run
 * @Description: 模拟聊天列表
 */
public class JsonMsgMode {
    private String message;
    private List<ContentDTO> content;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ContentDTO> getContent() {
        return content;
    }

    public void setContent(List<ContentDTO> content) {
        this.content = content;
    }

    public static class ContentDTO {
        private int type;     // -1 官方  -2 认证  -3 好友  -4 陌生人
        private int userId; // 对方Id
        private String userName; // 对方name
        private int userGrade; // 对方等级
        private String userImage; // 对方头像
        private int msgNewNum; // 新消息数量
        private List<MsgListDTO> msgList; // 会话list

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

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public int getMsgNewNum() {
            return msgNewNum;
        }

        public void setMsgNewNum(int msgNewNum) {
            this.msgNewNum = msgNewNum;
        }

        public List<MsgListDTO> getMsgList() {
            return msgList;
        }

        public void setMsgList(List<MsgListDTO> msgList) {
            this.msgList = msgList;
        }

        public static class MsgListDTO {
            private String msgStr; // 会话内容
            private int msgType; // 会话类型 0 对方    1自己
            private String msgTime; // 会话时间

            public String getMsgStr() {
                return msgStr;
            }

            public void setMsgStr(String msgStr) {
                this.msgStr = msgStr;
            }

            public int getMsgType() {
                return msgType;
            }

            public void setMsgType(int msgType) {
                this.msgType = msgType;
            }

            public String getMsgTime() {
                return msgTime;
            }

            public void setMsgTime(String msgTime) {
                this.msgTime = msgTime;
            }
        }
    }







}
