package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.XX_Adapter;
import com.example.lenovo.ztsandroid.adapter.XX_wd_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.model.entity.XX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.presenter.XiaoX_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/15.
 */
public class WeiD_XX_Fragment extends BaseFragment{


    @BindView(R.id.WeiD_XX)
    ListView WeiDXX;
    Unbinder unbinder;
    private XX_wd_Adapter myadapter;
    private ArrayList<XiaoX_Bean.DataBean> list = new ArrayList<>();
    private Bundle bundle;
    @Override
    protected int getLayoutId() {
        return R.layout.weidu_xx_fragment;
    }

    @Override
    protected void init(View view) {

        myadapter = new XX_wd_Adapter(App.activity,list);
        WeiDXX.setAdapter(myadapter);
        WeiDXX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void loadData() {

        ArrayList<XiaoX_Bean.DataBean> groups = (ArrayList<XiaoX_Bean.DataBean>) bundle.getSerializable("list");

        MyLog.e("传过来的数据",groups.toString());

        list.addAll(groups);


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




}
