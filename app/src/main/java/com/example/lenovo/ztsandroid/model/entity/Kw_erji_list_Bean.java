package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Kw_erji_list_Bean {


    /**
     * data : [{"text_id":"1","save_path":"1_2_7_1_1/kewen/1/","text_title":"Good morning","save":"1_2_7_1_1"},{"text_id":"2","save_path":"1_2_7_1_1/kewen/2/","text_title":"What is color is it","save":"1_2_7_1_1"},{"text_id":"3","save_path":"1_2_7_1_1/kewen/3/","text_title":"My name is Lisa","save":"1_2_7_1_1"},{"text_id":"4","save_path":"1_2_7_1_1/kewen/4/","text_title":"What happen","save":"1_2_7_1_1"},{"text_id":"851f48b4-3ddd-4d10-80f1-0497b5fbe2a5","save_path":"1_2_7_1_1/kewen/851f48b4-3ddd-4d10-80f1-0497b5fbe2a5/","text_title":"i love u for baby","save":"1_2_7_1_1"},{"text_id":"ad8c2bb3-60be-4b1b-8450-a9473649f4d8","save_path":"1_2_7_1_1/kewen/ad8c2bb3-60be-4b1b-8450-a9473649f4d8/","text_title":"i love u for baby","save":"1_2_7_1_1"},{"text_id":"f96beaad-0357-469f-b7e0-5b3d86c139b8","save_path":"1_2_7_1_1/kewen/f96beaad-0357-469f-b7e0-5b3d86c139b8/","text_title":"1","save":"1_2_7_1_1"}]
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
         * text_id : 1
         * save_path : 1_2_7_1_1/kewen/1/
         * text_title : Good morning
         * save : 1_2_7_1_1
         */

        private String text_id;
        private String save_path;
        private String text_title;
        private String save;

        public String getText_id() {
            return text_id;
        }

        public void setText_id(String text_id) {
            this.text_id = text_id;
        }

        public String getSave_path() {
            return save_path;
        }

        public void setSave_path(String save_path) {
            this.save_path = save_path;
        }

        public String getText_title() {
            return text_title;
        }

        public void setText_title(String text_title) {
            this.text_title = text_title;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }
    }
}
