package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.SendEmailCodeBean;
import com.wd.doctor.bean.SickCircleInfoBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/13
 *@Time:16:54
 *@Description:
 **/
public interface EmailContract {
    interface Iview extends BaseView {
        void onEmailSuccess(SendEmailCodeBean sendEmailCodeBean);
        void onEmailFliuse(String e);
    }


    interface Imodel{
        void onEmailModel(String email,IMtroWork iMtroWork);
        interface IMtroWork{
            void onEmailSuccess(SendEmailCodeBean sendEmailCodeBean);
            void onEmailFliuse(String resultes);
        }
    }

    interface Ipresenter{
        void onEmailPresenter(String email);
    }
}
