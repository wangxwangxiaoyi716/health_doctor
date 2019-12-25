package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.ChaYinHangCardBean;
import com.wd.doctor.bean.DectorMomeyBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface ChaYinHangCardContract {
    interface Iview extends BaseView {
        void onChaYinHangCardSuccess(ChaYinHangCardBean chaYinHangCardBean);
        void onChaYinHangCardFliuse(String e);
    }


    interface Imodel{
        void onChaYinHangCardModel(String doctorId, String sessionId, IMtroWork iMtroWork);
        interface IMtroWork{
            void onChaYinHangCardSuccess(ChaYinHangCardBean chaYinHangCardBean);
            void onChaYinHangCardFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onChaYinHangCardPresenter(String doctorId, String sessionId);
    }
}
