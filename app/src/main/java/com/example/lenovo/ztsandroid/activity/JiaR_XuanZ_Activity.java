package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.XuanZ_BJ_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.JaR_Bj_Cotract;
import com.example.lenovo.ztsandroid.model.entity.BanJBean;
import com.example.lenovo.ztsandroid.model.entity.Xz_Bj_Bean;
import com.example.lenovo.ztsandroid.presenter.Xz_Bj_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class JiaR_XuanZ_Activity extends BaseActivity implements JaR_Bj_Cotract.View{


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Banji_XZ)
    GridView BanjiXZ;
    @BindView(R.id.Jr_bj_btn)
    Button JrBjBtn;
    private String text;
    private ArrayList<BanJBean.DataBean> data = new ArrayList<>();
    private XuanZ_BJ_Adapter z_bj_adapter;
    private JaR_Bj_Cotract.Presenter presenter;
    private String classId;

    @Override
    protected int getLayoutId() {
        return R.layout.jia_xz_bj_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        ArrayList<BanJBean.DataBean> data1 = (ArrayList<BanJBean.DataBean>) intent.getSerializableExtra("data");

        data.addAll(data1);

        z_bj_adapter = new XuanZ_BJ_Adapter(App.activity,data);
        BanjiXZ.setAdapter(z_bj_adapter);
        z_bj_adapter.notifyDataSetChanged();

        BanjiXZ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                classId = data.get(position).getClassId();

                MyLog.e("sjdsalkjdswwwWWW",classId + "");
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





    @OnClick({R.id.back_jt, R.id.Jr_bj_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.Jr_bj_btn:
                if (classId == null){
                    Toast.makeText(App.activity,"请选择班级",Toast.LENGTH_SHORT).show();
                }else {

                    presenter = new Xz_Bj_Presenter(this);
                    presenter.SetUrl(App.stuid,classId);
                }

                break;
        }
    }

    @Override
    public void getManager(BanJBean duiHXqBean) {

    }

    @Override
    public void getManagerO(Xz_Bj_Bean str) {

        if (str.getData() !=  null){
            Intent intent = new Intent(App.activity,C_Jr_bj_Activity.class);
            startActivity(intent);
        }


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(JaR_Bj_Cotract.Presenter presenter) {

    }
}
