package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.SickCircleInfoBean;

import retrofit2.http.Header;
import retrofit2.http.Query;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface BingXiangQingContract {
    interface Iview extends BaseView {
        void onBingXiangQing(SickCircleInfoBean sickCircleInfoBean);
        void onXiangQing(String e);
    }


    interface Imodel{
        void onBingXiangQingModel(String doctorId,String sessionId,String sickCircleId, IMtroWork iMtroWork);
        interface IMtroWork{
            void onBingXiangQing(SickCircleInfoBean sickCircleInfoBean);
            void onXiangQing(String resultes);
        }
    }

    interface Ipresenter{
        void onBingXiangQingPresenter(String doctorId,String sessionId,String sickCircleId);
    }
}
