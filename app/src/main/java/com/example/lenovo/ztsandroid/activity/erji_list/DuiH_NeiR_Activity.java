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
import com.example.lenovo.ztsandroid.activity.DuiH_Sy_Activity;
import com.example.lenovo.ztsandroid.activity.JuZ_Sy_Activity;
import com.example.lenovo.ztsandroid.adapter.Dh_nr_Adapter;
import com.example.lenovo.ztsandroid.adapter.Jz_nr_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Juz_list_Cotract;
import com.example.lenovo.ztsandroid.model.entity.DuiH_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_erj_Bean;
import com.example.lenovo.ztsandroid.presenter.DuiH_erj_Presenter;
import com.example.lenovo.ztsandroid.presenter.Jz_erj_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class DuiH_NeiR_Activity extends BaseActivity implements Juz_list_Cotract.View{
    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.List_kew_r)
    ListView ListKewR;
    private Dh_nr_Adapter adapter;
    private ArrayList<DuiH_erj_Bean.DataBean> list = new ArrayList<>();
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



//        for(int i = 0; i <10; i++){
//            list.add(new Spinner_Bean("Starter Unit "+i));
//        }

        ListKewR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getTalk_name();
                String sentence_id = list.get(i).getTalk_id();
                String save_path = list.get(i).getRelative_path();
                Intent intent = new Intent(App.activity,DuiH_Sy_Activity.class);
                intent.putExtra("title",Xx);
                intent.putExtra("talk_id",sentence_id);

                MyLog.e("准备传过去的save_path ",save_path);

                intent.putExtra("relative_path",save_path);
                startActivity(intent);



            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
    presenter = new DuiH_erj_Presenter(this);

        presenter.setUrl(extra,type);

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



    }

    @Override
    public void getManager(DuiH_erj_Bean erjBean) {

        list.addAll(erjBean.getData());


//        MyLog.e("ADASDASDWQWQQQQ",erjBean.getData().get(0).getTalk_name() +"");

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new Dh_nr_Adapter(App.activity,list);
                ListKewR.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Juz_list_Cotract.Presenter presenter) {

    }
}
