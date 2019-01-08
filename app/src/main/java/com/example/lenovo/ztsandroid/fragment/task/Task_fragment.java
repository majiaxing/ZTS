package com.example.lenovo.ztsandroid.fragment.task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.utils.Putils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/10/26.
 */

public class Task_fragment extends BaseFragment {


    Button JrBj;


    @Override
    protected int getLayoutId() {
        return R.layout.cs_yemianth;
    }

    @Override
    protected void init(View view) {
    JrBj = view.findViewById(R.id.Jr_Bj);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {

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

    @OnClick(R.id.Jr_Bj)
    public void onViewClicked(View view) {

            Putils.PopupW(view,"非会员不能加入班级，请升级");

            Putils.PopupDimiss();

    }
}
