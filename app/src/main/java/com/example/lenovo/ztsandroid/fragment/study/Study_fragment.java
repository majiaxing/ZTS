package com.example.lenovo.ztsandroid.fragment.study;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.DuiH_Sy_Activity;
import com.example.lenovo.ztsandroid.activity.KW_LD_Activity;
import com.example.lenovo.ztsandroid.activity.Mian_Activity;
import com.example.lenovo.ztsandroid.activity.XX_Activity;
import com.example.lenovo.ztsandroid.activity.YB_SY_Activity;
import com.example.lenovo.ztsandroid.adapter.Grid_popup_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.JiaoC_xz_Cotract;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_content_Bean;
import com.example.lenovo.ztsandroid.presenter.JiaoC_Presenter;
import com.example.lenovo.ztsandroid.presenter.XiaoX_content_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/26.
 */

public class Study_fragment extends BaseFragment implements JiaoC_xz_Cotract.View {


    @BindView(R.id.Text_Banb)
    TextView TextBanb;
    @BindView(R.id.Text_NianJ)
    TextView TextNianJ;
    @BindView(R.id.Text_SXiaC)
    TextView TextSXiaC;
    @BindView(R.id.Back)
    ImageView Back;
    @BindView(R.id.linear)
    LinearLayout linear;
    @BindView(R.id.XX_Btn)
    RelativeLayout XXBtn;
    @BindView(R.id.Wd_Ts)
    TextView WdTs;
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.HW_)
    ImageView HW;
    @BindView(R.id.yb_text)
    TextView ybText;
    @BindView(R.id.Yin_Biao)
    RelativeLayout YinBiao;
    @BindView(R.id.Danci_text)
    TextView DanciText;
    @BindView(R.id.Danci)
    RelativeLayout Danci;
    @BindView(R.id.Duany_text)
    TextView DuanyText;
    @BindView(R.id.Duan_yu)
    RelativeLayout DuanYu;
    @BindView(R.id.Juzi_Text)
    TextView JuziText;
    @BindView(R.id.Juzi)
    RelativeLayout Juzi;
    @BindView(R.id.Kw_text)
    TextView KwText;
    @BindView(R.id.Ke_Wen)
    RelativeLayout KeWen;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.thxz)
    TextView thxz;
    @BindView(R.id.Tinghou_X)
    RelativeLayout TinghouX;
    @BindView(R.id.thhd)
    TextView thhd;
    @BindView(R.id.Tinghou_H)
    RelativeLayout TinghouH;
    @BindView(R.id.tltk)
    TextView tltk;
    @BindView(R.id.TingL_T)
    RelativeLayout TingLT;
    @BindView(R.id.ZNZW)
    TextView ZNZW;
    @BindView(R.id.Yuedu)
    RelativeLayout Yuedu;
    private PopupWindow popupWindow;
    private GridView grid;
    private Grid_popup_Adapter adapter;
    private ArrayList<JiaoC_Bean.DataBean> list = new ArrayList<>();
    private String Nj_jc;
    private JiaoC_xz_Cotract.Presenter presenter;
    private String jclx;
    private String sxc;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String jc;
    private String nj;
    private String sxc1;

    @Override
    protected int getLayoutId() {

        return R.layout.cs_yemainone;
    }


    @Override
    protected void init(View view) {



        sp = App.activity.getSharedPreferences("userInfo", App.activity.MODE_WORLD_READABLE);
        editor = sp.edit();

        jc = sp.getString("教材", null);
        nj = sp.getString("年级", null);
        sxc1 = sp.getString("上下册", null);

        MyLog.e("查询到的数据", jc + nj + sxc1);

        if (jc != "" && nj != "" && sxc1 !="" ){

            TextBanb.setText(jc);
            TextNianJ.setText(nj);
            TextSXiaC.setText(sxc1);
            MyLog.e("查询到的数据", jc + nj + sxc1);
        }else {

            TextBanb.setText("请选择  ");
            TextNianJ.setText("教材");
            TextSXiaC.setText("  ");
        }

    }

    public void upPopupWindow(View view) {

        View v = LayoutInflater.from(App.activity).inflate(R.layout.activity_popup_columns, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupView(View v) {

//        stuid = bundle.getInt("stuid");

        grid = v.findViewById(R.id.Grid_Popup);
        adapter = new Grid_popup_Adapter(App.activity, list);
        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View view1 = grid.getChildAt(position);
                LinearLayout linear = view1.findViewById(R.id.Liner);
                linear.setBackgroundResource(R.drawable.bg_btn_jiaoc_xz);
                Nj_jc = list.get(position).getNj();
                jclx = list.get(position).getJclx();
                sxc = list.get(position).getSxc();

//                MyLog.e("保存的数据", jclx + Nj_jc + sxc);




                if (jc == null|| nj == null|| sxc1 == null){

                    TextBanb.setText(jclx);
                    TextNianJ.setText(Nj_jc);
                    TextSXiaC.setText(sxc);

                    editor.putString("教材", jclx);
                    editor.putString("年级", Nj_jc);
                    editor.putString("上下册", sxc);
                    editor.commit();
                    MyLog.e("保存的数据",jclx + Nj_jc + sxc);
                }else {
                    if (!sp.getString("教材", null).equals(jclx) ||!sp.getString("年级", null).equals(Nj_jc) || !sp.getString("上下册", null).equals(sxc)) {
                        editor.clear();
                        TextBanb.setText(jclx);
                        TextNianJ.setText(Nj_jc);
                        TextSXiaC.setText(sxc);
                        editor.putString("教材", jclx);
                        editor.putString("年级", Nj_jc);
                        editor.putString("上下册", sxc);
                        editor.commit();
                        MyLog.e("保存的数据",jclx + Nj_jc + sxc);

                    }
                }

                popupWindow.dismiss();
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void loadData() {

        presenter = new JiaoC_Presenter(this);
        presenter.start();
        presenter.SetUrl(null);
        presenter = new XiaoX_content_Presenter(this);
        String stuid = String.valueOf(App.stuid);
        presenter.start();
        presenter.SetUrl(stuid);
    }

    @Override
    public void setParams(Bundle bundle) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

/*


    @Override
    public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
    }

    */

    @OnClick({R.id.XX_Btn, R.id.linear, R.id.Yin_Biao, R.id.Danci, R.id.Duan_yu, R.id.Juzi, R.id.Ke_Wen, R.id.Tinghou_X, R.id.Tinghou_H, R.id.TingL_T, R.id.Yuedu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.XX_Btn:
                Intent intent1 = new Intent(App.activity, XX_Activity.class);
                intent1.putExtra("stuid", App.stuid);
                startActivity(intent1);
                break;
            case R.id.linear:
                upPopupWindow(view);

                break;
            case R.id.Yin_Biao:
                Intent intent5 = new Intent(App.activity, YB_SY_Activity.class);
                intent5.putExtra("教材", TextBanb.getText());
                intent5.putExtra("年级", TextNianJ.getText());
                intent5.putExtra("上下册", TextSXiaC.getText());
                intent5.putExtra("flag", "symbol");
                startActivity(intent5);
                break;
            case R.id.Danci:
                Intent intent2 = new Intent(App.activity, KW_LD_Activity.class);
                intent2.putExtra("title", "word");
                intent2.putExtra("教材", TextBanb.getText());
                intent2.putExtra("年级", TextNianJ.getText());
                intent2.putExtra("上下册", TextSXiaC.getText());
                startActivity(intent2);
                break;
            case R.id.Duan_yu:
                Intent intent3 = new Intent(App.activity, KW_LD_Activity.class);
                intent3.putExtra("title", "phrase");
                intent3.putExtra("教材", TextBanb.getText());
                intent3.putExtra("年级", TextNianJ.getText());
                intent3.putExtra("上下册", TextSXiaC.getText());
                startActivity(intent3);
                break;
            case R.id.Juzi:
                Intent intent4 = new Intent(App.activity, KW_LD_Activity.class);
                intent4.putExtra("title", "sentence");
                intent4.putExtra("教材", TextBanb.getText());
                intent4.putExtra("年级", TextNianJ.getText());
                intent4.putExtra("上下册", TextSXiaC.getText());
                startActivity(intent4);
                break;
            case R.id.Ke_Wen:

                Intent intent = new Intent(App.activity, KW_LD_Activity.class);
                intent.putExtra("教材", TextBanb.getText());
                intent.putExtra("年级", TextNianJ.getText());
                intent.putExtra("上下册", TextSXiaC.getText());
                intent.putExtra("title", "text");
                MyLog.e("跳转携带的参数", jclx + Nj_jc + sxc);

                startActivity(intent);

                break;
            case R.id.Tinghou_X:

                Intent intent6 = new Intent(App.activity, KW_LD_Activity.class);

                intent6.putExtra("教材", TextBanb.getText());
                intent6.putExtra("年级", TextNianJ.getText());
                intent6.putExtra("上下册", TextSXiaC.getText());
                intent6.putExtra("title", "talk");
                MyLog.e("跳转携带的参数", jclx + Nj_jc + sxc);

                startActivity(intent6);


                break;
            case R.id.Tinghou_H:

                Intent intent8 = new Intent(App.activity, KW_LD_Activity.class);
                intent8.putExtra("教材", TextBanb.getText());
                intent8.putExtra("年级", TextNianJ.getText());
                intent8.putExtra("上下册", TextSXiaC.getText());
                intent8.putExtra("title", "listen");
                intent8.putExtra("listen_type","1");
                MyLog.e("跳转携带的参数", jclx + Nj_jc + sxc);

                startActivity(intent8);



                break;
            case R.id.TingL_T:
                Intent intent7 = new Intent(App.activity, KW_LD_Activity.class);
                intent7.putExtra("教材", TextBanb.getText());
                intent7.putExtra("年级", TextNianJ.getText());
                intent7.putExtra("上下册", TextSXiaC.getText());
                intent7.putExtra("title", "listen");
                intent7.putExtra("listen_type","2");
                MyLog.e("跳转携带的参数", jclx + Nj_jc + sxc);
                startActivity(intent7);

                break;
            case R.id.Yuedu:

                Intent intent9 = new Intent(App.activity, KW_LD_Activity.class);
                intent9.putExtra("教材", TextBanb.getText());
                intent9.putExtra("年级", TextNianJ.getText());
                intent9.putExtra("上下册", TextSXiaC.getText());
                intent9.putExtra("title", "read");
                MyLog.e("跳转携带的参数", jclx + Nj_jc + sxc);
                startActivity(intent9);




                break;
        }
    }

    @Override
    public void getManager(JiaoC_Bean jiaoC_bean) {

        MyLog.e("Grid请求到的数据", jiaoC_bean.getData().get(1).getJclx() + jiaoC_bean.getData().toString() + "");
        if (!jiaoC_bean.getData().isEmpty()) {
            list.addAll(jiaoC_bean.getData());
        }


    }

    @Override
    public void getXiaoXContent(XiaoX_content_Bean xiaoX_content_bean) {

        final int data = xiaoX_content_bean.getData();

        MyLog.e("ADDADASDASD", String.valueOf(data));


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (data == 0) {
                    WdTs.setVisibility(View.GONE);
                } else {
                    WdTs.setVisibility(View.VISIBLE);
                    String s = String.valueOf(data);
                    WdTs.setText(s);
                }
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }


    @Override
    public void setBasePresenter(JiaoC_xz_Cotract.Presenter presenter) {
        this.presenter = presenter;
    }


}
