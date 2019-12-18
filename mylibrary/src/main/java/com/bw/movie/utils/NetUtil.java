package com.bw.movie.utils;
/**
 *@describe(描述)：NetUtil
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:05
 *@author（作者）: wangxiaoyi
 **/

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    public static  boolean hasNetwork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isConnected()){
            return true;
        }else {
            return false;
        }
    }
}
