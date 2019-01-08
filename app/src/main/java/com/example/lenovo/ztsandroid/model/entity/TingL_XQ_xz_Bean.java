package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */

public class TingL_XQ_xz_Bean implements Serializable{


    /**
     * data : [{"listen_require":"句子填空","listen_content":"Gina is in PEP ___________","listen_text":"句子填空","listen_questionList":[{"listen_resolve":"","listen_answer":"Middle School","listen_optionList":[],"listen_questId":"604850a6-ed1e-4df0-9741-ef1560b1338e"}],"listen_video":"Gina is in PEP 1.\u2014.mp3","listen_tldist":"Gina is in PEP ___________"}]
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
         * listen_require : 句子填空
         * listen_content : Gina is in PEP ___________
         * listen_text : 句子填空
         * listen_questionList : [{"listen_resolve":"","listen_answer":"Middle School","listen_optionList":[],"listen_questId":"604850a6-ed1e-4df0-9741-ef1560b1338e"}]
         * listen_video : Gina is in PEP 1.—.mp3
         * listen_tldist : Gina is in PEP ___________
         */

        private String listen_require;
        private String listen_content;
        private String listen_text;
        private String listen_video;
        private String listen_tldist;
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

        public String getListen_tldist() {
            return listen_tldist;
        }

        public void setListen_tldist(String listen_tldist) {
            this.listen_tldist = listen_tldist;
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
             * listen_answer : Middle School
             * listen_optionList : []
             * listen_questId : 604850a6-ed1e-4df0-9741-ef1560b1338e
             */

            private String listen_resolve;
            private String listen_answer;
            private String listen_questId;
            private List<?> listen_optionList;

            public String getListen_resolve() {
                return listen_resolve;
            }

            public void setListen_resolve(String listen_resolve) {
                this.listen_resolve = listen_resolve;
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
