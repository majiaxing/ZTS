package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.utils.ZF_PopupUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/31.
 */
public class Qrdd_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.DQ_nj)
    TextView DQNj;
    @BindView(R.id.SM_)
    TextView SM;
    @BindView(R.id.VIP_btn)
    Button VIPBtn;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.one_n)
    TextView oneN;
    @BindView(R.id.Fy_M_S)
    TextView FyMS;
    @BindView(R.id.One_N)
    LinearLayout OneN;
    @BindView(R.id.two_nian)
    TextView twoNian;
    @BindView(R.id.FyTX_M_o)
    TextView FyTXMO;
    @BindView(R.id.FyT_M_o)
    TextView FyTMO;
    @BindView(R.id.two_n)
    LinearLayout twoN;
    @BindView(R.id.three_n)
    TextView threeN;
    @BindView(R.id.FyTX_M_S)
    TextView FyTXMS;
    @BindView(R.id.FyT_M_S)
    TextView FyTMS;
    @BindView(R.id.Three_N)
    LinearLayout ThreeN;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.Banj_X)
    TextView BanjX;
    @BindView(R.id.QXZ_bj)
    TextView QXZBj;
    @BindView(R.id.Ban_JI)
    LinearLayout BanJI;
    @BindView(R.id.Nianj_X)
    TextView NianjX;
    @BindView(R.id.QXZ_nj)
    TextView QXZNj;
    @BindView(R.id.Nian_JI)
    LinearLayout NianJI;
    @BindView(R.id.C_btn)
    CheckBox CBtn;
    @BindView(R.id.T_Y)
    TextView TY;
    @BindView(R.id.G_mai_xy)
    TextView GMaiXy;
    @BindView(R.id.ZhiF_btn)
    Button ZhiFBtn;
    private String xx;
    private String bj, nj;

//    private SharedPreferences sp, sp1, sp2;
//    private SharedPreferences.Editor editor, editor1, editor2;

    @Override
    protected int getLayoutId() {
        return R.layout.qrdd_activity;
    }

    @Override
    protected void initView() {

//        sp = getSharedPreferences("sp", MODE_PRIVATE);
//        sp1 = getSharedPreferences("sp1", MODE_APPEND);
//        sp2 = getSharedPreferences("sp2", MODE_APPEND);
//        editor = sp.edit();
//        editor1 = sp1.edit();
//        editor2 = sp2.edit();
//        xx = sp.getString("学校", null);
//        Log.e("sp 中的数据", sp.getString("学校", null) + "");
//        if (xx != null) {
//            QXZXx.setText(xx);
//        } else {
//            Intent intent = getIntent();
//            xx = intent.getStringExtra("学校");
//            Log.e("获取到学校信息", xx + "");
//            if (xx != null) {
//                Log.e("获取到学校信息", xx);
//                QXZXx.setText(xx);
//                editor.putString("学校", xx);
//                //提交新值。必须执行，否则前面的操作都无效。
//                editor.commit();
//            }
//        }
//
//        bj = sp1.getString("年级", null);
//        Log.e("Sp中的数据222222222222222", sp1.getString("年级", null) + "");
//        if (bj != null) {
//            QXZBj.setText(bj);
//        } else {
//            Intent intent1 = getIntent();
//            bj = intent1.getStringExtra("年级");
//            Log.e("获取到年级信息", bj + "");
//            if (bj != null) {
//                Log.e("获取到年级信息", bj);
//                QXZBj.setText(bj);
//                editor1.putString("年级", bj);
//                //提交新值。必须执行，否则前面的操作都无效。
//                editor1.commit();
//            }
//        }
//
//        nj = sp2.getString("班级", null);
//        Log.e("Sp中的数据23333333333333332", sp2.getString("班级", null) + "");
//        if (nj != null) {
//            QXZNj.setText(nj);
//        } else {
//            Intent intent1 = getIntent();
//            nj = intent1.getStringExtra("班级");
//            Log.e("获取到班级信息", nj + "");
//            if (nj != null) {
//                Log.e("获取到班级信息", nj);
//                QXZNj.setText(nj);
//                editor2.putString("班级", nj);
//                //提交新值。必须执行，否则前面的操作都无效。
//                editor2.commit();
//            }
//        }

        FyTXMO.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        FyTXMS.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );

    }


//    final String orderInfo = info;   // 订单信息
//
//    Runnable payRunnable = new Runnable() {
//
//        @Override
//        public void run() {
//            PayTask alipay = new PayTask(DemoActivity.this);
//            String result = alipay.payV2(orderInfo,true);
//
//            Message msg = new Message();
//            msg.what = SDK_PAY_FLAG;
//            msg.obj = result;
//            mHandler.sendMessage(msg);
//        }
//    };
//    // 必须异步调用
//    Thread payThread = new Thread(payRunnable);
//    payThread.start();


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

    @OnClick({R.id.back_jt, R.id.VIP_btn, R.id.One_N, R.id.two_n, R.id.Three_N,R.id.ZhiF_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.VIP_btn:
                break;

            case R.id.One_N:

                break;
            case R.id.two_n:

                break;
            case R.id.Three_N:

                break;


            case R.id.ZhiF_btn:
                ZF_PopupUtils.PopupW(view, "请选择支付方式");
                ZF_PopupUtils.PopupDimiss();
                break;
        }
    }

}
