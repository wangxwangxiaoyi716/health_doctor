package com.bw.movie;

import android.content.Context;
import android.widget.Toast;

/**
 *@describe(描述)：ToastUtils
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:05
 *@author（作者）: wangxiaoyi
 **/

public class ToastUtils {
    private static Toast mToast;

    public static void init(Context context) {
        mToast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
    }

    public static void show(int resId) {
        mToast.setText(resId);
        mToast.show();
    }

    public static void show(String charSequence) {
        mToast.setText(charSequence);
        mToast.show();
    }
}
