package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class YB_One_Xq_Presenter implements YB_XiangQ_Cotract.Presenter {

    private CSModel ybModel;
    private YB_XiangQ_Cotract.View View;


    public YB_One_Xq_Presenter(YB_XiangQ_Cotract.View loginView) {
         View = loginView;
        this.View.setBasePresenter(this);
        ybModel  =new CSModelImpl();
    }

    @Override
    public void SetUrl(String ybid, String flag ,String  shiliType) {

        ybModel.postYinB_XQ_one(ybid, flag ,shiliType, new MyNetWorkCallback<YB_XQ_one_Bean>() {
            @Override
            public void onSuccess(YB_XQ_one_Bean yb_xq_one_bean) {
                View.getManagerO(yb_xq_one_bean);
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
