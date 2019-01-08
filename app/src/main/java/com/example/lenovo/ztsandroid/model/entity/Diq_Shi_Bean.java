package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */

public class Diq_Shi_Bean implements Serializable {


    /**
     * data : [{"shi_name":"银川市","shi_id":"6401"},{"shi_name":"石嘴山市","shi_id":"6402"},{"shi_name":"吴忠市","shi_id":"6403"},{"shi_name":"固原市","shi_id":"6404"},{"shi_name":"中卫市","shi_id":"6405"}]
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
         * shi_name : 银川市
         * shi_id : 6401
         */

        private String shi_name;
        private String shi_id;

        public String getShi_name() {
            return shi_name;
        }

        public void setShi_name(String shi_name) {
            this.shi_name = shi_name;
        }

        public String getShi_id() {
            return shi_id;
        }

        public void setShi_id(String shi_id) {
            this.shi_id = shi_id;
        }
    }
}
