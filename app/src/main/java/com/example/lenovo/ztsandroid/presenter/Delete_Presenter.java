package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Delete_XX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/27.
 */

public class Delete_Presenter implements XX_Cotract.Presenter {



    private XX_Cotract.View view;
    private CSModel csModel;

    public Delete_Presenter(XX_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String useId, String pageNumber, String pageSize) {

    }
    @Override
    public void SetU(String json) {

        csModel.postXXDelete(json, new MyNetWorkCallback<Delete_XX_Bean>() {
            @Override
            public void onSuccess(Delete_XX_Bean xiaoX_bean) {
                view.getManagerDelete(xiaoX_bean);
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
