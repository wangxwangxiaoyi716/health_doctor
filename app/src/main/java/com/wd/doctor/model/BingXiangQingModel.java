package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.FaPingLunBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.contract.BingXiangQingContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:59
 *@Description:
 **/
public class BingXiangQingModel implements BingXiangQingContract.Imodel {
    @Override
    public void onBingXiangQingModel(String doctorId, String sessionId, String sickCircleId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getbingxiangqing(doctorId, sessionId, sickCircleId)
                .compose(CommonSchedulers.<SickCircleInfoBean> io2main())
                .subscribe(new Observer<SickCircleInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SickCircleInfoBean sickCircleInfoBean) {
                        iMtroWork.onBingXiangQing(sickCircleInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onXiangQing(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onFaPingLunModel(String doctorId, String sessionId, String sickCircleId, String content, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getfapinglun(doctorId, sessionId, sickCircleId, content)
                .compose(CommonSchedulers.<FaPingLunBean> io2main())
                .subscribe(new Observer<FaPingLunBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FaPingLunBean faPingLunBean) {
                        iMtroWork.onFaPingLunSuccess(faPingLunBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onXiangQing(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
