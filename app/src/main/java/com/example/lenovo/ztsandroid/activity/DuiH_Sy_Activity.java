package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.DuiH_XQ_Cotract;
import com.example.lenovo.ztsandroid.fragment.DuiH_Fragment;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.presenter.DuiH_XQ_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/7.
 */

public class DuiH_Sy_Activity extends BaseActivity implements DuiH_XQ_Cotract.View {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private String title1;
    private String talk_id;
    private DuiH_XQ_Cotract.Presenter presenter;
    private Bundle bundle;
    private DuiH_Fragment fragment;
    private String save_path;
    private ArrayList<String> videolist = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.duih_sy_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        title1 = intent.getStringExtra("title");
        talk_id = intent.getStringExtra("talk_id");
        save_path = intent.getStringExtra("relative_path");

        MyLog.e("传过来的save_path",save_path + "");


        title.setText("对话");

    }

    @Override
    public void initData() {

    }

    public static PopupWindow popupWindow;
    public static Button G_mai, E_ka;
    public static TextView text;
    public static LinearLayout FanH;

    public static void PopupW(View view, String str) {

        final View inflate = View.inflate(App.activity, R.layout.back_popup, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        text = inflate.findViewById(R.id.back_text);
        G_mai = inflate.findViewById(R.id.Qx_btn);
        E_ka = inflate.findViewById(R.id.Qr_btn);
        FanH = inflate.findViewById(R.id.Q_X);
        text.setText(str);
        G_mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                backgroundAlpha(1);
            }
        });
        E_ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                App.activity.onBackPressed();
            }
        });
        FanH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                backgroundAlpha(1);
            }
        });
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        backgroundAlpha(0.5f);
        popupWindow.showAsDropDown(inflate, 100, 100);


    }

    public static void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = App.activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        App.activity.getWindow().setAttributes(lp);
        App.activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public static void PopupDimiss() {
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
    }

    @Override
    public void loadData() {

        presenter = new DuiH_XQ_Presenter(this);
        presenter.SetUrl(talk_id);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    private Boolean isJS =false;

    @OnClick({R.id.back_jt, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                PopupW(view, "确认退出对话学习，退出后将保存进度");
                PopupDimiss();
                break;
            case R.id.title:
                break;
        }
    }

    @Override
    public void getManager(final DuiH_XQ_Bean duiHXqBean) {

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < duiHXqBean.getData().size(); i++) {
                    fragment = new DuiH_Fragment();
                    bundle = new Bundle();

                    if (isJS){

                        duiHXqBean.getData().get(i).setJS(isJS);
                        isJS =false;
                    }else {
                        duiHXqBean.getData().get(i).setJS(isJS);
                        isJS =true;

                    }
                    bundle.putSerializable("list", (Serializable) duiHXqBean.getData());
                    bundle.putString("word_id", duiHXqBean.getData().get(i).getJuese_id());
                    bundle.putString("type", talk_id);

                    bundle.putString("Relative_path",save_path);

                    bundle.putString("title",title1);

                    videolist.add(duiHXqBean.getData().get(i).getJuese_video());

                    bundle.putSerializable("Juese_videoList",videolist);

                    MyLog.e("listview 数据", duiHXqBean.getData().toString() + "");
                }
                fragment.setParams(bundle);
                list.add(fragment);
                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
                danciViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(DuiH_XQ_Cotract.Presenter presenter) {

    }
}
