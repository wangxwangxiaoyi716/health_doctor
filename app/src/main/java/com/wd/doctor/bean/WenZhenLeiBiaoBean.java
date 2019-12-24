package com.wd.doctor.bean;

import java.util.List;

/*
 *@auther:王晓义
 *@Date: 2019/12/23
 *@Time:19:00
 *@Description:
 **/
public class WenZhenLeiBiaoBean {

    /**
     * result : [{"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","inquiryTime":1577098752000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","nickName":"Why","recordId":3829,"status":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg","userId":436,"userName":"tdmOYx294617378"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * inquiryTime : 1577098752000
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * nickName : Why
         * recordId : 3829
         * status : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg
         * userId : 436
         * userName : tdmOYx294617378
         */

        private String doctorHeadPic;
        private long inquiryTime;
        private String jiGuangPwd;
        private String nickName;
        private int recordId;
        private int status;
        private String userHeadPic;
        private int userId;
        private String userName;

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public long getInquiryTime() {
            return inquiryTime;
        }

        public void setInquiryTime(long inquiryTime) {
            this.inquiryTime = inquiryTime;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
