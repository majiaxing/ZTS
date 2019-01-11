package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.My_Xinx_Cotract;
import com.example.lenovo.ztsandroid.cotract.Read_erj_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Student_Xinx_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/4.
 */

public class My_Xinx_Presenter implements My_Xinx_Cotract.Presenter {

    private My_Xinx_Cotract.View view;
    private CSModel csModel;

    public My_Xinx_Presenter(My_Xinx_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }



    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void seturl(String stuid) {
    csModel.postStudent_xinx(stuid, new MyNetWorkCallback<Student_Xinx_Bean>() {
        @Override
        public void onSuccess(Student_Xinx_Bean student_xinx_bean) {
            view.getManager(student_xinx_bean);
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
