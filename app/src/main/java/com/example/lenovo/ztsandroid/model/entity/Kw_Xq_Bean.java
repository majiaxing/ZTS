package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Kw_Xq_Bean implements Serializable{


    /**
     * data : [{"text_zw":"早上好","text_video":"yinpin","text_yw":"good morning","text_photo":"photo"}]
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
         * text_zw : 早上好
         * text_video : yinpin
         * text_yw : good morning
         * text_photo : photo
         */

        private String text_zw;
        private String text_video;
        private String text_yw;
        private String text_photo;

        public String getText_zw() {
            return text_zw;
        }

        public void setText_zw(String text_zw) {
            this.text_zw = text_zw;
        }

        public String getText_video() {
            return text_video;
        }

        public void setText_video(String text_video) {
            this.text_video = text_video;
        }

        public String getText_yw() {
            return text_yw;
        }

        public void setText_yw(String text_yw) {
            this.text_yw = text_yw;
        }

        public String getText_photo() {
            return text_photo;
        }

        public void setText_photo(String text_photo) {
            this.text_photo = text_photo;
        }
    }
}
