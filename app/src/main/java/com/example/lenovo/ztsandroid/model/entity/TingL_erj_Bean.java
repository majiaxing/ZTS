package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */

public class TingL_erj_Bean {


    /**
     * data : [{"listen_id":"d925fb91-97d8-4cc8-af3b-23cb37b5d063","save":"1_2_7_1_1","listen_name":"","Relative_path":"1_2_7_1_1/tingli/d925fb91-97d8-4cc8-af3b-23cb37b5d063/","listen_type":"1"}]
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

    public static class DataBean {
        /**
         * listen_id : d925fb91-97d8-4cc8-af3b-23cb37b5d063
         * save : 1_2_7_1_1
         * listen_name :
         * Relative_path : 1_2_7_1_1/tingli/d925fb91-97d8-4cc8-af3b-23cb37b5d063/
         * listen_type : 1
         */

        private String listen_id;
        private String save;
        private String listen_name;
        private String Relative_path;
        private String listen_type;

        public String getListen_id() {
            return listen_id;
        }

        public void setListen_id(String listen_id) {
            this.listen_id = listen_id;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }

        public String getListen_name() {
            return listen_name;
        }

        public void setListen_name(String listen_name) {
            this.listen_name = listen_name;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public String getListen_type() {
            return listen_type;
        }

        public void setListen_type(String listen_type) {
            this.listen_type = listen_type;
        }
    }
}
