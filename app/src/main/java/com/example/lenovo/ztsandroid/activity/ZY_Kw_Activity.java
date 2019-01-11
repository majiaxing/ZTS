package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_ZuoY_Adapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.config.FragmantBuilder;
import com.example.lenovo.ztsandroid.cotract.TiJiao_ZY_Cotract;
import com.example.lenovo.ztsandroid.cotract.Zy_Xq_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.DC_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.DuanY_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.DuiH_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.Juz_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.Kw_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.TingL_TK_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.TingL_XZ_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.YB_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.YueD_ErJFragment;
import com.example.lenovo.ztsandroid.model.entity.DWj_SC_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJao_ZY_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Xq_Bean;
import com.example.lenovo.ztsandroid.presenter.DuoWJ_SC_Presenter;
import com.example.lenovo.ztsandroid.presenter.TiJao_ZY_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
 * Created by Administrator on 2018/11/24.
 */
public class ZY_Kw_Activity extends BaseActivity implements TiJiao_ZY_Cotract.View ,View.OnClickListener{
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.LeiXin)
    TextView LeiXin;
    @BindView(R.id.YeShu)
    TextView YeShu;
    @BindView(R.id.Zongyeshu)
    TextView Zongyeshu;
    @BindView(R.id.FrameLayout)
    FrameLayout FrameLayout;
    @BindView(R.id.LeiX)
    RelativeLayout LeiX;

    private ArrayList<Fragment> list = new ArrayList<>();
    private DC_ErJFragment erJFragment;
    private ViewPagerAdapter adapter;
    private Bundle bundle , bundle1,bundle2,bundle3,bundle4,bundle5,bundle6,bundle7;
    private String hwid;

    private ArrayList<Spinner_Bean> arrayList = new ArrayList<>();

    private PopupWindow popupWindow;
    private List_ZuoY_Adapter Gadapter;
    private ListView listView;

    private JSONArray data = null;
    private String hw_type;
    String value = null;
    private String listen_type;
    private YueD_ErJFragment yueDErJFragment = new YueD_ErJFragment();
    private String hw_content;

    private TiJiao_ZY_Cotract.Presenter presenter;
    private String typeList;
    private String save_path;



    @Override
    protected int getLayoutId() {
        return R.layout.zuoye_xq_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
//        String mtitle = intent.getStringExtra("title");
        hwid = intent.getStringExtra("hwid");
//        title.setText(mtitle);
//
        bundle = new Bundle();

    }

    @Override
    public void initData() {

    }
//    弹出弹窗 询问 师傅退出
    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupView(View v) {

        listView = v.findViewById(R.id.popup_listview);
        TextView textView = v.findViewById(R.id.Ti_J_ChaK);
        Gadapter = new List_ZuoY_Adapter(App.activity, arrayList);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();
        textView.setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LeiXin.setText(arrayList.get(position).getPersonName());

//                switch (arrayList.get(position).getPersonName()) {
//
//                    case "单词":
//                        FragmantBuilder.getInstance().start(DC_ErJFragment.class).setParams(bundle1);
//                        break;
//
//                    case "短语":
//                        FragmantBuilder.getInstance().start(DuanY_ErJFragment.class).setParams(bundle2);
//
//                        break;
//
//                    case "音标":
//                        FragmantBuilder.getInstance().start(YB_ErJFragment.class).setParams(bundle3);
//                        break;
//
//                    case "课文":
//
//                        FragmantBuilder.getInstance().start(Kw_ErJFragment.class).setParams(bundle4);
//
//                        break;
//
//                    case "句子":
//                        FragmantBuilder.getInstance().start(Juz_ErJFragment.class).setParams(bundle5);
//
//                        break;
//                    case "阅读":
//
//                        FragmantBuilder.getInstance().start(YueD_ErJFragment.class).setParams(bundle6);
//                        break;
//
//                    case "对话":
//                        FragmantBuilder.getInstance().start(DuiH_ErJFragment.class).setParams(bundle7);
//                        break;
//                }
//                popupWindow.dismiss();
//                Gadapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void loadData() {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                postParams();
//            }
//        }).start();
    }

//        网络请求
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
                .url("http://192.168.0.103:8080/demo/student/homework/findByHomeWorkDetail")
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

//    对数据解析
    private void JsonDemo(String string) {


        //第一步，string参数相当于一个JSON,依次解析下一步
//        JSONObject json = null;
//
//        try {
//            json = new JSONObject(string);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            data = json.getJSONArray("data");
////            for (int i = 0; i < data.length(); i++) {
//                    MyLog.e("打印" + i ,data.get(i).toString());
//                 value = data.getString(i);
//                typeList = data.getJSONObject(i).getString("typeList");
//                 hw_type = data.getJSONObject(i).getString("hw_type");
//                hw_content = data.getJSONObject(i).getString("hw_content");
//
//
//                switch (data.getJSONObject(1).getString("hw_type")) {
//                    case "2":
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        MyLog.e("准备穿过去的数据", data.getString(1));
//                        FragmantBuilder.getInstance().start(DC_ErJFragment.class).setParams(bundle);
//
//                        break;
//                    case "8":
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        FragmantBuilder.getInstance().start(DuanY_ErJFragment.class).setParams(bundle);
//
//                        break;
//
//                    case "0":
//                        YB_ErJFragment zyYinBFragment = new YB_ErJFragment();
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        FragmantBuilder.getInstance().start(YB_ErJFragment.class).setParams(bundle);
//
//                        break;
//
//                    case "1":
//                        Kw_ErJFragment zyKwFragment = new Kw_ErJFragment();
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        FragmantBuilder.getInstance().start(Kw_ErJFragment.class).setParams(bundle);
//
//                        break;
//
//                    case "3":
//                        Juz_ErJFragment zy_juZ_fragment = new Juz_ErJFragment();
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        FragmantBuilder.getInstance().start(Juz_ErJFragment.class).setParams(bundle);
//
//                        break;
//
//                    case "6":
//                        YueD_ErJFragment zyYueDuFragment = new YueD_ErJFragment();
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        FragmantBuilder.getInstance().start(YueD_ErJFragment.class).setParams(bundle);
//
//                        break;
//
//                    case "4":
//                        DuiH_ErJFragment zyDuiHFragment = new DuiH_ErJFragment();
//                        bundle = new Bundle();
//                        bundle.putString("data", data.getString(1));
//                        bundle.putString("hw_type",data.getJSONObject(1).getString("hw_type"));
//                        bundle.putString("hw_content",data.getJSONObject(1).getString("hw_content"));
//                        FragmantBuilder.getInstance().start(DuiH_ErJFragment.class).setParams(bundle);
//                        break;
//                }
//
//
//
//                switch (hw_type) {
//                    case "2":
//                        bundle1 = new Bundle();
//                        bundle1.putString("data", value);
//                        bundle1.putString("hw_type",hw_type);
//                        bundle1.putString("hw_content",hw_content);
//                        MyLog.e("准备穿过去的数据", value);
//
//
//                        break;
//
//                    case "8":
//                        DuanY_ErJFragment zyDuanYFragment = new DuanY_ErJFragment();
//                        bundle2 = new Bundle();
//                        bundle2.putString("data", value);
//                        bundle2.putString("hw_type",hw_type);
//                        bundle2.putString("hw_content",hw_content);
//
//
//                        break;
//
//                    case "0":
//                        YB_ErJFragment zyYinBFragment = new YB_ErJFragment();
//                        bundle3 = new Bundle();
//                        bundle3.putString("data", value);
//                        bundle3.putString("hw_type",hw_type);
//                        bundle3.putString("hw_content",hw_content);
//
//
//                        break;
//
//                    case "1":
//                        Kw_ErJFragment zyKwFragment = new Kw_ErJFragment();
//                        bundle4 = new Bundle();
//                        bundle4.putString("data", value);
//                        bundle4.putString("hw_type",hw_type);
//                        bundle4.putString("hw_content",hw_content);
//
//
//                        break;
//
//                    case "3":
//                        Juz_ErJFragment zy_juZ_fragment = new Juz_ErJFragment();
//                        bundle5 = new Bundle();
//                        bundle5.putString("data", value);
//                        bundle5.putString("hw_type",hw_type);
//                        bundle5.putString("hw_content",hw_content);
//
//                        break;
//                    case "5":
////                            Zy_TingL_XZ_Fragment zyTingLXzFragment = new Zy_TingL_XZ_Fragment();
////                            bundle = new Bundle();
////                            bundle.putString("data",data.get(i).toString());
////                            FragmantBuilder.getInstance().start(Zy_TingL_XZ_Fragment.class).setParams(bundle);
//
//                        break;
//
//                    case "听力填空":
////                            Zy_TingL_TK_Fragment zyTingLTkFragment = new Zy_TingL_TK_Fragment();
////                            bundle = new Bundle();
////                            bundle.putString("data",data.get(i).toString());
////                            FragmantBuilder.getInstance().start(Zy_TingL_TK_Fragment.class).setParams(bundle);
//                        break;
//
//                    case "6":
//                        YueD_ErJFragment zyYueDuFragment = new YueD_ErJFragment();
//                        bundle6 = new Bundle();
//                        bundle6.putString("data", value);
//                        bundle6.putString("hw_type",hw_type);
//                        bundle6.putString("hw_content",hw_content);
//
//
//                        break;
//
//                    case "4":
//                        DuiH_ErJFragment zyDuiHFragment = new DuiH_ErJFragment();
//                        bundle7 = new Bundle();
//                        bundle7.putString("data", value);
//                        bundle7.putString("hw_type",hw_type);
//                        bundle7.putString("hw_content",hw_content);
//                        break;
//                }
//
//                switch (data.getJSONObject(i).getString("hw_type")){
//                    case "2":
//                        arrayList.add(new Spinner_Bean("单词"));
//                        break;
//                    case "8":
//                        arrayList.add(new Spinner_Bean("短语"));
//                        break;
//                    case "0":
//                        arrayList.add(new Spinner_Bean("音标"));
//                        break;
//                    case "1":
//                        arrayList.add(new Spinner_Bean("课文"));
//                        break;
//                    case "3":
//                        arrayList.add(new Spinner_Bean("句子"));
//                        break;
//                    case "6":
//                        arrayList.add(new Spinner_Bean("阅读"));
//                        break;
//                    case "4":
//                        arrayList.add(new Spinner_Bean("对话"));
//                        break;
//                }
//            }
//
//
//
//
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_jt, R.id.LeiX})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.LeiX:

                upPopupWindow(view);

                break;
        }
    }

    @Override
    public void getManager(TiJao_ZY_Bean xqbean) {


        MyLog.e("获取到路经 +++",xqbean.getData().getSave_path()+"");
        save_path = xqbean.getData().getSave_path();


        for (int i = 0;i<App.fileArrayList.size();i++){
            presenter = new DuoWJ_SC_Presenter(this);
            presenter.SetUrl(App.fileArrayList.get(i),"2",save_path);
        }
    }

    @Override
    public void getD_ShangC(DWj_SC_Bean sc_bean) {

        MyLog.e("上传文件的状态",sc_bean.getMessage());



    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(TiJiao_ZY_Cotract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Ti_J_ChaK:
                yueDErJFragment.OnShow(true);
                popupWindow.dismiss();
                presenter = new TiJao_ZY_Presenter(this);
                presenter.SetU(App.stuid,hwid,App.mlist);
                break;
        }
    }
}
