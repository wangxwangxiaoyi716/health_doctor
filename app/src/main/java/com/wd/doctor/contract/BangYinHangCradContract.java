package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.ChaYinHangCardBean;
import com.wd.doctor.bean.YinHangCardBean;

import retrofit2.http.Query;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface BangYinHangCradContract {
    interface Iview extends BaseView {
        void onBangYinHangCradSuccess(YinHangCardBean yinHangCardBean);
        void onBangYinHangCradFliuse(String e);
    }


    interface Imodel{
        void onBangYinHangCradModel(String doctorId, String sessionId, String bankCardNumber,String bankName,String bankCardType, IMtroWork iMtroWork);
        interface IMtroWork{
            void onBangYinHangCradSuccess(YinHangCardBean yinHangCardBean);
            void onBangYinHangCradFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onBangYinHangCradPresenter(String doctorId, String sessionId, String bankCardNumber,String bankName,String bankCardType);
    }
}
