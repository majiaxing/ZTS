package com.example.lenovo.ztsandroid.model.biz;

import com.example.lenovo.ztsandroid.model.entity.BanJBean;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.DWj_SC_Bean;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Qu_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Shi_Bean;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.DuiH_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Dy_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.LoginBean;
import com.example.lenovo.ztsandroid.model.entity.PinC_Fay_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_TJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.model.entity.Student_Xinx_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJ_Vip_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJao_ZY_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiLi_BaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.WangJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_content_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiuG_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiuG_CG_Bean;
import com.example.lenovo.ztsandroid.model.entity.Xz_Bj_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Dh_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Jz_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Yd_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dy_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Lenovo on 2018/10/24.
 */

public interface CSModel {

    void getLiveChinaUrl(String url,MyNetWorkCallback<CeSBean> callback);

    void postLogin(String name , String possward ,MyNetWorkCallback<LoginBean> callback);

    void postJC(String url ,MyNetWorkCallback<JiaoC_Bean> callback);

    void postKw(String jclx , String nj , String sxc , String flag,String listen_type,String stuid, MyNetWorkCallback<Kw_Bean> callback);

    void postKwerjList(String flag , String type , MyNetWorkCallback<Kw_erji_list_Bean> callback);

    void postKwXq(String text_id , MyNetWorkCallback<Kw_Xq_Bean> callback);

    void postXX( String urseId,String pageNumber, String pageSize, MyNetWorkCallback<XiaoX_Bean> callback);

    void postXiaoXContent( String urseId, MyNetWorkCallback<XiaoX_content_Bean> callback);

    void postXiaoXxq( String urseId, MyNetWorkCallback<XX_xq_Bean> callback);

    void postYinB( String jclx , String nj , String sxc , String flag, MyNetWorkCallback<YB_Bean> callback);

    void postYinB_XQ_four( String ybid , String flag,String shiliType, MyNetWorkCallback<YB_XQ_four_Bean> callback);

    void postYinB_XQ_one( String ybid , String flag,String shiliType, MyNetWorkCallback<YB_XQ_one_Bean> callback);


    void postYinB_TZ_YX( String ybid , String flag, MyNetWorkCallback<YB_XQ_one_Bean> callback);

    void postYinB_XQ_two(String ybid , String flag,String shiliType, MyNetWorkCallback<YB_XQ_Two_Bean> callback);

    void postYinB_XQ_three(String ybid , String flag,String shiliType, MyNetWorkCallback<YB_XQ_three_Bean> callback);

    void postJuz_list(String flag , String type , MyNetWorkCallback<Juz_erj_Bean> callback);

    void postDanc_Xq(String flag , String type, MyNetWorkCallback<Dc_Xq_Bean> callback);

    void postDY_Xq(String flag , String type , String stuid, MyNetWorkCallback<Dy_Xq_Bean> callback);

    void postJuz_Xq(String sentence_id , MyNetWorkCallback<Juz_Xq_Bean> callback);

    void postDuiH_er_list(String flag , String type, MyNetWorkCallback<DuiH_erj_Bean> callback);

    void postDuiH_XQ(String talk_id , MyNetWorkCallback<DuiH_XQ_Bean> callback);

    void postTingL(String flag , String type ,String listen_type, MyNetWorkCallback<TingL_erj_Bean> callback);

    void postTingL_XQ_xz(String listen_id ,MyNetWorkCallback<TingL_XQ_xz_Bean> callback);

    void postTiJ_TinL(String listen_id, String type, String stuid, String listen_type, String listen_questId, String learn_video, String learn_score , MyNetWorkCallback<TiLi_BaoC_Bean> callback);

    void postTingL_XQ_tk(String listen_id ,MyNetWorkCallback<TingL_TK_Bean> callback);

    void postRead_erj(String flag , String type , MyNetWorkCallback<Read_erj_Bean> callback);

    void postRead_xq( String read_id , MyNetWorkCallback<Read_XQ_Bean> callback);


    void postRead_TJ(String read_id , MyNetWorkCallback<Read_TJ_Bean> callback);

    void postZuoY_List(String stuid , MyNetWorkCallback<ZuoY_list_Bean> callback);

    void postZuoY_erJ(String hwid , String homework_cishu , String flag, String scoreAll, MyNetWorkCallback<ZuoY_erJ_Bean> callback);

    void postZuoY_Xq(String stuid, String hwid , String flag, MyNetWorkCallback<ZuoY_Xq_Bean> callback);

    void postSC_Lu(String stuid, String hwid, String hw_type, String hw_content,String hw_answerId,String hw_video, String hw_score,MyNetWorkCallback<LiY_SC_WJ_Bean> callback);


    void postSC_tx(String student, String stuTupian, String stuid, MyNetWorkCallback<LiY_SC_WJ_Bean> callback);


    void postSC_file(File file, String type, String save_path, MyNetWorkCallback<SC_YX_Bean> callback);


    void postSC_Lu_StdeyDc(String stuid, String word_id, String learn_video, String learn_score, String type,MyNetWorkCallback<Stdey_Bean> callback);

    void postSC_Lu_StdeyDy(String stuid, String word_id, String learn_video, String learn_score, String type,MyNetWorkCallback<Stdey_Bean> callback);

    void postSC_Lu_StdeyDh(String stuid, String word_id, String learn_video, String learn_score, String type,MyNetWorkCallback<Stdey_Bean> callback);
    void postSC_Lu_Stdeykw(String stuid, String word_id, String learn_video, String learn_score, String type,MyNetWorkCallback<Stdey_Bean> callback);
    void postSC_Lu_Stdeyjz(String stuid, String word_id, String learn_video, String learn_score, String type,MyNetWorkCallback<Stdey_Bean> callback);


    void postStudent_xinx(String stuid , MyNetWorkCallback<Student_Xinx_Bean> callback);



    void post_DiqSheng( MyNetWorkCallback<Diq_Bean> callback);

    void post_DiqShi( String shiID, MyNetWorkCallback<Diq_Shi_Bean> callback);

    void post_DiqQu(String quID, MyNetWorkCallback<Diq_Qu_Bean> callback);


    void post_JR_BJ(String stuid,String infor, MyNetWorkCallback<BanJBean> callback);

    void post_Xz_Bj(String stuid,String infor, MyNetWorkCallback<Xz_Bj_Bean> callback);

    void postTiJao_ZY(String stuid, String hwid, ArrayList<Map<String,Object>> mapArrayList, MyNetWorkCallback<TiJao_ZY_Bean> callback);


    void postTiJiao_File(File stuid, String type,String save_path , MyNetWorkCallback<DWj_SC_Bean> callback);

    void postWangJ(String shoujihao, String use_type_d , MyNetWorkCallback<WangJ_Bean> callback);

    void postWangJ_TJ(String usertype_code, String user_zhanghao, String user_password, String user_yanzhengma, String user_dianhua , MyNetWorkCallback<XiuG_CG_Bean> callback);

    void postXiuG_password(String stuid, String username, String afterpassword, String password , MyNetWorkCallback<XiuG_Bean> callback);




    void postTiJ_Vip(String stuid, String cardName, String cardPassword , MyNetWorkCallback<TiJ_Vip_Bean> callback);




    void postZuoY_DC(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_dc_Bean> callback);
    void postZuoY_DY(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_dy_Bean> callback);
    void postZuoY_TL(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_TL_xz_Bean> callback);
    void postZuoY_Kw(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_kw_Bean> callback);
    void postZuoY_Yb(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_dc_Bean> callback);
    void postZuoY_Jz(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_Jz_Bean> callback);
    void postZuoY_Yd(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_Yd_Bean> callback);
    void postZuoY_Dh(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_Dh_Bean> callback);





//    https://soe.tencentcloudapi.com/?
// Action=InitOralProcess&EvalMode=0&
// Nonce=2720&RefText=1&Region=ap-beijing&ScoreCoeff=4.0&
// SecretId=AKIDlLk2DzeZAd5bTMph1Oj7hBeu1w29pRUL
// &SessionId=1&
// Signature=TFiv%2Fy%2B0Z%2B%2FpFMTghMhu8FBh2yw%3D
// &Timestamp=1543221818&Version=2018-07-24&WorkMode=1

    void postYYin_JK(String EvalMode, String RefText, String SessionId, String WorkMode,String ScoreCoeff,MyNetWorkCallback<YuYinPinG_Bean> callback);

    void getFy_PG( String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType,String UserVoiceData,String SessionId,MyNetWorkCallback<String> callback);

}
