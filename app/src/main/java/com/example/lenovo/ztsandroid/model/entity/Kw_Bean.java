package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/14.
 */

public class Kw_Bean {


    /**
     * data : [{"practice":"0/4","dy":"预习单元1","save":"1_2_7_1_1001","Relative_path":"1_2_7_1_1001/","type":"dd46177a-eae5-466b-aa0e-e28235425ac4","photos":"13.png"},{"practice":"0/1","dy":"预习单元2","save":"1_2_7_1_1002","Relative_path":"1_2_7_1_1002/","type":"5e1b0ace-ec3a-4056-b5ea-547fc3b0d85f","photos":"3.jpg"},{"practice":"0/8","dy":"第一单元","save":"1_2_7_1_2001","Relative_path":"1_2_7_1_2001/","type":"a75692ee-94fc-443a-bac9-0ad543ece315","photos":"1.png"},{"practice":"0/5","dy":"第二单元","save":"1_2_7_1_2002","Relative_path":"1_2_7_1_2002/","type":"6f7ad514-9ccd-4ff9-a733-a6c4359493cf","photos":"5.png"},{"practice":"0/8","dy":"第三单元","save":"1_2_7_1_2003","Relative_path":"1_2_7_1_2003/","type":"836b983b-0489-4314-b246-481e5dcbaf7d","photos":"6.png"},{"practice":"0/6","dy":"第四单元","save":"1_2_7_1_2004","Relative_path":"1_2_7_1_2004/","type":"5ec40736-b828-4f7c-8e94-165e719050cf","photos":"7.jpg"},{"practice":"0/9","dy":"第五单元","save":"1_2_7_1_2005","Relative_path":"1_2_7_1_2005/","type":"f7534012-5fd4-4cdb-b9fb-623eef3b08f1","photos":"8.png"},{"practice":"0/5","dy":"第六单元","save":"1_2_7_1_2006","Relative_path":"1_2_7_1_2006/","type":"7d77bbf0-f1cb-47f6-891b-4d516cfaa538","photos":"9.png"},{"practice":"0/5","dy":"第七单元","save":"1_2_7_1_2007","Relative_path":"1_2_7_1_2007/","type":"6920c34c-4320-4a35-9f98-51bbc79df33f","photos":"10.png"},{"practice":"0/10","dy":"第八单元","save":"1_2_7_1_2008","Relative_path":"1_2_7_1_2008/","type":"22fd42d3-0102-40f5-94a5-58f4d9d7fd9d","photos":"11.png"},{"practice":"0/5","dy":"第九单元","save":"1_2_7_1_2009","Relative_path":"1_2_7_1_2009/","type":"05086b50-4aeb-4135-957a-4185c247d23a","photos":"12.png"}]
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
         * practice : 0/4
         * dy : 预习单元1
         * save : 1_2_7_1_1001
         * Relative_path : 1_2_7_1_1001/
         * type : dd46177a-eae5-466b-aa0e-e28235425ac4
         * photos : 13.png
         */

        private String practice;
        private String dy;
        private String save;
        private String Relative_path;
        private String type;
        private String photos;

        public String getPractice() {
            return practice;
        }

        public void setPractice(String practice) {
            this.practice = practice;
        }

        public String getDy() {
            return dy;
        }

        public void setDy(String dy) {
            this.dy = dy;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }
    }
}
