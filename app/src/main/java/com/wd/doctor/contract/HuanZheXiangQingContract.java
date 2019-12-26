package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.HuanZheXiangQingBean;
import com.wd.doctor.bean.YinHangCardBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/26
 *@Time:16:14
 *@Description:
 **/
public interface HuanZheXiangQingContract {
    interface Iview extends BaseView {
        void onHuanZheXiangQingSuccess(HuanZheXiangQingBean huanZheXiangQingBean);
        void onHuanZheXiangQingFliuse(String e);
    }


    interface Imodel{
        void onHuanZheXiangQingModel(String doctorId, String sessionId, String userId,IMtroWork iMtroWork);
        interface IMtroWork{
            void onHuanZheXiangQingSuccess(HuanZheXiangQingBean huanZheXiangQingBean);
            void onHuanZheXiangQingFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onHuanZheXiangQingPresenter(String doctorId, String sessionId, String userId);
    }
}
