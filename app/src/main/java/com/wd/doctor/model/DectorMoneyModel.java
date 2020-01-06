package com.wd.doctor.model;

import android.util.Log;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.ShouZhiJiLuBean;
import com.wd.doctor.contract.DectorMoneyContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/21
 *@Time:10:48
 *@Description:
 **/
public class DectorMoneyModel implements DectorMoneyContract.Imodel {
    public static final String TAG ="DectorMoneyModel";
    @Override
    public void onDectorMoneyModel(String doctorId, String sessionId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getyishengmoney(doctorId, sessionId)
                .compose(CommonSchedulers.<DectorMomeyBean> io2main())
                .subscribe(new Observer<DectorMomeyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DectorMomeyBean dectorMomeyBean) {
                        Log.d(TAG, "onNext: "+dectorMomeyBean.getMessage());
                        iMtroWork.onDectorMoneySuccess(dectorMomeyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        iMtroWork.onDectorMoneyFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onShouZhiJiLuModel(String doctorId, String sessionId, String page, String count, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getshouzhijilu(doctorId, sessionId, page, count)
                .compose(CommonSchedulers.<ShouZhiJiLuBean> io2main())
                .subscribe(new Observer<ShouZhiJiLuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShouZhiJiLuBean shouZhiJiLuBean) {
                        Log.d(TAG, "onNext: "+shouZhiJiLuBean.getMessage());
                        iMtroWork.onShouZhiJiLuSuccess(shouZhiJiLuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onDectorMoneyFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
