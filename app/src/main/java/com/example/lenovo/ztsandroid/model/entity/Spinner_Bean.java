package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Spinner_Bean implements Serializable {

    private String personName;

    public Spinner_Bean(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
