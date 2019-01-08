package com.example.lenovo.ztsandroid.net;


import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;
import com.example.lenovo.ztsandroid.utils.ACache;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSource;
import okio.HashingSource;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * 基于OKhttp发送网络请求
 * Created by xingge on 2017/7/11.
 */

public class OkHttpUtils implements IHttp {
    private String androidid;
    private OkHttpClient okHttpClient;
    //构造函数私有化
    private OkHttpUtils(){
        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static OkHttpUtils okHttpUtils;

    //提供一个公共的、静态的、返回值类型是当前本类的对象
    public static OkHttpUtils getInstance(){
        if(okHttpUtils == null){
            synchronized (OkHttpUtils.class){
                if(okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }

    /**
     * 发送get请求
     * @param url 请求地址
     * @param params 请求参数
     * @param callback 回调
     * @param <T> 请求回来的数据对应的JavaBean
     */
    @Override
    public <T> void get(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {


        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);

                sb.append(key).append("=").append(value).append("&");
                MyLog.e("请求数据",params.toString());
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request request = new Request.Builder().url(url).build();

            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //执行在主线程
                            callback.onError(404, e.getMessage().toString());

                        }
                    });
                }


                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    if (response.code()==200) {

                        final String jsonData = response.body().string();

                        App.context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //执行在主线程
                                callback.onSuccess(getGeneric(jsonData, callback));
                            }
                        });


                    }
                }
            });

    }

    @Override
    public <T> void post(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {


        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
                Log.e("AAAAAAAAAAAAAAAAAAA",params.toString());
            }
        }
        MyLog.e("Cookie",App.Cookie);
        Request request = new Request.Builder().url(url).addHeader("Cookie",App.Cookie).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {
//                callback.onError(404,e.getMessage().toString());

//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //执行在主线程
//
//                    }
//                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code() == 200){

                    String jsonData = response.body().string();


                   //执行在子线程中
//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                        //执行在主线程
                    Log.e("获取到的数据++++++++++++",jsonData+"");
                        callback.onSuccess(getGeneric(jsonData,callback));
//                    }
//                  });
                }
            }
        });
    }


    @Override
    public <T> void postjson(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {


        Map map = new HashMap();
        map.put("json",params);


//        FormBody.Builder builder = new FormBody.Builder();

//        if(params !=null && params.size() > 0){

        Gson gson = new Gson();
        String jsonImgList = gson.toJson(params);
        Log.e("GSON",jsonImgList + "");



        MediaType parse = MediaType.parse("application/json; charset=UTF_8");
        RequestBody requestBody = RequestBody.create(parse,jsonImgList);

        Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

//                callback.onError(404,e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code() == 200){

                    final String jsonData = response.body().string();
                    Log.e("获取到的数据",jsonData+"");

                    //执行在子线程中
//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                    //执行在主线程
                    callback.onSuccess(getGeneric(jsonData,callback));
//                    }
//                  });
                }
            }
        });
    }





    @Override
    public <T> void postSC_File(String url, Map<String, Object> params, final MyNetWorkCallback<T> callback) {
        try {
            //补全请求地址
//            String requestUrl = String.format("%s/%s", upload_head, actionUrl);
            MultipartBody.Builder builder = new MultipartBody.Builder();
            //设置类型
            builder.setType(MultipartBody.FORM);
            //追加参数
            for (String key : params.keySet()) {
                Object object = params.get(key);
                if (!(object instanceof File)) {
                    builder.addFormDataPart(key, object.toString());
                } else {
                    File file = (File) object;
                    builder.addFormDataPart(key, file.getName(), RequestBody.create(null, file));
                }

                Log.e("略略略",params.toString());

            }
            //创建RequestBody
            RequestBody body = builder.build();
            //创建Request
            final Request request = new Request.Builder().url(url).post(body).build();
            //单独设置参数 比如读取超时时间
            final Call call = okHttpClient.newBuilder().writeTimeout(50, TimeUnit.SECONDS).build().newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
//                    Log.e("TAG", e.toString());
//                    failedCallBack("上传失败", callback);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                      if (response.code() == 200){

                    final String jsonData = response.body().string();
                    Log.e("获取到的数据",jsonData+"");

                    //执行在子线程中
//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                    //执行在主线程
                    callback.onSuccess(getGeneric(jsonData,callback));
//                    }
//                  });
                }
                }
            });
        } catch (Exception e) {
            Log.e("daskjdsasaldjsalkjkdasl", e.toString());
        }

    }

    @Override
    public <T> void getZlY(String url, TreeMap<String, Object> params, final MyNetWorkCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = String.valueOf(params.get(key));
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        MyLog.e("请求数据",params.toString());
        MyLog.e("DSAKJKSAUWWDNKAn",url);
        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                        //执行在主线程
                        callback.onError(404, e.getMessage().toString());
//
//
//
            }


            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.code()==200) {

                    final String jsonData = response.body().string();

                    Log.e("获取到的数据++++++++++++",jsonData+"");

//                    App.context.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
                            //执行在主线程
                            callback.onSuccess(getGeneric(jsonData, callback));
//                        }
//                    });
                }
            }
        });
    }




    @Override
    public <T> void postZlY(String url, TreeMap<String, Object> params, final MyNetWorkCallback<T> callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = String.valueOf(params.get(key));
                builder.add(key,value);
            }
        }
        Log.e("AAAAAAAAAAAAAAAAAAA",params.toString());
//

        Request request = new Request.Builder().url(url).post(builder.build()).build();


        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code() == 200){
                    final String jsonData = response.body().string();

                    //执行在子线程中
//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                    //执行在主线程
                    Log.e("获取到的数据++++++++++++",jsonData+"");
                    callback.onSuccess((T) JsonData(jsonData));
//                    }
//                  });
                }
            }
        });

    }

    @Override
    public <T> void postCSh(String url, TreeMap<String, Object> params, final MyNetWorkCallback<T> callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = String.valueOf(params.get(key));
                builder.add(key,value);
            }
        }
        Log.e("AAAAAAAAAAAAAAAAAAA",params.toString());
//

        Request request = new Request.Builder().url(url).post(builder.build()).build();


        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code() == 200){
                    final String jsonData = response.body().string();

                    //执行在子线程中
//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                    //执行在主线程
                    Log.e("获取到的数据++++++++++++",jsonData+"");
                    callback.onSuccess(getGeneric(jsonData,callback));
//                    }
//                  });
                }
            }
        });
    }

    private String JsonData(String json){
        return json;
    }


    @Override
    public <T> void post_ZlYYin(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {

        Log.e("sadjhgsadkjas",params.toString());
        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Log.e("AAAAAAAAAAAAAAAAAAA",params.toString());
//

        Request request = new Request.Builder().url(url).post(builder.build()).build();


        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, final IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.code() == 200){
                    final String jsonData = response.body().string();

                    //执行在子线程中
//                App.context.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                    //执行在主线程
                    Log.e("获取到的数据++++++++++++",jsonData+"");
                    callback.onSuccess(getGeneric(jsonData,callback));
//                    }
//                  });
                }
            }
        });

    }

        /**
         * 自动解析json至回调中的JavaBean
         * @param jsonData
         * @param callBack
         * @param <T>
         * @return
         */
    private <T> T getGeneric(String jsonData, MyNetWorkCallback<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);
        ACache aCache = ACache.get(App.activity);
        aCache.put(t.getClass().getSimpleName(), (Serializable) t);
        return t;
    }


}
