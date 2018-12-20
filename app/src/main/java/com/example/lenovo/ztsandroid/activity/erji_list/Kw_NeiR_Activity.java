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



//        for(int i = 0; i <10; i++){
//            list.add(new Spinner_Bean("Starter Unit "+i));
//        }

        ListKewR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getText_title();
                String text_id = list.get(i).getText_id();
                Intent intent = new Intent(App.activity,Kew_Sy_Activity.class);
                intent.putExtra("title",Xx);
                intent.putExtra("text_id",text_id);
                intent.putExtra("type",type);
                startActivity(intent);



            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
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

    @Override
    public void getKw_erjlist(Kw_erji_list_Bean kw_erji_list_bean) {

        list.addAll(kw_erji_list_bean.getData());

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
