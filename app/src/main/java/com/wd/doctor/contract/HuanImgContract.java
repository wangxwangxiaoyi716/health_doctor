package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.XiTongZhaoBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/18
 *@Time:18:39
 *@Description:
 **/
public interface HuanImgContract {
    interface Iview extends BaseView {
        void onHuanImageSuccess(XiTongZhaoBean xiTongZhaoBean);
        void onHuanImageFliuse(String e);
    }


    interface Imodel{
        void onHuanImageModel(IMtroWork iMtroWork);
        interface IMtroWork{
            void onHuanImageSuccess(XiTongZhaoBean xiTongZhaoBean);
            void onHuanImageFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onHuanImagePresenter();
    }
}
