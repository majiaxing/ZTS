package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_Jz_Bean implements Serializable {


    /**
     * data : {"HomeworkPath":"homework/4567/41/","typeList":[{"practice":0,"hw_answerId":"f60f3a6a-3193-4f34-9bc3-c77d18835545","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"I know your doctor.","sentence_sid":"f60f3a6a-3193-4f34-9bc3-c77d18835545","sentence_zw":"我了解你的医生","everyScore":3.13,"sentence_video":"I know your doctor..mp3"},{"practice":0,"hw_answerId":"a93fe354-03d6-48d9-80ef-643c5af12da7","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"She is naughty.","sentence_sid":"a93fe354-03d6-48d9-80ef-643c5af12da7","sentence_zw":"他很腼腆","everyScore":3.13,"sentence_video":"She is naughty.mp3"},{"practice":0,"hw_answerId":"09a4dc03-dbaf-474d-8ea3-d0e778ea52fb","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"We talk about festivals.","sentence_sid":"09a4dc03-dbaf-474d-8ea3-d0e778ea52fb","sentence_zw":"我们在讨论节日","everyScore":3.13,"sentence_video":"We talk about festivals..mp3"},{"practice":0,"hw_answerId":"4b12a6f1-1b2e-46b0-b925-75f3f04ab16d","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"I bought the knives from that shop.","sentence_sid":"4b12a6f1-1b2e-46b0-b925-75f3f04ab16d","sentence_zw":"我从商店买了小吃","everyScore":3.13,"sentence_video":"I bought the knives from that shop..mp3"}],"Relative_path":"1_2_7_1_4/jvzi/454e309f-8dc4-40f6-a204-ea6bb9dca93a/"}
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
         * typeList : [{"practice":0,"hw_answerId":"f60f3a6a-3193-4f34-9bc3-c77d18835545","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"I know your doctor.","sentence_sid":"f60f3a6a-3193-4f34-9bc3-c77d18835545","sentence_zw":"我了解你的医生","everyScore":3.13,"sentence_video":"I know your doctor..mp3"},{"practice":0,"hw_answerId":"a93fe354-03d6-48d9-80ef-643c5af12da7","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"She is naughty.","sentence_sid":"a93fe354-03d6-48d9-80ef-643c5af12da7","sentence_zw":"他很腼腆","everyScore":3.13,"sentence_video":"She is naughty.mp3"},{"practice":0,"hw_answerId":"09a4dc03-dbaf-474d-8ea3-d0e778ea52fb","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"We talk about festivals.","sentence_sid":"09a4dc03-dbaf-474d-8ea3-d0e778ea52fb","sentence_zw":"我们在讨论节日","everyScore":3.13,"sentence_video":"We talk about festivals..mp3"},{"practice":0,"hw_answerId":"4b12a6f1-1b2e-46b0-b925-75f3f04ab16d","sentence_id":"454e309f-8dc4-40f6-a204-ea6bb9dca93a","sentence_yw":"I bought the knives from that shop.","sentence_sid":"4b12a6f1-1b2e-46b0-b925-75f3f04ab16d","sentence_zw":"我从商店买了小吃","everyScore":3.13,"sentence_video":"I bought the knives from that shop..mp3"}]
         * Relative_path : 1_2_7_1_4/jvzi/454e309f-8dc4-40f6-a204-ea6bb9dca93a/
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
             * practice : 0
             * hw_answerId : f60f3a6a-3193-4f34-9bc3-c77d18835545
             * sentence_id : 454e309f-8dc4-40f6-a204-ea6bb9dca93a
             * sentence_yw : I know your doctor.
             * sentence_sid : f60f3a6a-3193-4f34-9bc3-c77d18835545
             * sentence_zw : 我了解你的医生
             * everyScore : 3.13
             * sentence_video : I know your doctor..mp3
             */

            private int practice;
            private String hw_answerId;
            private String sentence_id;
            private String sentence_yw;
            private String sentence_sid;
            private String sentence_zw;
            private double everyScore;
            private String sentence_video;

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

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public String getSentence_video() {
                return sentence_video;
            }

            public void setSentence_video(String sentence_video) {
                this.sentence_video = sentence_video;
            }
        }
    }
}
