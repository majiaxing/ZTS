package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Yb_Grid_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.YB_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Bean;
import com.example.lenovo.ztsandroid.presenter.YinB_Presenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/5.
 */
public class YB_SY_Activity extends BaseActivity implements YB_Cotract.View{
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Yb_grid_view)
    GridView YbGridView;

    private ArrayList<YB_Bean.DataBean> list = new ArrayList<>();
    private Yb_Grid_Adapter myadapter;
    private YB_Cotract.Presenter presenter;
    private String jc;
    private String nj;
    private String sxc;
    private String flag;

    @Override
    protected int getLayoutId() {
        return R.layout.yb_xz_acitvity;
    }

    @Override
    protected void initView() {


        Intent intent = getIntent();
        jc = intent.getStringExtra("教材");
        nj = intent.getStringExtra("年级");
        sxc = intent.getStringExtra("上下册");
        flag = intent.getStringExtra("flag");




        YbGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  yb = list.get(i).getYbtype();
                Intent intent = new Intent(App.activity,YB_XQ_Activity.class);
                intent.putExtra("音标",yb);
                intent.putExtra("ID",list.get(i).getYbid());
//                intent.putExtra("",list.get(i).)
                startActivity(intent);
            }
        });





    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
    presenter = new YinB_Presenter(this);
    presenter.SetUrl(jc,nj,sxc,flag);
    presenter.start();
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
    public void getManager(YB_Bean yb_bean) {

        list.addAll(yb_bean.getData());
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                myadapter = new Yb_Grid_Adapter(App.activity, list);
                YbGridView.setAdapter(myadapter);
                myadapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(YB_Cotract.Presenter presenter) {

    }
}
