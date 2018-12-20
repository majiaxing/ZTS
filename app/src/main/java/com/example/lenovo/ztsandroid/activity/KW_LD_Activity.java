package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.erji_list.DuiH_NeiR_Activity;
import com.example.lenovo.ztsandroid.activity.erji_list.Jz_NeiR_Activity;
import com.example.lenovo.ztsandroid.activity.erji_list.Kw_NeiR_Activity;
import com.example.lenovo.ztsandroid.activity.erji_list.Read_erj_Activity;
import com.example.lenovo.ztsandroid.activity.erji_list.Tingl_NeiR_Activity;
import com.example.lenovo.ztsandroid.adapter.Kw_Ld_Adapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.presenter.KeW_list_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class KW_LD_Activity extends BaseActivity implements KeW_list_Cotract.View{

    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.KeWen_Listview)
    GridView KeWenListview;
    @BindView(R.id.title)
    TextView title;
    private Kw_Ld_Adapter myadapter;
    private ArrayList<Kw_Bean.DataBean> list = new ArrayList<>();
    private String extra;
    private KeW_list_Cotract.Presenter presenter;
    private String jclx;
    private String nj_jc;
    private String sxc;
    private String listen_type;

    @Override
    protected int getLayoutId() {
        return R.layout.kew_ld_activity;

    }


    @Override
    protected void initView() {

        final Intent intent = getIntent();
        extra = intent.getStringExtra("title");
        MyLog.e("lalalalallsahduaw",extra);
        jclx = intent.getStringExtra("教材");
        nj_jc = intent.getStringExtra("年级");
        sxc = intent.getStringExtra("上下册");
        listen_type = intent.getStringExtra("listen_type");
        Log.e("获取到的数据", jclx + nj_jc + sxc);
        MyLog.e("略略略",listen_type+" ");
        String stuid = String.valueOf(App.stuid);
        switch (extra){
            case "text":
                title.setText("课文");
                new KeW_list_Presenter(this);
                presenter.SetUrl(jclx,nj_jc,sxc,extra,null,stuid);
                break;

            case "word":
                title.setText("单词");
                new KeW_list_Presenter(this);
                presenter.SetUrl(jclx,nj_jc,sxc,extra,null,stuid);
                break;

            case "phrase":
                title.setText("短语");
                new KeW_list_Presenter(this);
                presenter.SetUrl(jclx,nj_jc,sxc,extra,null,stuid);
                break;
            case "sentence":
                title.setText("句子");
                new KeW_list_Presenter(this);
                presenter.SetUrl(jclx,nj_jc,sxc,extra,null,stuid);
                break;
            case "talk":
                title.setText("对话");
                new KeW_list_Presenter(this);
                presenter.SetUrl(jclx,nj_jc,sxc,extra,null,stuid);
                break;

            case "listen":


                    switch (listen_type){
                        case "1":
                            new KeW_list_Presenter(this);
                              presenter.SetUrl(jclx,nj_jc,sxc,extra,"1",stuid);
                             MyLog.e("lalla",listen_type);
                            title.setText("听力选择");
                            break;
                        case "2":
                            new KeW_list_Presenter(this);
                             presenter.SetUrl(jclx, nj_jc, sxc, extra, "2", stuid);
                             MyLog.e("lalla",listen_type);
                            title.setText("听力填空");

                            break;
                    }
                break;

            case "read":
                title.setText("阅读");
                new KeW_list_Presenter(this);
                presenter.SetUrl(jclx,nj_jc,sxc,extra,null,stuid);
            break;
        }


                KeWenListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                     String dy = list.get(i).getDy();
                String type = list.get(i).getType();

                switch (extra){

                    case "text":
                        Intent intent1 = new Intent(App.activity, Kw_NeiR_Activity.class);
                        intent1.putExtra("title", dy);
                        intent1.putExtra("type",type);
                        intent1.putExtra("extra",extra);
                        startActivity(intent1);
                        break;

                    case "word":
                        Intent intent7 = new Intent(App.activity, DanC_Sy_Activity.class);
                        intent7.putExtra("type",type);
                        intent7.putExtra("extra",extra);

                        startActivity(intent7);
                        break;

                    case "phrase":

                        Intent intent2 = new Intent(App.activity, DuanYu_Sy_Activity.class);
                        intent2.putExtra("title", dy);
                        intent2.putExtra("type",type);
                        intent2.putExtra("extra",extra);
                        startActivity(intent2);
                        break;
                    case "sentence":
                        Intent intent3 = new Intent(App.activity, Jz_NeiR_Activity.class);
                        intent3.putExtra("title", dy);
                        intent3.putExtra("type",type);
                        intent3.putExtra("extra",extra);
                        startActivity(intent3);
                        break;
                    case "talk":
                        Intent intent4 = new Intent(App.activity, DuiH_NeiR_Activity.class);
                        intent4.putExtra("title", dy);
                        intent4.putExtra("type",type);
                        intent4.putExtra("extra",extra);
                        startActivity(intent4);
                        break;

                    case "listen":

                        switch (listen_type){
                            case "1":
                                Intent intent5 = new Intent(App.activity, Tingl_NeiR_Activity.class);
                                intent5.putExtra("title", dy);
                                intent5.putExtra("type",type);
                                intent5.putExtra("extra",extra);
                                intent5.putExtra("listen_type",listen_type);
                                startActivity(intent5);

                                break;
                            case "2":
                                Intent intent6 = new Intent(App.activity, Tingl_NeiR_Activity.class);
                                intent6.putExtra("title", dy);
                                intent6.putExtra("type",type);
                                intent6.putExtra("extra",extra);
                                intent6.putExtra("listen_type",listen_type);
                                startActivity(intent6);

                                break;
                        }

                        break;

                    case "read":

                        Intent intent8 = new Intent(App.activity, Read_erj_Activity.class);
                        intent8.putExtra("title", dy);
                        intent8.putExtra("type",type);
                        intent8.putExtra("extra",extra);
                        startActivity(intent8);


                        break;


                }


//
//

            }
        });


    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick(R.id.back_jt)
    public void onViewClicked() {
        App.activity.onBackPressed();
    }

    @Override
    public void getManager(Kw_Bean kw_bean) {



            Log.e("huoqudaode shuji",kw_bean.toString() +"");

            list.addAll(kw_bean.getData());


            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    myadapter = new Kw_Ld_Adapter(App.activity, list);
                    KeWenListview.setAdapter(myadapter);
                    myadapter.notifyDataSetChanged();
                }
            });

//        {"jclx":"人教版","sxc":"上册","nj":"一年级","flag":"text"}
//        {"jclx":"人教版","sxc":"下册","nj":"一年级","flag":"text"}

//        {"jclx":"人教版","sxc":"上册","nj":"一年级","flag":"text"}
    }

    @Override
    public void getKw_erjlist(Kw_erji_list_Bean kw_erji_list_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(KeW_list_Cotract.Presenter presenter) {
            this.presenter =presenter;
    }
}
