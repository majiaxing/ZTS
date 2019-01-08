package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ZuoY_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.cotract.TiJao_Cotract;
import com.example.lenovo.ztsandroid.fragment.Read_fragment;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_D_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJiao_ZY_Bean;
import com.example.lenovo.ztsandroid.presenter.Read_TJ_Presenter;
import com.example.lenovo.ztsandroid.presenter.TiJao_Presenter;
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
public class ZuoY_Activity extends BaseActivity implements TiJao_Cotract.View ,View.OnClickListener {


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
    private TiJao_Cotract.Presenter presenter;


    private ZuoY_Adapter adapter;
    private Map<String, ArrayList<Spinner_Zuoy_Bean.DataBean>> map  = new HashMap<>();
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
                            mlist1.clear();
                                MyLog.e("输出————",typeList.length() + "");
                            for (int a = 0; a < typeList.length(); a++) {
                                JSONObject typeli = typeList.getJSONObject(a);
                                String hw_video1 = typeli.optString("hw_video");
                                String yb_bvideo = typeli.optString("yb_Bvideo");
                                int b= typeli.optInt("size");
                                mlist1.add(new Spinner_Zuoy_Bean.DataBean(yb_bvideo,hw_video1,b));
                            }
                            MyLog.e(" 获取到的typeList",typeList + "");
                            map.put("yb_typeList",mlist1);
                            list.add(new Spinner_Zuoy_Bean("音标"));
                            MyLog.e(" 保存到的数据",list.size() + "");
                            break;

                        case "1":
                            mlist2.clear();
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
                            mlist3.clear();
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
                            mlist4.clear();
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
                            mlist5.clear();
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
                            mlist6.clear();
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
                            mlist7.clear();
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
                            mlist8.clear();
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
    private PopupWindow popupWindow1 ,popupWindow2;
    private Button G_mai, E_ka;
    private TextView text;
    private LinearLayout fanH;


    private void showPopupWindow(View view ,String str) {
        View view1 = (LinearLayout) View.inflate(App.activity, R.layout.tijiao_popup, null);
        TextView ivP = (TextView) view1.findViewById(R.id.back_text);
        TextView ivX = (TextView) view1.findViewById(R.id.Qx_btn);
        TextView ivClose = (TextView) view1.findViewById(R.id.Qr_btn);
        LinearLayout FanH = (LinearLayout) view1.findViewById(R.id.Q_X);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ivP.setLayoutParams(params);
        ivX.setLayoutParams(params);
        ivClose.setLayoutParams(params);
        ivClose.setOnClickListener(this);
        popupWindow1 = new PopupWindow(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow1.setContentView(view1);
        popupWindow1.setFocusable(true);
        popupWindow1.setTouchable(true);
        popupWindow1.setOutsideTouchable(true);
        popupWindow1.showAsDropDown(view, 0, 0);
        backgroundAlpha(0.5f);
        view1= View.inflate(App.activity, R.layout.tijiao_popup, null);
        popupWindow2 = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        text = view1.findViewById(R.id.back_text);
        G_mai = view1.findViewById(R.id.Qx_btn);
        E_ka = view1.findViewById(R.id.Qr_btn);
        fanH = view1.findViewById(R.id.Q_X);
        text.setText(str);

        G_mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                backgroundAlpha(1f);
                popupWindow2.dismiss();
                popupWindow1.dismiss();
                backgroundAlpha(1f);
                MyLog.e("点击取消按钮", "haha");
            }
        });
        E_ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter = new TiJao_Presenter(ZuoY_Activity.this);
                presenter.SetUrl(App.stuid,hwid);
                popupWindow2.dismiss();
                popupWindow1.dismiss();
                backgroundAlpha(1f);
                MyLog.e("点击确定按钮", "lueluelue");
            }
        });
        fanH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow2.dismiss();
                popupWindow1.dismiss();
//                menBC.setVisibility(View.GONE);
                backgroundAlpha(1f);
                MyLog.e("点击返回按钮", "lalala");
            }
        });

        popupWindow2.setBackgroundDrawable(getResources().getDrawable(
                R.color.colorWhite));//设置背景
// 设置好参数之后再show
        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow2.setTouchable(true);
        popupWindow2.setFocusable(true);
        popupWindow2.setOutsideTouchable(true);
    }
    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp =App.activity.getWindow().getAttributes();
        lp.alpha = f;
        App.activity.getWindow().setAttributes(lp);

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

                showPopupWindow(view,"确认提交");

                break;
        }
    }

    @Override
    public void getManager(TiJiao_ZY_Bean xqBean) {

        if (xqBean.getData() == 0) {

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(App.activity, "提交成功", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
        }
    }
    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(TiJao_Cotract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {

    }
}
