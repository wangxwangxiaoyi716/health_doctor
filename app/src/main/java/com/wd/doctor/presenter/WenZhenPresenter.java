package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.ChaXinXiBean;
import com.wd.doctor.bean.FaXinXiBean;
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
            public void onFaXinXiSuccess(FaXinXiBean faXinXiBean) {

            }

            @Override
            public void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean) {

            }

            @Override
            public void onWenZhenFiuse(String resultes) {
                getView().onWenZhenFiuse(resultes);
            }
        });
    }

    @Override
    public void onFaXinXiModel(String doctorId, String sessionId, String inquiryId, String content, String type, String userId) {
        wenZhenModel.onFaXinXiModel(doctorId, sessionId, inquiryId, content, type, userId, new WenZhenContract.Imodel.IMtroWork() {
            @Override
            public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {

            }

            @Override
            public void onFaXinXiSuccess(FaXinXiBean faXinXiBean) {
                getView().onFaXinXiSuccess(faXinXiBean);
            }

            @Override
            public void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean) {

            }

            @Override
            public void onWenZhenFiuse(String resultes) {
                getView().onWenZhenFiuse(resultes);
            }
        });
    }

    @Override
    public void onChaXinXiModel(String doctorId, String sessionId, String inquiryId, String page, String count) {
        wenZhenModel.onChaXinXiModel(doctorId, sessionId, inquiryId, page, count, new WenZhenContract.Imodel.IMtroWork() {
            @Override
            public void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean) {

            }

            @Override
            public void onFaXinXiSuccess(FaXinXiBean faXinXiBean) {

            }

            @Override
            public void onChaXinXiSuccess(ChaXinXiBean chaXinXiBean) {
                getView().onChaXinXiSuccess(chaXinXiBean);
            }

            @Override
            public void onWenZhenFiuse(String resultes) {
                getView().onWenZhenFiuse(resultes);
            }
        });
    }


}
