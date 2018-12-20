package com.example.lenovo.ztsandroid.utils;

import android.net.wifi.hotspot2.pps.Credential;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static cn.hutool.extra.template.TemplateConfig.ResourceMode.FILE;
//import javax.xml.bind.DatatypeConverter;

/**
 * Created by Administrator on 2018/12/10.
 */

public class HMACTest {

    private static final String LOG_TAG = "HMACTest";
    private static final String REGISTER_HMAC_KEY = "oSF1kR2RegatkWAkDYlpGfyDKFqGLLGE";

    public static String stringToSign(String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec secret = new SecretKeySpec(
                    REGISTER_HMAC_KEY.getBytes("UTF-8"), mac.getAlgorithm());
            mac.init(secret);
            return Base64.encodeToString(mac.doFinal(data.getBytes()), Base64.NO_WRAP);
        } catch (NoSuchAlgorithmException e) {
            Log.e(LOG_TAG, "Hash algorithm SHA-1 is not supported", e);
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Encoding UTF-8 is not supported", e);
        } catch (InvalidKeyException e) {
            Log.e(LOG_TAG, "Invalid key", e);
        }
        return "";
    }



    public static String getStringToSign(String method, String endpoint, TreeMap<String, Object> params) {
        StringBuilder s2s = new StringBuilder();
        s2s.append(method).append(endpoint).append("/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.toString().substring(0, s2s.length() - 1);
    }




    public static String sign(String s, String key, String method) throws Exception {
        Mac mac = Mac.getInstance(method);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("ISO_8859_1"), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes("ISO_8859_1"));

        return Base64.encodeToString(hash,Base64.DEFAULT);

//        return DatatypeConverter.printBase64Binary(hash);

    }


//    public void reSampleRate(String inputPath,String outputPath,int inputSampleRate,int outputSampleRate) {
//        File BeforeSampleChangedFile = new File(inputPath);
//        File SampleChangedFile = new File(outputPath);
//        try {
//            FileInputStream fis = new FileInputStream(BeforeSampleChangedFile);
//            FileOutputStream fos = new FileOutputStream(SampleChangedFile);
//            //同样低采样率转高采样率也是可以的，改下面参数就行。
//            new SSRC(fis, fos, inputSampleRate, outputSampleRate, 2, 2, 1, Integer.MAX_VALUE, 0, 0, true);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



    /**
     * 文件转base64字符串
     *
     * @param file
     * @return
     */
    public static String fileToBase64(File file) {
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int length = in.read(bytes);

            MyLog.e("sdhauihwsda",length +"");

            base64 = Base64.encodeToString(bytes, 0, length, Base64.NO_WRAP);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return base64;
    }

}
