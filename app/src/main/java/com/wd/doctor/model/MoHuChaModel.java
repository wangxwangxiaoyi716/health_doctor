package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.contract.MoHuChaContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:19:33
 *@Description:
 **/
public class MoHuChaModel implements MoHuChaContract.Imodel {
    @Override
    public void onMoHuChaModel(String keyWord, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getmohushou(keyWord)
                .compose(CommonSchedulers.<SearchSickCircleBean> io2main())
                .subscribe(new Observer<SearchSickCircleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchSickCircleBean searchSickCircleBean) {
                        iMtroWork.onMoHuChaSuccess(searchSickCircleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onMoHuFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
