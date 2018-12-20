package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_xiali_Adapter;
import com.example.lenovo.ztsandroid.adapter.List_xiali_qu_Adapter;
import com.example.lenovo.ztsandroid.adapter.List_xiali_shi_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Diq_QieH_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Qu_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Shi_Bean;
import com.example.lenovo.ztsandroid.presenter.Diq_Presenter;
import com.example.lenovo.ztsandroid.presenter.Diq_qu_Presenter;
import com.example.lenovo.ztsandroid.presenter.Diq_shi_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.SSQ_Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/2.
 */
public class GM_E_Activity extends BaseActivity implements Diq_QieH_Cotract.View {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.NJ_Spinner)
    TextView NJSpinner;
    @BindView(R.id.NJ_popup)
    LinearLayout NJPopup;
    @BindView(R.id.Shenj_Dq_spinner)
    TextView ShenjDqSpinner;
    @BindView(R.id.Shen_popup)
    LinearLayout ShenPopup;
    @BindView(R.id.Sj_Dq_spinner)
    TextView SjDqSpinner;
    @BindView(R.id.Shi_popup)
    LinearLayout ShiPopup;
    @BindView(R.id.nj_spinner)
    TextView njSpinner;
    @BindView(R.id.Qu_Popup)
    LinearLayout QuPopup;
    @BindView(R.id.DF_NJ)
    TextView DFNJ;
    @BindView(R.id.Vip_Linear)
    LinearLayout VipLinear;


    private Diq_QieH_Cotract.Presenter presenter;
    private List_xiali_Adapter Gadapter;
    private List_xiali_shi_Adapter aadapter;
    private List_xiali_qu_Adapter badapter;
    private ListView listView;
    private PopupWindow popupWindow;
    private ArrayList<Diq_Bean.DataBean> shenglist = new ArrayList<>();
    private ArrayList<Diq_Shi_Bean.DataBean> shilist = new ArrayList<>();
    private ArrayList<Diq_Qu_Bean.DataBean> qulist = new ArrayList<>();
    private SSQ_Utils ssq_utils;
    private String shiID;
    private String quID;


    @Override
    protected int getLayoutId() {
        return R.layout.goumai_e_activity;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

        if (shenglist.isEmpty()) {
            presenter = new Diq_Presenter(this);
            presenter.start();
        }
        if (shiID != null) {

            presenter = new Diq_shi_Presenter(this);
            presenter.SetUrl(shiID);
        }
        if (quID != null) {

            presenter = new Diq_qu_Presenter(this);
            presenter.SetU(quID);
        }


    }

    public void upPopupWindowsheng(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupViewsheng(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupViewsheng(View v) {

        listView = v.findViewById(R.id.popup_listview);
        Gadapter = new List_xiali_Adapter(App.activity, shenglist);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShenjDqSpinner.setText(shenglist.get(position).getSheng_name());
                Log.e("点击传上去的数据", shenglist.get(position).getSheng_name());
                shiID = shenglist.get(position).getSheng_id();
                popupWindow.dismiss();
                Gadapter.notifyDataSetChanged();


            }
        });

    }


    public void upPopupWindowshi(View view) {

        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupViewshi(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupViewshi(View v) {

        listView = v.findViewById(R.id.popup_listview);

        aadapter = new List_xiali_shi_Adapter(App.activity, shilist);
        listView.setAdapter(aadapter);
        aadapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SjDqSpinner.setText(shilist.get(position).getShi_name());
                Log.e("点击传上去的数据", shilist.get(position).getShi_name());
                quID = shilist.get(position).getShi_id();

                MyLog.e("qqqqqqqqqq", quID);

                popupWindow.dismiss();
                aadapter.notifyDataSetChanged();
            }
        });

    }

    public void upPopupWindowqu(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupViewqu(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupViewqu(View v) {

        listView = v.findViewById(R.id.popup_listview);

        badapter = new List_xiali_qu_Adapter(App.activity, qulist);
        listView.setAdapter(badapter);
        badapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                njSpinner.setText(qulist.get(position).getQu_name());
                Log.e("点击传上去的数据", qulist.get(position).getQu_name());
                popupWindow.dismiss();
                badapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }


    @OnClick({R.id.back_jt, R.id.NJ_popup, R.id.Shen_popup, R.id.Shi_popup, R.id.Qu_Popup,R.id.Vip_Linear})
    public void onViewClicked(final View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.NJ_popup:
                MyLog.e("sdadsa", "sdasjdksaj");

//                    ssq_utils = new SSQ_Utils(nlist,NJSpinner);
//                    ssq_utils.upPopupWindow(view);


                break;
            case R.id.Shen_popup:

                upPopupWindowsheng(view);


                break;
            case R.id.Shi_popup:
                MyLog.e("asdsadas", shiID + "");
                if (shiID != null) {
                    if (shilist.isEmpty()) {
                        presenter = new Diq_shi_Presenter(this);
                        presenter.SetUrl(shiID);
                    }

                upPopupWindowshi(view);
                }
                break;
            case R.id.Qu_Popup:

                MyLog.e("asdsadas", quID + "");
                if (quID != null){


                if (qulist.isEmpty()) {
                    presenter = new Diq_qu_Presenter(this);
                    presenter.SetU(quID);
                }


                upPopupWindowqu(view);
                }
                break;

            case R.id.Vip_Linear:

                Intent intent = new Intent(this,E_Ka_X_Activity.class);
                startActivity(intent);


                break;
        }
    }

    @Override
    public void getManagerSheng(Diq_Bean diqBean) {
        shenglist.addAll(diqBean.getData());


    }

    @Override
    public void getManagershi(Diq_Shi_Bean diqBean) {
        shilist.addAll(diqBean.getData());

        MyLog.e("sakjsdkj", diqBean.getData().toString() + "");

    }

    @Override
    public void getManagerqu(Diq_Qu_Bean diqBean) {
        qulist.addAll(diqBean.getData());
        MyLog.e("sakjsdkj", diqBean.getData().toString() + "");
    }

    @Override
    public void getManager(Diq_Bean diqBean) {


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Diq_QieH_Cotract.Presenter presenter) {

    }

}
