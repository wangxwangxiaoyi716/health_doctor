package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.LiShiWenZhenBean;
import com.wd.doctor.contract.LiShiWenZhenContract;
import com.wd.doctor.model.LiShiWenZhenModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:19:39
 *@Description:
 **/
public class LiShiWenZhenPresenter extends BasePresenter<LiShiWenZhenContract.Iview> implements LiShiWenZhenContract.Ipresenter {

    private LiShiWenZhenModel liShiWenZhenModel;

    @Override
    protected void initModel() {
        liShiWenZhenModel = new LiShiWenZhenModel();
    }

    @Override
    public void onLiShiWenZhenPresenter(String doctorId, String sessionId, String page, String count) {
        liShiWenZhenModel.onLiShiWenZhenModel(doctorId, sessionId, page, count, new LiShiWenZhenContract.Imodel.IMtroWork() {
            @Override
            public void onLiShiWenZhenSuccess(LiShiWenZhenBean liShiWenZhenBean) {
                getView().onLiShiWenZhenSuccess(liShiWenZhenBean);
            }

            @Override
            public void onLiShiWenZhenFliuse(String resultes) {
                getView().onLiShiWenZhenFliuse(resultes);
            }
        });
    }
}
