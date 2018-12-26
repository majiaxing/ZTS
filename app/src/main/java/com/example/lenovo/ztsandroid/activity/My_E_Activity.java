package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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
import com.example.lenovo.ztsandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/31.
 */
public class My_E_Activity extends BaseActivity {


    @BindView(R.id.back_ka)
    ImageView backKa;
    @BindView(R.id.S_Y_bq)
    Button SYBq;
    @BindView(R.id.df_nj)
    TextView dfNj;
    @BindView(R.id.Zt_text)
    TextView ZtText;
    @BindView(R.id.Jr_bj)
    TextView JrBj;
    @BindView(R.id.E_ka_sy)
    LinearLayout EKaSy;
    private PopupWindow popupWindow;
    private Button G_mai, E_ka;
    private ImageView fanH;

    @Override
    protected int getLayoutId() {

        return R.layout.my_e_ka;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("school");
        String classId = intent.getStringExtra("classId");
        String memberState = intent.getStringExtra("memberState");
        String starttime = intent.getStringExtra("starttime");
        String endtime = intent.getStringExtra("endtime");

        final String kai = starttime.substring(0, 9);
        final String jie = endtime.substring(0,9);

        switch (memberState){
            case "1":
                ZtText.setText("有效期："+kai+"至"+jie);
                JrBj.setText(classId);
                break;
            case "0":
                ZtText.setText("免费体验");
                JrBj.setText("未加入班级");
                break;
        }


    }

    @Override
    public void loadData() {

    }

    private void PopupW(View view) {

        final View inflate = View.inflate(App.activity, R.layout.t_jia_e_ka, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        G_mai = inflate.findViewById(R.id._mai);
        E_ka = inflate.findViewById(R.id._KA);
        fanH = inflate.findViewById(R.id.Q_X);
        G_mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(App.activity, GM_E_Activity.class);
                startActivity(intent);
            }
        });
        E_ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fanH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        backgroundAlpha(0.5f);
        popupWindow.showAsDropDown(inflate, 100, 100);
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = App.activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        App.activity.getWindow().setAttributes(lp);
        App.activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void PopupDimiss() {
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_ka)
    public void onViewClicked() {

        App.activity.onBackPressed();
    }
}
