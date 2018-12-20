package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Kw_erji_list_Bean {


    /**
     * data : [{"text_id":"16ea2bc7-752e-42a9-8563-3ed9e4b1b01b","text_title":"Aron Ralston  2","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/16ea2bc7-752e-42a9-8563-3ed9e4b1b01b/"},{"text_id":"5837344e-4d60-450e-9638-d1cf96737a31","text_title":"Saving an old man  1","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/5837344e-4d60-450e-9638-d1cf96737a31/"},{"text_id":"637633ba-42cb-452e-96f1-e44e8e141ffa","text_title":"Climbing 1","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/637633ba-42cb-452e-96f1-e44e8e141ffa/"},{"text_id":"84536e6b-7b15-4dae-b376-818e2843d147","text_title":"Seeing a doctor","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/84536e6b-7b15-4dae-b376-818e2843d147/"},{"text_id":"9d2cb57e-f308-496c-a614-f3a5ddee5876","text_title":"Aron Ralston 3","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/9d2cb57e-f308-496c-a614-f3a5ddee5876/"},{"text_id":"dc5dff20-8b08-44fa-b4b1-a4a0c88ecce1","text_title":"Saving an old man 3","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/dc5dff20-8b08-44fa-b4b1-a4a0c88ecce1/"},{"text_id":"e3f9ad82-31e1-4c44-9809-5671ed1742f5","text_title":"Aron Ralston 1","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/e3f9ad82-31e1-4c44-9809-5671ed1742f5/"},{"text_id":"ec847036-b6b2-43e4-93e4-b707f49587a7","text_title":"Saving an Old Man","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/ec847036-b6b2-43e4-93e4-b707f49587a7/"},{"text_id":"f591157e-f442-46cb-a99e-4f4a19acbc38","text_title":"Climbing 2","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/f591157e-f442-46cb-a99e-4f4a19acbc38/"},{"text_id":"fa7444c3-fb48-455f-b32d-dffdcca7da9a","text_title":"Saving an old man  2","practice":0,"save":"1_2_8_2_2001","Relative_path":"1_2_8_2_2001/kewen/fa7444c3-fb48-455f-b32d-dffdcca7da9a/"}]
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
         * text_id : 16ea2bc7-752e-42a9-8563-3ed9e4b1b01b
         * text_title : Aron Ralston  2
         * practice : 0
         * save : 1_2_8_2_2001
         * Relative_path : 1_2_8_2_2001/kewen/16ea2bc7-752e-42a9-8563-3ed9e4b1b01b/
         */

        private String text_id;
        private String text_title;
        private int practice;
        private String save;
        private String Relative_path;

        public String getText_id() {
            return text_id;
        }

        public void setText_id(String text_id) {
            this.text_id = text_id;
        }

        public String getText_title() {
            return text_title;
        }

        public void setText_title(String text_title) {
            this.text_title = text_title;
        }

        public int getPractice() {
            return practice;
        }

        public void setPractice(int practice) {
            this.practice = practice;
        }

        public String getSave() {
            return save;
        }

        public void setSave(String save) {
            this.save = save;
        }

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }
    }
}
