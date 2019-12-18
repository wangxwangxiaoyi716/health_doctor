package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.contract.EmailContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/15
 *@Time:18:48
 *@Description:
 **/
public class EmailModel implements EmailContract.Imodel {
    @Override
    public void onEmailModel(String email,IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getemail(email)
                .compose(CommonSchedulers.<SendEmailCodeBean> io2main())
                .subscribe(new Observer<SendEmailCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SendEmailCodeBean sendEmailCodeBean) {
                        iMtroWork.onEmailSuccess(sendEmailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onEmailFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
