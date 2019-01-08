package com.example.lenovo.ztsandroid.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/11.
 */

public class PinC_Fay_Bean implements Serializable {


    /**
     * Response : {"PronAccuracy":59.961338,"PronFluency":0.81533897,"PronCompletion":1,"RequestId":"23f24059-73de-491e-9d36-a6209c54cc57","Words":[{"MemBeginTime":4560,"MemEndTime":5610,"PronAccuracy":59.961338,"PronFluency":0.81533897,"Word":"china","MatchTag":0,"PhoneInfos":[{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]}],"SessionId":"1544726293771","AudioUrl":"","SentenceInfoSet":[{"words":[{"MemBeginTime":4560,"MemEndTime":5610,"PronAccuracy":59.961338,"PronFluency":0.81533897,"Word":"china","MatchTag":0,"PhoneInfos":[{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]}],"sentence_id":-1}]}
     */

    private ResponseBean Response;

    public ResponseBean getResponse() {
        return Response;
    }

    public void setResponse(ResponseBean Response) {
        this.Response = Response;
    }

    public static class ResponseBean implements Serializable{
        /**
         * PronAccuracy : 59.961338
         * PronFluency : 0.81533897
         * PronCompletion : 1
         * RequestId : 23f24059-73de-491e-9d36-a6209c54cc57
         * Words : [{"MemBeginTime":4560,"MemEndTime":5610,"PronAccuracy":59.961338,"PronFluency":0.81533897,"Word":"china","MatchTag":0,"PhoneInfos":[{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]}]
         * SessionId : 1544726293771
         * AudioUrl :
         * SentenceInfoSet : [{"words":[{"MemBeginTime":4560,"MemEndTime":5610,"PronAccuracy":59.961338,"PronFluency":0.81533897,"Word":"china","MatchTag":0,"PhoneInfos":[{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]}],"sentence_id":-1}]
         */

        private double PronAccuracy;
        private double PronFluency;
        private int PronCompletion;
        private String RequestId;
        private String SessionId;
        private String AudioUrl;
        private List<WordsBean> Words;
        private List<SentenceInfoSetBean> SentenceInfoSet;

        public double getPronAccuracy() {
            return PronAccuracy;
        }

        public void setPronAccuracy(double PronAccuracy) {
            this.PronAccuracy = PronAccuracy;
        }

        public double getPronFluency() {
            return PronFluency;
        }

        public void setPronFluency(double PronFluency) {
            this.PronFluency = PronFluency;
        }

        public int getPronCompletion() {
            return PronCompletion;
        }

        public void setPronCompletion(int PronCompletion) {
            this.PronCompletion = PronCompletion;
        }

        public String getRequestId() {
            return RequestId;
        }

        public void setRequestId(String RequestId) {
            this.RequestId = RequestId;
        }

        public String getSessionId() {
            return SessionId;
        }

        public void setSessionId(String SessionId) {
            this.SessionId = SessionId;
        }

        public String getAudioUrl() {
            return AudioUrl;
        }

        public void setAudioUrl(String AudioUrl) {
            this.AudioUrl = AudioUrl;
        }

        public List<WordsBean> getWords() {
            return Words;
        }

        public void setWords(List<WordsBean> Words) {
            this.Words = Words;
        }

        public List<SentenceInfoSetBean> getSentenceInfoSet() {
            return SentenceInfoSet;
        }

        public void setSentenceInfoSet(List<SentenceInfoSetBean> SentenceInfoSet) {
            this.SentenceInfoSet = SentenceInfoSet;
        }

        public static class WordsBean implements Serializable{
            /**
             * MemBeginTime : 4560
             * MemEndTime : 5610
             * PronAccuracy : 59.961338
             * PronFluency : 0.81533897
             * Word : china
             * MatchTag : 0
             * PhoneInfos : [{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]
             */

            private int MemBeginTime;
            private int MemEndTime;
            private double PronAccuracy;
            private double PronFluency;
            private String Word;
            private int MatchTag;
            private List<PhoneInfosBean> PhoneInfos;

            public int getMemBeginTime() {
                return MemBeginTime;
            }

            public void setMemBeginTime(int MemBeginTime) {
                this.MemBeginTime = MemBeginTime;
            }

            public int getMemEndTime() {
                return MemEndTime;
            }

            public void setMemEndTime(int MemEndTime) {
                this.MemEndTime = MemEndTime;
            }

            public double getPronAccuracy() {
                return PronAccuracy;
            }

            public void setPronAccuracy(double PronAccuracy) {
                this.PronAccuracy = PronAccuracy;
            }

            public double getPronFluency() {
                return PronFluency;
            }

            public void setPronFluency(double PronFluency) {
                this.PronFluency = PronFluency;
            }

            public String getWord() {
                return Word;
            }

            public void setWord(String Word) {
                this.Word = Word;
            }

            public int getMatchTag() {
                return MatchTag;
            }

            public void setMatchTag(int MatchTag) {
                this.MatchTag = MatchTag;
            }

            public List<PhoneInfosBean> getPhoneInfos() {
                return PhoneInfos;
            }

            public void setPhoneInfos(List<PhoneInfosBean> PhoneInfos) {
                this.PhoneInfos = PhoneInfos;
            }

            public static class PhoneInfosBean implements Serializable{
                /**
                 * MemBeginTime : 4560
                 * MemEndTime : 4840
                 * PronAccuracy : 100
                 * DetectedStress : true
                 * Phone : 'tʃ
                 * Stress : true
                 */

                private int MemBeginTime;
                private int MemEndTime;
                private int PronAccuracy;
                private boolean DetectedStress;
                private String Phone;
                private boolean Stress;

                public int getMemBeginTime() {
                    return MemBeginTime;
                }

                public void setMemBeginTime(int MemBeginTime) {
                    this.MemBeginTime = MemBeginTime;
                }

                public int getMemEndTime() {
                    return MemEndTime;
                }

                public void setMemEndTime(int MemEndTime) {
                    this.MemEndTime = MemEndTime;
                }

                public int getPronAccuracy() {
                    return PronAccuracy;
                }

                public void setPronAccuracy(int PronAccuracy) {
                    this.PronAccuracy = PronAccuracy;
                }

                public boolean isDetectedStress() {
                    return DetectedStress;
                }

                public void setDetectedStress(boolean DetectedStress) {
                    this.DetectedStress = DetectedStress;
                }

                public String getPhone() {
                    return Phone;
                }

                public void setPhone(String Phone) {
                    this.Phone = Phone;
                }

                public boolean isStress() {
                    return Stress;
                }

                public void setStress(boolean Stress) {
                    this.Stress = Stress;
                }
            }
        }

        public static class SentenceInfoSetBean implements Serializable{
            /**
             * words : [{"MemBeginTime":4560,"MemEndTime":5610,"PronAccuracy":59.961338,"PronFluency":0.81533897,"Word":"china","MatchTag":0,"PhoneInfos":[{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]}]
             * sentence_id : -1
             */

            private int sentence_id;
            private List<WordsBeanX> words;

            public int getSentence_id() {
                return sentence_id;
            }

            public void setSentence_id(int sentence_id) {
                this.sentence_id = sentence_id;
            }

            public List<WordsBeanX> getWords() {
                return words;
            }

            public void setWords(List<WordsBeanX> words) {
                this.words = words;
            }

            public static class WordsBeanX implements Serializable{
                /**
                 * MemBeginTime : 4560
                 * MemEndTime : 5610
                 * PronAccuracy : 59.961338
                 * PronFluency : 0.81533897
                 * Word : china
                 * MatchTag : 0
                 * PhoneInfos : [{"MemBeginTime":4560,"MemEndTime":4840,"PronAccuracy":100,"DetectedStress":true,"Phone":"'tʃ","Stress":true},{"MemBeginTime":4840,"MemEndTime":5110,"PronAccuracy":100,"DetectedStress":false,"Phone":"aɪ","Stress":false},{"MemBeginTime":5110,"MemEndTime":5250,"PronAccuracy":32.27586,"DetectedStress":false,"Phone":"n","Stress":false},{"MemBeginTime":5250,"MemEndTime":5610,"PronAccuracy":7.5694857,"DetectedStress":false,"Phone":"ə","Stress":false}]
                 */

                private int MemBeginTime;
                private int MemEndTime;
                private double PronAccuracy;
                private double PronFluency;
                private String Word;
                private int MatchTag;
                private List<PhoneInfosBeanX> PhoneInfos;

                public int getMemBeginTime() {
                    return MemBeginTime;
                }

                public void setMemBeginTime(int MemBeginTime) {
                    this.MemBeginTime = MemBeginTime;
                }

                public int getMemEndTime() {
                    return MemEndTime;
                }

                public void setMemEndTime(int MemEndTime) {
                    this.MemEndTime = MemEndTime;
                }

                public double getPronAccuracy() {
                    return PronAccuracy;
                }

                public void setPronAccuracy(double PronAccuracy) {
                    this.PronAccuracy = PronAccuracy;
                }

                public double getPronFluency() {
                    return PronFluency;
                }

                public void setPronFluency(double PronFluency) {
                    this.PronFluency = PronFluency;
                }

                public String getWord() {
                    return Word;
                }

                public void setWord(String Word) {
                    this.Word = Word;
                }

                public int getMatchTag() {
                    return MatchTag;
                }

                public void setMatchTag(int MatchTag) {
                    this.MatchTag = MatchTag;
                }

                public List<PhoneInfosBeanX> getPhoneInfos() {
                    return PhoneInfos;
                }

                public void setPhoneInfos(List<PhoneInfosBeanX> PhoneInfos) {
                    this.PhoneInfos = PhoneInfos;
                }

                public static class PhoneInfosBeanX implements Serializable{
                    /**
                     * MemBeginTime : 4560
                     * MemEndTime : 4840
                     * PronAccuracy : 100
                     * DetectedStress : true
                     * Phone : 'tʃ
                     * Stress : true
                     */

                    private int MemBeginTime;
                    private int MemEndTime;
                    private int PronAccuracy;
                    private boolean DetectedStress;
                    private String Phone;
                    private boolean Stress;

                    public int getMemBeginTime() {
                        return MemBeginTime;
                    }

                    public void setMemBeginTime(int MemBeginTime) {
                        this.MemBeginTime = MemBeginTime;
                    }

                    public int getMemEndTime() {
                        return MemEndTime;
                    }

                    public void setMemEndTime(int MemEndTime) {
                        this.MemEndTime = MemEndTime;
                    }

                    public int getPronAccuracy() {
                        return PronAccuracy;
                    }

                    public void setPronAccuracy(int PronAccuracy) {
                        this.PronAccuracy = PronAccuracy;
                    }

                    public boolean isDetectedStress() {
                        return DetectedStress;
                    }

                    public void setDetectedStress(boolean DetectedStress) {
                        this.DetectedStress = DetectedStress;
                    }

                    public String getPhone() {
                        return Phone;
                    }

                    public void setPhone(String Phone) {
                        this.Phone = Phone;
                    }

                    public boolean isStress() {
                        return Stress;
                    }

                    public void setStress(boolean Stress) {
                        this.Stress = Stress;
                    }
                }
            }
        }
    }
}
