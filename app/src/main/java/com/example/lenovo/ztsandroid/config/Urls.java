package com.example.lenovo.ztsandroid.config;

/**
 * Created by xingge on 2017/7/11.
 */

public class Urls {
    //测试接口
    public static final String CSUrls = "http://www.ipanda.com/kehuduan/liebiao/badaling/index.json";

    //BaseUrl
    public static final String WaiWBASE = "http://192.168.0.103:8080/demo/student/";


    public static final String FileBASE = "http://192.168.0.103:8080/demo/file/";

    public static final String BASE = "https://zts100.com/demo/student/";

    //登录
    public static final String Login = BASE+"login";

    // 教材选择
    public static final String Jiaoc = BASE+"text/findByType";

    //课文列表
    public static final String KwList = BASE +"text/findBySortByText";

//课文二级列表
    public static final String KwerjList = BASE +"text/findByDy";

    //听力提交
    public static final String TiJiaoTL = BASE + "learn/saveLearnListen";

    //课文详情
    public static final String KwXq = BASE +"text/detail";



    public static final String Read_TJ = BASE +"learn/saveLearnRead";

    //消息列表
    public static final String XXList = BASE +"news/findAllByNews";

    //消息个数
    public static final String XXcontent = BASE+"news/findByUnReadCount";

    //消息详情
    public static final String XXxq = BASE+"news/findByOne";

    //音标列表
    public static final String YBList = BASE+"text/findBySortByText";

    //音标详情
    public static final String YB_Xq = BASE+"text/findBySymbol";

    //作业列表
    public static final String ZuoY_List = BASE+"homework/findByHomework";

    //作业二级列表
    public static final String ZuoY_ErJ = BASE+"homework/findByHomeworkTwo";

    //作业详情
    public static final String ZuoY_XQ = BASE+"homework/findByHomeWorkDetail";

    public static final String BoF = FileBASE+"download";

    //录音上传 单词
    public static final  String LuYinSC = BASE+"learn/saveLearnWord";


    //录音上传 短语
    public static final  String LuYinSC_Dy = BASE+"learn/saveLearnPhrase";

    //录音上传 对话
    public static final  String LuYinSC_Dh = BASE+"learn/saveLearnJS";

      //录音上传 课文
    public static final  String LuYinSC_Kw = BASE+"learn/saveLearnText";

      //录音上传 句子
    public static final  String LuYinSC_Jz = BASE+"learn/saveLearnSentence";

    //录音上传文件
    public static final  String LuYinSC_Flie = FileBASE+"upload";

    //作业文件保存
    public static final  String LuYinSC_BC = BASE+"homework/saveHomeWork";

    //头像上传
    public static final String Toux_SC = BASE+"updateStuInfo";

    //学生信息
    public static final  String Student_xinx = BASE+"findByStuid";

    //学校
    public static final  String Student_XueX = BASE+"findBySchool";

    //学校
    public static final  String Student_Sheng = BASE+"findBySheng";

    //学校
    public static final  String Student_Shi = BASE+"findByShi";
    //学校
    public static final  String Student_Qu = BASE+"findByQu";


    //添加班级
    public static final  String TianJBan = BASE+"addClass";

    //选择班级
    public static final  String XuanzJBan = BASE+"addTeaClass";


    //提交作业
    public static final  String TiaoJ_ZY = BASE+"homework/finishHomeWork";

    //作业详情
    public static final  String ZuoYXQ = BASE+"homework/findByHomeWorkDetail";


    //多文件上传
    public static final  String TiaoJ_File= FileBASE+"multiUpload";


    public static final String WangJ = "https://zts100.com/demo/"+ "login/getShouJiYanZhenMa";


    public static final String WangJ_TiJiao = "https://zts100.com/demo/"+ "user/stu_update_mima";


    //修改密码
    public static final String XiuG_password = BASE+ "updatePassword";

    public static final String TianJ_Vip = BASE + "addCard";

    //智聆口语评测域名
    public static final String ZL_KY_PC = "https://soe.tencentcloudapi.com";


//    SecretId: AKIDlLk2DzeZAd5bTMph1Oj7hBeu1w29pRUL
//    SecretKey: oSF1kR2RegatkWAkDYlpGfyDKFqGLLGE
}
