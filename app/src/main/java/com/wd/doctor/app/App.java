package com.wd.doctor.app;

import cn.jpush.im.android.api.JMessageClient;

/*
 *@auther:王晓义
 *@Date: 2019/12/25
 *@Time:11:41
 *@Description:
 **/
public class App extends com.bw.movie.app.App {
    @Override
    public void onCreate() {
        super.onCreate();
        JMessageClient.init(getApplicationContext());
    }
}
