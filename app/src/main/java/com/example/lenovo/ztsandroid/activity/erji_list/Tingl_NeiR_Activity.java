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
import com.example.lenovo.ztsandroid.activity.TingL_TK_Activity;
import com.example.lenovo.ztsandroid.activity.TingL_TK_Xz_Activity;
import com.example.lenovo.ztsandroid.adapter.Tl_nr_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.TingL_erj_Cotract;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;
import com.example.lenovo.ztsandroid.presenter.TingL_erj_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/21.
 */

public class Tingl_NeiR_Activity  extends BaseActivity implements TingL_erj_Cotract.View {



    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.List_kew_r)
    ListView ListKewR;
    private Tl_nr_Adapter adapter;
    private ArrayList<TingL_erj_Bean.DataBean> list = new ArrayList<>();
    private String extra;
    private TingL_erj_Cotract.Presenter presenter;
    private String type;
    private String listen_type;

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
        listen_type = intent.getStringExtra("listen_type");
        title.setText(xxx);


        ListKewR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  Xx = list.get(i).getListen_name();
                String text_id = list.get(i).getListen_id();
                String relative_path = list.get(i).getRelative_path();
                switch (listen_type){
                        case "1":
                            Intent intent = new Intent(App.activity,TingL_TK_Xz_Activity.class);
                            intent.putExtra("title",Xx);
                            intent.putExtra("listen_id",text_id);
                            intent.putExtra("relative_path",relative_path);
                            intent.putExtra("type",type);
                            startActivity(intent);
                            break;
                        case "2":

                            Intent intent1 = new Intent(App.activity,TingL_TK_Activity.class);
                            intent1.putExtra("title",Xx);
                            intent1.putExtra("listen_id",text_id);
                            intent1.putExtra("relative_path",relative_path);
                            intent1.putExtra("type",type);
                            startActivity(intent1);
                            break;
                    }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        presenter = new TingL_erj_Presenter(this);
        presenter.SetU(extra,type,listen_type);

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
    public void getManager(final TingL_erj_Bean xqbean) {
        list.addAll(xqbean.getData());


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

//                MyLog.e("ADSSHADBS",xqbean.getData().get(0).getSave());

                adapter = new Tl_nr_Adapter(App.activity,list);
                ListKewR.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void showmessage(String str) {

    }


    @Override
    public void setBasePresenter(TingL_erj_Cotract.Presenter presenter) {

    }
}
