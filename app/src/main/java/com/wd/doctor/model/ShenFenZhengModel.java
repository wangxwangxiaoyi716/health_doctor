package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.ShenFenZhengBean;
import com.wd.doctor.contract.ShenFenZhengContract;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/23
 *@Time:14:59
 *@Description:
 **/
public class ShenFenZhengModel implements ShenFenZhengContract.Imodel {
    @Override
    public void onShenFenZhengModel(String doctorId, String sessionId, Map<String, Object> BodyMap, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getshenfenzheng(doctorId, sessionId, BodyMap)
                .compose(CommonSchedulers.<ShenFenZhengBean> io2main())
                .subscribe(new Observer<ShenFenZhengBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShenFenZhengBean shenFenZhengBean) {
                        iMtroWork.onShenFenZhengSuccess(shenFenZhengBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onShenFenZhengFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
