package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/2.
 */

public class YB_Zy_Two_Bean implements Serializable {


    /**
     * data : {"typeList":[{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_photo":"","yb_human":"2_2.mp4","Relative_path":"yinbiao/1/","everyScore":11.11,"yb_cartoon":"2_1.mp4","yb_translate":"[ɪ]是短元音。发音时，舌尖抵住下齿龈，嘴微微张开， 上下牙之间能放下一个小拇指的距离。发音秘诀:一定要收小腹。"}],"Relative_path":"yinbiao/1/"}
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

    public static class DataBean implements Serializable{
        /**
         * typeList : [{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_photo":"","yb_human":"2_2.mp4","Relative_path":"yinbiao/1/","everyScore":11.11,"yb_cartoon":"2_1.mp4","yb_translate":"[ɪ]是短元音。发音时，舌尖抵住下齿龈，嘴微微张开， 上下牙之间能放下一个小拇指的距离。发音秘诀:一定要收小腹。"}]
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

        public static class TypeListBean implements Serializable{
            /**
             * HomeworkPath : homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/
             * yb_photo :
             * yb_human : 2_2.mp4
             * Relative_path : yinbiao/1/
             * everyScore : 11.11
             * yb_cartoon : 2_1.mp4
             * yb_translate : [ɪ]是短元音。发音时，舌尖抵住下齿龈，嘴微微张开， 上下牙之间能放下一个小拇指的距离。发音秘诀:一定要收小腹。
             */

            private String HomeworkPath;
            private String yb_photo;
            private String yb_human;
            private String Relative_path;
            private double everyScore;
            private String yb_cartoon;
            private String yb_translate;

            public String getHomeworkPath() {
                return HomeworkPath;
            }

            public void setHomeworkPath(String HomeworkPath) {
                this.HomeworkPath = HomeworkPath;
            }

            public String getYb_photo() {
                return yb_photo;
            }

            public void setYb_photo(String yb_photo) {
                this.yb_photo = yb_photo;
            }

            public String getYb_human() {
                return yb_human;
            }

            public void setYb_human(String yb_human) {
                this.yb_human = yb_human;
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

            public String getYb_cartoon() {
                return yb_cartoon;
            }

            public void setYb_cartoon(String yb_cartoon) {
                this.yb_cartoon = yb_cartoon;
            }

            public String getYb_translate() {
                return yb_translate;
            }

            public void setYb_translate(String yb_translate) {
                this.yb_translate = yb_translate;
            }
        }
    }
}
