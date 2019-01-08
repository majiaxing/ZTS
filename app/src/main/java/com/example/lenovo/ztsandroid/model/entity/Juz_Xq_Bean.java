package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */

public class Juz_Xq_Bean implements Serializable {


    /**
     * data : [{"sentence_id":"3a7eb7f8-83ab-4208-bcf3-df4f8f060e17","sentence_yw":"sentence","sentence_sid":"a4934d14-1cbc-4286-8776-9d05a331d8bb","sentence_zw":"句子a","sentence_video":"abc"},{"sentence_id":"3a7eb7f8-83ab-4208-bcf3-df4f8f060e17","sentence_yw":"sentence2","sentence_sid":"bfadf288-17bb-435e-8d11-ed66a45ca00b","sentence_zw":"句子b","sentence_video":"lili"},{"sentence_id":"3a7eb7f8-83ab-4208-bcf3-df4f8f060e17","sentence_yw":"ence","sentence_sid":"6a8ad427-2c7b-4393-8077-fb1df9452bd5","sentence_zw":"句子c","sentence_video":"1212"},{"sentence_id":"3a7eb7f8-83ab-4208-bcf3-df4f8f060e17","sentence_yw":"dede","sentence_sid":"a2c9b401-29de-41be-a41e-6dcf589bf47a","sentence_zw":"句子d","sentence_video":"dede"}]
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
         * sentence_id : 3a7eb7f8-83ab-4208-bcf3-df4f8f060e17
         * sentence_yw : sentence
         * sentence_sid : a4934d14-1cbc-4286-8776-9d05a331d8bb
         * sentence_zw : 句子a
         * sentence_video : abc
         */

        private String sentence_id;
        private String sentence_yw;
        private String sentence_sid;
        private String sentence_zw;
        private String sentence_video;

        public String getSentence_id() {
            return sentence_id;
        }

        public void setSentence_id(String sentence_id) {
            this.sentence_id = sentence_id;
        }

        public String getSentence_yw() {
            return sentence_yw;
        }

        public void setSentence_yw(String sentence_yw) {
            this.sentence_yw = sentence_yw;
        }

        public String getSentence_sid() {
            return sentence_sid;
        }

        public void setSentence_sid(String sentence_sid) {
            this.sentence_sid = sentence_sid;
        }

        public String getSentence_zw() {
            return sentence_zw;
        }

        public void setSentence_zw(String sentence_zw) {
            this.sentence_zw = sentence_zw;
        }

        public String getSentence_video() {
            return sentence_video;
        }

        public void setSentence_video(String sentence_video) {
            this.sentence_video = sentence_video;
        }
    }
}
