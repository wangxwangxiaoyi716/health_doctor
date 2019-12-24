package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.DectorMomeyBean;
import com.wd.doctor.bean.ShenFenZhengBean;

import java.util.Map;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface ShenFenZhengContract {
    interface Iview extends BaseView {
        void onShenFenZhengSuccess(ShenFenZhengBean shenFenZhengBean);
        void onShenFenZhengFliuse(String e);
    }


    interface Imodel{
        void onShenFenZhengModel(String doctorId, String sessionId, Map<String,Object> BodyMap, IMtroWork iMtroWork);
        interface IMtroWork{
            void onShenFenZhengSuccess(ShenFenZhengBean shenFenZhengBean);
            void onShenFenZhengFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onShenFenZhengPresenter(String doctorId, String sessionId, Map<String,Object> BodyMap);
    }
}
