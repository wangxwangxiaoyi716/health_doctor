package com.bw.movie.utils;
/**
 *@describe(描述)：CommonObserver
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:05
 *@author（作者）: wangxiaoyi
 **/

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class CommonObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
