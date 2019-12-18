package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.SearchSickCircleBean;
import com.wd.doctor.bean.SickCircleInfoBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface MoHuChaContract {
    interface Iview extends BaseView {
        void onMoHuChaSuccess(SearchSickCircleBean searchSickCircleBean);
        void onMoHuFliuse(String e);
    }


    interface Imodel{
        void onMoHuChaModel(String keyWord, IMtroWork iMtroWork);
        interface IMtroWork{
            void onMoHuChaSuccess(SearchSickCircleBean searchSickCircleBean);
            void onMoHuFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onMoHuChaPresenter(String keyWord);
    }
}
