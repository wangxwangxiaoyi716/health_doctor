package com.wd.doctor.bean;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:10:52
 *@Description:
 **/
public class ChaYinHangCardBean {


    /**
     * result : {"bankCardNumber":"4105583244","bankCardType":2,"bankName":"中国农业银行"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * bankCardNumber : 4105583244
         * bankCardType : 2
         * bankName : 中国农业银行
         */

        private String bankCardNumber;
        private int bankCardType;
        private String bankName;

        public String getBankCardNumber() {
            return bankCardNumber;
        }

        public void setBankCardNumber(String bankCardNumber) {
            this.bankCardNumber = bankCardNumber;
        }

        public int getBankCardType() {
            return bankCardType;
        }

        public void setBankCardType(int bankCardType) {
            this.bankCardType = bankCardType;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }
    }
}
