package com.wd.doctor.bean;

/**
 * describe:SendEmailCodeBean
 * date:2019/12/10
 * author:任(Lenovo)
 * function:    发送邮箱验证码
 */
public class SendEmailCodeBean {

    /**
     * message : 发送成功
     * status : 0000
     */

    private String message;
    private String status;

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
}
