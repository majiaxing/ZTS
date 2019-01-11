package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.DanC_Cotract;
import com.example.lenovo.ztsandroid.cotract.Diq_QieH_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Student_Xinx_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Diq_Presenter implements Diq_QieH_Cotract.Presenter {

    private Diq_QieH_Cotract.View view;
    private CSModel DancModel;

    public Diq_Presenter(final Diq_QieH_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        DancModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void start() {
        DancModel.post_DiqSheng(new MyNetWorkCallback<Diq_Bean>() {
            @Override
            public void onSuccess(Diq_Bean diq_Bean) {
                view.getManagerSheng(diq_Bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });




    }

    @Override
    public void SetUrl(String sheng_id) {


    }

    @Override
    public void SetU(String shi_id) {

    }
}
