package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/15.
 */

public class XiaoX_Presenter implements XX_Cotract.Presenter{

    private XX_Cotract.View view;
    private CSModel csModel;

    public XiaoX_Presenter(XX_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }
    @Override
    public void SetUrl(String useId, String pageNumber, String pageSize) {
        csModel.postXX(useId, pageNumber,  pageSize, new MyNetWorkCallback<XiaoX_Bean>() {
            @Override
            public void onSuccess(XiaoX_Bean xiaoX_bean) {
                view.getManager(xiaoX_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void SetU(String json) {

    }

    @Override
    public void start() {

    }


}
