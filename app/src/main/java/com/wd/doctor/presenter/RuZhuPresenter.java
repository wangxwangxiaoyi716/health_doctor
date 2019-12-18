package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.contract.RuZhuContract;
import com.wd.doctor.model.RuZhuModel;

import java.util.Map;

/*
 *@auther:王晓义
 *@Date: 2019/12/17
 *@Time:16:21
 *@Description:
 **/
public class RuZhuPresenter extends BasePresenter<RuZhuContract.Iview> implements RuZhuContract.Ipresenter {

    private RuZhuModel ruZhuModel;

    @Override
    protected void initModel() {
        ruZhuModel = new RuZhuModel();
    }

    @Override
    public void onRuZhuPresenter(Map<String, Object> map) {
        ruZhuModel.onRuZhuModel(map, new RuZhuContract.Imodel.IMtroWork() {
            @Override
            public void onRuZhuSuccess(ApplyJoinBean applyJoinBean) {
                getView().onRuZhuSuccess(applyJoinBean);
            }

            @Override
            public void onRuZhuFiluse(String e) {
                getView().onRuZhuFiluse(e);
            }
        });
    }
}
