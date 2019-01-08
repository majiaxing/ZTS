package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZY_Dc_Bean implements Serializable {


    /**
     * data : {"HomeworkPath":"homework/4567/41/","typeList":[{"practice":0,"hw_answerId":"0c7d36e7-b38f-46a7-b6d4-26240569b0fb","word_id":"0c7d36e7-b38f-46a7-b6d4-26240569b0fb","word_video":"am.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"am","word_tran":"好的"},{"practice":0,"hw_answerId":"1651c393-7ee7-4f59-a21a-e77cc0c80558","word_id":"1651c393-7ee7-4f59-a21a-e77cc0c80558","word_video":"hi.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"hi"},{"practice":0,"hw_answerId":"20084765-8e7d-4d69-b388-7ea3aedc590f","word_id":"20084765-8e7d-4d69-b388-7ea3aedc590f","word_video":"OK.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"OK","word_tran":"好的"},{"practice":0,"hw_answerId":"2a1d65e1-94c4-4d52-992c-131c2caf8dcf","word_id":"2a1d65e1-94c4-4d52-992c-131c2caf8dcf","word_video":"CD.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"CD","word_tran":"cd"},{"practice":0,"hw_answerId":"4c4daf2d-4ddc-4a38-909c-6637d7750bb8","word_id":"4c4daf2d-4ddc-4a38-909c-6637d7750bb8","word_video":"good.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"good","word_tran":"好的"},{"practice":0,"hw_answerId":"5bf053b3-9325-4f6d-922b-bc1170e086cd","word_id":"5bf053b3-9325-4f6d-922b-bc1170e086cd","word_video":"evening.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"evening","word_tran":"晚上"},{"practice":0,"hw_answerId":"78ebfd0c-44fb-4749-88a2-88a357c799a4","word_id":"78ebfd0c-44fb-4749-88a2-88a357c799a4","word_video":"I.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"I","word_tran":"我"},{"practice":0,"hw_answerId":"8b05e838-9d8e-4fcf-88b1-8d4af0030d24","word_id":"8b05e838-9d8e-4fcf-88b1-8d4af0030d24","word_video":"how.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"how","word_tran":"怎么样"},{"practice":0,"hw_answerId":"90043cf8-16be-4a6d-860d-653478c37bac","word_id":"90043cf8-16be-4a6d-860d-653478c37bac","word_video":"you.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"you","word_tran":"你"},{"practice":0,"hw_answerId":"a0becb72-3a6a-48f3-b405-865e66c0a598","word_id":"a0becb72-3a6a-48f3-b405-865e66c0a598","word_video":"HB.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"HB","word_tran":"hb"},{"practice":0,"hw_answerId":"b244a8e5-b685-4cd7-988d-0feb6baad257","word_id":"b244a8e5-b685-4cd7-988d-0feb6baad257","word_video":"thanks.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"thanks","word_tran":"谢谢"},{"practice":0,"hw_answerId":"b5606302-e0c0-4e6f-ab89-0c92aae49b0c","word_id":"b5606302-e0c0-4e6f-ab89-0c92aae49b0c","word_video":"are.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"are"},{"practice":0,"hw_answerId":"b7f4a0dd-4c67-4d22-9387-b95c01bc45a1","word_id":"b7f4a0dd-4c67-4d22-9387-b95c01bc45a1","word_video":"morning.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"morning","word_tran":"早上"},{"practice":0,"hw_answerId":"b9f11f9f-42ba-4cc6-8c5d-6cba72ee81f4","word_id":"b9f11f9f-42ba-4cc6-8c5d-6cba72ee81f4","word_video":"fine.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"fine","word_tran":"好的"},{"practice":0,"hw_answerId":"e8b214a4-728d-420d-8492-41ae686edcfd","word_id":"e8b214a4-728d-420d-8492-41ae686edcfd","word_video":"hello.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"hello","word_tran":"你好"},{"practice":0,"hw_answerId":"f86bc805-cc24-44b1-9c69-a56ffd4a1d0f","word_id":"f86bc805-cc24-44b1-9c69-a56ffd4a1d0f","word_video":"BBC.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"BBC","word_tran":"bbc"},{"practice":0,"hw_answerId":"ff3167c7-457f-42e0-9118-40c676f3a6ab","word_id":"ff3167c7-457f-42e0-9118-40c676f3a6ab","word_video":"afternoon.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"afternoon","word_tran":"下午好"}],"Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/"}
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
         * typeList : [{"practice":0,"hw_answerId":"0c7d36e7-b38f-46a7-b6d4-26240569b0fb","word_id":"0c7d36e7-b38f-46a7-b6d4-26240569b0fb","word_video":"am.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"am"},{"practice":0,"hw_answerId":"1651c393-7ee7-4f59-a21a-e77cc0c80558","word_id":"1651c393-7ee7-4f59-a21a-e77cc0c80558","word_video":"hi.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"hi"},{"practice":0,"hw_answerId":"20084765-8e7d-4d69-b388-7ea3aedc590f","word_id":"20084765-8e7d-4d69-b388-7ea3aedc590f","word_video":"OK.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"OK","word_tran":"好的"},{"practice":0,"hw_answerId":"2a1d65e1-94c4-4d52-992c-131c2caf8dcf","word_id":"2a1d65e1-94c4-4d52-992c-131c2caf8dcf","word_video":"CD.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"CD","word_tran":"cd"},{"practice":0,"hw_answerId":"4c4daf2d-4ddc-4a38-909c-6637d7750bb8","word_id":"4c4daf2d-4ddc-4a38-909c-6637d7750bb8","word_video":"good.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"good","word_tran":"好的"},{"practice":0,"hw_answerId":"5bf053b3-9325-4f6d-922b-bc1170e086cd","word_id":"5bf053b3-9325-4f6d-922b-bc1170e086cd","word_video":"evening.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"evening","word_tran":"晚上"},{"practice":0,"hw_answerId":"78ebfd0c-44fb-4749-88a2-88a357c799a4","word_id":"78ebfd0c-44fb-4749-88a2-88a357c799a4","word_video":"I.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"I","word_tran":"我"},{"practice":0,"hw_answerId":"8b05e838-9d8e-4fcf-88b1-8d4af0030d24","word_id":"8b05e838-9d8e-4fcf-88b1-8d4af0030d24","word_video":"how.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"how","word_tran":"怎么样"},{"practice":0,"hw_answerId":"90043cf8-16be-4a6d-860d-653478c37bac","word_id":"90043cf8-16be-4a6d-860d-653478c37bac","word_video":"you.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"you","word_tran":"你"},{"practice":0,"hw_answerId":"a0becb72-3a6a-48f3-b405-865e66c0a598","word_id":"a0becb72-3a6a-48f3-b405-865e66c0a598","word_video":"HB.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"HB","word_tran":"hb"},{"practice":0,"hw_answerId":"b244a8e5-b685-4cd7-988d-0feb6baad257","word_id":"b244a8e5-b685-4cd7-988d-0feb6baad257","word_video":"thanks.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"thanks","word_tran":"谢谢"},{"practice":0,"hw_answerId":"b5606302-e0c0-4e6f-ab89-0c92aae49b0c","word_id":"b5606302-e0c0-4e6f-ab89-0c92aae49b0c","word_video":"are.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"are"},{"practice":0,"hw_answerId":"b7f4a0dd-4c67-4d22-9387-b95c01bc45a1","word_id":"b7f4a0dd-4c67-4d22-9387-b95c01bc45a1","word_video":"morning.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"morning","word_tran":"早上"},{"practice":0,"hw_answerId":"b9f11f9f-42ba-4cc6-8c5d-6cba72ee81f4","word_id":"b9f11f9f-42ba-4cc6-8c5d-6cba72ee81f4","word_video":"fine.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"fine","word_tran":"好的"},{"practice":0,"hw_answerId":"e8b214a4-728d-420d-8492-41ae686edcfd","word_id":"e8b214a4-728d-420d-8492-41ae686edcfd","word_video":"hello.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"hello","word_tran":"你好"},{"practice":0,"hw_answerId":"f86bc805-cc24-44b1-9c69-a56ffd4a1d0f","word_id":"f86bc805-cc24-44b1-9c69-a56ffd4a1d0f","word_video":"BBC.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"BBC","word_tran":"bbc"},{"practice":0,"hw_answerId":"ff3167c7-457f-42e0-9118-40c676f3a6ab","word_id":"ff3167c7-457f-42e0-9118-40c676f3a6ab","word_video":"afternoon.mp3","save":"1_2_7_1_01","Relative_path":"1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/","everyScore":0.74,"type":"8918feb6-3afd-4199-8595-685b8c4ca62c","word":"afternoon","word_tran":"下午好"}]
         * Relative_path : 1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/
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
             * hw_answerId : 0c7d36e7-b38f-46a7-b6d4-26240569b0fb
             * word_id : 0c7d36e7-b38f-46a7-b6d4-26240569b0fb
             * word_video : am.mp3
             * save : 1_2_7_1_01
             * Relative_path : 1_2_7_1_01/danci/8918feb6-3afd-4199-8595-685b8c4ca62c/
             * everyScore : 0.74
             * type : 8918feb6-3afd-4199-8595-685b8c4ca62c
             * word : am
             * word_tran : 好的
             */

            private int practice;
            private String hw_answerId;
            private String word_id;
            private String word_video;
            private String save;
            private String Relative_path;
            private double everyScore;
            private String type;
            private String word;
            private String word_tran;

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

            public String getWord_id() {
                return word_id;
            }

            public void setWord_id(String word_id) {
                this.word_id = word_id;
            }

            public String getWord_video() {
                return word_video;
            }

            public void setWord_video(String word_video) {
                this.word_video = word_video;
            }

            public String getSave() {
                return save;
            }

            public void setSave(String save) {
                this.save = save;
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

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public String getWord_tran() {
                return word_tran;
            }

            public void setWord_tran(String word_tran) {
                this.word_tran = word_tran;
            }
        }
    }
}
