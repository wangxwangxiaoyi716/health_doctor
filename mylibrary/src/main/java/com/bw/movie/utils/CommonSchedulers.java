package com.bw.movie.utils;
/**
 *@describe(描述)：CommonSchedulers
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:05
 *@author（作者）: wangxiaoyi
 **/

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CommonSchedulers {
            public static  <T> ObservableTransformer<T,T> io2main(){
                return new ObservableTransformer<T, T>() {
                    @Override
                    public ObservableSource<T> apply(Observable<T> upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                };
            }
}
