package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.adapter.List_XX_Adapter;
import com.example.lenovo.ztsandroid.adapter.Zm_zh_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.presenter.YinB_Xq_Presenter;
import com.example.lenovo.ztsandroid.view.MyGridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YB_four_fragment extends BaseFragment implements YB_XiangQ_Cotract.View{

    @BindView(R.id.Grid_ZM_he)
    MyGridView GridZMHe;
    @BindView(R.id.TZ_YX_o)
    Button TZYXO;
    Unbinder unbinder;
    private Zm_zh_Adapter myadapter;
    private ArrayList<YB_XQ_four_Bean.DataBean> list = new ArrayList<>();
    private Bundle bundle;
    private String yBid;
    private YB_XiangQ_Cotract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_four_fragment;
    }

    @Override
    protected void init(View view) {

        yBid = bundle.getString("YBid");




    }

    @Override
    protected void loadData() {
    presenter = new YinB_Xq_Presenter(this);
        presenter.SetUrl(yBid,"4","");
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

    @OnClick(R.id.TZ_YX_o)
    public void onViewClicked() {

        Intent intent = new Intent(App.activity,TiaoZan_Activity.class);
        intent.putExtra("YB_id",yBid);
        startActivity(intent);


    }

    @Override
    public void getManager(YB_XQ_four_Bean yb_bean) {

        list.addAll(yb_bean.getData());


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                myadapter = new Zm_zh_Adapter(App.activity,list);
                GridZMHe.setAdapter(myadapter);
                myadapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void getManagerO(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerR(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTh(YB_XQ_three_Bean postYinB_XQ_three) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(YB_XiangQ_Cotract.Presenter presenter) {

    }
}
