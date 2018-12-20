package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */

public class DuiH_XQ_Bean implements Serializable{


    /**
     * data : [{"juese_yw":"where going","juese_zw":"我们去哪","juese_video":"我.png","juese_name":"lili","juese_id":"7d08ebc2-63bb-4adb-b206-ef199d203db0"},{"juese_yw":"go shopping","juese_zw":"去购物","juese_video":"我不app.png","juese_name":"liming","juese_id":"476d9751-dd7c-411a-8159-6ab213f44085"}]
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

    public static class DataBean implements Serializable{
        /**
         * juese_yw : where going
         * juese_zw : 我们去哪
         * juese_video : 我.png
         * juese_name : lili
         * juese_id : 7d08ebc2-63bb-4adb-b206-ef199d203db0
         */

        private String juese_yw;
        private String juese_zw;
        private String juese_video;
        private String juese_name;
        private String juese_id;
        private Boolean isJS;

        public Boolean getJS() {
            return isJS;
        }

        public void setJS(Boolean JS) {
            isJS = JS;
        }

        public String getJuese_yw() {
            return juese_yw;
        }

        public void setJuese_yw(String juese_yw) {
            this.juese_yw = juese_yw;
        }

        public String getJuese_zw() {
            return juese_zw;
        }

        public void setJuese_zw(String juese_zw) {
            this.juese_zw = juese_zw;
        }

        public String getJuese_video() {
            return juese_video;
        }

        public void setJuese_video(String juese_video) {
            this.juese_video = juese_video;
        }

        public String getJuese_name() {
            return juese_name;
        }

        public void setJuese_name(String juese_name) {
            this.juese_name = juese_name;
        }

        public String getJuese_id() {
            return juese_id;
        }

        public void setJuese_id(String juese_id) {
            this.juese_id = juese_id;
        }
    }
}
