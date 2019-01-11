package com.example.lenovo.ztsandroid.presenter;

import android.util.Log;

import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.cotract.Logincotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/14.
 */

public class KeW_list_Presenter  implements KeW_list_Cotract.Presenter{


    private CSModel totallabelModel;
    private KeW_list_Cotract.View KwView;


    public KeW_list_Presenter(KeW_list_Cotract.View loginView) {
        KwView = loginView;
        this.KwView.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String jclx, String nj, String sxc, String flag, String listen_type, String stuid) {

        totallabelModel.postKw(jclx, nj, sxc, flag,listen_type,stuid, new MyNetWorkCallback<Kw_Bean>() {
            @Override
            public void onSuccess(Kw_Bean kw_bean) {
                Log.e("访问状态",kw_bean.getMessage().toString()+"");
                KwView.getManager(kw_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }



    @Override
    public void SetU(String flag, String type) {

    }

    @Override
    public void start() {

    }
}
