package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.XiTongZhaoBean;
import com.wd.doctor.contract.HuanImgContract;
import com.wd.doctor.model.HuanImageModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/18
 *@Time:18:46
 *@Description:
 **/
public class HuanImagePresenter extends BasePresenter<HuanImgContract.Iview> implements HuanImgContract.Ipresenter {

    private HuanImageModel huanImageModel;

    @Override
    protected void initModel() {
        huanImageModel = new HuanImageModel();
    }

    @Override
    public void onHuanImagePresenter() {
        huanImageModel.onHuanImageModel(new HuanImgContract.Imodel.IMtroWork() {
            @Override
            public void onHuanImageSuccess(XiTongZhaoBean xiTongZhaoBean) {
                getView().onHuanImageSuccess(xiTongZhaoBean);
            }

            @Override
            public void onHuanImageFliuse(String resultes) {
                getView().onHuanImageFliuse(resultes);
            }
        });
    }
}
