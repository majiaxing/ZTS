package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.TianK_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/22.
 */
public class TingL_TK_Fragment extends BaseFragment {


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
    @BindView(R.id.Xz_list)
    ListView XzList;
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

    private Bundle bundle;
    private ArrayList<TingL_XQ_xz_Bean.DataBean> mlist = new ArrayList<>();
    private TianK_Adapter listadapter;

    @Override
    protected int getLayoutId() {
        return R.layout.tingl_tk_fragment;
    }

    @Override
    protected void init(View view) {


        ArrayList<TingL_XQ_xz_Bean.DataBean> list = (ArrayList<TingL_XQ_xz_Bean.DataBean>) bundle.getSerializable("list");

        String listen_text = list.get(0).getListen_text();


//        String title = bundle.getString("title");

        TMTitle.setText(listen_text);

        mlist.addAll(list);

        listadapter = new TianK_Adapter(App.activity, mlist);

        XzList.setAdapter(listadapter);


        JX.setVisibility(View.GONE);
        ChongZ.setVisibility(View.GONE);
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

    @OnClick({R.id.BF_zt, R.id.TJ_Xyt, R.id.next_T,R.id.XYT, R.id.ChongZ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BF_zt:
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
