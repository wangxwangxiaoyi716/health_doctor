package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.ApplyJoinBean;
import com.wd.doctor.bean.SickCircleInfoBean;

import java.util.Map;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface RuZhuContract {
    interface Iview extends BaseView {
        void onRuZhuSuccess(ApplyJoinBean applyJoinBean);
        void onRuZhuFiluse(String e);
    }


    interface Imodel{
        void onRuZhuModel(Map<String,Object> map,IMtroWork iMtroWork);
        interface IMtroWork{
            void onRuZhuSuccess(ApplyJoinBean applyJoinBean);
            void onRuZhuFiluse(String e);
        }
    }

    interface Ipresenter{
        void onRuZhuPresenter(Map<String,Object> map);
    }
}
