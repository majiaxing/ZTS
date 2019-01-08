package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/14.
 */
public class LoginBean implements Serializable{


    /**
     * data : {"id":12,"juese":null,"caidan":null,"user":{"user_banji_d":"100063137259,100063137260","yonghuleixing":"学生","usertype_code":"5","user_sex_m":"男","user_school_m":"银川市第二中学","diqu_d":"640104","user_savepath":"user/5/12/","user_m":"majiaxing","zhanghao":"majiaxing","diqu_m":"兴庆区","user_school_d":"644006184","Id":12,"user_sex_d":"1"}}
     * data2 : 4E211052D10D65E175544A3BEA61E0B0
     * data3 : null
     * pageInfo : null
     * success : true
     * message : 登录成功
     * icon : null
     * token : null
     * code : 200
     */

    private DataBean data;
    private String data2;
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

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
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
         * id : 12
         * juese : null
         * caidan : null
         * user : {"user_banji_d":"100063137259,100063137260","yonghuleixing":"学生","usertype_code":"5","user_sex_m":"男","user_school_m":"银川市第二中学","diqu_d":"640104","user_savepath":"user/5/12/","user_m":"majiaxing","zhanghao":"majiaxing","diqu_m":"兴庆区","user_school_d":"644006184","Id":12,"user_sex_d":"1"}
         */

        private int id;
        private Object juese;
        private Object caidan;
        private UserBean user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getJuese() {
            return juese;
        }

        public void setJuese(Object juese) {
            this.juese = juese;
        }

        public Object getCaidan() {
            return caidan;
        }

        public void setCaidan(Object caidan) {
            this.caidan = caidan;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * user_banji_d : 100063137259,100063137260
             * yonghuleixing : 学生
             * usertype_code : 5
             * user_sex_m : 男
             * user_school_m : 银川市第二中学
             * diqu_d : 640104
             * user_savepath : user/5/12/
             * user_m : majiaxing
             * zhanghao : majiaxing
             * diqu_m : 兴庆区
             * user_school_d : 644006184
             * Id : 12
             * user_sex_d : 1
             */

            private String user_banji_d;
            private String yonghuleixing;
            private String usertype_code;
            private String user_sex_m;
            private String user_school_m;
            private String diqu_d;
            private String user_savepath;
            private String user_m;
            private String zhanghao;
            private String diqu_m;
            private String user_school_d;
            private int Id;
            private String user_sex_d;

            public String getUser_banji_d() {
                return user_banji_d;
            }

            public void setUser_banji_d(String user_banji_d) {
                this.user_banji_d = user_banji_d;
            }

            public String getYonghuleixing() {
                return yonghuleixing;
            }

            public void setYonghuleixing(String yonghuleixing) {
                this.yonghuleixing = yonghuleixing;
            }

            public String getUsertype_code() {
                return usertype_code;
            }

            public void setUsertype_code(String usertype_code) {
                this.usertype_code = usertype_code;
            }

            public String getUser_sex_m() {
                return user_sex_m;
            }

            public void setUser_sex_m(String user_sex_m) {
                this.user_sex_m = user_sex_m;
            }

            public String getUser_school_m() {
                return user_school_m;
            }

            public void setUser_school_m(String user_school_m) {
                this.user_school_m = user_school_m;
            }

            public String getDiqu_d() {
                return diqu_d;
            }

            public void setDiqu_d(String diqu_d) {
                this.diqu_d = diqu_d;
            }

            public String getUser_savepath() {
                return user_savepath;
            }

            public void setUser_savepath(String user_savepath) {
                this.user_savepath = user_savepath;
            }

            public String getUser_m() {
                return user_m;
            }

            public void setUser_m(String user_m) {
                this.user_m = user_m;
            }

            public String getZhanghao() {
                return zhanghao;
            }

            public void setZhanghao(String zhanghao) {
                this.zhanghao = zhanghao;
            }

            public String getDiqu_m() {
                return diqu_m;
            }

            public void setDiqu_m(String diqu_m) {
                this.diqu_m = diqu_m;
            }

            public String getUser_school_d() {
                return user_school_d;
            }

            public void setUser_school_d(String user_school_d) {
                this.user_school_d = user_school_d;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getUser_sex_d() {
                return user_sex_d;
            }

            public void setUser_sex_d(String user_sex_d) {
                this.user_sex_d = user_sex_d;
            }
        }
    }
}
