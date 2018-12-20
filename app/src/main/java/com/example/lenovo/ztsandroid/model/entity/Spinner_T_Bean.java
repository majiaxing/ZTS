package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Spinner_T_Bean {

    private String personName;


    private String read_optionA;
    private String read_optionTextA;

    private String read_optionB;
    private String read_optionTextB;

    private String read_optionC;
    private String read_optionTextC;

    private String read_optionD;
    private String read_optionTextD;

    private String read_answer;

    private String hw_answerId;

    public Spinner_T_Bean(String personName, String read_optionA, String read_optionTextA, String read_optionB, String read_optionTextB, String read_optionC, String read_optionTextC, String read_optionD, String read_optionTextD, String read_answer,String hw_answerId) {
        this.personName = personName;
        this.read_optionA = read_optionA;
        this.read_optionTextA = read_optionTextA;
        this.read_optionB = read_optionB;
        this.read_optionTextB = read_optionTextB;
        this.read_optionC = read_optionC;
        this.read_optionTextC = read_optionTextC;
        this.read_optionD = read_optionD;
        this.read_optionTextD = read_optionTextD;
        this.read_answer = read_answer;
        this.hw_answerId =  hw_answerId;
    }

    public String getHw_answerId() {
        return hw_answerId;
    }

    public void setHw_answerId(String hw_answerId) {
        this.hw_answerId = hw_answerId;
    }

    public String getRead_answer() {
        return read_answer;
    }

    public void setRead_answer(String read_answer) {
        this.read_answer = read_answer;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getRead_optionA() {
        return read_optionA;
    }

    public void setRead_optionA(String read_optionA) {
        this.read_optionA = read_optionA;
    }

    public String getRead_optionTextA() {
        return read_optionTextA;
    }

    public void setRead_optionTextA(String read_optionTextA) {
        this.read_optionTextA = read_optionTextA;
    }

    public String getRead_optionB() {
        return read_optionB;
    }

    public void setRead_optionB(String read_optionB) {
        this.read_optionB = read_optionB;
    }

    public String getRead_optionTextB() {
        return read_optionTextB;
    }

    public void setRead_optionTextB(String read_optionTextB) {
        this.read_optionTextB = read_optionTextB;
    }

    public String getRead_optionC() {
        return read_optionC;
    }

    public void setRead_optionC(String read_optionC) {
        this.read_optionC = read_optionC;
    }

    public String getRead_optionTextC() {
        return read_optionTextC;
    }

    public void setRead_optionTextC(String read_optionTextC) {
        this.read_optionTextC = read_optionTextC;
    }

    public String getRead_optionD() {
        return read_optionD;
    }

    public void setRead_optionD(String read_optionD) {
        this.read_optionD = read_optionD;
    }

    public String getRead_optionTextD() {
        return read_optionTextD;
    }

    public void setRead_optionTextD(String read_optionTextD) {
        this.read_optionTextD = read_optionTextD;
    }
}
