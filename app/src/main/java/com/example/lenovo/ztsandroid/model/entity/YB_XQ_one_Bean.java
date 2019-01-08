package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class YB_XQ_one_Bean implements Serializable {


    /**
     * data : [{"hw_answerId":1,"yb_Bvideo":"sit[sɪt]坐.mp3","yb_wordId":1,"yb_Avideo":"sit[sɪt]坐.mp3","yb_photoes":"sit[sɪt]坐.jpg","Relative_path":"yinbiao/1/","yb_translate":"[sɪt] 坐","yb_word":"sit"}]
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
         * hw_answerId : 1
         * yb_Bvideo : sit[sɪt]坐.mp3
         * yb_wordId : 1
         * yb_Avideo : sit[sɪt]坐.mp3
         * yb_photoes : sit[sɪt]坐.jpg
         * Relative_path : yinbiao/1/
         * yb_translate : [sɪt] 坐
         * yb_word : sit
         */

        private int hw_answerId;
        private String yb_Bvideo;
        private int yb_wordId;
        private String yb_Avideo;
        private String yb_photoes;
        private String Relative_path;
        private String yb_translate;
        private String yb_word;

        public int getHw_answerId() {
            return hw_answerId;
        }

        public void setHw_answerId(int hw_answerId) {
            this.hw_answerId = hw_answerId;
        }

        public String getYb_Bvideo() {
            return yb_Bvideo;
        }

        public void setYb_Bvideo(String yb_Bvideo) {
            this.yb_Bvideo = yb_Bvideo;
        }

        public int getYb_wordId() {
            return yb_wordId;
        }

        public void setYb_wordId(int yb_wordId) {
            this.yb_wordId = yb_wordId;
        }

        public String getYb_Avideo() {
            return yb_Avideo;
        }

        public void setYb_Avideo(String yb_Avideo) {
            this.yb_Avideo = yb_Avideo;
        }

        public String getYb_photoes() {
            return yb_photoes;
        }

        public void setYb_photoes(String yb_photoes) {
            this.yb_photoes = yb_photoes;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public String getYb_translate() {
            return yb_translate;
        }

        public void setYb_translate(String yb_translate) {
            this.yb_translate = yb_translate;
        }

        public String getYb_word() {
            return yb_word;
        }

        public void setYb_word(String yb_word) {
            this.yb_word = yb_word;
        }
    }
}
