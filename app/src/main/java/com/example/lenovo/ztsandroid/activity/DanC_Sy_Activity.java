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
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_Danc_Adapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.DanC_Cotract;
import com.example.lenovo.ztsandroid.fragment.DanCi_fragment;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.presenter.DanC_Presenter;
import com.example.lenovo.ztsandroid.utils.ACache;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class DanC_Sy_Activity extends BaseActivity implements DanC_Cotract.View ,DanCi_fragment.FragmentToActivity {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.Text_XX)
    TextView TextXX;
    @BindView(R.id.linear)
    LinearLayout linear;

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
    private ACache cache;
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
        presenter.SetUrl(extra, type);
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

    @OnClick({R.id.back_jt, R.id.linear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                BackPopupUtils.PopupW(view, "确认退出单词学习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.linear:
                upPopupWindow(TextXX);
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
                    bundle.putString("word", dcXqBean.getData().get(i).getWord());
                    bundle.putString("word_tran", dcXqBean.getData().get(i).getWord_tran());

                    bundle.putString("Relative_path", dcXqBean.getData().get(i).getRelative_path());
                    bundle.putString("word_video", dcXqBean.getData().get(i).getWord_video());

                    bundle.putString("word_id", dcXqBean.getData().get(i).getWord_id());
                    bundle.putString("type", dcXqBean.getData().get(i).getType());
                    bundle.putString("yema",dcXqBean.getData().size() +"");
                    bundle.putString("dangq",i+1+"");
                    danCi_fragment.setParams(bundle);
                    list.add(danCi_fragment);
                }

                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);

                viewPager.setAdapter(adapter);
                nlist.addAll(dcXqBean.getData());

            }
        });
    }

    @Override
    public void showmessage(String str) {

        cache=ACache.get(App.activity);
        final Dc_Xq_Bean list1 = (Dc_Xq_Bean)cache.getAsObject("Dc_Xq_Bean");

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < list1.getData().size(); i++) {
                    DanCi_fragment danCi_fragment = new DanCi_fragment();
                    bundle = new Bundle();
                    bundle.putString("word", list1.getData().get(i).getWord());
                    bundle.putString("word_tran", list1.getData().get(i).getWord_tran());

                    bundle.putString("Relative_path", list1.getData().get(i).getRelative_path());
                    bundle.putString("word_video", list1.getData().get(i).getWord_video());

                    bundle.putString("word_id", list1.getData().get(i).getWord_id());
                    bundle.putString("type", list1.getData().get(i).getType());

                    danCi_fragment.setParams(bundle);
                    list.add(danCi_fragment);
                }

                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
                viewPager.setAdapter(adapter);

                nlist.addAll(list1.getData());
            }
        });


    }

    @Override
    public void setBasePresenter(DanC_Cotract.Presenter presenter) {

    }

    @Override
    public void huidiao(String str) {
        // 回调函数 取值
//        Toast.makeText(getApplicationContext(),"我是 Fragment3 回调函数执行了",Toast.LENGTH_SHORT).show();
        title.setText(str);
    }
}
