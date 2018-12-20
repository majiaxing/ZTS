package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_XX_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/2.
 */
public class Xuan_Z_NJ_Activity extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.List_NJ)
    ListView ListNJ;
    private List_XX_Adapter myadapter;
    private ArrayList<Spinner_Bean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.xuan_z_nj_activity;
    }

    @Override
    protected void initView() {

        list.add(new Spinner_Bean("一年级"));
        list.add(new Spinner_Bean("二年级"));
        list.add(new Spinner_Bean("三年级"));
        list.add(new Spinner_Bean("四年级"));
        list.add(new Spinner_Bean("五年级"));
        list.add(new Spinner_Bean("六年级"));
        list.add(new Spinner_Bean("七年级"));
        list.add(new Spinner_Bean("八年级"));
        list.add(new Spinner_Bean("九年级"));
        list.add(new Spinner_Bean("高一"));
        list.add(new Spinner_Bean("高二"));
        list.add(new Spinner_Bean("高三"));

        myadapter = new List_XX_Adapter(App.activity,list);
        ListNJ.setAdapter(myadapter);

        ListNJ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nj = list.get(i).getPersonName();
                Log.e("ListView条目",nj);
                Intent intent = new Intent(App.activity,Qrdd_Activity.class);
                intent.putExtra("年级",nj);
                startActivity(intent);
                finish();
            }
        });

    }

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

    @OnClick(R.id.back_jt)
    public void onViewClicked() {
        App.activity.onBackPressed();
    }
}
