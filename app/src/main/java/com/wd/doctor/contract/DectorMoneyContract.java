package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.SendEmailCodeBean;

import retrofit2.http.Header;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface DectorMoneyContract {
    interface Iview extends BaseView {
        void onDectorMoneySuccess(DectorMomeyBean dectorMomeyBean);
        void onDectorMoneyFliuse(String e);
    }


    interface Imodel{
        void onDectorMoneyModel(String doctorId,String sessionId, IMtroWork iMtroWork);
        interface IMtroWork{
            void onDectorMoneySuccess(DectorMomeyBean dectorMomeyBean);
            void onDectorMoneyFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onDectorMoneyPresenter(String doctorId,String sessionId);
    }
}
