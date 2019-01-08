package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/19.
 */

public class XX_xq_Bean implements Serializable {


    /**
     * data : {"newtype":"作业消息","homeworkName":"hhhha哈哈","newstate":"1","stuid":"63","newtime":"2018-12-29 16:13:49","newcontent":"王军军老师布置作业:hhhha哈哈","end":"2018-12-29","id":79,"hwid":"1f1a17f7-9351-412a-a984-ae2bb291f10b"}
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
         * newtype : 作业消息
         * homeworkName : hhhha哈哈
         * newstate : 1
         * stuid : 63
         * newtime : 2018-12-29 16:13:49
         * newcontent : 王军军老师布置作业:hhhha哈哈
         * end : 2018-12-29
         * id : 79
         * hwid : 1f1a17f7-9351-412a-a984-ae2bb291f10b
         */

        private String newtype;
        private String homeworkName;
        private String newstate;
        private String stuid;
        private String newtime;
        private String newcontent;
        private String end;
        private int id;
        private String hwid;

        public String getNewtype() {
            return newtype;
        }

        public void setNewtype(String newtype) {
            this.newtype = newtype;
        }

        public String getHomeworkName() {
            return homeworkName;
        }

        public void setHomeworkName(String homeworkName) {
            this.homeworkName = homeworkName;
        }

        public String getNewstate() {
            return newstate;
        }

        public void setNewstate(String newstate) {
            this.newstate = newstate;
        }

        public String getStuid() {
            return stuid;
        }

        public void setStuid(String stuid) {
            this.stuid = stuid;
        }

        public String getNewtime() {
            return newtime;
        }

        public void setNewtime(String newtime) {
            this.newtime = newtime;
        }

        public String getNewcontent() {
            return newcontent;
        }

        public void setNewcontent(String newcontent) {
            this.newcontent = newcontent;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHwid() {
            return hwid;
        }

        public void setHwid(String hwid) {
            this.hwid = hwid;
        }
    }
}
