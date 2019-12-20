package com.wd.doctor.model;

import android.util.Log;

import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;
import com.wd.doctor.app.ApiService;
import com.wd.doctor.bean.ShangChuanBean;
import com.wd.doctor.contract.ShangChuanContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

/*
 *@auther:王晓义
 *@Date: 2019/12/20
 *@Time:10:02
 *@Description:
 **/
public class ShangChuanModel implements ShangChuanContract.Imodel {
    public static final String TAG = "ShangChuanModel";

    @Override
    public void onShangChuanModel(String doctorId, String sessionId, MultipartBody.Part imagePic, IMtroWork iMtroWork) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getshangchuan(doctorId, sessionId, imagePic)
                .compose(CommonSchedulers.<ShangChuanBean> io2main())
                .subscribe(new Observer<ShangChuanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShangChuanBean shangChuanBean) {
                        Log.d(TAG, "onNext: "+shangChuanBean.getMessage());
                        iMtroWork.onShangChuanSuccess(shangChuanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMtroWork.onShangChuanFliuse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
