package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_dy_Bean {


    /**
     * data : {"HomeworkPath":"homework/4567/41/","typeList":[{"practice":0,"hw_answerId":"473fdbd3-d288-4dbe-8a44-574afbf24f58","phrase":"Good afternoon!","phrase_tran":"下午好","save":"1_2_7_1_01","phrase_video":"Good afternoon.mp3","phrase_id":"473fdbd3-d288-4dbe-8a44-574afbf24f58","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"4816c1c5-a7b1-4a3b-86d0-b0d567caf203","phrase":"Good morning!","phrase_tran":"早上好","save":"1_2_7_1_01","phrase_video":"Good morning.mp3","phrase_id":"4816c1c5-a7b1-4a3b-86d0-b0d567caf203","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"71955532-0260-4710-bc71-f70d453be1a4","phrase":"How are you?","phrase_tran":"你好吗","save":"1_2_7_1_01","phrase_video":"How are you.mp3","phrase_id":"71955532-0260-4710-bc71-f70d453be1a4","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"e92ff8d5-c264-4ca1-9e0b-093ad65f5738","phrase":"Good evening!","save":"1_2_7_1_01","phrase_video":"Good evening.mp3","phrase_id":"e92ff8d5-c264-4ca1-9e0b-093ad65f5738","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"}],"Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/"}
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
         * HomeworkPath : homework/4567/41/
         * typeList : [{"practice":0,"hw_answerId":"473fdbd3-d288-4dbe-8a44-574afbf24f58","phrase":"Good afternoon!","phrase_tran":"下午好","save":"1_2_7_1_01","phrase_video":"Good afternoon.mp3","phrase_id":"473fdbd3-d288-4dbe-8a44-574afbf24f58","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"4816c1c5-a7b1-4a3b-86d0-b0d567caf203","phrase":"Good morning!","phrase_tran":"早上好","save":"1_2_7_1_01","phrase_video":"Good morning.mp3","phrase_id":"4816c1c5-a7b1-4a3b-86d0-b0d567caf203","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"71955532-0260-4710-bc71-f70d453be1a4","phrase":"How are you?","phrase_tran":"你好吗","save":"1_2_7_1_01","phrase_video":"How are you.mp3","phrase_id":"71955532-0260-4710-bc71-f70d453be1a4","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"e92ff8d5-c264-4ca1-9e0b-093ad65f5738","phrase":"Good evening!","save":"1_2_7_1_01","phrase_video":"Good evening.mp3","phrase_id":"e92ff8d5-c264-4ca1-9e0b-093ad65f5738","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":3.13,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c"}]
         * Relative_path : 1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/
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

        public static class TypeListBean {
            /**
             * practice : 0
             * hw_answerId : 473fdbd3-d288-4dbe-8a44-574afbf24f58
             * phrase : Good afternoon!
             * phrase_tran : 下午好
             * save : 1_2_7_1_01
             * phrase_video : Good afternoon.mp3
             * phrase_id : 473fdbd3-d288-4dbe-8a44-574afbf24f58
             * Relative_path : 1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/
             * everyScore : 3.13
             * type : 8918feb6-3afd-4199-8595-685b8c4ca62c
             */

            private int practice;
            private String hw_answerId;
            private String phrase;
            private String phrase_tran;
            private String save;
            private String phrase_video;
            private String phrase_id;
            private String Relative_path;
            private double everyScore;
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

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
