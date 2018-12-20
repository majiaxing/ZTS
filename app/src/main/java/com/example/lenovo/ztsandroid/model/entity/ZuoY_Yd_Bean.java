package com.example.lenovo.ztsandroid.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_Yd_Bean {


    /**
     * data : {"HomeworkPath":"homework/4567/41/","typeList":[{"read_text":"(B)","everyScore":2.5,"read_content":"Tom has a new room. In his room, a picture is on the table. Three people are in the picture, his father, his mother and he. A desk, a chair, a bed and a bookcase are in the new room, too. A baseball is under the chair and some CDs are under the bed. A hat is on the desk. Some plants are on the floor. A bookcase is next to the bed. Some English books are in the bookcase. What a nice room!","read_questionList":[{"read_question":"1. What is under the chair?","hw_answerId":"ff99211b-a8ef-446f-851f-22389764bf7a","read_optionList":[{"read_option":"A","read_xid":"b69723e0-cdc3-4078-8f64-b1aeb26d4b48","read_optionText":" Some CDs"},{"read_option":"B","read_xid":"4ad845fa-1585-4746-9bdb-95f1db872925","read_optionText":" A baseball."},{"read_option":"C","read_xid":"b64815bb-3539-4959-887f-c886af181ba0","read_optionText":"A hat."},{"read_option":"D","read_xid":"bd236ede-0f82-4380-8a14-e27e0f4c3930","read_optionText":"Some plants."}],"read_answer":"B","read_qid":"ff99211b-a8ef-446f-851f-22389764bf7a","read_resolve":"考点：\n理解性技能-抓取细节-事物\n"},{"read_question":"2. Where are the plants?","hw_answerId":"b2ee5fea-207c-42c9-bee1-d11bcd381ab6","read_optionList":[{"read_option":"A","read_xid":"29b8650d-061d-4022-bf13-fbd7a400e3ce","read_optionText":"On the desk."},{"read_option":"B","read_xid":"8a4c6d10-bc24-4d13-956c-5234a0d62fa2","read_optionText":"Under the bed."},{"read_option":"C","read_xid":"34744aa3-7aa6-4920-97cc-00416bf18a4e","read_optionText":"On the floor."},{"read_option":"D","read_xid":"d429f576-36a8-4266-af2e-3eaa16b03df0","read_optionText":"In the picture."}],"read_answer":"C","read_qid":"b2ee5fea-207c-42c9-bee1-d11bcd381ab6","read_resolve":"考点：\n理解性技能-抓取细节-地点\n"},{"read_question":"3. How many people are there in the picture?","hw_answerId":"44678b34-b223-4c66-a6b8-d25f884628c9","read_optionList":[{"read_option":"A","read_xid":"995875ff-bb60-41eb-b4ec-c6963f433b74","read_optionText":" Two."},{"read_option":"B","read_xid":"2c8ff65e-8513-413c-b005-bcb1c2e65c18","read_optionText":"Three."},{"read_option":"C","read_xid":"1e67c5b8-e2bf-4898-b4d5-7e3e7d04320e","read_optionText":" Four"},{"read_option":"D","read_xid":"6e7ebdc0-a352-47fb-a331-8c8e6ab8e709","read_optionText":"Five."}],"read_answer":"B","read_qid":"44678b34-b223-4c66-a6b8-d25f884628c9","read_resolve":"考点：\n理解性技能-推理判断\n"},{"read_question":"4. What's next to the bed?","hw_answerId":"4983af1d-7785-4f78-a012-1740e9e12e4f","read_optionList":[{"read_option":"A","read_xid":"56d33774-a8d9-4f3d-a8f6-3aa0ed02483f","read_optionText":"A book"},{"read_option":"B","read_xid":"08d51454-86d9-4fd9-a6a9-a653240d502b","read_optionText":" A baseball."},{"read_option":"C","read_xid":"5f24fdf2-5364-42bd-a20f-3a34152448e5","read_optionText":"A bookcase."},{"read_option":"D","read_xid":"8b2f4bd9-415e-4dda-9a6d-65e3649ec5d1","read_optionText":"We don't know."}],"read_answer":"C","read_qid":"4983af1d-7785-4f78-a012-1740e9e12e4f","read_resolve":"考点：\n理解性技能-抓取细节-事物\n"},{"read_question":"5. What kind of books are in the bookcase?","hw_answerId":"0e4d1373-7895-4f7a-b8b5-45088cdea04d","read_optionList":[{"read_option":"A","read_xid":"30ab3ec7-ea1b-4727-bdf1-bd4ec7543c54","read_optionText":"English books."},{"read_option":"B","read_xid":"3a5ab687-cb9a-430d-a4f1-8c338e8e6c51","read_optionText":"Science books"},{"read_option":"C","read_xid":"dff93042-83fd-404f-a5c7-7419aaa2213a","read_optionText":"History books."},{"read_option":"D","read_xid":"121a1300-1d9f-4f09-bc82-8bf27473f84a","read_optionText":"Story books."}],"read_answer":"A","read_qid":"0e4d1373-7895-4f7a-b8b5-45088cdea04d","read_resolve":"考点：\n理解性技能-抓取细节-特征\n"}]}],"Relative_path":"1_2_7_1_4/yuedu/1651b61f-e2dc-4a7f-9c59-32cc164f4092/"}
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

    public static class DataBean {
        /**
         * HomeworkPath : homework/4567/41/
         * typeList : [{"read_text":"(B)","everyScore":2.5,"read_content":"Tom has a new room. In his room, a picture is on the table. Three people are in the picture, his father, his mother and he. A desk, a chair, a bed and a bookcase are in the new room, too. A baseball is under the chair and some CDs are under the bed. A hat is on the desk. Some plants are on the floor. A bookcase is next to the bed. Some English books are in the bookcase. What a nice room!","read_questionList":[{"read_question":"1. What is under the chair?","hw_answerId":"ff99211b-a8ef-446f-851f-22389764bf7a","read_optionList":[{"read_option":"A","read_xid":"b69723e0-cdc3-4078-8f64-b1aeb26d4b48","read_optionText":" Some CDs"},{"read_option":"B","read_xid":"4ad845fa-1585-4746-9bdb-95f1db872925","read_optionText":" A baseball."},{"read_option":"C","read_xid":"b64815bb-3539-4959-887f-c886af181ba0","read_optionText":"A hat."},{"read_option":"D","read_xid":"bd236ede-0f82-4380-8a14-e27e0f4c3930","read_optionText":"Some plants."}],"read_answer":"B","read_qid":"ff99211b-a8ef-446f-851f-22389764bf7a","read_resolve":"考点：\n理解性技能-抓取细节-事物\n"},{"read_question":"2. Where are the plants?","hw_answerId":"b2ee5fea-207c-42c9-bee1-d11bcd381ab6","read_optionList":[{"read_option":"A","read_xid":"29b8650d-061d-4022-bf13-fbd7a400e3ce","read_optionText":"On the desk."},{"read_option":"B","read_xid":"8a4c6d10-bc24-4d13-956c-5234a0d62fa2","read_optionText":"Under the bed."},{"read_option":"C","read_xid":"34744aa3-7aa6-4920-97cc-00416bf18a4e","read_optionText":"On the floor."},{"read_option":"D","read_xid":"d429f576-36a8-4266-af2e-3eaa16b03df0","read_optionText":"In the picture."}],"read_answer":"C","read_qid":"b2ee5fea-207c-42c9-bee1-d11bcd381ab6","read_resolve":"考点：\n理解性技能-抓取细节-地点\n"},{"read_question":"3. How many people are there in the picture?","hw_answerId":"44678b34-b223-4c66-a6b8-d25f884628c9","read_optionList":[{"read_option":"A","read_xid":"995875ff-bb60-41eb-b4ec-c6963f433b74","read_optionText":" Two."},{"read_option":"B","read_xid":"2c8ff65e-8513-413c-b005-bcb1c2e65c18","read_optionText":"Three."},{"read_option":"C","read_xid":"1e67c5b8-e2bf-4898-b4d5-7e3e7d04320e","read_optionText":" Four"},{"read_option":"D","read_xid":"6e7ebdc0-a352-47fb-a331-8c8e6ab8e709","read_optionText":"Five."}],"read_answer":"B","read_qid":"44678b34-b223-4c66-a6b8-d25f884628c9","read_resolve":"考点：\n理解性技能-推理判断\n"},{"read_question":"4. What's next to the bed?","hw_answerId":"4983af1d-7785-4f78-a012-1740e9e12e4f","read_optionList":[{"read_option":"A","read_xid":"56d33774-a8d9-4f3d-a8f6-3aa0ed02483f","read_optionText":"A book"},{"read_option":"B","read_xid":"08d51454-86d9-4fd9-a6a9-a653240d502b","read_optionText":" A baseball."},{"read_option":"C","read_xid":"5f24fdf2-5364-42bd-a20f-3a34152448e5","read_optionText":"A bookcase."},{"read_option":"D","read_xid":"8b2f4bd9-415e-4dda-9a6d-65e3649ec5d1","read_optionText":"We don't know."}],"read_answer":"C","read_qid":"4983af1d-7785-4f78-a012-1740e9e12e4f","read_resolve":"考点：\n理解性技能-抓取细节-事物\n"},{"read_question":"5. What kind of books are in the bookcase?","hw_answerId":"0e4d1373-7895-4f7a-b8b5-45088cdea04d","read_optionList":[{"read_option":"A","read_xid":"30ab3ec7-ea1b-4727-bdf1-bd4ec7543c54","read_optionText":"English books."},{"read_option":"B","read_xid":"3a5ab687-cb9a-430d-a4f1-8c338e8e6c51","read_optionText":"Science books"},{"read_option":"C","read_xid":"dff93042-83fd-404f-a5c7-7419aaa2213a","read_optionText":"History books."},{"read_option":"D","read_xid":"121a1300-1d9f-4f09-bc82-8bf27473f84a","read_optionText":"Story books."}],"read_answer":"A","read_qid":"0e4d1373-7895-4f7a-b8b5-45088cdea04d","read_resolve":"考点：\n理解性技能-抓取细节-特征\n"}]}]
         * Relative_path : 1_2_7_1_4/yuedu/1651b61f-e2dc-4a7f-9c59-32cc164f4092/
         */

        private String HomeworkPath;
        private String Relative_path;
        private List<TypeListBean> typeList;

        public String getHomeworkPath() {
            return HomeworkPath;
        }

        public void setHomeworkPath(String HomeworkPath) {
            this.HomeworkPath = HomeworkPath;
        }

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
             * read_text : (B)
             * everyScore : 2.5
             * read_content : Tom has a new room. In his room, a picture is on the table. Three people are in the picture, his father, his mother and he. A desk, a chair, a bed and a bookcase are in the new room, too. A baseball is under the chair and some CDs are under the bed. A hat is on the desk. Some plants are on the floor. A bookcase is next to the bed. Some English books are in the bookcase. What a nice room!
             * read_questionList : [{"read_question":"1. What is under the chair?","hw_answerId":"ff99211b-a8ef-446f-851f-22389764bf7a","read_optionList":[{"read_option":"A","read_xid":"b69723e0-cdc3-4078-8f64-b1aeb26d4b48","read_optionText":" Some CDs"},{"read_option":"B","read_xid":"4ad845fa-1585-4746-9bdb-95f1db872925","read_optionText":" A baseball."},{"read_option":"C","read_xid":"b64815bb-3539-4959-887f-c886af181ba0","read_optionText":"A hat."},{"read_option":"D","read_xid":"bd236ede-0f82-4380-8a14-e27e0f4c3930","read_optionText":"Some plants."}],"read_answer":"B","read_qid":"ff99211b-a8ef-446f-851f-22389764bf7a","read_resolve":"考点：\n理解性技能-抓取细节-事物\n"},{"read_question":"2. Where are the plants?","hw_answerId":"b2ee5fea-207c-42c9-bee1-d11bcd381ab6","read_optionList":[{"read_option":"A","read_xid":"29b8650d-061d-4022-bf13-fbd7a400e3ce","read_optionText":"On the desk."},{"read_option":"B","read_xid":"8a4c6d10-bc24-4d13-956c-5234a0d62fa2","read_optionText":"Under the bed."},{"read_option":"C","read_xid":"34744aa3-7aa6-4920-97cc-00416bf18a4e","read_optionText":"On the floor."},{"read_option":"D","read_xid":"d429f576-36a8-4266-af2e-3eaa16b03df0","read_optionText":"In the picture."}],"read_answer":"C","read_qid":"b2ee5fea-207c-42c9-bee1-d11bcd381ab6","read_resolve":"考点：\n理解性技能-抓取细节-地点\n"},{"read_question":"3. How many people are there in the picture?","hw_answerId":"44678b34-b223-4c66-a6b8-d25f884628c9","read_optionList":[{"read_option":"A","read_xid":"995875ff-bb60-41eb-b4ec-c6963f433b74","read_optionText":" Two."},{"read_option":"B","read_xid":"2c8ff65e-8513-413c-b005-bcb1c2e65c18","read_optionText":"Three."},{"read_option":"C","read_xid":"1e67c5b8-e2bf-4898-b4d5-7e3e7d04320e","read_optionText":" Four"},{"read_option":"D","read_xid":"6e7ebdc0-a352-47fb-a331-8c8e6ab8e709","read_optionText":"Five."}],"read_answer":"B","read_qid":"44678b34-b223-4c66-a6b8-d25f884628c9","read_resolve":"考点：\n理解性技能-推理判断\n"},{"read_question":"4. What's next to the bed?","hw_answerId":"4983af1d-7785-4f78-a012-1740e9e12e4f","read_optionList":[{"read_option":"A","read_xid":"56d33774-a8d9-4f3d-a8f6-3aa0ed02483f","read_optionText":"A book"},{"read_option":"B","read_xid":"08d51454-86d9-4fd9-a6a9-a653240d502b","read_optionText":" A baseball."},{"read_option":"C","read_xid":"5f24fdf2-5364-42bd-a20f-3a34152448e5","read_optionText":"A bookcase."},{"read_option":"D","read_xid":"8b2f4bd9-415e-4dda-9a6d-65e3649ec5d1","read_optionText":"We don't know."}],"read_answer":"C","read_qid":"4983af1d-7785-4f78-a012-1740e9e12e4f","read_resolve":"考点：\n理解性技能-抓取细节-事物\n"},{"read_question":"5. What kind of books are in the bookcase?","hw_answerId":"0e4d1373-7895-4f7a-b8b5-45088cdea04d","read_optionList":[{"read_option":"A","read_xid":"30ab3ec7-ea1b-4727-bdf1-bd4ec7543c54","read_optionText":"English books."},{"read_option":"B","read_xid":"3a5ab687-cb9a-430d-a4f1-8c338e8e6c51","read_optionText":"Science books"},{"read_option":"C","read_xid":"dff93042-83fd-404f-a5c7-7419aaa2213a","read_optionText":"History books."},{"read_option":"D","read_xid":"121a1300-1d9f-4f09-bc82-8bf27473f84a","read_optionText":"Story books."}],"read_answer":"A","read_qid":"0e4d1373-7895-4f7a-b8b5-45088cdea04d","read_resolve":"考点：\n理解性技能-抓取细节-特征\n"}]
             */

            private String read_text;
            private double everyScore;
            private String read_content;
            private List<ReadQuestionListBean> read_questionList;

            public String getRead_text() {
                return read_text;
            }

            public void setRead_text(String read_text) {
                this.read_text = read_text;
            }

            public double getEveryScore() {
                return everyScore;
            }

            public void setEveryScore(double everyScore) {
                this.everyScore = everyScore;
            }

            public String getRead_content() {
                return read_content;
            }

            public void setRead_content(String read_content) {
                this.read_content = read_content;
            }

            public List<ReadQuestionListBean> getRead_questionList() {
                return read_questionList;
            }

            public void setRead_questionList(List<ReadQuestionListBean> read_questionList) {
                this.read_questionList = read_questionList;
            }

            public static class ReadQuestionListBean {
                /**
                 * read_question : 1. What is under the chair?
                 * hw_answerId : ff99211b-a8ef-446f-851f-22389764bf7a
                 * read_optionList : [{"read_option":"A","read_xid":"b69723e0-cdc3-4078-8f64-b1aeb26d4b48","read_optionText":" Some CDs"},{"read_option":"B","read_xid":"4ad845fa-1585-4746-9bdb-95f1db872925","read_optionText":" A baseball."},{"read_option":"C","read_xid":"b64815bb-3539-4959-887f-c886af181ba0","read_optionText":"A hat."},{"read_option":"D","read_xid":"bd236ede-0f82-4380-8a14-e27e0f4c3930","read_optionText":"Some plants."}]
                 * read_answer : B
                 * read_qid : ff99211b-a8ef-446f-851f-22389764bf7a
                 * read_resolve : 考点：
                 理解性技能-抓取细节-事物

                 */

                private String read_question;
                private String hw_answerId;
                private String read_answer;
                private String read_qid;
                private String read_resolve;
                private List<ReadOptionListBean> read_optionList;

                public String getRead_question() {
                    return read_question;
                }

                public void setRead_question(String read_question) {
                    this.read_question = read_question;
                }

                public String getHw_answerId() {
                    return hw_answerId;
                }

                public void setHw_answerId(String hw_answerId) {
                    this.hw_answerId = hw_answerId;
                }

                public String getRead_answer() {
                    return read_answer;
                }

                public void setRead_answer(String read_answer) {
                    this.read_answer = read_answer;
                }

                public String getRead_qid() {
                    return read_qid;
                }

                public void setRead_qid(String read_qid) {
                    this.read_qid = read_qid;
                }

                public String getRead_resolve() {
                    return read_resolve;
                }

                public void setRead_resolve(String read_resolve) {
                    this.read_resolve = read_resolve;
                }

                public List<ReadOptionListBean> getRead_optionList() {
                    return read_optionList;
                }

                public void setRead_optionList(List<ReadOptionListBean> read_optionList) {
                    this.read_optionList = read_optionList;
                }

                public static class ReadOptionListBean {
                    /**
                     * read_option : A
                     * read_xid : b69723e0-cdc3-4078-8f64-b1aeb26d4b48
                     * read_optionText :  Some CDs
                     */

                    private String read_option;
                    private String read_xid;
                    private String read_optionText;

                    public String getRead_option() {
                        return read_option;
                    }

                    public void setRead_option(String read_option) {
                        this.read_option = read_option;
                    }

                    public String getRead_xid() {
                        return read_xid;
                    }

                    public void setRead_xid(String read_xid) {
                        this.read_xid = read_xid;
                    }

                    public String getRead_optionText() {
                        return read_optionText;
                    }

                    public void setRead_optionText(String read_optionText) {
                        this.read_optionText = read_optionText;
                    }
                }
            }
        }
    }
}
