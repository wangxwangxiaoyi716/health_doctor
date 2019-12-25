package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.ChaYinHangCardBean;
import com.wd.doctor.contract.ChaYinHangCardContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:11:11
 *@Description:
 **/
public class ChaYinHuangCardModel implements ChaYinHangCardContract.Imodel {
    @Override
    public void onChaYinHangCardModel(String doctorId, String sessionId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getchayinhuang(doctorId, sessionId)
                .compose(CommonSchedulers.<ChaYinHangCardBean> io2main())
                .subscribe(new Observer<ChaYinHangCardBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChaYinHangCardBean chaYinHangCardBean) {
                        iMtroWork.onChaYinHangCardSuccess(chaYinHangCardBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onChaYinHangCardFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
