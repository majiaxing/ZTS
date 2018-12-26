package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ZuoY_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.model.entity.Spinner_D_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.view.MyListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/12/9.
 */
public class ZuoY_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.QB_T)
    TextView QBT;
    @BindView(R.id.WC_T)
    TextView WCT;
    @BindView(R.id.WZ_T)
    TextView WZT;
    @BindView(R.id.ZuoY_LX)
    ListView ZuoYLX;
    @BindView(R.id.Ti_J_ChaK)
    TextView TiJChaK;
    private String hwid;

    private ArrayList<Spinner_Zuoy_Bean> list = new ArrayList<>();

    private ZuoY_Adapter adapter;
    private Map<String, ArrayList<Spinner_Zuoy_Bean.DataBean>> map  = new HashMap<>();;
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist1 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist2 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist3 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist4 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist5 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist6 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist7 = new ArrayList<>();
    private ArrayList<Spinner_Zuoy_Bean.DataBean> mlist8 = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.zuoye_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        hwid = intent.getStringExtra("hwid");



        new Thread(new Runnable() {
            @Override
            public void run() {
                postParams();
            }
        }).start();

    }

    private void postParams() {
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //构建一个请求体 add参数1 key 参数2 value 发送字段
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("hwid", hwid)
                .add("flag", "1")
                .add("stuid", App.stuid)
                .build();
        //构建一个请求对象
        Request request = new Request.Builder()
                .url(Urls.BASE + "homework/findDetail")
                .post(builder.build())
                .build();

        //发送请求获取响应
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if (response.isSuccessful()) {
                //打印服务端返回结果
                String sss = response.body().string();


                JsonDemo(sss);
                Log.e("asdbjksaiwqoe", sss);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void JsonDemo(String string) {


//        第一步，string参数相当于一个JSON,依次解析下一步
        JSONObject json = null;

        try {
            json = new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject data = json.getJSONObject("data");
            JSONArray type = data.getJSONArray("type");
            for (int i = 0; i < type.length(); i++) {
                JSONObject value = type.getJSONObject(i);
                String hw_type = value.optString("hw_type");
                JSONArray typeList = value.optJSONArray("typeList");
                MyLog.e(" 获取到的hw_type",hw_type + "");
                    switch (hw_type) {
                        case "0":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video1 = typeli.optString("hw_video");
                                String yb_bvideo = typeli.optString("yb_Bvideo");
                                int b= a+1;
                                mlist1.add(new Spinner_Zuoy_Bean.DataBean(yb_bvideo,hw_video1,b));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("yb_typeList",mlist1);
                            list.add(new Spinner_Zuoy_Bean("音标"));
                            MyLog.e(" 保存到的数据",list.size() + "");
                            break;
                        case "1":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video2 = typeli.optString("hw_video");
                                String requrie_video2 = typeli.optString("requrie_video");
                                int size = typeli.optInt("size");
                                mlist2.add(new Spinner_Zuoy_Bean.DataBean(requrie_video2,hw_video2,size));
                                MyLog.e(" 获取到的数据",requrie_video2 + "");
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("kw_typeList",mlist2);
                            list.add(new Spinner_Zuoy_Bean("课文"));
                            break;
                        case "2":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video3 = typeli.optString("hw_video");
                                String requrie_video3 = typeli.optString("requrie_video");
                                int size = typeli.optInt("size");
                                mlist3.add(new Spinner_Zuoy_Bean.DataBean(requrie_video3,hw_video3,size));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("dc_typeList",mlist3);
                            list.add(new Spinner_Zuoy_Bean("单词"));

                            break;
                        case "3":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video4 = typeli.optString("hw_video");
                                String requrie_video4 = typeli.optString("requrie_video");
                                int size = typeli.optInt("size");
                                mlist4.add(new Spinner_Zuoy_Bean.DataBean(requrie_video4,hw_video4,size));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("jz_typeList",mlist4);
                            list.add(new Spinner_Zuoy_Bean("句子"));
                            break;
                        case "4":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video5 = typeli.optString("hw_video");
                                String requrie_video5 = typeli.optString("requrie_video");
                                int size = typeli.optInt("size");
                                mlist5.add(new Spinner_Zuoy_Bean.DataBean(requrie_video5,hw_video5,size));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("dh_typeList",mlist5);
                            list.add(new Spinner_Zuoy_Bean("对话"));
                            break;
                        case "5":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video6 = typeli.optString("hw_video");
                                String requrie_video6 = typeli.optString("requrie_video");
                                int size = typeli.optInt("size");
                                mlist6.add(new Spinner_Zuoy_Bean.DataBean(requrie_video6,hw_video6,size));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("tl_typeList",mlist6);
                            list.add(new Spinner_Zuoy_Bean("听力"));
                            break;
                        case "6":
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video7 = typeli.optString("hw_video");
                                String requrie_video7 = typeli.optString("requrie_video");
                                int size = typeli.optInt("size");
                                mlist7.add(new Spinner_Zuoy_Bean.DataBean(requrie_video7,hw_video7,size));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("yd_typeList",mlist7);
                            list.add(new Spinner_Zuoy_Bean("阅读"));
                            break;
                        case "8":
                            for (int a = 0; a < typeList.length(); a++) {
                            JSONObject typeli = typeList.getJSONObject(a);
                            String hw_video8 = typeli.optString("hw_video");
                            String requrie_video8 = typeli.optString("requrie_video");
                            int size = typeli.optInt("size");
                            mlist8.add(new Spinner_Zuoy_Bean.DataBean(requrie_video8,hw_video8,size));
                        }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("dy_typeList",mlist8);
                            list.add(new Spinner_Zuoy_Bean("短语"));
                            break;
                    }
                }

            MyLog.e("LALLALALA",map.size() + "");
            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new ZuoY_Adapter(App.activity,list,map);
                    ZuoYLX.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_jt, R.id.Ti_J_ChaK})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.Ti_J_ChaK:



                break;
        }
    }


}
