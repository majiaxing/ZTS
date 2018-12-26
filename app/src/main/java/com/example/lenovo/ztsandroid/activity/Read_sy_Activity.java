package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_YueD_Adapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Read_XQ_Cotract;
import com.example.lenovo.ztsandroid.fragment.Read_fragment;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.presenter.Read_XQ_Presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/22.
 */
public class Read_sy_Activity extends BaseActivity implements Read_XQ_Cotract.View {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.text)
    TextView text;

    private Read_XQ_Cotract.Presenter presenter;
    private String text_id;

    private Bundle bundle;

    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();

    private PopupWindow popupWindow;
    private ArrayList<Spinner_Bean> nlist = new ArrayList<>();
    private List_YueD_Adapter Padapter;
    private GridView grid;


    @Override
    protected int getLayoutId() {
        return R.layout.duany_sy_activity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        text_id = intent.getStringExtra("Read_id");
        String mtitle = intent.getStringExtra("title");
        title.setText(mtitle);

    }

    @Override
    public void initData() {

    }


    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.popup_yuedu, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupView(View v) {

        grid = v.findViewById(R.id.Grid_view);
        Padapter = new List_YueD_Adapter(App.activity, nlist);
        grid.setAdapter(Padapter);
        Padapter.notifyDataSetChanged();
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                title.setText(nlist.get(position).getWord());
//                Log.e("点击传上去的数据", nlist.get(position).getWord());
//                popupWindow.dismiss();
//                nlist.clear();
//                Padapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    public void loadData() {

        presenter = new Read_XQ_Presenter(this);
        presenter.SetUrl(text_id);

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
                BackPopupUtils.PopupW(view, "确认退出阅读练习？退出后将保存进度");
                break;
            case R.id.title:
                upPopupWindow(text);
                break;
        }
    }


    int s = 1;

    @Override
    public void getManager(final Read_XQ_Bean xqBean) {


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < xqBean.getData().size(); i++) {

                    Read_fragment fragment = new Read_fragment();
                    bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) xqBean.getData());
//                    bundle.putString("",xqBean.getData().get(i).getRead_questionList().get().getRead_qid());
                    MyLog.e("准备传过去的数据", xqBean.getData() + "");
                    fragment.setParams(bundle);
                    list.add(fragment);

                    for (int a = 0; a < xqBean.getData().get(i).getRead_questionList().size(); a++) {
                        nlist.add(new Spinner_Bean("" + s));
                        s++;
                        MyLog.e("GridView数据", s + "            ");
                    }


                }

                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
                danciViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Read_XQ_Cotract.Presenter presenter) {

    }
}
