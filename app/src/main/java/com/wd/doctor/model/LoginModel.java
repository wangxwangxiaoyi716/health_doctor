package com.wd.doctor.model;

import android.util.Log;

import com.bw.movie.utils.CommonObserver;
import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.contract.LoginContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/11
 *@Time:20:00
 *@Description:
 **/
public class LoginModel implements LoginContract.Imodel {
    public static final String TAG = "LoginModel";
    @Override
    public void onDengModel(String email, String pwd, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getdeng(email,pwd)
                .compose(CommonSchedulers.<LoginBean> io2main())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        Log.d(TAG, "onNext: "+loginBean.getMessage());
                        iMtroWork.onDengSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        iMtroWork.onLoginFiluse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
