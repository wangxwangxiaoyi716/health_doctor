package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.FindInquiryRecordListBean;
import com.wd.doctor.bean.SickCircleInfoBean;
import com.wd.doctor.bean.WenZhenLeiBiaoBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/16
 *@Time:15:48
 *@Description:
 **/
public interface WenZhenContract {
    interface Iview extends BaseView {
        void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean);
        void onWenZhenFiuse(String e);
    }


    interface Imodel{
        void onWenZhenModel(String doctorId,String sessionId,IMtroWork iMtroWork);
        interface IMtroWork{
            void onWenZhenSuccess(WenZhenLeiBiaoBean wenZhenLeiBiaoBean);
            void onWenZhenFiuse(String resultes);
        }
    }

    interface Ipresenter{
        void onWenZhenPresenter(String doctorId, String sessionId);
    }
}
