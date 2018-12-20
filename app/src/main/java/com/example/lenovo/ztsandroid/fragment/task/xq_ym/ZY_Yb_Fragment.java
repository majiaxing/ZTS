package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.MyListview_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Xq_Bean;
import com.example.lenovo.ztsandroid.presenter.YB_One_Xq_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.view.MyListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/27.
 */
public class ZY_Yb_Fragment extends BaseFragment implements View.OnClickListener{


    TextView Dc;

    RadioButton BFOne,BFOneXuanZ,BFTwoXuanZ;

    RadioButton BFTwo;

    ImageView YBXxImage;

    TextView textView;

    Button TZYXO;
    private YB_XiangQ_Cotract.Presenter presenter;
    private MyListview_Adapter madapter;
    private ArrayList<YB_XQ_one_Bean.DataBean> list = new ArrayList<>();
    private Bundle bundle;
    private String yBid;

    private MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_one_fragment;
    }

    @Override
    protected void init(View view) {




        Dc = view.findViewById(R.id.Dc);
        BFOne = view.findViewById(R.id.BF_One);
        BFTwo = view.findViewById(R.id.BF_Two);
        YBXxImage = view.findViewById(R.id.YB_xx_image);
        BFOneXuanZ = view.findViewById(R.id.BF_One_Xuanz);
        BFTwoXuanZ = view.findViewById(R.id.BF_Two_Xuanz);
        textView = view.findViewById(R.id.yb_one_item);
        BFOne.setOnClickListener(this);
        BFTwo.setOnClickListener(this);


        String yin = bundle.getString("DanCy");
        String fany = bundle.getString("DanCz");


//        madapter = new MyListview_Adapter(App.activity, list);
//        Listview.setAdapter(madapter);
//        madapter.notifyDataSetChanged();

        MyLog.e("Yin+FAny", yin + fany);


        Dc.setText(yin);
        textView.setText(fany);

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
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mediaPlayer == null){
            mediaPlayer = new MediaPlayer();
        }
        if (!isVisibleToUser){
//            mediaPlayer.start();
            mediaPlayer.stop();
        }else {
            try {
                mediaPlayer = null;
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131229550.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3");
                //3 准备播放
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

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
        mediaPlayer.stop();
    }
    private Boolean bool[] = {false};
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
                break;
            case R.id.BF_Btn:

                if (bool[0]){

                    if (mediaPlayer.isPlaying()){
                        MyLog.e("lalall","ahahahahh");
                        mediaPlayer.pause();
                    }
                    bool[0] = false;
                }else {
                    if (!mediaPlayer.isPlaying()){
                        MyLog.e("holle dnsjk","ahahahahh");
                        mediaPlayer.start();
                    }
                    bool[0] = true;
                }
                break;

        }
    }
}
