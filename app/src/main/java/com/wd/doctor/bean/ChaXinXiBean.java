package com.wd.doctor.bean;

import java.util.List;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:15:54
 *@Description:
 **/
public class ChaXinXiBean {

    /**
     * result : [{"askTime":1577193127000,"content":"4","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577193118000,"content":"班","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577193106000,"content":"5","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577193028000,"content":"看见","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577193023000,"content":"11","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577192335000,"content":"1","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577192328000,"content":"1","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577192003000,"content":"王晓义我儿子","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577191846000,"content":"王晓义我儿子","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"},{"askTime":1577191428000,"content":"王晓义我儿子","direction":2,"doctorHeadPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","msgType":1,"userHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg"}]
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
         * askTime : 1577193127000
         * content : 4
         * direction : 2
         * doctorHeadPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
         * msgType : 1
         * userHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-12-22/h4iWWg20191222200159.jpeg
         */

        private long askTime;
        private String content;
        private int direction;
        private String doctorHeadPic;
        private int msgType;
        private String userHeadPic;

        public long getAskTime() {
            return askTime;
        }

        public void setAskTime(long askTime) {
            this.askTime = askTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public String getDoctorHeadPic() {
            return doctorHeadPic;
        }

        public void setDoctorHeadPic(String doctorHeadPic) {
            this.doctorHeadPic = doctorHeadPic;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }

        public String getUserHeadPic() {
            return userHeadPic;
        }

        public void setUserHeadPic(String userHeadPic) {
            this.userHeadPic = userHeadPic;
        }
    }
}
