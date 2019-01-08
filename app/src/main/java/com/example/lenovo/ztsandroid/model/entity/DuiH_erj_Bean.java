package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */

public class DuiH_erj_Bean implements Serializable {


    /**
     * data : [{"talk_id":"95e42fa3-14a8-438b-bf06-8d52727c1c5b","practice":"0/6","talk_name":"Introducing and Greeting","save":"1_2_7_1_2001","Relative_path":"1_2_7_1_2001/duihua/95e42fa3-14a8-438b-bf06-8d52727c1c5b/"}]
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
         * talk_id : 95e42fa3-14a8-438b-bf06-8d52727c1c5b
         * practice : 0/6
         * talk_name : Introducing and Greeting
         * save : 1_2_7_1_2001
         * Relative_path : 1_2_7_1_2001/duihua/95e42fa3-14a8-438b-bf06-8d52727c1c5b/
         */

        private String talk_id;
        private String practice;
        private String talk_name;
        private String save;
        private String Relative_path;

        public String getTalk_id() {
            return talk_id;
        }

        public void setTalk_id(String talk_id) {
            this.talk_id = talk_id;
        }

        public String getPractice() {
            return practice;
        }

        public void setPractice(String practice) {
            this.practice = practice;
        }

        public String getTalk_name() {
            return talk_name;
        }

        public void setTalk_name(String talk_name) {
            this.talk_name = talk_name;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }
    }
}
