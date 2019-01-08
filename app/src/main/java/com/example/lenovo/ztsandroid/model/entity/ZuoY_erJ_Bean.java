package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ZuoY_erJ_Bean implements Serializable {


    /**
     * data : {"homeworkType":[{"hw_type":"6","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"800b3ed1-4fec-4a50-baa8-5cc2f9bf6492","listenType":"","typeName":"Starter阅读理解","type":"6ec73767-a83a-4bb0-a192-94726523f836","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"5","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"20e14909-43fb-46b9-9ff3-044b524aab0d","listenType":"1","typeName":"图片听选（本题3分）","type":"a75692ee-94fc-443a-bac9-0ad543ece315","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"5","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"374339f3-386c-40df-bb91-b7616d10a4a7","listenType":"1","typeName":"听对话，选择正确答案。","type":"a75692ee-94fc-443a-bac9-0ad543ece315","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"5","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"2331d5a9-976c-43e6-bb2d-eba5d63beaab","listenType":"2","typeName":"句子填空","type":"6f7ad514-9ccd-4ff9-a733-a6c4359493cf","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"0","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"1","listenType":"","typeName":"ɪ","type":"1","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"2","jiaocaiid":"1_7_1","score":126.6,"avgScore":11.11,"hw_content":"dd2c9332-23d0-4b28-aaf2-6acf058152b1","listenType":"","typeName":"预习单元3","type":"dd2c9332-23d0-4b28-aaf2-6acf058152b1","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"8","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"a75692ee-94fc-443a-bac9-0ad543ece315","listenType":"","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"3","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"ac4422ff-15f2-49d9-8ee0-e65fb5334e3b","listenType":"","typeName":"听说训练4","type":"6f7ad514-9ccd-4ff9-a733-a6c4359493cf","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"1","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"b2e435a6-1290-4c3b-aacb-e9e20858a529","listenType":"","typeName":"Section A 3b","type":"5e1b0ace-ec3a-4056-b5ea-547fc3b0d85f","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"}],"tips":"作业未开始或已结束，不可做作业"}
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
         * homeworkType : [{"hw_type":"6","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"800b3ed1-4fec-4a50-baa8-5cc2f9bf6492","listenType":"","typeName":"Starter阅读理解","type":"6ec73767-a83a-4bb0-a192-94726523f836","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"5","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"20e14909-43fb-46b9-9ff3-044b524aab0d","listenType":"1","typeName":"图片听选（本题3分）","type":"a75692ee-94fc-443a-bac9-0ad543ece315","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"5","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"374339f3-386c-40df-bb91-b7616d10a4a7","listenType":"1","typeName":"听对话，选择正确答案。","type":"a75692ee-94fc-443a-bac9-0ad543ece315","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"5","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"2331d5a9-976c-43e6-bb2d-eba5d63beaab","listenType":"2","typeName":"句子填空","type":"6f7ad514-9ccd-4ff9-a733-a6c4359493cf","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"0","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"1","listenType":"","typeName":"ɪ","type":"1","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"2","jiaocaiid":"1_7_1","score":126.6,"avgScore":11.11,"hw_content":"dd2c9332-23d0-4b28-aaf2-6acf058152b1","listenType":"","typeName":"预习单元3","type":"dd2c9332-23d0-4b28-aaf2-6acf058152b1","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"8","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"a75692ee-94fc-443a-bac9-0ad543ece315","listenType":"","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"3","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"ac4422ff-15f2-49d9-8ee0-e65fb5334e3b","listenType":"","typeName":"听说训练4","type":"6f7ad514-9ccd-4ff9-a733-a6c4359493cf","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"},{"hw_type":"1","jiaocaiid":"1_7_1","score":"","avgScore":11.11,"hw_content":"b2e435a6-1290-4c3b-aacb-e9e20858a529","listenType":"","typeName":"Section A 3b","type":"5e1b0ace-ec3a-4056-b5ea-547fc3b0d85f","stu_hw_id":"4d7b6014-0e2f-47d1-891c-93c340bad00b"}]
         * tips : 作业未开始或已结束，不可做作业
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
             * hw_type : 6
             * jiaocaiid : 1_7_1
             * score :
             * avgScore : 11.11
             * hw_content : 800b3ed1-4fec-4a50-baa8-5cc2f9bf6492
             * listenType :
             * typeName : Starter阅读理解
             * type : 6ec73767-a83a-4bb0-a192-94726523f836
             * stu_hw_id : 4d7b6014-0e2f-47d1-891c-93c340bad00b
             */

            private String hw_type;
            private String jiaocaiid;
            private String score;
            private double avgScore;
            private String hw_content;
            private String listenType;
            private String typeName;
            private String type;
            private String stu_hw_id;

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

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
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

            public String getListenType() {
                return listenType;
            }

            public void setListenType(String listenType) {
                this.listenType = listenType;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStu_hw_id() {
                return stu_hw_id;
            }

            public void setStu_hw_id(String stu_hw_id) {
                this.stu_hw_id = stu_hw_id;
            }
        }
    }
}
