package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ZuoY_erJ_Bean {


    /**
     * data : {"homeworkType":[{"hw_type":"2","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"dd46177a-eae5-466b-aa0e-e28235425ac4","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"8","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"dd46177a-eae5-466b-aa0e-e28235425ac4","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"3","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"6d2a87e7-0507-4b5e-8c22-d09e472935a4","listenType":"","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"1","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"4295bf8f-900d-4655-846a-723cde9a7127","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"1","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"f05fe173-3dbd-487c-ad57-4f9cdb4dd886","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"4","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"95e42fa3-14a8-438b-bf06-8d52727c1c5b","listenType":"","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"5","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"03a78ddc-e722-4d23-9eca-925b4725f427","listenType":"1","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"5","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"05663253-5882-4591-86aa-94fab7af0272","listenType":"2","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"6","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"800b3ed1-4fec-4a50-baa8-5cc2f9bf6492","listenType":"","typeName":"预习1-3单元","type":"6ec73767-a83a-4bb0-a192-94726523f836"}],"tips":"本作业只能完成一次"}
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
         * homeworkType : [{"hw_type":"2","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"dd46177a-eae5-466b-aa0e-e28235425ac4","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"8","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"dd46177a-eae5-466b-aa0e-e28235425ac4","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"3","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"6d2a87e7-0507-4b5e-8c22-d09e472935a4","listenType":"","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"1","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"4295bf8f-900d-4655-846a-723cde9a7127","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"1","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"f05fe173-3dbd-487c-ad57-4f9cdb4dd886","listenType":"","typeName":"预习单元1","type":"dd46177a-eae5-466b-aa0e-e28235425ac4"},{"hw_type":"4","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"95e42fa3-14a8-438b-bf06-8d52727c1c5b","listenType":"","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"5","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"03a78ddc-e722-4d23-9eca-925b4725f427","listenType":"1","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"5","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"05663253-5882-4591-86aa-94fab7af0272","listenType":"2","typeName":"第一单元","type":"a75692ee-94fc-443a-bac9-0ad543ece315"},{"hw_type":"6","jiaocaiid":"1_7_1","avgScore":11.11,"hw_content":"800b3ed1-4fec-4a50-baa8-5cc2f9bf6492","listenType":"","typeName":"预习1-3单元","type":"6ec73767-a83a-4bb0-a192-94726523f836"}]
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
             * hw_type : 2
             * jiaocaiid : 1_7_1
             * avgScore : 11.11
             * hw_content : dd46177a-eae5-466b-aa0e-e28235425ac4
             * listenType :
             * typeName : 预习单元1
             * type : dd46177a-eae5-466b-aa0e-e28235425ac4
             */

            private String hw_type;
            private String jiaocaiid;
            private double avgScore;
            private String hw_content;
            private String listenType;
            private String typeName;
            private String type;

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
        }
    }
}
