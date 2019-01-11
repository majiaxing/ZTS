package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.XX_xq_Cotract;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;
import com.example.lenovo.ztsandroid.presenter.XX_xq_Presenter;
import com.example.lenovo.ztsandroid.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/2.
 */
public class XiaoX_XQ_Activity extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Xiao_XQ)
    TextView XiaoXQ;
    @BindView(R.id.A_Image_TX)
    CircleImageView AImageTX;
    @BindView(R.id.data_zs)
    TextView dataZs;
    @BindView(R.id.Xx_neirong)
    TextView XxNeirong;


    private String xx_title;
    private String xx_nr;

    private XX_xq_Cotract.Presenter presenter;
    private String newtime;


    @Override
    protected int getLayoutId() {
        return R.layout.xiaox_xiangq_activity;
    }

    @Override
    protected void initView() {
//        获取父页面的  参数
        Intent intent = getIntent();
        xx_title = intent.getStringExtra("标题");
        xx_nr = intent.getStringExtra("内容");
        newtime = intent.getStringExtra("时间");
        Log.e("获取消息标题",xx_title+""+xx_nr);
        XiaoXQ.setText(xx_title);
        XxNeirong.setText(xx_nr);
        dataZs.setText(newtime);

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

//        presenter = new XX_xq_Presenter(this);
//        presenter.SetUrl(id);
//        presenter.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_jt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;

        }
    }

}
