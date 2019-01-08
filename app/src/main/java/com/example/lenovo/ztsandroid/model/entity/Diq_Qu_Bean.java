package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */

public class Diq_Qu_Bean implements Serializable{


    /**
     * data : [{"qu_name":"市辖区","qu_id":"640101"},{"qu_name":"兴庆区","qu_id":"640104"},{"qu_name":"西夏区","qu_id":"640105"},{"qu_name":"金凤区","qu_id":"640106"},{"qu_name":"永宁县","qu_id":"640121"},{"qu_name":"贺兰县","qu_id":"640122"},{"qu_name":"灵武市","qu_id":"640181"}]
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
         * qu_name : 市辖区
         * qu_id : 640101
         */

        private String qu_name;
        private String qu_id;

        public String getQu_name() {
            return qu_name;
        }

        public void setQu_name(String qu_name) {
            this.qu_name = qu_name;
        }

        public String getQu_id() {
            return qu_id;
        }

        public void setQu_id(String qu_id) {
            this.qu_id = qu_id;
        }
    }
}
