package com.example.lenovo.ztsandroid.fragment.myself;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.GM_E_Activity;
import com.example.lenovo.ztsandroid.activity.My_E_Activity;
import com.example.lenovo.ztsandroid.activity.SheZ_Activity;
import com.example.lenovo.ztsandroid.activity.Xiugai_Activity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.My_Xinx_Cotract;
import com.example.lenovo.ztsandroid.model.entity.Student_Xinx_Bean;
import com.example.lenovo.ztsandroid.presenter.My_Xinx_Presenter;
import com.example.lenovo.ztsandroid.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/10/26.
 */

public class Myself_fragment extends BaseFragment implements My_Xinx_Cotract.View{


    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.YH_m)
    TextView YHM;
    @BindView(R.id.WD_vip)
    LinearLayout WDVip;
    @BindView(R.id.GouM_vip)
    LinearLayout GouMVip;
    @BindView(R.id.She_Z)
    LinearLayout SheZ;
    Unbinder unbinder;
    @BindView(R.id.XiuGaiZL)
    ImageView XiuGaiZL;
    @BindView(R.id.KEhuZhT)
    TextView KEhuZhT;

    private My_Xinx_Cotract.Presenter presenter;
    private String school;
    private String student;
    private String starttime;
    private String endtime;
    private String username;
    private String memberState;
    private String classId;
    private String kai;
    private String jie;

    @Override
    protected int getLayoutId() {
        return R.layout.cs_yemianfour;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        presenter  = new My_Xinx_Presenter(this);
        presenter.seturl(App.stuid);
    }

    @Override
    public void setParams(Bundle bundle) {

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

    @OnClick({R.id.WD_vip, R.id.GouM_vip, R.id.She_Z, R.id.circleImageView, R.id.XiuGaiZL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.WD_vip:
                Intent intent = new Intent(App.activity, My_E_Activity.class);
                intent.putExtra("school",school);
                intent.putExtra("classId",classId);
                intent.putExtra("memberState",memberState);
                intent.putExtra("starttime",starttime);
                intent.putExtra("endtime",endtime);
                startActivity(intent);

                break;
            case R.id.GouM_vip:

                Intent intent1 = new Intent(App.activity, GM_E_Activity.class);
                startActivity(intent1);

                break;
            case R.id.She_Z:

                Intent intent2 = new Intent(App.activity, SheZ_Activity.class);
                startActivity(intent2);


                break;
            case R.id.circleImageView:
                Intent intent4 = new Intent(App.activity,Xiugai_Activity.class);
                intent4.putExtra("student",student);
                startActivity(intent4);

                break;
            case R.id.XiuGaiZL:

                Intent intent3 = new Intent(App.activity,Xiugai_Activity.class);
                intent3.putExtra("student",student);
                startActivity(intent3);
                break;
        }
    }

    @Override
    public void getManager(Student_Xinx_Bean xq_bean) {


        if (xq_bean.getData() == null){
            return;
        }

        if (xq_bean.getData().getSchool() != "") {

            school = xq_bean.getData().getSchool();
            student = xq_bean.getData().getStudent();
            starttime = xq_bean.getData().getStarttime();
            endtime = xq_bean.getData().getEndtime();
            username = xq_bean.getData().getUsername();
            classId = xq_bean.getData().getClassId();
            memberState = xq_bean.getData().getMemberState();
        if (starttime !=null||endtime  != null){

            kai = starttime.substring(0, 10);
            jie = endtime.substring(0,10);
        }
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                YHM.setText(student);
                switch (memberState){
                    case "1":
                        KEhuZhT.setText("有效期："+kai+"至"+jie);
                        break;
                    case "2":
                        KEhuZhT.setText("有效期："+kai+"至"+jie);
                        break;
                    case "0":
                        KEhuZhT.setText("你目前为非会员");
                        break;
                }
            }
        });
        }
    }
    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(My_Xinx_Cotract.Presenter presenter) {

    }
}
