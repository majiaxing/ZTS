package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/14.
 */

public class JiaoC_Bean implements Serializable{


    /**
     * data : [{"jclx":"哈哈版","nj":"一年级","sxc":"上册"},{"jclx":"人教版","nj":"一年级","sxc":"上册"},{"jclx":"人教版","nj":"一年级","sxc":"上册"},{"jclx":"人教版","nj":"二年级","sxc":"上册"},{"jclx":"人教版","nj":"一年级","sxc":"上册"},{"jclx":"人教版","nj":"二年级","sxc":"上册"},{"jclx":"人教版","nj":"七年级","sxc":"上册"},{"nj":"五年级","sxc":"上册"},{"jclx":"test版","nj":"五年级","sxc":"上册"},null]
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : success
     * icon : null
     * code : 200
     */

    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
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

    public static class DataBean implements Serializable {
        /**
         * jclx : 哈哈版
         * nj : 一年级
         * sxc : 上册
         */

        private String jclx;
        private String nj;
        private String sxc;

        public String getJclx() {
            return jclx;
        }

        public void setJclx(String jclx) {
            this.jclx = jclx;
        }

        public String getNj() {
            return nj;
        }

        public void setNj(String nj) {
            this.nj = nj;
        }

        public String getSxc() {
            return sxc;
        }

        public void setSxc(String sxc) {
            this.sxc = sxc;
        }
    }
}
