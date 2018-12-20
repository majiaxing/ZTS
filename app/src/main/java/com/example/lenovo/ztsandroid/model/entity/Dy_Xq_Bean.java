package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/28.
 */

public class Dy_Xq_Bean implements Serializable{


    /**
     * data : [{"practice":0,"hw_answerId":"18a6ebad-19cd-4ec3-a862-c2f2fd5bd514","phrase":"last name","phrase_tran":"姓氏","save":"1_2_7_1_1","phrase_video":"last name.mp3","phrase_id":"18a6ebad-19cd-4ec3-a862-c2f2fd5bd514","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"36d24c83-ee85-4e11-8c5e-63bfdf1bd8d0","phrase":"I am ...","save":"1_2_7_1_1","phrase_video":"I am ....mp3","phrase_id":"36d24c83-ee85-4e11-8c5e-63bfdf1bd8d0","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"4ba89d97-5dc2-4d7b-b907-1816991d3c61","phrase":"Good afternoon!","save":"1_2_7_1_1","phrase_video":"Good afternoon.mp3","phrase_id":"4ba89d97-5dc2-4d7b-b907-1816991d3c61","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"577d2f94-8d2f-4593-98d6-be98d7fc3bbf","phrase":"phone number","save":"1_2_7_1_1","phrase_video":"phone number.mp3","phrase_id":"577d2f94-8d2f-4593-98d6-be98d7fc3bbf","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"b6c227da-3478-4567-beee-0432900dcf09","phrase":"middle school","save":"1_2_7_1_1","phrase_video":"middle school.mp3","phrase_id":"b6c227da-3478-4567-beee-0432900dcf09","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"b6cde3f8-1a48-4736-a24d-06a0599fcf8d","phrase":"Good morning!","save":"1_2_7_1_1","phrase_video":"Good morning.mp3","phrase_id":"b6cde3f8-1a48-4736-a24d-06a0599fcf8d","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"ec3e148c-f90a-424d-8a4d-1e85811dc279","phrase":"first name","save":"1_2_7_1_1","phrase_video":"first name.mp3","phrase_id":"ec3e148c-f90a-424d-8a4d-1e85811dc279","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"},{"practice":0,"hw_answerId":"f0d75150-6a1e-4dde-9808-bb53d64ab6ff","phrase":"telephone number","save":"1_2_7_1_1","phrase_video":"telephone number.mp3","phrase_id":"f0d75150-6a1e-4dde-9808-bb53d64ab6ff","Relative_path":"1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/","type":"ab67709c-84e6-4329-a94b-467c8046a4de"}]
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : success
     * icon : null
     * code : 200
     * token : null
     */

    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
    private int code;
    private Object token;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * practice : 0
         * hw_answerId : 18a6ebad-19cd-4ec3-a862-c2f2fd5bd514
         * phrase : last name
         * phrase_tran : 姓氏
         * save : 1_2_7_1_1
         * phrase_video : last name.mp3
         * phrase_id : 18a6ebad-19cd-4ec3-a862-c2f2fd5bd514
         * Relative_path : 1_2_7_1_1/duanyu/ab67709c-84e6-4329-a94b-467c8046a4de/
         * type : ab67709c-84e6-4329-a94b-467c8046a4de
         */

        private int practice;
        private String hw_answerId;
        private String phrase;
        private String phrase_tran;
        private String save;
        private String phrase_video;
        private String phrase_id;
        private String Relative_path;
        private String type;

        public int getPractice() {
            return practice;
        }

        public void setPractice(int practice) {
            this.practice = practice;
        }

        public String getHw_answerId() {
            return hw_answerId;
        }

        public void setHw_answerId(String hw_answerId) {
            this.hw_answerId = hw_answerId;
        }

        public String getPhrase() {
            return phrase;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
        }

        public String getPhrase_tran() {
            return phrase_tran;
        }

        public void setPhrase_tran(String phrase_tran) {
            this.phrase_tran = phrase_tran;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }

        public String getPhrase_video() {
            return phrase_video;
        }

        public void setPhrase_video(String phrase_video) {
            this.phrase_video = phrase_video;
        }

        public String getPhrase_id() {
            return phrase_id;
        }

        public void setPhrase_id(String phrase_id) {
            this.phrase_id = phrase_id;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
