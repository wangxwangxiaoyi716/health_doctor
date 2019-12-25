package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.FaXinXiBean;
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

    @Override
    public void onFaXinXiModel(String doctorId, String sessionId, String inquiryId, String content, String type, String userId, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getfaxinxi(doctorId, sessionId, inquiryId, content, type, userId)
                .compose(CommonSchedulers.<FaXinXiBean> io2main())
                .subscribe(new Observer<FaXinXiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FaXinXiBean faXinXiBean) {
                        iMtroWork.onFaXinXiSuccess(faXinXiBean);
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

    @Override
    public void onChaXinXiModel(String doctorId, String sessionId, String inquiryId, String page, String count, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getchaxinxi(doctorId, sessionId, inquiryId, page, count)
                .compose(CommonSchedulers.<ChaXinXiBean> io2main())
                .subscribe(new Observer<ChaXinXiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChaXinXiBean chaXinXiBean) {
                        iMtroWork.onChaXinXiSuccess(chaXinXiBean);
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
