package com.mayunfeng.road.mode;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: 一带一路
 * @Package: com.mayunfeng.road.mode
 * @Author: pkpk.run
 * @Description: null
 */
public class JsonTabMode implements Serializable {


    private String message;
    private List<TitleDTO> title;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TitleDTO> getTitle() {
        return title;
    }

    public void setTitle(List<TitleDTO> title) {
        this.title = title;
    }

    public static class TitleDTO implements Serializable {
        private int type; // 类型 此类型非上面的类型 （以此类型进行数据加载）  1 2 3 4 5 6 7
        private String title; // 标题Str
        private String url; // 加载数据地址  pag=0

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
