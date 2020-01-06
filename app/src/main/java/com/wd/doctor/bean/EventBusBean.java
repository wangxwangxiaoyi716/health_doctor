package com.wd.doctor.bean;

/*
 *@auther:王晓义
 *@Date: 2019/12/26
 *@Time:10:53
 *@Description:
 **/
public class EventBusBean {
    int userid;
    String nickName;
    int inquiryId;

    public EventBusBean(int userid, String nickName, int inquiryId) {
        this.userid = userid;
        this.nickName = nickName;
        this.inquiryId = inquiryId;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(int inquiryId) {
        this.inquiryId = inquiryId;
    }

    @Override
    public String toString() {
        return "EventBusBean{" +
                "userid=" + userid +
                ", nickName='" + nickName + '\'' +
                ", inquiryId=" + inquiryId +
                '}';
    }
}
