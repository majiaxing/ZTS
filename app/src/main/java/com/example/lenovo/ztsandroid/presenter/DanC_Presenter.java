package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.DanC_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class DanC_Presenter implements DanC_Cotract.Presenter {

    private DanC_Cotract.View view;
    private CSModel DancModel;

    public DanC_Presenter(DanC_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        DancModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String flag, String type) {

        DancModel.postDanc_Xq(flag, type, new MyNetWorkCallback<Dc_Xq_Bean>() {
            @Override
            public void onSuccess(Dc_Xq_Bean dcXqBean) {
                view.getManager(dcXqBean);
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
