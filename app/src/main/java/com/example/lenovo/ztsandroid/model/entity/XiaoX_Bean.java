package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/15.
 */

public class XiaoX_Bean  implements Serializable {


    /**
     * data : [{"newtype":"作业消息","newstate":"1","stuid":"12","newtime":"2018-12-15T09:20:55.000+0000","newcontent":"王军军老师布置作业:我要布置","id":37},{"newtype":"作业消息","newstate":"1","stuid":"12","newtime":"2018-12-15T09:14:05.000+0000","newcontent":"王军军老师布置作业:weweiwanchweiwancheng","id":30},{"newtype":"作业消息","newstate":"1","stuid":"12","newtime":"2018-12-15T02:58:28.000+0000","newcontent":"王军军老师布置作业:123456","id":23},{"newtype":"作业消息","newstate":"1","stuid":"12","newtime":"2018-12-15T02:47:41.000+0000","newcontent":"王军军老师布置作业:111","id":16},{"newtype":"作业消息","newstate":"1","stuid":"12","newtime":"2018-12-15T02:45:17.000+0000","newcontent":"王军军老师布置作业:123456","id":11}]
     * data2 : null
     * data3 : null
     * pageInfo : 5
     * success : true
     * message : success
     * icon : null
     * token : null
     * code : 200
     */

    private Object data2;
    private Object data3;
    private int pageInfo;
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

    public int getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(int pageInfo) {
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

    public static class DataBean {
        /**
         * newtype : 作业消息
         * newstate : 1
         * stuid : 12
         * newtime : 2018-12-15T09:20:55.000+0000
         * newcontent : 王军军老师布置作业:我要布置
         * id : 37
         */

        private String newtype;
        private String newstate;
        private String stuid;
        private String newtime;
        private String newcontent;
        private int id;
        private boolean ischeck;

        public boolean ischeck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        public String getNewtype() {
            return newtype;
        }

        public void setNewtype(String newtype) {
            this.newtype = newtype;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
