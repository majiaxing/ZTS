package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Read_zy_O_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.Lu_SC_Cotract;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.presenter.Lu_SC_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.OnItemlick;
import com.example.lenovo.ztsandroid.view.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/27.
 */
public class Zy_YueDu_Fragment extends BaseFragment implements Lu_SC_Cotract.View,OnItemlick{


    @BindView(R.id.DuanW_Nr)
    TextView DuanWNr;
    @BindView(R.id.Item_sm)
    TextView textSm;
    @BindView(R.id.Tm_ListView)
    MyListView TmListView;
    @BindView(R.id.Ti_J_ChaK)
    TextView TiJChaK;
    Unbinder unbinder;

    private Bundle bundle;
    private Lu_SC_Cotract.Presenter presenter;
    private ArrayList<Spinner_T_Bean> list = new ArrayList<>();
    private  Read_zy_O_Adapter listadapter ;
    private Boolean misShow;

    private String hw_type;
    private String hw_content;
    private String hwid;
    private String hw_answerId;
    private String everyScore;

    @Override
    protected int getLayoutId() {
        return R.layout.read_feagment;
    }

    @Override
    protected void init(View view) {

        TiJChaK.setVisibility(View.GONE);


        String kWy = bundle.getString("KWy");

        String read_text = bundle.getString("read_text");

        hw_type = bundle.getString("hw_type");
        hw_content = bundle.getString("hw_content");
        hwid = bundle.getString("hwid");

        hw_answerId = bundle.getString("hw_answerId");
        everyScore = bundle.getString("EveryScore");
        MyLog.e("@_@!!!!!!!!!!!", kWy + "" + hw_answerId);

        DuanWNr.setText(kWy);

//
        ArrayList<Spinner_T_Bean> mapO = (ArrayList<Spinner_T_Bean>) bundle.getSerializable("mapO");
        MyLog.e("@@@@@__*__*%%%%!!!!", mapO.size() + "");
        list.addAll(mapO);



        listadapter = new Read_zy_O_Adapter(App.activity, list);
        TmListView.setAdapter(listadapter);
        listadapter.notifyDataSetChanged();
//        TmListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listadapter.setOnItemlick(this);

//        TmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                View view1 = TmListView.getChildAt(position);
//                TextView  checkBoxA= view1.findViewById(R.id.BF_A_Xuanz);
//                TextView  checkBoxB= view1.findViewById(R.id.BF_B_Xuanz);
//                TextView  checkBoxC= view1.findViewById(R.id.BF_C_Xuanz);
//                TextView  checkBoxD= view1.findViewById(R.id.BF_D_Xuanz);
//
//                if (checkBoxA.getVisibility() == View.VISIBLE){
//                    presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
//                    presenter.SetU(App.stuid,hwid,"6",hw_content,hw_answerId,list.get(position).getRead_optionA(),"1",everyScore);
//                } else if (checkBoxB.getVisibility() == View.VISIBLE) {
//                    presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
//                    presenter.SetU(App.stuid,hwid,"6",hw_content,hw_answerId,list.get(position).getRead_optionB(),"1",everyScore);
//                }else if (checkBoxC.getVisibility() == View.VISIBLE){
//                    presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
//                    presenter.SetU(App.stuid,hwid,"6",hw_content,hw_answerId,list.get(position).getRead_optionC(),"1",everyScore);
//                }else if (checkBoxD.getVisibility() == View.VISIBLE){
//                    presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
//                    presenter.SetU(App.stuid,hwid,"6",hw_content,hw_answerId,list.get(position).getRead_optionD(),"1",everyScore);
//                }
//            }
//        });
    }


    public void Onshow(Boolean isShow){

        MyLog.e("aQQQQQ",isShow.toString()+"");

//        listadapter = new Read_zy_O_Adapter(App.activity, list);
//        listadapter.onClickeListener(isShow);
//        listadapter.notifyDataSetChanged();

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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @OnClick(R.id.Ti_J_ChaK)
    public void onViewClicked() {

        App.activity.onBackPressed();

    }


    @Override
    public void getManager(LiY_SC_WJ_Bean xq_bean) {

        MyLog.e("上传答案 成功",xq_bean.getData().getSave_path());

    }

    @Override
    public void getWJSC(SC_YX_Bean sc_yx_bean) {

    }

    @Override
    public void getManager(YuYinPinG_Bean yuYinPinGBean) {

    }

    @Override
    public void getManagerO(String pinC_fay_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Lu_SC_Cotract.Presenter presenter) {

    }

    @Override
    public void onlick(View view,String hw_answerId) {
        switch (view.getId()){
            case R.id.Xuanz_btn_A:
                presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
                presenter.SetU(App.stuid,hwid,hw_type,hw_content,hw_answerId,list.get(0).getRead_optionA(),"80",everyScore);
                break;
            case R.id.Xuanz_btn_B:
                presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
                presenter.SetU(App.stuid,hwid,hw_type,hw_content,hw_answerId,list.get(1).getRead_optionB(),"80",everyScore);
                break;
            case R.id.Xuanz_btn_C:
                presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
                presenter.SetU(App.stuid,hwid,hw_type,hw_content,hw_answerId,list.get(2).getRead_optionC(),"80",everyScore);
                break;
            case R.id.Xuanz_btn_D:
                presenter = new Lu_SC_Presenter(Zy_YueDu_Fragment.this);
                presenter.SetU(App.stuid,hwid,hw_type,hw_content,hw_answerId,list.get(3).getRead_optionD(),"80",everyScore);
                break;
        }
    }
}
