package com.wd.doctor.bean;

/**
 *@describe(描述)：SickCircleInfoBean
 *@data（日期）: 2019/12/13
 *@time（时间）: 15:54
 *@author（作者）: wangxiaoyi
 **/
//查询病友圈详情
public class SickCircleInfoBean {

    /**
     * result : {"amount":0,"authorName":"LQ_PTBPO","departmentId":2,"departmentName":"骨科","detail":"4too宏观经济","disease":"退行性关节病","id":1655,"title":"挂机了","treatmentEndTime":1575561600000,"treatmentHospital":"你看看","treatmentProcess":"哈哈","treatmentStartTime":1575561600000,"userId":410,"whetherContent":2}
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
         * amount : 0
         * authorName : LQ_PTBPO
         * departmentId : 2
         * departmentName : 骨科
         * detail : 4too宏观经济
         * disease : 退行性关节病
         * id : 1655
         * title : 挂机了
         * treatmentEndTime : 1575561600000
         * treatmentHospital : 你看看
         * treatmentProcess : 哈哈
         * treatmentStartTime : 1575561600000
         * userId : 410
         * whetherContent : 2
         */

        private int amount;
        private String authorName;
        private int departmentId;
        private String departmentName;
        private String detail;
        private String disease;
        private int id;
        private String title;
        private long treatmentEndTime;
        private String treatmentHospital;
        private String treatmentProcess;
        private long treatmentStartTime;
        private int userId;
        private int whetherContent;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospital() {
            return treatmentHospital;
        }

        public void setTreatmentHospital(String treatmentHospital) {
            this.treatmentHospital = treatmentHospital;
        }

        public String getTreatmentProcess() {
            return treatmentProcess;
        }

        public void setTreatmentProcess(String treatmentProcess) {
            this.treatmentProcess = treatmentProcess;
        }

        public long getTreatmentStartTime() {
            return treatmentStartTime;
        }

        public void setTreatmentStartTime(long treatmentStartTime) {
            this.treatmentStartTime = treatmentStartTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherContent() {
            return whetherContent;
        }

        public void setWhetherContent(int whetherContent) {
            this.whetherContent = whetherContent;
        }
    }
}
