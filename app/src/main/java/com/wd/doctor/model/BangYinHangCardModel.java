package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.YinHangCardBean;
import com.wd.doctor.contract.BangYinHangCradContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:14:52
 *@Description:
 **/
public class BangYinHangCardModel implements BangYinHangCradContract.Imodel {
    @Override
    public void onBangYinHangCradModel(String doctorId, String sessionId, String bankCardNumber, String bankName, String bankCardType, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getbangyinhangka(doctorId, sessionId, bankCardNumber, bankName, bankCardType)
                .compose(CommonSchedulers.<YinHangCardBean> io2main())
                .subscribe(new Observer<YinHangCardBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YinHangCardBean yinHangCardBean) {
                        iMtroWork.onBangYinHangCradSuccess(yinHangCardBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onBangYinHangCradFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
