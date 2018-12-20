package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Juz_erj_Bean {


    /**
     * data : [{"save_path":"1_2_7_1_1/jvzi/05ec16a8-07a6-4da9-acf8-72a357ffcbf3/","sentence_id":"05ec16a8-07a6-4da9-acf8-72a357ffcbf3","sentence_name":"2222222222222","save":"1_2_7_1_1"}]
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
         * save_path : 1_2_7_1_1/jvzi/05ec16a8-07a6-4da9-acf8-72a357ffcbf3/
         * sentence_id : 05ec16a8-07a6-4da9-acf8-72a357ffcbf3
         * sentence_name : 2222222222222
         * save : 1_2_7_1_1
         */

        private String save_path;
        private String sentence_id;
        private String sentence_name;
        private String save;

        public String getSave_path() {
            return save_path;
        }

        public void setSave_path(String save_path) {
            this.save_path = save_path;
        }

        public String getSentence_id() {
            return sentence_id;
        }

        public void setSentence_id(String sentence_id) {
            this.sentence_id = sentence_id;
        }

        public String getSentence_name() {
            return sentence_name;
        }

        public void setSentence_name(String sentence_name) {
            this.sentence_name = sentence_name;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }
    }
}
