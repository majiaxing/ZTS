package com.example.lenovo.ztsandroid.model.biz;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.lenovo.ztsandroid.config.Urls;
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
import com.example.lenovo.ztsandroid.net.HttpFactroy;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;
import com.example.lenovo.ztsandroid.utils.HMACTest;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class CSModelImpl implements CSModel {

    private String signature;

    @Override
    public void getLiveChinaUrl(String url, MyNetWorkCallback<CeSBean> callback) {

        HttpFactroy.create().get(Urls.CSUrls,null,callback);
    }

    @Override
    public void postLogin(String name, String possward, MyNetWorkCallback<LoginBean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("username", name);
        map.put("password", possward);
        HttpFactroy.create().post(Urls.Login,map,callback);

    }

    @Override
    public void postJC(String url, MyNetWorkCallback<JiaoC_Bean> callback) {
        HttpFactroy.create().post(Urls.Jiaoc,null,callback);
    }

    @Override
    public void postKw(String jclx, String nj, String sxc, String flag, String listen_type, String stuid, MyNetWorkCallback<Kw_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("jclx", jclx);
        map.put("nj", nj);
        map.put("sxc", sxc);
        map.put("flag", flag);
        map.put("listen_type",listen_type);
        map.put("stuid",stuid);
        Gson gson = new Gson();
        String jsonImgList = gson.toJson(map);
        Log.e("GSON",jsonImgList + "");

        Map  map1 = new HashMap<>();
        map1.put("json",jsonImgList);

        HttpFactroy.create().post(Urls.KwList,map1,callback);
    }

    @Override
    public void postKwerjList(String flag, String type, MyNetWorkCallback<Kw_erji_list_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("flag",flag );
        map.put("type",type );

        HttpFactroy.create().post(Urls.KwerjList,map,callback);

    }

    @Override
    public void postKwXq(String text_id, MyNetWorkCallback<Kw_Xq_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("text_id",text_id );

        HttpFactroy.create().post(Urls.KwXq,map,callback);
    }

    @Override
    public void postXX(String urseId, String pageNumber, String pageSize, MyNetWorkCallback<XiaoX_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",urseId );
        map.put("pageNumber",pageNumber );
        map.put("pageSize",pageSize );
        HttpFactroy.create().post(Urls.XXList,map,callback);
    }



    @Override
    public void postXiaoXContent(String urseId, MyNetWorkCallback<XiaoX_content_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",urseId );
        HttpFactroy.create().post(Urls.XXcontent,map,callback);
    }

    @Override
    public void postXiaoXxq(String id, MyNetWorkCallback<XX_xq_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("id",id );
        HttpFactroy.create().post(Urls.XXxq,map,callback);
    }

    @Override
    public void postYinB(String jclx, String nj, String sxc, String flag, MyNetWorkCallback<YB_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("jclx", jclx);
        map.put("nj", nj);
        map.put("sxc", sxc);
        map.put("flag", flag);

        Gson gson = new Gson();
        String jsonImgList = gson.toJson(map);
        Log.e("GSON",jsonImgList + "");

        Map  map1 = new HashMap<>();
        map1.put("json",jsonImgList);

        HttpFactroy.create().post(Urls.YBList,map1,callback);




    }



    @Override
    public void postYinB_XQ_four(String ybid, String flag, String shiliType, MyNetWorkCallback<YB_XQ_four_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("ybid",ybid );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.YB_Xq,map,callback);
    }

    @Override
    public void postYinB_XQ_one(String ybid, String flag,String shiliType, MyNetWorkCallback<YB_XQ_one_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("ybid",ybid );
        map.put("flag",flag );
        map.put("shiliType","1");
        HttpFactroy.create().post(Urls.YB_Xq,map,callback);
    }

    @Override
    public void postYinB_TZ_YX(String ybid, String flag, MyNetWorkCallback<YB_XQ_one_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("ybid",ybid );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.YB_Xq,map,callback);
    }


    @Override
    public void postYinB_XQ_two(String ybid, String flag, String shiliType, MyNetWorkCallback<YB_XQ_Two_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("ybid",ybid );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.YB_Xq,map,callback);
    }

    @Override
    public void postYinB_XQ_three(String ybid, String flag, String shiliType, MyNetWorkCallback<YB_XQ_three_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("ybid",ybid );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.YB_Xq,map,callback);
    }

    @Override
    public void postJuz_list(String flag, String type, MyNetWorkCallback<Juz_erj_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("type",type );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.KwerjList,map,callback);
    }

    @Override
    public void postDanc_Xq(String flag, String type, MyNetWorkCallback<Dc_Xq_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("type",type );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.KwerjList,map,callback);
    }

    @Override
    public void postDY_Xq(String flag, String type, String stuid, MyNetWorkCallback<Dy_Xq_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("type",type );
        map.put("flag",flag );
        map.put("stuid",stuid );
        HttpFactroy.create().post(Urls.KwerjList,map,callback);
    }

    @Override
    public void postJuz_Xq(String sentence_id, MyNetWorkCallback<Juz_Xq_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("sentence_id",sentence_id );

        HttpFactroy.create().post(Urls.KwXq,map,callback);


    }

    @Override
    public void postDuiH_er_list(String flag, String type, MyNetWorkCallback<DuiH_erj_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("type",type );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.KwerjList,map,callback);
    }

    @Override
    public void postDuiH_XQ(String talk_id, MyNetWorkCallback<DuiH_XQ_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("talk_id",talk_id );

        HttpFactroy.create().post(Urls.KwXq,map,callback);

    }

    @Override
    public void postTingL(String flag, String type,String listen_type, MyNetWorkCallback<TingL_erj_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("type",type );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        HttpFactroy.create().post(Urls.KwerjList,map,callback);
    }

    @Override
    public void postTingL_XQ_xz(String listen_id, MyNetWorkCallback<TingL_XQ_xz_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("listen_id",listen_id );

        HttpFactroy.create().post(Urls.KwXq,map,callback);

    }

    @Override
    public void postTiJ_TinL(String listen_id, String type, String stuid, String listen_type, String listen_questId, String learn_video, String learn_score, MyNetWorkCallback<TiLi_BaoC_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("listen_id",listen_id );
        map.put("type",type );
        map.put("stuid",stuid );
        map.put("listen_type",listen_type );
        map.put("listen_questId",listen_questId );
        map.put("learn_video",learn_video );
        map.put("learn_score",learn_score );
        HttpFactroy.create().post(Urls.TiJiaoTL,map,callback);

    }

    @Override
    public void postTingL_XQ_tk(String listen_id, MyNetWorkCallback<TingL_TK_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("listen_id",listen_id );

        HttpFactroy.create().post(Urls.KwXq,map,callback);
    }

    @Override
    public void postRead_erj(String flag, String type, MyNetWorkCallback<Read_erj_Bean> callback) {


        Map<String, String> map = new HashMap<>();
        map.put("type",type );
        map.put("flag",flag );
        HttpFactroy.create().post(Urls.KwerjList,map,callback);


    }

    @Override
    public void postRead_xq(String read_id, MyNetWorkCallback<Read_XQ_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("read_id",read_id );

        HttpFactroy.create().post(Urls.KwXq,map,callback);
    }

    @Override
    public void postZuoY_List(String stuid, MyNetWorkCallback<ZuoY_list_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );

        HttpFactroy.create().post(Urls.ZuoY_List,map,callback);
    }

    @Override
    public void postZuoY_erJ(String hwid, String homework_cishu, String flag, String scoreAll, MyNetWorkCallback<ZuoY_erJ_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("hwid",hwid);
        map.put("homework_cishu",homework_cishu);
        map.put("flag",flag);
        map.put("scoreAll",scoreAll);

        HttpFactroy.create().post(Urls.ZuoY_ErJ,map,callback);
    }

    @Override
    public void postZuoY_Xq(String stuid, String hwid, String flag, MyNetWorkCallback<ZuoY_Xq_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("stuid",stuid );
        HttpFactroy.create().post(Urls.ZuoY_XQ,map,callback);


    }

    @Override
    public void postSC_Lu(String stuid, String hwid, String hw_type, String hw_content,String hw_answerId,String hw_video, String hw_score,  MyNetWorkCallback<LiY_SC_WJ_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid);
        map.put("hw_type",hw_type);
        map.put("hw_content",hw_content);
        map.put("hw_answerId",hw_answerId);
        map.put("hw_video",hw_video);
        map.put("hw_score",hw_score);
        HttpFactroy.create().post(Urls.LuYinSC_BC,map,callback);
    }

    @Override
    public void postSC_tx(String student, String stuTupian, String stuid, MyNetWorkCallback<LiY_SC_WJ_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("student",student );
        map.put("stuTupian",stuTupian );
        HttpFactroy.create().post(Urls.Toux_SC,map,callback);
    }

    @Override
    public void postSC_file(File file, String type, String save_path, MyNetWorkCallback<SC_YX_Bean> callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("file",file);
        map.put("type",type );
        map.put("save_path",save_path );

        HttpFactroy.create().postSC_File(Urls.LuYinSC_Flie,map,callback);
    }

    @Override
    public void postSC_Lu_StdeyDc(String stuid, String word_id, String learn_video, String learn_score, String type, MyNetWorkCallback<Stdey_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("word_id",word_id );
        map.put("learn_video",learn_video );
        map.put("learn_score",learn_score );
        map.put("type",type );
        HttpFactroy.create().post(Urls.LuYinSC,map,callback);
    }

    @Override
    public void postSC_Lu_StdeyDy(String stuid, String word_id, String learn_video, String learn_score, String type, MyNetWorkCallback<Stdey_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("phrase_id",word_id );
        map.put("learn_video",learn_video );
        map.put("learn_score",learn_score );
        map.put("type",type );
        HttpFactroy.create().post(Urls.LuYinSC_Dy,map,callback);
    }

    @Override
    public void postSC_Lu_StdeyDh(String stuid, String word_id, String learn_video, String learn_score, String type, MyNetWorkCallback<Stdey_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("juese_id",word_id );
        map.put("learn_video",learn_video );
        map.put("learn_score",learn_score );
        map.put("talk_id",type );
        HttpFactroy.create().post(Urls.LuYinSC_Dh,map,callback);
    }

@Override
    public void postSC_Lu_Stdeykw(String stuid, String word_id, String learn_video, String learn_score, String type, MyNetWorkCallback<Stdey_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("juese_id",word_id );
        map.put("learn_video",learn_video );
        map.put("learn_score",learn_score );
        map.put("type",type );
        HttpFactroy.create().post(Urls.LuYinSC_Dh,map,callback);
    }

@Override
    public void postSC_Lu_Stdeyjz(String stuid, String word_id, String learn_video, String learn_score, String type, MyNetWorkCallback<Stdey_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("juese_id",word_id );
        map.put("learn_video",learn_video );
        map.put("learn_score",learn_score );
        map.put("type",type );
        HttpFactroy.create().post(Urls.LuYinSC_Dh,map,callback);
    }


    @Override
    public void postStudent_xinx(String stuid, MyNetWorkCallback<Student_Xinx_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        HttpFactroy.create().post(Urls.Student_xinx,map,callback);
    }

    @Override
    public void post_DiqSheng(MyNetWorkCallback<Diq_Bean> callback) {
        HttpFactroy.create().post(Urls.Student_Sheng,null,callback);
    }



    @Override
    public void post_DiqShi(String shiID,MyNetWorkCallback<Diq_Shi_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("sheng_id",shiID );
        HttpFactroy.create().post(Urls.Student_Shi,map,callback);
    }

    @Override
    public void post_DiqQu(String quID,MyNetWorkCallback<Diq_Qu_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("shi_id",quID );
        HttpFactroy.create().post(Urls.Student_Qu,map,callback);
    }

    @Override
    public void post_JR_BJ(String stuid, String infor, MyNetWorkCallback<BanJBean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("infor",infor );
        HttpFactroy.create().post(Urls.TianJBan,map,callback);
    }

    @Override
    public void post_Xz_Bj(String stuid, String infor, MyNetWorkCallback<Xz_Bj_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid );
        map.put("classId",infor );
        HttpFactroy.create().post(Urls.XuanzJBan,map,callback);
    }

    @Override
    public void postTiJao_ZY(String stuid, String hwid, ArrayList<Map<String, Object>> typeList, MyNetWorkCallback<TiJao_ZY_Bean> callback) {


        Map<String, Object> map = new HashMap<>();
        map.put("stuid", stuid);
        map.put("hwid", hwid);
        map.put("typeList", typeList);
        Gson gson = new Gson();
        String jsonImgList = gson.toJson(map);
        Log.e("GSON",jsonImgList + "");

        Map  map1 = new HashMap<>();
        map1.put("json",jsonImgList);

        HttpFactroy.create().post(Urls.TiaoJ_ZY,map1,callback);
    }

    @Override
    public void postTiJiao_File(File stuid, String type, String save_path, MyNetWorkCallback<DWj_SC_Bean> callback) {

        Map<String, Object> map = new HashMap<>();
        map.put("file",stuid);
        map.put("type",type );
        map.put("save_path",save_path );
        HttpFactroy.create().postSC_File(Urls.LuYinSC_Flie,map,callback);
    }

    @Override
    public void postWangJ(String shoujihao, String use_type_d, MyNetWorkCallback<WangJ_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("shoujihao",shoujihao);
        map.put("use_type_d",use_type_d );
        HttpFactroy.create().post(Urls.WangJ,map,callback);
    }

    @Override
    public void postWangJ_TJ(String usertype_code, String user_zhanghao, String user_password, String user_yanzhengma, String user_dianhua, MyNetWorkCallback<XiuG_CG_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("usertype_code",usertype_code);
        map.put("user_zhanghao",user_zhanghao );
        map.put("user_password",user_password );
        map.put("user_yanzhengma",user_yanzhengma );
        map.put("user_dianhua",user_dianhua );
        HttpFactroy.create().post_ZlYYin(Urls.WangJ_TiJiao,map,callback);
    }

    @Override
    public void postXiuG_password(String stuid, String username, String afterpassword, String password, MyNetWorkCallback<XiuG_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("username",username );
        map.put("afterpassword",afterpassword );
        map.put("password",password );
        HttpFactroy.create().post_ZlYYin(Urls.XiuG_password,map,callback);
    }

    @Override
    public void postTiJ_Vip(String stuid, String cardName, String cardPassword, MyNetWorkCallback<TiJ_Vip_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("cardName",cardName );
        map.put("cardPassword",cardPassword );
        HttpFactroy.create().post(Urls.TianJ_Vip,map,callback);
    }

    @Override
    public void postZuoY_DC(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_dc_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_DY(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_dy_Bean> callback) {

        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_TL(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_TL_xz_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_Kw(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_kw_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_Yb(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_dc_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_Jz(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_Jz_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_Yd(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_Yd_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }

    @Override
    public void postZuoY_Dh(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, MyNetWorkCallback<ZuoY_Dh_Bean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("stuid",stuid);
        map.put("hwid",hwid );
        map.put("flag",flag );
        map.put("listen_type",listen_type );
        map.put("hw_type",hw_type );
        map.put("hw_content",hw_content );
        map.put("avgScore",avgScore );
        HttpFactroy.create().post(Urls.ZuoYXQ,map,callback);
    }


    @Override
    public void postYYin_JK( String EvalMode, String RefText, String SessionId, String WorkMode,String ScoreCoeff, MyNetWorkCallback<YuYinPinG_Bean> callback) {


        final TreeMap<String, Object> params = new TreeMap<String, Object>();
        int nextInt = new Random().nextInt(999999);
        MyLog.e("拼接的 请求串",nextInt+"");
        params.put("Nonce", nextInt);
        // 实际调用时应当使用系统当前时间
        params.put("Timestamp", System.currentTimeMillis() / 1000 +"");
        params.put("Region", "ap-beijing");
        params.put("SecretId", "AKIDwmWN4oMsCKOI1avCF2eyJUVM4bxmvuDL");
        params.put("Action", "InitOralProcess");
        params.put("Version", "2018-07-24");
        params.put("SessionId", SessionId);
        params.put("RefText",RefText );
        params.put("WorkMode",WorkMode);
        params.put("EvalMode", EvalMode);
        params.put("ScoreCoeff", ScoreCoeff);

        String str2sign = HMACTest.getStringToSign("POST","soe.tencentcloudapi.com",params);
//        MyLog.e("拼接的 请求串",str2sign);
        try {
            signature = HMACTest.sign(str2sign, "62rgTXXM1PgmjZHrNn26zmRuY4QaecT9", "HmacSHA1");
            MyLog.e("Signature=" ,signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.put("Signature", signature);
        HttpFactroy.create().postCSh(Urls.ZL_KY_PC,params,callback);
    }
    @Override
    public void getFy_PG(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId, MyNetWorkCallback<String> callback) {

        final TreeMap<String, Object> params = new TreeMap<String, Object>();
        int nextInt = new Random().nextInt(999999);
        MyLog.e("拼接的 请求串",nextInt+"");
        params.put("Nonce", nextInt);
        // 实际调用时应当使用系统当前时间
        params.put("Timestamp", System.currentTimeMillis() / 1000 +"");
        params.put("Region", "ap-beijing");
        params.put("SecretId", "AKIDwmWN4oMsCKOI1avCF2eyJUVM4bxmvuDL");
        params.put("Action", "TransmitOralProcess");
        params.put("Version", "2018-07-24");
        params.put("SeqId",SeqId);
        params.put("IsEnd", IsEnd);
        params.put("VoiceFileType","2");
        params.put("VoiceEncodeType","1");
        params.put("UserVoiceData", UserVoiceData);
        params.put("SessionId", SessionId);
        String str2sign = HMACTest.getStringToSign("POST","soe.tencentcloudapi.com",params);
        MyLog.e("拼接的 请求串",str2sign);
        try {
            signature = HMACTest.sign(str2sign, "62rgTXXM1PgmjZHrNn26zmRuY4QaecT9", "HmacSHA1");
            MyLog.e("Signature=123123213" , signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.put("Signature", signature);
        HttpFactroy.create().postZlY(Urls.ZL_KY_PC,params,callback);

    }

}
