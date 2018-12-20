package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class YB_XQ_Two_Bean {


    /**
     * data : [{"yb_human":"human.video","yb_cartoon":"cartoon.video","yb_translate":" 现在来看看我们应该如何正确的发出/iː/这个音。\r\n\r\n    1）张开你的嘴巴，好像你在微笑，露出你的牙齿，嘴唇向两边伸开，成扁平形。\r\n    2）将舌前部向硬腭尽量抬起。舌头轻微接触下齿背部。\r\n    3）嘴唇绷紧，舌头肌肉保持紧张，震动声带，发出/iː/音。\r\n\r\n注意：/iː/个长元音，发音的时候要尽量拉长。"}]
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
         * yb_human : human.video
         * yb_cartoon : cartoon.video
         * yb_translate :  现在来看看我们应该如何正确的发出/iː/这个音。

         1）张开你的嘴巴，好像你在微笑，露出你的牙齿，嘴唇向两边伸开，成扁平形。
         2）将舌前部向硬腭尽量抬起。舌头轻微接触下齿背部。
         3）嘴唇绷紧，舌头肌肉保持紧张，震动声带，发出/iː/音。

         注意：/iː/个长元音，发音的时候要尽量拉长。
         */

        private String yb_human;
        private String yb_cartoon;
        private String yb_translate;

        public String getYb_human() {
            return yb_human;
        }

        public void setYb_human(String yb_human) {
            this.yb_human = yb_human;
        }

        public String getYb_cartoon() {
            return yb_cartoon;
        }

        public void setYb_cartoon(String yb_cartoon) {
            this.yb_cartoon = yb_cartoon;
        }

        public String getYb_translate() {
            return yb_translate;
        }

        public void setYb_translate(String yb_translate) {
            this.yb_translate = yb_translate;
        }
    }
}
