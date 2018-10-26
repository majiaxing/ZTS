package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.CScotract;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.presenter.CSpresenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class CSFragment extends BaseFragment implements CScotract.View{

    private ImageView imageView;
    private Bundle bundle;
    private String ImageUrl ;
    private CSpresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.cs_fragment;
    }

    @Override
    protected void init(View view) {
        new CSpresenter(this);
        presenter.SetUrl(null);
    imageView = view.findViewById(R.id.image);

    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle=bundle;
    }

    @Override
    public void getManager(CeSBean ceSBean) {
        MyLog.e("请求数据",ceSBean.toString());
        ImageUrl = ceSBean.getLive().get(1).getImage();
        Glide.with(this).load(ImageUrl).into(imageView);
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(CScotract.Presenter presenter) {
       this.presenter = (CSpresenter) presenter;
    }
}
