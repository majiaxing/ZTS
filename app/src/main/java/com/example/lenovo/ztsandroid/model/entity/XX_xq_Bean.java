package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/11/19.
 */

public class XX_xq_Bean {


    /**
     * data : {"newtype":"学习资料","classId":"101374467889","newstate":"1","newcontent":"frfr","id":17}
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
         * newtype : 学习资料
         * classId : 101374467889
         * newstate : 1
         * newcontent : frfr
         * id : 17
         */

        private String newtype;
        private String classId;
        private String newstate;
        private String newcontent;
        private int id;

        public String getNewtype() {
            return newtype;
        }

        public void setNewtype(String newtype) {
            this.newtype = newtype;
        }

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getNewstate() {
            return newstate;
        }

        public void setNewstate(String newstate) {
            this.newstate = newstate;
        }

        public String getNewcontent() {
            return newcontent;
        }

        public void setNewcontent(String newcontent) {
            this.newcontent = newcontent;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
