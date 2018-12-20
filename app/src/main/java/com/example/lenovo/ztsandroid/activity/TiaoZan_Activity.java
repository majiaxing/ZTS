package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_Danc_Adapter;
import com.example.lenovo.ztsandroid.adapter.Tiaoz_Adapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.DanC_Cotract;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.fragment.DanCi_fragment;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.presenter.DanC_Presenter;
import com.example.lenovo.ztsandroid.presenter.YB_One_Xq_Presenter;
import com.example.lenovo.ztsandroid.presenter.YB_Tiaoz_Presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/12/7.
 */
public class TiaoZan_Activity extends BaseActivity implements YB_XiangQ_Cotract.View {



    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private PopupWindow popupWindow;
    private ArrayList<YB_XQ_one_Bean.DataBean> nlist = new ArrayList<>();
    private Tiaoz_Adapter Gadapter;
    private ListView listView;
    private YB_XiangQ_Cotract.Presenter presenter;
    private String type;
    private String extra;
    private Bundle bundle;
    @Override
    protected int getLayoutId() {
        return R.layout.yb_tzyx;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        String yb_id = intent.getStringExtra("YB_id");

        presenter = new YB_Tiaoz_Presenter(this);
        presenter.SetU(yb_id, "1");
    }

    @Override
    public void initData() {
    }


    @Override
    public void loadData() {

    }

    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupView(View v) {

        listView = v.findViewById(R.id.popup_listview);

        Gadapter = new Tiaoz_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title.setText(nlist.get(position).getYb_word());
                Log.e("点击传上去的数据", nlist.get(position).getYb_word());
                popupWindow.dismiss();
                Gadapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_jt, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                BackPopupUtils.PopupW(view, "确认退出单词学习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.title:
                upPopupWindow(view);
                break;
        }
    }



    @Override
    public void getManager(YB_XQ_four_Bean yb_bean) {

    }

    @Override
    public void getManagerO(final YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerR(final YB_XQ_one_Bean yb_xq_one_bean) {

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < yb_xq_one_bean.getData().size(); i++) {
                    DanCi_fragment danCi_fragment = new DanCi_fragment();
                    bundle = new Bundle();
                    bundle.putString("word",yb_xq_one_bean.getData().get(i).getYb_word());
                    bundle.putString("word_tran",yb_xq_one_bean.getData().get(i).getYb_translate());
                    danCi_fragment.setParams(bundle);
                    list.add(danCi_fragment);
                }
                adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
                viewPager.setAdapter(adapter);



                nlist.addAll(yb_xq_one_bean.getData());


            }
        });
    }

    @Override
    public void getManagerTh(YB_XQ_three_Bean postYinB_XQ_three) {

    }

    @Override
    public void showmessage(String str) {

    }




    @Override
    public void setBasePresenter(YB_XiangQ_Cotract.Presenter presenter) {

    }
}
