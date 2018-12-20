package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Read_XuanZ_T_Adapter;
import com.example.lenovo.ztsandroid.adapter.Xuanz_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/22.
 */
public class Read_fragment extends BaseFragment {

    @BindView(R.id.DuanW_Nr)
    TextView DuanWNr;
    @BindView(R.id.Item_sm)
    TextView textSm;
    @BindView(R.id.Tm_ListView)
    ListView TmListView;
    @BindView(R.id.Ti_J_ChaK)
    TextView TiJChaK;
    Unbinder unbinder;

    private Bundle bundle;
    private Read_XuanZ_T_Adapter listadapter;
    private ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> mList = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.read_feagment;
    }

    @Override
    protected void init(View view) {


        ArrayList<Read_XQ_Bean.DataBean> list = (ArrayList<Read_XQ_Bean.DataBean>) bundle.getSerializable("list");

        MyLog.e("AASDSADA", list.toString() + "");


        String read_text = list.get(0).getRead_text();
        String read_content = list.get(0).getRead_content();
        List<Read_XQ_Bean.DataBean.ReadQuestionListBean> read_questionList = list.get(0).getRead_questionList();
        mList.addAll(read_questionList);
        DuanWNr.setText(read_content);
        textSm.setText(read_text);

        listadapter = new Read_XuanZ_T_Adapter(App.activity,mList);
        TmListView.setAdapter(listadapter);
        listadapter.notifyDataSetChanged();

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
}
