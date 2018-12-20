package com.example.lenovo.ztsandroid.activity.erji_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.Read_sy_Activity;
import com.example.lenovo.ztsandroid.adapter.Read_nr_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Read_erj_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Read_erj_Bean;
import com.example.lenovo.ztsandroid.presenter.Read_erj_Presenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/22.
 */
public class Read_erj_Activity extends BaseActivity implements Read_erj_Cotract.View {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.List_kew_r)
    ListView ListKewR;
    private Read_nr_Adapter adapter;
    private ArrayList<Read_erj_Bean.DataBean> list = new ArrayList<>();
    private String extra;
    private Read_erj_Cotract.Presenter presenter;
    private String type;

    @Override
    protected int getLayoutId() {
        return R.layout.kew_neir_activity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String xxx = intent.getStringExtra("title");
        extra = intent.getStringExtra("extra");
        type = intent.getStringExtra("type");
        title.setText(xxx);


//        for(int i = 0; i <10; i++){
//            list.add(new Spinner_Bean("Starter Unit "+i));
//        }

        ListKewR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Xx = list.get(i).getRead_title();
                String sentence_id = list.get(i).getRead_id();
                Intent intent = new Intent(App.activity, Read_sy_Activity.class);
                intent.putExtra("title", Xx);
                intent.putExtra("Read_id", sentence_id);
                startActivity(intent);


            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        presenter = new Read_erj_Presenter(this);
        presenter.SetU(extra, type);

    }

    @Override
    public void getManager(Read_erj_Bean xqbean) {

        list.addAll(xqbean.getData());


//        MyLog.e("ADASDASDWQWQQQQ",erjBean.getData().get(0).getTalk_name() +"");

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new Read_nr_Adapter(App.activity, list);
                ListKewR.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Read_erj_Cotract.Presenter presenter) {

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
