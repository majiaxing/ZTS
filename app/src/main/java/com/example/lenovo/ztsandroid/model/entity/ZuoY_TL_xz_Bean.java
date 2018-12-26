package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/18.
 */

public class ZuoY_TL_xz_Bean implements Serializable{


    /**
     * data : {"typeList":[{"listen_id":"03a78ddc-e722-4d23-9eca-925b4725f427","listen_text":"词汇听力（本题8分）","listen_questionList":[{"listen_resolve":"","hw_answerId":"4eda54de-2bd4-4c25-a490-323f11059219","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/4eda54de-2bd4-4c25-a490-323f11059219/","listen_answer":"B","listen_optionList":[{"listen_optionId":2327,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2328,"listen_optionContent":"oo","listen_option":"B"},{"listen_optionId":2329,"listen_optionContent":"u","listen_option":"C"}],"listen_questVideo":"1. c___k v. 做饭.mp3","listen_question":"1. c___k v. 做饭","listen_questId":"4eda54de-2bd4-4c25-a490-323f11059219"},{"listen_resolve":"","hw_answerId":"978ddbf2-c940-4e99-9ff7-937f41280334","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/978ddbf2-c940-4e99-9ff7-937f41280334/","listen_answer":"A","listen_optionList":[{"listen_optionId":2330,"listen_optionContent":"ea","listen_option":"A"},{"listen_optionId":2331,"listen_optionContent":"he","listen_option":"B"},{"listen_optionId":2332,"listen_optionContent":"ae","listen_option":"C"}],"listen_questVideo":"2. w___ther n. 天气.mp3","listen_question":"2. w___ther n. 天气","listen_questId":"978ddbf2-c940-4e99-9ff7-937f41280334"},{"listen_resolve":"","hw_answerId":"29dc06ed-c525-42c5-8a91-501c20bea99c","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/29dc06ed-c525-42c5-8a91-501c20bea99c/","listen_answer":"B","listen_optionList":[{"listen_optionId":2333,"listen_optionContent":"iu","listen_option":"A"},{"listen_optionId":2334,"listen_optionContent":"ui","listen_option":"B"},{"listen_optionId":2335,"listen_optionContent":"u","listen_option":"C"}],"listen_questVideo":"3. j___ce n. 果汁；饮料.mp3","listen_question":"3. j___ce n. 果汁；饮料","listen_questId":"29dc06ed-c525-42c5-8a91-501c20bea99c"},{"listen_resolve":"","hw_answerId":"7135c0b3-7a06-4c4f-9676-e879f341c1bc","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/7135c0b3-7a06-4c4f-9676-e879f341c1bc/","listen_answer":"C","listen_optionList":[{"listen_optionId":2336,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2337,"listen_optionContent":"e","listen_option":"B"},{"listen_optionId":2338,"listen_optionContent":"a","listen_option":"C"}],"listen_questVideo":"4. v___cation n. 假期.mp3","listen_question":"4. v___cation n. 假期","listen_questId":"7135c0b3-7a06-4c4f-9676-e879f341c1bc"},{"listen_resolve":"","hw_answerId":"566217d8-443b-4a8f-96e4-f6e7928ae37d","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/566217d8-443b-4a8f-96e4-f6e7928ae37d/","listen_answer":"B","listen_optionList":[{"listen_optionId":2339,"listen_optionContent":" n. 高山","listen_option":"A"},{"listen_optionId":2340,"listen_optionContent":" n. 国；国家","listen_option":"B"},{"listen_optionId":2341,"listen_optionContent":"n. 冬天；冬季","listen_option":"C"}],"listen_questVideo":"5.\u2014.mp3","listen_question":"5.","listen_questId":"566217d8-443b-4a8f-96e4-f6e7928ae37d"},{"listen_resolve":"","hw_answerId":"aaf7c28c-0f8e-4160-b6db-1536529ea0dc","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/aaf7c28c-0f8e-4160-b6db-1536529ea0dc/","listen_answer":"C","listen_optionList":[{"listen_optionId":2342,"listen_optionContent":"v. 坐","listen_option":"A"},{"listen_optionId":2343,"listen_optionContent":"v. 下雪/n. 雪","listen_option":"B"},{"listen_optionId":2344,"listen_optionContent":"v. 滑冰","listen_option":"C"}],"listen_questVideo":"6.___.mp3","listen_question":"6.","listen_questId":"aaf7c28c-0f8e-4160-b6db-1536529ea0dc"},{"listen_resolve":"","hw_answerId":"fdfad847-2c65-4691-bad9-e7d4adcf39fd","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/fdfad847-2c65-4691-bad9-e7d4adcf39fd/","listen_answer":"A","listen_optionList":[{"listen_optionId":2345,"listen_optionContent":"此刻；马上","listen_option":"A"},{"listen_optionId":2346,"listen_optionContent":"正确","listen_option":"B"},{"listen_optionId":2347,"listen_optionContent":"右转","listen_option":"C"}],"listen_questVideo":"7.____.mp3","listen_question":"7.","listen_questId":"fdfad847-2c65-4691-bad9-e7d4adcf39fd"},{"listen_resolve":"","hw_answerId":"ba69a746-6bf8-450a-b07e-363e75ef71d1","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/ba69a746-6bf8-450a-b07e-363e75ef71d1/","listen_answer":"C","listen_optionList":[{"listen_optionId":2348,"listen_optionContent":"返回","listen_option":"A"},{"listen_optionId":2349,"listen_optionContent":"（给某人）回电话","listen_option":"B"},{"listen_optionId":2350,"listen_optionContent":"捎个口信；传话","listen_option":"C"}],"listen_questVideo":"8.____.mp3","listen_question":"8.","listen_questId":"ba69a746-6bf8-450a-b07e-363e75ef71d1"}],"everyScore":1.56,"listen_video":"","listen_type":"1"}],"Relative_path":"1_2_7_1_2001/tingli/03a78ddc-e722-4d23-9eca-925b4725f427/"}
     * data2 : null
     * data3 : null
     * pageInfo : null
     * success : true
     * message : success
     * icon : null
     * token : null
     * code : 200
     */

    private DataBean data;
    private Object data2;
    private Object data3;
    private Object pageInfo;
    private boolean success;
    private String message;
    private Object icon;
    private Object token;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public Object getData3() {
        return data3;
    }

    public void setData3(Object data3) {
        this.data3 = data3;
    }

    public Object getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Object pageInfo) {
        this.pageInfo = pageInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean implements Serializable{
        /**
         * typeList : [{"listen_id":"03a78ddc-e722-4d23-9eca-925b4725f427","listen_text":"词汇听力（本题8分）","listen_questionList":[{"listen_resolve":"","hw_answerId":"4eda54de-2bd4-4c25-a490-323f11059219","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/4eda54de-2bd4-4c25-a490-323f11059219/","listen_answer":"B","listen_optionList":[{"listen_optionId":2327,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2328,"listen_optionContent":"oo","listen_option":"B"},{"listen_optionId":2329,"listen_optionContent":"u","listen_option":"C"}],"listen_questVideo":"1. c___k v. 做饭.mp3","listen_question":"1. c___k v. 做饭","listen_questId":"4eda54de-2bd4-4c25-a490-323f11059219"},{"listen_resolve":"","hw_answerId":"978ddbf2-c940-4e99-9ff7-937f41280334","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/978ddbf2-c940-4e99-9ff7-937f41280334/","listen_answer":"A","listen_optionList":[{"listen_optionId":2330,"listen_optionContent":"ea","listen_option":"A"},{"listen_optionId":2331,"listen_optionContent":"he","listen_option":"B"},{"listen_optionId":2332,"listen_optionContent":"ae","listen_option":"C"}],"listen_questVideo":"2. w___ther n. 天气.mp3","listen_question":"2. w___ther n. 天气","listen_questId":"978ddbf2-c940-4e99-9ff7-937f41280334"},{"listen_resolve":"","hw_answerId":"29dc06ed-c525-42c5-8a91-501c20bea99c","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/29dc06ed-c525-42c5-8a91-501c20bea99c/","listen_answer":"B","listen_optionList":[{"listen_optionId":2333,"listen_optionContent":"iu","listen_option":"A"},{"listen_optionId":2334,"listen_optionContent":"ui","listen_option":"B"},{"listen_optionId":2335,"listen_optionContent":"u","listen_option":"C"}],"listen_questVideo":"3. j___ce n. 果汁；饮料.mp3","listen_question":"3. j___ce n. 果汁；饮料","listen_questId":"29dc06ed-c525-42c5-8a91-501c20bea99c"},{"listen_resolve":"","hw_answerId":"7135c0b3-7a06-4c4f-9676-e879f341c1bc","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/7135c0b3-7a06-4c4f-9676-e879f341c1bc/","listen_answer":"C","listen_optionList":[{"listen_optionId":2336,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2337,"listen_optionContent":"e","listen_option":"B"},{"listen_optionId":2338,"listen_optionContent":"a","listen_option":"C"}],"listen_questVideo":"4. v___cation n. 假期.mp3","listen_question":"4. v___cation n. 假期","listen_questId":"7135c0b3-7a06-4c4f-9676-e879f341c1bc"},{"listen_resolve":"","hw_answerId":"566217d8-443b-4a8f-96e4-f6e7928ae37d","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/566217d8-443b-4a8f-96e4-f6e7928ae37d/","listen_answer":"B","listen_optionList":[{"listen_optionId":2339,"listen_optionContent":" n. 高山","listen_option":"A"},{"listen_optionId":2340,"listen_optionContent":" n. 国；国家","listen_option":"B"},{"listen_optionId":2341,"listen_optionContent":"n. 冬天；冬季","listen_option":"C"}],"listen_questVideo":"5.\u2014.mp3","listen_question":"5.","listen_questId":"566217d8-443b-4a8f-96e4-f6e7928ae37d"},{"listen_resolve":"","hw_answerId":"aaf7c28c-0f8e-4160-b6db-1536529ea0dc","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/aaf7c28c-0f8e-4160-b6db-1536529ea0dc/","listen_answer":"C","listen_optionList":[{"listen_optionId":2342,"listen_optionContent":"v. 坐","listen_option":"A"},{"listen_optionId":2343,"listen_optionContent":"v. 下雪/n. 雪","listen_option":"B"},{"listen_optionId":2344,"listen_optionContent":"v. 滑冰","listen_option":"C"}],"listen_questVideo":"6.___.mp3","listen_question":"6.","listen_questId":"aaf7c28c-0f8e-4160-b6db-1536529ea0dc"},{"listen_resolve":"","hw_answerId":"fdfad847-2c65-4691-bad9-e7d4adcf39fd","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/fdfad847-2c65-4691-bad9-e7d4adcf39fd/","listen_answer":"A","listen_optionList":[{"listen_optionId":2345,"listen_optionContent":"此刻；马上","listen_option":"A"},{"listen_optionId":2346,"listen_optionContent":"正确","listen_option":"B"},{"listen_optionId":2347,"listen_optionContent":"右转","listen_option":"C"}],"listen_questVideo":"7.____.mp3","listen_question":"7.","listen_questId":"fdfad847-2c65-4691-bad9-e7d4adcf39fd"},{"listen_resolve":"","hw_answerId":"ba69a746-6bf8-450a-b07e-363e75ef71d1","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/ba69a746-6bf8-450a-b07e-363e75ef71d1/","listen_answer":"C","listen_optionList":[{"listen_optionId":2348,"listen_optionContent":"返回","listen_option":"A"},{"listen_optionId":2349,"listen_optionContent":"（给某人）回电话","listen_option":"B"},{"listen_optionId":2350,"listen_optionContent":"捎个口信；传话","listen_option":"C"}],"listen_questVideo":"8.____.mp3","listen_question":"8.","listen_questId":"ba69a746-6bf8-450a-b07e-363e75ef71d1"}],"everyScore":1.56,"listen_video":"","listen_type":"1"}]
         * Relative_path : 1_2_7_1_2001/tingli/03a78ddc-e722-4d23-9eca-925b4725f427/
         */

        private String Relative_path;
        private List<TypeListBean> typeList;

        public String getRelative_path() {
            return Relative_path;
        }

        public void setRelative_path(String Relative_path) {
            this.Relative_path = Relative_path;
        }

        public List<TypeListBean> getTypeList() {
            return typeList;
        }

        public void setTypeList(List<TypeListBean> typeList) {
            this.typeList = typeList;
        }

        public static class TypeListBean {
            /**
             * listen_id : 03a78ddc-e722-4d23-9eca-925b4725f427
             * listen_text : 词汇听力（本题8分）
             * listen_questionList : [{"listen_resolve":"","hw_answerId":"4eda54de-2bd4-4c25-a490-323f11059219","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/4eda54de-2bd4-4c25-a490-323f11059219/","listen_answer":"B","listen_optionList":[{"listen_optionId":2327,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2328,"listen_optionContent":"oo","listen_option":"B"},{"listen_optionId":2329,"listen_optionContent":"u","listen_option":"C"}],"listen_questVideo":"1. c___k v. 做饭.mp3","listen_question":"1. c___k v. 做饭","listen_questId":"4eda54de-2bd4-4c25-a490-323f11059219"},{"listen_resolve":"","hw_answerId":"978ddbf2-c940-4e99-9ff7-937f41280334","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/978ddbf2-c940-4e99-9ff7-937f41280334/","listen_answer":"A","listen_optionList":[{"listen_optionId":2330,"listen_optionContent":"ea","listen_option":"A"},{"listen_optionId":2331,"listen_optionContent":"he","listen_option":"B"},{"listen_optionId":2332,"listen_optionContent":"ae","listen_option":"C"}],"listen_questVideo":"2. w___ther n. 天气.mp3","listen_question":"2. w___ther n. 天气","listen_questId":"978ddbf2-c940-4e99-9ff7-937f41280334"},{"listen_resolve":"","hw_answerId":"29dc06ed-c525-42c5-8a91-501c20bea99c","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/29dc06ed-c525-42c5-8a91-501c20bea99c/","listen_answer":"B","listen_optionList":[{"listen_optionId":2333,"listen_optionContent":"iu","listen_option":"A"},{"listen_optionId":2334,"listen_optionContent":"ui","listen_option":"B"},{"listen_optionId":2335,"listen_optionContent":"u","listen_option":"C"}],"listen_questVideo":"3. j___ce n. 果汁；饮料.mp3","listen_question":"3. j___ce n. 果汁；饮料","listen_questId":"29dc06ed-c525-42c5-8a91-501c20bea99c"},{"listen_resolve":"","hw_answerId":"7135c0b3-7a06-4c4f-9676-e879f341c1bc","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/7135c0b3-7a06-4c4f-9676-e879f341c1bc/","listen_answer":"C","listen_optionList":[{"listen_optionId":2336,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2337,"listen_optionContent":"e","listen_option":"B"},{"listen_optionId":2338,"listen_optionContent":"a","listen_option":"C"}],"listen_questVideo":"4. v___cation n. 假期.mp3","listen_question":"4. v___cation n. 假期","listen_questId":"7135c0b3-7a06-4c4f-9676-e879f341c1bc"},{"listen_resolve":"","hw_answerId":"566217d8-443b-4a8f-96e4-f6e7928ae37d","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/566217d8-443b-4a8f-96e4-f6e7928ae37d/","listen_answer":"B","listen_optionList":[{"listen_optionId":2339,"listen_optionContent":" n. 高山","listen_option":"A"},{"listen_optionId":2340,"listen_optionContent":" n. 国；国家","listen_option":"B"},{"listen_optionId":2341,"listen_optionContent":"n. 冬天；冬季","listen_option":"C"}],"listen_questVideo":"5.\u2014.mp3","listen_question":"5.","listen_questId":"566217d8-443b-4a8f-96e4-f6e7928ae37d"},{"listen_resolve":"","hw_answerId":"aaf7c28c-0f8e-4160-b6db-1536529ea0dc","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/aaf7c28c-0f8e-4160-b6db-1536529ea0dc/","listen_answer":"C","listen_optionList":[{"listen_optionId":2342,"listen_optionContent":"v. 坐","listen_option":"A"},{"listen_optionId":2343,"listen_optionContent":"v. 下雪/n. 雪","listen_option":"B"},{"listen_optionId":2344,"listen_optionContent":"v. 滑冰","listen_option":"C"}],"listen_questVideo":"6.___.mp3","listen_question":"6.","listen_questId":"aaf7c28c-0f8e-4160-b6db-1536529ea0dc"},{"listen_resolve":"","hw_answerId":"fdfad847-2c65-4691-bad9-e7d4adcf39fd","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/fdfad847-2c65-4691-bad9-e7d4adcf39fd/","listen_answer":"A","listen_optionList":[{"listen_optionId":2345,"listen_optionContent":"此刻；马上","listen_option":"A"},{"listen_optionId":2346,"listen_optionContent":"正确","listen_option":"B"},{"listen_optionId":2347,"listen_optionContent":"右转","listen_option":"C"}],"listen_questVideo":"7.____.mp3","listen_question":"7.","listen_questId":"fdfad847-2c65-4691-bad9-e7d4adcf39fd"},{"listen_resolve":"","hw_answerId":"ba69a746-6bf8-450a-b07e-363e75ef71d1","HomeworkPath":"homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/ba69a746-6bf8-450a-b07e-363e75ef71d1/","listen_answer":"C","listen_optionList":[{"listen_optionId":2348,"listen_optionContent":"返回","listen_option":"A"},{"listen_optionId":2349,"listen_optionContent":"（给某人）回电话","listen_option":"B"},{"listen_optionId":2350,"listen_optionContent":"捎个口信；传话","listen_option":"C"}],"listen_questVideo":"8.____.mp3","listen_question":"8.","listen_questId":"ba69a746-6bf8-450a-b07e-363e75ef71d1"}]
             * everyScore : 1.56
             * listen_video :
             * listen_type : 1
             */

            private String listen_id;
            private String listen_text;
            private double everyScore;
            private String listen_video;
            private String listen_type;
            private String listen_content;


            private List<ListenQuestionListBean> listen_questionList;


            public String getListen_content() {
                return listen_content;
            }

            public void setListen_content(String listen_content) {
                this.listen_content = listen_content;
            }

            public String getListen_id() {
                return listen_id;
            }

            public void setListen_id(String listen_id) {
                this.listen_id = listen_id;
            }

            public String getListen_text() {
                return listen_text;
            }

            public void setListen_text(String listen_text) {
                this.listen_text = listen_text;
            }

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public String getListen_video() {
                return listen_video;
            }

            public void setListen_video(String listen_video) {
                this.listen_video = listen_video;
            }

            public String getListen_type() {
                return listen_type;
            }

            public void setListen_type(String listen_type) {
                this.listen_type = listen_type;
            }

            public List<ListenQuestionListBean> getListen_questionList() {
                return listen_questionList;
            }

            public void setListen_questionList(List<ListenQuestionListBean> listen_questionList) {
                this.listen_questionList = listen_questionList;
            }

            public static class ListenQuestionListBean implements Serializable{
                /**
                 * listen_resolve :
                 * hw_answerId : 4eda54de-2bd4-4c25-a490-323f11059219
                 * HomeworkPath : homework/cd546973-a47d-4b6f-a55a-531dc99c698c/12/5/03a78ddc-e722-4d23-9eca-925b4725f427/4eda54de-2bd4-4c25-a490-323f11059219/
                 * listen_answer : B
                 * listen_optionList : [{"listen_optionId":2327,"listen_optionContent":"o","listen_option":"A"},{"listen_optionId":2328,"listen_optionContent":"oo","listen_option":"B"},{"listen_optionId":2329,"listen_optionContent":"u","listen_option":"C"}]
                 * listen_questVideo : 1. c___k v. 做饭.mp3
                 * listen_question : 1. c___k v. 做饭
                 * listen_questId : 4eda54de-2bd4-4c25-a490-323f11059219
                 */

                private String listen_resolve;
                private String hw_answerId;
                private String HomeworkPath;
                private String listen_answer;
                private String listen_questVideo;
                private String listen_question;
                private String listen_questId;
                private List<ListenOptionListBean> listen_optionList;

                public String getListen_resolve() {
                    return listen_resolve;
                }

                public void setListen_resolve(String listen_resolve) {
                    this.listen_resolve = listen_resolve;
                }

                public String getHw_answerId() {
                    return hw_answerId;
                }

                public void setHw_answerId(String hw_answerId) {
                    this.hw_answerId = hw_answerId;
                }

                public String getHomeworkPath() {
                    return HomeworkPath;
                }

                public void setHomeworkPath(String HomeworkPath) {
                    this.HomeworkPath = HomeworkPath;
                }

                public String getListen_answer() {
                    return listen_answer;
                }

                public void setListen_answer(String listen_answer) {
                    this.listen_answer = listen_answer;
                }

                public String getListen_questVideo() {
                    return listen_questVideo;
                }

                public void setListen_questVideo(String listen_questVideo) {
                    this.listen_questVideo = listen_questVideo;
                }

                public String getListen_question() {
                    return listen_question;
                }

                public void setListen_question(String listen_question) {
                    this.listen_question = listen_question;
                }

                public String getListen_questId() {
                    return listen_questId;
                }

                public void setListen_questId(String listen_questId) {
                    this.listen_questId = listen_questId;
                }

                public List<ListenOptionListBean> getListen_optionList() {
                    return listen_optionList;
                }

                public void setListen_optionList(List<ListenOptionListBean> listen_optionList) {
                    this.listen_optionList = listen_optionList;
                }

                public static class ListenOptionListBean implements Serializable{
                    /**
                     * listen_optionId : 2327
                     * listen_optionContent : o
                     * listen_option : A
                     */

                    private int listen_optionId;
                    private String listen_optionContent;
                    private String listen_option;

                    private String listen_optionPhotoes;

                    public String getListen_optionPhotoes() {
                        return listen_optionPhotoes;
                    }

                    public void setListen_optionPhotoes(String listen_optionPhotoes) {
                        this.listen_optionPhotoes = listen_optionPhotoes;
                    }

                    public int getListen_optionId() {
                        return listen_optionId;
                    }

                    public void setListen_optionId(int listen_optionId) {
                        this.listen_optionId = listen_optionId;
                    }

                    public String getListen_optionContent() {
                        return listen_optionContent;
                    }

                    public void setListen_optionContent(String listen_optionContent) {
                        this.listen_optionContent = listen_optionContent;
                    }

                    public String getListen_option() {
                        return listen_option;
                    }

                    public void setListen_option(String listen_option) {
                        this.listen_option = listen_option;
                    }
                }
            }
        }
    }
}
