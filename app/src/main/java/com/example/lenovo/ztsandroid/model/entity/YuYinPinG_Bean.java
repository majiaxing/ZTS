package com.example.lenovo.ztsandroid.model.entity;

/**
 * Created by Administrator on 2018/12/11.
 */

public class YuYinPinG_Bean {


    /**
     * Response : {"RequestId":"4edc1f9b-e4f7-42b6-bf2c-5af0ab2b2f4e","SessionId":"ygeghdflwsuhfsiudfhuh"}
     */

    private ResponseBean Response;

    public ResponseBean getResponse() {
        return Response;
    }

    public void setResponse(ResponseBean Response) {
        this.Response = Response;
    }

    public static class ResponseBean {
        /**
         * RequestId : 4edc1f9b-e4f7-42b6-bf2c-5af0ab2b2f4e
         * SessionId : ygeghdflwsuhfsiudfhuh
         */

        private String RequestId;
        private String SessionId;

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
    }
}
