package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.HuanZheXiangQingBean;
import com.wd.doctor.contract.HuanZheXiangQingContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/26
 *@Time:16:19
 *@Description:
 **/
public class HuanZheXiangQingModel implements HuanZheXiangQingContract.Imodel {
    @Override
    public void onHuanZheXiangQingModel(String doctorId, String sessionId, String userId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .gethuanzhexiangqing(doctorId, sessionId, userId)
                .compose(CommonSchedulers.<HuanZheXiangQingBean> io2main())
                .subscribe(new Observer<HuanZheXiangQingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HuanZheXiangQingBean huanZheXiangQingBean) {
                        iMtroWork.onHuanZheXiangQingSuccess(huanZheXiangQingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onHuanZheXiangQingFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
