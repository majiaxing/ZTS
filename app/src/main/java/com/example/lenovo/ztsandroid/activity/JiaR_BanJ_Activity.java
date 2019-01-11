package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.JaR_Bj_Cotract;
import com.example.lenovo.ztsandroid.model.entity.BanJBean;
import com.example.lenovo.ztsandroid.model.entity.Xz_Bj_Bean;
import com.example.lenovo.ztsandroid.presenter.JaR_Bj_Presenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class JiaR_BanJ_Activity extends BaseActivity implements JaR_Bj_Cotract.View{


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.SR_ls)
    EditText SRLs;
    @BindView(R.id.Jr_bj_btn)
    Button JrBjBtn;

    private JaR_Bj_Cotract.Presenter presenter;
    private String text;

    @Override
    protected int getLayoutId() {
        return R.layout.jia_r_bj_activity;
    }

    @Override
    protected void initView() {




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
                break;
            case R.id.Jr_bj_btn:



                text = SRLs.getText().toString();
//                判读 是否 有这个班级存在
                presenter = new JaR_Bj_Presenter(this);
                presenter.SetUrl(App.stuid,text);


                break;
        }
    }

    @Override
    public void getManager(BanJBean duiHXqBean) {

        if (duiHXqBean.getData() == null){

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast toast = Toast.makeText(App.activity,"此班级id不存在", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();


//                    Toast.makeText(App.activity,"此班级id不存在",Toast.LENGTH_LONG).show();
                }
            });
        }else {
//            显示所有的班级 在列表上
            ArrayList<BanJBean.DataBean> data = (ArrayList<BanJBean.DataBean>) duiHXqBean.getData();
            Intent intent = new Intent(App.activity,JiaR_XuanZ_Activity.class);
            intent.putExtra("data", data);
            startActivity(intent);
            finish();
        }




    }

    @Override
    public void getManagerO(Xz_Bj_Bean str) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(JaR_Bj_Cotract.Presenter presenter) {

    }
}
