package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.LiShiWenZhenBean;
import com.wd.doctor.contract.LiShiWenZhenContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:19:38
 *@Description:
 **/
public class LiShiWenZhenModel implements LiShiWenZhenContract.Imodel {
    @Override
    public void onLiShiWenZhenModel(String doctorId, String sessionId, String page, String count, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getlishijilu(doctorId, sessionId, page, count)
                .compose(CommonSchedulers.<LiShiWenZhenBean> io2main())
                .subscribe(new Observer<LiShiWenZhenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LiShiWenZhenBean liShiWenZhenBean) {
                        iMtroWork.onLiShiWenZhenSuccess(liShiWenZhenBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onLiShiWenZhenFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
