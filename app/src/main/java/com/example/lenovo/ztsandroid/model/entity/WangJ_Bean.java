package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/12/7.
 */

public class WangJ_Bean {


    /**
     * data : {"msg0":"发送成功","SessionID":"4446ED7D584D685C53E1E008F1FB7E63"}
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : 发送成功
     * icon : null
     * code : 200
     * token : null
     */

    private DataBean data;
    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
    private int code;
    private Object token;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public static class DataBean {
        /**
         * msg0 : 发送成功
         * SessionID : 4446ED7D584D685C53E1E008F1FB7E63
         */

        private String msg0;
        private String SessionID;

        public String getMsg0() {
            return msg0;
        }

        public void setMsg0(String msg0) {
            this.msg0 = msg0;
        }

        public String getSessionID() {
            return SessionID;
        }

        public void setSessionID(String SessionID) {
            this.SessionID = SessionID;
        }
    }
}
