package com.example.lenovo.ztsandroid.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.Read_XuanZ_T_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.Read_XQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Read_TJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.presenter.Read_TJ_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.view.MyListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/22.
 */
public class Read_fragment extends BaseFragment implements Read_XQ_Cotract.View ,View.OnClickListener{

    @BindView(R.id.DuanW_Nr)
    TextView DuanWNr;
    @BindView(R.id.Item_sm)
    TextView ItemSm;
    @BindView(R.id.Tm_ListView)
    MyListView TmListView;
    @BindView(R.id.Ti_J_ChaK)
    TextView TiJChaK;


    private Bundle bundle;
    private Read_XuanZ_T_Adapter listadapter;
    private ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> mList = new ArrayList<>();
    private Read_XQ_Cotract.Presenter presenter;
    private String Read_id;
    private String type;
    private String jsonImgList;
    private PopupWindow popupWindow1 ,popupWindow2;
    private Button G_mai, E_ka;
    private TextView text;
    private LinearLayout fanH;


    @Override

    protected int getLayoutId() {
        return R.layout.read_feagment;
    }

    @Override
    protected void init(View view) {

        Read_id = bundle.getString("Read_id");
        type = bundle.getString("type");
        ArrayList<Read_XQ_Bean.DataBean> list = (ArrayList<Read_XQ_Bean.DataBean>) bundle.getSerializable("list");

        MyLog.e("AASDSADA", list.toString() + "");


        String read_text = list.get(0).getRead_text();
        String read_content = list.get(0).getRead_content();
        List<Read_XQ_Bean.DataBean.ReadQuestionListBean> read_questionList = list.get(0).getRead_questionList();
        mList.addAll(read_questionList);
        DuanWNr.setText(read_content);
        ItemSm.setText(read_text);

        listadapter = new Read_XuanZ_T_Adapter(App.activity, mList);
        TmListView.setAdapter(listadapter);
        listadapter.notifyDataSetChanged();

//        MengBView.bringToFront();
//        MengBView.bringToFront();
//        MengBView.setZ(0.f);
//        MengBView.setZ(100.f);



    }


    private void showPopupWindow(View view ,String s) {
        View view1 = (LinearLayout) View.inflate(App.activity, R.layout.tijiao_popup, null);
        TextView ivP = (TextView) view1.findViewById(R.id.back_text);
        TextView ivX = (TextView) view1.findViewById(R.id.Qx_btn);
        TextView ivClose = (TextView) view1.findViewById(R.id.Qr_btn);
        LinearLayout FanH = (LinearLayout) view1.findViewById(R.id.Q_X);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ivP.setLayoutParams(params);
        ivX.setLayoutParams(params);
        ivClose.setLayoutParams(params);
        ivClose.setOnClickListener(this);
        popupWindow1 = new PopupWindow(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow1.setContentView(view1);
        popupWindow1.setFocusable(true);
        popupWindow1.setTouchable(true);
        popupWindow1.setOutsideTouchable(true);
        popupWindow1.showAsDropDown(view, 0, 0);
        backgroundAlpha(0.5f);
        view1= View.inflate(App.activity, R.layout.tijiao_popup, null);
        popupWindow2 = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        text = view1.findViewById(R.id.back_text);
        G_mai = view1.findViewById(R.id.Qx_btn);
        E_ka = view1.findViewById(R.id.Qr_btn);
        fanH = view1.findViewById(R.id.Q_X);
        text.setText(s);

        G_mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                backgroundAlpha(1f);
                popupWindow2.dismiss();
                popupWindow1.dismiss();
                backgroundAlpha(1f);
                MyLog.e("点击取消按钮", "haha");
            }
        });
        E_ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter = new Read_TJ_Presenter(Read_fragment.this);
                presenter.SetUrl(jsonImgList);
                popupWindow2.dismiss();
                popupWindow1.dismiss();
                backgroundAlpha(1f);
                MyLog.e("点击确定按钮", "lueluelue");
            }
        });
        fanH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow2.dismiss();
                popupWindow1.dismiss();
//                menBC.setVisibility(View.GONE);
                backgroundAlpha(1f);
                MyLog.e("点击返回按钮", "lalala");
            }
        });

        popupWindow2.setBackgroundDrawable(getResources().getDrawable(
                R.color.colorWhite));//设置背景
// 设置好参数之后再show
        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow2.setTouchable(true);
        popupWindow2.setFocusable(true);
        popupWindow2.setOutsideTouchable(true);
    }
    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp =App.activity.getWindow().getAttributes();
        lp.alpha = f;
        App.activity.getWindow().setAttributes(lp);

    }





    @Override
    protected void loadData() {

    }


    private void PopupDimiss() {
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
                popupWindow1.dismiss();
            }
        });
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
    public void getManager(Read_XQ_Bean xqBean) {

    }

    @Override
    public void getRead_Tj(Read_TJ_Bean read_tj_bean) {

        int score = read_tj_bean.getData().getScore();

        MyLog.e("学生得分", score + "");
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Read_XQ_Cotract.Presenter presenter) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.Ti_J_ChaK})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Ti_J_ChaK:
                ArrayList<Map<String, String>> answerList = new ArrayList<>();
                ArrayList<String> answer = listadapter.getAnswer();
                ArrayList<String> read_qid = listadapter.getRead_qid();
                if (answer != null || read_qid != null) {
                    for (int i = 0; i < answer.size(); i++) {
                        Log.e("tag==answer", "答案=" + answer.get(i));
                        Map<String, String> map1 = new HashMap<>();
                        map1.put("learn_video", answer.get(i));
                        map1.put("read_qid", read_qid.get(i));
                        map1.put("learn_score", "0");
                        answerList.add(map1);
                        Map<String, Object> map = new HashMap<>();
                        map.put("read_id", Read_id);
                        map.put("type", type);
                        map.put("stuid", App.stuid);
                        map.put("answerList", answerList);
                        Gson gson = new Gson();
                        jsonImgList = gson.toJson(map);
                        Log.e("GSON", jsonImgList + "");
                    }
//                    PopupW(view, "确认提交");
                    showPopupWindow(TiJChaK,"确认提交");

                } else {
                    Toast toast = Toast.makeText(App.activity, "有未选择的答案", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }
                break;


        }
    }

    @Override
    public void onClick(View v) {

    }
}
