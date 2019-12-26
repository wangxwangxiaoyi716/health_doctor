package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.HuanZheXiangQingBean;
import com.wd.doctor.contract.HuanZheXiangQingContract;
import com.wd.doctor.model.HuanZheXiangQingModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/26
 *@Time:16:21
 *@Description:
 **/
public class HuanZheXiangQingPresenter extends BasePresenter<HuanZheXiangQingContract.Iview> implements HuanZheXiangQingContract.Ipresenter {

    private HuanZheXiangQingModel huanZheXiangQingModel;

    @Override
    protected void initModel() {
        huanZheXiangQingModel = new HuanZheXiangQingModel();
    }

    @Override
    public void onHuanZheXiangQingPresenter(String doctorId, String sessionId, String userId) {
        huanZheXiangQingModel.onHuanZheXiangQingModel(doctorId, sessionId, userId, new HuanZheXiangQingContract.Imodel.IMtroWork() {
            @Override
            public void onHuanZheXiangQingSuccess(HuanZheXiangQingBean huanZheXiangQingBean) {
                getView().onHuanZheXiangQingSuccess(huanZheXiangQingBean);
            }

            @Override
            public void onHuanZheXiangQingFliuse(String resultes) {
                getView().onHuanZheXiangQingFliuse(resultes);
            }
        });
    }
}
