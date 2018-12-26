package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/12/26.
 */

public class ZuoY_TT_Bean {


    /**
     * data : {"typeList":[{"listen_require":"句子填空","listen_content":"She isn\u2019t ________.¬¬ of crossing the river.","listen_id":"05663253-5882-4591-86aa-94fab7af0272","listen_text":"句子填空","listen_questionList":[{"listen_resolve":"","hw_answerId":"d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05","HomeworkPath":"homework/10be4e7a-001d-490c-9e4a-b2288b96c059/12/5/05663253-5882-4591-86aa-94fab7af0272/d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05/","listen_answer":"afraid","listen_optionList":[],"listen_questId":"d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05"}],"everyScore":11.11,"listen_video":"She isn\u2019t 1. \u2014of crossing the river.mp3","listen_type":"2"}],"Relative_path":"1_2_7_1_2001/tingli/05663253-5882-4591-86aa-94fab7af0272/"}
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
         * typeList : [{"listen_require":"句子填空","listen_content":"She isn\u2019t ________.¬¬ of crossing the river.","listen_id":"05663253-5882-4591-86aa-94fab7af0272","listen_text":"句子填空","listen_questionList":[{"listen_resolve":"","hw_answerId":"d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05","HomeworkPath":"homework/10be4e7a-001d-490c-9e4a-b2288b96c059/12/5/05663253-5882-4591-86aa-94fab7af0272/d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05/","listen_answer":"afraid","listen_optionList":[],"listen_questId":"d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05"}],"everyScore":11.11,"listen_video":"She isn\u2019t 1. \u2014of crossing the river.mp3","listen_type":"2"}]
         * Relative_path : 1_2_7_1_2001/tingli/05663253-5882-4591-86aa-94fab7af0272/
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
             * listen_require : 句子填空
             * listen_content : She isn’t ________.¬¬ of crossing the river.
             * listen_id : 05663253-5882-4591-86aa-94fab7af0272
             * listen_text : 句子填空
             * listen_questionList : [{"listen_resolve":"","hw_answerId":"d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05","HomeworkPath":"homework/10be4e7a-001d-490c-9e4a-b2288b96c059/12/5/05663253-5882-4591-86aa-94fab7af0272/d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05/","listen_answer":"afraid","listen_optionList":[],"listen_questId":"d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05"}]
             * everyScore : 11.11
             * listen_video : She isn’t 1. —of crossing the river.mp3
             * listen_type : 2
             */

            private String listen_require;
            private String listen_content;
            private String listen_id;
            private String listen_text;
            private double everyScore;
            private String listen_video;
            private String listen_type;
            private List<ListenQuestionListBean> listen_questionList;

            public String getListen_require() {
                return listen_require;
            }

            public void setListen_require(String listen_require) {
                this.listen_require = listen_require;
            }

            public String getListen_content() {
                return listen_content;
            }

            public void setListen_content(String listen_content) {
                this.listen_content = listen_content;
            }

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

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
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

            public static class ListenQuestionListBean {
                /**
                 * listen_resolve :
                 * hw_answerId : d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05
                 * HomeworkPath : homework/10be4e7a-001d-490c-9e4a-b2288b96c059/12/5/05663253-5882-4591-86aa-94fab7af0272/d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05/
                 * listen_answer : afraid
                 * listen_optionList : []
                 * listen_questId : d0d5a82b-2cf4-4f63-b4a5-40e55b5d2a05
                 */

                private String listen_resolve;
                private String hw_answerId;
                private String HomeworkPath;
                private String listen_answer;
                private String listen_questId;
                private List<?> listen_optionList;

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

                public String getHomeworkPath() {
                    return HomeworkPath;
                }

                public void setHomeworkPath(String HomeworkPath) {
                    this.HomeworkPath = HomeworkPath;
                }

                public String getListen_answer() {
                    return listen_answer;
                }

                public void setListen_answer(String listen_answer) {
                    this.listen_answer = listen_answer;
                }

                public String getListen_questId() {
                    return listen_questId;
                }

                public void setListen_questId(String listen_questId) {
                    this.listen_questId = listen_questId;
                }

                public List<?> getListen_optionList() {
                    return listen_optionList;
                }

                public void setListen_optionList(List<?> listen_optionList) {
                    this.listen_optionList = listen_optionList;
                }
            }
        }
    }
}
