package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/12/15.
 */

public class XiuG_CG_Bean implements Serializable {


    /**
     * data : {"smg0":"家长手机号下无学生","msg_":"验证码通过"}
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message :
     * icon : null
     * token : null
     * code : 200
     */

    private DataBean data;
    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
    private Object token;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean implements Serializable{
        /**
         * smg0 : 家长手机号下无学生
         * msg_ : 验证码通过
         */

        private String smg0;
        private String msg_;

        public String getSmg0() {
            return smg0;
        }

        public void setSmg0(String smg0) {
            this.smg0 = smg0;
        }

        public String getMsg_() {
            return msg_;
        }

        public void setMsg_(String msg_) {
            this.msg_ = msg_;
        }
    }
}
