package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ZY_TianK_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/27.
 */
public class Zy_TingL_TK_Fragment extends BaseFragment {

    @BindView(R.id.BF_zt)
    CheckBox BFZt;
    @BindView(R.id.TJ_Xyt)
    Button TJXyt;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.next_T)
    Button nextT;
    @BindView(R.id.TM_title)
    TextView TMTitle;
    //    @BindView(R.id.Xz_list)
//    ListView XzList;
    @BindView(R.id.linear_layout_xz)
    RelativeLayout linearLayoutXz;
    @BindView(R.id.JX_)
    TextView JX;
    @BindView(R.id.JX_list)
    ListView JXList;
    @BindView(R.id.LinearLayout)
    android.widget.LinearLayout LinearLayout;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    Unbinder unbinder;
    @BindView(R.id.XYT)
    Button XYT;
    @BindView(R.id.linearLayout5)
    android.widget.LinearLayout linearLayout5;
    @BindView(R.id.ChongZ)
    Button ChongZ;
    @BindView(R.id.Tk_Nr)
    TextView TkNr;
    @BindView(R.id.edit_TK)
    EditText editTK;

    private Bundle bundle;
    private ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean> mlist = new ArrayList<>();
    private ZY_TianK_Adapter listadapter;
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频

    private String relative_path;
    private String word_video;

    @Override
    protected int getLayoutId() {
        return R.layout.tingl_tk_fragment;
    }

    @Override
    protected void init(View view) {

        ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean> list = (ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean>) bundle.getSerializable("list");
        String listen_text = bundle.getString("title");

        TMTitle.setText(listen_text);

        mlist.addAll(list);
//
//        listadapter = new ZY_TianK_Adapter(App.activity, mlist);
//
//        XzList.setAdapter(listadapter);

        TkNr.setText(list.get(0).getListen_content());


        JX.setVisibility(View.GONE);
        ChongZ.setVisibility(View.GONE);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPlayer == null) {
            mPlayer = new MediaPlayer();
        }
        if (!isVisibleToUser) {
//            mediaPlayer.start();
            mPlayer.stop();
        } else {
            try {
                mPlayer = null;
                mPlayer = new MediaPlayer();

                relative_path = bundle.getString("Relative_path");
                word_video = bundle.getString("listen_video");
                String s = URLEncoder.encode(word_video, "utf-8").replaceAll("\\+", "%20");

                String bofUrl = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=2" + "&" + "fileName=" + s;
                mPlayer.setDataSource(bofUrl);
                MyLog.e("sahdisauhdiuahdiuaw", bofUrl);

                //3 准备播放
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                    }
                });

                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        MyLog.e("CheckBox_状态", BFZt.isChecked() + "");
                        BFZt.setChecked(false);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPlayer.stop();
    }


    @Override
    protected void loadData() {

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



    private Boolean bool[] = {false};

    @OnClick({R.id.BF_zt, R.id.TJ_Xyt, R.id.next_T, R.id.XYT, R.id.ChongZ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BF_zt:

                if (bool[0]) {
                    if (mPlayer.isPlaying()) {
                        MyLog.e("lalall", "ahahahahh");
                        mPlayer.pause();
                        bool[0] = false;
                    }
                } else {
                    if (!mPlayer.isPlaying()) {
                        MyLog.e("holle dnsjk", "ahahahahh");
                        mPlayer.start();
                        bool[0] = true;
                    }
                }


                break;
            case R.id.TJ_Xyt:
                JX.setVisibility(View.VISIBLE);
                XYT.setVisibility(View.VISIBLE);
                ChongZ.setVisibility(View.VISIBLE);
                break;
            case R.id.next_T:
                break;

            case R.id.XYT:
                break;
            case R.id.ChongZ:

                break;
        }
    }
}
