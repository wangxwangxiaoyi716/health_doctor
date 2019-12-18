package com.wd.doctor.model;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.contract.RuZhuContract;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 *@auther:王晓义
 *@Date: 2019/12/17
 *@Time:16:19
 *@Description:
 **/
public class RuZhuModel implements RuZhuContract.Imodel {
    @Override
    public void onRuZhuModel(Map<String, Object> map, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getruzhu(map)
                .compose(CommonSchedulers.<ApplyJoinBean> io2main())
                .subscribe(new Observer<ApplyJoinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApplyJoinBean applyJoinBean) {
                        iMtroWork.onRuZhuSuccess(applyJoinBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onRuZhuFiluse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
