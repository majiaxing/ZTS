package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.Qrdd_Activity;
import com.example.lenovo.ztsandroid.activity.YB_XQ_Activity;
import com.example.lenovo.ztsandroid.adapter.Yb_Grid_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/5.
 */

public class BYY_Fragment extends BaseFragment {


    @BindView(R.id.Yb_grid_view)
    GridView YbGridView;
    Unbinder unbinder;
    private ArrayList<Spinner_Bean> list = new ArrayList<>();
    private Yb_Grid_Adapter myadapter;

    @Override
    protected int getLayoutId() {
        return R.layout.yb_sy_fragment;
    }

    @Override
    protected void init(View view) {
        list.add(new Spinner_Bean("i:"));
        list.add(new Spinner_Bean("i"));
        list.add(new Spinner_Bean("e"));
        list.add(new Spinner_Bean("ə:"));
        list.add(new Spinner_Bean("a:"));
        list.add(new Spinner_Bean("æ"));

//        myadapter = new Yb_Grid_Adapter(App.activity, list);
//        YbGridView.setAdapter(myadapter);

        YbGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String  yb = list.get(i).getPersonName();
//                Intent intent = new Intent(App.activity,YB_XQ_Activity.class);
//                intent.putExtra("音标",yb);
//                startActivity(intent);
            }
        });

    }

    @Override
    protected void loadData() {

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
