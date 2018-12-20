package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ZuoY_list_Bean {


    /**
     * data : [{"scoreAll":"待完成","homework_cishu":"1","homewordName":"zuoye1","flag":"已结束","stuid":"41","finishPeople":0,"startTime":"2018-11-26T02:46:26.000+0000","endTime":"2018-11-26T08:05:34.000+0000","hwid":"45670"},{"scoreAll":73,"homework_cishu":"0","homewordName":"zuoye2","flag":"已结束","stuid":"41","finishPeople":1,"startTime":"2018-11-26T08:19:44.000+0000","endTime":"2018-11-25T08:05:34.000+0000","hwid":"4567"}]
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
         * scoreAll : 待完成
         * homework_cishu : 1
         * homewordName : zuoye1
         * flag : 已结束
         * stuid : 41
         * finishPeople : 0
         * startTime : 2018-11-26T02:46:26.000+0000
         * endTime : 2018-11-26T08:05:34.000+0000
         * hwid : 45670
         */

        private String scoreAll;
        private String homework_cishu;
        private String homewordName;
        private String flag;
        private String stuid;
        private int finishPeople;
        private String startTime;
        private String endTime;
        private String hwid;

        public String getScoreAll() {
            return scoreAll;
        }

        public void setScoreAll(String scoreAll) {
            this.scoreAll = scoreAll;
        }

        public String getHomework_cishu() {
            return homework_cishu;
        }

        public void setHomework_cishu(String homework_cishu) {
            this.homework_cishu = homework_cishu;
        }

        public String getHomewordName() {
            return homewordName;
        }

        public void setHomewordName(String homewordName) {
            this.homewordName = homewordName;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getStuid() {
            return stuid;
        }

        public void setStuid(String stuid) {
            this.stuid = stuid;
        }

        public int getFinishPeople() {
            return finishPeople;
        }

        public void setFinishPeople(int finishPeople) {
            this.finishPeople = finishPeople;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getHwid() {
            return hwid;
        }

        public void setHwid(String hwid) {
            this.hwid = hwid;
        }
    }
}
