package com.example.lenovo.ztsandroid.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.XiaoX_XQ_Activity;
import com.example.lenovo.ztsandroid.adapter.XX_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.cotract.XX_xq_Cotract;
import com.example.lenovo.ztsandroid.model.entity.XX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.presenter.XX_xq_Presenter;
import com.example.lenovo.ztsandroid.presenter.XiaoX_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/15.
 */
public class QuanB_XX_Fragment extends BaseFragment implements XX_xq_Cotract.View{


    @BindView(R.id.WeiD_XX)
    ListView WeiDXX;
    Unbinder unbinder;
    private XX_Adapter myadapter;
    private ArrayList<XiaoX_Bean.DataBean> list = new ArrayList<>();
    private Bundle bundle;
    private View bottom;
    private TextView tv;
    private ProgressBar pb;
    private XX_xq_Cotract.Presenter presenter;
    private String newtype;
    private String newcontent;
    //监听来源
    public boolean mIsFromItem = false;
    private ArrayList<Map<String,String>> id = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.weidu_xx_fragment;
    }

    @Override
    protected void init(View view) {
        presenter = new XX_xq_Presenter(this);
        //获取底部含有加载条的布局view
       View below = getActivity().getLayoutInflater().inflate(R.layout.bottom, null);
        tv = below.findViewById(R.id.textView);
        pb = below.findViewById(R.id.progressBar1);


        myadapter = new XX_Adapter(App.activity, list, new AllCheckListener() {
            @Override
            public void onCheckedChanged(boolean b) {
            }
        });
        WeiDXX.setAdapter(myadapter);

        WeiDXX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MyLog.e("dsadsahdaweqqqq","asdasdakldhw");
                int id1 = list.get(position).getId();
                presenter.SetUrl(id1+"");
                View view1 = WeiDXX.getChildAt(position);
                TextView textView = view1.findViewById(R.id.Wd_Ts);
                if (textView.getVisibility() != View.GONE){
                    textView.setVisibility(View.GONE);
                }
            }
        });
    }

    public void isShow(Boolean b){
        myadapter.onClickeListener(b);
    }

   public void onShow(Boolean b){

        if (b){
            //当监听来源为点击item改变maincbk状态时不在监听改变，防止死循环
            if (mIsFromItem) {
                mIsFromItem = false;
                Log.e("mainCheckBox", "此时我不可以触发");
                return;
            }
            //改变数据
            for (XiaoX_Bean.DataBean model : list) {
                model.setIscheck(b);
            }
            //刷新listview
            myadapter.notifyDataSetChanged();
        }

    }

    public ArrayList<Map<String,String>> XXID(){
//        for (int i= 0;i<list.size();i++){
//            if (list.get(i).ischeck()){
//                Map<String, String> hashMap = new HashMap<>();
//                hashMap.put("id", String.valueOf(list.get(i).getId()));
//                id.add(hashMap);
//            }
//        }
//        MyLog.e("要回调的ID",id.toString() + "");

        String id1 = myadapter.onClickeID();
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("id",id1);
        id.add(hashMap);

        return this.id;
    }

    public void delete(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ischeck()){
                list.remove(i);
            }
        }
        myadapter.notifyDataSetChanged();
    }

    public void changeIsRead(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ischeck()){
                //设置已读
            }
        }
        myadapter.notifyDataSetChanged();
    }

    @Override
    protected void loadData() {

        ArrayList<XiaoX_Bean.DataBean> groups = (ArrayList<XiaoX_Bean.DataBean>) bundle.getSerializable("list");

        MyLog.e("传过来的数据",groups.toString());

        list.addAll(groups);

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

//ListView分页加载数据
//    @Override
//    public void getManager(XiaoX_Bean xiaoX_bean) {
//
//
//
//    }
//
    @Override
    public void getManager(XX_xq_Bean xx_xq_bean) {

        newtype = xx_xq_bean.getData().getNewtype();
        newcontent = xx_xq_bean.getData().getNewcontent();

        Intent intent = new Intent(App.activity, XiaoX_XQ_Activity.class);
        intent.putExtra("时间",xx_xq_bean.getData().getNewtime());
        intent.putExtra("标题",newtype);
        intent.putExtra("内容",newcontent);
        startActivity(intent);
    }


    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(XX_xq_Cotract.Presenter presenter) {

    }

    public interface AllCheckListener {
        void onCheckedChanged(boolean b);
    }


}
