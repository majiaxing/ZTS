package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Kw_sy_Adapter;
import com.example.lenovo.ztsandroid.adapter.LunBotuAdapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Kw_Xq_Cotract;
import com.example.lenovo.ztsandroid.fragment.KeW_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.presenter.Kw_xq_Presenter;
import com.example.lenovo.ztsandroid.utils.ConfigFragment;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.SetViewPagerListener;
import com.example.lenovo.ztsandroid.utils.Xuanz_NR_Utils;
import com.example.lenovo.ztsandroid.utils.YinY_Utils;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/7.
 */

public class Kew_Sy_Activity extends BaseActivity implements Kw_Xq_Cotract.View{


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private KeW_Fragment keW_fragment;
    private Kw_Xq_Cotract.Presenter presenter;
    private String text_id;
    private Bundle bundle;
    private String type;
    private String relative_path;

    @Override
    protected int getLayoutId() {
        return R.layout.juz_sy_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        text_id = intent.getStringExtra("text_id");
        String mtitle = intent.getStringExtra("title");
        type = intent.getStringExtra("type");
//        title.setText(mtitle);
        relative_path = intent.getStringExtra("relative_path");

    }

    @Override
    public void initData() {

    }

    public static PopupWindow popupWindow;
    public static Button G_mai, E_ka;
    public static TextView text;
    public static LinearLayout fanH;


    public static void PopupW(View view, String str) {


        final View inflate = View.inflate(App.activity, R.layout.back_popup, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        fanH= inflate.findViewById(R.id.Q_X);
        text = inflate.findViewById(R.id.back_text);
        G_mai = inflate.findViewById(R.id.Qx_btn);
        E_ka = inflate.findViewById(R.id.Qr_btn);
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
        fanH.setOnClickListener(new View.OnClickListener() {
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
        presenter = new Kw_xq_Presenter(this);
        presenter.SetU(text_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.title, R.id.back_jt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title:
//                Xuanz_NR_Utils.upPopupWindow(view,title);
                break;
            case R.id.back_jt:
                PopupW(view, "确认退出课文朗读？退出后将保存进度");
                PopupDimiss();
                break;
        }
    }
    @Override
    public void getManager(final Kw_Xq_Bean xq_bean) {

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < xq_bean.getData().size(); i++) {

                    keW_fragment = new KeW_Fragment();
                    bundle = new Bundle();
//                    bundle.putSerializable("list", (Serializable) xq_bean.getData());
//                    MyLog.e("准备传过去的数据",xq_bean.getData() + "");

                    bundle.putString("nr",xq_bean.getData().get(i).getText_yw());
                    bundle.putString("fy",xq_bean.getData().get(i).getText_zw());

                    bundle.putString("word_id",text_id);
                    bundle.putString("type",type);

                    bundle.putString("word_video", xq_bean.getData().get(i).getText_video());
                    bundle.putString("type",text_id );
                    bundle.putString("relative_path",relative_path);

                    keW_fragment.setParams(bundle);
                    list.add(keW_fragment);
                }

                adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
                danciViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Kw_Xq_Cotract.Presenter presenter) {

    }
}
