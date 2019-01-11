package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;

/**
 * Created by Administrator on 2018/11/26.
 */

public interface CS_YYin_JK_Cotract {


//    定义view里面的 方法

    interface View extends BaseView<CS_YYin_JK_Cotract.Presenter> {
        void getManager(String string);
        void showmessage(String str);
    }

//    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String Action ,String EvalMode ,String Nonce,String RefText,String Region ,String SecretId,String SessionId,String Signature,String Timestamp,String Version,String WorkMode);
    }


}
