package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Read_erj_Bean {


    /**
     * data : [{"read_id":"784e672c-3bac-465c-8d8d-f6ceae98e0c7","save":"1_2_7_1_1","read_title":"we","Relative_path":"1_2_7_1_1/yuedu/784e672c-3bac-465c-8d8d-f6ceae98e0c7/"}]
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
         * read_id : 784e672c-3bac-465c-8d8d-f6ceae98e0c7
         * save : 1_2_7_1_1
         * read_title : we
         * Relative_path : 1_2_7_1_1/yuedu/784e672c-3bac-465c-8d8d-f6ceae98e0c7/
         */

        private String read_id;
        private String save;
        private String read_title;
        private String Relative_path;

        public String getRead_id() {
            return read_id;
        }

        public void setRead_id(String read_id) {
            this.read_id = read_id;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }

        public String getRead_title() {
            return read_title;
        }

        public void setRead_title(String read_title) {
            this.read_title = read_title;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }
    }
}
