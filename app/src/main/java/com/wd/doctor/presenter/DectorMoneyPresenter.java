package com.wd.doctor.presenter;

import android.util.Log;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.ShouZhiJiLuBean;
import com.wd.doctor.contract.DectorMoneyContract;
import com.wd.doctor.model.DectorMoneyModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/21
 *@Time:10:50
 *@Description:
 **/
public class DectorMoneyPresenter extends BasePresenter<DectorMoneyContract.Iview> implements DectorMoneyContract.Ipresenter {
    public static final String TAG ="DectorMoneyPresenter";
    private DectorMoneyModel dectorMoneyModel;

    @Override
    protected void initModel() {
        dectorMoneyModel = new DectorMoneyModel();
    }

    @Override
    public void onDectorMoneyPresenter(String doctorId, String sessionId) {
        dectorMoneyModel.onDectorMoneyModel(doctorId, sessionId, new DectorMoneyContract.Imodel.IMtroWork() {
            @Override
            public void onDectorMoneySuccess(DectorMomeyBean dectorMomeyBean) {
                Log.d(TAG, "onDectorMoneySuccess: "+dectorMomeyBean.getMessage());
                getView().onDectorMoneySuccess(dectorMomeyBean);
            }

            @Override
            public void onShouZhiJiLuSuccess(ShouZhiJiLuBean shouZhiJiLuBean) {

            }

            @Override
            public void onDectorMoneyFliuse(String resultes) {
                Log.d(TAG, "onDectorMoneyFliuse: "+resultes);
                getView().onDectorMoneyFliuse(resultes);
            }
        });
    }

    @Override
    public void onShouZhiJiLuPresenter(String doctorId, String sessionId, String page, String count) {
        dectorMoneyModel.onShouZhiJiLuModel(doctorId, sessionId, page, count, new DectorMoneyContract.Imodel.IMtroWork() {
            @Override
            public void onDectorMoneySuccess(DectorMomeyBean dectorMomeyBean) {

            }

            @Override
            public void onShouZhiJiLuSuccess(ShouZhiJiLuBean shouZhiJiLuBean) {
                Log.d(TAG, "onShouZhiJiLuSuccess: "+shouZhiJiLuBean.getMessage());
                getView().onShouZhiJiLuSuccess(shouZhiJiLuBean);
            }

            @Override
            public void onDectorMoneyFliuse(String resultes) {
                getView().onDectorMoneyFliuse(resultes);
            }
        });
    }


}
