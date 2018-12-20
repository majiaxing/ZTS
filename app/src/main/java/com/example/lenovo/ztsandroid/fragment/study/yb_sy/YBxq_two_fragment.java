package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.presenter.YB_Two_XQ_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YBxq_two_fragment extends BaseFragment implements YB_XiangQ_Cotract.View ,View.OnClickListener{


    CheckBox RDH;
    CheckBox RZR;
    LinearLayout XZFy;
    Button TZYXT;
    TextView YB_Nr;
    private YB_XiangQ_Cotract.Presenter presenter;
    private Bundle bundle;
    private String yBid;

    @Override
    protected int getLayoutId() {
        return R.layout.tb_xq_two_fragment;
    }

    @Override
    protected void init(View view) {

        RDH = view.findViewById(R.id.R_D_H);
        RZR = view .findViewById(R.id.R_Z_R);
        XZFy = view.findViewById(R.id.XZ_fy);
        TZYXT = view.findViewById(R.id.TZ_YX_t);
        YB_Nr = view.findViewById(R.id.YB_Nr);

        RDH.setOnClickListener(this);
        RZR.setOnClickListener(this);
        TZYXT.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

        yBid = bundle.getString("YBid");
        presenter = new YB_Two_XQ_Presenter(this);
        presenter.SetUrl(yBid,"2","");

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void getManager(YB_XQ_four_Bean yb_bean) {


    }

    @Override
    public void getManagerO(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {
        final String yb_translate = yb_xq_two_bean.getData().get(0).getYb_translate();

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                YB_Nr.setText(yb_translate);
            }
        });

    }

    @Override
    public void getManagerR(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTh(YB_XQ_three_Bean yb_xq_th_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(YB_XiangQ_Cotract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.R_D_H:

                    RDH.setChecked(true);
                    RZR.setChecked(false);

                break;
            case R.id.R_Z_R:

                RDH.setChecked(false);
                RZR.setChecked(true);
                break;
            case R.id.TZ_YX_t:
                Intent intent = new Intent(App.activity,TiaoZan_Activity.class);
                intent.putExtra("YB_id",yBid);
                startActivity(intent);
                break;
        }
    }
}
