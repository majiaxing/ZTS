package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_Dh_Bean implements Serializable{


    /**
     * data : {"HomeworkPath":"homework/4567/41/","typeList":[{"juese_yw":"Sally：Good morning, Jane.","juese_video":"Greetings.mp3","hw_answerId":"e8e13254-2551-41d1-849b-922415b53911","juese_name":"全部音频","everyScore":6.25,"juese_id":"e8e13254-2551-41d1-849b-922415b53911"},{"juese_yw":"enen","juese_video":"dsds","hw_answerId":"434343434","juese_name":"enen","everyScore":6.25,"juese_id":"434343434"}],"Relative_path":"1_2_7_1_2/duihua/b7a6fbcd-de5d-4ec7-9f96-635c731951eb/"}
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
         * HomeworkPath : homework/4567/41/
         * typeList : [{"juese_yw":"Sally：Good morning, Jane.","juese_video":"Greetings.mp3","hw_answerId":"e8e13254-2551-41d1-849b-922415b53911","juese_name":"全部音频","everyScore":6.25,"juese_id":"e8e13254-2551-41d1-849b-922415b53911"},{"juese_yw":"enen","juese_video":"dsds","hw_answerId":"434343434","juese_name":"enen","everyScore":6.25,"juese_id":"434343434"}]
         * Relative_path : 1_2_7_1_2/duihua/b7a6fbcd-de5d-4ec7-9f96-635c731951eb/
         */

        private String HomeworkPath;
        private String Relative_path;
        private List<TypeListBean> typeList;

        public String getHomeworkPath() {
            return HomeworkPath;
        }

        public void setHomeworkPath(String HomeworkPath) {
            this.HomeworkPath = HomeworkPath;
        }

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
             * juese_yw : Sally：Good morning, Jane.
             * juese_video : Greetings.mp3
             * hw_answerId : e8e13254-2551-41d1-849b-922415b53911
             * juese_name : 全部音频
             * everyScore : 6.25
             * juese_id : e8e13254-2551-41d1-849b-922415b53911
             */

            private String juese_yw;
            private String juese_video;
            private String hw_answerId;
            private String juese_name;
            private double everyScore;
            private String juese_id;

            private Boolean isJS;

            public Boolean getJS() {
                return isJS;
            }

            public void setJS(Boolean JS) {
                isJS = JS;
            }

            public String getJuese_yw() {
                return juese_yw;
            }

            public void setJuese_yw(String juese_yw) {
                this.juese_yw = juese_yw;
            }

            public String getJuese_video() {
                return juese_video;
            }

            public void setJuese_video(String juese_video) {
                this.juese_video = juese_video;
            }

            public String getHw_answerId() {
                return hw_answerId;
            }

            public void setHw_answerId(String hw_answerId) {
                this.hw_answerId = hw_answerId;
            }

            public String getJuese_name() {
                return juese_name;
            }

            public void setJuese_name(String juese_name) {
                this.juese_name = juese_name;
            }

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public String getJuese_id() {
                return juese_id;
            }

            public void setJuese_id(String juese_id) {
                this.juese_id = juese_id;
            }
        }
    }
}
