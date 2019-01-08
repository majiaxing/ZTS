package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/30.
 */

public class ZuoY_yb_Bean  implements Serializable {


    /**
     * hw_type : 0
     * jiaocaiid : 0
     * score : {"score":5}
     * HomeworkPath : homework/4567/41/
     * avgScore : 12
     * typeList : [{"hw_answerId":12,"yb_Bvideo":"bvideo","yb_wordId":12,"yb_Avideo":"Avideo","yb_photoes":"photo","hw_video":"Mario Maurer.mp3","everyScore":2.4,"yb_translate":"/biː/ n. 蜜蜂","hw_score":"1","yb_word":"bee"},{"hw_answerId":13,"yb_wordId":13,"hw_video":"Mario Maurer.mp3","everyScore":2.4,"yb_translate":"/wiː/ pron. 我们","hw_score":"1","yb_word":"we"},{"hw_answerId":14,"yb_wordId":14,"hw_video":"Mario Maurer.mp3","everyScore":2.4,"yb_translate":"/ri:d/ vt. 阅读","hw_score":"1","yb_word":"read"},{"hw_answerId":15,"yb_wordId":15,"hw_video":"Mario Maurer.mp3","everyScore":2.4,"yb_translate":"/miːt/ n. 肉","hw_score":"1","yb_word":"meat"},{"hw_answerId":16,"yb_wordId":16,"hw_video":"Mario Maurer.mp3","everyScore":2.4,"yb_translate":" /hiːt/ n. 高温","hw_score":"1","yb_word":"heat "}]
     * hw_content : 1
     * page : 0
     * Relative_path : yinbiao/
     * type : 0
     */

    private String hw_type;
    private String jiaocaiid;
    private ScoreBean score;
    private String HomeworkPath;
    private int avgScore;
    private String hw_content;
    private int page;
    private String Relative_path;
    private String type;
    private List<TypeListBean> typeList;

    public String getHw_type() {
        return hw_type;
    }

    public void setHw_type(String hw_type) {
        this.hw_type = hw_type;
    }

    public String getJiaocaiid() {
        return jiaocaiid;
    }

    public void setJiaocaiid(String jiaocaiid) {
        this.jiaocaiid = jiaocaiid;
    }

    public ScoreBean getScore() {
        return score;
    }

    public void setScore(ScoreBean score) {
        this.score = score;
    }

    public String getHomeworkPath() {
        return HomeworkPath;
    }

    public void setHomeworkPath(String HomeworkPath) {
        this.HomeworkPath = HomeworkPath;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public String getHw_content() {
        return hw_content;
    }

    public void setHw_content(String hw_content) {
        this.hw_content = hw_content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public List<TypeListBean> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeListBean> typeList) {
        this.typeList = typeList;
    }

    public static class ScoreBean implements Serializable{
        /**
         * score : 5
         */

        private int score;

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static class TypeListBean implements Serializable{
        /**
         * hw_answerId : 12
         * yb_Bvideo : bvideo
         * yb_wordId : 12
         * yb_Avideo : Avideo
         * yb_photoes : photo
         * hw_video : Mario Maurer.mp3
         * everyScore : 2.4
         * yb_translate : /biː/ n. 蜜蜂
         * hw_score : 1
         * yb_word : bee
         */

        private int hw_answerId;
        private String yb_Bvideo;
        private int yb_wordId;
        private String yb_Avideo;
        private String yb_photoes;
        private String hw_video;
        private double everyScore;
        private String yb_translate;
        private String hw_score;
        private String yb_word;

        public int getHw_answerId() {
            return hw_answerId;
        }

        public void setHw_answerId(int hw_answerId) {
            this.hw_answerId = hw_answerId;
        }

        public String getYb_Bvideo() {
            return yb_Bvideo;
        }

        public void setYb_Bvideo(String yb_Bvideo) {
            this.yb_Bvideo = yb_Bvideo;
        }

        public int getYb_wordId() {
            return yb_wordId;
        }

        public void setYb_wordId(int yb_wordId) {
            this.yb_wordId = yb_wordId;
        }

        public String getYb_Avideo() {
            return yb_Avideo;
        }

        public void setYb_Avideo(String yb_Avideo) {
            this.yb_Avideo = yb_Avideo;
        }

        public String getYb_photoes() {
            return yb_photoes;
        }

        public void setYb_photoes(String yb_photoes) {
            this.yb_photoes = yb_photoes;
        }

        public String getHw_video() {
            return hw_video;
        }

        public void setHw_video(String hw_video) {
            this.hw_video = hw_video;
        }

        public double getEveryScore() {
            return everyScore;
        }

        public void setEveryScore(double everyScore) {
            this.everyScore = everyScore;
        }

        public String getYb_translate() {
            return yb_translate;
        }

        public void setYb_translate(String yb_translate) {
            this.yb_translate = yb_translate;
        }

        public String getHw_score() {
            return hw_score;
        }

        public void setHw_score(String hw_score) {
            this.hw_score = hw_score;
        }

        public String getYb_word() {
            return yb_word;
        }

        public void setYb_word(String yb_word) {
            this.yb_word = yb_word;
        }
    }
}
