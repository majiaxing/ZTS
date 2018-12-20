package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_XX_Adapter;
import com.example.lenovo.ztsandroid.adapter.Spinner_Adapter;
import com.example.lenovo.ztsandroid.adapter.ZN_zw_adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/5.
 */
public class ZN_ZW_Activity extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Listview_ZN_ZW)
    ListView ListviewZNZW;
    private ZN_zw_adapter myadapter;
    private ArrayList<Spinner_Bean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.zn_zw_activity;
    }

    @Override
    protected void initView() {

        list.add(new Spinner_Bean("1.公共事业（应用）"));
        list.add(new Spinner_Bean("1.公共事业（应用）"));
        list.add(new Spinner_Bean("1.公共事业（应用）"));
        list.add(new Spinner_Bean("1.公共事业（应用）"));
        list.add(new Spinner_Bean("1.公共事业（应用）"));
        list.add(new Spinner_Bean("1.公共事业（应用）"));


        myadapter = new ZN_zw_adapter(App.activity,list);
        ListviewZNZW.setAdapter(myadapter);

        ListviewZNZW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getPersonName();
                Intent intent = new Intent(App.activity,ZN_Zw_xq_Activity.class);
                intent.putExtra("title",Xx);
                startActivity(intent);
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
