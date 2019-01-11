package com.example.lenovo.ztsandroid.activity.erji_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.Kew_Sy_Activity;
import com.example.lenovo.ztsandroid.adapter.kw_nr_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.presenter.Kw_erji_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class Kw_NeiR_Activity extends BaseActivity implements KeW_list_Cotract.View{
    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.List_kew_r)
    ListView ListKewR;
    private kw_nr_Adapter adapter;
    private ArrayList<Kw_erji_list_Bean.DataBean> list = new ArrayList<>();
    private String extra;
    private KeW_list_Cotract.Presenter presenter;
    private String type;

    @Override
    protected int getLayoutId() {
        return R.layout.kew_neir_activity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String xxx = intent.getStringExtra("title");
        extra= intent.getStringExtra("extra");
        type = intent.getStringExtra("type");
        title.setText(xxx);
//        列表的点击事件
        ListKewR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getText_title();
                String text_id = list.get(i).getText_id();
                String relative_path = list.get(i).getRelative_path();
                Intent intent = new Intent(App.activity,Kew_Sy_Activity.class);
                intent.putExtra("title",Xx);
                intent.putExtra("text_id",text_id);
                intent.putExtra("type",type);
                intent.putExtra("relative_path",relative_path);
                MyLog.e("要传过去的数据",relative_path);
                startActivity(intent);
            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

//        开启 网络请求 初始化presenter 传参
    presenter = new Kw_erji_Presenter(this);
        presenter.SetU(extra,type);

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

    @Override
    public void getManager(Kw_Bean kw_bean) {

    }
//   请求成功的回调
    @Override
    public void getKw_erjlist(Kw_erji_list_Bean kw_erji_list_bean) {
//得到数据 填充在list 集合里
        list.addAll(kw_erji_list_bean.getData());
//        开启主线程  初始化适配器  填充数据
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new kw_nr_Adapter(App.activity,list);
                ListKewR.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(KeW_list_Cotract.Presenter presenter) {

    }
}
