package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/11/29.
 */

public class DataBean {

    /**
     * hw_type : 8
     * jiaocaiid : 0
     * typeList : [{"practice":0,"hw_answerId":"473fdbd3-d288-4dbe-8a44-574afbf24f58","phrase":"Good afternoon!","phrase_tran":"下午好","save":"1_2_7_1_01","phrase_video":"Good afternoon.mp3","phrase_id":"473fdbd3-d288-4dbe-8a44-574afbf24f58","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"4816c1c5-a7b1-4a3b-86d0-b0d567caf203","phrase":"Good morning!","phrase_tran":"早上好","save":"1_2_7_1_01","phrase_video":"Good morning.mp3","phrase_id":"4816c1c5-a7b1-4a3b-86d0-b0d567caf203","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"71955532-0260-4710-bc71-f70d453be1a4","phrase":"How are you?","phrase_tran":"你好吗","save":"1_2_7_1_01","phrase_video":"How are you.mp3","phrase_id":"71955532-0260-4710-bc71-f70d453be1a4","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","type":"8918feb6-3afd-4199-8595-685b8c4ca62c"},{"practice":0,"hw_answerId":"e92ff8d5-c264-4ca1-9e0b-093ad65f5738","phrase":"Good evening!","save":"1_2_7_1_01","phrase_video":"Good evening.mp3","phrase_id":"e92ff8d5-c264-4ca1-9e0b-093ad65f5738","Relative_path":"1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/","type":"8918feb6-3afd-4199-8595-685b8c4ca62c"}]
     * hw_content : 8918feb6-3afd-4199-8595-685b8c4ca62c
     * page : 0
     * Relative_path : 1_2_7_1_01/duanyu/8918feb6-3afd-4199-8595-685b8c4ca62c/
     * type : 8918feb6-3afd-4199-8595-685b8c4ca62c
     */

    private String hw_type;
    private String jiaocaiid;
    private String hw_content;
    private int page;
    private String Relative_path;
    private String type;
    private String typeList;

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

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }


}



