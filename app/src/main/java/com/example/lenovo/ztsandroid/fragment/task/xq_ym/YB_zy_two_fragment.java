package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

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
import com.example.lenovo.ztsandroid.activity.ZuoY_TiaoZan_Activity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Two_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_YB_Two_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YB_zy_two_fragment extends BaseFragment implements ZuoY_Yb_Cotract.View, View.OnClickListener {


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
    private ZuoY_Yb_Cotract.Presenter presenter;
    private Bundle bundle, bundle1;
    private String yBid;
    private String relative_path;
    private String yb_translate;
    private String yb_human;
    private String yb_photo;
    private String hw_answerId;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;


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

        hw_answerId = bundle.getString("hw_answerId");
        hw_type = bundle.getString("hw_type");
        hw_content = bundle.getString("hw_content");
        hwid = bundle.getString("hwid");
        avgScores = bundle.getString("avgScores");


    }

    @Override
    protected void loadData() {

        yBid = bundle.getString("YBid");
        presenter = new ZuoY_YB_Two_presenter(this);
        presenter.SetUrl(App.stuid,hwid,"2","",hw_type,hw_content,avgScores ,"");
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


//    @Override
//    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {
//        yb_translate = yb_xq_two_bean.getData().get(0).getYb_translate();
//        relative_path = yb_xq_two_bean.getData().get(0).getRelative_path();
//        yb_human = yb_xq_two_bean.getData().get(0).getYb_human();
//        yb_photo = yb_xq_two_bean.getData().get(0).getYb_photo();
//
//        App.activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//                String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=1"+"&"+"fileName="+yb_photo;
//
//
//                YBNr.setText(yb_translate);
//
//                Glide.with(App.activity).load(bofUrl).asGif().into(FaYDongh);
//
//                String bofUrlO = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=3" + "&" + "fileName=" + yb_human;
//
//                MyLog.e("打印的Url", bofUrlO);
//
//                Uri uri = Uri.parse(bofUrlO);
//                MediaController mediaController = new MediaController(App.activity);
//                mediaController.setVisibility(View.GONE);
//                videoView.setVideoURI(uri);
//                videoView.setBackgroundResource(R.drawable.ship_zwt);
//                Button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (!videoView.isPlaying()) {
//                            videoView.start();
//                            videoView.requestFocus();
//                            videoView.setBackground(null);
//                            Button.setVisibility(View.GONE);
//                        }
//                    }
//                });
//                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mp) {
//                        Button.setVisibility(View.VISIBLE);
//                    }
//                });
//            }
//        });
//    }




    @Override
    public void getManagerTwo(YB_Zy_Two_Bean yb_xq_two_bean) {
        yb_translate = yb_xq_two_bean.getData().getTypeList().get(0).getYb_translate();
        relative_path = yb_xq_two_bean.getData().getTypeList().get(0).getRelative_path();
        yb_human = yb_xq_two_bean.getData().getTypeList().get(0).getYb_human();
        yb_photo = yb_xq_two_bean.getData().getTypeList().get(0).getYb_photo();

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=1"+"&"+"fileName="+yb_photo;

                YBNr.setText(yb_translate);

                Glide.with(App.activity).load(bofUrl).asGif().into(FaYDongh);

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
    public void getManagerThree(YB_Zy_Three_Bean yb_xq_three_bean) {

    }

    @Override
    public void getManagerFour(YB_Zy_four_Bean yb_xq_four_bean) {

    }

    @Override
    public void getManagerOne(YB_Zy_One_Bean yb_xq_one_bean) {

    }

    @Override
    public void showmessage(String str) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.R_D_H:
//                FragmentManager manager1=App.activity.getSupportFragmentManager();
//                FragmentTransaction transaction1=manager1.beginTransaction();
//                FaY_DongH_Fragment fragment2=new FaY_DongH_Fragment();
//                transaction1.add(R.id.Frame_Louyout, fragment2);
//                transaction1.commit();

//                if (yb_translate != null) {
//                    bundle1.putString("relative_path", relative_path);
//                    bundle1.putString("yb_translate", yb_translate);
//                    bundle1.putString("yb_photo", yb_photo);
////                    fragment2.setParams(bundle1);
//                    FragmantBuilder.getInstance().start(FaY_DongH_Fragment.class).setParams(bundle1);
//                    MyLog.e("yb_translate+relative_path", yb_translate + relative_path);
//                }
                ZRFYRela.setVisibility(View.GONE);
                FaYDongh.setVisibility(View.VISIBLE);


                RDH.setChecked(true);
                RZR.setChecked(false);
                break;
            case R.id.R_Z_R:
//                FragmentManager manager=App.activity.getSupportFragmentManager();
//                FragmentTransaction transaction=manager.beginTransaction();
//                ZhenR_FY_Fragment fragment1=new ZhenR_FY_Fragment();
//                transaction.add(R.id.Frame_Louyout, fragment1);
//                transaction.commit();

//                bundle1.putString("relative_path", relative_path);
//                bundle1.putString("yb_human", yb_human);
//                bundle1.putString("yb_translate", yb_translate);
////                fragment1.setParams(bundle1);
//                FragmantBuilder.getInstance().start(ZhenR_FY_Fragment.class).setParams(bundle1);
//                MyLog.e("yb_translate+relative_path", yb_translate + relative_path);

                ZRFYRela.setVisibility(View.VISIBLE);
                FaYDongh.setVisibility(View.GONE);


                RDH.setChecked(false);
                RZR.setChecked(true);
                break;
            case R.id.TZ_YX_t:
                Intent intent = new Intent(App.activity,ZuoY_TiaoZan_Activity.class);
                intent.putExtra("hw_type",hw_type);
                intent.putExtra("hw_content",hw_content);
                intent.putExtra("hwid",hwid);
                intent.putExtra("avgScores",avgScores);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void setBasePresenter(ZuoY_Yb_Cotract.Presenter presenter) {

    }
}
