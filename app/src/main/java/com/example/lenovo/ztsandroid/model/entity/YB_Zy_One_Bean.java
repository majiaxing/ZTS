package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/2.
 */

public class YB_Zy_One_Bean implements Serializable{


    /**
     * data : {"typeList":[{"hw_answerId":1,"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/1/","yb_Bvideo":"sit.mp3","avgScore":100,"yb_wordId":1,"yb_Avideo":"sit.mp3","yb_photoes":"sit.jpg","Relative_path":"yinbiao/1/","everyScore":11.11,"yb_translate":"[sɪt] 坐","yb_word":"sit"}],"Relative_path":"yinbiao/1/"}
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : success
     * icon : null
     * token : null
     * code : 200
     */

    private DataBean data;
    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
    private Object token;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * typeList : [{"hw_answerId":1,"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/1/","yb_Bvideo":"sit.mp3","avgScore":100,"yb_wordId":1,"yb_Avideo":"sit.mp3","yb_photoes":"sit.jpg","Relative_path":"yinbiao/1/","everyScore":11.11,"yb_translate":"[sɪt] 坐","yb_word":"sit"}]
         * Relative_path : yinbiao/1/
         */

        private String Relative_path;
        private List<TypeListBean> typeList;

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public List<TypeListBean> getTypeList() {
            return typeList;
        }

        public void setTypeList(List<TypeListBean> typeList) {
            this.typeList = typeList;
        }

        public static class TypeListBean {
            /**
             * hw_answerId : 1
             * HomeworkPath : homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/1/
             * yb_Bvideo : sit.mp3
             * avgScore : 100
             * yb_wordId : 1
             * yb_Avideo : sit.mp3
             * yb_photoes : sit.jpg
             * Relative_path : yinbiao/1/
             * everyScore : 11.11
             * yb_translate : [sɪt] 坐
             * yb_word : sit
             */

            private int hw_answerId;
            private String HomeworkPath;
            private String yb_Bvideo;
            private int avgScore;
            private int yb_wordId;
            private String yb_Avideo;
            private String yb_photoes;
            private String Relative_path;
            private double everyScore;
            private String yb_translate;
            private String yb_word;

            public int getHw_answerId() {
                return hw_answerId;
            }

            public void setHw_answerId(int hw_answerId) {
                this.hw_answerId = hw_answerId;
            }

            public String getHomeworkPath() {
                return HomeworkPath;
            }

            public void setHomeworkPath(String HomeworkPath) {
                this.HomeworkPath = HomeworkPath;
            }

            public String getYb_Bvideo() {
                return yb_Bvideo;
            }

            public void setYb_Bvideo(String yb_Bvideo) {
                this.yb_Bvideo = yb_Bvideo;
            }

            public int getAvgScore() {
                return avgScore;
            }

            public void setAvgScore(int avgScore) {
                this.avgScore = avgScore;
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

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
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
}
