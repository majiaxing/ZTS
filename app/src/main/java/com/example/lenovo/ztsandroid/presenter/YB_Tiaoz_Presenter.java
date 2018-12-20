package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class YB_Tiaoz_Presenter implements YB_XiangQ_Cotract.Presenter {

    private CSModel ybModel;
    private YB_XiangQ_Cotract.View View;


    public YB_Tiaoz_Presenter(YB_XiangQ_Cotract.View loginView) {
         View = loginView;
        this.View.setBasePresenter(this);
        ybModel  =new CSModelImpl();
    }

    @Override
    public void SetUrl(String ybid, String flag ,String  shiliType) {

    }

    @Override
    public void SetU(String ybid, String flag) {

        ybModel.postYinB_TZ_YX(ybid, flag, new MyNetWorkCallback<YB_XQ_one_Bean>() {
            @Override
            public void onSuccess(YB_XQ_one_Bean yb_xq_one_bean) {
                View.getManagerR(yb_xq_one_bean);
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
