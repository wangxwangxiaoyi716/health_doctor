package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.YinHangCardBean;
import com.wd.doctor.contract.BangYinHangCradContract;
import com.wd.doctor.model.BangYinHangCardModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/24
 *@Time:14:53
 *@Description:
 **/
public class BangYinHangCardPresenter extends BasePresenter<BangYinHangCradContract.Iview> implements BangYinHangCradContract.Ipresenter {

    private BangYinHangCardModel bangYinHangCardModel;

    @Override
    protected void initModel() {
        bangYinHangCardModel = new BangYinHangCardModel();
    }

    @Override
    public void onBangYinHangCradPresenter(String doctorId, String sessionId, String bankCardNumber, String bankName, String bankCardType) {
        bangYinHangCardModel.onBangYinHangCradModel(doctorId, sessionId, bankCardNumber, bankName, bankCardType, new BangYinHangCradContract.Imodel.IMtroWork() {
            @Override
            public void onBangYinHangCradSuccess(YinHangCardBean yinHangCardBean) {
                getView().onBangYinHangCradSuccess(yinHangCardBean);
            }

            @Override
            public void onBangYinHangCradFliuse(String resultes) {
                getView().onBangYinHangCradFliuse(resultes);
            }
        });
    }
}
