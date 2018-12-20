package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Spinner_D_Bean {

    private String personName;
    private String Value;

    public Spinner_D_Bean(String personName, String value) {
        this.personName = personName;
        Value = value;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
