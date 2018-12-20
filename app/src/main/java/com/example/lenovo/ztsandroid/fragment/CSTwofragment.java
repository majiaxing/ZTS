package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Myadapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.CScotract;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.presenter.CSpresenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class CSTwofragment extends BaseFragment implements CScotract.View{

    private ListView listView;
    private CSpresenter presenter;
    private Myadapter myadapter;
    private ArrayList<CeSBean.LiveBean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.cstwo_fragment;
    }

    @Override
    protected void init(View view) {
        new CSpresenter(this);
        presenter.SetUrl(null);
        listView = view.findViewById(R.id.CS_listview);
        myadapter = new Myadapter(getContext(),list);
        listView.setAdapter(myadapter);
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {

    }

    @Override
    public void getManager(CeSBean ceSBean) {


        list.addAll(ceSBean.getLive());
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(CScotract.Presenter presenter) {
        this.presenter = (CSpresenter) presenter;
    }
}
