package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Spinner_TingL_Bean {

    private String personName;


    private String read_optionA;
    private String read_optionTextA;

    private String read_optionB;
    private String read_optionTextB;

    private String read_optionC;
    private String read_optionTextC;

    private String read_answer;

    public Spinner_TingL_Bean(String personName, String read_optionA, String read_optionTextA, String read_optionB, String read_optionTextB, String read_optionC, String read_optionTextC,String read_answer) {
        this.personName = personName;
        this.read_optionA = read_optionA;
        this.read_optionTextA = read_optionTextA;
        this.read_optionB = read_optionB;
        this.read_optionTextB = read_optionTextB;
        this.read_optionC = read_optionC;
        this.read_optionTextC = read_optionTextC;

        this.read_answer = read_answer;
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


        }
