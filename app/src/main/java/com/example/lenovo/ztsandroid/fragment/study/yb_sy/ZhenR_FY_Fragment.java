package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

        String relative_path = bundle.getString("relative_path");
        String yb_translate = bundle.getString("yb_human");
        MyLog.e("adasdsalkjdlw",yb_translate+relative_path);
        String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=1"+"&"+"fileName="+yb_translate;

        MyLog.e("打印的Url",bofUrl);


        Uri uri = Uri.parse(bofUrl);
        VideoView videoView = view.findViewById(R.id.video_view);
        videoView.setMediaController(new MediaController(App.activity));
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.requestFocus();

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }
}
