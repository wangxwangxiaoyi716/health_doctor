package com.wd.doctor.bean;

/**
 * describe:UploadImagePicBean
 * date:2019/12/11
 * author:任(Lenovo)
 * function:上传形象照
 */
public class UploadImagePicBean {

    /**
     * result : http://172.17.8.100/images/health/doctor/image_pic/2019-12-11/DeSQD720191211141537.png
     * message : 上传成功
     * status : 0000
     */

    private String result;
    private String message;
    private String status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
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
}
