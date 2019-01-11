package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class YB_Two_XQ_Presenter implements YB_XiangQ_Cotract.Presenter {

    private CSModel ybModel;
    private YB_XiangQ_Cotract.View view;


    public YB_Two_XQ_Presenter(YB_XiangQ_Cotract.View loginView) {
        view = loginView;
        this.view.setBasePresenter(this);
        ybModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String ybid, String flag, String shiliType) {

        ybModel.postYinB_XQ_two(ybid, flag, shiliType, new MyNetWorkCallback<YB_XQ_Two_Bean>() {
            @Override
            public void onSuccess(YB_XQ_Two_Bean yb_xq_two_bean) {
                view.getManagerT(yb_xq_two_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void SetU(String ybid, String flag) {

    }

    @Override
    public void start() {

    }


}
