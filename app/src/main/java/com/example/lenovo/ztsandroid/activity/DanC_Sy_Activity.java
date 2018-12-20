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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.DanC_Adapter;
import com.example.lenovo.ztsandroid.adapter.List_Danc_Adapter;
import com.example.lenovo.ztsandroid.adapter.List_popup_Adapter;
import com.example.lenovo.ztsandroid.adapter.LunBotuAdapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.adapter.lutuAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.DanC_Cotract;
import com.example.lenovo.ztsandroid.fragment.DanCi_fragment;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.presenter.DanC_Presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;
import com.example.lenovo.ztsandroid.utils.Xuanz_NR_Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class DanC_Sy_Activity extends BaseActivity implements DanC_Cotract.View{


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private PopupWindow popupWindow;
    private ArrayList<Dc_Xq_Bean.DataBean> nlist = new ArrayList<>();
    private List_Danc_Adapter Gadapter;
    private ListView listView;
    private DanC_Cotract.Presenter presenter;
    private String type;
    private String extra;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.yuy_kewld_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        extra = intent.getStringExtra("extra");



    }

    @Override
    public void initData() {

    }


    @Override
    public void loadData() {
        presenter = new DanC_Presenter(this);
        presenter.SetUrl(extra,type);
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

        Gadapter = new List_Danc_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title.setText(nlist.get(position).getWord());
                Log.e("点击传上去的数据", nlist.get(position).getWord());
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
    public void getManager(final Dc_Xq_Bean dcXqBean) {


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < dcXqBean.getData().size(); i++) {
                    DanCi_fragment danCi_fragment = new DanCi_fragment();
                    bundle = new Bundle();
                    bundle.putString("word",dcXqBean.getData().get(i).getWord());
                    bundle.putString("word_tran",dcXqBean.getData().get(i).getWord_tran());

                    bundle.putString("Relative_path",dcXqBean.getData().get(i).getRelative_path());
                    bundle.putString("word_video",dcXqBean.getData().get(i).getWord_video());

                    bundle.putString("word_id",dcXqBean.getData().get(i).getWord_id());
                    bundle.putString("type",dcXqBean.getData().get(i).getType());

                    danCi_fragment.setParams(bundle);
                    list.add(danCi_fragment);
                }

                adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
                viewPager.setAdapter(adapter);



                nlist.addAll(dcXqBean.getData());


            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(DanC_Cotract.Presenter presenter) {

    }
}