package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_kw_Bean implements Serializable{


    /**
     * data : {"HomeworkPath":"homework/4567/41/","typeList":[{"text_id":"02c8a26f-0f99-46e9-a1e4-80a8a78d53e5","text_zw":"学校注意：亲爱的同学们，我们很高兴和你们分享一些关于学习的注意事项，网同学们注意","hw_answerId":"02c8a26f-0f99-46e9-a1e4-80a8a78d53e5","text_video":"School notice.mp3","everyScore":12.5,"text_yw":"Dear students,\nWe have some interesting and fun things for you this term. On September twenty-first, we have a school trip in the afternoon.\nOctober is a great month. On the twelfth and the fifteenth, we have two ball games, soccer and volleyball. School Day is on October twenty-second. Your parents can come to our school. Next month, we have an art festival. It\u2019s on November third. We have an English party on November thirtieth. On December the third, we have a book sale in the school library.\nThis is a really busy term! Have a good time!\n"}],"Relative_path":"1_2_7_1_8/kewen/02c8a26f-0f99-46e9-a1e4-80a8a78d53e5/"}
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
         * typeList : [{"text_id":"02c8a26f-0f99-46e9-a1e4-80a8a78d53e5","text_zw":"学校注意：亲爱的同学们，我们很高兴和你们分享一些关于学习的注意事项，网同学们注意","hw_answerId":"02c8a26f-0f99-46e9-a1e4-80a8a78d53e5","text_video":"School notice.mp3","everyScore":12.5,"text_yw":"Dear students,\nWe have some interesting and fun things for you this term. On September twenty-first, we have a school trip in the afternoon.\nOctober is a great month. On the twelfth and the fifteenth, we have two ball games, soccer and volleyball. School Day is on October twenty-second. Your parents can come to our school. Next month, we have an art festival. It\u2019s on November third. We have an English party on November thirtieth. On December the third, we have a book sale in the school library.\nThis is a really busy term! Have a good time!\n"}]
         * Relative_path : 1_2_7_1_8/kewen/02c8a26f-0f99-46e9-a1e4-80a8a78d53e5/
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
             * text_id : 02c8a26f-0f99-46e9-a1e4-80a8a78d53e5
             * text_zw : 学校注意：亲爱的同学们，我们很高兴和你们分享一些关于学习的注意事项，网同学们注意
             * hw_answerId : 02c8a26f-0f99-46e9-a1e4-80a8a78d53e5
             * text_video : School notice.mp3
             * everyScore : 12.5
             * text_yw : Dear students,
             We have some interesting and fun things for you this term. On September twenty-first, we have a school trip in the afternoon.
             October is a great month. On the twelfth and the fifteenth, we have two ball games, soccer and volleyball. School Day is on October twenty-second. Your parents can come to our school. Next month, we have an art festival. It’s on November third. We have an English party on November thirtieth. On December the third, we have a book sale in the school library.
             This is a really busy term! Have a good time!

             */

            private String text_id;
            private String text_zw;
            private String hw_answerId;
            private String text_video;
            private double everyScore;
            private String text_yw;

            public String getText_id() {
                return text_id;
            }

            public void setText_id(String text_id) {
                this.text_id = text_id;
            }

            public String getText_zw() {
                return text_zw;
            }

            public void setText_zw(String text_zw) {
                this.text_zw = text_zw;
            }

            public String getHw_answerId() {
                return hw_answerId;
            }

            public void setHw_answerId(String hw_answerId) {
                this.hw_answerId = hw_answerId;
            }

            public String getText_video() {
                return text_video;
            }

            public void setText_video(String text_video) {
                this.text_video = text_video;
            }

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public String getText_yw() {
                return text_yw;
            }

            public void setText_yw(String text_yw) {
                this.text_yw = text_yw;
            }
        }
    }
}
