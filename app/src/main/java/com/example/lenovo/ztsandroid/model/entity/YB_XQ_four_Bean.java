package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/19.
 */

public class YB_XQ_four_Bean implements Serializable {


    /**
     * data : [{"yb_id":5,"yb_video":"5.mp3","yb_symbol":"e","word":[{"yb_sym_video":"1.mp3","yb_sym_tran":" /hiː/ pron. 他","yb_sym_word":"he"},{"yb_sym_video":"2.mp3","yb_sym_tran":"/miː/ pron. 我","yb_sym_word":"me"},{"yb_sym_video":"3.mp3","yb_sym_tran":"/biː/ vt. 是","yb_sym_word":"be"},{"yb_sym_video":"4.mp3","yb_sym_tran":" /ʃiː/ pron. 她","yb_sym_word":"she"},{"yb_sym_video":"5.mp3","yb_sym_tran":" /wiː/ pron. 我们","yb_sym_word":"we"}]},{"yb_id":15,"yb_video":"6.mp3","yb_symbol":"ee,ea,ie,e","word":[]}]
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

    public static class DataBean implements Serializable{
        /**
         * yb_id : 5
         * yb_video : 5.mp3
         * yb_symbol : e
         * word : [{"yb_sym_video":"1.mp3","yb_sym_tran":" /hiː/ pron. 他","yb_sym_word":"he"},{"yb_sym_video":"2.mp3","yb_sym_tran":"/miː/ pron. 我","yb_sym_word":"me"},{"yb_sym_video":"3.mp3","yb_sym_tran":"/biː/ vt. 是","yb_sym_word":"be"},{"yb_sym_video":"4.mp3","yb_sym_tran":" /ʃiː/ pron. 她","yb_sym_word":"she"},{"yb_sym_video":"5.mp3","yb_sym_tran":" /wiː/ pron. 我们","yb_sym_word":"we"}]
         */

        private int yb_id;
        private String yb_video;
        private String yb_symbol;
        private List<WordBean> word;

        public int getYb_id() {
            return yb_id;
        }

        public void setYb_id(int yb_id) {
            this.yb_id = yb_id;
        }

        public String getYb_video() {
            return yb_video;
        }

        public void setYb_video(String yb_video) {
            this.yb_video = yb_video;
        }

        public String getYb_symbol() {
            return yb_symbol;
        }

        public void setYb_symbol(String yb_symbol) {
            this.yb_symbol = yb_symbol;
        }

        public List<WordBean> getWord() {
            return word;
        }

        public void setWord(List<WordBean> word) {
            this.word = word;
        }

        public static class WordBean implements Serializable{
            /**
             * yb_sym_video : 1.mp3
             * yb_sym_tran :  /hiː/ pron. 他
             * yb_sym_word : he
             */

            private String yb_sym_video;
            private String yb_sym_tran;
            private String yb_sym_word;

            public String getYb_sym_video() {
                return yb_sym_video;
            }

            public void setYb_sym_video(String yb_sym_video) {
                this.yb_sym_video = yb_sym_video;
            }

            public String getYb_sym_tran() {
                return yb_sym_tran;
            }

            public void setYb_sym_tran(String yb_sym_tran) {
                this.yb_sym_tran = yb_sym_tran;
            }

            public String getYb_sym_word() {
                return yb_sym_word;
            }

            public void setYb_sym_word(String yb_sym_word) {
                this.yb_sym_word = yb_sym_word;
            }
        }
    }
}
