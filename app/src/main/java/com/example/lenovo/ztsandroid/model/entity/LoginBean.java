package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/14.
 */
public class LoginBean {


    /**
     * data : [{"memberState":"0","stuid":41,"student":"马佳兴","schoolId":"6401","sex":"1","endtime":"2018-11-14T16:00:00.000+0000","areas":"640102","starttime":"2018-11-14T16:00:00.000+0000","username":"majiaxing"}]
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : 登录成功
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

    public static class DataBean {
        /**
         * memberState : 0
         * stuid : 41
         * student : 马佳兴
         * schoolId : 6401
         * sex : 1
         * endtime : 2018-11-14T16:00:00.000+0000
         * areas : 640102
         * starttime : 2018-11-14T16:00:00.000+0000
         * username : majiaxing
         */

        private String memberState;
        private int stuid;
        private String student;
        private String schoolId;
        private String sex;
        private String endtime;
        private String areas;
        private String starttime;
        private String username;

        public String getMemberState() {
            return memberState;
        }

        public void setMemberState(String memberState) {
            this.memberState = memberState;
        }

        public int getStuid() {
            return stuid;
        }

        public void setStuid(int stuid) {
            this.stuid = stuid;
        }

        public String getStudent() {
            return student;
        }

        public void setStudent(String student) {
            this.student = student;
        }

        public String getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(String schoolId) {
            this.schoolId = schoolId;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getAreas() {
            return areas;
        }

        public void setAreas(String areas) {
            this.areas = areas;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
