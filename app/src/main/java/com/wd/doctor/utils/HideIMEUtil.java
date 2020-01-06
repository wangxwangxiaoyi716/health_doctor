package com.wd.doctor.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.wd.doctor.view.AutoHideIMEFrameLayout;

import androidx.fragment.app.Fragment;


/**
 *@describe(描述)：HideIMEUtil
 *@data（日期）: 2019/12/26
 *@time（时间）: 19:28
 *@author（作者）: 王晓义
 **/
public class HideIMEUtil {
    public static void wrap(Activity activity) {
        ViewGroup contentParent = (ViewGroup) activity.findViewById(android.R.id.content);        wrap(contentParent);
    }
    public static void wrap(Fragment fragment) {
        ViewGroup contentParent = (ViewGroup) fragment.getView().getParent();
        wrap(contentParent);
    }
    public static void wrap(ViewGroup contentParent) {
        View content = contentParent.getChildAt(0);
        contentParent.removeView(content);
        ViewGroup.LayoutParams p = content.getLayoutParams();
        AutoHideIMEFrameLayout layout = new AutoHideIMEFrameLayout(content.getContext());        layout.addView(content);
        contentParent.addView(layout, new ViewGroup.LayoutParams(p.width, p.height));
    }


}
