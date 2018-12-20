package com.example.lenovo.ztsandroid.model.entity;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/11/2.
 */

public class XX_Bean {

    private int Toux;
    private String Title;
    private String Neirong;
    private String Data;
    private String Wdxx;
    public XX_Bean(int toux, String title, String neirong, String data,String wdxx ) {
        Toux = toux;
        Title = title;
        Neirong = neirong;
        Data = data;
        Wdxx = wdxx;

    }

    public int getToux() {
        return Toux;
    }

    public void setToux(int toux) {
        Toux = toux;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getNeirong() {
        return Neirong;
    }

    public void setNeirong(String neirong) {
        Neirong = neirong;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getWdxx() {
        return Wdxx;
    }

    public void setWdxx(String wdxx) {
        Wdxx = wdxx;
    }
}
