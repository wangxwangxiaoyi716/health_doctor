package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.ChaYinHangCardBean;
import com.wd.doctor.contract.ChaYinHangCardContract;
import com.wd.doctor.model.ChaYinHuangCardModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:11:16
 *@Description:
 **/
public class ChaYinHuangCardPresenter extends BasePresenter<ChaYinHangCardContract.Iview> implements ChaYinHangCardContract.Ipresenter {

    private ChaYinHuangCardModel chaYinHuangCardModel;

    @Override
    protected void initModel() {
        chaYinHuangCardModel = new ChaYinHuangCardModel();
    }

    @Override
    public void onChaYinHangCardPresenter(String doctorId, String sessionId) {
        chaYinHuangCardModel.onChaYinHangCardModel(doctorId, sessionId, new ChaYinHangCardContract.Imodel.IMtroWork() {
            @Override
            public void onChaYinHangCardSuccess(ChaYinHangCardBean chaYinHangCardBean) {
                getView().onChaYinHangCardSuccess(chaYinHangCardBean);
            }

            @Override
            public void onChaYinHangCardFliuse(String resultes) {
                getView().onChaYinHangCardFliuse(resultes);
            }
        });
    }
}
