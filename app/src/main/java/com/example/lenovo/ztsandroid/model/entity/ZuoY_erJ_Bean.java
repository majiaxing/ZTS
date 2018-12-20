package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ZuoY_erJ_Bean {


    /**
     * data : {"homeworkType":[{"hw_type":"8","jiaocaiid":"0","avgScore":50,"hw_content":"8918feb6-3afd-4199-8595-685b8c4ca62c","type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"hw_type":"6","jiaocaiid":"0","avgScore":50,"hw_content":"1651b61f-e2dc-4a7f-9c59-32cc164f4092","type":"3bf553d3-2769-4ba8-8785-2ced3abd340a"}],"tips":"本作业只能完成一次"}
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
         * homeworkType : [{"hw_type":"8","jiaocaiid":"0","avgScore":50,"hw_content":"8918feb6-3afd-4199-8595-685b8c4ca62c","type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"hw_type":"6","jiaocaiid":"0","avgScore":50,"hw_content":"1651b61f-e2dc-4a7f-9c59-32cc164f4092","type":"3bf553d3-2769-4ba8-8785-2ced3abd340a"}]
         * tips : 本作业只能完成一次
         */

        private String tips;
        private List<HomeworkTypeBean> homeworkType;

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public List<HomeworkTypeBean> getHomeworkType() {
            return homeworkType;
        }

        public void setHomeworkType(List<HomeworkTypeBean> homeworkType) {
            this.homeworkType = homeworkType;
        }

        public static class HomeworkTypeBean {
            /**
             * hw_type : 8
             * jiaocaiid : 0
             * avgScore : 50
             * hw_content : 8918feb6-3afd-4199-8595-685b8c4ca62c
             * type : 8918feb6-3afd-4199-8595-685b8c4ca62c
             */

            private String hw_type;
            private String jiaocaiid;
            private double avgScore;
            private String hw_content;
            private String type;
            private String listen_type;

            public String getListen_type() {
                return listen_type;
            }

            public void setListen_type(String listen_type) {
                this.listen_type = listen_type;
            }

            public String getHw_type() {
                return hw_type;
            }

            public void setHw_type(String hw_type) {
                this.hw_type = hw_type;
            }

            public String getJiaocaiid() {
                return jiaocaiid;
            }

            public void setJiaocaiid(String jiaocaiid) {
                this.jiaocaiid = jiaocaiid;
            }

            public double getAvgScore() {
                return avgScore;
            }

            public void setAvgScore(double avgScore) {
                this.avgScore = avgScore;
            }

            public String getHw_content() {
                return hw_content;
            }

            public void setHw_content(String hw_content) {
                this.hw_content = hw_content;
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
