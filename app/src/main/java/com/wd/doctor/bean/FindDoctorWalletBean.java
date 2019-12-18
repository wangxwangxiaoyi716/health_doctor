package com.wd.doctor.bean;

/**
 * describe:FindDoctorWalletBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:查询医生钱包
 */
public class FindDoctorWalletBean {

    /**
     * result : {"balance":0,"doctorId":155,"id":155,"version":1,"whetherBindBankCard":2,"whetherBindIdCard":2}
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
         * balance : 0
         * doctorId : 155
         * id : 155
         * version : 1
         * whetherBindBankCard : 2
         * whetherBindIdCard : 2
         */

        private int balance;
        private int doctorId;
        private int id;
        private int version;
        private int whetherBindBankCard;
        private int whetherBindIdCard;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getWhetherBindBankCard() {
            return whetherBindBankCard;
        }

        public void setWhetherBindBankCard(int whetherBindBankCard) {
            this.whetherBindBankCard = whetherBindBankCard;
        }

        public int getWhetherBindIdCard() {
            return whetherBindIdCard;
        }

        public void setWhetherBindIdCard(int whetherBindIdCard) {
            this.whetherBindIdCard = whetherBindIdCard;
        }
    }
}
