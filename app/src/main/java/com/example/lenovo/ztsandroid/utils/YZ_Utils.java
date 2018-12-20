package com.example.lenovo.ztsandroid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/10/29.
 */

public class YZ_Utils {

    public static boolean isPhone(String inputText) {
        Pattern pat = Pattern.compile("^((14[0-9])|(13[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$");
        Matcher mat = pat.matcher(inputText);
        return mat.matches();

    }
    public static boolean isYanzheng(String inputText) {
        Pattern pat = Pattern.compile("^\\d{6}$");
        Matcher mat = pat.matcher(inputText);
        return mat.matches();

    }
}
