package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/12/9.
 */

public class Spinner_Zuoy_Bean implements Serializable {


    private ArrayList<Spinner_Zuoy_Bean.DataBean> data;
    private String type;
    public Spinner_Zuoy_Bean(String type) {
        this.type = type;
    }


    public ArrayList<Spinner_Zuoy_Bean.DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<Spinner_Zuoy_Bean.DataBean> data) {
        this.data = data;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class DataBean {

        private String personName;
        private String Value;
        private int size;
        public DataBean(String personName, String value,int size) {
            this.personName = personName;
            this.Value = value;
            this.size = size;
        }



        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
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
}
