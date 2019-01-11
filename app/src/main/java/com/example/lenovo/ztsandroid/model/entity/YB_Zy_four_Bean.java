package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/1/2.
 */
public class YB_Zy_four_Bean implements Serializable{


    /**
     * data : {"typeList":[{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":1,"yb_symbol":"i","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"sick.mp3","yb_sym_tran":"[sɪk]","yb_sym_word":"sick"},{"yb_sym_video":"dinner.mp3","yb_sym_tran":"[ˈdɪnə]","yb_sym_word":"dinner"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":2,"yb_symbol":"e","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"remain.mp3","yb_sym_tran":"[rɪˈmeɪn]","yb_sym_word":"remain"},{"yb_sym_video":"ticket.mp3","yb_sym_tran":"[ˈtɪkɪt]","yb_sym_word":"ticket"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":3,"yb_symbol":"u","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"minute.mp3","yb_sym_tran":"[ˈmɪnɪt]","yb_sym_word":"minute"},{"yb_sym_video":"business.mp3","yb_sym_tran":"[ˈbɪznəs]","yb_sym_word":"business"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":4,"yb_symbol":"ui","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"build.mp3","yb_sym_tran":"[bɪld]","yb_sym_word":"build"},{"yb_sym_video":"guitar.mp3","yb_sym_tran":"[gɪˈtɑ:]","yb_sym_word":"guitar"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":5,"yb_symbol":"y","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"bicycle.mp3","yb_sym_tran":"[ˈbaɪsɪkl]","yb_sym_word":"bicycle"},{"yb_sym_video":"party.mp3","yb_sym_tran":"[ˈpɑːtɪ]","yb_sym_word":"party"}]}],"Relative_path":"yinbiao/1/"}
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

    public static class DataBean implements Serializable{
        /**
         * typeList : [{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":1,"yb_symbol":"i","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"sick.mp3","yb_sym_tran":"[sɪk]","yb_sym_word":"sick"},{"yb_sym_video":"dinner.mp3","yb_sym_tran":"[ˈdɪnə]","yb_sym_word":"dinner"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":2,"yb_symbol":"e","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"remain.mp3","yb_sym_tran":"[rɪˈmeɪn]","yb_sym_word":"remain"},{"yb_sym_video":"ticket.mp3","yb_sym_tran":"[ˈtɪkɪt]","yb_sym_word":"ticket"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":3,"yb_symbol":"u","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"minute.mp3","yb_sym_tran":"[ˈmɪnɪt]","yb_sym_word":"minute"},{"yb_sym_video":"business.mp3","yb_sym_tran":"[ˈbɪznəs]","yb_sym_word":"business"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":4,"yb_symbol":"ui","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"build.mp3","yb_sym_tran":"[bɪld]","yb_sym_word":"build"},{"yb_sym_video":"guitar.mp3","yb_sym_tran":"[gɪˈtɑ:]","yb_sym_word":"guitar"}]},{"HomeworkPath":"homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/","yb_id":5,"yb_symbol":"y","Relative_path":"yinbiao/1/","everyScore":2.22,"word":[{"yb_sym_video":"bicycle.mp3","yb_sym_tran":"[ˈbaɪsɪkl]","yb_sym_word":"bicycle"},{"yb_sym_video":"party.mp3","yb_sym_tran":"[ˈpɑːtɪ]","yb_sym_word":"party"}]}]
         * Relative_path : yinbiao/1/
         */

        private String Relative_path;
        private List<TypeListBean> typeList;

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public List<TypeListBean> getTypeList() {
            return typeList;
        }

        public void setTypeList(List<TypeListBean> typeList) {
            this.typeList = typeList;
        }

        public static class TypeListBean implements Serializable{
            /**
             * HomeworkPath : homework/b98526a5-e6f2-44a2-8281-81fe44c1d8ae/63/0/1/null/
             * yb_id : 1
             * yb_symbol : i
             * Relative_path : yinbiao/1/
             * everyScore : 2.22
             * word : [{"yb_sym_video":"sick.mp3","yb_sym_tran":"[sɪk]","yb_sym_word":"sick"},{"yb_sym_video":"dinner.mp3","yb_sym_tran":"[ˈdɪnə]","yb_sym_word":"dinner"}]
             */

            private String HomeworkPath;
            private int yb_id;
            private String yb_symbol;
            private String Relative_path;
            private double everyScore;
            private List<WordBean> word;

            public String getHomeworkPath() {
                return HomeworkPath;
            }

            public void setHomeworkPath(String HomeworkPath) {
                this.HomeworkPath = HomeworkPath;
            }

            public int getYb_id() {
                return yb_id;
            }

            public void setYb_id(int yb_id) {
                this.yb_id = yb_id;
            }

            public String getYb_symbol() {
                return yb_symbol;
            }

            public void setYb_symbol(String yb_symbol) {
                this.yb_symbol = yb_symbol;
            }

            public String getRelative_path() {
                return Relative_path;
            }

            public void setRelative_path(String Relative_path) {
                this.Relative_path = Relative_path;
            }

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public List<WordBean> getWord() {
                return word;
            }

            public void setWord(List<WordBean> word) {
                this.word = word;
            }

            public static class WordBean implements Serializable{
                /**
                 * yb_sym_video : sick.mp3
                 * yb_sym_tran : [sɪk]
                 * yb_sym_word : sick
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
}
