package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.XiTongZhaoBean;
import com.wd.doctor.contract.HuanImgContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/18
 *@Time:18:42
 *@Description:
 **/
public class HuanImageModel implements HuanImgContract.Imodel {

    @Override
    public void onHuanImageModel(IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getxtzp()
                .compose(CommonSchedulers.<XiTongZhaoBean> io2main())
                .subscribe(new Observer<XiTongZhaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiTongZhaoBean xiTongZhaoBean) {
                        iMtroWork.onHuanImageSuccess(xiTongZhaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onHuanImageFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
