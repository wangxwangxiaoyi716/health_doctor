package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.contract.WenZhenContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/16
 *@Time:15:51
 *@Description:
 **/
public class WenZhenModel implements WenZhenContract.Imodel {
    @Override
    public void onWenZhenModel(String doctorId, String sessionId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getwenzhenlei(doctorId, sessionId)
                .compose(CommonSchedulers.<WenZhenLeiBiaoBean> io2main())
                .subscribe(new Observer<WenZhenLeiBiaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {
                        iMtroWork.onWenZhenSuccess(wenZhenLeiBiaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onWenZhenFiuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
