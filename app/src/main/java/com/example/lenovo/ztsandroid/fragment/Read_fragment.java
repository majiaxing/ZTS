package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/22.
 */
public class Read_fragment extends BaseFragment implements Read_XQ_Cotract.View {

    @BindView(R.id.DuanW_Nr)
    TextView DuanWNr;
    @BindView(R.id.Item_sm)
    TextView textSm;
    @BindView(R.id.Tm_ListView)
    MyListView TmListView;
    @BindView(R.id.Ti_J_ChaK)
    TextView TiJChaK;
    Unbinder unbinder;

    private Bundle bundle;
    private Read_XuanZ_T_Adapter listadapter;
    private ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> mList = new ArrayList<>();
    private Read_XQ_Cotract.Presenter presenter;
    private String Read_id;
    private String type;

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
        textSm.setText(read_text);

        listadapter = new Read_XuanZ_T_Adapter(App.activity, mList);
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

    @OnClick(R.id.Ti_J_ChaK)
    public void onViewClicked() {


        ArrayList<Map<String,String>> answerList = new ArrayList<>();
        ArrayList<String> answer = listadapter.getAnswer();
        ArrayList<String> read_qid = listadapter.getRead_qid();
        if (answer != null||read_qid != null) {
            for (int i = 0; i < answer.size(); i++) {
                Log.e("tag==answer","答案="+answer.get(i));
                Map<String ,String> map1 = new HashMap<>();
                map1.put("learn_video",answer.get(i));

                map1.put("read_qid",read_qid.get(i));
                map1.put("learn_score","0");
                answerList.add(map1);

            }
        }else {
            Toast.makeText(getActivity(),"有未选择的答案",Toast.LENGTH_SHORT).show();
            return;
        }

//        if (read_qid != null){
//            for (int i= 0; i<read_qid.size();i++){
//                Log.e("tag==read_qid","答案="+read_qid.get(i));
//            }
//        }

        Map<String ,Object> map = new HashMap<>();
        map.put("read_id", Read_id);
        map.put("type",type);
        map.put("stuid",App.stuid);
        map.put("answerList",answerList);

        Gson gson = new Gson();
        String jsonImgList = gson.toJson(map);
        Log.e("GSON",jsonImgList + "");


        presenter = new Read_TJ_Presenter(this);
        presenter.SetUrl(jsonImgList);
    }
    @Override
    public void getManager(Read_XQ_Bean xqBean) {

    }

    @Override
    public void getRead_Tj(Read_TJ_Bean read_tj_bean) {

        int score = read_tj_bean.getData().getScore();

        MyLog.e("学生得分",score + "" );

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Read_XQ_Cotract.Presenter presenter) {

    }
}
