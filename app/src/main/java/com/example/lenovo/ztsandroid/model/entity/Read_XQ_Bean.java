package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Read_XQ_Bean implements Serializable{


    /**
     * data : [{"read_text":"we1234","read_content":"we7654321","read_questionList":[{"read_question":"what?","read_optionList":[{"read_option":"A","read_xid":"1e529a71-d364-470b-98c6-f88b3ebf3e13","read_optionText":"1","read_photoes":"11"},{"read_option":"B","read_xid":"b928545a-d289-46c8-bfe2-852133be2269","read_optionText":"2","read_photoes":"2"},{"read_option":"B","read_xid":"8220131a-6334-4665-83a0-79d23c4792c3","read_optionText":"3","read_photoes":"3"}],"read_answer":"A","read_qid":"ebd7003c-769a-4d2a-9469-ae443f7f4947","read_resolve":"we"},{"read_question":"why?","read_optionList":[{"read_option":"A","read_xid":"0c952ea3-77ef-47fb-9e9b-0b70232c62e7","read_optionText":"1","read_photoes":"1"},{"read_option":"B","read_xid":"ced5fa8a-9d8f-411f-ad45-ccf213751156","read_optionText":"2","read_photoes":"2"},{"read_option":"C","read_xid":"85431ccd-ae47-4e18-92b3-829cc1bdedf6","read_optionText":"3","read_photoes":"3"}],"read_answer":"B","read_qid":"1c8c6ec0-065c-4e03-b90d-d5adac6f5f5b","read_resolve":"we1234"}]}]
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
         * read_text : we1234
         * read_content : we7654321
         * read_questionList : [{"read_question":"what?","read_optionList":[{"read_option":"A","read_xid":"1e529a71-d364-470b-98c6-f88b3ebf3e13","read_optionText":"1","read_photoes":"11"},{"read_option":"B","read_xid":"b928545a-d289-46c8-bfe2-852133be2269","read_optionText":"2","read_photoes":"2"},{"read_option":"B","read_xid":"8220131a-6334-4665-83a0-79d23c4792c3","read_optionText":"3","read_photoes":"3"}],"read_answer":"A","read_qid":"ebd7003c-769a-4d2a-9469-ae443f7f4947","read_resolve":"we"},{"read_question":"why?","read_optionList":[{"read_option":"A","read_xid":"0c952ea3-77ef-47fb-9e9b-0b70232c62e7","read_optionText":"1","read_photoes":"1"},{"read_option":"B","read_xid":"ced5fa8a-9d8f-411f-ad45-ccf213751156","read_optionText":"2","read_photoes":"2"},{"read_option":"C","read_xid":"85431ccd-ae47-4e18-92b3-829cc1bdedf6","read_optionText":"3","read_photoes":"3"}],"read_answer":"B","read_qid":"1c8c6ec0-065c-4e03-b90d-d5adac6f5f5b","read_resolve":"we1234"}]
         */

        private String read_text;
        private String read_content;
        private List<ReadQuestionListBean> read_questionList;

        public String getRead_text() {
            return read_text;
        }

        public void setRead_text(String read_text) {
            this.read_text = read_text;
        }

        public String getRead_content() {
            return read_content;
        }

        public void setRead_content(String read_content) {
            this.read_content = read_content;
        }

        public List<ReadQuestionListBean> getRead_questionList() {
            return read_questionList;
        }

        public void setRead_questionList(List<ReadQuestionListBean> read_questionList) {
            this.read_questionList = read_questionList;
        }

        public static class ReadQuestionListBean implements Serializable{
            /**
             * read_question : what?
             * read_optionList : [{"read_option":"A","read_xid":"1e529a71-d364-470b-98c6-f88b3ebf3e13","read_optionText":"1","read_photoes":"11"},{"read_option":"B","read_xid":"b928545a-d289-46c8-bfe2-852133be2269","read_optionText":"2","read_photoes":"2"},{"read_option":"B","read_xid":"8220131a-6334-4665-83a0-79d23c4792c3","read_optionText":"3","read_photoes":"3"}]
             * read_answer : A
             * read_qid : ebd7003c-769a-4d2a-9469-ae443f7f4947
             * read_resolve : we
             */

            private String read_question;
            private String read_answer;
            private String read_qid;
            private String read_resolve;
            private List<ReadOptionListBean> read_optionList;

            public String getRead_question() {
                return read_question;
            }

            public void setRead_question(String read_question) {
                this.read_question = read_question;
            }

            public String getRead_answer() {
                return read_answer;
            }

            public void setRead_answer(String read_answer) {
                this.read_answer = read_answer;
            }

            public String getRead_qid() {
                return read_qid;
            }

            public void setRead_qid(String read_qid) {
                this.read_qid = read_qid;
            }

            public String getRead_resolve() {
                return read_resolve;
            }

            public void setRead_resolve(String read_resolve) {
                this.read_resolve = read_resolve;
            }

            public List<ReadOptionListBean> getRead_optionList() {
                return read_optionList;
            }

            public void setRead_optionList(List<ReadOptionListBean> read_optionList) {
                this.read_optionList = read_optionList;
            }

            public static class ReadOptionListBean implements Serializable{
                /**
                 * read_option : A
                 * read_xid : 1e529a71-d364-470b-98c6-f88b3ebf3e13
                 * read_optionText : 1
                 * read_photoes : 11
                 */

                private String read_option;
                private String read_xid;
                private String read_optionText;
                private String read_photoes;

                public String getRead_option() {
                    return read_option;
                }

                public void setRead_option(String read_option) {
                    this.read_option = read_option;
                }

                public String getRead_xid() {
                    return read_xid;
                }

                public void setRead_xid(String read_xid) {
                    this.read_xid = read_xid;
                }

                public String getRead_optionText() {
                    return read_optionText;
                }

                public void setRead_optionText(String read_optionText) {
                    this.read_optionText = read_optionText;
                }

                public String getRead_photoes() {
                    return read_photoes;
                }

                public void setRead_photoes(String read_photoes) {
                    this.read_photoes = read_photoes;
                }
            }
        }
    }
}
