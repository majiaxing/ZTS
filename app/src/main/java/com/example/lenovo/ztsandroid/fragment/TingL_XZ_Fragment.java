package com.example.lenovo.ztsandroid.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.TingL_XQ_xz_Cotract;
import com.example.lenovo.ztsandroid.model.entity.TiLi_BaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.presenter.TiL_BaoC_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/21.
 */
public class TingL_XZ_Fragment extends BaseFragment implements TingL_XQ_xz_Cotract.View {

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
    @BindView(R.id.Image_A)
    ImageView ImageA;
    @BindView(R.id.XuanZ_A)
    ImageView XuanZA;
    @BindView(R.id.Text_A)
    TextView TextA;
    @BindView(R.id.Image_B)
    ImageView ImageB;
    @BindView(R.id.XuanZ_B)
    ImageView XuanZB;
    @BindView(R.id.Text_B)
    TextView TextB;
    @BindView(R.id.Image_C)
    ImageView ImageC;
    @BindView(R.id.XuanZ_C)
    ImageView XuanZC;
    @BindView(R.id.Text_C)
    TextView TextC;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.tm_title)
    TextView tmTitle;
    @BindView(R.id.BF_One)
    TextView BFOne;
    @BindView(R.id.BF_One_Xuanz)
    TextView BFOneXuanz;
    @BindView(R.id.Xuanz_nr_A)
    TextView XuanzNrA;
    @BindView(R.id.XX_A)
    LinearLayout XXA;
    @BindView(R.id.BF_Two)
    TextView BFTwo;
    @BindView(R.id.BF_Two_Xuanz)
    TextView BFTwoXuanz;
    @BindView(R.id.Xuanz_nr_B)
    TextView XuanzNrB;
    @BindView(R.id.XX_B)
    LinearLayout XXB;
    @BindView(R.id.BF_Three)
    TextView BFThree;
    @BindView(R.id.BF_Three_Xuanz)
    TextView BFThreeXuanz;
    @BindView(R.id.Xuanz_nr_C)
    TextView XuanzNrC;
    @BindView(R.id.XX_C)
    LinearLayout XXC;
    @BindView(R.id.linearLayout_ZX)
    LinearLayout linearLayoutZX;
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
    @BindView(R.id.BF_Four)
    TextView BFFour;
    @BindView(R.id.BF_Four_Xuanz)
    TextView BFFourXuanz;
    @BindView(R.id.Xuanz_nr_D)
    TextView XuanzNrD;
    @BindView(R.id.XX_D)
    android.widget.LinearLayout XXD;
    @BindView(R.id.ChongZ)
    Button ChongZ;
    private Bundle bundle;
    private ArrayList<TingL_TK_Bean.DataBean.ListenQuestionListBean.ListenOptionListBean> mlist = new ArrayList<>();
    private String relative_path;
    private String word_video;
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频
    private TingL_XQ_xz_Cotract.Presenter presenter;
    private String listen_id;
    private String type;
    private String listen_questId;
    String str = null;
    private String listen_optionContent;
    private String listen_optionPhotoes;
    private String listen_answer;
    private String avgScore;

    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_xuanz;
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

            if (BFZt != null) {
                BFZt.setChecked(false);
            }
        } else {
            try {
                mPlayer = null;
                mPlayer = new MediaPlayer();
                relative_path = bundle.getString("relative_path");
                word_video = bundle.getString("word_video");
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

                        if (BFZt != null){

                        MyLog.e("CheckBox_状态", BFZt.isChecked() + "");
                        BFZt.setChecked(false);
                        bool[0] = false;
                        }
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
    protected void init(View view) {


        BFZt = view.findViewById(R.id.BF_zt);
        TJXyt = view.findViewById(R.id.TJ_Xyt);
        textView3 = view.findViewById(R.id.textView3);
        nextT = view.findViewById(R.id.next_T);
        TMTitle = view.findViewById(R.id.TM_title);
        linearLayoutXz = view.findViewById(R.id.linear_layout_xz);
        JX = view.findViewById(R.id.JX_);
        JXList = view.findViewById(R.id.JX_list);
        LinearLayout = view.findViewById(R.id.LinearLayout);
        relativeLayout2 = view.findViewById(R.id.relativeLayout2);


        ArrayList<TingL_TK_Bean.DataBean.ListenQuestionListBean.ListenOptionListBean> list = (ArrayList<TingL_TK_Bean.DataBean.ListenQuestionListBean.ListenOptionListBean>) bundle.getSerializable("list");

        listen_optionContent = list.get(0).getListen_optionContent();
        listen_optionPhotoes = list.get(0).getListen_optionPhotoes();

        MyLog.e("adhwahjakhlsa",listen_optionContent+listen_optionPhotoes);


        listen_answer = bundle.getString("listen_answer");
        String title = bundle.getString("title");
        String ertitle = bundle.getString("ertitle");
        relative_path = bundle.getString("relative_path");
        avgScore = bundle.getString("avgScore");

        listen_id = bundle.getString("listen_id");
        type = bundle.getString("type");
        listen_questId = bundle.getString("Listen_questId");
        TMTitle.setText(title);

        String yema = bundle.getString("yema");
        String dangq = bundle.getString("dangq");
        MyLog.e("一共有————",yema);
        textView3.setText(dangq+"/"+yema);

        if (listen_optionContent != null) {

            MyLog.e("sdaada0", list.size() + "");
            switch (list.size()) {
                case 2:
                    XuanzNrA.setText(list.get(0).getListen_option() + ". " + list.get(0).getListen_optionContent());
                    XuanzNrB.setText(list.get(1).getListen_option() + ". " + list.get(1).getListen_optionContent());
                    XXC.setVisibility(View.GONE);
                    XXD.setVisibility(View.GONE);
                    break;
                case 3:
                    XuanzNrA.setText(list.get(0).getListen_option() + ". " + list.get(0).getListen_optionContent());
                    XuanzNrB.setText(list.get(1).getListen_option() + ". " + list.get(1).getListen_optionContent());
                    XuanzNrC.setText(list.get(2).getListen_option() + ". " + list.get(2).getListen_optionContent());
                    XXD.setVisibility(View.GONE);
                    break;
                case 4:
                    XuanzNrA.setText(list.get(0).getListen_option() + ". " + list.get(0).getListen_optionContent());
                    XuanzNrB.setText(list.get(1).getListen_option() + ". " + list.get(1).getListen_optionContent());
                    XuanzNrC.setText(list.get(2).getListen_option() + ". " + list.get(2).getListen_optionContent());
                    XuanzNrD.setText(list.get(3).getListen_option() + ". " + list.get(3).getListen_optionContent());
                    break;
            }

            linearLayout.setVisibility(View.GONE);
            linearLayoutZX.setVisibility(View.VISIBLE);
            tmTitle.setText(ertitle);

        } else if (listen_optionPhotoes != null) {

            linearLayout.setVisibility(View.VISIBLE);
            linearLayoutZX.setVisibility(View.GONE);

            String sA = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=1" + "&" + "fileName=" + list.get(0).getListen_optionPhotoes();
            String sB = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=1" + "&" + "fileName=" + list.get(1).getListen_optionPhotoes();
            String sC = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=1" + "&" + "fileName=" + list.get(2).getListen_optionPhotoes();


            MyLog.e("AAAAAAA", sA);
            MyLog.e("BBBBBBB", sB);
            MyLog.e("CCCCCCC", sC);

            Glide.with(App.activity).load(sA).into(ImageA);
            Glide.with(App.activity).load(sB).into(ImageB);
            Glide.with(App.activity).load(sC).into(ImageC);

            TextA.setText(list.get(0).getListen_option());
            TextB.setText(list.get(1).getListen_option());
            TextC.setText(list.get(2).getListen_option());

            if (XuanZA.getVisibility() == View.VISIBLE) {
                str = "A";
            } else if (XuanZB.getVisibility() == View.VISIBLE) {
                str = "B";
            } else if (XuanZC.getVisibility() == View.VISIBLE) {
                str = "C";
            }


        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }

    private Boolean[] bool = {false};
    private String FenS = null;

    @OnClick({R.id.TJ_Xyt, R.id.next_T, R.id.Image_A, R.id.Image_B, R.id.Image_C, R.id.XX_A, R.id.XX_B, R.id.XX_C, R.id.XX_D, R.id.BF_zt ,R.id.ChongZ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.TJ_Xyt:
                if (listen_optionContent != null) {
                    if (BFOneXuanz.getVisibility() == View.GONE && BFTwoXuanz.getVisibility() == View.GONE && BFThreeXuanz.getVisibility() == View.GONE && BFFourXuanz.getVisibility() == View.GONE){
                        Toast toast = Toast.makeText(App.activity, "请选择答案后提交", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                        return;
                    }else {
                        if (BFOneXuanz.getVisibility() == View.VISIBLE) {
                            str = "A";
                            BFOneXuanz.setVisibility(View.GONE);
                            BFTwoXuanz.setVisibility(View.GONE);
                            BFThreeXuanz.setVisibility(View.GONE);
                            BFFourXuanz.setVisibility(View.GONE);
                            if (listen_answer.equals("A")) {
                                FenS = avgScore;
                                BFOne.setBackgroundResource(R.drawable.ture);
                            } else {
                                BFOne.setBackgroundResource(R.drawable.false_cuo);
                                FenS = "0";
                                if (listen_answer.equals("B")) {
                                    BFTwo.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("C")) {
                                    BFThree.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("D")) {
                                    BFFour.setBackgroundResource(R.drawable.ture);
                                }
                            }
                        } else if (BFTwoXuanz.getVisibility() == View.VISIBLE) {
                            str = "B";
                            BFOneXuanz.setVisibility(View.GONE);
                            BFTwoXuanz.setVisibility(View.GONE);
                            BFThreeXuanz.setVisibility(View.GONE);
                            BFFourXuanz.setVisibility(View.GONE);
                            if (listen_answer.equals("B")) {
                                BFTwo.setBackgroundResource(R.drawable.ture);
                                FenS = avgScore;
                            } else {
                                BFTwo.setBackgroundResource(R.drawable.false_cuo);
                                FenS = "0";
                                if (listen_answer.equals("A")) {
                                    BFOne.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("C")) {
                                    BFThree.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("D")) {
                                    BFFour.setBackgroundResource(R.drawable.ture);
                                }
                            }
                        } else if (BFThreeXuanz.getVisibility() == View.VISIBLE) {
                            str = "C";
                            BFOneXuanz.setVisibility(View.GONE);
                            BFTwoXuanz.setVisibility(View.GONE);
                            BFThreeXuanz.setVisibility(View.GONE);
                            BFFourXuanz.setVisibility(View.GONE);
                            if (listen_answer.equals("C")) {
                                FenS = avgScore;
                                BFThree.setBackgroundResource(R.drawable.ture);
                            } else {
                                BFThree.setBackgroundResource(R.drawable.false_cuo);
                                FenS = "0";
                                if (listen_answer.equals("A")) {
                                    BFOne.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("B")) {
                                    BFTwo.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("D")) {
                                    BFFour.setBackgroundResource(R.drawable.ture);
                                }
                            }
                        } else if (BFFourXuanz.getVisibility() == View.VISIBLE) {
                            str = "D";
                            BFOneXuanz.setVisibility(View.GONE);
                            BFTwoXuanz.setVisibility(View.GONE);
                            BFThreeXuanz.setVisibility(View.GONE);
                            BFFourXuanz.setVisibility(View.GONE);

                            if (listen_answer.equals("D")) {
                                FenS = avgScore;
                                BFFour.setBackgroundResource(R.drawable.ture);
                            } else {
                                FenS = "0";
                                BFFour.setBackgroundResource(R.drawable.false_cuo);
                                if (listen_answer.equals("A")) {
                                    BFOne.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("B")) {
                                    BFTwo.setBackgroundResource(R.drawable.ture);
                                } else if (listen_answer.equals("C")) {
                                    BFThree.setBackgroundResource(R.drawable.ture);
                                }
                            }
                        }
                    }
                } else if (listen_optionPhotoes != null) {

                    if (XuanZA.getVisibility() == View.GONE && XuanZB.getVisibility() == View.GONE && XuanZC.getVisibility() == View.GONE) {
                        Toast toast = Toast.makeText(App.activity, "请选择答案后提交", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    } else {
                        if (XuanZA.getVisibility() == View.VISIBLE) {
                            str = "A";
                            if (listen_answer.equals("A")) {
                                FenS = avgScore;
                                XuanZA.setBackgroundResource(R.drawable.xuanz_true);
                            } else {
                                FenS = "0";
                                XuanZA.setBackgroundResource(R.drawable.xuanz_false);
                                if (listen_answer.equals("B")) {
                                    XuanZB.setVisibility(View.VISIBLE);
                                    XuanZB.setBackgroundResource(R.drawable.xuanz_true);
                                } else if (listen_answer.equals("C")) {
                                    XuanZC.setVisibility(View.VISIBLE);
                                    XuanZC.setBackgroundResource(R.drawable.xuanz_true);
                                }
                            }
                        } else if (XuanZB.getVisibility() == View.VISIBLE) {
                            str = "B";

                            if (listen_answer.equals("B")) {
                                FenS = avgScore;
                                XuanZB.setBackgroundResource(R.drawable.xuanz_true);
                            } else {
                                FenS = "0";
                                XuanZB.setBackgroundResource(R.drawable.xuanz_false);
                                if (listen_answer.equals("A")) {
                                    XuanZA.setVisibility(View.VISIBLE);
                                    XuanZA.setBackgroundResource(R.drawable.xuanz_true);
                                } else if (listen_answer.equals("C")) {
                                    XuanZC.setVisibility(View.VISIBLE);
                                    XuanZC.setBackgroundResource(R.drawable.xuanz_true);
                                }
                            }
                        } else if (XuanZC.getVisibility() == View.VISIBLE) {
                            str = "C";
                            if (listen_answer.equals("C")) {
                                FenS = avgScore;
                                XuanZC.setBackgroundResource(R.drawable.xuanz_true);
                            } else {
                                FenS = "0";
                                XuanZC.setBackgroundResource(R.drawable.xuanz_false);
                                if (listen_answer.equals("A")) {
                                    XuanZA.setVisibility(View.VISIBLE);
                                    XuanZA.setBackgroundResource(R.drawable.xuanz_true);
                                } else if (listen_answer.equals("B")) {
                                    XuanZB.setVisibility(View.VISIBLE);
                                    XuanZB.setBackgroundResource(R.drawable.xuanz_true);
                                }
                            }
                        }
                    }
                }
                presenter = new TiL_BaoC_Presenter(this);
                presenter.SetUrl(listen_id, type, App.stuid, "2", listen_questId, str, FenS);

                TJXyt.setText("下一题");
                ChongZ.setVisibility(View.VISIBLE);
                break;

            case R.id.next_T:
                break;
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
            case R.id.Image_A:
                XuanZA.setVisibility(View.VISIBLE);
                XuanZB.setVisibility(View.GONE);
                XuanZC.setVisibility(View.GONE);
                break;
            case R.id.Image_B:
                XuanZA.setVisibility(View.GONE);
                XuanZB.setVisibility(View.VISIBLE);
                XuanZC.setVisibility(View.GONE);
                break;
            case R.id.Image_C:
                XuanZA.setVisibility(View.GONE);
                XuanZB.setVisibility(View.GONE);
                XuanZC.setVisibility(View.VISIBLE);
                break;

            case R.id.XX_A:

                BFOneXuanz.setVisibility(View.VISIBLE);
                BFTwoXuanz.setVisibility(View.GONE);
                BFThreeXuanz.setVisibility(View.GONE);
                BFFourXuanz.setVisibility(View.GONE);
                break;
            case R.id.XX_B:
                BFOneXuanz.setVisibility(View.GONE);
                BFTwoXuanz.setVisibility(View.VISIBLE);
                BFThreeXuanz.setVisibility(View.GONE);
                BFFourXuanz.setVisibility(View.GONE);
                break;
            case R.id.XX_C:
                BFOneXuanz.setVisibility(View.GONE);
                BFTwoXuanz.setVisibility(View.GONE);
                BFThreeXuanz.setVisibility(View.VISIBLE);
                BFFourXuanz.setVisibility(View.GONE);
                break;

            case R.id.XX_D:
                BFOneXuanz.setVisibility(View.GONE);
                BFTwoXuanz.setVisibility(View.GONE);
                BFThreeXuanz.setVisibility(View.GONE);
                BFFourXuanz.setVisibility(View.VISIBLE);
                break;
            case R.id.ChongZ:



                break;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void getManager(TingL_XQ_xz_Bean xqbean) {

    }

    @Override
    public void getManager(TingL_TK_Bean xqbean) {

    }

    @Override
    public void getManagerTiJ(TiLi_BaoC_Bean tiLi_baoC_bean) {

        final String flag = tiLi_baoC_bean.getData().getFlag();

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(App.activity,flag,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(TingL_XQ_xz_Cotract.Presenter presenter) {

    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }


}
