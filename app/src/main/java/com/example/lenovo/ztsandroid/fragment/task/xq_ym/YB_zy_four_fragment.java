package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.activity.ZuoY_TiaoZan_Activity;
import com.example.lenovo.ztsandroid.adapter.Zm_zh_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Two_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_YB_Four_presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YB_zy_four_fragment extends BaseFragment implements ZuoY_Yb_Cotract.View{

    @BindView(R.id.Grid_ZM_he)
    RecyclerView GridZMHe;
    @BindView(R.id.TZ_YX_o)
    Button TZYXO;
    Unbinder unbinder;
    private Zm_zh_Adapter myadapter;
    private LetterGroupAdapter letterGroupAdapter;
    private ArrayList<YB_Zy_four_Bean.DataBean.TypeListBean> list = new ArrayList<>();
    private Bundle bundle;
    private String yBid;
    private ZuoY_Yb_Cotract.Presenter presenter;
    private String hw_answerId;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;

    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_four_fragment;
    }

    @Override
    protected void init(View view) {

        yBid = bundle.getString("YBid");
        letterGroupAdapter =new LetterGroupAdapter(R.layout.zm_zh_grid_item,list);
        GridZMHe.setLayoutManager(new GridLayoutManager(getActivity(),2));
        GridZMHe.setAdapter(letterGroupAdapter);

        hw_answerId = bundle.getString("hw_answerId");
        hw_type = bundle.getString("hw_type");
        hw_content = bundle.getString("hw_content");
        hwid = bundle.getString("hwid");
        avgScores = bundle.getString("avgScores");


    }

    @Override
    protected void loadData() {
    presenter = new ZuoY_YB_Four_presenter(this);
        presenter.SetUrl(App.stuid, hwid,"4","", hw_type, hw_content, avgScores,"");
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

    @OnClick(R.id.TZ_YX_o)
    public void onViewClicked() {

        Intent intent = new Intent(App.activity,ZuoY_TiaoZan_Activity.class);
        intent.putExtra("hw_type",hw_type);
        intent.putExtra("hw_content",hw_content);
        intent.putExtra("hwid",hwid);
        intent.putExtra("avgScores",avgScores);
        startActivity(intent);


    }

//    @Override
//    public void getManager(YB_XQ_four_Bean yb_bean) {
//        list.addAll(yb_bean.getData());
//        App.activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                letterGroupAdapter.notifyDataSetChanged();
//            }
//        });
//    }


    @Override
    public void getManagerOne(YB_Zy_One_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTwo(YB_Zy_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerThree(YB_Zy_Three_Bean yb_xq_three_bean) {

    }

    @Override
    public void getManagerFour(YB_Zy_four_Bean yb_xq_four_bean) {

        if (list == null){
            list.addAll(yb_xq_four_bean.getData().getTypeList());
        }else {
            list.clear();
            list.addAll(yb_xq_four_bean.getData().getTypeList());
        }


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                letterGroupAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(ZuoY_Yb_Cotract.Presenter presenter) {

    }


    public class LetterGroupAdapter extends BaseQuickAdapter<YB_Zy_four_Bean.DataBean.TypeListBean, BaseViewHolder> {
        public LetterGroupAdapter(int layoutResId, List data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, YB_Zy_four_Bean.DataBean.TypeListBean item) {
            helper.setText(R.id.zm_item,item.getYb_symbol());
            for (int i = 0; i < item.getWord().size(); i++) {
                LetterChildAdapter adapter = new LetterChildAdapter(R.layout.yb_nr_item,item.getWord());
                ((RecyclerView)helper.getView(R.id.List_dc_zh_item)).setLayoutManager(new LinearLayoutManager(helper.itemView.getContext()));
                ((RecyclerView)helper.getView(R.id.List_dc_zh_item)).setAdapter(adapter);
            }
        }
    }

    public class LetterChildAdapter extends BaseQuickAdapter<YB_Zy_four_Bean.DataBean.TypeListBean.WordBean, BaseViewHolder> {
        public LetterChildAdapter(int layoutResId, List data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, YB_Zy_four_Bean.DataBean.TypeListBean.WordBean item) {
            helper.setText(R.id.zh_O,item.getYb_sym_word());
            helper.setText(R.id.text_O, String.format("[%s]", item.getYb_sym_tran()));
        }
    }
}
