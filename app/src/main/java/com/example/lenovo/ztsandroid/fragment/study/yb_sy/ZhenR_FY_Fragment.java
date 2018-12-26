package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.utils.MyLog;

/**
 * Created by Administrator on 2018/12/23.
 */
public class ZhenR_FY_Fragment extends BaseFragment {

    Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.zhenr_fay_fragment;
    }

    @Override
    protected void init(View view) {


        final Button button = view.findViewById(R.id.Button);

        String relative_path = bundle.getString("relative_path");
        String yb_translate = bundle.getString("yb_human");
        MyLog.e("adasdsalkjdlw",yb_translate+relative_path);
        String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=3"+"&"+"fileName="+yb_translate;

        MyLog.e("打印的Url",bofUrl);


        Uri uri = Uri.parse(bofUrl);
        final VideoView videoView = view.findViewById(R.id.video_view);

        MediaController mediaController = new MediaController(App.activity);
        mediaController.setVisibility(View.GONE);
        videoView.setVideoURI(uri);
        videoView.setBackgroundResource(R.drawable.ship_zwt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!videoView.isPlaying()){
                    videoView.start();
                    videoView.requestFocus();
                    videoView.setBackground(null);
                    button.setVisibility(View.GONE);
                }
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                button.setVisibility(View.VISIBLE);

            }
        });
    }
    @Override
    protected void loadData() {

    }
    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }
}
