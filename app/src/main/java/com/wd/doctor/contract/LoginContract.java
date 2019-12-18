package com.wd.doctor.contract;

import com.bw.movie.base.BaseView;
import com.wd.doctor.bean.LoginBean;

/*
 *@auther:王晓义
 *@Date: 2019/12/11
 *@Time:19:41
 *@Description:
 **/
public interface LoginContract {
    interface Iview extends BaseView{
        void onDengSuccess(LoginBean loginBean);
        void onLoginFiluse(String e);
    }

    interface Imodel{
        void onDengModel(String email,String pwd,IMtroWork iMtroWork);
        interface IMtroWork{
            void onDengSuccess(LoginBean loginBean);
            void onLoginFiluse(String resultes);
        }
    }

    interface Ipresenter{
        void onDengPresenter(String email,String pwd);
    }
}
