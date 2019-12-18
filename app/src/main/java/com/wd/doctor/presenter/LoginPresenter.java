package com.wd.doctor.presenter;

import com.bw.movie.base.BasePresenter;
import com.wd.doctor.bean.LoginBean;
import com.wd.doctor.contract.LoginContract;
import com.wd.doctor.model.LoginModel;

/*
 *@auther:王晓义
 *@Date: 2019/12/11
 *@Time:20:02
 *@Description:
 **/
public class LoginPresenter extends BasePresenter<LoginContract.Iview> implements LoginContract.Ipresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void onDengPresenter(String email, String pwd) {
        loginModel.onDengModel(email,pwd, new LoginContract.Imodel.IMtroWork() {
            @Override
            public void onDengSuccess(LoginBean loginBean) {
                getView().onDengSuccess(loginBean);
            }

            @Override
            public void onLoginFiluse(String resultes) {
                getView().onLoginFiluse(resultes);
            }
        });
    }
}
