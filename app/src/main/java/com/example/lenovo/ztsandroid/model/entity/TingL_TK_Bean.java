package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class TingL_TK_Bean implements Serializable {


    /**
     * data : [{"listen_id":"20e14909-43fb-46b9-9ff3-044b524aab0d","listen_text":"图片听选（本题3分）","listen_questionList":[{"listen_resolve":"","hw_answerId":"8c7d7425-d441-4f9e-b040-6faf11c5123a","listen_answer":"B","listen_optionList":[{"listen_optionId":3108,"listen_optionPhotoes":"1.A.jpg","listen_option":"A"},{"listen_optionId":3109,"listen_optionPhotoes":"1B.jpg","listen_option":"B"},{"listen_optionId":3110,"listen_optionPhotoes":"1C.jpg","listen_option":"C"}],"listen_questVideo":"It is a small meal. It\u2019s 17 yuan.mp3","listen_question":"1.It is a small meal. It\u2019s 17 yuan.","listen_questId":"8c7d7425-d441-4f9e-b040-6faf11c5123a"},{"listen_resolve":"","hw_answerId":"3bd56ec6-5f0a-4c6c-8aaa-2242bd429589","listen_answer":"C","listen_optionList":[{"listen_optionId":3111,"listen_optionPhotoes":"2A.jpg","listen_option":"A"},{"listen_optionId":3112,"listen_optionPhotoes":"2B.jpg","listen_option":"B"},{"listen_optionId":3113,"listen_optionPhotoes":"2C.jpg","listen_option":"C"}],"listen_questVideo":"His birthday is on May 20th..mp3","listen_question":"2.His birthday is on May 20th.","listen_questId":"3bd56ec6-5f0a-4c6c-8aaa-2242bd429589"},{"listen_resolve":"","hw_answerId":"6ff7c790-c326-4474-acad-56c0fd34506c","listen_answer":"A","listen_optionList":[{"listen_optionId":3114,"listen_optionPhotoes":"3A.jpg","listen_option":"A"},{"listen_optionId":3115,"listen_optionPhotoes":"3B.jpg","listen_option":"B"},{"listen_optionId":3116,"listen_optionPhotoes":"3C.jpg","listen_option":"C"}],"listen_questVideo":"My telephone number is 265924.mp3","listen_question":"3.My telephone number is 265924.","listen_questId":"6ff7c790-c326-4474-acad-56c0fd34506c"}],"listen_video":"","listen_type":"1"}]
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
         * listen_id : 20e14909-43fb-46b9-9ff3-044b524aab0d
         * listen_text : 图片听选（本题3分）
         * listen_questionList : [{"listen_resolve":"","hw_answerId":"8c7d7425-d441-4f9e-b040-6faf11c5123a","listen_answer":"B","listen_optionList":[{"listen_optionId":3108,"listen_optionPhotoes":"1.A.jpg","listen_option":"A"},{"listen_optionId":3109,"listen_optionPhotoes":"1B.jpg","listen_option":"B"},{"listen_optionId":3110,"listen_optionPhotoes":"1C.jpg","listen_option":"C"}],"listen_questVideo":"It is a small meal. It\u2019s 17 yuan.mp3","listen_question":"1.It is a small meal. It\u2019s 17 yuan.","listen_questId":"8c7d7425-d441-4f9e-b040-6faf11c5123a"},{"listen_resolve":"","hw_answerId":"3bd56ec6-5f0a-4c6c-8aaa-2242bd429589","listen_answer":"C","listen_optionList":[{"listen_optionId":3111,"listen_optionPhotoes":"2A.jpg","listen_option":"A"},{"listen_optionId":3112,"listen_optionPhotoes":"2B.jpg","listen_option":"B"},{"listen_optionId":3113,"listen_optionPhotoes":"2C.jpg","listen_option":"C"}],"listen_questVideo":"His birthday is on May 20th..mp3","listen_question":"2.His birthday is on May 20th.","listen_questId":"3bd56ec6-5f0a-4c6c-8aaa-2242bd429589"},{"listen_resolve":"","hw_answerId":"6ff7c790-c326-4474-acad-56c0fd34506c","listen_answer":"A","listen_optionList":[{"listen_optionId":3114,"listen_optionPhotoes":"3A.jpg","listen_option":"A"},{"listen_optionId":3115,"listen_optionPhotoes":"3B.jpg","listen_option":"B"},{"listen_optionId":3116,"listen_optionPhotoes":"3C.jpg","listen_option":"C"}],"listen_questVideo":"My telephone number is 265924.mp3","listen_question":"3.My telephone number is 265924.","listen_questId":"6ff7c790-c326-4474-acad-56c0fd34506c"}]
         * listen_video :
         * listen_type : 1
         */

        private String listen_id;
        private String listen_text;
        private String listen_video;
        private String listen_type;
        private List<ListenQuestionListBean> listen_questionList;

        public String getListen_id() {
            return listen_id;
        }

        public void setListen_id(String listen_id) {
            this.listen_id = listen_id;
        }

        public String getListen_text() {
            return listen_text;
        }

        public void setListen_text(String listen_text) {
            this.listen_text = listen_text;
        }

        public String getListen_video() {
            return listen_video;
        }

        public void setListen_video(String listen_video) {
            this.listen_video = listen_video;
        }

        public String getListen_type() {
            return listen_type;
        }

        public void setListen_type(String listen_type) {
            this.listen_type = listen_type;
        }

        public List<ListenQuestionListBean> getListen_questionList() {
            return listen_questionList;
        }

        public void setListen_questionList(List<ListenQuestionListBean> listen_questionList) {
            this.listen_questionList = listen_questionList;
        }

        public static class ListenQuestionListBean implements Serializable{
            /**
             * listen_resolve :
             * hw_answerId : 8c7d7425-d441-4f9e-b040-6faf11c5123a
             * listen_answer : B
             * listen_optionList : [{"listen_optionId":3108,"listen_optionPhotoes":"1.A.jpg","listen_option":"A"},{"listen_optionId":3109,"listen_optionPhotoes":"1B.jpg","listen_option":"B"},{"listen_optionId":3110,"listen_optionPhotoes":"1C.jpg","listen_option":"C"}]
             * listen_questVideo : It is a small meal. It’s 17 yuan.mp3
             * listen_question : 1.It is a small meal. It’s 17 yuan.
             * listen_questId : 8c7d7425-d441-4f9e-b040-6faf11c5123a
             */

            private String listen_resolve;
            private String hw_answerId;
            private String listen_answer;
            private String listen_questVideo;
            private String listen_question;
            private String listen_questId;
            private String avgScore;

            public String getAvgScore() {
                return avgScore;
            }

            public void setAvgScore(String avgScore) {
                this.avgScore = avgScore;
            }

            private List<ListenOptionListBean> listen_optionList;

            public String getListen_resolve() {
                return listen_resolve;
            }

            public void setListen_resolve(String listen_resolve) {
                this.listen_resolve = listen_resolve;
            }

            public String getHw_answerId() {
                return hw_answerId;
            }

            public void setHw_answerId(String hw_answerId) {
                this.hw_answerId = hw_answerId;
            }

            public String getListen_answer() {
                return listen_answer;
            }

            public void setListen_answer(String listen_answer) {
                this.listen_answer = listen_answer;
            }

            public String getListen_questVideo() {
                return listen_questVideo;
            }

            public void setListen_questVideo(String listen_questVideo) {
                this.listen_questVideo = listen_questVideo;
            }

            public String getListen_question() {
                return listen_question;
            }

            public void setListen_question(String listen_question) {
                this.listen_question = listen_question;
            }

            public String getListen_questId() {
                return listen_questId;
            }

            public void setListen_questId(String listen_questId) {
                this.listen_questId = listen_questId;
            }

            public List<ListenOptionListBean> getListen_optionList() {
                return listen_optionList;
            }

            public void setListen_optionList(List<ListenOptionListBean> listen_optionList) {
                this.listen_optionList = listen_optionList;
            }

            public static class ListenOptionListBean implements Serializable{
                /**
                 * listen_optionId : 3108
                 * listen_optionPhotoes : 1.A.jpg
                 * listen_option : A
                 */

                private int listen_optionId;
                private String listen_optionPhotoes;
                private String listen_option;
                private String listen_optionContent;

                public String getListen_optionContent() {
                    return listen_optionContent;
                }

                public void setListen_optionContent(String listen_optionContent) {
                    this.listen_optionContent = listen_optionContent;
                }

                public int getListen_optionId() {
                    return listen_optionId;
                }

                public void setListen_optionId(int listen_optionId) {
                    this.listen_optionId = listen_optionId;
                }

                public String getListen_optionPhotoes() {
                    return listen_optionPhotoes;
                }

                public void setListen_optionPhotoes(String listen_optionPhotoes) {
                    this.listen_optionPhotoes = listen_optionPhotoes;
                }

                public String getListen_option() {
                    return listen_option;
                }

                public void setListen_option(String listen_option) {
                    this.listen_option = listen_option;
                }
            }
        }
    }
}
