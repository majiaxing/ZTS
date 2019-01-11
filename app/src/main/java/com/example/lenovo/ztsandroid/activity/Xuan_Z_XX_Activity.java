package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_XX_Adapter;
import com.example.lenovo.ztsandroid.adapter.Myadapter;
import com.example.lenovo.ztsandroid.adapter.Spinner_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/2.
 */
public class Xuan_Z_XX_Activity extends BaseActivity {
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.XX_Shenj_Dq_spinner)
    Spinner XXShenjDqSpinner;
    @BindView(R.id.XX_Sj_Dq_spinner)
    Spinner XXSjDqSpinner;
    @BindView(R.id.XX_XJ_spinner)
    Spinner XXXJSpinner;
    @BindView(R.id.SS_Edit)
    EditText SSEdit;
    @BindView(R.id.List_XX)
    ListView ListXX;
    private List_XX_Adapter myadapter;
    private ArrayList<Spinner_Bean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.xuan_z_xx_activity;
    }

    @Override
    protected void initView() {

//        创建数据
        List<Spinner_Bean> persons=new ArrayList<Spinner_Bean>();
        persons.add(new Spinner_Bean( "宁夏"));
        persons.add(new Spinner_Bean("银川市"));
        persons.add(new Spinner_Bean("金凤区" ));
        //  建立Adapter绑定数据源
        Spinner_Adapter _MyAdapter=new Spinner_Adapter(persons,this);
            //绑定Adapter
        XXShenjDqSpinner.setAdapter(_MyAdapter);
        XXSjDqSpinner.setAdapter(_MyAdapter);
        XXXJSpinner.setAdapter(_MyAdapter);


        list.add(new Spinner_Bean("银川九中"));
        list.add(new Spinner_Bean("银川九中"));
        list.add(new Spinner_Bean("银川九中"));
        list.add(new Spinner_Bean("银川九中"));
        list.add(new Spinner_Bean("唐徕回中"));
        list.add(new Spinner_Bean("唐徕回中"));
        list.add(new Spinner_Bean("唐徕回中"));
        list.add(new Spinner_Bean("唐徕回中"));
        list.add(new Spinner_Bean("唐徕回中"));
        list.add(new Spinner_Bean("银川一中"));
        list.add(new Spinner_Bean("银川一中"));
        list.add(new Spinner_Bean("银川一中"));
        list.add(new Spinner_Bean("银川一中"));
        list.add(new Spinner_Bean("银川一中"));
        list.add(new Spinner_Bean("银川一中"));

        myadapter = new List_XX_Adapter(App.activity,list);
        ListXX.setAdapter(myadapter);

        ListXX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getPersonName();
                Intent intent = new Intent(App.activity,Qrdd_Activity.class);
                intent.putExtra("学校",Xx);
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
