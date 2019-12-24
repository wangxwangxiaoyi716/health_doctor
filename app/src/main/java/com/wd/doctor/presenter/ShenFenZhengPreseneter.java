package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.ShenFenZhengBean;
import com.wd.doctor.contract.ShenFenZhengContract;
import com.wd.doctor.model.ShenFenZhengModel;

import java.util.Map;

/*
 *@auther:王晓义
 *@Date: 2019/12/23
 *@Time:15:01
 *@Description:
 **/
public class ShenFenZhengPreseneter extends BasePresenter<ShenFenZhengContract.Iview> implements ShenFenZhengContract.Ipresenter {

    private ShenFenZhengModel shenFenZhengModel;

    @Override
    protected void initModel() {
        shenFenZhengModel = new ShenFenZhengModel();
    }

    @Override
    public void onShenFenZhengPresenter(String doctorId, String sessionId, Map<String, Object> BodyMap) {
        shenFenZhengModel.onShenFenZhengModel(doctorId, sessionId, BodyMap, new ShenFenZhengContract.Imodel.IMtroWork() {
            @Override
            public void onShenFenZhengSuccess(ShenFenZhengBean shenFenZhengBean) {
                getView().onShenFenZhengSuccess(shenFenZhengBean);
            }

            @Override
            public void onShenFenZhengFliuse(String resultes) {
                getView().onShenFenZhengFliuse(resultes);
            }
        });
    }
}
