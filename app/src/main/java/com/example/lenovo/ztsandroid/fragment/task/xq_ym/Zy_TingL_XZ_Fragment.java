package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Read_zy_O_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_TingL_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/27.
 */
public class Zy_TingL_XZ_Fragment extends BaseFragment {


    @BindView(R.id.BF_zt)
    CheckBox BFZt;
    @BindView(R.id.TJ_Xyt)
    Button TJXyt;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.next_T)
    Button nextT;
    @BindView(R.id.TM_title)
    TextView TMTitle;
    @BindView(R.id.Xuanz_btn_A)
    CheckBox XuanzBtnA;
    @BindView(R.id.Xuanz_nr_A)
    TextView XuanzNrA;
    @BindView(R.id.Xuanz_btn_B)
    CheckBox XuanzBtnB;
    @BindView(R.id.Xuanz_nr_B)
    TextView XuanzNrB;
    @BindView(R.id.Xuanz_btn_C)
    CheckBox XuanzBtnC;
    @BindView(R.id.Xuanz_nr_C)
    TextView XuanzNrC;
    @BindView(R.id.linear_layout_xz)
    android.widget.LinearLayout linearLayoutXz;
    @BindView(R.id.JX_)
    TextView JX;
    @BindView(R.id.JX_list)
    ListView JXList;
    @BindView(R.id.LinearLayout)
    android.widget.LinearLayout LinearLayout;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.Item_Tm)
    TextView ItemTm;
    private Bundle bundle;
    private Read_zy_O_Adapter listadapter;
    private ArrayList<Spinner_TingL_Bean> list = new ArrayList<>();
    private String read_option;
    private String read_optionText;
    private Boolean isShow = true;

    @Override
    protected int getLayoutId() {
        return R.layout.zy_tingl_xz_fragment;
    }

    @Override
    protected void init(View view) {



        String kWy = bundle.getString("KWy");


        MyLog.e("@_@!!!!!!!!!!!", kWy + "");

        TMTitle.setText(kWy);

//
        String daan = bundle.getString("Daan");


        String read_optionA = bundle.getString("read_optionA");
        String read_optionB = bundle.getString("read_optionB");
        String read_optionC = bundle.getString("read_optionC");
        String read_optionTextA = bundle.getString("read_optionTextA");
        String read_optionTextB = bundle.getString("read_optionTextB");
        String read_optionTextC = bundle.getString("read_optionTextC");

        XuanzNrA.setText(read_optionA + ". "+read_optionTextA);
        XuanzNrB.setText(read_optionB + ". "+read_optionTextB);
        XuanzNrC.setText(read_optionC + ". "+read_optionTextC);


    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.BF_zt, R.id.TJ_Xyt, R.id.next_T, R.id.Xuanz_btn_A, R.id.Xuanz_btn_B, R.id.Xuanz_btn_C, R.id.Xuanz_btn_D})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BF_zt:

                App.activity.onBackPressed();

                break;
            case R.id.TJ_Xyt:
                break;
            case R.id.next_T:
                break;
            case R.id.Xuanz_btn_A:
                break;
            case R.id.Xuanz_btn_B:
                break;
            case R.id.Xuanz_btn_C:
                break;
            case R.id.Xuanz_btn_D:
                break;
        }
    }
}
