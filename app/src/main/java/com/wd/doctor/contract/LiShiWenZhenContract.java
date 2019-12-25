package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.LiShiWenZhenBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface LiShiWenZhenContract {
    interface Iview extends BaseView {
        void onLiShiWenZhenSuccess(LiShiWenZhenBean liShiWenZhenBean);
        void onLiShiWenZhenFliuse(String e);
    }


    interface Imodel{
        void onLiShiWenZhenModel(String doctorId, String sessionId,String page,String count, IMtroWork iMtroWork);
        interface IMtroWork{
            void onLiShiWenZhenSuccess(LiShiWenZhenBean liShiWenZhenBean);
            void onLiShiWenZhenFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onLiShiWenZhenPresenter(String doctorId, String sessionId,String page,String count);
    }
}
