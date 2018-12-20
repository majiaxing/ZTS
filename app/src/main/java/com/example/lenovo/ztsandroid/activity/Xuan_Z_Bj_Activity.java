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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/2.
 */
public class Xuan_Z_Bj_Activity extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.List_NJ)
    ListView ListNJ;
    private List_XX_Adapter myadapter;
    private ArrayList<Spinner_Bean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.xuan_z_bj_activity;
    }

    @Override
    protected void initView() {
        list.add(new Spinner_Bean("一班"));
        list.add(new Spinner_Bean("二班"));
        list.add(new Spinner_Bean("三班"));
        list.add(new Spinner_Bean("四班"));
        list.add(new Spinner_Bean("五班"));
        list.add(new Spinner_Bean("六班"));
        list.add(new Spinner_Bean("七班"));
        list.add(new Spinner_Bean("八班"));
        list.add(new Spinner_Bean("九班"));
        list.add(new Spinner_Bean("十班"));
        list.add(new Spinner_Bean("十一班"));

        myadapter = new List_XX_Adapter(App.activity,list);
        ListNJ.setAdapter(myadapter);

        ListNJ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nj = list.get(i).getPersonName();
                Log.e("ListView条目",nj);
                Intent intent = new Intent(App.activity,Qrdd_Activity.class);
                intent.putExtra("班级",nj);
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
