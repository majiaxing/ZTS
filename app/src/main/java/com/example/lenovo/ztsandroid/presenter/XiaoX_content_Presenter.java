package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.JiaoC_xz_Cotract;
import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_content_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/16.
 */

public class XiaoX_content_Presenter implements JiaoC_xz_Cotract.Presenter{


    private JiaoC_xz_Cotract.View view;
    private CSModel csModel;

    public XiaoX_content_Presenter(JiaoC_xz_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }




    @Override
    public void SetUrl(String string) {
        csModel.postXiaoXContent(string, new MyNetWorkCallback<XiaoX_content_Bean>() {
            @Override
            public void onSuccess(XiaoX_content_Bean xiaoX_content_bean) {
                view.getXiaoXContent(xiaoX_content_bean);
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
