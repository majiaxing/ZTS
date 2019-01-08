package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/12/6.
 */

public class Model implements Serializable {


    private boolean ischeck;
    private String st;

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

}
