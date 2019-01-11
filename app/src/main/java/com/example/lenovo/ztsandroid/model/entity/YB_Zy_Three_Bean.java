package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/2.
 */
public class YB_Zy_Three_Bean implements Serializable{


    /**
     * data : {"typeList":[{"symbol":"ɪ","HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","ybtype":"前元音","video":"1.mp3","Relative_path":"yinbiao/1/","everyScore":11.11}],"Relative_path":"yinbiao/1/"}
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
         * typeList : [{"symbol":"ɪ","HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","ybtype":"前元音","video":"1.mp3","Relative_path":"yinbiao/1/","everyScore":11.11}]
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
             * symbol : ɪ
             * HomeworkPath : homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/
             * ybtype : 前元音
             * video : 1.mp3
             * Relative_path : yinbiao/1/
             * everyScore : 11.11
             */

            private String symbol;
            private String HomeworkPath;
            private String ybtype;
            private String video;
            private String Relative_path;
            private double everyScore;

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getHomeworkPath() {
                return HomeworkPath;
            }

            public void setHomeworkPath(String HomeworkPath) {
                this.HomeworkPath = HomeworkPath;
            }

            public String getYbtype() {
                return ybtype;
            }

            public void setYbtype(String ybtype) {
                this.ybtype = ybtype;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
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
        }
    }
}
