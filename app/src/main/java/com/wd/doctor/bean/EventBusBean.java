package com.wd.doctor.bean;

/*
 *@auther:王晓义
 *@Date: 2019/12/26
 *@Time:10:53
 *@Description:
 **/
public class EventBusBean {
    int userid;

    public EventBusBean(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "EventBusBean{" +
                "userid=" + userid +
                '}';
    }
}
