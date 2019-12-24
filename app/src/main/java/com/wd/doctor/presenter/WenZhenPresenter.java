package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;
import com.wd.doctor.contract.WenZhenContract;
import com.wd.doctor.model.WenZhenModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/16
 *@Time:15:53
 *@Description:
 **/
public class WenZhenPresenter extends BasePresenter<WenZhenContract.Iview> implements WenZhenContract.Ipresenter {

    private WenZhenModel wenZhenModel;

    @Override
    protected void initModel() {
        wenZhenModel = new WenZhenModel();
    }

    @Override
    public void onWenZhenPresenter(String doctorId, String sessionId) {
        wenZhenModel.onWenZhenModel(doctorId, sessionId, new WenZhenContract.Imodel.IMtroWork() {
            @Override
            public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {
                getView().onWenZhenSuccess(wenZhenLeiBiaoBean);
            }

            @Override
            public void onWenZhenFiuse(String resultes) {
                getView().onWenZhenFiuse(resultes);
            }
        });
    }
}
