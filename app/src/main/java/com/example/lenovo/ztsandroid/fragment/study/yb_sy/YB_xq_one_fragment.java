package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.adapter.MyListview_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.presenter.YB_One_Xq_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.view.MyListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/5.
 */

public class YB_xq_one_fragment extends BaseFragment implements YB_XiangQ_Cotract.View,View.OnClickListener {



    TextView Dc;

    TextView FanY;

    RadioButton BFOne,BFOneXuanZ,BFTwoXuanZ;

    RadioButton BFTwo;

    ImageView YBXxImage;

    Button TZYXO;

    ImageView Image;
    private YB_XiangQ_Cotract.Presenter presenter;
    private MyListview_Adapter madapter;
    private ArrayList<YB_XQ_one_Bean.DataBean> list = new ArrayList<>();
    private Bundle bundle;
    private String yBid;
    private Button bf_btn;
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频

    private String yb_avideo;
    private String relativePath;
    private String photo;

    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_one_fragment;
    }

    @Override
    protected void init(View view) {

//        初始化控件
        Dc = view.findViewById(R.id.Dc);
        BFOne = view.findViewById(R.id.BF_One);
        BFTwo = view.findViewById(R.id.BF_Two);
        TZYXO = view.findViewById(R.id.TZ_YX_o);
        bf_btn = view.findViewById(R.id.BF_Btn);
        YBXxImage = view.findViewById(R.id.YB_xx_image);
        BFOneXuanZ = view.findViewById(R.id.BF_One_Xuanz);
        BFTwoXuanZ = view.findViewById(R.id.BF_Two_Xuanz);
        FanY = view.findViewById(R.id.yb_one_item);
        Image = view.findViewById(R.id.YB_xx_image);
//        四个按钮的点击事件
        BFOne.setOnClickListener(this);
        BFTwo.setOnClickListener(this);
        TZYXO.setOnClickListener(this);
        bf_btn.setOnClickListener(this);



    }

    @Override
    protected void loadData() {
//        开始网络请求 presenter 层的初始化
        yBid = bundle.getString("YBid");
        presenter = new YB_One_Xq_Presenter(this);
        presenter.SetUrl(yBid, "1" ,"1");

    }
//  在fragment 显示隐藏的时候 加载 播放框架
    public void setVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPlayer == null){
            mPlayer = new MediaPlayer();
        }
        if (!isVisibleToUser){
//            mediaPlayer.start();
            mPlayer.stop();
        }else {
            try {
                mPlayer = null;
                mPlayer = new MediaPlayer();
                String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relativePath+"&"+"type=2"+"&"+"fileName="+yb_avideo;
                mPlayer.setDataSource(bofUrl);
                MyLog.e("sahdisauhdiuahdiuaw",bofUrl);
                //3 准备播放
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mPlayer.start();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


// 通过bundle 得到父级页面穿过来的 值
    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }




// 网络请求 成功的回调
    @Override
    public void getManager(YB_XQ_four_Bean yb_bean) {

    }

    @Override
    public void getManagerO(YB_XQ_one_Bean yb_xq_one_bean) {

        final String yb_word = yb_xq_one_bean.getData().get(0).getYb_word();
        final String yb_text = yb_xq_one_bean.getData().get(0).getYb_translate();
        yb_avideo = yb_xq_one_bean.getData().get(0).getYb_Avideo();
        relativePath = yb_xq_one_bean.getData().get(0).getRelative_path();
        photo = yb_xq_one_bean.getData().get(0).getYb_photoes();
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Dc.setText(yb_word);
                FanY.setText(yb_text);
                String str = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relativePath + "&" + "type=1" + "&" + "fileName=" +photo;
                MyLog.e("ASDHAS",str);
                Glide.with(App.activity).load(str).into(YBXxImage);


            }
        });


    }

    @Override
    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerR(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTh(YB_XQ_three_Bean postYinB_XQ_three) {

    }
//请求失呗是返回的message
    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(YB_XiangQ_Cotract.Presenter presenter) {

    }

    private Boolean[] bool  = {false};
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BF_One:
                BFOneXuanZ.setVisibility(View.VISIBLE);
                BFTwoXuanZ.setVisibility(View.GONE);
                break;
            case R.id.BF_Two:
                BFOneXuanZ.setVisibility(View.GONE);
                BFTwoXuanZ.setVisibility(View.VISIBLE);
                break;
            case R.id.TZ_YX_o:

                MyLog.e("sadsaddasqqqqqqqqq","点击按钮");
                Intent intent = new Intent(App.activity,TiaoZan_Activity.class);
                intent.putExtra("YB_id",yBid);
                startActivity(intent);
                break;

            case R.id.BF_Btn:


                if (bool[0]){
                    if (mPlayer.isPlaying()){
                        MyLog.e("lalall","ahahahahh");
                        setVisibleHint(false);
                    }
                    bool[0] = false;
                }else {
                    if (!mPlayer.isPlaying()){
                        MyLog.e("holle dnsjk","ahahahahh");
                        setVisibleHint(true);
                    }
                    bool[0] = true;
                }
                break;

        }
    }
}
