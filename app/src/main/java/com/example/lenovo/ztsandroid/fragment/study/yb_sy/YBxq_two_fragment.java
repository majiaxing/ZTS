package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.presenter.YB_Two_XQ_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YBxq_two_fragment extends BaseFragment implements YB_XiangQ_Cotract.View, View.OnClickListener {


    TextView YB_Nr;
    FrameLayout frameLayout;
    @BindView(R.id.R_D_H)
    CheckBox RDH;
    @BindView(R.id.R_Z_R)
    CheckBox RZR;
    @BindView(R.id.XZ_fy)
    LinearLayout XZFy;
    @BindView(R.id.TZ_YX_t)
    Button TZYXT;
    @BindView(R.id.Fa_Y_dongh)
    ImageView FaYDongh;
    @BindView(R.id.Button)
    android.widget.Button Button;
    @BindView(R.id.video_view)
    VideoView videoView;
    @BindView(R.id.ZR_FY_Rela)
    RelativeLayout ZRFYRela;
    @BindView(R.id.YB_Nr)
    TextView YBNr;
    @BindView(R.id.DH_Button)
    android.widget.Button DHButton;
    @BindView(R.id.DH_video_view)
    VideoView DHVideoView;
    @BindView(R.id.DH_FY_Rela)
    RelativeLayout DHFYRela;
    private YB_XiangQ_Cotract.Presenter presenter;
    private Bundle bundle, bundle1;
    private String yBid;
    private String relative_path;
    private String yb_translate;
    private String yb_human;
    private String yb_photo;
    private String yb_cartoon;


    @Override
    protected int getLayoutId() {
        return R.layout.tb_xq_two_fragment;
    }

    @Override
    protected void init(View view) {
        RDH = view.findViewById(R.id.R_D_H);
        RZR = view.findViewById(R.id.R_Z_R);
        XZFy = view.findViewById(R.id.XZ_fy);
        TZYXT = view.findViewById(R.id.TZ_YX_t);

        RDH.setOnClickListener(this);
        RZR.setOnClickListener(this);
        TZYXT.setOnClickListener(this);
        bundle1 = new Bundle();
    }

    @Override
    protected void loadData() {

        yBid = bundle.getString("YBid");
        presenter = new YB_Two_XQ_Presenter(this);
        presenter.SetUrl(yBid, "2", "");

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
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }


    @Override
    public void getManager(YB_XQ_four_Bean yb_bean) {


    }

    @Override
    public void getManagerO(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {
        yb_translate = yb_xq_two_bean.getData().get(0).getYb_translate();
        relative_path = yb_xq_two_bean.getData().get(0).getRelative_path();
        yb_human = yb_xq_two_bean.getData().get(0).getYb_human();
        yb_photo = yb_xq_two_bean.getData().get(0).getYb_photo();
        yb_cartoon = yb_xq_two_bean.getData().get(0).getYb_cartoon();
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (!yb_photo.equals("")) {


                    DHFYRela.setVisibility(View.GONE);
                    FaYDongh.setVisibility(View.VISIBLE);
                    MyLog.e("现在是图片",yb_photo);
                    String bofUrl = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=1" + "&" + "fileName=" + yb_photo;
                    Glide.with(App.activity).load(bofUrl).asGif().into(FaYDongh);
                    MyLog.e("图片的Url",bofUrl);
                } else if (!yb_cartoon.equals("")) {

                    MyLog.e("现在是视频",yb_cartoon);
                    FaYDongh.setVisibility(View.GONE);
                    DHFYRela.setVisibility(View.VISIBLE);
                    String bofUrlDH = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=3" + "&" + "fileName=" + yb_cartoon;
                    Uri uri = Uri.parse(bofUrlDH);
                    MediaController mediaController = new MediaController(App.activity);
                    mediaController.setVisibility(View.GONE);
                    DHVideoView.setVideoURI(uri);
                    DHVideoView.setBackgroundResource(R.drawable.ship_zwt);
                    DHButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!DHVideoView.isPlaying()) {
                                DHVideoView.start();
                                DHVideoView.requestFocus();
                                DHVideoView.setBackground(null);
                                DHButton.setVisibility(View.GONE);
                            }
                        }
                    });
                    DHVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            DHButton.setVisibility(View.VISIBLE);
                        }
                    });
                }

                YBNr.setText(yb_translate);


                String bofUrlO = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=3" + "&" + "fileName=" + yb_human;

                MyLog.e("打印的Url", bofUrlO);

                Uri uri = Uri.parse(bofUrlO);
                MediaController mediaController = new MediaController(App.activity);
                mediaController.setVisibility(View.GONE);
                videoView.setVideoURI(uri);
                videoView.setBackgroundResource(R.drawable.ship_zwt);
                Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!videoView.isPlaying()) {
                            videoView.start();
                            videoView.requestFocus();
                            videoView.setBackground(null);
                            Button.setVisibility(View.GONE);
                        }
                    }
                });
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Button.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }

    @Override
    public void getManagerR(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTh(YB_XQ_three_Bean yb_xq_th_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(YB_XiangQ_Cotract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.R_D_H:
                if (!yb_photo.equals("")){
                    ZRFYRela.setVisibility(View.GONE);
                    FaYDongh.setVisibility(View.VISIBLE);
                    DHFYRela.setVisibility(View.GONE);
                }else if (!yb_cartoon.equals("")){
                ZRFYRela.setVisibility(View.GONE);
                FaYDongh.setVisibility(View.GONE);
                DHFYRela.setVisibility(View.VISIBLE);
                }
                RDH.setChecked(true);
                RZR.setChecked(false);
                break;
            case R.id.R_Z_R:


                ZRFYRela.setVisibility(View.VISIBLE);
                FaYDongh.setVisibility(View.GONE);
                DHFYRela.setVisibility(View.GONE);

                RDH.setChecked(false);
                RZR.setChecked(true);
                break;
            case R.id.TZ_YX_t:
                Intent intent = new Intent(App.activity, TiaoZan_Activity.class);
                intent.putExtra("YB_id", yBid);
                startActivity(intent);
                break;
        }
    }
}
