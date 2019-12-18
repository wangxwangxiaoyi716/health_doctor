package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.FaPingLunBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.contract.BingXiangQingContract;
import com.wd.doctor.model.BingXiangQingModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:17:02
 *@Description:
 **/
public class BingXiangQingPresenter extends BasePresenter<BingXiangQingContract.Iview> implements BingXiangQingContract.Ipresenter {

    private BingXiangQingModel bingXiangQingModel;

    @Override
    protected void initModel() {
        bingXiangQingModel = new BingXiangQingModel();
    }

    @Override
    public void onBingXiangQingPresenter(String doctorId, String sessionId, String sickCircleId) {
        bingXiangQingModel.onBingXiangQingModel(doctorId, sessionId, sickCircleId, new BingXiangQingContract.Imodel.IMtroWork() {
            @Override
            public void onBingXiangQing(SickCircleInfoBean sickCircleInfoBean) {
                getView().onBingXiangQing(sickCircleInfoBean);
            }

            @Override
            public void onFaPingLunSuccess(FaPingLunBean faPingLunBean) {

            }

            @Override
            public void onXiangQing(String resultes) {
                getView().onXiangQing(resultes);
            }
        });
    }

    @Override
    public void onFaPingLunPresenter(String doctorId, String sessionId, String sickCircleId, String content) {
        bingXiangQingModel.onFaPingLunModel(doctorId, sessionId, sickCircleId, content, new BingXiangQingContract.Imodel.IMtroWork() {
            @Override
            public void onBingXiangQing(SickCircleInfoBean sickCircleInfoBean) {

            }

            @Override
            public void onFaPingLunSuccess(FaPingLunBean faPingLunBean) {
                getView().onFaPingLunSuccess(faPingLunBean);
            }

            @Override
            public void onXiangQing(String resultes) {
                getView().onXiangQing(resultes);
            }
        });
    }
}
