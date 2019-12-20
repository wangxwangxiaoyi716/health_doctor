package com.wd.doctor.presenter;

import android.util.Log;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.ShangChuanBean;
import com.wd.doctor.contract.ShangChuanContract;
import com.wd.doctor.model.ShangChuanModel;

import okhttp3.MultipartBody;

/*
 *@auther:王晓义
 *@Date: 2019/12/20
 *@Time:10:04
 *@Description:
 **/
public class ShangChuanPresenter extends BasePresenter<ShangChuanContract.Iview> implements ShangChuanContract.Ipresenter {
    public static final String TAG = "ShangChuanPresenter";
    private ShangChuanModel shangChuanModel;

    @Override
    protected void initModel() {
        shangChuanModel = new ShangChuanModel();
    }

    @Override
    public void onShangChuanPresenter(String doctorId, String sessionId, MultipartBody.Part imagePic) {
        shangChuanModel.onShangChuanModel(doctorId, sessionId, imagePic, new ShangChuanContract.Imodel.IMtroWork() {
            @Override
            public void onShangChuanSuccess(ShangChuanBean shangChuanBean) {
                Log.d(TAG, "onShangChuanSuccess: "+shangChuanBean.getMessage());
                getView().onShangChuanSuccess(shangChuanBean);
            }

            @Override
            public void onShangChuanFliuse(String resultes) {
                getView().onShangChuanFliuse(resultes);
            }
        });
    }
}
