package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.contract.MoHuChaContract;
import com.wd.doctor.model.MoHuChaModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:19:35
 *@Description:
 **/
public class MoHuChaPresenter extends BasePresenter<MoHuChaContract.Iview> implements MoHuChaContract.Ipresenter {

    private MoHuChaModel moHuChaModel;

    @Override
    protected void initModel() {
        moHuChaModel = new MoHuChaModel();
    }

    @Override
    public void onMoHuChaPresenter(String keyWord) {
        moHuChaModel.onMoHuChaModel(keyWord, new MoHuChaContract.Imodel.IMtroWork() {
            @Override
            public void onMoHuChaSuccess(SearchSickCircleBean searchSickCircleBean) {
                getView().onMoHuChaSuccess(searchSickCircleBean);
            }

            @Override
            public void onMoHuFliuse(String resultes) {
                getView().onMoHuFliuse(resultes);
            }
        });
    }
}
