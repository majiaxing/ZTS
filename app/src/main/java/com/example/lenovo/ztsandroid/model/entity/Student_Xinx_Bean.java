package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/12/4.
 */
public class Student_Xinx_Bean {


    /**
     * data : {"stuTupian":"1.tmp","memberState":"1","classId":"12","stuid":41,"student":"majiaxing","school":"溏涞回中","endtime":"2020-11-28T09:57:04.000+0000","areas":"majiaxing","starttime":"2018-11-28T09:57:04.000+0000","username":"majiaxing"}
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
         * stuTupian : 1.tmp
         * memberState : 1
         * classId : 12
         * stuid : 41
         * student : majiaxing
         * school : 溏涞回中
         * endtime : 2020-11-28T09:57:04.000+0000
         * areas : majiaxing
         * starttime : 2018-11-28T09:57:04.000+0000
         * username : majiaxing
         */

        private String stuTupian;
        private String memberState;
        private String classId;
        private int stuid;
        private String student;
        private String school;
        private String endtime;
        private String areas;
        private String starttime;
        private String username;

        public String getStuTupian() {
            return stuTupian;
        }

        public void setStuTupian(String stuTupian) {
            this.stuTupian = stuTupian;
        }

        public String getMemberState() {
            return memberState;
        }

        public void setMemberState(String memberState) {
            this.memberState = memberState;
        }

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
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

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
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
