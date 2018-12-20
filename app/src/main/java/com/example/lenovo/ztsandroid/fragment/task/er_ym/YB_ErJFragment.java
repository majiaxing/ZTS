package com.example.lenovo.ztsandroid.fragment.task.er_ym;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.ZY_Yb_Fragment;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/29.
 */
public class YB_ErJFragment extends BaseActivity {

    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.LeiXin)
    TextView LeiXin;
    @BindView(R.id.YeShu)
    TextView YeShu;
    @BindView(R.id.Zongyeshu)
    TextView Zongyeshu;
    @BindView(R.id.LeiX)
    RelativeLayout LeiX;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;
    private ArrayList<Fragment> nlist = new ArrayList<>();
    private ViewPagerAdapter adapter;

    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.zy_dc_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

//    @Override
//    protected void init(View view) {
//
//
//
//        String typeList = bundle.getString("data");
//
//
//        MyLog.e("List数据", typeList + "");
//
//        JsonDemo(typeList);
//
//
////        for (int i = 0;i<list.size(); i++){
////
////            ZY_Yb_Fragment zyDanCFragment = new ZY_Yb_Fragment();
////            bundle.putSerializable("list",list.get(i).getYb_word());
////            zyDanCFragment.setParams(bundle);
////            nlist.add(zyDanCFragment);
////
////        }
//    }


    private void JsonDemo(String string) {
//
//        Gson gson = new Gson();
//        java.lang.reflect.Type type = new TypeToken<ZuoY_dc_Bean>() {}.getType();
//        ZuoY_dc_Bean jsonBean = gson.fromJson(string, type);
//        List<ZuoY_dc_Bean.TypeListBean> list = jsonBean.getTypeList();
//        for (int i = 0; i<  list.size(); i++){
//            Zy_Dc_Fragment zuYYinBFragment = new Zy_Dc_Fragment();
//                bundle = new Bundle();
//                bundle.putString("DanCy",list.get(i).getWord());
//                bundle.putString("DanCz",list.get(i).getWord_tran());
//
//                MyLog.e("解析出来的单词数据",list.get(i).getWord() + "");
//
//                zuYYinBFragment.setParams(bundle);
//                nlist.add(zuYYinBFragment);
//        }


        //第一步，string参数相当于一个JSON,依次解析下一步
        JSONArray json = null;
        JSONObject data = null;
        try {
            data = new JSONObject(string);

            JSONArray typeList = data.getJSONArray("typeList");


            for (int a = 0; a < typeList.length(); a++) {

                JSONObject value = null;

                value = typeList.getJSONObject(a);

                String word = value.optString("yb_word");
                String word_tran = value.optString("yb_translate");


                ZY_Yb_Fragment zuYYinBFragment = new ZY_Yb_Fragment();
                bundle = new Bundle();
                bundle.putString("DanCy", word);
                bundle.putString("DanCz", word_tran);

                MyLog.e("解析到的数据", word + word_tran);

                zuYYinBFragment.setParams(bundle);
                nlist.add(zuYYinBFragment);
            }

            adapter = new ViewPagerAdapter(getSupportFragmentManager(), nlist);
            viewPager.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
