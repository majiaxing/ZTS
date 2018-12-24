package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.XX_Adapter;
import com.example.lenovo.ztsandroid.adapter.XX_FragmentAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.fragment.QuanB_XX_Fragment;
import com.example.lenovo.ztsandroid.fragment.WeiD_XX_Fragment;
import com.example.lenovo.ztsandroid.model.entity.XX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.presenter.XiaoX_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/2.
 */
public class XX_Activity extends BaseActivity implements XX_Cotract.View {

    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.QBYD)
    TextView QBYD;
    @BindView(R.id.DuquXiaox_tab)
    TabLayout DuquXiaoxTab;
    @BindView(R.id.DuquXiaox_pager)
    ViewPager DuquXiaoxPager;
    @BindView(R.id.linearLayout_Duquxiaox)
    LinearLayout linearLayoutDuquxiaox;
    @BindView(R.id.linearLayout_Kxx)
    LinearLayout linearLayoutKxx;
    @BindView(R.id.Quanx)
    CheckBox Quanx;
    @BindView(R.id.BiaoW_Yd)
    Button BiaoWYd;
    @BindView(R.id.BiaoW_Sc)
    Button BiaoWSc;
    @BindView(R.id.ZT_LinearLayout)
    LinearLayout ZTLinearLayout;

    private XX_Adapter myadapter;
    private ArrayList<XX_Bean> list = new ArrayList<>();
    private PopupWindow popupWindow;
    private TextView quxiao, queding;
    private ImageView fanH;
    private List<Fragment> fragments = new ArrayList<>();
    private XX_FragmentAdapter adapter;
    private Bundle bundle;
    private XX_Cotract.Presenter presenter;
    private ArrayList<XiaoX_Bean.DataBean> list1;
    private QuanB_XX_Fragment fragment1  = new QuanB_XX_Fragment();
    private WeiD_XX_Fragment fragment2 = new WeiD_XX_Fragment();
    private Boolean isShow = false;
    @Override
    protected int getLayoutId() {
        return R.layout.xx_activity;
    }

    @Override
    protected void initView() {
        linearLayoutKxx.setVisibility(View.GONE);
        ZTLinearLayout.setVisibility(View.GONE);


    }


       public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }


    }


    @Override
    public void initData() {
        presenter = new XiaoX_Presenter(this);
        String s = String.valueOf(App.stuid);
        presenter.SetUrl(s,"1","10");
    }

    @Override
    public void loadData() {
    }

    public void PopupW(View view) {

        final View inflate = View.inflate(App.activity, R.layout.bwyd_popup, null);
        popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        quxiao = inflate.findViewById(R.id.qx_btn);
        queding = inflate.findViewById(R.id.qd_btn);
        fanH = inflate.findViewById(R.id.Q_X);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.textView = (TextView) findViewById(R.id.Wd_Ts);
                App.textView.setVisibility(View.GONE);
                myadapter.notifyDataSetChanged();
                popupWindow.dismiss();
                backgroundAlpha(1f);

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
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
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

    public void PopupDimiss() {
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(App.activity,Mian_Activity.class);
        startActivity(intent);
        finish();
        Log.i("LOG_TAG", "onBackPressed");
    }

    boolean bool = false;
    @OnClick({R.id.back_jt, R.id.QBYD, R.id.Quanx, R.id.BiaoW_Yd, R.id.BiaoW_Sc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                Intent intent = new Intent(App.activity,Mian_Activity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.QBYD:
                if (bool){
                    ZTLinearLayout.setVisibility(View.GONE);
                    bool = false;
                    QBYD.setText("编辑");
                 }else {
                    QBYD.setText("取消");
                    ZTLinearLayout.setVisibility(View.VISIBLE);
                    bool = true;

                }
                if (isShow)
                    isShow = false;
                else
                    isShow = true;
                fragment1.isShow(isShow);

                break;
            case R.id.Quanx:

                fragment1.onShow(true);



                //根据不同的情况对maincheckbox做处理
//                if (!b && !mMainCkb.isChecked()) {
//                    return;
//                } else if (!b && mMainCkb.isChecked()) {
//                    mIsFromItem = true;
//                    mMainCkb.setChecked(false);
//                } else if (b) {
//                    mIsFromItem = true;
//                    mMainCkb.setChecked(true);
//                }
                break;
            case R.id.BiaoW_Yd:
                break;
            case R.id.BiaoW_Sc:
                break;
        }
    }

    @Override
    public void getManager(final XiaoX_Bean xiaoX_bean) {




        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (xiaoX_bean.getData().size() == 0) {
                    linearLayoutKxx.setVisibility(View.VISIBLE);
                    QBYD.setVisibility(View.INVISIBLE);
                    return;
                } else {
                    list1 = new ArrayList();
                    list1.addAll(xiaoX_bean.getData());
                    bundle = new Bundle();
                    bundle.putSerializable("list", list1);
//                MyLog.e("准备传过去的数据",list1.get(0).getNewtype() + "");

                    fragment1.setParams(bundle);
                    fragment2.setParams(bundle);

                    fragments.add(fragment1);
                    fragments.add(fragment2);


                    adapter = new XX_FragmentAdapter(getSupportFragmentManager(), fragments);
                    DuquXiaoxPager.setAdapter(adapter);
                    DuquXiaoxTab.setupWithViewPager(DuquXiaoxPager);

                    DuquXiaoxTab.post(new Runnable() {
                        @Override
                        public void run() {
                            setIndicator(DuquXiaoxTab, 60, 60);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void showmessage(String str) {



    }

    @Override
    public void setBasePresenter(XX_Cotract.Presenter presenter) {

    }

}
