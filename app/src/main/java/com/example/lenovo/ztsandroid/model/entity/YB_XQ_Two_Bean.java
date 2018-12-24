package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class YB_XQ_Two_Bean {


    /**
     * data : [{"yb_human":"2_2.mp4","Relative_path":"yinbiao/2/","yb_cartoon":"2_1.mp3","yb_translate":"2_1.gif"}]
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : success
     * icon : null
     * token : null
     * code : 200
     */

    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
    private Object token;
    private int code;
    private List<DataBean> data;

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public Object getData3() {
        return data3;
    }

    public void setData3(Object data3) {
        this.data3 = data3;
    }

    public Object getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Object pageInfo) {
        this.pageInfo = pageInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * yb_human : 2_2.mp4
         * Relative_path : yinbiao/2/
         * yb_cartoon : 2_1.mp3
         * yb_translate : 2_1.gif
         */

        private String yb_human;
        private String Relative_path;
        private String yb_cartoon;
        private String yb_translate;

        public String getYb_human() {
            return yb_human;
        }

        public void setYb_human(String yb_human) {
            this.yb_human = yb_human;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public String getYb_cartoon() {
            return yb_cartoon;
        }

        public void setYb_cartoon(String yb_cartoon) {
            this.yb_cartoon = yb_cartoon;
        }

        public String getYb_translate() {
            return yb_translate;
        }

        public void setYb_translate(String yb_translate) {
            this.yb_translate = yb_translate;
        }
    }
}
