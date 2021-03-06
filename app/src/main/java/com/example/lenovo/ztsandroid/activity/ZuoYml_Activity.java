package com.example.lenovo.ztsandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ZY_ml_Adapter;
import com.example.lenovo.ztsandroid.cotract.Zuoy_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.DC_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.DuanY_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.DuiH_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.Juz_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.Kw_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.TingL_TK_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.TingL_XZ_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.YB_ErJFragment;
import com.example.lenovo.ztsandroid.fragment.task.er_ym.YueD_ErJFragment;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;
import com.example.lenovo.ztsandroid.presenter.Zuoye_erji_list_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class ZuoYml_Activity extends Activity implements Zuoy_Cotract.View {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.dianjichakan)
    TextView dianjichakan;
    @BindView(R.id.ChaK_XQ)
    LinearLayout ChaKXQ;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.XueShengFenS)
    TextView XueShengFenS;
    @BindView(R.id.List_view)
    android.widget.ListView ListView;
    @BindView(R.id.statr_ZY)
    TextView statrZY;
    private ArrayList<ZuoY_erJ_Bean.DataBean.HomeworkTypeBean> list = new ArrayList<>();
    private ZY_ml_Adapter adapter;
    private Zuoy_Cotract.Presenter presenter;
    private String hwid;

    private String title;
    private String homework_cishu;
    private String scoreAll;
    private String flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zuoyeml_activity);
        ButterKnife.bind(this);

        initView();
        initData();
        loadData();

    }
    protected void initView() {

//        获取参数
        final Intent intent = getIntent();
        title = intent.getStringExtra("title");
        hwid = intent.getStringExtra("hwid");
        homework_cishu = intent.getStringExtra("homework_cishu");
        scoreAll = intent.getStringExtra("scoreAll");
        flag = intent.getStringExtra("flag");
        Title.setText(title);
//        判断是否开始作业
        if (scoreAll != null) {
            XueShengFenS.setText(scoreAll);
        } else {
            XueShengFenS.setText("未开始作业");
        }
//        点击ListView  根据类型 跳转相应的页面
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String hw_type = list.get(position).getHw_type();
                String hw_content = list.get(position).getHw_content();
                double avgScore = list.get(position).getAvgScore();
                switch (hw_type) {
                    case "2":
                        Intent intent1 = new Intent(App.activity, DC_ErJFragment.class);
                        intent1.putExtra("hw_type", hw_type);
                        intent1.putExtra("hw_content", hw_content);
                        intent1.putExtra("avgScore", avgScore);
                        intent1.putExtra("hwid", hwid);
                        startActivity(intent1);
                        break;
                    case "8":
                        Intent intent2 = new Intent(App.activity, DuanY_ErJFragment.class);
                        intent2.putExtra("hw_type", hw_type);
                        intent2.putExtra("hw_content", hw_content);
                        intent2.putExtra("avgScore", avgScore);
                        intent2.putExtra("hwid", hwid);
                        startActivity(intent2);
                        break;
                    case "0":
                        Intent intent3 = new Intent(App.activity, YB_ErJFragment.class);
                        intent3.putExtra("hw_type", hw_type);
                        intent3.putExtra("hw_content", hw_content);
                        intent3.putExtra("avgScore", avgScore);
                        intent3.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(YB_ErJFragment.class).setParams(bundle3);
                        startActivity(intent3);
                        break;
                    case "1":
//                        bundle4 = new Bundle();
                        Intent intent4 = new Intent(App.activity, Kw_ErJFragment.class);
                        intent4.putExtra("hw_type", hw_type);
                        intent4.putExtra("hw_content", hw_content);
                        intent4.putExtra("avgScore", avgScore);
                        intent4.putExtra("hwid", hwid);
                        startActivity(intent4);
//                        FragmantBuilder.getInstance().start(Kw_ErJFragment.class).setParams(bundle4);
                        break;
                    case "3":
//                        Juz_ErJFragment zy_juZ_fragment = new Juz_ErJFragment();
//                        bundle5 = new Bundle();
                        Intent intent5 = new Intent(App.activity, Juz_ErJFragment.class);
                        intent5.putExtra("hw_type", hw_type);
                        intent5.putExtra("hw_content", hw_content);
                        intent5.putExtra("avgScore", avgScore);
                        intent5.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(Juz_ErJFragment.class).setParams(bundle5);
                        startActivity(intent5);
                        break;
                    case "6":
//                        bundle6 = new Bundle();
                        Intent intent6 = new Intent(App.activity, YueD_ErJFragment.class);
                        intent6.putExtra("hw_type", hw_type);
                        intent6.putExtra("hw_content", hw_content);
                        intent6.putExtra("avgScore", avgScore);
                        intent6.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(YueD_ErJFragment.class).setParams(bundle6);
                        startActivity(intent6);
                        break;

                    case "4":
//                        bundle7 = new Bundle();
                        Intent intent7 = new Intent(App.activity, DuiH_ErJFragment.class);
                        intent7.putExtra("hw_type", hw_type);
                        intent7.putExtra("hw_content", hw_content);
                        intent7.putExtra("avgScore", avgScore);
                        intent7.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(DuiH_ErJFragment.class).setParams(bundle7);
                        startActivity(intent7);
                        break;

                    case "5":
                        MyLog.e("听力类型ID", list.get(position).getListenType() + "");
                        if (list.get(position).getListenType() != null) {

                            switch (list.get(position).getListenType()) {
                                case "1":
                                    Intent intent8 = new Intent(App.activity, TingL_XZ_ErJFragment.class);
                                    intent8.putExtra("hw_type", hw_type);
                                    intent8.putExtra("hw_content", hw_content);
                                    intent8.putExtra("avgScore", avgScore);
                                    intent8.putExtra("hwid", hwid);
                                    startActivity(intent8);
                                    break;
                                case "2":
                                    Intent intent9 = new Intent(App.activity, TingL_TK_ErJFragment.class);
                                    intent9.putExtra("hw_type", hw_type);
                                    intent9.putExtra("hw_content", hw_content);
                                    intent9.putExtra("avgScore", avgScore);
                                    intent9.putExtra("hwid", hwid);
                                    startActivity(intent9);
                                    break;
                            }
                        }
                        break;
                }
            }
        });


    }
    public void initData() {

        Uri uri = getIntent().getData();
        if (uri != null) {
            String url = uri.toString();
            String p1 = uri.getQueryParameter("param1");
            String p2 = uri.getQueryParameter("param2");


            MyLog.e("得到的参数", url + p1 + p2 + "");

        }

    }


    public void loadData() {
//        开启网络请求 初始化 presenter
        presenter = new Zuoye_erji_list_Presenter(this);
        presenter.SetU(hwid, homework_cishu, flag, scoreAll);
    }


    @Override
    public void getManager(ZuoY_list_Bean listBean) {
    }

    @Override
    public void getManagZuoY(ZuoY_erJ_Bean erJ_bean) {
//        添加数据
        list.addAll(erJ_bean.getData().getHomeworkType());
//        在主线程中操作
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                初始化 adapter 创建item
                adapter = new ZY_ml_Adapter(list, App.activity);
                ListView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Zuoy_Cotract.Presenter presenter) {

    }


    @OnClick({R.id.back_jt, R.id.ChaK_XQ, R.id.statr_ZY})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:

                this.onBackPressed();

                break;
            case R.id.ChaK_XQ:

                Intent intent = new Intent(this, ZuoY_Activity.class);
                intent.putExtra("hwid", hwid);
                startActivity(intent);

                break;
            case R.id.statr_ZY:
//                Intent intent1 = new Intent(this, ZY_Kw_Activity.class);
//                intent1.putExtra("title", title);
//                intent1.putExtra("hwid", hwid);
//                startActivity(intent1);


                String hw_content = list.get(0).getHw_content();
                double avgScore = list.get(0).getAvgScore();

                String hw_type = list.get(0).getHw_type();
                String listenType = list.get(0).getListenType();
                switch (hw_type) {
                        case "2":
                            Intent intent1 = new Intent(App.activity, DC_ErJFragment.class);
                            intent1.putExtra("hw_type", hw_type);
                            intent1.putExtra("hw_content", hw_content);
                            intent1.putExtra("avgScore", avgScore);
                            intent1.putExtra("hwid", hwid);
                            startActivity(intent1);
                            break;
                        case "8":
                            Intent intent2 = new Intent(App.activity, DuanY_ErJFragment.class);
                            intent2.putExtra("hw_type", hw_type);
                            intent2.putExtra("hw_content", hw_content);
                            intent2.putExtra("avgScore", avgScore);
                            intent2.putExtra("hwid", hwid);
                            startActivity(intent2);
                            break;
                        case "0":
                            Intent intent3 = new Intent(App.activity, YB_ErJFragment.class);
                            intent3.putExtra("hw_type", hw_type);
                            intent3.putExtra("hw_content", hw_content);
                            intent3.putExtra("avgScore", avgScore);
                            intent3.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(YB_ErJFragment.class).setParams(bundle3);
                            startActivity(intent3);
                            break;
                        case "1":
//                        bundle4 = new Bundle();
                            Intent intent4 = new Intent(App.activity, Kw_ErJFragment.class);
                            intent4.putExtra("hw_type", hw_type);
                            intent4.putExtra("hw_content", hw_content);
                            intent4.putExtra("avgScore", avgScore);
                            intent4.putExtra("hwid", hwid);
                            startActivity(intent4);
//                        FragmantBuilder.getInstance().start(Kw_ErJFragment.class).setParams(bundle4);
                            break;
                        case "3":
//                        Juz_ErJFragment zy_juZ_fragment = new Juz_ErJFragment();
//                        bundle5 = new Bundle();
                            Intent intent5 = new Intent(App.activity, Juz_ErJFragment.class);
                            intent5.putExtra("hw_type", hw_type);
                            intent5.putExtra("hw_content", hw_content);
                            intent5.putExtra("avgScore", avgScore);
                            intent5.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(Juz_ErJFragment.class).setParams(bundle5);
                            startActivity(intent5);
                            break;
                        case "6":
//                        bundle6 = new Bundle();
                            Intent intent6 = new Intent(App.activity, YueD_ErJFragment.class);
                            intent6.putExtra("hw_type", hw_type);
                            intent6.putExtra("hw_content", hw_content);
                            intent6.putExtra("avgScore", avgScore);
                            intent6.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(YueD_ErJFragment.class).setParams(bundle6);
                            startActivity(intent6);
                            break;

                        case "4":
//                        bundle7 = new Bundle();
                            Intent intent7 = new Intent(App.activity, DuiH_ErJFragment.class);
                            intent7.putExtra("hw_type", hw_type);
                            intent7.putExtra("hw_content", hw_content);
                            intent7.putExtra("avgScore", avgScore);
                            intent7.putExtra("hwid", hwid);
//                        FragmantBuilder.getInstance().start(DuiH_ErJFragment.class).setParams(bundle7);
                            startActivity(intent7);
                            break;

                        case "5":
//                            MyLog.e("听力类型ID", list.get(position).getListenType() + "");
                            if ( listenType!= null) {
                                if (listenType.equals("1")){
                                    Intent intent8 = new Intent(App.activity, TingL_XZ_ErJFragment.class);
                                    intent8.putExtra("hw_type", hw_type);
                                    intent8.putExtra("hw_content", hw_content);
                                    intent8.putExtra("avgScore", avgScore);
                                    intent8.putExtra("hwid", hwid);
                                    startActivity(intent8);
                                }else if (listenType.equals("2")){
                                    Intent intent9 = new Intent(App.activity, TingL_TK_ErJFragment.class);
                                    intent9.putExtra("hw_type", hw_type);
                                    intent9.putExtra("hw_content", hw_content);
                                    intent9.putExtra("avgScore", avgScore);
                                    intent9.putExtra("hwid", hwid);
                                    startActivity(intent9);
                                }
                            }
                            break;
                    }
                }
        }
    @OnClick(R.id.XueShengFenS)
    public void onViewClicked() {
    }


}
