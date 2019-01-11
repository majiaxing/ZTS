package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

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
import com.example.lenovo.ztsandroid.activity.ZuoY_TiaoZan_Activity;
import com.example.lenovo.ztsandroid.adapter.MyListview_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Two_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_YB_One_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/5.
 */

public class YB_zy_one_fragment extends BaseFragment implements ZuoY_Yb_Cotract.View,View.OnClickListener {

    TextView Dc;

    TextView FanY;

    RadioButton BFOne,BFOneXuanZ,BFTwoXuanZ;

    RadioButton BFTwo;

    ImageView YBXxImage;

    Button TZYXO;

    ImageView Image;
    private ZuoY_Yb_Cotract.Presenter presenter;
    private MyListview_Adapter madapter;
    private ArrayList<YB_XQ_one_Bean.DataBean> list = new ArrayList<>();
    private Bundle bundle;
    private String yBid;
    private Button bf_btn;
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频

    private String yb_avideo;
    private String relativePath;
    private String photo;
    private String hw_answerId;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;

    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_one_fragment;
    }

    @Override
    protected void init(View view) {
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

        hw_answerId = bundle.getString("hw_answerId");
        hw_type = bundle.getString("hw_type");
        hw_content = bundle.getString("hw_content");
        hwid = bundle.getString("hwid");
        avgScores = bundle.getString("avgScores");

        BFOne.setOnClickListener(this);
        BFTwo.setOnClickListener(this);
        TZYXO.setOnClickListener(this);
        bf_btn.setOnClickListener(this);



    }

    @Override
    protected void loadData() {

        yBid = bundle.getString("YBid");
        presenter = new ZuoY_YB_One_presenter(this);
        presenter.SetUrl(App.stuid,hwid,"1","",hw_type,hw_content,avgScores,"1");
    }

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







//    @Override
//    public void getManagerO(YB_XQ_one_Bean yb_xq_one_bean) {
//
//        final String yb_word = yb_xq_one_bean.getData().get(0).getYb_word();
//        final String yb_text = yb_xq_one_bean.getData().get(0).getYb_translate();
//        yb_avideo = yb_xq_one_bean.getData().get(0).getYb_Avideo();
//        relativePath = yb_xq_one_bean.getData().get(0).getRelative_path();
//        photo = yb_xq_one_bean.getData().get(0).getYb_photoes();
//        App.activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//                Dc.setText(yb_word);
//                FanY.setText(yb_text);
//                String str = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relativePath + "&" + "type=1" + "&" + "fileName=" +photo;
//                MyLog.e("ASDHAS",str);
//                Glide.with(App.activity).load(str).into(YBXxImage);
//
//
//            }
//        });
//
//
//    }


    @Override
    public void getManagerOne(YB_Zy_One_Bean yb_xq_one_bean) {

        final String yb_word = yb_xq_one_bean.getData().getTypeList().get(0).getYb_word();
        final String yb_text = yb_xq_one_bean.getData().getTypeList().get(0).getYb_translate();
        yb_avideo = yb_xq_one_bean.getData().getTypeList().get(0).getYb_Avideo();
        relativePath = yb_xq_one_bean.getData().getTypeList().get(0).getRelative_path();
        photo = yb_xq_one_bean.getData().getTypeList().get(0).getYb_photoes();
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
    public void getManagerTwo(YB_Zy_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerThree(YB_Zy_Three_Bean yb_xq_three_bean) {

    }

    @Override
    public void getManagerFour(YB_Zy_four_Bean yb_xq_four_bean) {

    }


    @Override
    public void showmessage(String str) {

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
                Intent intent = new Intent(App.activity,ZuoY_TiaoZan_Activity.class);
                intent.putExtra("hw_type",hw_type);
                intent.putExtra("hw_content",hw_content);
                intent.putExtra("hwid",hwid);
                intent.putExtra("avgScores",avgScores);
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

    @Override
    public void setBasePresenter(ZuoY_Yb_Cotract.Presenter presenter) {

    }
}
