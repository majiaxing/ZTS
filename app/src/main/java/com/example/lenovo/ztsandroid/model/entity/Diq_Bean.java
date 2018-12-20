package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */

public class Diq_Bean {


    /**
     * data : [{"sheng_name":"宁夏回族自治区","sheng_id":"64"},{"sheng_name":"北京市","sheng_id":"11"},{"sheng_name":"天津市","sheng_id":"12"},{"sheng_name":"上海市","sheng_id":"31"},{"sheng_name":"江苏省","sheng_id":"32"},{"sheng_name":"湖北省","sheng_id":"42"},{"sheng_name":"湖南省","sheng_id":"43"},{"sheng_name":"河北省","sheng_id":"13"},{"sheng_name":"山西省","sheng_id":"14"},{"sheng_name":"内蒙古自治区","sheng_id":"15"},{"sheng_name":"辽宁省","sheng_id":"21"},{"sheng_name":"吉林省","sheng_id":"22"},{"sheng_name":"黑龙江省","sheng_id":"23"},{"sheng_name":"浙江省","sheng_id":"33"},{"sheng_name":"安徽省","sheng_id":"34"},{"sheng_name":"福建省","sheng_id":"35"},{"sheng_name":"江西省","sheng_id":"36"},{"sheng_name":"山东省","sheng_id":"37"},{"sheng_name":"河南省","sheng_id":"41"},{"sheng_name":"广东省","sheng_id":"44"},{"sheng_name":"广西壮族自治区","sheng_id":"45"},{"sheng_name":"海南省","sheng_id":"46"},{"sheng_name":"重庆市","sheng_id":"50"},{"sheng_name":"四川省","sheng_id":"51"},{"sheng_name":"贵州省","sheng_id":"52"},{"sheng_name":"云南省","sheng_id":"53"},{"sheng_name":"西藏自治区","sheng_id":"54"},{"sheng_name":"陕西省","sheng_id":"61"},{"sheng_name":"甘肃省","sheng_id":"62"},{"sheng_name":"青海省","sheng_id":"63"},{"sheng_name":"新疆维吾尔自治区","sheng_id":"65"}]
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
         * sheng_name : 宁夏回族自治区
         * sheng_id : 64
         */

        private String sheng_name;
        private String sheng_id;

        public String getSheng_name() {
            return sheng_name;
        }

        public void setSheng_name(String sheng_name) {
            this.sheng_name = sheng_name;
        }

        public String getSheng_id() {
            return sheng_id;
        }

        public void setSheng_id(String sheng_id) {
            this.sheng_id = sheng_id;
        }
    }
}
