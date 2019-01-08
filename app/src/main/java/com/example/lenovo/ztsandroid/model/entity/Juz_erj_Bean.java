package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Juz_erj_Bean implements Serializable {


    /**
     * data : [{"practice":"0/10","sentence_id":"1932bac1-be10-43bc-85df-ae00a5620f58","sentence_name":"Sentences","save":"1_2_8_2_2003","Relative_path":"1_2_8_2_2003/jvzi/1932bac1-be10-43bc-85df-ae00a5620f58/"}]
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
         * practice : 0/10
         * sentence_id : 1932bac1-be10-43bc-85df-ae00a5620f58
         * sentence_name : Sentences
         * save : 1_2_8_2_2003
         * Relative_path : 1_2_8_2_2003/jvzi/1932bac1-be10-43bc-85df-ae00a5620f58/
         */

        private String practice;
        private String sentence_id;
        private String sentence_name;
        private String save;
        private String Relative_path;

        public String getPractice() {
            return practice;
        }

        public void setPractice(String practice) {
            this.practice = practice;
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

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }
    }
}
