package com.example.lenovo.ztsandroid.fragment.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.DuiH_Sy_Activity;
import com.example.lenovo.ztsandroid.activity.ZuoYml_Activity;
import com.example.lenovo.ztsandroid.adapter.ZY_lsit_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.Zuoy_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;
import com.example.lenovo.ztsandroid.presenter.ZuoY_List_Presenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/23.
 */

public class Task_bj_Fragment extends BaseFragment implements Zuoy_Cotract.View{


    @BindView(R.id.List_view)
    android.widget.ListView ListView;
    private ArrayList<ZuoY_list_Bean.DataBean> list = new ArrayList<>();
    private ZY_lsit_Adapter adapter;
    private Zuoy_Cotract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.bj_zy_fragment;
    }

    @Override
    protected void init(View view) {

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String  Xx = list.get(position).getHomewordName();
                String hwid = list.get(position).getHwid();
                String flag = list.get(position).getFlag();
                String homework_cishu = list.get(position).getHomework_cishu();
                String scoreAll = list.get(position).getScoreAll();
                Intent intent = new Intent(App.activity,ZuoYml_Activity.class);
                intent.putExtra("hwid",hwid);
                intent.putExtra("flag",flag);
                intent.putExtra("homework_cishu",homework_cishu);
                intent.putExtra("scoreAll",scoreAll);
                intent.putExtra("title",Xx);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void loadData() {
    presenter = new ZuoY_List_Presenter(this);
    presenter.SetUrl(App.stuid);
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

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }


    @Override
    public void getManager(ZuoY_list_Bean listBean) {

        if (listBean.getData() == null){
            return;
        }
        list.addAll(listBean.getData());

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                adapter = new ZY_lsit_Adapter(list, App.activity);
                ListView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void getManagZuoY(ZuoY_erJ_Bean erJ_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Zuoy_Cotract.Presenter presenter) {

    }
}
