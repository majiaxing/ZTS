package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.cotract.YB_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.YB_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/19.
 */

public class YinB_Presenter implements YB_Cotract.Presenter {

    private CSModel totallabelModel;
    private YB_Cotract.View view;


    public YinB_Presenter(YB_Cotract.View loginView) {
        view = loginView;
        this.view.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String jclx, String nj, String sxc, String flag) {

        totallabelModel.postYinB(jclx, nj, sxc, flag, new MyNetWorkCallback<YB_Bean>() {
            @Override
            public void onSuccess(YB_Bean yb_bean) {
                view.getManager(yb_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void start() {

    }
}
