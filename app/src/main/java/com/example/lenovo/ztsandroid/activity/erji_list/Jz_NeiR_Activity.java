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
import com.example.lenovo.ztsandroid.activity.DanC_Sy_Activity;
import com.example.lenovo.ztsandroid.activity.JuZ_Sy_Activity;
import com.example.lenovo.ztsandroid.activity.Kew_Sy_Activity;
import com.example.lenovo.ztsandroid.adapter.Jz_nr_Adapter;
import com.example.lenovo.ztsandroid.adapter.kw_nr_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Juz_list_Cotract;
import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.model.entity.DuiH_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.presenter.Jz_erj_Presenter;
import com.example.lenovo.ztsandroid.presenter.Kw_erji_Presenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class Jz_NeiR_Activity extends BaseActivity implements Juz_list_Cotract.View{
    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.List_kew_r)
    ListView ListKewR;
    private Jz_nr_Adapter adapter;
    private ArrayList<Juz_erj_Bean.DataBean> list = new ArrayList<>();
    private String extra;
    private Juz_list_Cotract.Presenter presenter;
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




        ListKewR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getSentence_name();
                String sentence_id = list.get(i).getSentence_id();
                Intent intent = new Intent(App.activity,JuZ_Sy_Activity.class);
                intent.putExtra("title",Xx);
                intent.putExtra("sentence_id",sentence_id);
                intent.putExtra("Relative_path",list.get(i).getRelative_path());
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
    presenter = new Jz_erj_Presenter(this);

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
    public void getManager(Juz_erj_Bean erjBean) {

        list.addAll(erjBean.getData());


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new Jz_nr_Adapter(App.activity,list);
                ListKewR.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void getManager(DuiH_erj_Bean erjBean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Juz_list_Cotract.Presenter presenter) {

    }
}
